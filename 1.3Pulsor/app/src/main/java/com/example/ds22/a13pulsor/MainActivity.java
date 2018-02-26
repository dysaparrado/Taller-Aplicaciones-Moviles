package com.example.ds22.a13pulsor;

import android.graphics.Color;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.text.DecimalFormat;
import java.util.Random;
import java.util.Timer;
import java.util.TimerTask;

public class MainActivity extends AppCompatActivity {

    public TextView numero,naleatorio;
    public Button pulsar;

    public double rdm = 1;
    public double rdmn;
    public Handler handler = new Handler();
    DecimalFormat decf = new DecimalFormat("#.0");

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        numero = (TextView) findViewById(R.id.textView);
        naleatorio = (TextView) findViewById(R.id.textView2);
        pulsar = (Button) findViewById(R.id.button);
        rdmn = (Math.random()*(3.0-1.0))+1.0;

        naleatorio.setText(decf.format(rdmn));
        handler.postDelayed(runnable, 100);

        pulsar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                pulso();
            }
        });



    }

    public void reset(){
        DecimalFormat df = new DecimalFormat("#.0");
        numero.setText(df.format(rdm));
        double temp = Double.parseDouble(numero.getText().toString());
        if(temp == 3.0){
            rdm = 1;
        }
        rdm = rdm+.1;



    }

    private Runnable runnable = new Runnable() {
        @Override
        public void run() {
      /* do what you need to do */
            reset();
      /* and here comes the "trick" */
            handler.postDelayed(this, 100);
        }
    };


    public void pulso(){
        double numerot = Double.parseDouble(numero.getText().toString());
        double numerot2 = Double.parseDouble(naleatorio.getText().toString());

        if(numerot == numerot2){
            Toast.makeText(MainActivity.this,"Felicidades Acertaste !!", Toast.LENGTH_SHORT).show();
            rdmn = (Math.random()*(3.0-1.0))+1.0;
            naleatorio.setText(decf.format(rdmn));
            naleatorio.setTextColor(Color.GREEN);
        }

        else if(numerot != numerot2){
            Toast.makeText(MainActivity.this,"Lo Siento, Fallaste!", Toast.LENGTH_SHORT).show();
            rdmn = (Math.random()*(3.0-1.0))+1.0;
            naleatorio.setText(decf.format(rdmn));
            naleatorio.setTextColor(Color.RED);

        }
    }
}
