package com.example.doanmobile;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

public class DetailsActivity extends AppCompatActivity {
    TextView tvDetailC;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_details);
        tvDetailC = findViewById(R.id.tvDetail);
        //
        String id = getIntent().getStringExtra("userId");
        tvDetailC.setText(id);
    }
}