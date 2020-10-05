package com.example.notas;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.notas.actividades.CrearNota;
import com.example.notas.actividades.VerEditarNota;
import com.example.notas.clases.nota;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private final int AGREGAR_NOTA=1;
    private final int EDIT_NOTA=2;
    //Variables para vista
    private LinearLayout contenedor;
    private Button btnAgregar;
    //Variables para datos
    private ArrayList<nota> ListaNotas;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        contenedor = findViewById(R.id.LlContenedorMain);
        btnAgregar = findViewById(R.id.btnCrearNotaMain);
        ListaNotas = new ArrayList<>();

        btnAgregar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, CrearNota.class);
                startActivity(intent);
            }
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == AGREGAR_NOTA && resultCode == RESULT_OK){
            if (data != null){
                final nota nota = data.getExtras().getParcelable("NOTA");
                ListaNotas.add(nota);
                final int posicion = i;

                LinearLayout contenidoNota = new LinearLayout(this);

                LinearLayout.LayoutParams paramsTextView = new LinearLayout.LayoutParams(0, ViewGroup.LayoutParams.WRAP_CONTENT, 3);
                TextView textView = new TextView(this);
                textView.setText(nota.getTitulo());
                textView.setTextSize(24);
                textView.setTextColor(Color.BLUE);
                textView.setLayoutParams(paramsTextView);
                textView.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Bundle bundle = new Bundle();
                        bundle.putInt("POS", posicion);
                        bundle.putParcelable("NOTA", nota);
                        Intent intent= new Intent(MainActivity.this, VerEditarNota.class);
                        intent.putExtras(bundle);
                        startActivityForResult(intent, EDIT_NOTA);
                    }
                });
                //Button
                Button btnEliminar = new Button(this);
                btnEliminar.setText("Eliminar");
                LinearLayout.LayoutParams paramsBTN = new LinearLayout.LayoutParams(0, ViewGroup.LayoutParams.WRAP_CONTENT, 3);
                btnEliminar.setLayoutParams(paramsBTN);
                btnEliminar.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        ListaNotas.remove()
                    }
                });
            }
        }
    }
   // private void RepintNotas
}