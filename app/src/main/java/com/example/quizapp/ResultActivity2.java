package com.example.quizapp;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;

public class ResultActivity2 extends AppCompatActivity {

    TextView tv, tv2, tv3, tv4, resultText;
    Button btnRestart;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_result2);

        // Initialize views
        tv = findViewById(R.id.tvres);
        tv2 = findViewById(R.id.tvres2);
        tv3 = findViewById(R.id.tvres3);
        tv4 = findViewById(R.id.tvres4);
        resultText = findViewById(R.id.resulttext);
        btnRestart = findViewById(R.id.btnRestart);

        // Set text for result sections
        tv.setText("Correct Answers: " + QuestionActivity2.correct);
        tv2.setText("Wrong Answers: " + QuestionActivity2.wrong);
        tv3.setText("Final Score: " + QuestionActivity2.correct);
        tv4.setText("Percentage: " + (QuestionActivity2.correct * 100 / 5) + "%");

        // Clear the scores for next round
        QuestionActivity.correct = 0;
        QuestionActivity.wrong = 0;

        // Restart button action
        btnRestart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(ResultActivity2.this, Login.class);
                startActivity(intent);
                finish(); // Finish current activity to avoid returning to result screen
            }
        });
    }
}
