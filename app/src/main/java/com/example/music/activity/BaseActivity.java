package com.example.music.activity;

import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.annotation.StringRes;
import androidx.appcompat.app.AppCompatActivity;

import com.afollestad.materialdialogs.MaterialDialog;
import com.example.music.R;

public abstract class BaseActivity extends AppCompatActivity {
    protected MaterialDialog progressDialog, alertDialog;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        createProgressDialog();
        createAlertDialog();
    }

    public void createProgressDialog() {
        progressDialog = new MaterialDialog.Builder(this)
                .content(R.string.msg_please_waiting)
                .progress(true, 0)
                .build();
    }

    public void createAlertDialog() {
        alertDialog = new MaterialDialog.Builder(this)
                .title(R.string.app_name)
                .positiveText(R.string.action_ok)
                .cancelable(false)
                .build();
    }

    @Override
    protected void onDestroy() {
        if (progressDialog != null && progressDialog.isShowing()) {
            progressDialog.dismiss();
        }

        if (alertDialog != null && alertDialog.isShowing()) {
            alertDialog.dismiss();
        }
        super.onDestroy();
    }
}
