package com.example.quizapp;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class SplashScreen extends AppCompatActivity {
    ImageView imageLogo;
    TextView titleView;
    Animation top_animation;
    Animation button_animation;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_splash_screen);

        // Find views
        imageLogo = findViewById(R.id.imageview);
        titleView = findViewById(R.id.titleText);

        // Load animations
        top_animation = AnimationUtils.loadAnimation(this, R.anim.top_animation);
        button_animation = AnimationUtils.loadAnimation(this, R.anim.button_animation);

        // Set animations
        imageLogo.setAnimation(top_animation);
        titleView.setAnimation(button_animation);

        // Delay and navigate to the next screen
        new Handler().postDelayed(() -> {
            Intent intent = new Intent(SplashScreen.this, Register.class);
            startActivity(intent);
            finish();
        }, 3000); // Delay for 3 seconds
    }
}