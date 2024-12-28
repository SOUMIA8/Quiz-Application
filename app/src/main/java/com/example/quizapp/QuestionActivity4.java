package com.example.quizapp;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class QuestionActivity4 extends AppCompatActivity {

    // Questions pour le quiz Python
    String questions[] = {
            "What is the correct extension for a Python file?",
            "Which keyword is used to define a function in Python?",
            "Which function is used to print output in Python?",
            "What symbol is used to indicate the start of a block in Python?",
            "What does the 'import' statement do in Python?"
    };

    // Réponses correctes
    String answer[] = {
            ".py",
            "def",
            "print()",
            "Indentation",
            "Imports a module"
    };

    // Options pour chaque question
    String opt[] = {
            // Options pour la question 1
            ".cpp", ".java", ".py", ".c",
            // Options pour la question 2
            "def", "function", "lambda", "fun",
            // Options pour la question 3
            "output()", "print()", "echo()", "log()",
            // Options pour la question 4
            ":", "Indentation", ";", "{ }",
            // Options pour la question 5
            "Defines a function", "Imports a module", "Initializes a variable", "Ends the program"
    };

    int flag = 0; // Indice actuel de la question

    // Variables pour les scores
    public static int marks = 0, correct = 0, wrong = 0;

    // Déclaration des vues
    TextView tv;
    Button submitbutton, quitbutton;
    RadioGroup radio_g;
    RadioButton rb1, rb2, rb3, rb4;
    private TextView questionnumber;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_question4);

        // Initialisation des vues
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

        // Charger la première question et ses options
        tv.setText(questions[flag]);
        rb1.setText(opt[0]);
        rb2.setText(opt[1]);
        rb3.setText(opt[2]);
        rb4.setText(opt[3]);
        questionnumber.setText("Question " + (flag + 1) + "/" + questions.length);

        // Gestionnaire d'événements pour le bouton "Submit"
        submitbutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (radio_g.getCheckedRadioButtonId() == -1) {
                    Toast.makeText(QuestionActivity4.this, "Please select one", Toast.LENGTH_SHORT).show();
                    return;
                }

                // Vérifier la réponse sélectionnée
                RadioButton uans = findViewById(radio_g.getCheckedRadioButtonId());
                String ansText = uans.getText().toString();

                if (ansText.equals(answer[flag])) {
                    correct++;
                    Toast.makeText(QuestionActivity4.this, "Correct", Toast.LENGTH_SHORT).show();
                } else {
                    wrong++;
                    Toast.makeText(QuestionActivity4.this, "Wrong", Toast.LENGTH_SHORT).show();
                }

                flag++;

                // Passer à la question suivante ou terminer le quiz
                if (flag < questions.length) {
                    tv.setText(questions[flag]);
                    rb1.setText(opt[flag * 4]);
                    rb2.setText(opt[flag * 4 + 1]);
                    rb3.setText(opt[flag * 4 + 2]);
                    rb4.setText(opt[flag * 4 + 3]);
                    questionnumber.setText("Question " + (flag + 1) + "/" + questions.length);
                } else {
                    marks = correct;
                    Intent in = new Intent(QuestionActivity4.this, ResultActivity.class);
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
