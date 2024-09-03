package com.example.doanmobile.sql;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.os.RecoverySystem;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import com.example.doanmobile.R;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.ArrayList;

public class MainActivity2 extends AppCompatActivity implements UserAdapters.UserCallbacks{
    RecyclerView rvListCode;
    ArrayList<Userss> lstUsers;
    UserAdapters userAdapters;
    FloatingActionButton fbAdd;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        rvListCode = findViewById(R.id.rvLists);
        fbAdd = findViewById(R.id.fbAdd);
        fbAdd.setOnClickListener(view -> addUserDialog());
        // lấy dữ liệu
        lstUsers = UserDataQuery.getAll(this);
        userAdapters = new UserAdapters(lstUsers);
        userAdapters.setCallback(this);
        // gan adapter
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        rvListCode.setAdapter(userAdapters);
        rvListCode.setLayoutManager(linearLayoutManager);
    }

    void addUserDialog() {
        // khởi tạo dialog để thêm người dùng.
        AlertDialog.Builder alertDialog = new AlertDialog.Builder(MainActivity2.this);
        alertDialog.setTitle("Thêm mới");
        LayoutInflater inflater = this.getLayoutInflater();
        View dialogView = inflater.inflate(R.layout.dialog_add_user, null);
        alertDialog.setView(dialogView);
        EditText edName = dialogView.findViewById(R.id.edName);
        EditText edAvatar = dialogView.findViewById(R.id.edAvatar);
        // load phòng ban
        Spinner snPart= dialogView.findViewById(R.id.snDepart);
        ArrayList<Department> lstDepart= DepartmentDataQuery.getAll(this);
        lstDepart.add(0,new Department(0,"Chọn nhóm nhạc"));
        ArrayAdapter<Department> departmentArrayAdapter= new ArrayAdapter<>(this, android.R.layout.simple_spinner_item,lstDepart);
        departmentArrayAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        snPart.setAdapter(departmentArrayAdapter);
        //
        alertDialog.setPositiveButton("Đồng ý", (dialog, which) -> {
            String names = edName.getText().toString();
            String avatars = edAvatar.getText().toString();
            Department itemde=(Department) snPart.getSelectedItem();
            if (itemde.ids==0)
            {
                Toast.makeText(MainActivity2.this, "Vui lòng chọn phòng ban", Toast.LENGTH_LONG).show();

            } else
            if (names.isEmpty()) {
                Toast.makeText(MainActivity2.this, "Nhập dữ liệu không hợp lệ", Toast.LENGTH_LONG).show();
            } else {
                Userss us = new Userss(0, names, avatars);
                us.departid= itemde.ids;
                long id = UserDataQuery.insert(MainActivity2.this, us);
                if (id > 0) {
                    Toast.makeText(MainActivity2.this, "Thêm người dùng thành công.", Toast.LENGTH_LONG).show();
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

    void updateUserDialog(Userss us) {
        // khởi tạo dialog để cập nhật người dùng
        AlertDialog.Builder alertDialog = new AlertDialog.Builder(MainActivity2.this);
        alertDialog.setTitle("Cập nhật");
        LayoutInflater inflater = this.getLayoutInflater();
        View dialogView = inflater.inflate(R.layout.dialog_add_user, null);
        alertDialog.setView(dialogView);
        EditText edNames = dialogView.findViewById(R.id.edName);
        EditText edAvatars = dialogView.findViewById(R.id.edAvatar);
        // load phòng ban
        Spinner snPart= dialogView.findViewById(R.id.snDepart);
        ArrayList<Department> lstDepart= DepartmentDataQuery.getAll(this);
        lstDepart.add(0,new Department(0,"Chọn nhóm nhạc"));
        ArrayAdapter<Department> departmentArrayAdapter= new ArrayAdapter<>(this, android.R.layout.simple_spinner_item,lstDepart);
        departmentArrayAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        snPart.setAdapter(departmentArrayAdapter);
        //

        // gán dữ liệu
        edNames.setText(us.getNames());
        edAvatars.setText(us.getAvatars());
        snPart.setSelection(us.departid);
        //se
        alertDialog.setPositiveButton("Đồng ý", (dialog, which) -> {

            us.setNames(edNames.getText().toString());
            us.setAvatars(edAvatars.getText().toString());
            Department itemde=(Department) snPart.getSelectedItem();
            if (itemde.ids==0)
            {
                Toast.makeText(MainActivity2.this, "Vui lòng chọn phòng ban", Toast.LENGTH_LONG).show();

            } else
            if (us.names.isEmpty()) {
                Toast.makeText(MainActivity2.this, "Nhập dữ liệu không hợp lệ", Toast.LENGTH_LONG).show();
            } else {
                us.departid= itemde.ids;
                int ids = UserDataQuery.update(MainActivity2.this, us);
                if (ids > 0) {
                    Toast.makeText(MainActivity2.this, "Cập nhật người dùng thành công.", Toast.LENGTH_LONG).show();
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
        lstUsers.clear();
        lstUsers.addAll(UserDataQuery.getAll(MainActivity2.this));
        userAdapters.notifyDataSetChanged();
    }

    @Override
    public void onItemDeleteClicked(Userss us, int position) {
        boolean rs = UserDataQuery.delete(MainActivity2.this, us.ids);
        if (rs) {
            Toast.makeText(this, "Xoá thành công", Toast.LENGTH_LONG).show();
            resetData();
        } else {
            Toast.makeText(this, "Xoá thất bại", Toast.LENGTH_LONG).show();
        }
    }

    @Override
    public void onItemEditClicked(Userss us, int position) {
        updateUserDialog(us);
    }
}