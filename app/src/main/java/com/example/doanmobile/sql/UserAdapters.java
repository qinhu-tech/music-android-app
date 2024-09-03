package com.example.doanmobile.sql;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.doanmobile.R;
import com.example.doanmobile.UserAdapter;

import java.util.ArrayList;

public class UserAdapters extends RecyclerView.Adapter<UserAdapters.UsersViewHolder>{
    ArrayList<Userss> lstUsers;
    Context contexts;
    UserCallbacks userCallbacks;
    // Hàm khởi tạo để tương tác với list
    public UserAdapters(ArrayList<Userss> lstUsers) {
        this.lstUsers = lstUsers;
    }
    // ham khoi tao cho tuong tac voi item
    public void setCallback(UserCallbacks callback) {this.userCallbacks = callback;}

    @NonNull
    @Override
    public UsersViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        contexts = parent.getContext();
        LayoutInflater inflater = LayoutInflater.from(contexts);
        //Nap layout cho View bieu dien phan tu user
        View userViews = inflater.inflate(R.layout.layoutitems, parent, false);
        //
        UsersViewHolder viewHolder = new UsersViewHolder(userViews);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull UsersViewHolder holder, int position) {
        // lay tung item cua du lieu
        Userss item = lstUsers.get(position);
        // gan vao item cua view
        holder.imAvartas.setImageBitmap(Util.convertToBitmapFromAssets(contexts, item.getAvatars()));
        holder.tvNames.setText(item.getNames() + " - "+ item.departname);
        //bat su kien
        holder.ivDelete.setOnClickListener(view -> userCallbacks.onItemDeleteClicked(item, position));
        holder.ivEdit.setOnClickListener(view -> userCallbacks.onItemEditClicked(item, position));
    }

    @Override
    public int getItemCount() {
        return lstUsers.size();
    }

    class UsersViewHolder extends RecyclerView.ViewHolder{
        ImageView imAvartas;
        TextView tvNames;
        ImageView ivEdit;
        ImageView ivDelete;
        public UsersViewHolder(@NonNull View itemView) {
            super(itemView);
            imAvartas = itemView.findViewById(R.id.ivAvartarr);
            tvNames = itemView.findViewById(R.id.tvNamee);
            ivEdit = itemView.findViewById(R.id.ivEdit);
            ivDelete = itemView.findViewById(R.id.ivDelete);
        }
    }
    // dung de thuc hien thao tac xoa, cap nhat tren dong
    public interface UserCallbacks{
        void onItemDeleteClicked(Userss us, int position);
        void onItemEditClicked(Userss us, int position);
    }
}
