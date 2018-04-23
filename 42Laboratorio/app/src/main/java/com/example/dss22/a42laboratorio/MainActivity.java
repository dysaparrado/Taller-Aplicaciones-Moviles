package com.example.dss22.a42laboratorio;

import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    Button button;


    EditText editText;
    TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        button = (Button) findViewById(R.id.button);

        editText = (EditText) findViewById(R.id.editText);
        textView = (TextView) findViewById(R.id.textView);

        button.setOnClickListener(this);


    }

    private void UnSegundo() {

        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }


    public void hilo() {

        new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 1; i <= Integer.parseInt(editText.getText().toString()); i++) {
                    UnSegundo();
                   // progressBar2.setProgress(i);

                }


            }
        }).start();

    }


    @Override
    public void onClick(View v) {

        switch (v.getId()) {

            case R.id.button:
                hilo();
                AsyncTarea aT1 = new AsyncTarea();
                aT1.execute();

                break;
            default:
                break;
        }
    }

    public static long fib(int n) {
        if (n <= 1) return n;
        else return fib(n-1) + fib(n-2);
    }


    private class  AsyncTarea extends AsyncTask<Void, Integer,Boolean> {
        @Override
        protected void onPreExecute() {
            super.onPreExecute();
        }

        @Override
        protected Boolean doInBackground(Void... params) {

            for (int i=1; i<= Integer.parseInt(editText.getText().toString()); i++){
                UnSegundo();
                    textView.setText(textView.getText().toString()+" "+fib(i));

                if (isCancelled()){
                    break;
                }
            }
            return true;
        }


        @Override
        protected void onProgressUpdate(Integer... values) {
            super.onProgressUpdate(values);

        }

        @Override
        protected void onPostExecute(Boolean aVoid) {

            if (aVoid){
                Toast.makeText(getApplicationContext(),"Serie Fibonacci hasta el "+editText.getText().toString(),Toast.LENGTH_SHORT).show();
            }
        }


        @Override
        protected void onCancelled() {
            super.onCancelled();

        }


    }
}

