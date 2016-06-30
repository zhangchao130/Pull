package com.google.lenono.servicedemo;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Handler;
import android.os.IBinder;
import android.os.Message;
import android.os.Messenger;
import android.os.RemoteException;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

public class MessengerActivity extends AppCompatActivity implements View.OnClickListener {
    Button btn1, btn2;
    Messenger sendMessenger;
    Messenger clientMessenger;
    Intent intent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_messenger);
        btn2 = (Button) findViewById(R.id.messenger_service01_btn02);
        btn2.setOnClickListener(this);
        intent = new Intent();
        intent.setAction("com.google.lenono.processservice.messengeservice");
        bindService(intent, new ServiceConnection() {
            @Override
            public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
                Log.i("aaa", "连接成功");
                sendMessenger = new Messenger(iBinder);
            }

            @Override
            public void onServiceDisconnected(ComponentName componentName) {

            }
        }, Context.BIND_AUTO_CREATE);
        clientMessenger = new Messenger(new Handler() {
            @Override
            public void handleMessage(Message msg) {
                super.handleMessage(msg);
                Log.i("aaa", "客户端得到的消息：" + msg.arg1+msg.arg2);
            }
        });
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {

            case R.id.messenger_service01_btn02:
                Message message = Message.obtain();
                message.arg1 = 10;
                message.arg2 = 100;
                message.replyTo = clientMessenger;
                try {
                    sendMessenger.send(message);
                } catch (RemoteException e) {
                    e.printStackTrace();
                }
                break;
        }
    }


}
