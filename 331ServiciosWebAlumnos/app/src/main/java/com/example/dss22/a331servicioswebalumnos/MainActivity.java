package com.example.dss22.a331servicioswebalumnos;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
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

public class MainActivity extends AppCompatActivity implements ServerResponse {

    static RecyclerView recycler;
    Post conectar;
    EditText id, nombre, direccion;
    Button all, bid;
    private AlertDialog dialog;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        id = findViewById(R.id.txtId);

        all = findViewById(R.id.btnAll);
        bid = findViewById(R.id.btnID);
        recycler = findViewById(R.id.recyclerView);
        recycler.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false));
        recycler.setHasFixedSize(true);



        all.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Get process = new Get(MainActivity.this);
                process.execute();
            }
        });

        bid.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int n = Integer.parseInt(id.getText().toString());
                GetID process = new GetID(n, MainActivity.this);
                process.execute();
            }
        });

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);

        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                LayoutInflater inflater = getLayoutInflater();
                View mView1 = inflater.inflate(R.layout.actualizar,null);

                final EditText input_nc = (EditText) mView1.findViewById(R.id.updateNombre);
                final EditText input_lastname = (EditText) mView1.findViewById(R.id.updateDireccion);

                final Button btnSave = (Button) mView1.findViewById(R.id.btnActualizar);

                btnSave.setText("INSERTAR");

                AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);
                builder.setView(mView1).setTitle("Agregar Alumno")
                        .setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialogInterface, int i) {

                                dialog.dismiss();
                            }
                        });

                btnSave.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        JSONObject alumno = new JSONObject();
                        try {

                            conectar = new Post(MainActivity.this);
                            alumno.put("nombre", URLEncoder.encode(input_nc.getText().toString(), "utf-8"));
                            alumno.put("direccion", URLEncoder.encode(input_lastname.getText().toString(), "utf-8"));

                            try {

                                conectar.getJSON(String.valueOf(alumno));
                                URL url = new URL("http://dsparra22.x10host.com/datos1/insertar_alumno.php");
                                conectar.execute(url);

                            } catch (MalformedURLException e) {
                                e.printStackTrace();
                            }
                        } catch (JSONException e) {
                            e.printStackTrace();
                        } catch (UnsupportedEncodingException e) {
                            e.printStackTrace();
                        }




                            dialog.dismiss();
                            Snackbar.make(view,"Saving",Snackbar.LENGTH_SHORT).show();

                    }
                });

                dialog = builder.create();
                dialog.show();

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
                    if (respuesta.getString("mensaje").equals("Creacion correcta")) {
                        Toast.makeText(MainActivity.this, "Se inserto correctamente", Toast.LENGTH_SHORT).show();
                        nombre.setText("");
                        direccion.setText("");
                    }
                }

            } catch (JSONException e) {
                e.printStackTrace();
            }
        }
    }
}

