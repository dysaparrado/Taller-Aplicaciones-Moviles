package com.example.dss22.a224proyectoapp;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity3 extends AppCompatActivity {
    private Activity activity;
    private ArrayList<ItemALAC> list = new ArrayList<ItemALAC>();
    private ItemAdapter3 adapter;
    private RecyclerView recyclerView;
    private AlertDialog dialog;

    private static final String TAG = MainActivity3.class.getSimpleName();



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.item_list);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);


        TextView nc=(TextView) findViewById(R.id.nc);
        final TextView nombre=(TextView) findViewById(R.id.nombre);
        final TextView telefono=(TextView) findViewById(R.id.telefono);
        final TextView carrera=(TextView) findViewById(R.id.carrera);
        final TextView correo=(TextView) findViewById(R.id.correo);
        TextView btnEdit=(TextView) findViewById(R.id.btnEdit);
        TextView ac=(TextView) findViewById(R.id.ac);



        final Bundle datos = this.getIntent().getExtras();
        fetchRecords(datos.getInt("nc"));
        nc.setText("N° Ctrl: "+datos.getInt("nc"));
        nombre.setText("Nombre: "+datos.getString("nombre"));
        telefono.setText("Telefono: "+datos.getString("telefono"));
        carrera.setText("Carrera: "+datos.getString("carrera"));
        correo.setText("Correo: "+datos.getString("correo"));
        ac.setText("Total Creditos: "+creditos(datos.getInt("nc")));

        btnEdit.setOnClickListener(new View.OnClickListener() {


            @Override
            public void onClick(View view) {

                final int id = datos.getInt("nc");


                LayoutInflater layoutInflater = MainActivity3.this.getLayoutInflater();
                View view1 = layoutInflater.inflate(R.layout.activity_edit,null);

                final EditText input_lastname = (EditText) view1.findViewById(R.id.Lastname);
                final EditText input_firstname = (EditText) view1.findViewById(R.id.Firstname);
                final EditText input_middlename = (EditText) view1.findViewById(R.id.MiddleName);
                final EditText input_contact = (EditText) view1.findViewById(R.id.Contact);
                final Button btnSave = (Button) view1.findViewById(R.id.btnSave);


                AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity3.this);
                builder.setView(view1).setTitle("Editar Alumno").setNegativeButton("close", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {

                        dialog.dismiss();
                    }
                });

                final Functions functions = new Functions(MainActivity3.this);
                final Item _items = functions.getSingleItemAL(id);
                input_lastname.setText(_items.getNombre());
                input_firstname.setText(_items.getTelefono());
                input_middlename.setText(_items.getCarrera());
                input_contact.setText(_items.getCorreo());

                btnSave.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {

                        String lastname = input_lastname.getText().toString();
                        String firstname = input_firstname.getText().toString();
                        String middlename = input_middlename.getText().toString();
                        String contact = input_contact.getText().toString();

                        _items.setNombre(lastname);
                        _items.setTelefono(firstname);
                        _items.setCarrera(middlename);
                        _items.setCorreo(contact);

                        functions.UpdateAL(_items);

                        Toast.makeText(MainActivity3.this, lastname + " updated.", Toast.LENGTH_SHORT).show();
                        dialog.dismiss();

                        nombre.setText("Nombre: "+lastname);
                        telefono.setText("Telefono: "+firstname);
                        carrera.setText("Carrera: "+middlename);
                        correo.setText("Correo: "+contact);




                    }
                });
                dialog = builder.create();
                dialog.show();




            }
        });


    }


    // ----- Obtener todos los registros y pasarlos al RecyclerView
    public void fetchRecords(int idc) {

        recyclerView = (RecyclerView) findViewById(R.id.recyclerView);
        adapter = new ItemAdapter3(this,list);

        LinearLayoutManager layoutManager = new LinearLayoutManager(MainActivity3.this);
        layoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setAdapter(adapter);

        list.clear();

        Functions functions = new Functions(MainActivity3.this);

        ArrayList<ItemALAC> data = functions.getAcALAC(idc);



        int cre=0;
        if (data.size()>0){
            for (int i = 0; i<data.size(); i++){

                int id = data.get(i).getIdc();

                String fecha = data.get(i).getFecha();
                String nombrea = data.get(i).getNombrea();
                String creditos = String.valueOf(data.get(i).getCreditos());
                int cree=data.get(i).getCreditos();


                ItemALAC item = new ItemALAC();

                item.setIdc(id);
                item.setFecha(fecha);
                item.setNombrea(nombrea);
                item.setCreditos(Integer.parseInt(creditos));

                list.add(item);
                cre+=cree;

            }adapter.notifyDataSetChanged();

        }else {
            Toast.makeText(MainActivity3.this, "No Records found.", Toast.LENGTH_SHORT).show();
        }

    }

    public int creditos(int idc) {


        Functions functions = new Functions(MainActivity3.this);

        ArrayList<ItemALAC> data = functions.getAcALAC(idc);



        int cre=0;
        if (data.size()>0) {
            for (int i = 0; i < data.size(); i++) {

                int id = data.get(i).getIdc();

                String fecha = data.get(i).getFecha();
                String nombrea = data.get(i).getNombrea();
                String creditos = String.valueOf(data.get(i).getCreditos());
                int cree = data.get(i).getCreditos();

                cre += cree;
            }

        }
        return cre;

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.delete_all) {

            AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity3.this);
            builder.setTitle("You want to delete all records")
                    .setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialogInterface, int i) {

                            Functions functions = new Functions(MainActivity3.this);
                            functions.DeleteAll();

                            Toast.makeText(MainActivity3.this, "Delete Success.", Toast.LENGTH_SHORT).show();

                        }
                    }).setNegativeButton("No", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialogInterface, int i) {
                    dialog.dismiss();
                }
            });
            dialog = builder.create();
            dialog.show();


            return true;
        }

        if(id == R.id.navigation_home){
            Intent intent = new Intent (MainActivity3.this, MainActivity.class);
            startActivityForResult(intent, 0);

        }

        if(id == R.id.navigation_dashboard){
            Intent intent = new Intent (MainActivity3.this, MainActivity2.class);
            startActivityForResult(intent, 0);
        }

        return super.onOptionsItemSelected(item);
    }
}
