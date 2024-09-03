package com.example.doanmobile;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class DetailActivity extends AppCompatActivity {
    TextView tvMenu;
    Button btBackC;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);
        tvMenu = findViewById(R.id.tvMenu);
        btBackC = findViewById(R.id.btBack);
        //get dữ liệu
        Bundle goi = getIntent().getExtras();
        String mnname = goi.getString("menu");
        tvMenu.setText(mnname);
        btBackC.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });

    }
}