package com.example.dss22.a224proyectoapp;


import android.app.Activity;
import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

/**
 * Created by lenovo on 07/03/2018.
 * Define RecyclerView.Adapter y RecyclerView.ViewHolder
 * Establece listener para los componentes
 */

public class ItemAdapter extends RecyclerView.Adapter<ItemAdapter.MyViewHolder> {

    private Activity activity;
    private ArrayList<Item> list;
    private AlertDialog dialog;

    public ItemAdapter(Activity activity, ArrayList<Item> list) {
        this.activity = activity;
        this.list = list;
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        // Referencia para almacenar el contexto
        Context context;
        context = parent.getContext();

        // Referencia para el inflater
        LayoutInflater nuevo;
        nuevo = LayoutInflater.from(context);

        View itemView = nuevo.inflate(R.layout.item_list4,parent,false);


        return new MyViewHolder(itemView);
    }

    /*
    Vincula los datos con los datos con los elementos holder
     Establece listeners para los "botones" (que no son botones)

     */
    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {

        final Item item = list.get(position);


        holder.nc.setText("N° Ctrl: " + item.getId());
        holder.nombre.setText("Nombre: " + item.getNombre());
       // holder.creditos.setText("Total Creditos: " + item.getCreditos());
        //holder.telefono.setText("Telefono: " + item.getTelefono());
        //holder.carrera.setText("Carrera: " + item.getCarrera());
        //holder.correo.setText("Correo:" + item.getCorreo());

        holder.btnEdit.setOnClickListener(new View.OnClickListener() {


            @Override
            public void onClick(View view) {

                final int id = item.getId();


               // LayoutInflater layoutInflater = activity.getLayoutInflater();
             //   View view1 = layoutInflater.inflate(R.layout.activity_edit,null);
/*
                final EditText input_lastname = (EditText) view1.findViewById(R.id.Lastname);
                final EditText input_firstname = (EditText) view1.findViewById(R.id.Firstname);
                final EditText input_middlename = (EditText) view1.findViewById(R.id.MiddleName);
                final EditText input_contact = (EditText) view1.findViewById(R.id.Contact);
               */

                //final Button btnSave = (Button) view1.findViewById(R.id.btnSave);


                //AlertDialog.Builder builder = new AlertDialog.Builder(activity);
                //builder.setView(view1).setTitle("Edit Records").setNegativeButton("close", new DialogInterface.OnClickListener() {
                  //  @Override
                   // public void onClick(DialogInterface dialogInterface, int i) {

                     //   dialog.dismiss();
                    //}
                //});

                final Functions functions = new Functions(activity);
                final Item _items = functions.getSingleItemAL(id);

                Intent ListSong = new Intent(activity.getApplicationContext(), MainActivity3.class);
                ListSong.putExtra("nc", _items.getId());
                ListSong.putExtra("nombre", _items.getNombre());
                ListSong.putExtra("telefono", _items.getTelefono());
                ListSong.putExtra("carrera", _items.getCarrera());
                ListSong.putExtra("correo", _items.getCorreo());

                activity.startActivity(ListSong);




            }
        });

        holder.btnAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                final int id = item.getIdc();
                final int idc = item.getId();


                LayoutInflater layoutInflater = activity.getLayoutInflater();
                View view1 = layoutInflater.inflate(R.layout.activity_add3,null);

                final Spinner input_lastname = (Spinner) view1.findViewById(R.id.actividades);
                final EditText input_firstname = (EditText) view1.findViewById(R.id.fecha);
                final Button btnSave = (Button) view1.findViewById(R.id.btnSave);


                AlertDialog.Builder builder = new AlertDialog.Builder(activity);
                builder.setView(view1).setTitle("Edit Records").setNegativeButton("close", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {

                        dialog.dismiss();
                    }
                });

                final Functions functions = new Functions(activity);
//                final ItemAc _items = functions.getSingleItemAC(id);

             //   input_lastname.setText(_items.getNombrea());
               // input_firstname.setText(_items.getCreditos()+"");

               final ItemALAC item = new ItemALAC();
              //  final ItemALAC _items = functions.getSingleALAC(id);
                input_lastname.setAdapter(functions.llenarSpinner(activity));




                btnSave.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {

                   //     String lastname = input_lastname.getText().toString();
                     String firstname = input_firstname.getText().toString();
                        String fecha = input_lastname.getSelectedItem().toString();
                        int cred=input_lastname.getSelectedItemPosition()+1;
                      //  _items.setNombrea(lastname);
                       // _items.setCreditos(Integer.parseInt(firstname));
                        item.setId(idc);
                        item.setIdc(id);

                        item.setNombrea(fecha);
                        item.setCreditos(cred);
                        item.setFecha(firstname);

                        functions.InsertALAC(item);

                      Toast.makeText(activity, firstname + " Agregada", Toast.LENGTH_SHORT).show();
                       // ((MainActivity2)activity).fetchRecords();
                        dialog.dismiss();
                    }
                });
                dialog = builder.create();
                dialog.show();

            }



        });
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder{

        TextView nc;
        TextView nombre;
        TextView telefono;
        TextView carrera;
        TextView correo;
      //  TextView creditos;

        TextView btnEdit;
        TextView btnAdd;


        public MyViewHolder(View itemView) {
            super(itemView);

            nc = itemView.findViewById(R.id.nc);
            nombre = itemView.findViewById(R.id.nombre);
       //    creditos = itemView.findViewById(R.id.credito);
           // telefono = itemView.findViewById(R.id.creditos);
           // carrera = itemView.findViewById(R.id.carrera);
            //correo = itemView.findViewById(R.id.correo);

            btnEdit = itemView.findViewById(R.id.btnEdit);
            btnAdd = itemView.findViewById(R.id.btnAdd);

        }
    }

    public int creditos(int idc) {


        Functions functions = new Functions(activity);

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
}
