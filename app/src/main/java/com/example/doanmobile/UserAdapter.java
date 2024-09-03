package com.example.doanmobile;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class UserAdapter extends RecyclerView.Adapter<UserAdapter.UserViewHolder> {
    ArrayList<User> lstUser;
    Context context;
    Usercallback userCallback;

    public UserAdapter(ArrayList<User> lstUser, Usercallback userCallback) {
        this.lstUser = lstUser;
        this.userCallback = userCallback;
    }

    @NonNull
    @Override
    public UserViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        context = parent.getContext();
        LayoutInflater inflater = LayoutInflater.from(context);
        // Nạp layout cho View biểu diễn phần tử User
        View userView = inflater.inflate(R.layout.layoutitem, parent, false);
        //
        UserViewHolder viewHolder = new UserViewHolder(userView);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull UserViewHolder holder, int position) {
        // lấy từng item của dữ liệu
        User item = lstUser.get(position);
        // gán vào item của view
        holder.imAvarta.setImageBitmap(Utils.convertToBitmapFromAssets(context, item.getAvatar()));
        holder.tvName.setText(item.getName());
        // lấy sự kiện
        holder.itemView.setOnClickListener(view -> userCallback.onItemClick(item.getId()));
    }

    @Override
    public int getItemCount() {
        return lstUser.size();
    }

    class UserViewHolder extends RecyclerView.ViewHolder{
        ImageView imAvarta;
        TextView tvName;
        public UserViewHolder(@NonNull View itemView) {
            super(itemView);
            imAvarta = itemView.findViewById(R.id.ivAvartar);
            tvName = itemView.findViewById(R.id.tvName);
        }
    }
    public interface Usercallback{
        void onItemClick(String id);
    }
}
