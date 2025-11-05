package com.example.ejerciciofinal;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.PointerIcon;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.recyclerview.widget.RecyclerView;

public class MainActivity extends AppCompatActivity {
    Toolbar tb;
    RecyclerView rv;
    ActionBar ab;
    Button btOcultar;
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
        tb = findViewById(R.id.toolbar);
        rv = findViewById(R.id.recyclerView);
        btOcultar = findViewById(R.id.button);
        setSupportActionBar(tb);
        btOcultar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

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
                return true;
            }else if(id == R.id.listaFavs){
                Toast.makeText(this, "Favoritas", Toast.LENGTH_SHORT).show();
                return true;
            }else if (id == R.id.añadir){
                Toast.makeText(this, "Añadida", Toast.LENGTH_SHORT).show();
                return true;
            }else if(id == R.id.mostrar){
                Toast.makeText(this, "Mostrar", Toast.LENGTH_SHORT).show();
                return true;
            }else if (id == R.id.pelisFav){
                Toast.makeText(this, "Favoritas2", Toast.LENGTH_SHORT).show();
                return true;
            }


        return super.onOptionsItemSelected(item);
    }

}