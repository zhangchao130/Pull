package com.google.lenono.servicedemo;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.IBinder;
import android.os.RemoteException;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import com.google.lenono.processservice.IMyAidlInterface;

import java.util.ArrayList;
import java.util.List;

public class AIDLClientActivity extends AppCompatActivity implements View.OnClickListener {
    Button btn1, btn2;
    IMyAidlInterface iMyAidlInterface;
    Intent intent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_aidlacitivity);
        btn1 = (Button) findViewById(R.id.aidl_processservice01_btn01);
        btn2 = (Button) findViewById(R.id.aidl_processservice01_btn02);
        btn1.setOnClickListener(this);
        btn2.setOnClickListener(this);
        intent = new Intent();
        intent.setAction("com.google.processervice.aidlservice");


    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.aidl_processservice01_btn01:
                bindService(intent, connection, Context.BIND_AUTO_CREATE);
                Log.i("aaa", "连接成功");
                break;
            case R.id.aidl_processservice01_btn02:
                try {
                    int result = iMyAidlInterface.add(1,2);
                    Log.i("aaa", "result=" + result);
                    List<String> data = new ArrayList<String>();
                    String name = iMyAidlInterface.getData(data).toString();
                    Log.i("aaa", "服务端返回的信息：" + name);

                } catch (RemoteException e) {
                    e.printStackTrace();
                }
                break;
        }

    }

    ServiceConnection connection = new ServiceConnection() {
        @Override
        public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
            iMyAidlInterface = IMyAidlInterface.Stub.asInterface(iBinder);
        }

        @Override
        public void onServiceDisconnected(ComponentName componentName) {

        }
    };
}
