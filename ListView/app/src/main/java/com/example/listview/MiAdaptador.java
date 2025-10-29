package com.example.listview;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class MiAdaptador extends  RecyclerView.Adapter<MiAdaptador.MyViewHolder>{
    ArrayList<SistemaOperativo> sistemasOperativos;
    public MiAdaptador(ArrayList<SistemaOperativo> sistemasOperativos) {
        this.sistemasOperativos = sistemasOperativos;
    }

    int selectedPos = RecyclerView.NO_POSITION;

    public int getSelectedPos(){
        return selectedPos;
    }
    public void setSelectedPos(int nuevaPos) {
        if (nuevaPos == selectedPos) {
            selectedPos = RecyclerView.NO_POSITION;
            notifyItemChanged(nuevaPos);
        } else {
            if (selectedPos != RecyclerView.NO_POSITION){
                notifyItemChanged(selectedPos);
            }
            selectedPos = nuevaPos;
            notifyItemChanged(nuevaPos);
        }
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View elemento= LayoutInflater.from(parent.getContext()).inflate(R.layout.celda, parent, false);
        MyViewHolder mvh = new MyViewHolder(elemento);
        return mvh ;
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        SistemaOperativo so = this.sistemasOperativos.get(position);
        holder.obtenerTvNombre().setText(so.getNombre());
        holder.obtenerTvEdad().setText(so.getAno()+"");
        holder.obtenerimlogo().setImageResource(so.getLogo());
        if (selectedPos == position){
            holder.itemView.setBackgroundResource(R.color.colorseleccionado);
        }else {
            holder.itemView.setBackgroundResource(R.color.colorcelda);
        }
    }

    @Override
    public int getItemCount() {
        return this.sistemasOperativos.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder{
        TextView tvNombre, tvEdad;
        ImageView imlogo;
        public MyViewHolder(View viewElemento){
            super(viewElemento);
            this.tvNombre = viewElemento.findViewById(R.id.textViewNombre);
            this.tvEdad = viewElemento.findViewById(R.id.textViewYear);
            this.imlogo = viewElemento.findViewById(R.id.imageView);
            viewElemento.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    int posPulsada = getAdapterPosition();
                    setSelectedPos(posPulsada);
                    Toast.makeText(v.getContext(), sistemasOperativos.get(posPulsada).getNombre(), Toast.LENGTH_SHORT).show();
                }
            });
        }
        public TextView obtenerTvNombre(){
            return tvNombre;
        }
        public TextView obtenerTvEdad(){
            return tvEdad;
        }
        public ImageView obtenerimlogo(){
            return imlogo;
        }
    }
    
}