package com.google.lenono.servicedemo;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class StartServiceActivity03 extends AppCompatActivity implements View.OnClickListener {
    Button btn;
    Intent intent;
    String urlPath = "http://img1.imgtn.bdimg.com/it/u=2948830857,1878924554&fm=21&gp=0.jpg";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_start_service03);
        btn = (Button) findViewById(R.id.start_service03_btn1);
        btn.setOnClickListener(this);
        intent = new Intent(this, StartService03.class);
        intent.putExtra("urlPath", urlPath);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.start_service03_btn1:
                startService(intent);
                break;
        }
    }
}
