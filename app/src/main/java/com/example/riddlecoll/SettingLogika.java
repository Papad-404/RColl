package com.example.riddlecoll;

import android.content.Intent;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class SettingLogika extends AppCompatActivity {
    TextView mTextField;
    ImageView mivGambar;
    EditText medtJawaban;
    ImageButton mbtnSubmit2;
    CountDownTimer timer;
    int x=0;
    int arr;
    int skor;
    String jawaban;

    SoalLogika logika = new SoalLogika();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.soallogika);

        mTextField = findViewById(R.id.time);
        mivGambar = findViewById(R.id.ivGambar);
        medtJawaban = findViewById(R.id.edtJawaban);
        mbtnSubmit2 = findViewById(R.id.btnSubmit2);

        mbtnSubmit2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                cekJawaban();
            }
        });

        setKonten();
    }

    public void setKonten(){
        medtJawaban.setText(null);
        arr = logika.image.length;

        timer = new CountDownTimer(30000, 1000) {

            public void onTick(long millisUntilFinished) {
                mTextField.setText("Timer: " + millisUntilFinished / 1000);
            }

            public void onFinish() {
                cekJawaban();
            }
        };
        timer.start();

        if(x >= arr){
            String jumlahSkor = String.valueOf(skor);
            timer.cancel();
            Intent i = new Intent(SettingLogika.this, SkorLogika.class);
            i.putExtra("skorlogika",jumlahSkor);
            startActivity(i);
            finish();
        }else{
            ubahGambar();
            jawaban = logika.getJawabanBenar(x);
            timer.start();
        }
        x++;
    }


    public void ubahGambar(){
        Resources res = getResources();
        String mPhoto = logika.getStringGambar(x);
        int resID = res.getIdentifier(mPhoto, "drawable", getPackageName());
        Drawable drawable = res.getDrawable(resID);
        mivGambar.setImageDrawable(drawable);
    }

    public void cekJawaban(){
        if(!medtJawaban.getText().toString().isEmpty()){
            if(medtJawaban.getText().toString().equalsIgnoreCase(jawaban)){
                skor = skor + 10;
                Toast.makeText(this, "Correct!", Toast.LENGTH_SHORT).show();
                timer.cancel();
                setKonten();
            }else{
                Toast.makeText(this, "Wrong!", Toast.LENGTH_SHORT).show();
                timer.cancel();
                setKonten();
            }
        }else if (mbtnSubmit2.isPressed()){
            if (medtJawaban.getText().toString().isEmpty()) {
                Toast.makeText(this, "Wrong!", Toast.LENGTH_SHORT).show();
                timer.cancel();
                setKonten();
            }
        } else {
            Toast.makeText(this, "Time's Up", Toast.LENGTH_SHORT).show();
            timer.cancel();
            setKonten();
        }
    }

}
