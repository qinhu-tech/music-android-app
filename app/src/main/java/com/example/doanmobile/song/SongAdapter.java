package com.example.doanmobile.song;

import android.content.Context;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.doanmobile.R;

import java.util.ArrayList;
import java.util.Random;

public class SongAdapter extends RecyclerView.Adapter<SongAdapter.SongViewHolder>{
    ArrayList<Song> lstSong;
    Context contextss;
    SongUserCallback songUserCallback;

    public SongAdapter(ArrayList<Song> lstSong) {
        this.lstSong = lstSong;
    }
    public void setSongCallback(SongUserCallback songUserCallback) {
        this.songUserCallback = songUserCallback;
    }
    @NonNull
    @Override
    public SongViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        contextss = parent.getContext();
        LayoutInflater inflater = LayoutInflater.from(contextss);
        View userViewss = inflater.inflate(R.layout.item_song, parent, false);
        SongViewHolder viewHolder = new SongViewHolder(userViewss);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull SongViewHolder holder, int position) {
        Song item = lstSong.get(position);
        holder.tvTitle.setText(item.getTitle());
        // tao mau ngay nhien cho hinh vector Asset
        Random rnd = new Random();
        int color = Color.argb(255, rnd.nextInt(256), rnd.nextInt(256), rnd.nextInt(256));
        holder.ivSong.setImageResource(R.drawable.baseline_music_note_24);
        holder.ivSong.setColorFilter(color);
        // tao su kien
        holder.ivPlay.setOnClickListener(view -> songUserCallback.onItemClickedPlay(item.getFilename()));
        holder.ivPause.setOnClickListener(view -> songUserCallback.onItemClickedStop());
    }

    @Override
    public int getItemCount() {
        return lstSong.size();
    }

    class SongViewHolder extends RecyclerView.ViewHolder{
        TextView tvTitle;
        ImageView ivPlay;
        ImageView ivPause;
        ImageView ivSong;
        public SongViewHolder(@NonNull View itemView) {
            super(itemView);
            tvTitle = itemView.findViewById(R.id.tv_song_name);
            ivPlay = itemView.findViewById(R.id.iv_play);
            ivPause = itemView.findViewById(R.id.iv_pause);
            ivSong = itemView.findViewById(R.id.iv_song);
        }
    }
    public interface SongUserCallback{
        void onItemClickedPlay(String songName);
        void onItemClickedStop();
    }
}
