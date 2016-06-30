package com.google.lenono.boradcastreceiver;

import android.content.Intent;
import android.content.IntentFilter;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class BroadcastRecevierActivity02 extends AppCompatActivity implements View.OnClickListener {
    Button btn1, btn2, btn3;
    BroadcastService04 broadcastService04;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_broadcast_recevier02);
        btn1 = (Button) findViewById(R.id.broadcastrecevier_activity02_btn01);
        btn2 = (Button) findViewById(R.id.broadcastrecevier_activity02_btn02);
        btn3 = (Button) findViewById(R.id.broadcastrecevier_activity02_btn03);
        btn1.setOnClickListener(this);
        btn2.setOnClickListener(this);
        btn3.setOnClickListener(this);
        broadcastService04=new BroadcastService04();
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.broadcastrecevier_activity02_btn01:
                IntentFilter intentFilter = new IntentFilter();
                intentFilter.addAction("code");
                registerReceiver(broadcastService04, intentFilter);
                break;
            case R.id.broadcastrecevier_activity02_btn02:
                unregisterReceiver(broadcastService04);
                break;
            case R.id.broadcastrecevier_activity02_btn03:
                Intent intent = new Intent();
                intent.setAction("code");
                sendBroadcast(intent);
                break;
        }

    }
}
