package com.example.doanmobile;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.widget.Button;

import com.example.doanmobile.fragment.HomeFragment;
import com.example.doanmobile.fragment.InfoFragment;
import com.example.doanmobile.fragment.SettingFragment;
import com.example.doanmobile.intro.WelcomeActivity;
import com.example.doanmobile.sql.MainActivity2;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.navigation.NavigationBarView;

public class FragmentActivity extends AppCompatActivity {
    Button btbacks;
    BottomNavigationView mnBottom;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fragment);
        mnBottom = findViewById(R.id.navmenu);
        //
        ActionBar actionBar = getSupportActionBar();
        actionBar.setTitle("Main");
        actionBar.setDisplayHomeAsUpEnabled(true);
        // load len Fragment
        mnBottom.setOnItemSelectedListener(getListener());
        btbacks = findViewById(R.id.btbackk);
        btbacks.setOnClickListener(v -> startActivity(new Intent(this, MainActivity.class)));
    }

    @NonNull
    private NavigationBarView.OnItemSelectedListener getListener() {
        return new NavigationBarView.OnItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                Fragment fmNew;
                switch (item.getItemId()){
                    case R.id.mnHome:
                        getSupportActionBar().setTitle(item.getTitle());
                        fmNew = new HomeFragment();
                        loadFragment(fmNew);
                        return true;
                    case R.id.mnInfo:
                        getSupportActionBar().setTitle(item.getTitle());
                        fmNew = new InfoFragment();
                        loadFragment(fmNew);
                        return true;
                    case R.id.mnSetting:
                        getSupportActionBar().setTitle(item.getTitle());
                        fmNew = new SettingFragment();
                        loadFragment(fmNew);
                        return true;
                }
                return true;
            }
        };
    }

    void loadFragment (Fragment fmNew)
    {
        FragmentTransaction fmTran = getSupportFragmentManager().beginTransaction();
        fmTran.replace(R.id.main_fragment, fmNew);
        fmTran.addToBackStack(null);
        fmTran.commit();
    }
}