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

public class QuestionActivity extends AppCompatActivity {

    String questions[] = {
            "What is the correct extension for a C program file?",
            "Which keyword is used to declare a variable in C?",
            "Which function is used to print output in C?",
            "What symbol is used to terminate a statement in C?",
            "What does #include<stdio.h> do in a C program?"
    };

    String answer[] = {
            ".c",
            "int",
            "printf()",
            ";",
            "Includes standard input/output functions"
    };

    String opt[] = {
            // Options for question 1
            ".cpp", ".java", ".c", ".py",
            // Options for question 2
            "int", "var", "function", "String",
            // Options for question 3
            "print()", "cout", "printf()", "println()",
            // Options for question 4
            ":", ";", ",", ".",
            // Options for question 5
            "Declares a variable", "Defines the main function", "Includes standard input/output functions", "Ends the program"
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
        setContentView(R.layout.activity_question);

        final TextView score = (TextView) findViewById(R.id.textview4);
        TextView textView = (TextView) findViewById(R.id.DispName);
        Intent intent = getIntent();

        questionnumber = findViewById(R.id.DispName);
        submitbutton = (Button) findViewById(R.id.button3);
        quitbutton = (Button) findViewById(R.id.buttonquit);
        tv = (TextView) findViewById(R.id.tvque);

        radio_g = (RadioGroup) findViewById(R.id.answergrp);
        rb1 = (RadioButton) findViewById(R.id.radiobutton);
        rb2 = (RadioButton) findViewById(R.id.radiobutton2);
        rb3 = (RadioButton) findViewById(R.id.radiobutton3);
        rb4 = (RadioButton) findViewById(R.id.radiobutton4);

        // Set the first question and options
        tv.setText(questions[flag]);
        rb1.setText(opt[flag * 4]);      // Option A
        rb2.setText(opt[flag * 4 + 1]);  // Option B
        rb3.setText(opt[flag * 4 + 2]);  // Option C
        rb4.setText(opt[flag * 4 + 3]);  // Option D

        submitbutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if (radio_g.getCheckedRadioButtonId() == -1) {
                    Toast.makeText(QuestionActivity.this, "Please select one", Toast.LENGTH_SHORT).show();
                    return;
                }

                RadioButton uans = (RadioButton) findViewById(radio_g.getCheckedRadioButtonId());
                String ansText = uans.getText().toString();

                if (ansText.equals(answer[flag])) {
                    correct++;
                    Toast.makeText(QuestionActivity.this, "Correct", Toast.LENGTH_SHORT).show();
                } else {
                    wrong++;
                    Toast.makeText(QuestionActivity.this, "Wrong", Toast.LENGTH_SHORT).show();
                }

                flag++;

                if (flag < questions.length) {
                    tv.setText(questions[flag]);
                    rb1.setText(opt[flag * 4]);
                    rb2.setText(opt[flag * 4 + 1]);
                    rb3.setText(opt[flag * 4 + 2]);
                    rb4.setText(opt[flag * 4 + 3]);
                    questionnumber.setText(flag + "/" + questions.length + " Question");
                } else {
                    marks = correct;
                    Intent in = new Intent(QuestionActivity.this, ResultActivity.class);
                    startActivity(in);
                }

                radio_g.clearCheck();
            }
        });

        quitbutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent1 = new Intent(getApplicationContext(), Login.class);
                startActivity(intent1);
            }
        });
    }
}
