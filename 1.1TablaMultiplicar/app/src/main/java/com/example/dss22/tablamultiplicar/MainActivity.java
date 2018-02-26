package com.example.dss22.tablamultiplicar;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

         Button btnCalcular;
        final EditText et1,et2,et3,et4,et5,et6,et7,et8,et9,et10,etNumero;
        final int[] numero1 = new int[1];
        final int[] resultado = new int[1];

        btnCalcular = (Button)findViewById(R.id.btnCalcular);
        et1 = (EditText) findViewById(R.id.et1);
        et2 = (EditText) findViewById(R.id.et2);
        et3 = (EditText) findViewById(R.id.et3);
        et4 = (EditText) findViewById(R.id.et4);
        et5 = (EditText) findViewById(R.id.et5);
        et6 = (EditText) findViewById(R.id.et6);
        et7 = (EditText) findViewById(R.id.et7);
        et8 = (EditText) findViewById(R.id.et8);
        et9 = (EditText) findViewById(R.id.et9);
        et10 = (EditText) findViewById(R.id.et10);
        etNumero = (EditText) findViewById(R.id.etNumero);


        btnCalcular.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {

                resultado[0] = Integer.parseInt(etNumero.getText().toString());

                et1.setText(resultado[0] *1+"");
                et2.setText(resultado[0] *2+"");
                et3.setText(resultado[0] *3+"");
                et4.setText(resultado[0] *4+"");
                et5.setText(resultado[0] *5+"");
                et6.setText(resultado[0] *6+"");
                et7.setText(resultado[0] *7+"");
                et8.setText(resultado[0] *8+"");
                et9.setText(resultado[0] *9+"");
                et10.setText(resultado[0] *10+"");




            }
        });
    }
}
