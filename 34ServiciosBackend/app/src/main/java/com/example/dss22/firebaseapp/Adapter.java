package com.example.dss22.firebaseapp;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import java.util.List;


public class Adapter extends RecyclerView.Adapter<Adapter.AlumnoViewHolder> {

    List<Alumno> alumnos;

    public Adapter(List<Alumno> alumnos) {
        this.alumnos = alumnos;
    }

    @Override
    public AlumnoViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_list,parent,false);
        AlumnoViewHolder alumnoViewHolder = new AlumnoViewHolder(v);
        return alumnoViewHolder;
    }

    @Override
    public void onBindViewHolder(AlumnoViewHolder holder, int position) {

        holder.Nombre.setText(alumnos.get(position).getNombre());
        holder.NControl.setText(alumnos.get(position).getNocontrol());
    }

    @Override
    public int getItemCount() {
        return alumnos.size();
    }

    public class AlumnoViewHolder extends RecyclerView.ViewHolder{

        TextView Nombre,NControl;

        public AlumnoViewHolder(View itemView) {
            super(itemView);
            Nombre=itemView.findViewById(R.id.txtNombre);
            NControl=itemView.findViewById(R.id.txtNControl);
        }
    }
}
