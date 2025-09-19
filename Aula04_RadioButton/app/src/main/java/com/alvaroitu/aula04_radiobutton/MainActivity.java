package com.alvaroitu.aula04_radiobutton;

import android.graphics.Color;
import android.util.Log;
import android.view.View;
import android.widget.*;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity {

    CheckBox vermelho, verde, azul;
    Button botaoEnviar, botaoLimpar;
    TextView textoCheckBoxRadioButton, textoSwitch, textoToggle;
    Switch botaoSwitch;
    ToggleButton botaoToggle;
    RadioGroup radioGroupSexo;
    RadioButton radioButtonSexo;
    int radioButtonId;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        vermelho = findViewById(R.id.vermelho);
        verde = findViewById(R.id.verde);
        azul = findViewById(R.id.azul);
        botaoEnviar = findViewById(R.id.botaoEnviar);
        botaoLimpar = findViewById(R.id.botaoLimpar);
        textoCheckBoxRadioButton = findViewById(R.id.textoCheckBoxRadioButton);
        textoSwitch = findViewById(R.id.textoSwitch);
        textoToggle = findViewById(R.id.textoToggle);
        botaoSwitch = findViewById(R.id.botaoSwitch);
        botaoToggle = findViewById(R.id.botaoToggle);
        radioGroupSexo = findViewById(R.id.radioGroupSexo);

        botaoEnviar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String cores = "";
                String sexo = "";
                if(vermelho.isChecked()){
                    String corSelecionada = vermelho.getText().toString();
                    cores = corSelecionada + " selecionada - ";
                }
                if(verde.isChecked()){
                    String corSelecionada = verde.getText().toString();
                    cores = cores + corSelecionada + " selecionado - ";
                }
                if(azul.isChecked()){
                    String corSelecionada = azul.getText().toString();
                    cores = cores + corSelecionada + " selecionado - ";
                }
                radioButtonId = radioGroupSexo.getCheckedRadioButtonId();
                Log.d("VALOR", String.valueOf(radioButtonId));
                Log.d("VALOR", String.valueOf(R.id.masculino));
                Log.d("VALOR", String.valueOf(R.id.feminino));
                if(radioButtonId != -1){
                    radioButtonSexo = findViewById(radioButtonId);
                    String sexoSelecionado = radioButtonSexo.getText().toString();
                    sexo = sexoSelecionado + " selecionado.";
                    textoCheckBoxRadioButton.setText(cores + sexo);
                } else {
                    Toast.makeText(MainActivity.this,
                            "Sexo deve ser selecionado.", Toast.LENGTH_SHORT).show();
                }
            }
        }); // fim do botao enviar

        botaoLimpar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                vermelho.setChecked(false);
                verde.setChecked(false);
                azul.setChecked(false);
                radioGroupSexo.clearCheck();
                textoCheckBoxRadioButton.setText(getString(R.string.textoCheckBoxRadioButton));
            }
        }); // fim do botao limpa

        botaoSwitch.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                if(botaoSwitch.isChecked()){
                    textoSwitch.setText("PALMEIRAS NÃO TEM MUNDIAL!!!");
                    textoSwitch.setBackgroundColor(getColor(R.color.green));
                }else{
                    textoSwitch.setText(getString(R.string.textoSwitch));
                    textoSwitch.setBackgroundColor(getColor(R.color.white));
                }
            }
        }); // fim do botao switch

        botaoToggle.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                if(botaoToggle.isChecked()){
                    textoToggle.setText("PALMEIRAS NÃO TEM MUNDIAL!!!");
                }else{
                    textoToggle.setText(getString(R.string.textoToggle));
                }

            }
        }); // fim do botao toogle
    }
}