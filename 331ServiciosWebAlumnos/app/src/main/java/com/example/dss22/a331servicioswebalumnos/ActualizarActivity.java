package com.example.dss22.a331servicioswebalumnos;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.UnsupportedEncodingException;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLEncoder;

public class ActualizarActivity extends AppCompatActivity implements ServerResponse{

    EditText txtnombre,txtdireccion;
    String idAlumno,nombre,direccion;
    Button actualizar;
    Post conectar;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.actualizar);

        txtnombre=findViewById(R.id.updateNombre);
        txtdireccion=findViewById(R.id.updateDireccion);
        actualizar=findViewById(R.id.btnActualizar);

        if(getIntent().hasExtra("idAlumno")&&getIntent().hasExtra("nombre")&&getIntent().hasExtra("direccion")){
            idAlumno=getIntent().getStringExtra("idAlumno");
            nombre=getIntent().getStringExtra("nombre");
            direccion=getIntent().getStringExtra("direccion");
        }

        txtnombre.setText(nombre);
        txtdireccion.setText(direccion);

        actualizar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                JSONObject alumno = new JSONObject();
                try {

                    conectar = new Post(ActualizarActivity.this);
                    alumno.put("idalumno",idAlumno);
                    alumno.put("nombre", URLEncoder.encode(txtnombre.getText().toString(), "utf-8"));
                    alumno.put("direccion", URLEncoder.encode(txtdireccion.getText().toString(), "utf-8"));

                    try {

                        conectar.getJSON(String.valueOf(alumno));
                        URL url = new URL("http://dsparra22.x10host.com/datos1/actualizar_alumno.php");
                        conectar.execute(url);

                    } catch (MalformedURLException e) {
                        e.printStackTrace();
                    }
                } catch (JSONException e) {
                    e.printStackTrace();
                } catch (UnsupportedEncodingException e) {
                    e.printStackTrace();
                }

                Intent intent = new Intent (view.getContext(), MainActivity.class);
                startActivityForResult(intent, 0);
            }
        });
    }

    @Override
    public void procesarRespuesta(String resp) {
        if (resp == null) {

        } else {
            try {

                JSONObject respuesta = new JSONObject(resp);
                if (respuesta.getInt("estado")==1) {
                    if (respuesta.getString("mensaje").equals("Actualizacion correcta")) {
                        Toast.makeText(ActualizarActivity.this, "Datos actualizados correctamente", Toast.LENGTH_SHORT).show();
                        finish();
                    }
                }

            } catch (JSONException e) {
                e.printStackTrace();
            }
        }
    }
}
