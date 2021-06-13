package com.example.control7;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;

public class MainActivity extends Activity {
    private Button btnRegistrar;
    private EditText txtNombre, txtCodigo;
    private ProgressBar progressBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btnRegistrar = (Button)findViewById(R.id.btnRegistrar);
        txtNombre=(EditText)findViewById(R.id.txtNombre);
        txtCodigo=(EditText)findViewById(R.id.txtCodigo);
        progressBar=(ProgressBar)findViewById(R.id.progressBar);
        btnRegistrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                new Task1().execute(txtNombre.getText().toString());
            }
        });
    }

    class Task1 extends AsyncTask<String,Void,String>{

        @Override
        protected void onPreExecute(){
            progressBar.setVisibility(View.VISIBLE);
            btnRegistrar.setEnabled(false);
        }
        @Override
        protected void onPostExecute(String s){
            progressBar.setVisibility(View.INVISIBLE);
            btnRegistrar.setEnabled(true);
            Intent intent = new Intent(MainActivity.this,ResultadoActivity.class);
            intent.putExtra("usuario",txtNombre.getText().toString());
            intent.putExtra("codigo",txtCodigo.getText().toString());
            startActivity(intent);
        }
        @Override
        protected String doInBackground(String... strings){
            try {
                Thread.sleep(3000);
            }catch (InterruptedException e){
                e.printStackTrace();
            }
            return strings[0];
        }

    }

}