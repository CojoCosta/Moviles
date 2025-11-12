package com.example.ejerciciofinal;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.util.ArrayList;

public class ListadoFavoritos extends AppCompatActivity {
    Toolbar tb;
    ListView listadoFav;
    ArrayList<Pelicula> peliculas;
    ActionBar ab;
    ArrayAdapter<Pelicula> adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_listado_favoritos);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        peliculas = Datos.rellenaPeliculas();
        tb = findViewById(R.id.toolbar3);
        listadoFav = findViewById(R.id.listadoFav);
        setSupportActionBar(tb);
        ab = getSupportActionBar();
        ab.setDisplayHomeAsUpEnabled(true);
        adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1,peliculas);
        listadoFav.setAdapter(adapter);
        listadoFav.setChoiceMode(ListView.CHOICE_MODE_MULTIPLE);

        listadoFav.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

            }
        });
    }
}