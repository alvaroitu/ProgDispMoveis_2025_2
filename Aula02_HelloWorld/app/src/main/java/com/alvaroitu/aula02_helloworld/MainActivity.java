package com.alvaroitu.aula02_helloworld;

import android.annotation.SuppressLint;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity {

    EditText entrada;
    Button botaoEnviar;
    TextView saida;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        entrada = findViewById(R.id.entrada);
        botaoEnviar = findViewById(R.id.botaoEnviar);
        saida = findViewById(R.id.saida);

        botaoEnviar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String textoRecebido = entrada.getText().toString();
                saida.setText(textoRecebido);
            }
        });
    }
}