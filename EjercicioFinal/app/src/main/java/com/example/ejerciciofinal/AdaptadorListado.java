package com.example.ejerciciofinal;

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
    public AdaptadorListado (ArrayList<Pelicula> peliculas){
        this.peliculas = peliculas;
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
                notifyItemChanged(selectedPos);
            } else {
                this.selectedPos = selectedPos;
                notifyItemChanged(selectedPos);
            }
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
        holder.getDuracion().setText(p.getDuracion());
        holder.getSala().setText(p.getSala());
        holder.getCaratula().setImageResource(p.getPortada());
        holder.getIvPg().setImageResource(p.getClasi());
        if (p.getFavorita()){
            holder.getIvFav().setImageResource(R.drawable.iconofav);
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
