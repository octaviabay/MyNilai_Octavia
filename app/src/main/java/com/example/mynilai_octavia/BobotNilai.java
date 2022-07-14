package com.example.mynilai_octavia;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class BobotNilai extends AppCompatActivity {

    EditText nKdran, ntgs, nuts, nuas;

    Double hadir;
    Double tugas;
    Double uts;
    Double uas;
    Double nakhir;
    String grade;
    TextView tAkhir, nGrade;
    Button bHitung, Btnext2;

    String nim, nama, matkul;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bobot_nilai);

        String kehadiran = getIntent().getExtras().getString("kehadiran");
        matkul = getIntent().getExtras().getString("matkul");
        tugas = Double.valueOf(getIntent().getExtras().getString("tugas"));
        uts = Double.valueOf(getIntent().getExtras().getString("uts"));
        uas = Double.valueOf(getIntent().getExtras().getString("uas"));
        nim = getIntent().getExtras().getString("nim");
        nama = getIntent().getExtras().getString("nama");

        nKdran = findViewById(R.id.hadiran);
        nKdran.setText(kehadiran);

        ntgs = findViewById(R.id.nTugas);
        ntgs.setText(tugas.toString());

        nuts = findViewById(R.id.nlUTS);
        nuts.setText(uts.toString());

        nuas = findViewById(R.id.nlUAS);
        nuas.setText(uas.toString());

        tAkhir = findViewById(R.id.takhir);
        nGrade = findViewById(R.id.tgrade);
        bHitung = findViewById(R.id.btnHitung);
        Btnext2 = findViewById(R.id.next2);
        bHitung.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                hadir = Double.parseDouble(nKdran.getText().toString());
                tugas = Double.parseDouble(ntgs.getText().toString());
                uts = Double.parseDouble(nuts.getText().toString());
                uas = Double.parseDouble(nuas.getText().toString());

                nakhir = (hadir * 0.1) + (tugas * 0.3) + (uts * 0.3) + (uas * 0.3);

                if (nakhir >= 90 && nakhir <= 100) {
                    grade = "A";
                } else if (nakhir >= 80 && nakhir <= 89) {
                    grade = "B";
                } else if (nakhir >= 60 && nakhir <= 69) {
                    grade = "C";
                } else {
                    grade = "E";
                }

                tAkhir.setText("" + nakhir);
                nGrade.setText(" " + grade);
            }
        });
        Btnext2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(BobotNilai.this, HasilAkhir.class);
                i.putExtra("akhir", tAkhir.getText().toString());
                i.putExtra("grade", nGrade.getText().toString());
                i.putExtra("nim", nim);
                i.putExtra("nama", nama);
                i.putExtra("matkul", matkul);
                startActivity(i);
            }
        });
    }
}