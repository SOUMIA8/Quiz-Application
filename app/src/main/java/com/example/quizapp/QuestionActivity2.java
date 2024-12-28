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

public class QuestionActivity2 extends AppCompatActivity {

    // Updated questions, answers, and options for C++
    String questions[] = {
            "What is the correct file extension for a C++ program?",
            "Which keyword is used to define a class in C++?",
            "Which operator is used to access the members of a class object?",
            "What is the purpose of the 'main()' function in C++?",
            "Which library is used for input/output operations in C++?"
    };

    String answer[] = {
            ".cpp",
            "class",
            ".",
            "Entry point of the program",
            "<iostream>"
    };

    String opt[] = {
            // Options for question 1
            ".c", ".cpp", ".java", ".py",
            // Options for question 2
            "struct", "class", "object", "function",
            // Options for question 3
            "->", "::", ".", "/",
            // Options for question 4
            "Declare variables", "Entry point of the program", "Include libraries", "Terminate the program",
            // Options for question 5
            "<stdio.h>", "<iostream>", "<stdlib.h>", "<conio.h>"
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
        setContentView(R.layout.activity_question2);

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

        // Set the first question and options
        tv.setText(questions[flag]);
        rb1.setText(opt[0]);
        rb2.setText(opt[1]);
        rb3.setText(opt[2]);
        rb4.setText(opt[3]);

        submitbutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if (radio_g.getCheckedRadioButtonId() == -1) {
                    Toast.makeText(QuestionActivity2.this, "Please select one", Toast.LENGTH_SHORT).show();
                    return;
                }

                RadioButton uans = findViewById(radio_g.getCheckedRadioButtonId());
                String ansText = uans.getText().toString();

                if (ansText.equals(answer[flag])) {
                    correct++;
                    Toast.makeText(QuestionActivity2.this, "Correct", Toast.LENGTH_SHORT).show();
                } else {
                    wrong++;
                    Toast.makeText(QuestionActivity2.this, "Wrong", Toast.LENGTH_SHORT).show();
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
                    Intent in = new Intent(QuestionActivity2.this, ResultActivity.class);
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
