package com.example.riddlecoll;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class SettingMemori extends AppCompatActivity {
    TextView mtvSoal;
    RadioGroup mrgPilihanJawaban;
    RadioButton mrbPilihanJawaban1, mrbPilihanJawaban2, mrbPilihanJawaban3, mrbPilihanJawaban4;
    Button mbtnSubmit;
    int skor=0;
    int arr;
    int x;
    String jawaban;

    SoalMemori memori = new SoalMemori();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.soalmemori);

        mtvSoal = findViewById(R.id.tvSoal);
        mrgPilihanJawaban = (RadioGroup) findViewById(R.id.rgPilihanJawaban);
        mrbPilihanJawaban1 = (RadioButton) findViewById(R.id.rbPilihanJawaban1);
        mrbPilihanJawaban2 = (RadioButton) findViewById(R.id.rbPilihanJawaban2);
        mrbPilihanJawaban3 = (RadioButton) findViewById(R.id.rbPilihanJawaban3);
        mrbPilihanJawaban4 = findViewById(R.id.rbPilihanJawaban4);
        mbtnSubmit = (Button) findViewById(R.id.btnSubmit);

        setKonten();

        mbtnSubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                cekJawaban();
            }
        });
    }

    public void setKonten(){
        mrgPilihanJawaban.clearCheck();
        arr = memori.pertanyaan.length;
        if(x >= arr){
            String jumlahSkor = String.valueOf(skor);
            Intent i = new Intent(SettingMemori.this, SkorMemo.class);
            i.putExtra("skormemori",jumlahSkor);
            startActivity(i);
        }else{
            mtvSoal.setText(memori.getPertanyaan(x));
            mrbPilihanJawaban1.setText(memori.getPilihanJawaban1(x));
            mrbPilihanJawaban2.setText(memori.getPilihanJawaban2(x));
            mrbPilihanJawaban3.setText(memori.getPilihanJawaban3(x));
            mrbPilihanJawaban4.setText(memori.getPilihanJawaban4(x));
            jawaban = memori.getJawabanBenar(x);
        }
        x++;
    }

    public void cekJawaban(){
        if(mrbPilihanJawaban1.isChecked()){
            if(mrbPilihanJawaban1.getText().toString().equals(jawaban)){
                skor = skor + 10;
                Toast.makeText(this, "Correct", Toast.LENGTH_SHORT).show();
                setKonten();
            }else{
                Toast.makeText(this, "Wrong!", Toast.LENGTH_SHORT).show();
                setKonten();
            }
        }else if(mrbPilihanJawaban2.isChecked()){
            if(mrbPilihanJawaban2.getText().toString().equals(jawaban)){
                skor = skor + 10;
                Toast.makeText(this, "Correct", Toast.LENGTH_SHORT).show();
                setKonten(); //update next konten
            }else{
                Toast.makeText(this, "Wrong!", Toast.LENGTH_SHORT).show();
                setKonten();
            }
        }else if(mrbPilihanJawaban3.isChecked()){
            if(mrbPilihanJawaban3.getText().toString().equals(jawaban)){
                skor = skor + 10;
                Toast.makeText(this, "Correct", Toast.LENGTH_SHORT).show();
                setKonten(); //update next konten
            }else{
                Toast.makeText(this, "Wrong!", Toast.LENGTH_SHORT).show();
                setKonten();
            }
        }else if(mrbPilihanJawaban4.isChecked()){
            if(mrbPilihanJawaban4.getText().toString().equals(jawaban)){
                skor = skor + 10;
                Toast.makeText(this, "Correct!", Toast.LENGTH_SHORT).show();
                setKonten();
            }else{
                Toast.makeText(this, "Wrong!", Toast.LENGTH_SHORT).show();
                setKonten();
            }
        }
    }
}
