package com.google.lenono.servicedemo;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.IBinder;
import android.os.Parcel;
import android.os.RemoteException;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

public class BoundServiceActivity02 extends AppCompatActivity implements View.OnClickListener {
    Button btn1, btn2, btn3;
    Intent intent;
    BoundService02.MyBinder myBinder;
    boolean isCount = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bound_service02);
        btn1 = (Button) this.findViewById(R.id.bound_service02_btn01);
        btn2 = (Button) this.findViewById(R.id.bound_service02_btn02);
        btn3 = (Button) this.findViewById(R.id.bound_service02_btn03);
        btn1.setOnClickListener(this);
        btn2.setOnClickListener(this);
        btn3.setOnClickListener(this);
        intent = new Intent(this, BoundService02.class);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.bound_service02_btn01:
                bindService(intent, connection, Context.BIND_AUTO_CREATE);
                isCount = true;
                break;
            case R.id.bound_service02_btn02:
                if (isCount) {
                    unbindService(connection);
                }
                break;
            case R.id.bound_service02_btn03:
                Parcel data = Parcel.obtain();
                data.writeString("name");
                Parcel reply = Parcel.obtain();
                try {
                    myBinder.transact(100, data, reply, 1);
                    String name = reply.readString();
                    Log.i("aaa", "reply=" + name);
                } catch (RemoteException e) {
                    e.printStackTrace();
                }
                break;


        }
    }

    ServiceConnection connection = new ServiceConnection() {
        @Override
        public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
            myBinder = (BoundService02.MyBinder) iBinder;

        }

        @Override
        public void onServiceDisconnected(ComponentName componentName) {

        }
    };
}
