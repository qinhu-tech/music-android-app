package com.example.doanmobile.search;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Filter;
import android.widget.Filterable;
import android.widget.RelativeLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.doanmobile.R;

import java.util.ArrayList;
import java.util.List;

import de.hdodenhof.circleimageview.CircleImageView;

public class SearchAdapter extends RecyclerView.Adapter<SearchAdapter.SearchViewHolder> implements Filterable {
    private List<Usersss> mListUsers;
    private final List<Usersss> mListUsersOld;
    public ICLickItemsonglist icLickItemsonglist;

    public SearchAdapter(List<Usersss> mListUsers, ICLickItemsonglist icLickItemsonglist) {
        this.mListUsers = mListUsers;
        this.mListUsersOld = mListUsers;
        this.icLickItemsonglist = icLickItemsonglist;
    }
    @NonNull
    @Override
    public SearchViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_user,parent,false);
        return new SearchViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull SearchViewHolder holder, int position) {
        Usersss usersss = mListUsers.get(position);
        if(usersss==null){
            return;
        }
        holder.imgUser.setImageResource(usersss.getImage());
        holder.tvName1.setText(usersss.getNamess());
        holder.tvAddress.setText(usersss.getAddress());
        holder.layout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                icLickItemsonglist.onClicksongitem(usersss);
            }
        });
    }

    @Override
    public int getItemCount() {
        if(mListUsers != null){
            return mListUsers.size();
        }
        return 0;
    }

    class SearchViewHolder extends RecyclerView.ViewHolder{
        private final CircleImageView imgUser;
        private final TextView tvName1;
        private final TextView tvAddress;
        private final RelativeLayout layout;
        public SearchViewHolder(@NonNull View itemView) {
            super(itemView);
            imgUser = itemView.findViewById(R.id.img_user);
            tvName1 = itemView.findViewById(R.id.tv_name);
            tvAddress = itemView.findViewById(R.id.tv_address);
            layout = itemView.findViewById(R.id.layoutitem);
        }
    }
    @Override
    public Filter getFilter() {
        return new Filter() {
            @Override
            protected FilterResults performFiltering(CharSequence constraint) {
                String strSearch = constraint.toString();
                if(strSearch.isEmpty()){
                    mListUsers=mListUsersOld;
                }else {
                    List<Usersss> list = new ArrayList<>();
                    for (Usersss usersss:mListUsersOld){
                        if(usersss.getNamess().toLowerCase().contains(strSearch.toLowerCase())){
                            list.add(usersss);
                        }
                    }
                    mListUsers = list;
                }
                FilterResults filterResults = new FilterResults();
                filterResults.values=mListUsers;

                return filterResults;
            }
            @Override
            protected void publishResults(CharSequence charSequence, FilterResults results) {
                mListUsers = (List<Usersss>) results.values;
                notifyDataSetChanged();
            }
        };
    }
    public interface ICLickItemsonglist {
        void onClicksongitem(Usersss usersss);
    }
}
