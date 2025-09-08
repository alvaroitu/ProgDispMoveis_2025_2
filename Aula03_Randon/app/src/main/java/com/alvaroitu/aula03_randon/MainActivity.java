package com.alvaroitu.aula03_randon;

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

    Random geradorAleatorio = new Random();
    int numeroEscolhido;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        chute = findViewById(R.id.chute);
        botaoChutar = findViewById(R.id.botaoChutar);
        resultado = findViewById(R.id.resultado);

        numeroEscolhido = geradorAleatorio.nextInt(10) + 1;
        Log.d("Tigrinho", "numero escolhido foi: " + numeroEscolhido);

        botaoChutar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String chuteUsuario = chute.getText().toString();
                int numUsuario = Integer.parseInt(chuteUsuario);
                if (numUsuario == numeroEscolhido){
                    resultado.setText("voce acertou");
                    botaoChutar.setEnabled(false);
                    resultado.setBackgroundColor(Color.GREEN);
                } else {
                    resultado.setText("Voce eeerrroooouuu");
                }
            }
        });
    }
}