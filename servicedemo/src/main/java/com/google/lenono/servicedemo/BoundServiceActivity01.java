package com.google.lenono.servicedemo;

import android.app.Service;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.IBinder;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class BoundServiceActivity01 extends AppCompatActivity implements View.OnClickListener {
    Button btn1, btn2;
    Intent intent;
    private BoundService01.MyBinder myBinder;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bound_service01);
        btn1 = (Button) this.findViewById(R.id.bound_service01_btn01);
        btn2 = (Button) this.findViewById(R.id.bound_service01_btn02);
        btn1.setOnClickListener(this);
        btn2.setOnClickListener(this);
        intent = new Intent(this, BoundService01.class);
        bindService(intent, new ServiceConnection() {
            @Override
            public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
                myBinder = (BoundService01.MyBinder) iBinder;
            }

            @Override
            public void onServiceDisconnected(ComponentName componentName) {

            }
        }, Context.BIND_AUTO_CREATE);

    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.bound_service01_btn01:
                myBinder.startMusic();
                break;
            case R.id.bound_service01_btn02:
                myBinder.pauseMusic();
                break;
        }
    }
}
