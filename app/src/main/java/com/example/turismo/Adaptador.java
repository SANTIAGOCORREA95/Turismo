package com.example.turismo;

import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class Adaptador extends RecyclerView.Adapter<Adaptador.viewHolder> {

    ArrayList<Actividad_Turistica> listadeDatos;

    public Adaptador(ArrayList<Actividad_Turistica> listadeDatos) {
        this.listadeDatos = listadeDatos;
    }

    @NonNull
    @Override
    public Adaptador.viewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View vistaDelItemLista= LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_lista,parent,false);

        return new viewHolder(vistaDelItemLista);
    }

    @Override
    public void onBindViewHolder(@NonNull Adaptador.viewHolder holder, int position) {
        holder.actualizar(listadeDatos.get(position));
    }

    @Override
    public int getItemCount() {
        return listadeDatos.size();
    }

    public class viewHolder extends RecyclerView.ViewHolder {
        ImageView actividad;
        TextView nombre;
        TextView descripcion;

        public viewHolder(@NonNull View itemView) {
            super(itemView);
            actividad=itemView.findViewById(R.id.actividad);
            nombre=itemView.findViewById(R.id.nombre);
            //descripcion=itemView.findViewById(R.id.descripcion);
        }

        public void actualizar(Actividad_Turistica actividad_turistica) {
            actividad.setImageResource(actividad_turistica.getActividad());
            nombre.setText(actividad_turistica.getNombre());
            //descripcion.setText(actividad_turistica.getDescripcion());

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                    Intent intent = new Intent(itemView.getContext(),MainActivity.class);
                    intent.putExtra("datosActividades",actividad_turistica);
                    itemView.getContext().startActivity(intent);

                }
            });
        }
    }
}
