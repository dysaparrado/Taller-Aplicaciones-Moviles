package com.example.dss22.gato;

import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;



public class MainActivity extends AppCompatActivity {

    void smn(Button btn1,Button btn3,Button btn2,Button btnReinicio) {
        if (btn1.getText().equals(btn3.getText()) && btn2.getText().equals(btn3.getText())) {
            btnReinicio.setText("Ganaste");
            btn1.setTextColor(Color.GREEN);
            btn2.setTextColor(Color.GREEN);
            btn3.setTextColor(Color.GREEN);

            btn1.setEnabled(false);
            btn2.setEnabled(false);
            btn3.setEnabled(false);


        }
    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);



        final Button btn1, btn2, btn3, btn4, btn5, btn6, btn7, btn8,btn9,btnReinicio;

        final EditText etJugador,etTurno;

        final int[] coint = {1};



        btn1 = (Button)findViewById(R.id.btn1);
        btn2 = (Button)findViewById(R.id.btn2);
        btn3 = (Button)findViewById(R.id.btn3);
        btn4 = (Button)findViewById(R.id.btn4);
        btn5 = (Button)findViewById(R.id.btn5);
        btn6 = (Button)findViewById(R.id.btn6);
        btn7 = (Button)findViewById(R.id.btn7);
        btn8 = (Button)findViewById(R.id.btn8);
        btn9 = (Button)findViewById(R.id.btn9);
        btnReinicio = (Button)findViewById(R.id.btnReinicio);
        btn1.setTextColor(Color.GRAY);
        btn2.setTextColor(Color.GRAY);
        btn3.setTextColor(Color.GRAY);
        btn4.setTextColor(Color.GRAY);
        btn5.setTextColor(Color.GRAY);
        btn6.setTextColor(Color.GRAY);
        btn7.setTextColor(Color.GRAY);
        btn8.setTextColor(Color.GRAY);
        btn9.setTextColor(Color.GRAY);
        etTurno = (EditText) findViewById(R.id.etTurno);




        btn1.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                if(coint[0] ==1){
                btn1.setText("X");
                etTurno.setText("2");
                coint[0] =2;
                }else if(coint[0]==2){
                    btn1.setText("O");
                    etTurno.setText("1");
                    coint[0] =1;
                }


