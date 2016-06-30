package com.google.lenono.processservice;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.os.RemoteException;
import android.util.Log;

import java.util.ArrayList;
import java.util.List;

public class AIDLService extends Service {


    class AIDLInterface extends IMyAidlInterface.Stub {
        @Override
        public int add(int a, int b) throws RemoteException {
            return a + b;
        }

        @Override
        public List<String> getData(List<String> data) throws RemoteException {
            Log.i("aaa", "getData:" + data);
            List<String> list = new ArrayList<String>();
            list.add("lisi");
            return list;
        }



    }

    @Override
    public IBinder onBind(Intent intent) {
        return new AIDLInterface();
    }
}
