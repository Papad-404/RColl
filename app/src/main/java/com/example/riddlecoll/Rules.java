package com.example.riddlecoll;

import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class Rules extends AppCompatActivity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.rules);
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        Intent rule = new Intent(Rules.this, MainActivity.class);
        startActivity(rule);
        finish();
    }
}
