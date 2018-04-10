package com.example.dss22.a331servicioswebalumnos;



import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;
import org.json.JSONException;
import org.json.JSONObject;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;

public class Adapter extends RecyclerView.Adapter<Adapter.ViewHolderDatos> implements ServerResponse{

    ArrayList<Item> list;
    Context context;
    Post conectar;



    public Adapter(ArrayList<Item> listDatos, Context context) {
        this.list = listDatos;
        this.context = context;

    }

    @Override
    public ViewHolderDatos onCreateViewHolder(ViewGroup parent, int viewType) {



        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_list, null, false);
        return new ViewHolderDatos(view);


    }

    @Override
    public void onBindViewHolder(final ViewHolderDatos holder, final int position) {
        holder.idAlumno.setText(list.get(position).getIdAlumno());
        holder.nombre.setText("Nombre: "+list.get(position).getNombre());
        holder.direccion.setText("Direccion: "+list.get(position).getDireccion());

        holder.btnAct.setOnClickListener(new View.OnClickListener() {


            @Override
            public void onClick(View view) {

                Intent intent = new Intent(context, ActualizarActivity.class);
                intent.putExtra("idAlumno", holder.idAlumno.getText().toString());
                intent.putExtra("nombre", list.get(position).getNombre());
                intent.putExtra("direccion", list.get(position).getDireccion());
                context.startActivity(intent);

            }

        });

        holder.btnEli.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                JSONObject datosAlumnos = new JSONObject();
                try {

                    conectar = new Post(Adapter.this);
                    datosAlumnos.put("idalumno", holder.idAlumno.getText().toString());

                    try {

                        conectar.getJSON(String.valueOf(datosAlumnos));
                        URL url = new URL("http://dsparra22.x10host.com/datos1/borrar_alumno.php");
                        conectar.execute(url);
                        list.remove(position);
                        notifyDataSetChanged();

                    } catch (MalformedURLException e) {
                        e.printStackTrace();
                    }
                } catch (JSONException e) {
                    e.printStackTrace();
                }

            }

        });

    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    @Override
    public void procesarRespuesta(String resp) {
        if (resp == null) {

        } else {
            try {

                JSONObject respuesta = new JSONObject(resp);
                if (respuesta.getInt("estado")==1) {
                    if (respuesta.getString("mensaje").equals("Eliminacion exitosa")) {
                        Toast.makeText(context, "Se elimino correctamente", Toast.LENGTH_SHORT).show();
                    }
                }

            } catch (JSONException e) {
                e.printStackTrace();
            }
        }
    }

    public class ViewHolderDatos extends RecyclerView.ViewHolder {
        TextView idAlumno, nombre, direccion, btnAct,btnEli;

        public ViewHolderDatos(View itemView) {
            super(itemView);

            idAlumno = itemView.findViewById(R.id.idAlumno);
            nombre = itemView.findViewById(R.id.idNombre);
            direccion = itemView.findViewById(R.id.idDireccion);
            btnAct = itemView.findViewById(R.id.btnAct);
            btnEli = itemView.findViewById(R.id.btnEli);
        }
    }
}