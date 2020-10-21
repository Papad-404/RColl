package com.example.riddlecoll;

public class SoalMemori {

    public String[] pertanyaan = {
            "Ada berapa orang yang memakai masker?",
            "Benda apa yang dipegang suster bermasker?",
            "Sepatu warna apa yang dikenakan oleh dokter berkacamata?",
    };

    //membuat array untuk pilihan jawaban
    private String[][] jawaban = {
            {"1","2","3","Tidak ada"},
            {"Pena","Papan Jalan","Stetoskop","Suntikan"},
            {"Coklat","Biru","Hitam","Putih"},
    };

    //membuat array untuk jawaban benar
    private String[] correctanswer = {
            "1",
            "Suntikan",
            "Hitam",
    };

    public String getPertanyaan(int x){
        String question = pertanyaan[x];
        return question;
    }

    public String getPilihanJawaban1(int x){
        String choice1 = jawaban[x][0];
        return choice1;
    }

    public String getPilihanJawaban2(int x){
        String choice2 = jawaban[x][1];
        return choice2;
    }

    public String getPilihanJawaban3(int x){
        String choice3 = jawaban[x][2];
        return choice3;
    }

    public String getPilihanJawaban4(int x){
        String choice4 = jawaban[x][3];
        return choice4;
    }

    public String getJawabanBenar(int x){
        String jawaban = correctanswer[x];
        return jawaban;
    }
}
