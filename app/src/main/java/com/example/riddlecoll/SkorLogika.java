package com.example.riddlecoll;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class SkorLogika extends AppCompatActivity {
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
                Intent a = new Intent(SkorLogika.this, Home.class);
                startActivity(a);
            }
        });
        mbtnretry.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                    Intent b = new Intent(SkorLogika.this, HomeLogika.class);
                    startActivity(b);
                }
        });
    }

    public void setSkor(){
        String skorLogika = getIntent().getStringExtra("skorlogika");
        mtvHasilAkhir.setText("SKOR : "+skorLogika);
    }
    @Override
    public void onBackPressed() {
        super.onBackPressed();
        Intent c = new Intent(SkorLogika.this, HomeLogika.class);
        startActivity(c);
    }
}
