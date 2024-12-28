package com.example.quizapp;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class ResultActivity3 extends AppCompatActivity {

    TextView tv, tv2, tv3;
    Button btnRestart;
    TextView percentage;
    TextView resultText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_result2);

        tv = (TextView) findViewById(R.id.tvres);
        tv2 = (TextView) findViewById(R.id.tvres2);
        tv3 = (TextView) findViewById(R.id.tvres3);

        btnRestart = (Button) findViewById(R.id.btnRestart);
        resultText = findViewById(R.id.resulttext);

        StringBuffer sb = new StringBuffer();
        sb.append("Correct answer :" + QuestionActivity3.correct + "\n");

        StringBuffer sb2 = new StringBuffer();
        sb2.append("Wrong answer :" + QuestionActivity3.wrong + "\n");

        StringBuffer sb3 = new StringBuffer();
        sb3.append("Final score :" + QuestionActivity3.correct + "\n");

        StringBuffer sb4 = new StringBuffer();
        sb4.append(QuestionActivity3.correct + "/" + "5");

        tv.setText(sb);
        tv2.setText(sb2);
        tv3.setText(sb3);
        resultText.setText(sb4);

        QuestionActivity3.correct = 0;
        QuestionActivity3.wrong = 0;

        btnRestart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(ResultActivity3.this, MainActivity.class);
                startActivity(intent);
                finish();
            }
        });
    }
}
