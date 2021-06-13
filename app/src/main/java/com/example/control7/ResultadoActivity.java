package com.example.control7;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.os.Bundle;
import android.widget.TextView;

public class ResultadoActivity extends Activity {
    private TextView txtResultado;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_resultado);


        txtResultado=(TextView)findViewById(R.id.txtresultado);
        String nombre = getIntent().getStringExtra("usuario");
        String cod = getIntent().getStringExtra("codigo");
        txtResultado.setText("Registro almacenado con exito  \n -Nombre: "+nombre+" \n -Codigo: "+cod);


    }
}