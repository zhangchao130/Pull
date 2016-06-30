package com.google.lenono.servicedemo;

import android.media.MediaPlayer;


import android.app.Service;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Binder;
import android.os.IBinder;

public class BoundService01 extends Service {
    private MyBinder myBinder = new MyBinder();
    private MediaPlayer mediaPlayer;

    @Override
    public void onCreate() {
        super.onCreate();
        mediaPlayer = MediaPlayer.create(this, R.raw.yanyuan);
        mediaPlayer.setLooping(true);

    }

    class MyBinder extends Binder {
        public void startMusic() {
            mediaPlayer.start();
        }

        public void pauseMusic() {
            mediaPlayer.pause();
        }
    }

    @Override
    public IBinder onBind(Intent intent) {

        return myBinder;
    }
}
