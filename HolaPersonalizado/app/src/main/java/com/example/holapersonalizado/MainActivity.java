package com.example.holapersonalizado;

import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    Button bt;
    TextView tv1;
    TextView tv2;
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
        bt = findViewById(R.id.bt);
        tv1 = findViewById(R.id.tv1);
        tv2 = findViewById(R.id.tv2);
        ett = findViewById(R.id.ett);
        bt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                tv2.setText(ett.getText());
                String texto = String.valueOf(ett.getText());
                if (texto.contains("a")) {
                    Toast toast = Toast.makeText(getApplicationContext(), "Escribiste una a",
                            Toast.LENGTH_LONG);
                    toast.show();
                }
            }
        });
        RadioGroup radioGroup = (RadioGroup) findViewById(R.id.radioGroup);
        radioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                RadioButton rbBlanco = (RadioButton) findViewById(R.id.radioButtonB);
                RadioButton rbVerde = (RadioButton) findViewById(R.id.radioButtonV);
                RadioButton rbAzul = (RadioButton) findViewById(R.id.radioButtonA);
                RadioButton rbRojo = (RadioButton) findViewById(R.id.radioButtonR);
                if (rbBlanco.isChecked()) {
                    getWindow().getDecorView().setBackgroundColor(Color.WHITE);
                } else if (rbVerde.isChecked()) {
                    getWindow().getDecorView().setBackgroundColor(Color.GREEN);
                } else if (rbAzul.isChecked()) {
                    getWindow().getDecorView().setBackgroundColor(Color.BLUE);
                } else if (rbRojo.isChecked()) {
                    getWindow().getDecorView().setBackgroundColor(Color.RED);
                }}
            });
        }

    }

