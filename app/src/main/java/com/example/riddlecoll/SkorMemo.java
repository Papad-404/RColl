package com.example.riddlecoll;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class SkorMemo extends AppCompatActivity {
    TextView mtvHasilAkhir;
    Button mbtnMenu, mbtnretry;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.scoring);

        mtvHasilAkhir = (TextView) findViewById(R.id.tvSkorAkhir);
        mbtnMenu = (Button) findViewById(R.id.btnMenu);
        mbtnretry = findViewById(R.id.btnretry);

        setSkor();

        mbtnMenu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(SkorMemo.this, Home.class);
                startActivity(i);
                finish();
            }
        });
        mbtnretry.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent a = new Intent(SkorMemo.this, HomeMemori.class);
                startActivity(a);
                finish();
            }
        });
    }

    public void setSkor(){
        String skorMemori = getIntent().getStringExtra("skormemori");
        mtvHasilAkhir.setText("SKOR : "+skorMemori);
    }
}
