package usfx.tarea.ind210;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import io.github.kexanie.library.MathView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    /*
    * Si nos referimos a un periodo tendremos la siguiente fórmula:
    P: préstamo o valor presente al principio del  periodo.
    F: pago o valor futuro al final del periodo.
    F - P: intereses del periodo.
    i: tasa efectiva de interés por periodo (vencido)
    */
    private Button btnCalculate, btnClear;
    MathView formula_one;
    private EditText editA, editP, editF, editI, editN;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        editA = findViewById(R.id.editA);
        editF = findViewById(R.id.editF);
        editP = findViewById(R.id.editP);
        editN = findViewById(R.id.editN);
        editI = findViewById(R.id.editI);
        btnClear = findViewById(R.id.btnClear);
        formula_one = findViewById(R.id.formula_one);
        btnCalculate = findViewById(R.id.btnCalculate);
        btnCalculate.setOnClickListener(this);
        btnClear.setOnClickListener(this);
        /*formula_one1.config(
                "MathJax.Hub.Config({\n"+
                        "  CommonHTML: { linebreaks: { automatic: true } },\n"+
                        "  \"HTML-CSS\": { linebreaks: { automatic: true } },\n"+
                        "         SVG: { linebreaks: { automatic: true } }\n"+
                        "});");*/
        editA.addTextChangedListener(new TextWatcher() {
            public void afterTextChanged(Editable s) {
                if (!s.toString().trim().equals("")) {
                    editF.setEnabled(false);
                    editF.setTextAppearance(MainActivity.this, R.style.MyEditTextStyleEnabled);
                    editF.getText().clear();
                    editP.getText().clear();
                    editP.setEnabled(false);
                    editP.setTextAppearance(MainActivity.this, R.style.MyEditTextStyleEnabled);
                } else {
                    editF.setEnabled(true);
                    editF.setTextAppearance(MainActivity.this, R.style.MyEditTextStyle);
                    editP.setEnabled(true);
                    editP.setTextAppearance(MainActivity.this, R.style.MyEditTextStyle);
                }
            }

            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
            }

            public void onTextChanged(CharSequence s, int start, int before, int count) {
            }
        });
        editF.addTextChangedListener(new TextWatcher() {
            public void afterTextChanged(Editable s) {
                if (!s.toString().trim().equals("")) {
                    editA.setEnabled(false);
                    editA.setTextAppearance(MainActivity.this, R.style.MyEditTextStyleEnabled);
                    editA.getText().clear();
                    editP.getText().clear();
                    editP.setEnabled(false);
                    editP.setTextAppearance(MainActivity.this, R.style.MyEditTextStyleEnabled);
                } else {
                    editA.setEnabled(true);
                    editA.setTextAppearance(MainActivity.this, R.style.MyEditTextStyle);
                    editP.setEnabled(true);
                    editP.setTextAppearance(MainActivity.this, R.style.MyEditTextStyle);
                }
            }

            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
            }

            public void onTextChanged(CharSequence s, int start, int before, int count) {
            }
        });
        editP.addTextChangedListener(new TextWatcher() {
            public void afterTextChanged(Editable s) {
                if (!s.toString().trim().equals("")) {
                    editA.setEnabled(false);
                    editA.setTextAppearance(MainActivity.this, R.style.MyEditTextStyleEnabled);
                    editA.getText().clear();
                    editF.getText().clear();
                    editF.setEnabled(false);
                    editF.setTextAppearance(MainActivity.this, R.style.MyEditTextStyleEnabled);
                } else {
                    editA.setEnabled(true);
                    editA.setTextAppearance(MainActivity.this, R.style.MyEditTextStyle);
                    editF.setEnabled(true);
                    editF.setTextAppearance(MainActivity.this, R.style.MyEditTextStyle);
                }
            }

            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
            }

            public void onTextChanged(CharSequence s, int start, int before, int count) {
            }
        });
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.btnCalculate: {
                validarDatos();
                break;
            }
            case R.id.btnClear: {
                editF.getText().clear();
                editP.getText().clear();
                editA.getText().clear();
                editN.getText().clear();
                editI.getText().clear();
                break;
            }
        }
    }

    private void validarDatos() {
        if (editI.getText().toString().trim().equals("")) {
            Toast.makeText(MainActivity.this, "Interes es requerido", Toast.LENGTH_LONG).show();
            return;
        }
        if (editN.getText().toString().trim().equals("")) {
            Toast.makeText(MainActivity.this, "N de (Tiempo o Periodo) es requerido", Toast.LENGTH_LONG).show();
            return;
        }
        if (editA.getText().toString().trim().equals("") && editF.getText().toString().trim().equals("") && editP.getText().toString().trim().equals("")) {
            Toast.makeText(MainActivity.this, "Ingrese alguno de los parametros entre A, F o P", Toast.LENGTH_LONG).show();
            return;
        }
        if (!editA.getText().toString().trim().equals("")) {
            CalcularConA();
            return;
        }
        if (!editP.getText().toString().trim().equals("")) {
            CalcularConP();
            return;
        }
        if (!editF.getText().toString().trim().equals("")) {
            CalcularConF();
            return;
        }
    }

    private void CalcularConA() {
        //FVPSU Para calcular P
        String P = Formulario.FVPSU(editI.getText().toString(), editN.getText().toString(), editA.getText().toString());
        //FCCSU Para calcular F
        String F = Formulario.FCCSU(editI.getText().toString(), editN.getText().toString(), editA.getText().toString());
        formula_one.setText(P + F);
    }

    //Subir su realizacion de la tarea
    private void CalcularConF() {
        //FVPPU Para calcular P
        String P = Formulario.FVPPU(editI.getText().toString(), editN.getText().toString(), editF.getText().toString());
        //FFA Para calcular A
        String A = Formulario.FFA(editI.getText().toString(), editN.getText().toString(), editF.getText().toString());
        formula_one.setText(P + A);
    }

    private void CalcularConP() {
        //FCCPU Para calcular F
        String F = Formulario.FCCPU(editI.getText().toString(), editN.getText().toString(), editP.getText().toString());
        //FFA Para calcular A
        String A = Formulario.FRC(editI.getText().toString(), editN.getText().toString(), editP.getText().toString());
        formula_one.setText(F + A);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()){
            case R.id.action_info :
                new dialogFormulario(MainActivity.this);
                break;
        }
        return super.onOptionsItemSelected(item);
    }
}