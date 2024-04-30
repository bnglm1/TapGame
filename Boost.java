package com.example.d1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class Boost extends AppCompatActivity {

    Button b1, b2, b3, geri;
    TextView toplamScore;
    int score, scoreArt;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_boost);

        b1 = findViewById(R.id.boost1);
        b2 = findViewById(R.id.boost2);
        b3 = findViewById(R.id.boost3);
        geri = findViewById(R.id.geriTus);
        toplamScore = findViewById(R.id.txtScore);

        Intent intent = getIntent();
        if(intent != null && intent.hasExtra("score")) {
            score = intent.getIntExtra("score", 0);
            scoreArt = intent.getIntExtra("scoreArttir", 0);
            toplamScore.setText(" "+score);
        }

        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(score >= 120) {
                    Toast.makeText(Boost.this, "Satın Alma Başarılı", Toast.LENGTH_SHORT).show();
                    score -= 120;
                    scoreArt += 3;
                    toplamScore.setText(" "+score);
                }
            }
        });
        b2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(score >= 200) {
                    Toast.makeText(Boost.this, "Satın Alma Başarılı", Toast.LENGTH_SHORT).show();
                    score -= 200;
                    scoreArt += 5;
                    toplamScore.setText(" "+score);
                }
            }
        });
        b3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(score >= 300) {
                    Toast.makeText(Boost.this, "Satın Alma Başarılı", Toast.LENGTH_SHORT).show();
                    score -= 300;
                    scoreArt += 8;
                    toplamScore.setText(" "+score);
                }
            }
        });

        geri.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent geri = new Intent();
                geri.putExtra("remainingScore", score);
                geri.putExtra("artScore", scoreArt);
                setResult(RESULT_OK, geri); // Sonucu "OK" olarak ayarla

                finish(); // BoostActivity'yi kapat
            }
        });

    }
}