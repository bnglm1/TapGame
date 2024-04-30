package com.example.d1;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.content.Intent;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    Button btn, bst, upGrade;
    TextView txt;
    TextView txt2;

    int score = 0;
    int scoreInc = 1;
    int upgrade = 10;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btn = findViewById(R.id.button);
        txt = findViewById(R.id.textView);
        txt2 = findViewById(R.id.textView2);
        bst = findViewById(R.id.boostSayfa);
        upGrade = findViewById(R.id.upg);

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                score += scoreInc;
                txt.setText(" "+score);
                txt2.setText("+ "+scoreInc);
            }
        });

        upGrade.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (score >= upgrade) {
                    score -= upgrade;
                    scoreInc++;
                    upgrade *= 2;
                    txt.setText(" "+score);
                    txt2.setText("+ "+scoreInc);
                }
                else {
                    Toast.makeText(MainActivity.this, "Yeterli Puanınız Yok", Toast.LENGTH_SHORT).show();
                }
            }
        });

        bst.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, Boost.class);
                intent.putExtra("score", score);
                intent.putExtra("scoreArttir", scoreInc);
                startActivityForResult(intent, 1);
            }
        });
    }
    public void setScoreInc(int yeniArtisMiktarı) {
        scoreInc = yeniArtisMiktarı;
    }
    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (requestCode == 1 && resultCode == RESULT_OK) { // BoostActivity'den gelen sonucu kontrol et
            int remainingScore = data.getIntExtra("remainingScore", 0);
            int sonInc = data.getIntExtra("artScore", 0);
            txt.setText(" " + remainingScore);
            txt2.setText("+ "+sonInc);
            score = remainingScore;
            scoreInc = sonInc;
        }
    }
}