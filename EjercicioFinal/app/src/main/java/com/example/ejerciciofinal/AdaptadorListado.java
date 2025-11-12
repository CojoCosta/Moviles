package com.example.ejerciciofinal;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import java.util.ArrayList;

public class AdaptadorListado extends RecyclerView.Adapter<AdaptadorListado.MyViewHolder> {
    ArrayList<Pelicula> peliculas;
    Context contexto;
    public AdaptadorListado (ArrayList<Pelicula> peliculas, Context contexto){
        this.peliculas = peliculas;
        this.contexto = contexto;
    }
    int selectedPos = RecyclerView.NO_POSITION;
    public  int getSelectedPos(){
        return selectedPos;
    }
    public void setSelectedPos(int selectedPos) {
        if (selectedPos == this.selectedPos) {
            this.selectedPos = RecyclerView.NO_POSITION;
            notifyItemChanged(selectedPos);
        } else {
            if (this.selectedPos != RecyclerView.NO_POSITION) {
                notifyItemChanged(this.selectedPos);
            }
                this.selectedPos = selectedPos;
            notifyItemChanged(selectedPos);

        }
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View elemento = LayoutInflater.from(parent.getContext()).inflate(R.layout.celda2, parent, false);
        MyViewHolder mvh = new MyViewHolder(elemento);
        return mvh;
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        Pelicula p = this.peliculas.get(position);
        holder.getDirector().setText(p.getDirector());
        holder.getFecha().setText(p.getFecha() + "");
        holder.getDuracion().setText(p.getDuracion()+"");
        holder.getSala().setText(p.getSala());
        holder.getCaratula().setImageResource(p.getPortada());
        holder.getIvPg().setImageResource(p.getClasi());
        if (p.getFavorita()){
            holder.getIvFav().setImageResource(R.drawable.star);
        } else {
            holder.getIvFav().setImageResource(0);
        }
        if (selectedPos == position){
            holder.itemView.setBackgroundResource(R.color.naranja);
        } else{
            holder.itemView.setBackgroundResource(R.color.gris);
        }
    }

    public class MyViewHolder extends RecyclerView.ViewHolder{
        TextView director, fecha, duracion, sala;
        ImageView caratula, ivPg, ivFav;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            director = itemView.findViewById(R.id.director);
            fecha = itemView.findViewById(R.id.fecha);
            duracion = itemView.findViewById(R.id.duracion);
            sala = itemView.findViewById(R.id.sala);
            caratula = itemView.findViewById(R.id.ivCaratula);
            ivPg = itemView.findViewById(R.id.ivPg);
            ivFav = itemView.findViewById(R.id.ivFav);
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    int selectedPos = getAdapterPosition();
                    setSelectedPos(selectedPos);
                    Intent lanzaryoutube = new Intent(contexto, ActivityListado.class);

                }
            });
        }
        public TextView getDirector(){
            return director;
        }
        public TextView getFecha(){
            return fecha;
        }
        public TextView getDuracion(){
            return duracion;
        }
        public TextView getSala(){
            return sala;
        }
        public ImageView getCaratula(){
            return caratula;
        }
        public ImageView getIvPg(){
            return ivPg;
        }
        public ImageView getIvFav(){
            return ivFav;
        }

    }


    @Override
    public int getItemCount() {
        return this.peliculas.size();
    }

}
