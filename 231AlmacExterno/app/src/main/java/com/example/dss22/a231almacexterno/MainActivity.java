package com.example.dss22.a231almacexterno;


import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class MainActivity extends AppCompatActivity {
    EditText textBox;
    static final int READ_BLOCK_SIZE = 100;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        textBox = (EditText) findViewById(R.id.editText);
    }

    public void onClickSave(View view) {
        File myFile = new File("/sdcard/myfile.txt");

        String str = textBox.getText().toString();
        try {
            myFile.createNewFile();
            FileOutputStream fOut = new FileOutputStream(myFile);
            OutputStreamWriter osw = new OutputStreamWriter(fOut);
            osw.append(str);
            osw.close();
            //---write the string to the file---
            fOut.close();
            Toast.makeText(view.getContext(),"Guadado con Exito!!", Toast.LENGTH_LONG).show();

            try {
                osw.write(str);
            } catch (IOException e) {
                e.printStackTrace();
            }

            textBox.setText("");
        } catch (IOException ioe) {
            ioe.printStackTrace();
        }
    }

    public void onClickLoad(View view) {
        File myFile = new File("/sdcard/myfile.txt");
        try{
            FileInputStream fileInputStream = new FileInputStream(myFile);
            BufferedReader myReader = new BufferedReader( new InputStreamReader(fileInputStream));
            String a = "";
            String b="";
            while((a = myReader.readLine())!=null){
                b +=a;
            }

            myReader.close();
            textBox.setText(b);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}



