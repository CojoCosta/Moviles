package com.example.listview;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.view.menu.MenuBuilder;
import androidx.appcompat.widget.Toolbar;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    ListView listview;
    ArrayList<String> lista = new ArrayList<>();
    Toolbar tb;
    ArrayAdapter<String> adapter;

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
        listview = findViewById(R.id.listview);
        String[] contactos = new String[]{"ITALIANI", "HUGO", "PABLO", "CARRIL SUBNORMAL", "PARIENTA", "AATUVIEJA", "JUAN", "CURRO", "LUGONPA"};
        for (int i = 0; i < contactos.length; i++) {
            lista.add(contactos[i]);
        }
        tb = findViewById(R.id.toolbar);
        setSupportActionBar(tb);
        adapter = new ArrayAdapter<>(MainActivity.this, android.R.layout.simple_list_item_checked, lista);
        listview.setAdapter(adapter);
        listview.setChoiceMode(ListView.CHOICE_MODE_MULTIPLE);
        listview.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                adapter.notifyDataSetChanged();
            }
        });


    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater menuInflater = getMenuInflater();
        menuInflater.inflate(R.menu.menu, menu);
        return true;

    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        int id = item.getItemId();
        if (id == R.id.borrar) {
            for (int i = listview.getCount() -1 ; i >=0 ;i--) {
                if (listview.isItemChecked(i)){
                    lista.remove(i);
                }
            }
            listview.getCheckedItemPositions().clear();
            adapter.notifyDataSetChanged();
        }
        adapter.notifyDataSetChanged();
        return false;
    }

}