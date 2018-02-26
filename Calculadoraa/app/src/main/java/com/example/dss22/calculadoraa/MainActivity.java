package com.example.dss22.calculadoraa;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    Button btnCero, btnUno, btnDos, btnTres, btnCuatro, btnCinco, btnSeis, btnSiete, btnOcho,
            btnNueve, btnPunto, btnIgual, btnSuma, btnResta, btnMult, btnDiv, btnLimpiar;
    EditText etResultado, conc;

    double numero1, numero2, resultado;
    String operador;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        btnCero = (Button)findViewById(R.id.btnCero);
        btnUno = (Button)findViewById(R.id.btnUno);
        btnDos = (Button)findViewById(R.id.btnDos);
        btnTres = (Button)findViewById(R.id.btnTres);
        btnCuatro = (Button)findViewById(R.id.btnCuatro);
        btnCinco = (Button)findViewById(R.id.btnCinco);
        btnSeis = (Button)findViewById(R.id.btnSeis);
        btnSiete = (Button)findViewById(R.id.btnSiete);
        btnOcho = (Button)findViewById(R.id.btnOcho);
        btnNueve = (Button)findViewById(R.id.btnNueve);
        btnPunto = (Button)findViewById(R.id.btnPunto);
        btnIgual = (Button)findViewById(R.id.btnIgual);
        btnSuma = (Button)findViewById(R.id.btnSuma);
        btnResta = (Button)findViewById(R.id.btnResta);
        btnMult = (Button)findViewById(R.id.btnMult);
        btnDiv = (Button)findViewById(R.id.btnDiv);
        btnLimpiar = (Button)findViewById(R.id.btnLimpiar);
        etResultado = (EditText)findViewById(R.id.etResultado);

        btnCero.setOnClickListener(new View.OnClickListener() {

            public void onClick(View v) {
                conc = (EditText)findViewById(R.id.etResultado);
                etResultado.setText(conc.getText().toString() + "0");
            }
        });

        btnUno.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                conc = (EditText)findViewById(R.id.etResultado);
                etResultado.setText(conc.getText().toString() + "1");

            }
        });

        btnDos.setOnClickListener(new View.OnClickListener() {

            public void onClick(View v) {
                conc = (EditText)findViewById(R.id.etResultado);
                etResultado.setText(conc.getText().toString() + "2");
            }
        });

        btnTres.setOnClickListener(new View.OnClickListener() {

            public void onClick(View v) {
                conc = (EditText)findViewById(R.id.etResultado);
                etResultado.setText(conc.getText().toString() + "3");
            }
        });

        btnCuatro.setOnClickListener(new View.OnClickListener() {

            public void onClick(View v) {
                conc = (EditText)findViewById(R.id.etResultado);
                etResultado.setText(conc.getText().toString() + "4");
            }
        });

        btnCinco.setOnClickListener(new View.OnClickListener() {

            public void onClick(View v) {
                conc = (EditText)findViewById(R.id.etResultado);
                etResultado.setText(conc.getText().toString() + "5");
            }
        });

        btnSeis.setOnClickListener(new View.OnClickListener() {

            public void onClick(View v) {
                conc = (EditText)findViewById(R.id.etResultado);
                etResultado.setText(conc.getText().toString() + "6");
            }
        });

        btnSiete.setOnClickListener(new View.OnClickListener() {

            public void onClick(View v) {
                conc = (EditText)findViewById(R.id.etResultado);
                etResultado.setText(conc.getText().toString() + "7");
            }
        });

        btnOcho.setOnClickListener(new View.OnClickListener() {

            public void onClick(View v) {
                conc = (EditText)findViewById(R.id.etResultado);
                etResultado.setText(conc.getText().toString() + "8");
            }
        });

        btnNueve.setOnClickListener(new View.OnClickListener() {

            public void onClick(View v) {
                conc = (EditText)findViewById(R.id.etResultado);
                etResultado.setText(conc.getText().toString() + "9");
            }
        });

        btnPunto.setOnClickListener(new View.OnClickListener() {

            public void onClick(View v) {
                conc = (EditText)findViewById(R.id.etResultado);
                etResultado.setText(conc.getText().toString() + ".");
            }
        });

        btnIgual.setOnClickListener(new View.OnClickListener() {

            public void onClick(View v) {
                conc = (EditText)findViewById(R.id.etResultado);
                numero2 = Double.parseDouble(conc.getText().toString());

                if(operador.equals("+")){
                    etResultado.setText("");
                    resultado = numero1 + numero2;
                }
                if(operador.equals("-")){
                    etResultado.setText("");
                    resultado = numero1 - numero2;
                }
                if(operador.equals("*")){
                    etResultado.setText("");
                    resultado = numero1 * numero2;
                }
                if(operador.equals("/")){
                    etResultado.setText("");
                    if(numero2 != 0){
                        resultado = numero1 / numero2;
                    }else {
                        etResultado.setText("Indefinido");
                    }
                }
                etResultado.setText(String.valueOf(resultado));
            }
        });

        btnSuma.setOnClickListener(new View.OnClickListener() {

            public void onClick(View v) {
                operador = "+";
                conc = (EditText)findViewById(R.id.etResultado);
                numero1 = Double.parseDouble(conc.getText().toString());
                etResultado.setText("");
            }
        });

        btnResta.setOnClickListener(new View.OnClickListener() {

            public void onClick(View v) {
                operador = "-";
                conc = (EditText)findViewById(R.id.etResultado);
                numero1 = Double.parseDouble(conc.getText().toString());
                etResultado.setText("");
            }
        });

        btnMult.setOnClickListener(new View.OnClickListener() {

            public void onClick(View v) {
                operador = "*";
                conc = (EditText)findViewById(R.id.etResultado);
                numero1 = Double.parseDouble(conc.getText().toString());
                etResultado.setText("");
            }
        });

        btnDiv.setOnClickListener(new View.OnClickListener() {

            public void onClick(View v) {
                operador = "/";
                conc = (EditText)findViewById(R.id.etResultado);
                numero1 = Double.parseDouble(conc.getText().toString());
                etResultado.setText("");
            }
        });

        btnLimpiar.setOnClickListener(new View.OnClickListener() {

            public void onClick(View v) {
                numero1 = 0;
                numero2 = 0;
                etResultado.setText("");
            }
        });
    }
}


