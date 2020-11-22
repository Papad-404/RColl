package com.example.riddlecoll;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class Home extends AppCompatActivity {
    ImageButton logika, memori;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.home);

        logika = findViewById(R.id.gmbrlogi);
        logika.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(Home.this, HomeLogika.class));
            }
        });
        memori = findViewById(R.id.gmbrmemo);
        memori.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(Home.this, HomeMemori.class));
            }
        });
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        Intent home = new Intent(Home.this, MainActivity.class);
        startActivity(home);
    }
}
