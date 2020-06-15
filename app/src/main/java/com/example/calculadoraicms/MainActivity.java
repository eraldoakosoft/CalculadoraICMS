package com.example.calculadoraicms;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.santalu.maskedittext.MaskEditText;

import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.util.Locale;

public class MainActivity extends AppCompatActivity {

    private static final Locale LOCAL = new Locale("pt","BR");
    private EditText campoICMS, campoIcmsST, campoBaseIcms, campoBaseIcmsSt, qtd;
    private EditText nfCampoICMS, nfCampoIcmsST, nfCampoBaseIcms, nfCampoBaseIcmsSt, nFqtd;
    private double icms, icmsSt, baseIcms, baseIcmsSt, quantidade, nfQuantidade;
    private Button btnCalcular;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnCalcular = findViewById(R.id.buttonCalcular);

        campoICMS = findViewById(R.id.editTextNumberDecimal9);
        campoBaseIcms = findViewById(R.id.editTextNumberDecimal10);
        campoIcmsST = findViewById(R.id.editTextNumberDecimal11);
        campoBaseIcmsSt = findViewById(R.id.editTextNumberDecimal12);
        qtd = findViewById(R.id.editTextNumberDecimal8);


        nfCampoICMS = findViewById(R.id.editTextNumberDecimal3);
        nfCampoIcmsST = findViewById(R.id.editTextNumberDecimal5);
        nfCampoBaseIcms = findViewById(R.id.editTextNumberDecimal4);
        nfCampoBaseIcmsSt = findViewById(R.id.editTextNumberDecimal6);
        nFqtd = findViewById(R.id.editTextNumberDecimal2);



        btnCalcular.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                calcular();
            }
        });


    }



    public void calcular(){
        double valorIcms;
        double valorIcmsSt;
        double valorBaseIcmsSt;
        double valorBaseIcms;

        String textoIcms;
        String textoBaseIcms;
        String textoBaseIcmsSt;
        String textoIcmsSt;
        String textoQtd;
        String textoQtdNf;

        textoBaseIcms = campoBaseIcms.getText().toString();
        textoBaseIcmsSt = campoBaseIcmsSt.getText().toString();
        textoIcms = campoICMS.getText().toString();
        textoIcmsSt = campoIcmsST.getText().toString();
        textoQtd = qtd.getText().toString();
        textoQtdNf = nFqtd.getText().toString();


        if (textoIcms.isEmpty()){
            textoIcms = "00.00";
        }
        if (textoBaseIcms.isEmpty()){
            textoBaseIcms = "00.00";
        }
        if (textoIcmsSt.isEmpty()){
            textoIcmsSt = "00.00";
        }
        if (textoBaseIcmsSt.isEmpty()){
            textoBaseIcmsSt = "00.00";
        }

        if(!textoQtd.isEmpty()){
            if (!textoQtdNf.isEmpty()){

                icms = Double.parseDouble(textoIcms);
                icmsSt = Double.parseDouble(textoIcmsSt);
                baseIcms = Double.parseDouble(textoBaseIcms);
                baseIcmsSt = Double.parseDouble(textoBaseIcmsSt);
                quantidade = Double.parseDouble(qtd.getText().toString());
                nfQuantidade = Double.parseDouble(nFqtd.getText().toString());

                valorIcms = ( icms / quantidade ) * nfQuantidade;
                valorIcmsSt = ( icmsSt / quantidade ) * nfQuantidade;
                valorBaseIcmsSt = ( baseIcmsSt / quantidade ) * nfQuantidade;
                valorBaseIcms = ( baseIcms / quantidade ) * nfQuantidade;

                DecimalFormat df = new DecimalFormat("#,##0.00", new DecimalFormatSymbols(LOCAL));


                nfCampoBaseIcms.setText(df.format(valorBaseIcms));
                nfCampoBaseIcmsSt.setText(df.format(valorBaseIcmsSt));
                nfCampoICMS.setText(df.format(valorIcms));
                nfCampoIcmsST.setText(df.format(valorIcmsSt));

            }else{
                Toast.makeText(this, "Digite a Quantidade da NF", Toast.LENGTH_SHORT).show();
            }
        }else{
            Toast.makeText(MainActivity.this, "Digite a Quantidade de Referencia!", Toast.LENGTH_SHORT).show();
        }



        /*
        System.out.println("********************************");
        System.out.println("ICMS: " + valorIcms);
        System.out.println("ICMS C. St.: " + valorIcmsSt);
        System.out.println("Base ICMS .: " + valorBaseIcms);
        System.out.println("Base ICMS C. St.: " + valorBaseIcmsSt);
        */





    }

}