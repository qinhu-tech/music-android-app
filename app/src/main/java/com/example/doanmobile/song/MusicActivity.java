package com.example.doanmobile.song;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;

import com.example.doanmobile.R;

public class MusicActivity extends AppCompatActivity {
    Button btMediaPlayer;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_music);
        btMediaPlayer = findViewById(R.id.btMediaPlayer);
        btMediaPlayer.setOnClickListener(v -> startActivity(new Intent(this, SongActivity.class)));
    }
}