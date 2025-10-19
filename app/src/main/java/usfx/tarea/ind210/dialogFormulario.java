package usfx.tarea.ind210;

import android.app.AlertDialog;
import android.content.ClipData;
import android.content.ClipboardManager;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

public class dialogFormulario extends AlertDialog {

    private static ViewGroup viewGroup;

    public dialogFormulario(Context context) {
        super(context);
        View dialogView = LayoutInflater.from(context).inflate(R.layout.formulario, viewGroup, false);
        final Button btnClose = dialogView.findViewById(R.id.btnClose);
        final LinearLayout githubContainer = dialogView.findViewById(R.id.githubContainer);
        final TextView txtRepositorio = dialogView.findViewById(R.id.txtRepositorio);

        AlertDialog.Builder builder = new AlertDialog.Builder(context);
        builder.setView(dialogView);
        AlertDialog alertDialog = builder.create();

        // Acción cerrar
        btnClose.setOnClickListener(v -> alertDialog.dismiss());

        // Copiar al portapapeles
        githubContainer.setOnClickListener(v -> {
            String repoLink = "https://github.com/juanvictorbascopecastro/Factores-de-Inter-s";

            // Copiar al portapapeles
            ClipboardManager clipboard = (ClipboardManager) context.getSystemService(Context.CLIPBOARD_SERVICE);
            ClipData clip = ClipData.newPlainText("GitHub Repo", repoLink);
            clipboard.setPrimaryClip(clip);

            // Abrir en navegador
            Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse(repoLink));
            context.startActivity(intent);

            Toast.makeText(context, "Abriendo repositorio y copiado al portapapeles ✅", Toast.LENGTH_SHORT).show();
        });


        alertDialog.show();
    }
}
