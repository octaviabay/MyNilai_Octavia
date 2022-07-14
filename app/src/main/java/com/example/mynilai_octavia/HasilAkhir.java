package com.example.mynilai_octavia;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.EditText;
import android.widget.TextView;


public class HasilAkhir extends AppCompatActivity {

    EditText Enim, Enama, nakhir, gnilai;
    TextView tvMatkul;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hasil_akhir);

        Enim = findViewById(R.id.dnim);
        Enama = findViewById(R.id.dnama);
        nakhir = findViewById(R.id.dAkhir);
        gnilai = findViewById(R.id.dGrade);

        String akhir = getIntent().getExtras().getString("akhir");
        String grade = getIntent().getExtras().getString("grade");

        String matkul = getIntent().getExtras().getString("matkul");
        tvMatkul = findViewById(R.id.tvMatkul);
        tvMatkul.setText(matkul);

        nakhir.findViewById(R.id.dAkhir);
        nakhir.setText(akhir);

        gnilai.findViewById(R.id.dGrade);
        gnilai.setText(grade);

        String nim = getIntent().getExtras().getString("nim");
        String nama = getIntent().getExtras().getString("nama");

        Enim.findViewById(R.id.dnim);
        Enim.setText(nim);

        Enama.findViewById(R.id.dnama);
        Enama.setText(nama);
    }
}