package com.google.lenono.boradcastreceiver;

import android.content.IntentFilter;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

public class BroadcastRecevierActivity_Call extends AppCompatActivity {
    private BroadcastReceiver_Call broadcastReceiver_call;
    private IntentFilter intentFilter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_broadcast_recevier_activity__call);
        broadcastReceiver_call = new BroadcastReceiver_Call();
        intentFilter = new IntentFilter();
        intentFilter.addAction("android.intent.action.NEW_OUTGOING_CALL");
        intentFilter.addAction("android.intent.action.PHONE_STATE");
        registerReceiver(broadcastReceiver_call,intentFilter);
        Log.i("aaa","oncreate");







    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        unregisterReceiver(broadcastReceiver_call);
        Log.i("ccc","onDestroy");
    }
}
