package com.example.riddlecoll;

import android.content.Intent;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class TanyaMemori extends AppCompatActivity {
    CountDownTimer timer;
    TextView mTextField;
    Button start;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.tanyamemo);

        mTextField = findViewById(R.id.time);
        start = findViewById(R.id.readyy);

        timer = new CountDownTimer(15000, 1000) {

            public void onTick(long millisUntilFinished) {
                mTextField.setText("Timer: " + millisUntilFinished / 1000);
            }

            public void onFinish() {
                Intent i = new Intent(TanyaMemori.this, SettingMemori.class);
                startActivity(i);
                finish();
            }
        }.start();

        start.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                timer.cancel();
                Intent i = new Intent(TanyaMemori.this, SettingMemori.class);
                startActivity(i);
                finish();
            }
        });
    }
}
