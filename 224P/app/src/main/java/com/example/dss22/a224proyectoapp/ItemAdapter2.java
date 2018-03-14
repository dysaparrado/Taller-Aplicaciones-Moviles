package com.example.dss22.a224proyectoapp;


import android.app.Activity;
import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

/**
 * Created by lenovo on 07/03/2018.
 * Define RecyclerView.Adapter y RecyclerView.ViewHolder
 * Establece listener para los componentes
 */

public class ItemAdapter2 extends RecyclerView.Adapter<ItemAdapter2.MyViewHolder> {

    private Activity activity;
    private ArrayList<ItemAc> list;
    private AlertDialog dialog;

    public ItemAdapter2(Activity activity, ArrayList<ItemAc> list) {
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

        View itemView = nuevo.inflate(R.layout.item_list2,parent,false);


        return new MyViewHolder(itemView);
    }

    /*
    Vincula los datos con los datos con los elementos holder
     Establece listeners para los "botones" (que no son botones)

     */
    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {

        final ItemAc item = list.get(position);

        holder.nc.setText("ID: " + item.getIdc());
        holder.nombre.setText("Nombre: " + item.getNombrea());
        holder.creditos.setText("Creditos: " + item.getCreditos());


        holder.btnEdit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {


                final int id = item.getIdc();


                LayoutInflater layoutInflater = activity.getLayoutInflater();
                View view1 = layoutInflater.inflate(R.layout.activity_edit2,null);

                final EditText input_lastname = (EditText) view1.findViewById(R.id.nombrea);
                final EditText input_firstname = (EditText) view1.findViewById(R.id.telefono);
                final Button btnSave = (Button) view1.findViewById(R.id.btnSave);


                AlertDialog.Builder builder = new AlertDialog.Builder(activity);
                builder.setView(view1).setTitle("Edit Records").setNegativeButton("close", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {

                        dialog.dismiss();
                    }
                });

                final Functions functions = new Functions(activity);
                final ItemAc _items = functions.getSingleItemAC(id);
                input_lastname.setText(_items.getNombrea());
                input_firstname.setText(_items.getCreditos()+"");


                btnSave.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {

                        String lastname = input_lastname.getText().toString();
                        String firstname = input_firstname.getText().toString();

                        _items.setNombrea(lastname);
                        _items.setCreditos(Integer.parseInt(firstname));


                        functions.UpdateAC(_items);

                        Toast.makeText(activity, lastname + " updated.", Toast.LENGTH_SHORT).show();
                        ((MainActivity2)activity).fetchRecords();
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
        TextView creditos;


        TextView btnEdit;


        public MyViewHolder(View itemView) {
            super(itemView);


            nc = itemView.findViewById(R.id.idc);
            nombre = itemView.findViewById(R.id.nombre);
            creditos = itemView.findViewById(R.id.telefono);


            btnEdit = itemView.findViewById(R.id.btnEdit);


        }
    }
}
