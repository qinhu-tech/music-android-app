package com.example.doanmobile;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;

import com.example.doanmobile.intro.WelcomeActivity;

public class StartActivity extends AppCompatActivity {
    Button btMediaPlayer;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_start);
        btMediaPlayer = findViewById(R.id.btMediaPlayer);
        btMediaPlayer.setOnClickListener(v -> startActivity(new Intent(this, WelcomeActivity.class)));
    }
}