package com.example.dss22.a224proyectoapp;


import android.app.Activity;
import android.app.AlertDialog;
import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by lenovo on 07/03/2018.
 * Define RecyclerView.Adapter y RecyclerView.ViewHolder
 * Establece listener para los componentes
 */

public class ItemAdapter3 extends RecyclerView.Adapter<ItemAdapter3.MyViewHolder> {

    private Activity activity;
    private ArrayList<ItemALAC> list;
    private AlertDialog dialog;

    public ItemAdapter3(Activity activity, ArrayList<ItemALAC> list) {
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

        View itemView = nuevo.inflate(R.layout.item_list5,parent,false);


        return new MyViewHolder(itemView);
    }

    /*
    Vincula los datos con los datos con los elementos holder
     Establece listeners para los "botones" (que no son botones)

     */
    @Override
    public void onBindViewHolder(final MyViewHolder holder, int position) {

        final ItemALAC item = list.get(position);

        holder.fecha.setText("Fecha: " + item.getFecha());
        holder.nombrea.setText("Nombre: " + item.getNombrea());
        holder.creditos.setText("Creditos: " + item.getCreditos());


        holder.btnEdit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
/*
                final int id = item.getIdc();
                final int idc = item.getId();


                LayoutInflater layoutInflater = activity.getLayoutInflater();
                View view1 = layoutInflater.inflate(R.layout.activity_add3,null);

                final android.widget.Spinner input_lastname = (android.widget.Spinner) view1.findViewById(R.id.actividades);
                final EditText input_firstname = (EditText) view1.findViewById(R.id.fecha);
                final Button btnSave = (Button) view1.findViewById(R.id.btnSave);


                AlertDialog.Builder builder = new AlertDialog.Builder(activity);
                builder.setView(view1).setTitle("Editar Actividad Asignada").setNegativeButton("close", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {

                        dialog.dismiss();
                    }
                });

                final Functions functions = new Functions(activity);
                final ItemALAC _items = functions.getSingleALAC(id);



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
                        ;

                        item.setNombrea(fecha);
                        item.setCreditos(cred);
                        item.setFecha(firstname);

                        functions.UpdateALAC(item);

                        Toast.makeText(activity, firstname + " Actualizada", Toast.LENGTH_SHORT).show();
                         ((MainActivity3)activity).fetchRecords(id);
                        ((MainActivity3)activity).creditos(id);
                        dialog.dismiss();
                    }
                });
                dialog = builder.create();
                dialog.show();
*/
            }



        });


    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder{

        TextView fecha;
        TextView nombrea;
        TextView creditos;


        TextView btnEdit;


        public MyViewHolder(View itemView) {
            super(itemView);


            fecha = itemView.findViewById(R.id.idc);
            nombrea = itemView.findViewById(R.id.nombre);
            creditos = itemView.findViewById(R.id.telefono);


            btnEdit = itemView.findViewById(R.id.btnEdit);


        }
    }
}
