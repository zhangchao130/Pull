package com.google.lenono.servicedemo;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class StratServiceActivity01 extends AppCompatActivity implements View.OnClickListener{
    Button btn1,btn2;
    Intent intent;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_strat_service01);
        btn1=(Button) this.findViewById(R.id.start_seriver01_btn01);
        btn2=(Button)this.findViewById(R.id.start_seriver01_btn02);


        btn1.setOnClickListener(this);
        btn2.setOnClickListener(this);
        intent=new Intent(this,StartService01.class);
    }

    @Override
    public void onClick(View view) {
    switch (view.getId()){
        case R.id.start_seriver01_btn01:
            startService(intent);
            break;
        case R.id.start_seriver01_btn02:
            stopService(intent);
            break;
    }
    }
}
