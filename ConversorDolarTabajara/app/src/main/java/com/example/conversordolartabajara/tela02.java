package com.example.conversordolartabajara;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.text.DecimalFormat;

public class tela02 extends AppCompatActivity {

    public EditText cotacaoVal;
    public EditText dolarVal;
    public TextView resultadoVal;
    public Button calcular;
    public Button limpar;
    public  Double valorReal;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tela02);

        cotacaoVal = (EditText) findViewById(R.id.valCotacao);
        dolarVal = (EditText) findViewById(R.id.valorDolar);
        calcular =(Button) findViewById(R.id.btnCalcular);
        limpar = (Button) findViewById(R.id.btnLimpar);
        resultadoVal = (TextView) findViewById(R.id.resultado);


        calcular.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                calcularMetod();
            }
        });

        limpar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                limparMetod();
            }
        });

    }

    protected void calcularMetod (){
        if(cotacaoVal.getText().toString().equals("")){
            Toast.makeText(getApplicationContext(), "Favor preencher o campo [Cotação do Dólar].", Toast.LENGTH_LONG).show();
            cotacaoVal.requestFocus();
            return;
        }

        if(dolarVal.getText().toString().equals("")){
            Toast.makeText(getApplicationContext(), "Favor preencher o campo [Valor a ser convertido].", Toast.LENGTH_LONG).show();
            dolarVal.requestFocus();
            return;
        }

        double cotacao = Double.parseDouble(cotacaoVal.getText().toString());
        double valorDolar = Double.parseDouble(dolarVal.getText().toString());
        double valorReal = cotacao*valorDolar;
        resultadoVal.setText(new DecimalFormat().format(valorReal));

    }

    protected  void limparMetod (){
        cotacaoVal.setText("");
        dolarVal.setText("");
        resultadoVal.setText("");
        cotacaoVal.requestFocus();
    }
}
