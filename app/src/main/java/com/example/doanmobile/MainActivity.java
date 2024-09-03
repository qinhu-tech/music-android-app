package com.example.doanmobile;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;

import com.example.doanmobile.intro.WelcomeActivity;
import com.example.doanmobile.search.SearchActivity;
import com.example.doanmobile.song.MusicActivity;
import com.example.doanmobile.sql.DepartmentActivity;
import com.example.doanmobile.sql.MainActivity2;
import com.example.doanmobile.ui.LoginActivity;

public class MainActivity extends AppCompatActivity {
    Button btback1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button button = findViewById(R.id.btn);
        Button button1 = findViewById(R.id.btn1);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this,PdfActivity.class);
                startActivity(intent);
            }
        });
        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent1 = new Intent(MainActivity.this,PlayActivity.class);
                startActivity(intent1);
            }
        });
    }
    // gắn menu cho Ac
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater menuInf = getMenuInflater();
        menuInf.inflate(R.menu.optionmenu,menu);
        return true;
    }
    //tạo sự kiện click trên item của menu
    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()){
            case R.id.mnAccount:
                showActivity(item.getTitle().toString());
                return true;
            case R.id.mnMusic:
                showActivityy(item.getTitle().toString());
                return true;
            case R.id.mnMusicnote:
                showActivityyy(item.getTitle().toString());
                return true;
            case R.id.mnMusiclist:
                showActivityyyy(item.getTitle().toString());
                return true;
            case R.id.mnMusicplay:
                showActivityyyyy(item.getTitle().toString());
                return true;
            case R.id.mnSearch:
                showActivityyyyyy(item.getTitle().toString());
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }
    void showActivity(String nameMn)
    {
        Intent i = new Intent(MainActivity.this, LoginActivity.class);
        i.putExtra("menu", nameMn);
        startActivity(i);
    }
    void showActivityy(String nameMn)
    {
        Intent u = new Intent(MainActivity.this, RecyclerviewActivity.class);
        u.putExtra("menu", nameMn);
        startActivity(u);
    }
    void showActivityyy(String nameMn)
    {
        Intent h = new Intent(MainActivity.this, DepartmentActivity.class);
        h.putExtra("menu", nameMn);
        startActivity(h);
    }
    void showActivityyyy(String nameMn)
    {
        Intent k = new Intent(MainActivity.this, MainActivity2.class);
        k.putExtra("menu", nameMn);
        startActivity(k);
    }
    void showActivityyyyy(String nameMn)
    {
        Intent g = new Intent(MainActivity.this, MusicActivity.class);
        g.putExtra("menu", nameMn);
        startActivity(g);
    }






















    void showActivityyyyyy(String nameMn)
    {
        Intent s = new Intent(MainActivity.this, SearchActivity.class);
        s.putExtra("menu", nameMn);
        startActivity(s);
    }
}