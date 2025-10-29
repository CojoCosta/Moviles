package com.example.cambiardeactivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.activity.EdgeToEdge;
import androidx.activity.result.ActivityResult;
import androidx.activity.result.ActivityResultCallback;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {
    Button bt;
    int num;
    Intent intent;
    EditText ett;

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
        ActivityResultLauncher<Intent> launcher=registerForActivityResult(new ActivityResultContracts.StartActivityForResult(),new ActivityResultCallback<ActivityResult>() {
            @Override
            public void onActivityResult(ActivityResult result) {
                if(result.getResultCode() == RESULT_OK){
                    Intent obtenerDevolucion = result.getData();
                    int numEstrellas = (int)obtenerDevolucion.getFloatExtra("estrellas", 0);
                    switch (numEstrellas){
                        case 0:
                            Log.i("PRUEBA", "ME ENCUENTRO HORRIBLE");
                        break;
                        case 1:
                            Log.i("PRUEBA", "ME ENCUENTRO MUY MAL");
                        break;
                        case 2:
                            Log.i("PRUEBA","ME ENCUENTRO MAL");
                        break;
                        case 3:
                            Log.i("PRUEBA","ME ENCUENTRO NORMAL");
                        break;
                        case 4 :
                            Log.i("PRUEBA", "ME ENCUENTRO DECENTE");
                        break;
                        case 5 :
                            Log.i("PRUEBA", "ME ENCUENTRO BIEM");
                        break;
                    }
                }
            }
        });

        bt = findViewById(R.id.button);
        num = 5;
        ett = findViewById(R.id.eTT);
        bt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                intent = new Intent(MainActivity.this, Activity2.class);
                //intent.putExtra("numero", num);
                //intent.putExtra("texto", ett.getText().toString());
                //startActivity(intent);
                launcher.launch(intent);
            }
        });

    }
}