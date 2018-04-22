package com.example.dss22.a41threads;

import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    Button button,button2,button3;

    ProgressBar progressBar2,progressBar3;

    EditText editText2,editText3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        button = (Button) findViewById(R.id.button);
        button2 = (Button) findViewById(R.id.button2);
        button3 = (Button) findViewById(R.id.button3);

        progressBar2 = (ProgressBar) findViewById(R.id.progressBar2);
        progressBar3 = (ProgressBar) findViewById(R.id.progressBar3);

        editText2 = (EditText) findViewById(R.id.editText2);
        editText3 = (EditText) findViewById(R.id.editText3);

        button.setOnClickListener(this);
        button2.setOnClickListener(this);
        button3.setOnClickListener(this);

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
                for (int i = 1; i <= Integer.parseInt(editText2.getText().toString()); i++) {
                    UnSegundo();
                    progressBar2.setProgress(i);

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
            case R.id.button2:
                hilo();
                break;
            case R.id.button3:
                AsyncTarea aT = new AsyncTarea();
                aT.execute();
                break;
            default:
                break;
        }
    }

    private class  AsyncTarea extends AsyncTask<Void, Integer,Boolean> {
        @Override
        protected void onPreExecute() {
            super.onPreExecute();
        }

        @Override
        protected Boolean doInBackground(Void... params) {

            for (int i=1; i<= Integer.parseInt(editText3.getText().toString()); i++){
                UnSegundo();
                progressBar3.setProgress(i);

                if (isCancelled()){
                    break;
                }
            }
            return true;
        }


        @Override
        protected void onProgressUpdate(Integer... values) {
            super.onProgressUpdate(values);

            progressBar3.setProgress(values[0].intValue());
        }

        @Override
        protected void onPostExecute(Boolean aVoid) {

            if (aVoid){
                Toast.makeText(getApplicationContext(),"Tarea Finaliza AsyncTask "+progressBar3.getProgress()+"s",Toast.LENGTH_SHORT).show();
            }
        }


        @Override
        protected void onCancelled() {
            super.onCancelled();

        }


    }
}