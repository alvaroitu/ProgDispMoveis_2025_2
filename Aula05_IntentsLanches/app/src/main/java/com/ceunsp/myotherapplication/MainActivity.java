package com.ceunsp.myotherapplication;

import android.content.Intent;
import android.util.Log;
import android.view.View;
import android.widget.*;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity {

    EditText textNome;
    RadioGroup pedido;
    RadioButton lancheRadio;
    CheckBox adicBatata, adicOnion, adicCheddar;
    Button botaoEnviar, botaoLimpar;
    double total = 0.0;
    String descricaoPedido = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        textNome = findViewById(R.id.textNome);
        pedido = findViewById(R.id.groupPedido);
        adicBatata = findViewById(R.id.adicBatata);
        adicOnion = findViewById(R.id.adicOnion);
        adicCheddar = findViewById(R.id.adicCheddar);
        botaoEnviar = findViewById(R.id.botaoEnviar);
        botaoLimpar = findViewById(R.id.botaoLimpar);

        botaoEnviar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int lancheSelecionado = pedido.getCheckedRadioButtonId();
                Log.d("lanche", "onCreate: " + lancheSelecionado);
                lancheRadio = findViewById(lancheSelecionado);
                String lancheTexto = lancheRadio.getText().toString();

                if (lancheTexto.equals("Mega Burger (R$ 30,00)")) {
                    total += 30.0;
                } else if (lancheTexto.equals("Super Frango (R$ 25,00)")) {
                    total += 25.0;
                } else {
                    total += 22.0;
                }
                descricaoPedido += lancheTexto + " + ";

                if (adicBatata.isChecked()) {
                    total += 5.0;
                    descricaoPedido += adicBatata.getText().toString() + " ";
                }
                if (adicOnion.isChecked()) {
                    total += 8.0;
                    descricaoPedido += adicOnion.getText().toString() + " ";
                }
                if (adicCheddar.isChecked()) {
                    total += 6.0;
                    descricaoPedido += adicCheddar.getText().toString() + " ";
                }

                Intent intent = new Intent(getApplicationContext(), SecondActivity.class);
                intent.putExtra("total", total);
                intent.putExtra("descricaoPedido", descricaoPedido);
                intent.putExtra("nome", textNome.getText().toString());
                startActivity(intent);
            }
        });
    }
}