                if(btn1.getText().equals("X") || btn1.getText().equals("O")){
                    btn1.setEnabled(false);
                }

                
                smn(btn1,btn2,btn3,btnReinicio);
                smn(btn1,btn4,btn7,btnReinicio);
                smn(btn1,btn5,btn9,btnReinicio);
            }
        });

        btn2.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                if(coint[0] ==1){
                    btn2.setText("X");
                    etTurno.setText("2");
                    coint[0] =2;
                }else if(coint[0]==2){
                    btn2.setText("O");
                    etTurno.setText("1");
                    coint[0] =1;
                }
                if(btn2.getText().equals("X") || btn2.getText().equals("O")){
                    btn2.setEnabled(false);
                }


                smn(btn2,btn1,btn3,btnReinicio);
                smn(btn2,btn5,btn8,btnReinicio);
            }


        });

        btn3.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                if(coint[0] ==1){
                    btn3.setText("X");
                    etTurno.setText("2");
                    coint[0] =2;
                }else if(coint[0]==2){
                    btn3.setText("O");
                    etTurno.setText("1");
                    coint[0] =1;
                }


                if(btn3.getText().equals("X") || btn3.getText().equals("O")){
                    btn3.setEnabled(false);
                }

                smn(btn3,btn2,btn1,btnReinicio);
                smn(btn3,btn6,btn9,btnReinicio);
                smn(btn3,btn5,btn7,btnReinicio);
            }
        });

        btn4.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {

                if(coint[0] ==1){
                    btn4.setText("X");
                    etTurno.setText("2");
                    coint[0] =2;
                }else if(coint[0]==2){
                    btn4.setText("O");
                    etTurno.setText("1");
                    coint[0] =1;
                }
                if(btn4.getText().equals("X") || btn4.getText().equals("O")){
                    btn4.setEnabled(false);
                }

                smn(btn4,btn5,btn6,btnReinicio);
                smn(btn4,btn1,btn7,btnReinicio);
            }
        });

        btn5.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {

                if(coint[0] ==1){
                    btn5.setText("X");
                    etTurno.setText("2");
                    coint[0] =2;
                }else if(coint[0]==2){
                    btn5.setText("O");
                    etTurno.setText("1");
                    coint[0] =1;
                }
                if(btn5.getText().equals("X") || btn5.getText().equals("O")){
                    btn5.setEnabled(false);
                }

                smn(btn5,btn4,btn6,btnReinicio);
                smn(btn5,btn2,btn8,btnReinicio);
            }
        });

        btn6.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {

                if(coint[0] ==1){
                    btn6.setText("X");
                    etTurno.setText("2");
                    coint[0] =2;
                }else if(coint[0]==2){
                    btn6.setText("O");
                    etTurno.setText("1");
                    coint[0] =1;
                }
                if(btn6.getText().equals("X") || btn6.getText().equals("O")){
                    btn6.setEnabled(false);
                }

                smn(btn6,btn4,btn5,btnReinicio);
                smn(btn6,btn3,btn9,btnReinicio);
            }
        });

        btn7.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {

                if(coint[0] ==1){
                    btn7.setText("X");
                    etTurno.setText("2");
                    coint[0] =2;
                }else if(coint[0]==2){
                    btn7.setText("O");
                    etTurno.setText("1");
                    coint[0] =1;
                }
                if(btn7.getText().equals("X") || btn7.getText().equals("O")){
                    btn7.setEnabled(false);
                }

                smn(btn7,btn8,btn9,btnReinicio);
                smn(btn7,btn1,btn4,btnReinicio);
                smn(btn7,btn5,btn3,btnReinicio);
            }
        });

        btn8.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {

                if(coint[0] ==1){
                    btn8.setText("X");
                    etTurno.setText("2");
                    coint[0] =2;
                }else if(coint[0]==2){
                    btn8.setText("O");
                    etTurno.setText("1");
                    coint[0] =1;
                }
                if(btn8.getText().equals("X") || btn8.getText().equals("O")){
                    btn8.setEnabled(false);
                }

                smn(btn8,btn7,btn9,btnReinicio);
                smn(btn8,btn5,btn2,btnReinicio);
            }
        });

        btn9.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {

                if(coint[0] ==1){
                    btn9.setText("X");
                    etTurno.setText("2");
                    coint[0] =2;
                }else if(coint[0]==2){
                    btn9.setText("O");
                    etTurno.setText("1");
                    coint[0] =1;
                }
                if(btn9.getText().equals("X") || btn9.getText().equals("O")){
                    btn9.setEnabled(false);
                }

                smn(btn9,btn7,btn9,btnReinicio);
                smn(btn9,btn3,btn6,btnReinicio);
                smn(btn9,btn5,btn1,btnReinicio);
            }
        });

        btnReinicio.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {

                btn1.setText("");
                btn2.setText("");
                btn3.setText("");
                btn4.setText("");
                btn5.setText("");
                btn6.setText("");
                btn7.setText("");
                btn8.setText("");
                btn9.setText("");
                etTurno.setText("1");
                btn1.setEnabled(true);
                btn2.setEnabled(true);
                btn3.setEnabled(true);
                btn4.setEnabled(true);
                btn5.setEnabled(true);
                btn6.setEnabled(true);
                btn7.setEnabled(true);
                btn8.setEnabled(true);
                btn9.setEnabled(true);
                btn1.setTextColor(Color.GRAY);
                btn2.setTextColor(Color.GRAY);
                btn3.setTextColor(Color.GRAY);
                btn4.setTextColor(Color.GRAY);
                btn5.setTextColor(Color.GRAY);
                btn6.setTextColor(Color.GRAY);
                btn7.setTextColor(Color.GRAY);
                btn8.setTextColor(Color.GRAY);
                btn9.setTextColor(Color.GRAY);
                btnReinicio.setText("Reiniciar");

            }
        }




        );






    }

}
