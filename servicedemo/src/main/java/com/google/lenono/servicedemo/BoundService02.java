package com.google.lenono.servicedemo;

import android.app.Service;
import android.content.Intent;
import android.os.Binder;
import android.os.Handler;
import android.os.IBinder;
import android.os.Parcel;
import android.os.RemoteException;
import android.util.Log;

public class BoundService02 extends Service {
    MyBinder myBinder = new MyBinder();

    public BoundService02() {
    }

    class MyBinder extends Binder {
        @Override
        protected boolean onTransact(int code, Parcel data, Parcel reply, int flags) throws RemoteException {
            String name = data.readString();
            Log.i("aaa", "pracel data=" + name);
            reply.writeString("张超");
            return super.onTransact(code, data, reply, flags);
        }
    }

    @Override
    public IBinder onBind(Intent intent) {
        Log.i("aaa","onBind");
        return myBinder;
    }

    @Override
    public void onCreate() {
        super.onCreate();
        Log.i("aaa","onCreat");
    }

    @Override
    public boolean onUnbind(Intent intent) {
        Log.i("aaa","onUnbind");
        return super.onUnbind(intent);
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        Log.i("aaa","onDestroy");
    }
}
