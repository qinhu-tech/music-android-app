package com.example.doanmobile.ui;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.doanmobile.FragmentActivity;
import com.example.doanmobile.MainActivity;
import com.example.doanmobile.R;
import com.example.doanmobile.model.Users;
import com.google.gson.Gson;

public class LoginActivity extends AppCompatActivity {

    Button btLogin, btRegister;
    EditText edUserNameC, edPasswordC;
    SharedPreferences.Editor editor;
    private final Gson gson = new Gson();
    SharedPreferences sharedPreferences;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        getSupportActionBar().setTitle("Login");
        // Anh xa
        anhxa();
        //
        sharedPreferences = getSharedPreferences(Util.SHARE_PREFERENCES_APP, Context.MODE_PRIVATE);
        // tao su kien
        taosukien();
    }
    private  void taosukien()
    {
        btLogin.setOnClickListener(view -> checkUserLogin() );
        btRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(LoginActivity.this, RegisterActivity.class);
                startActivity(i);
            }
        });
    }
    void anhxa()
    {
        btLogin = findViewById(R.id.btLogin);
        btRegister = findViewById(R.id.btRegister);
        edUserNameC = findViewById(R.id.edUserName);
        edPasswordC = findViewById(R.id.edPassword);
    }


    private void checkUserLogin()
    {
        String username = edUserNameC.getText().toString().trim();
        String password = edPasswordC.getText().toString().trim();
        // Kiem tra du lieu
        if (TextUtils.isEmpty(username) || TextUtils.isEmpty(password))
        {
            Toast.makeText(getApplicationContext(),"Vui lòng nhập thông tin đầy đủ",Toast.LENGTH_LONG).show();
        }
        else {
            Toast.makeText(getApplicationContext(),"Đằng nhập thành công",Toast.LENGTH_LONG).show();
        }
        String userPref = sharedPreferences.getString(Util.KEY_USER, null);
        Users user = gson.fromJson(userPref, Users.class);
        // user = null => user chưa đăng ký
        if(user == null) {
            return;
        }
        // kiểm tra username và pass có trùng với user đã đăng ký hay không
        boolean isValid = edUserNameC.getText().toString().trim().equals(user.getUserName()) && edPasswordC.getText().toString().trim().equals(user.getPassword());
        // Nếu két quả trùng thì bắt đầu chạy main activity
        if (isValid)
        {
            Intent intent = new Intent(this, FragmentActivity.class);
            // Khởi tạo bundle để truyền user data qua cho MainActivity
            Bundle bundle = new Bundle();
            // Vì user là object nên dùng putSerializable
            bundle.putSerializable(Util.KEY_USER_PROFILE, user);
//            Hoặc có thể dùng put String nếu chỉ dùng user name
//             bundle.putString(Utils.KEY_USER_PROFILE, user.getUserName());
//             put bundle cho intent
            intent.putExtras(bundle);
            startActivity(intent);
            // sau khi chạy Main thì tắt loginactivity
            finish();
        }
    }
}