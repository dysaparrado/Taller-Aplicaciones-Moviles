package com.example.dss22.sqlite;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import com.example.cabo.sqlite.R;

public class MainActivity extends AppCompatActivity {
    EditText usuario,contra;
    TextView vista;
    Button añadir,borrar,actualizar,mostrar;
    DB_Controller controller;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        usuario = findViewById(R.id.Usuario);
        contra = findViewById(R.id.Password);
        vista = findViewById(R.id.show);
        añadir = findViewById(R.id.añadir);
        borrar = findViewById(R.id.borrar);
        actualizar = findViewById(R.id.actualizar);
        mostrar = findViewById(R.id.mostrar);

        controller = new DB_Controller(this,"",null,1);


        añadir.setOnClickListener(new View.OnClickListener() {



                public void onClick (View v){

                controller.insertar_user(usuario.getText().toString(), contra.getText().toString());
        usuario.setText("");
        contra.setText("");
            }


        });

        borrar.setOnClickListener(new View.OnClickListener() {

            public void onClick(View v) {

                controller.borrar_user(usuario.getText().toString());
                usuario.setText("");
                contra.setText("");
            }
        });

        actualizar.setOnClickListener(new View.OnClickListener() {
            String txttemp;
            public void onClick(View v) {
                txttemp = contra.getText().toString();
                controller.actualizar(contra.getText().toString(),usuario.getText().toString());
                usuario.setText("");
                contra.setText("");
            }
        });

        mostrar.setOnClickListener(new View.OnClickListener() {

            public void onClick(View v) {

                controller.show_users(vista);
                usuario.setText("");
                contra.setText("");
            }
        });
    }
}


