package com.example.notas.actividades;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.example.notas.R;
import com.example.notas.clases.nota;

public class VerEditarNota extends AppCompatActivity {

    private EditText txtTitulo, txtContenido;

    private Button btnModificar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ver_editar_nota);

        txtContenido = findViewById(R.id.etxtContenidoVerEditarNota);
        txtTitulo = findViewById(R.id.etxtTituloVerEditarNota);
        btnModificar = findViewById(R.id.btnModificarVerEditarNota);

        if (getIntent().getExtras() != null){
            final nota nota = get.Intent().getExtras.getParcelable("NOTA");
            int posicion = getIntent().getExtras.getInt("POS");

            btnModificar.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    nota.setTitulo();
                    nota.setContenido();

                }
            });
        }

    }
}