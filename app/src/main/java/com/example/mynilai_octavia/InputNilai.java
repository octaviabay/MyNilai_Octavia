package com.example.mynilai_octavia;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class InputNilai extends AppCompatActivity {
    EditText nim, nama, kehadiran, tugas, uts, uas;
    Button Bsubmit;
    String matkul;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_input_nilai);

        matkul = getIntent().getExtras().getString("matkul");
        nim = findViewById(R.id.nim);
        nama = findViewById(R.id.Nama);
        kehadiran = findViewById(R.id.Kehadiran);
        tugas = findViewById(R.id.Tugas);
        uts = findViewById(R.id.UTS);
        uas = findViewById(R.id.UAS);

        Bsubmit = findViewById(R.id.submit);
        Bsubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i =new Intent(InputNilai.this, BobotNilai.class);
                i.putExtra( "kehadiran", kehadiran.getText().toString());
                i.putExtra("tugas", tugas.getText().toString());
                i.putExtra("uts", uts.getText().toString());
                i.putExtra("uas", uas.getText().toString());
                i.putExtra("nama", nama.getText().toString());
                i.putExtra("nim", nim.getText().toString());
                i.putExtra("matkul", matkul);startActivity(i);
            }
        });
    }
}