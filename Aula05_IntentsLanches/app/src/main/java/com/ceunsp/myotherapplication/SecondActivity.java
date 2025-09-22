package com.ceunsp.myotherapplication;

import android.content.Intent;
import android.net.Uri;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;

public class SecondActivity extends AppCompatActivity {

    TextView textoTotal, textoDescricao;
    Button botaoPagar, botaoEmail;

    String nomeRecebido;
    String descRecebido;
    Double totalRecebido;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        textoTotal = findViewById(R.id.textoTotal);
        textoDescricao = findViewById(R.id.textoDescricao);
        botaoPagar = findViewById(R.id.botaoPagar);
        botaoEmail = findViewById(R.id.botaoEmail);

        Bundle dados = getIntent().getExtras();
        nomeRecebido = dados.getString("nome");
        descRecebido = dados.getString("descricaoPedido");
        totalRecebido = dados.getDouble("total");

        textoTotal.setText("R$ " + totalRecebido);
        textoDescricao.setText(nomeRecebido + ", você pediu: " + descRecebido);

        botaoPagar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent abrirNavegador = new Intent(Intent.ACTION_VIEW, Uri.parse("http://google.com.br"));
                startActivity(abrirNavegador);
            }
        });

        botaoEmail.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent abrirEmail = new Intent(Intent.ACTION_SENDTO, Uri.fromParts("mailto", "abc@example.com", null));
                abrirEmail.putExtra(Intent.EXTRA_SUBJECT, "SUBJECT");
                abrirEmail.putExtra(Intent.EXTRA_TEXT, "BODY");
                startActivity(Intent.createChooser(abrirEmail, "Enviar email"));
            }
        });
    }
}