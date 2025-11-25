package com.example.ejerciciofinal;

import android.os.Bundle;
import android.view.MenuItem;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class RecyclerListado extends AppCompatActivity {
    ActionBar actionBar;
    RecyclerView rvListado;
    RecyclerView.LayoutManager miLayoutManagerListado;
    AdaptadorListado adaptadorListado;
    ArrayList<Pelicula> peliculas;
    Toolbar tb;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_recycler_listado);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        peliculas = Datos.rellenaPeliculas();
        tb = findViewById(R.id.toolbar2);
        rvListado = findViewById(R.id.recyclerListado);
        setSupportActionBar(tb);
        adaptadorListado = new AdaptadorListado(peliculas, this);
        miLayoutManagerListado = new GridLayoutManager(this, 1);
        rvListado.setLayoutManager(miLayoutManagerListado);
        rvListado.setAdapter(adaptadorListado);
        actionBar = getSupportActionBar();
        actionBar.setDisplayHomeAsUpEnabled(true);
    }
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                onBackPressed();
                return true;
        }
        return super.onOptionsItemSelected(item);
    }
}