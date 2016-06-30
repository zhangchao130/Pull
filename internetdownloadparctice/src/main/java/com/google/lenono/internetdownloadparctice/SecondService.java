package com.google.lenono.internetdownloadparctice;

import android.app.Service;
import android.content.Context;
import android.content.Intent;
import android.os.Binder;
import android.os.Handler;
import android.os.IBinder;
import android.os.Message;
import android.util.Log;

import com.google.lenono.internetdownloadparctice.SQLite.NewsDaoService;
import com.google.lenono.internetdownloadparctice.utils.MyAdapter;

public class SecondService extends Service {
    private MyBinder myBinder = new MyBinder();

    private Handler handler;

    public SecondService() {
    }

    @Override
    public void onCreate() {
        super.onCreate();
        handler = new Handler() {
            @Override
            public void handleMessage(Message msg) {
                super.handleMessage(msg);
                if (msg.what == 2) {

                    NewsActivity.adapter.notifyDataSetChanged();

                }
            }
        };


    }

    class MyBinder extends Binder {
        public void updata() {
            new Thread() {
                @Override
                public void run() {
                    super.run();
                    NewsActivity.data.clear();
                    NewsDaoService newsDaoService = new NewsDaoService(getApplicationContext());
                    NewsActivity.data.addAll(newsDaoService.getAllNewsListData());
                    Log.i("bbb", "数据添加成功");
                    handler.sendEmptyMessage(2);

                }
            }.start();
        }


    }

    @Override
    public IBinder onBind(Intent intent) {
        return myBinder;
    }
}
