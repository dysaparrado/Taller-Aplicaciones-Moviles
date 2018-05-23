package com.example.dss22.a58calllog;

import android.database.Cursor;
import android.net.Uri;
import android.provider.CallLog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import static android.provider.CallLog.CONTENT_URI;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class MainActivity extends AppCompatActivity {

    TextView txt;
    Button insertar;
    DatabaseReference mDatabase;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mDatabase=FirebaseDatabase.getInstance().getReference();
        insertar=(Button)findViewById(R.id.button);
        txt=(TextView)findViewById(R.id.txt);

        insertar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Cursor c=getCallLog();

                while (c.moveToNext()){
                    String id =mDatabase.push().getKey();

                    String tipo = c.getString(0);
                    String nombre = c.getString(1);
                    String numero = c.getString(2);
                    String duracion = c.getString(3);


                    Llamada call = new Llamada(tipo,nombre,numero,duracion);

                    mDatabase.child("Llamada").child(id).setValue(call);
                }




                Toast.makeText( MainActivity.this,"Guardado",Toast.LENGTH_LONG).show();
            }
        });

        Cursor c=getCallLog();
        String cad="";
        while (c.moveToNext()){
            cad+="ID: "+c.getString(1)+"\nTipo: "+c.getString(0)+"\nNumero: "+c.getString(2)+"\nDuracion: "+c.getString(3)+" Segundos "+"\n \n \n";
        }
        txt.setText(cad);
    }

    public Cursor getCallLog(){
        Uri uri=Uri.parse("content://call_log/calls");
        return getContentResolver().query(
                uri,//URI
                /*Proyecion*/  new String[]{CallLog.Calls.TYPE, CallLog.Calls._ID, CallLog.Calls.NUMBER,CallLog.Calls.DURATION},
                /*Where*/      null,
                null,
                /*Order*/      null
        );
    }
}