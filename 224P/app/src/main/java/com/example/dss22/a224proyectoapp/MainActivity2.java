package com.example.dss22.a224proyectoapp;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
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
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity2 extends AppCompatActivity {

    private static final String TAG = MainActivity2.class.getSimpleName();

    private ArrayList<ItemAc> list = new ArrayList<ItemAc>();
    private ItemAdapter2 adapter;
    private RecyclerView recyclerView;
    private AlertDialog dialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);


        fetchRecords();


        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                LayoutInflater inflater = getLayoutInflater();
                View mView1 = inflater.inflate(R.layout.activity_add2,null);

                final EditText input_nc = (EditText) mView1.findViewById(R.id.nc);
                final EditText input_nombre = (EditText) mView1.findViewById(R.id.nombrea);
                final EditText input_lastname = (EditText) mView1.findViewById(R.id.telefono);

                final Button btnSave = (Button) mView1.findViewById(R.id.btnSave);

                AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity2.this);
                builder.setView(mView1).setTitle("Agregar Actividad")
                        .setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialogInterface, int i) {

                                dialog.dismiss();
                            }
                        });

                btnSave.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {

                        String nc=input_nc.getText().toString();
                        String nombre = input_nombre.getText().toString();
                        String lastname = input_lastname.getText().toString();


                        if (lastname.equals("")  && nc.equals("")){
                            Snackbar.make(view,"Field incomplete",Snackbar.LENGTH_SHORT).show();

                        }else {
                            Save(nc,nombre,lastname);
                            dialog.dismiss();
                            Snackbar.make(view,"Saving",Snackbar.LENGTH_SHORT).show();
                        }
                    }
                });

                dialog = builder.create();
                dialog.show();
            }


        });



    }


    // ----- Obtener todos los registros y pasarlos al RecyclerView
    public void fetchRecords() {

        recyclerView = (RecyclerView) findViewById(R.id.recycler);
        adapter = new ItemAdapter2(this,list);

        LinearLayoutManager layoutManager = new LinearLayoutManager(MainActivity2.this);
        layoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setAdapter(adapter);

        list.clear();

        Functions functions = new Functions(MainActivity2.this);

        ArrayList<ItemAc> data = functions.getAllRecordsAC();

        if (data.size()>0){
            for (int i = 0; i<data.size(); i++){

                int id = data.get(i).getIdc();
                String lname = data.get(i).getNombrea();
                String fname = String.valueOf(data.get(i).getCreditos());


                ItemAc item = new ItemAc();

                item.setIdc(id);
                item.setNombrea(lname);
                item.setCreditos(Integer.parseInt(fname));

                list.add(item);

            }adapter.notifyDataSetChanged();

        }else {
            Toast.makeText(MainActivity2.this, "No Records found.", Toast.LENGTH_SHORT).show();
        }
    }

    private void Save(String nc,String nombre,String lastname) {


        Functions functions = new Functions(MainActivity2.this);
        ItemAc item = new ItemAc();

        item.setIdc(Integer.parseInt(nc));
        item.setNombrea(nombre);
        item.setCreditos(Integer.parseInt(lastname));

        functions.InsertAC(item);
        Toast.makeText(MainActivity2.this, "Saved...", Toast.LENGTH_SHORT).show();
        fetchRecords();
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

            AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity2.this);
            builder.setTitle("You want to delete all records")
                    .setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialogInterface, int i) {

                            Functions functions = new Functions(MainActivity2.this);
                            functions.DeleteAll();
                            fetchRecords();
                            Toast.makeText(MainActivity2.this, "Delete Success.", Toast.LENGTH_SHORT).show();

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
           Intent intent = new Intent (MainActivity2.this, MainActivity.class);
            startActivityForResult(intent, 0);
        }

        if(id == R.id.navigation_dashboard){
            //Intent intent = new Intent (MainActivity.this, MainAc.class);
            //startActivityForResult(intent, 0);
        }

        return super.onOptionsItemSelected(item);
    }
}
