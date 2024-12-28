package com.example.quizapp;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.Handler;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class Login extends AppCompatActivity {

    EditText Email, Password;
    Button LoginBtn;
    TextView link_signup;
    ProgressBar progressBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        Email = findViewById(R.id.email);
        Password = findViewById(R.id.password);
        LoginBtn = findViewById(R.id.login_button);
        link_signup = findViewById(R.id.link_signup);
        progressBar = findViewById(R.id.progressbar);

        link_signup.setOnClickListener(view -> {
            Intent intent = new Intent(Login.this, Register.class);
            startActivity(intent);
        });

        LoginBtn.setOnClickListener(view -> {
            String email = Email.getText().toString().trim();
            String password = Password.getText().toString().trim();

            if (TextUtils.isEmpty(email)) {
                Email.setError("Email is required");
                return;
            }

            if (TextUtils.isEmpty(password)) {
                Password.setError("Password is required");
                return;
            }

            progressBar.setVisibility(View.VISIBLE);

            new Handler().postDelayed(() -> {
                SharedPreferences sharedPreferences = getSharedPreferences("UserData", MODE_PRIVATE);
                String storedEmail = sharedPreferences.getString("Email", "");
                String storedPassword = sharedPreferences.getString("Password", "");

                Log.d("Login", "Stored Email: " + storedEmail);
                Log.d("Login", "Stored Password: " + storedPassword);

                if (email.equals(storedEmail) && password.equals(storedPassword)) {
                    progressBar.setVisibility(View.INVISIBLE);
                    Intent intent = new Intent(Login.this, MainActivity.class);
                    startActivity(intent);
                    finish();
                } else {
                    progressBar.setVisibility(View.INVISIBLE);
                    Password.setError("Invalid email or password");
                }
            }, 2000);
        });
    }
}
