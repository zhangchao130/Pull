package com.google.lenono.processservice;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

public class AIDLServiceActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_aidlservice);
        Intent intent = new Intent();
        intent.setAction("com.google.processervice.aidlservice");
        startService(intent);
        Log.i("aaa", "AIDL启动了");
    }
}
