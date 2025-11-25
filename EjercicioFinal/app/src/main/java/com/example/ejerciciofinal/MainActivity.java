package com.example.ejerciciofinal;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    Toolbar tb;
    RecyclerView rv;
    ActionBar ab;
    ImageButton btOcultar;
    RecyclerView.LayoutManager miLayoutManager;
    MiAdaptador miAdaptador;
    TextView tv;
    ArrayList<Pelicula> peliculas;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        peliculas = Datos.rellenaPeliculas();
        miAdaptador = new MiAdaptador(peliculas);
        miLayoutManager = new GridLayoutManager(this, 1);
        tb = findViewById(R.id.toolbar);
        rv = findViewById(R.id.recyclerView);
        tv = findViewById(R.id.textView3);
        rv.setLayoutManager(miLayoutManager);
        rv.setAdapter(miAdaptador);
        setSupportActionBar(tb);

        btOcultar = findViewById(R.id.imageButton);
        btOcultar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (ab.isShowing()){
                    ab.hide();
                    btOcultar.setImageResource(R.drawable.g);
                } else{
                    ab.show();
                    btOcultar.setImageResource(R.drawable.r);
                }
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater menuInflater = getMenuInflater();
        menuInflater.inflate(R.menu.menu, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        ab = getSupportActionBar();
        int id =item.getItemId();
        if (id == R.id.listado){
            Toast.makeText(this, "Listado", Toast.LENGTH_SHORT).show();
            Intent it = new Intent(MainActivity.this , RecyclerListado.class);
            startActivity(it);
        }else if(id == R.id.listaFavs){
            Intent fav = new Intent(MainActivity.this, ListadoFavoritos.class);
            fav.putExtra("pelis", peliculas);
            startActivity(fav);
            Toast.makeText(this, "Favoritas", Toast.LENGTH_SHORT).show();
        }else if (id == R.id.añadir){
            Toast.makeText(this, "Añadida", Toast.LENGTH_SHORT).show();
        }else if(id == R.id.mostrar){
            Toast.makeText(this, "Mostrar", Toast.LENGTH_SHORT).show();
        }else if (id == R.id.pelisFav){
            Toast.makeText(this, "Favoritas2", Toast.LENGTH_SHORT).show();
        }
        return super.onOptionsItemSelected(item);
    }
}