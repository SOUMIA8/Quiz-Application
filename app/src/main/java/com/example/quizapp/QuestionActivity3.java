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

public class QuestionActivity3 extends AppCompatActivity {

    // Questions pour le langage Java
    String questions[] = {
            "Which keyword is used to define a class in Java?",
            "What is the entry point of a Java program?",
            "Which symbol is used to terminate a statement in Java?",
            "What is the size of int in Java?",
            "Which method is used to print output in Java?"
    };

    // Réponses correctes
    String answer[] = {
            "class",
            "main() method",
            ";",
            "4 bytes",
            "System.out.println()"
    };

    // Options pour chaque question
    String opt[] = {
            // Options pour la question 1
            "class", "define", "function", "program",
            // Options pour la question 2
            "main() method", "start() method", "init() method", "entry() method",
            // Options pour la question 3
            ":", ";", ".", ",",
            // Options pour la question 4
            "2 bytes", "4 bytes", "8 bytes", "16 bytes",
            // Options pour la question 5
            "print()", "System.out.println()", "echo()", "cout"
    };

    int flag = 0; // Pour suivre l'indice actuel de la question

    // Variables pour suivre les résultats
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
        setContentView(R.layout.activity_question3);

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

        // Initialisation de la première question et des options
        tv.setText(questions[flag]);
        rb1.setText(opt[0]);
        rb2.setText(opt[1]);
        rb3.setText(opt[2]);
        rb4.setText(opt[3]);

        // Gestionnaire d'événements pour le bouton "Submit"
        submitbutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (radio_g.getCheckedRadioButtonId() == -1) {
                    Toast.makeText(QuestionActivity3.this, "Please select one", Toast.LENGTH_SHORT).show();
                    return;
                }

                // Vérification de la réponse choisie
                RadioButton uans = findViewById(radio_g.getCheckedRadioButtonId());
                String ansText = uans.getText().toString();

                if (ansText.equals(answer[flag])) {
                    correct++;
                    Toast.makeText(QuestionActivity3.this, "Correct", Toast.LENGTH_SHORT).show();
                } else {
                    wrong++;
                    Toast.makeText(QuestionActivity3.this, "Wrong", Toast.LENGTH_SHORT).show();
                }

                // Charger la question suivante
                flag++;
                if (flag < questions.length) {
                    tv.setText(questions[flag]);
                    rb1.setText(opt[flag * 4]);
                    rb2.setText(opt[flag * 4 + 1]);
                    rb3.setText(opt[flag * 4 + 2]);
                    rb4.setText(opt[flag * 4 + 3]);
                    questionnumber.setText("Question " + (flag + 1) + "/" + questions.length);
                } else {
                    // Fin du quiz, afficher les résultats
                    marks = correct;
                    Intent in = new Intent(QuestionActivity3.this, ResultActivity.class);
                    startActivity(in);
                }

                // Réinitialiser la sélection des réponses
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
