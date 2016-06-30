package com.google.lenono.servicedemo;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class IntentServiceActivity01 extends AppCompatActivity {
    Intent intent;
    private String urlPtah = "http://f.hiphotos.baidu.com/image/h%3D300/sign=4c454181d643ad4bb92e40c0b2025a89/03087bf40ad162d967a5de3816dfa9ec8a13cd4f.jpg";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_intent_service01);
        intent = new Intent(this, IntentService01.class);
        intent.putExtra("name", urlPtah);
        startService(intent);
    }
}
