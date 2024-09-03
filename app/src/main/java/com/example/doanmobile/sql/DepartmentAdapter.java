package com.example.doanmobile.sql;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.constraintlayout.motion.widget.FloatLayout;
import androidx.recyclerview.widget.RecyclerView;

import com.example.doanmobile.R;

import java.util.ArrayList;

public class DepartmentAdapter extends RecyclerView.Adapter<DepartmentAdapter.DepartmentViewHolder>{
    ArrayList<Department> lstDepart;
    Context contexts;
    DepartmentCallback userCallback;
    // Hàm khởi tạo để tương tác với list
    public DepartmentAdapter(ArrayList<Department> lstDepart) {
        this.lstDepart = lstDepart;
    }
    // hàm khởi tạo cho tương tác với item
    public void setCallback(DepartmentCallback callback) {
        this.userCallback = callback;
    }
    // Hàm khởi tạo để tương tác với list
    @NonNull
    @Override
    public DepartmentViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        contexts = parent.getContext();
        LayoutInflater inflater = LayoutInflater.from(contexts);
        // Nạp layout cho View biểu diễn phần tử user
        View userViews = inflater.inflate(R.layout.layoutitemtext, parent, false);

        DepartmentViewHolder viewHolder = new DepartmentViewHolder(userViews);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull DepartmentViewHolder holder, int position) {
        // lấy từng item của dữ liệu
        Department item = lstDepart.get(position);
        // gán vào item của view
        holder.tvNames.setText(position + 1 +" - "+ item.getNames());
        // bat su kien
        holder.ivDelete.setOnClickListener(view -> userCallback.onItemDeleteClicked(item, position));
        holder.ivEdit.setOnClickListener(view -> userCallback.onItemEditClicked(item, position));
    }

    @Override
    public int getItemCount() {
        return lstDepart.size();
    }

    class DepartmentViewHolder extends RecyclerView.ViewHolder{
        TextView tvNames;
        ImageView ivEdit;
        ImageView ivDelete;
        public DepartmentViewHolder(@NonNull View itemView) {
            super(itemView);
            tvNames = itemView.findViewById(R.id.tvNamee);
            ivEdit= itemView.findViewById(R.id.ivEdit);
            ivDelete= itemView.findViewById(R.id.ivDelete);
        }
    }
    // dùng để thực hiện thao tác xoá, cập nhật trên dòng
    public interface DepartmentCallback{
        void onItemDeleteClicked(Department us, int position);
        void onItemEditClicked(Department us, int position);
    }
}
