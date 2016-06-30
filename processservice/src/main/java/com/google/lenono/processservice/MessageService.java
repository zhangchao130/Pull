package com.google.lenono.processservice;

import android.app.Service;
import android.content.Intent;
import android.os.Handler;
import android.os.IBinder;
import android.os.Message;
import android.os.Messenger;
import android.os.RemoteException;
import android.util.Log;

public class MessageService extends Service {
    Messenger messenger = new Messenger(new Handler() {
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            Log.i("aaa", msg.arg1 + ":" + msg.arg2);
            //通过客户端传递过来的消息，创建服务端
            Message message = Message.obtain(msg);
            //把服务端的消息传递给客户端
            message.arg1 = msg.arg1 + msg.arg2;
            try {

                message.replyTo.send(message);
            } catch (RemoteException e) {
                e.printStackTrace();
            }
        }
    });


    @Override
    public IBinder onBind(Intent intent) {
        return messenger.getBinder();
    }
}
