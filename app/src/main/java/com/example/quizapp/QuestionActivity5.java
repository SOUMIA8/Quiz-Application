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

public class QuestionActivity5 extends AppCompatActivity {

    String questions[] = {
            "What is the correct file extension for Python files?",
            "Which keyword is used to define a function in Python?",
            "How do you start a comment in Python?",
            "Which data type is used to store a sequence of characters in Python?",
            "What does the 'len()' function do in Python?"
    };

    String answer[] = {
            ".py",
            "def",
            "#",
            "str",
            "Returns the length of an object"
    };

    String opt[] = {
            // Options for question 1
            ".py", ".java", ".c", ".txt",
            // Options for question 2
            "function", "def", "lambda", "func",
            // Options for question 3
            "//", "#", "/*", "--",
            // Options for question 4
            "int", "list", "str", "dict",
            // Options for question 5
            "Calculates the size of memory", "Returns the length of an object", "Checks if an object is empty", "Iterates through the object"
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
        setContentView(R.layout.activity_question5);

        final TextView score = findViewById(R.id.textview4);
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
                Toast.makeText(QuestionActivity5.this, "Please select one", Toast.LENGTH_SHORT).show();
                return;
            }

            RadioButton uans = findViewById(radio_g.getCheckedRadioButtonId());
            String ansText = uans.getText().toString();

            if (ansText.equals(answer[flag])) {
                correct++;
                Toast.makeText(QuestionActivity5.this, "Correct", Toast.LENGTH_SHORT).show();
            } else {
                wrong++;
                Toast.makeText(QuestionActivity5.this, "Wrong", Toast.LENGTH_SHORT).show();
            }

            flag++;

            if (flag < questions.length) {
                tv.setText(questions[flag]);
                rb1.setText(opt[flag * 4]);
                rb2.setText(opt[flag * 4 + 1]);
                rb3.setText(opt[flag * 4 + 2]);
                rb4.setText(opt[flag * 4 + 3]);
                questionnumber.setText((flag + 1) + "/" + questions.length + " Question");
            } else {
                marks = correct;
                Intent in = new Intent(QuestionActivity5.this, ResultActivity.class);
                startActivity(in);
            }

            radio_g.clearCheck();
            score.setText("Score: " + correct);
        });

        quitbutton.setOnClickListener(view -> {
            Intent intent1 = new Intent(getApplicationContext(), Login.class);
            startActivity(intent1);
        });
    }
}
