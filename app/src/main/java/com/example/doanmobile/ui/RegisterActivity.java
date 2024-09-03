package com.example.doanmobile.ui;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.RadioGroup;
import android.widget.Toast;

import com.example.doanmobile.R;
import com.example.doanmobile.User;
import com.example.doanmobile.model.Users;
import com.google.gson.Gson;

public class RegisterActivity extends AppCompatActivity {
    private EditText edUserNameC;
    private EditText edPasswordC;
    private EditText edConfirmPasswordC;
    private EditText edEmailC;
    private EditText edPhoneNumberC;
    private RadioGroup rbSex;
    private Button btnRegister;
    private ImageButton imbBack;

    private SharedPreferences.Editor editor;
    SharedPreferences sharedPreferences;

    private final Gson gson = new Gson();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        getSupportActionBar().setTitle("Register");
        //khai báo share Pre
        sharedPreferences = getSharedPreferences(Util.SHARE_PREFERENCES_APP, Context.MODE_PRIVATE);
        editor = sharedPreferences.edit();
        //lấy dữ liệu
        anhxadulieu();
        taosukien();
    }
    void anhxadulieu()
    {
        edUserNameC = findViewById(R.id.edUserNameRe);
        edPasswordC = findViewById(R.id.edPasswordRe);
        edConfirmPasswordC = findViewById(R.id.edconfirm_password);
        edEmailC = findViewById(R.id.edEmail);
        edPhoneNumberC = findViewById(R.id.edPhone);
        rbSex = findViewById(R.id.rgSex);
        btnRegister = findViewById(R.id.btRegister);
        imbBack = findViewById(R.id.imbBack);
    }
    void taosukien()
    {
        btnRegister.setOnClickListener(v->sukienRegister());
        imbBack.setOnClickListener(v->finish());
    }
    void sukienRegister()
    {
        String userName = edUserNameC.getText().toString().trim();
        String password = edPasswordC.getText().toString().trim();
        String confirmPassword = edConfirmPasswordC.getText().toString().trim();
        String email = edEmailC.getText().toString().trim();
        String phone = edPhoneNumberC.getText().toString().trim();
        // nếu sex = 1 là nam, sex = 0 là nữ.
        int sex = 1;
        boolean isValid = checkUserName(userName) && checkPassword(password,confirmPassword);
        if (isValid){
            //nếu dữ liệu hợp lệ, tạo đối tượng user để lưu vô share preference
            Users userNew = new Users();
            userNew.setUserName(userName);
            userNew.setPassword(password);
            userNew.setEmail(email);
            userNew.setPhoneNumber(phone);
            //lấy radio button id đang đc checked
            int sexSelected = rbSex.getCheckedRadioButtonId();
            if(sexSelected == R.id.rbFemale) {
                sex = 0;
            }
            userNew.setSex(sex);
            //vì user là object nên convert qua string với format là json để lưu vào share preference
            String userStr = gson.toJson(userNew);
            editor.putString(Util.KEY_USER, userStr);
            editor.commit();
            //dùng Toast để show thông báo đăng ký thành công
            Toast.makeText(RegisterActivity.this, "Đăng ký tài khoản thành công" , Toast.LENGTH_LONG).show();
            //finish RegisterActivity
            finish();
        }
    }
    private boolean checkUserName(String userName)
    {
        if(userName.isEmpty()) {
            edUserNameC.setError("Vui lòng nhập tên đăng nhập");
            return false;
        }
        if (userName.length() < 5){
            edUserNameC.setError("Tên đăng nhập phải ít nhất 6 ký tự");
            return false;
        }
        return true;
    }
    private boolean checkPassword(String password, String confirmPassword)
    {
        if(password.isEmpty()) {
            edPasswordC.setError("Vui lòng nhập mật khẩu");
            return false;
        }
        if (password.length() < 5){
            edPasswordC.setError("Mật khẩu phải lớn hơn 5 ký tự");
            return false;
        }
        if (!password.equals(confirmPassword)){
            edConfirmPasswordC.setError("Xác nhận mật khẩu không khớp");
            return false;
        }
        return true;
    }
}