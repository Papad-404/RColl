package com.example.riddlecoll;

public class SoalLogika {

    public String[] image = {
            "riddle1",
            "riddles10",
            "riddle3",
            "riddle11",
            "riddle14",
            "riddles11",
            "riddle7",
            "riddles7",
            "riddles9",
            "riddles8",
    };

    private String[] jawabanBenar = {
            "Echo",
            "Alphabet",
            "Map",
            "Name",
            "Incorrectly",
            "Voice",
            "Silence",
            "Breath",
            "Trouble",
            "Handsome",
    };

    public String getStringGambar(int x){
        String gambar = image[x];
        return gambar;
    }

    public String getJawabanBenar(int x){
        String jawaban = jawabanBenar[x];
        return jawaban;
    }
}
