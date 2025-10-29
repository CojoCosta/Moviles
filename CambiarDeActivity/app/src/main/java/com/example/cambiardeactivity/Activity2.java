package com.example.cambiardeactivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RatingBar;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class Activity2 extends AppCompatActivity {
    Intent intent2;
    TextView tv;
    Button bt2;
    RatingBar rb;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_2);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        intent2 = getIntent();
        tv = findViewById(R.id.textView);
        tv.setText(intent2.getIntExtra("numero", 0) + "");
        tv.setText("HOLA "+ intent2.getStringExtra("texto"));

        bt2 = findViewById(R.id.button2);
        rb = findViewById(R.id.ratingBar);
        bt2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent enviarInfo = new Intent();
                enviarInfo.putExtra("estrellas", rb.getRating());
                setResult(RESULT_OK, enviarInfo);
                finish();
            }
        });
    }
}