package com.factoresinteres.compuesto;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import androidx.appcompat.widget.Toolbar;

import ru.noties.jlatexmath.JLatexMathView;


public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    /*
    * Si nos referimos a un periodo tendremos la siguiente fórmula:
    P: préstamo o valor presente al principio del  periodo.
    F: pago o valor futuro al final del periodo.
    F - P: intereses del periodo.
    i: tasa efectiva de interés por periodo (vencido)
    */
    private Button btnCalculate, btnClear;
    JLatexMathView mathView;
    private EditText editA, editP, editF, editI, editN;

    @SuppressLint("SetJavaScriptEnabled")
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
        mathView = findViewById(R.id.formula_one);
        btnCalculate = findViewById(R.id.btnCalculate);
        
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        
        btnCalculate.setOnClickListener(this);
        btnClear.setOnClickListener(this);

        // La condicion es que no permite ingresar ciertos prametros entre A, F, P es decir solo uno puede ingresar y dos son calculados
        // evendo cuando cambia el texto
        editA.addTextChangedListener(new TextWatcher() {
            public void afterTextChanged(Editable s) {
                if (!s.toString().trim().equals("")) {
                    editF.setEnabled(false); // inabilitar F
                    editF.setTextAppearance(MainActivity.this, R.style.MyEditTextStyleEnabled);
                    editF.getText().clear();
                    editP.getText().clear();
                    editP.setEnabled(false); // Inabilitar P
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
        int id = view.getId();
        if (id == R.id.btnCalculate) {
            validators();
        } else if (id == R.id.btnClear) {
            editF.getText().clear();
            editP.getText().clear();
            editA.getText().clear();
            editN.getText().clear();
            editI.getText().clear();
        }
    }

    private void validators() {
        if (editI.getText().toString().trim().isEmpty()) {
            Toast.makeText(MainActivity.this, "(i) Interes es requerido!", Toast.LENGTH_LONG).show();
            return;
        }
        if (editN.getText().toString().trim().isEmpty()) {
            Toast.makeText(MainActivity.this, "N de (Tiempo o Periodo) es requerido!", Toast.LENGTH_LONG).show();
            return;
        }
        if (editA.getText().toString().trim().isEmpty() && editF.getText().toString().trim().isEmpty() && editP.getText().toString().trim().equals("")) {
            Toast.makeText(MainActivity.this, "Ingrese alguno de los parametros entre A, F o P", Toast.LENGTH_LONG).show();
            return;
        }
        if (!editA.getText().toString().trim().isEmpty()) {
            CalcularConA();
            return;
        }
        if (!editP.getText().toString().trim().isEmpty()) {
            CalcularConP();
            return;
        }
        if (!editF.getText().toString().trim().isEmpty()) {
            CalcularConF();
            return;
        }
    }

    private void CalcularConA() {
        // FVPSU Para calcular P
        String P = FormulariesDisplay.FVPSU(editI.getText().toString(), editN.getText().toString(), editA.getText().toString());
        // FCCSU Para calcular F
        String F = FormulariesDisplay.FCCSU(editI.getText().toString(), editN.getText().toString(), editA.getText().toString());

        // Espaciado entre la visualizacion de ambas formulas
        mostrarFormula(P + " \\\\ \\vspace{0.5cm} \\\\ " + F);
    }

    private void CalcularConF() {
        // FVPPU Para calcular P
        String P = FormulariesDisplay.FVPPU(editI.getText().toString(), editN.getText().toString(), editF.getText().toString());
        // FFA Para calcular A
        String A = FormulariesDisplay.FFA(editI.getText().toString(), editN.getText().toString(), editF.getText().toString());

        // Espaciado entre la visualizacion de ambas formulas
        mostrarFormula(P + " \\\\ \\vspace{0.5cm} \\\\ " + A);
    }

    private void CalcularConP() {
        // FCCPU Para calcular F
        String F = FormulariesDisplay.FCCPU(editI.getText().toString(), editN.getText().toString(), editP.getText().toString());
        // FRC Para calcular A
        String A = FormulariesDisplay.FRC(editI.getText().toString(), editN.getText().toString(), editP.getText().toString());

        // Espaciado entre la visualizacion de ambas formulas
        mostrarFormula(F + " \\\\ \\vspace{0.5cm} \\\\ " + A);
    }
    private void mostrarFormula(String latex) {
        mathView.setLatex(latex);
    }



    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        int id = item.getItemId();
        if (id == R.id.action_info) {
            new dialogFormulario(MainActivity.this);
        }
        return super.onOptionsItemSelected(item);
    }
}