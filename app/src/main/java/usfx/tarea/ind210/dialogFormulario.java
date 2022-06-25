package usfx.tarea.ind210;

import android.app.AlertDialog;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

public class dialogFormulario extends AlertDialog {
    private static ViewGroup viewGroup;

    public dialogFormulario(Context context) {
        super(context);
        View dialogView = LayoutInflater.from(context).inflate(R.layout.formulario, viewGroup, false);
        final Button btnClose = dialogView.findViewById(R.id.btnClose);

        AlertDialog.Builder builder = new AlertDialog.Builder(context);
        builder.setView(dialogView);
        AlertDialog alertDialog = builder.create();


        btnClose.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                alertDialog.cancel();
            }
        });
        alertDialog.show();
    }
}
