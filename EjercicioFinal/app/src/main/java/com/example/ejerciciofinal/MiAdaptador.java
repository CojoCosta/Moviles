package com.example.ejerciciofinal;

import android.media.Image;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class MiAdaptador extends RecyclerView.Adapter<MiAdaptador.MyViewHolder> {
    ArrayList<Pelicula> peliculas;
    public MiAdaptador (ArrayList<Pelicula> peliculas){
        this.peliculas = peliculas;
    }
    int selectedPos = RecyclerView.NO_POSITION;
    public  int getSelectedPos(){
        return selectedPos;
    }
    public void setSelectedPos(int selectedPos){
        if (selectedPos == this.selectedPos){
            this.selectedPos = RecyclerView.NO_POSITION;
            notifyItemChanged(selectedPos);
        } else{
            if (this.selectedPos != RecyclerView.NO_POSITION){
                notifyItemChanged(selectedPos);
            } else{
                this.selectedPos = selectedPos;
                notifyItemChanged(selectedPos);
            }
        }
    }
    public class MyViewHolder extends RecyclerView.ViewHolder{
        TextView tvTitulo, tvDirector;
        ImageView imageView, imageViewPG;
        public MyViewHolder(View viewElemento){
            super(viewElemento);
            tvTitulo = viewElemento.findViewById(R.id.textView);
            tvDirector = viewElemento.findViewById(R.id.textView2);
            imageView = viewElemento.findViewById(R.id.imageView);
            imageViewPG = viewElemento.findViewById(R.id.imageView2);
        }
        public TextView obtenerTitulo(){
            return tvTitulo;
        }
        public TextView obtenerDirector(){
            return tvDirector;
        }
        public ImageView obtenerPortada(){
            return imageView;
        }
        public ImageView obtenerPG(){
            return imageViewPG;
        }
    }

    @NonNull
    @Override
    public MiAdaptador.MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View elemento = LayoutInflater.from(parent.getContext()).inflate(R.layout.celda, parent, false);
        MyViewHolder mvh = new MyViewHolder(elemento);
        return mvh;
    }
    //Añadir datos a cada celda
    @Override
    public void onBindViewHolder(@NonNull MiAdaptador.MyViewHolder holder, int position) {
        Pelicula peli = this.peliculas.get(position);
        holder.obtenerTitulo().setText(peli.getDirector());
        holder.obtenerDirector().setText(peli.getDirector());
        holder.obtenerPortada().setImageResource(peli.getPortada());
        holder.obtenerPG().setImageResource(peli.getClasi());
    }

    @Override
    public int getItemCount() {
        return 0;
    }
}
