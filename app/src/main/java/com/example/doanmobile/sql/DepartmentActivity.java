package com.example.doanmobile.sql;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import com.example.doanmobile.R;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.ArrayList;

public class DepartmentActivity extends AppCompatActivity implements DepartmentAdapter.DepartmentCallback {
    RecyclerView rvListCode;
    ArrayList<Department> lstDepart;
    DepartmentAdapter departAdapter;
    FloatingActionButton fbAdd;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_department);
        rvListCode = findViewById(R.id.rvListDe);
        fbAdd = findViewById(R.id.fbAdd);
        fbAdd.setOnClickListener(view -> addUserDialog());
        // lấy dữ liệu
        lstDepart = DepartmentDataQuery.getAll(this);
        departAdapter= new DepartmentAdapter(lstDepart);
        departAdapter.setCallback(this);
        // gan adapter
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        rvListCode.setAdapter(departAdapter);
        rvListCode.setLayoutManager(linearLayoutManager);
    }

    void addUserDialog() {
        // khởi tạo dialog để thêm người dùng.
        AlertDialog.Builder alertDialog = new AlertDialog.Builder(DepartmentActivity.this);
        alertDialog.setTitle("Thêm mới");
        LayoutInflater inflater = this.getLayoutInflater();
        View dialogView = inflater.inflate(R.layout.dialog_add_depart, null);
        alertDialog.setView(dialogView);
        EditText edNames = dialogView.findViewById(R.id.edNameDe);
        Spinner snType= dialogView.findViewById(R.id.snType);
        // load data for Spinner
        String []arrType=new String[]{"Nhóm 1","Nhóm 2","Nhóm 3","Nhóm 4"};
        ArrayAdapter<String> arrayAdapter= new ArrayAdapter<>(this, android.R.layout.simple_spinner_dropdown_item, arrType);
        snType.setAdapter(arrayAdapter);
        //
        alertDialog.setPositiveButton("Đồng ý", (dialog, which) -> {
            String names = edNames.getText().toString();

            if (names.isEmpty()) {
                Toast.makeText(DepartmentActivity.this, "Nhập dữ liệu không hợp lệ", Toast.LENGTH_LONG).show();
            } else {
                Department us = new Department(0, names);
                long id = DepartmentDataQuery.insert(DepartmentActivity.this, us);
                if (id > 0) {
                    Toast.makeText(DepartmentActivity.this, "Thêm phòng ban thành công.", Toast.LENGTH_LONG).show();
                    resetData();
                    dialog.dismiss();
                }
            }
        });
        alertDialog.setNegativeButton("Huỷ", (dialog, which) -> {
            dialog.dismiss();
        });
        alertDialog.create();
        alertDialog.show();
    }

    void updateUserDialog(Department us) {
        // khởi tạo dialog để cập nhật người dùng
        AlertDialog.Builder alertDialog = new AlertDialog.Builder(DepartmentActivity.this);
        alertDialog.setTitle("Cập nhật");
        LayoutInflater inflater = this.getLayoutInflater();
        View dialogView = inflater.inflate(R.layout.dialog_add_depart, null);
        alertDialog.setView(dialogView);
        EditText edNames = dialogView.findViewById(R.id.edNameDe);

        // gán dữ liệu
        edNames.setText(us.getNames());

        //
        alertDialog.setPositiveButton("Đồng ý", (dialog, which) -> {

            us.setNames(edNames.getText().toString());

            if (us.names.isEmpty()) {
                Toast.makeText(DepartmentActivity.this, "Nhập dữ liệu không hợp lệ", Toast.LENGTH_LONG).show();
            } else {

                int id = DepartmentDataQuery.update(DepartmentActivity.this, us);
                if (id > 0) {
                    Toast.makeText(DepartmentActivity.this, "Cập nhật phòng ban thành công.", Toast.LENGTH_LONG).show();
                    resetData();
                    dialog.dismiss();
                }
            }
        });
        alertDialog.setNegativeButton("Hủy", (dialog, which) -> {
            dialog.dismiss();
        });
        alertDialog.create();
        alertDialog.show();
    }

    void resetData() {
        lstDepart.clear();
        lstDepart.addAll(DepartmentDataQuery.getAll(DepartmentActivity.this));
        departAdapter.notifyDataSetChanged();
    }

    @Override
    public void onItemDeleteClicked(Department us, int position) {
        boolean rs = DepartmentDataQuery.delete(DepartmentActivity.this, us.ids);
        if (rs) {
            Toast.makeText(this, "Xoá thành công", Toast.LENGTH_LONG).show();
            resetData();
        } else {
            Toast.makeText(this, "Xoá thất bại", Toast.LENGTH_LONG).show();
        }
    }

    @Override
    public void onItemEditClicked(Department us, int position) {
        updateUserDialog(us);
    }
}