package com.google.lenono.servicedemo;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class StartServiceActivity02 extends AppCompatActivity implements View.OnClickListener{
Button btn1;
    Intent intent;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_start_service02);
        intent =new Intent(this,StartService02.class);
        btn1=(Button)findViewById(R.id.start_service02_btn1);
        btn1.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.start_service02_btn1:
                startService(intent);
                break;
        }
    }
}
