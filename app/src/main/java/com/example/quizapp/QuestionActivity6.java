package com.example.quizapp;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;

public class QuestionActivity6 extends AppCompatActivity {

    String questions[] = {
            "What is the correct extension for a JavaScript file?",
            "Which keyword is used to declare a variable in JavaScript?",
            "Which function is used to output data to the console in JavaScript?",
            "What symbol is used to terminate a statement in JavaScript?",
            "What is the purpose of the 'console.log()' function in JavaScript?"
    };

    String answer[] = {
            ".js",
            "let",
            "console.log()",
            ";",
            "Outputs data to the console"
    };

    String opt[] = {
            // Options for question 1
            ".jsx", ".js", ".java", ".ts",
            // Options for question 2
            "let", "var", "const", "int",
            // Options for question 3
            "print()", "console.log()", "log()", "echo()",
            // Options for question 4
            ".", ";", ":", ",",
            // Options for question 5
            "Declares a function", "Outputs data to the console", "Ends a loop", "Defines a variable"
    };

    int flag = 0;

    public static int marks = 0, correct = 0, wrong = 0;

    TextView tv;
    Button submitbutton, quitbutton;
    RadioGroup radio_g;
    RadioButton rb1, rb2, rb3, rb4;
    private TextView questionnumber;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_question6);

        final TextView score = findViewById(R.id.textview4);
        TextView textView = findViewById(R.id.DispName);
        Intent intent = getIntent();

        questionnumber = findViewById(R.id.DispName);
        submitbutton = findViewById(R.id.button3);
        quitbutton = findViewById(R.id.buttonquit);
        tv = findViewById(R.id.tvque);

        radio_g = findViewById(R.id.answergrp);
        rb1 = findViewById(R.id.radiobutton);
        rb2 = findViewById(R.id.radiobutton2);
        rb3 = findViewById(R.id.radiobutton3);
        rb4 = findViewById(R.id.radiobutton4);

        tv.setText(questions[flag]);
        rb1.setText(opt[0]);
        rb2.setText(opt[1]);
        rb3.setText(opt[2]);
        rb4.setText(opt[3]);

        submitbutton.setOnClickListener(view -> {

            if (radio_g.getCheckedRadioButtonId() == -1) {
                Toast.makeText(QuestionActivity6.this, "Please select one", Toast.LENGTH_SHORT).show();
                return;
            }

            RadioButton uans = findViewById(radio_g.getCheckedRadioButtonId());
            String ansText = uans.getText().toString();

            if (ansText.equals(answer[flag])) {
                correct++;
                Toast.makeText(QuestionActivity6.this, "Correct", Toast.LENGTH_SHORT).show();
            } else {
                wrong++;
                Toast.makeText(QuestionActivity6.this, "Wrong", Toast.LENGTH_SHORT).show();
            }

            flag++;
            if (score != null) {
                score.setText("" + correct);

                if (flag < questions.length) {
                    tv.setText(questions[flag]);
                    rb1.setText(opt[flag * 4]);
                    rb2.setText(opt[flag * 4 + 1]);
                    rb3.setText(opt[flag * 4 + 2]);
                    rb4.setText(opt[flag * 4 + 3]);
                    questionnumber.setText(flag + "/" + questions.length + " Question");
                } else {
                    marks = correct;
                    Intent in = new Intent(QuestionActivity6.this, ResultActivity.class);
                    startActivity(in);
                }

                radio_g.clearCheck();
            }
        });

        quitbutton.setOnClickListener(view -> {
            Intent intent1 = new Intent(getApplicationContext(), Login.class);
            startActivity(intent1);
        });

    }
}
