package com.example.aplicacionnota;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    public EditText Nota;
    public TextView textView;
    public int nota;

    Button btn = findViewById(R.id.btn);


    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Nota = findViewById(R.id.txtNota);
        textView = findViewById(R.id.textView);

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                MostrarDatos();
            }
        });

    }

    private void obtenerValores(){
        nota = Integer.parseInt(Nota.getText().toString());
    }

    private boolean esValida(int val){
        if (val >=0 && val <=100){
            return true;
        }else {
            return false;
        }
    }

    public void MostrarDatos(){
        obtenerValores();
        if(esValida(nota)){
            if (nota >= 90 && nota <=100){
                textView.setText("Usted tiene una A");
                Toast.makeText(this, "Felicitaciones", Toast.LENGTH_SHORT).show();
            } else if(nota >=80  ){
                textView.setText("Usted tiene una B");
                Toast.makeText(this, "Excelente", Toast.LENGTH_SHORT).show();
            } else if (nota >=70) {
                textView.setText("Usted tiene una C");
                Toast.makeText(this, "Siga estudiando", Toast.LENGTH_SHORT).show();
            } else {
                textView.setText("Usted tiene una f");
                Toast.makeText(this, "Vuelva y tome la materia", Toast.LENGTH_SHORT).show();
            }
        }
    }
}