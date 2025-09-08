package com.alvaroitu.layout_aula01;

import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity {

    EditText numero1, numero2;
    TextView resultado;
    Button botaoSoma, botaoSub, botaoMult, botaoDiv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        numero1 = findViewById(R.id.numero1);
        numero2 = findViewById(R.id.numero2);
        botaoSoma = findViewById(R.id.botaoSoma);
        botaoSub = findViewById(R.id.botaoSub);
        botaoMult = findViewById(R.id.botaoMult);
        botaoDiv = findViewById(R.id.botaoDiv);
        resultado = findViewById(R.id.resultado);


        botaoSoma.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int numeroRecebido1 = Integer.parseInt(numero1.getText().toString());
                double numeroRecebido2 = Double.parseDouble(numero2.getText().toString());
                double soma = numeroRecebido1 + numeroRecebido2;
                resultado.setText("Soma: " + soma);
            }
        });
        botaoSub.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int numeroRecebido1 = Integer.parseInt(numero1.getText().toString());
                double numeroRecebido2 = Double.parseDouble(numero2.getText().toString());
                double subtracao = numeroRecebido1 - numeroRecebido2;
                resultado.setText("Subtração: " + subtracao);
            }
        });
        botaoMult.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int numeroRecebido1 = Integer.parseInt(numero1.getText().toString());
                double numeroRecebido2 = Double.parseDouble(numero2.getText().toString());
                double multiplicacao = numeroRecebido1 * numeroRecebido2;
                resultado.setText("Multiplicação: " + multiplicacao);
            }
        });
        botaoDiv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int numeroRecebido1 = Integer.parseInt(numero1.getText().toString());
                double numeroRecebido2 = Double.parseDouble(numero2.getText().toString());
                if (numeroRecebido2 == 0 ){
                    Toast.makeText(MainActivity.this, "NÃO PODE DIVIDIR POR 0",
                            Toast.LENGTH_LONG).show();
                    Toast.makeText(MainActivity.this, "zzdvzcvzxcvzxvxc", Toast.LENGTH_SHORT).show();
                } else {
                    double divisao = numeroRecebido1 / numeroRecebido2;
                    resultado.setText("Divisão: " + divisao);
                }
            }
        });


    }
}