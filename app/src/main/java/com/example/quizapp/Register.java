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



public class Register extends AppCompatActivity {

    EditText FullName, Email, Password;
    Button RegisterBtn;
    TextView login_link;
    ProgressBar progressBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        FullName = findViewById(R.id.fullname);
        Email = findViewById(R.id.email);
        Password = findViewById(R.id.password);
        RegisterBtn = findViewById(R.id.register_button);
        login_link = findViewById(R.id.link_login);
        progressBar = findViewById(R.id.progressbar);

        login_link.setOnClickListener(view -> {
            Intent intent = new Intent(Register.this, Login.class);
            startActivity(intent);
        });

        RegisterBtn.setOnClickListener(view -> {
            String fullName = FullName.getText().toString().trim();
            String email = Email.getText().toString().trim();
            String password = Password.getText().toString().trim();

            if (TextUtils.isEmpty(fullName)) {
                FullName.setError("Full name is required");
                return;
            }

            if (TextUtils.isEmpty(email)) {
                Email.setError("Email is required");
                return;
            }

            if (TextUtils.isEmpty(password)) {
                Password.setError("Password is required");
                return;
            }

            if (password.length() < 6) {
                Password.setError("Password must be at least 6 characters");
                return;
            }

            progressBar.setVisibility(View.VISIBLE);

            new Handler().postDelayed(() -> {
                SharedPreferences sharedPreferences = getSharedPreferences("UserData", MODE_PRIVATE);
                SharedPreferences.Editor editor = sharedPreferences.edit();

                editor.putString("FullName", fullName);
                editor.putString("Email", email);
                editor.putString("Password", password);
                editor.apply();

                Log.d("Register", "User registered with Email: " + email);

                progressBar.setVisibility(View.INVISIBLE);
                Intent intent = new Intent(Register.this, Login.class);
                startActivity(intent);
                finish();
            }, 2000);
        });
    }
}
