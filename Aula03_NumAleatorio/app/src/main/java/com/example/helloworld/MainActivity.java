package com.example.helloworld;

import android.graphics.Color;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;

import java.util.Random;

public class MainActivity extends AppCompatActivity {

    EditText chute;
    Button botaoChutar;
    TextView resultado;
    TextView tentativas;

    Random geradorAleatorio = new Random();
    int numEscolhido;
    int numTentativas = 5;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        chute = findViewById(R.id.chute);
        botaoChutar = findViewById(R.id.botaoChutar);
        resultado = findViewById(R.id.resultado);
        tentativas = findViewById(R.id.tentativas);

        numEscolhido = geradorAleatorio.nextInt(10) + 1;
        Log.d("Tigrinho", "número escolhido foi: " + numEscolhido);

        botaoChutar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // 0. Diminuir as tentativas
                numTentativas = numTentativas - 1;
                tentativas.setText("Você tem " + numTentativas + " tentativas!");

                // 1. Pegar o numero que o usuario colocou
                String chuteUsuario = chute.getText().toString();
                int numUsuario = Integer.parseInt(chuteUsuario);

                // 2. Comparar com o numEscolhido
                if (numUsuario == numEscolhido) {
                    resultado.setText("Você acertou!");
                    resultado.setBackgroundColor(Color.GREEN);
                    botaoChutar.setEnabled(false);
                } else if (numTentativas == 0) {
                    resultado.setText("Você perdeu!");
                    resultado.setBackgroundColor(Color.RED);
                    botaoChutar.setEnabled(false);
                } else {
                    resultado.setText("Você errou!");
                }
            }
        });

    }
}