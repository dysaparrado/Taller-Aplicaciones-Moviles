package com.ejemplo.rcview2;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

public class RecyclerAdapter extends RecyclerView.Adapter<RecyclerAdapter.RecyclerViewHolder> {


    private String[] nombres;
    private  String[] carrera;
    private  String[] nc;

    public RecyclerAdapter(String[] nombres ,String[] carrera , String[] nc) {
        this.nombres = nombres;
        this.carrera = carrera;
        this.nc = nc;
    }



    @Override
    public RecyclerViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        //View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_layout,parent,false);
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_layout,null,false);
        //RecyclerViewHolder recyclerViewHolder = new RecyclerViewHolder(view);
        return new RecyclerViewHolder(view);
    }

    @Override
    public void onBindViewHolder(RecyclerViewHolder holder, int position) {
        holder.nombre.setText(nombres[position]);
        holder.carreras.setText(carrera[position]);
        holder.num.setText(nc[position]);
    }

    @Override
    public int getItemCount() {
        return nombres.length;

    }

    public static class RecyclerViewHolder extends RecyclerView.ViewHolder {
        TextView nombre,carreras,num;

        public RecyclerViewHolder(View itemView) {
            super(itemView);
            nombre = itemView.findViewById(R.id.alumno_id);
            carreras=itemView.findViewById(R.id.carrera_id);
            num = itemView.findViewById(R.id.nc_id);
        }
    }
}

