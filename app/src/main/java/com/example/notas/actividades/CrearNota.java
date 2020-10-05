package com.example.notas.actividades;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.example.notas.R;
import com.example.notas.clases.nota;

import org.w3c.dom.Notation;

public class CrearNota extends AppCompatActivity {

    //Variables para la vista

    private EditText txtTitulo, txtContenido;
    private Button btnGuardar;

    //Variables para los datos
    //----------

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_crear_nota);
        txtTitulo = findViewById(R.id.etxtTituloCrearNota);
        txtContenido = findViewById(R.id.etxtContenidoCrarNota);
        btnGuardar = findViewById(R.id.btnGuardarCrearNota);

        btnGuardar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (    !txtTitulo.getText().toString().isEmpty() &&
                        !txtContenido.getText().toString().isEmpty()){
                    nota nota = new nota(txtTitulo.getText().toString(),
                            txtContenido.getText().toString());
                    Intent intent = new Intent();
                    Bundle bundle = new Bundle();
                    bundle.putParcelable("NOTA", nota);
                    intent.putExtras()
                }
            }
        });
    }
}