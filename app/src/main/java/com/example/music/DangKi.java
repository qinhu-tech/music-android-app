package com.example.music;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.music.activity.MainActivity;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class DangKi extends AppCompatActivity {
    TextView coTaiKhoan;
    Button DangKiTK;
    EditText inpEmail, inpPass, intConformPass;
    String emailPattern = "[a-zA-Z0-9._-]+@[a-z]+\\.+[a-z]+";
    ProgressDialog progressDialog;

    FirebaseAuth mAuth;
    FirebaseUser mUser;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dang_ki);

        coTaiKhoan = (TextView) findViewById(R.id.tvDaCoTK);
        DangKiTK = (Button) findViewById(R.id.btnDK);
        inpEmail = (EditText) findViewById(R.id.edtEmail);
        inpPass = (EditText) findViewById(R.id.edtPassDK);
        intConformPass = (EditText) findViewById(R.id.edtNhapLaiPass);

        progressDialog = new ProgressDialog(this);

        mAuth = FirebaseAuth.getInstance();
        mUser = mAuth.getCurrentUser();
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);


        coTaiKhoan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(DangKi.this, DangNhap.class));
            }
        });

        DangKiTK.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                PerForAuth();
            }
        });
    }

    private void PerForAuth(){
        String email = inpEmail.getText().toString();
        String pass = inpPass.getText().toString();
        String conformPass = intConformPass.getText().toString();

        if(!email.matches(emailPattern)){
            inpEmail.setError("Nhập lại email");
        } else if (pass.isEmpty() || pass.length()<6) {
            inpPass.setError("Nhập lại mật khẩu (hơn 6 ký tự)");
        } else if (!pass.equals(conformPass)) {
            intConformPass.setError("Phải trùng với mật khẩu đã tạo");
        }else{
            progressDialog.setMessage("Chờ chút nha...");
            progressDialog.setTitle("Đăng kí");
            progressDialog.setCanceledOnTouchOutside(false);
            progressDialog.show();

            mAuth.createUserWithEmailAndPassword(email, pass).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                @Override
                public void onComplete(@NonNull Task<AuthResult> task) {
                    if(task.isSuccessful()){
                        sentUserToNextActivity();
                        progressDialog.dismiss();
                        Toast.makeText(DangKi.this, "Đăng kí thành công", Toast.LENGTH_SHORT).show();
                    }else {
                        progressDialog.dismiss();
                        Toast.makeText(DangKi.this, ""+ task.getException(), Toast.LENGTH_SHORT).show();
                    }
                }
            });
        }
    }

    private void sentUserToNextActivity() {
        Intent intent = new Intent(DangKi.this, MainActivity.class);
        intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK|Intent.FLAG_ACTIVITY_NEW_TASK);
        startActivity(intent);
    }
}