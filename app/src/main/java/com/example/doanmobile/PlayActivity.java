package com.example.doanmobile;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Context;
import android.media.AudioManager;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.view.View;
import android.widget.ImageView;
import android.widget.SeekBar;
import android.widget.TextView;

import java.util.ArrayList;

public class PlayActivity extends AppCompatActivity {
    ImageView play,prev,next,imageView;
    TextView songTitle;
    SeekBar mSeekBarTime,mSeekBarVol;
    static MediaPlayer mMediaPlayer;
    private Runnable runnable;
    private AudioManager mAudioManager;
    int currentIndex = 0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_play);
        play=findViewById(R.id.play);
        prev=findViewById(R.id.prev);
        next=findViewById(R.id.next);
        imageView=findViewById(R.id.imageview);
        songTitle=findViewById(R.id.song_title);
        mSeekBarTime=findViewById(R.id.seek_bar_title);
        mSeekBarVol=findViewById(R.id.seek_bar_volume);
        mAudioManager = (AudioManager) getSystemService(Context.AUDIO_SERVICE);
        final ArrayList<Integer> song = new ArrayList<>();
        song.add(0,R.raw.chacaidoseve);
        song.add(1,R.raw.chungtakhongthuocvenhau);
        song.add(2,R.raw.iceman);
        song.add(3,R.raw.haytraochoanh);
        song.add(4,R.raw.nangamxadan);
        song.add(5,R.raw.thoiemdungdi);
        song.add(6,R.raw.nguoinhuanh);
        song.add(7,R.raw.vetinh);
        int maxV = mAudioManager.getStreamMaxVolume(AudioManager.STREAM_MUSIC);
        int curV=mAudioManager.getStreamVolume(AudioManager.STREAM_MUSIC);
        mMediaPlayer = MediaPlayer.create(getApplicationContext(),song.get(currentIndex));
        mSeekBarVol.setMax(maxV);
        mSeekBarVol.setProgress(curV);
        mSeekBarVol.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                mAudioManager.setStreamVolume(AudioManager.STREAM_MUSIC,progress,0);
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });
        play.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mSeekBarTime.setMax(mMediaPlayer.getDuration());
                if(mMediaPlayer!=null && mMediaPlayer.isPlaying()){
                    mMediaPlayer.pause();
                    play.setImageResource(R.drawable.play);
                }else{
                    mMediaPlayer.start();
                    play.setImageResource(R.drawable.pause);
                }
                songDetails();
            }
        });
        next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(mMediaPlayer != null){
                    play.setImageResource(R.drawable.pause);
                }
                if(currentIndex<song.size()-1){
                    currentIndex++;
                }else {
                    currentIndex=0;
                }if(mMediaPlayer.isPlaying()){
                    mMediaPlayer.stop();
                }
                mMediaPlayer = MediaPlayer.create(getApplicationContext(),song.get(currentIndex));
                mMediaPlayer.start();
                songDetails();
            }
        });
        prev.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(mMediaPlayer!=null){
                    play.setImageResource(R.drawable.pause);
                }
                if(currentIndex>0){
                    currentIndex--;
                }else {
                    currentIndex=song.size()-1;
                }
                if(mMediaPlayer.isPlaying()){
                    mMediaPlayer.start();
                }
                mMediaPlayer = MediaPlayer.create(getApplicationContext(),song.get(currentIndex));
                songDetails();
            }
        });
        mSeekBarTime.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                if(fromUser){
                    mMediaPlayer.seekTo(progress);
                    mSeekBarTime.setProgress(progress);
                }
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });
    }
    private void songDetails() {
        if (currentIndex == 0) {
            songTitle.setText("Chắc Ai Đó Sẽ Về - Sơn Tùng M-TP");
            imageView.setImageResource(R.drawable.chacaidoseve);
        }
        if (currentIndex == 1) {
            songTitle.setText("Chúng Ta Không Thuộc Về Nhau - Sơn Tùng M-TP");
            imageView.setImageResource(R.drawable.chungtakhongthuocvenhau);
        }
        if (currentIndex == 2) {
            songTitle.setText("ICEMAN - Sol7, RPT MCK, DCOD");
            imageView.setImageResource(R.drawable.iceman);
        }
        if (currentIndex == 3) {
            songTitle.setText("Hãy Trao Cho Anh - Sơn Tùng M-TP");
            imageView.setImageResource(R.drawable.haytraochoanh);
        }
        if (currentIndex == 4) {
            songTitle.setText("Nẵng Ấm Xa Dần - Sơn Tùng M-TP");
            imageView.setImageResource(R.drawable.nangamxadan);
        }
        if (currentIndex == 5) {
            songTitle.setText("Thôi Em Đừng Đi - RPT MCK, Trung Trần");
            imageView.setImageResource(R.drawable.thoiemdungdi);
        }
        if (currentIndex == 6) {
            songTitle.setText("Người Như Anh - Mai Tiến Dũng");
            imageView.setImageResource(R.drawable.nguoinhuanh);
        }
        if (currentIndex == 7) {
            songTitle.setText("Vệ Tinh -  HIEUTHUHAI, Hoàng Tôn, Kewtiie");
            imageView.setImageResource(R.drawable.vetinh);
        }
        mMediaPlayer.setOnPreparedListener(new MediaPlayer.OnPreparedListener() {
            @Override
            public void onPrepared(MediaPlayer mediaPlayer) {
                mSeekBarTime.setMax(mMediaPlayer.getDuration());
                mMediaPlayer.start();
            }
        });
        new Thread(new Runnable() {
            @Override
            public void run() {
                while (mMediaPlayer != null) {
                    try {
                        if (mMediaPlayer.isPlaying()) {
                            Message message = new Message();
                            message.what = mMediaPlayer.getCurrentPosition();
                            handler.sendMessage(message);
                            Thread.sleep(1000);
                        }
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        }).start();
    }
    @SuppressLint("HandlerLeak")
    Handler handler=new Handler(){
        @Override
        public void handleMessage(@NonNull Message msg) {
            mSeekBarTime.setProgress(msg.what);
        }
    };
}