package com.google.lenono.customLinearLayout;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.google.lenono.customview.R;

public class CustomLayoutActivity extends AppCompatActivity implements View.OnClickListener{
    CustomLayout customLayout;
    Button btn1,btn2;
    TextView tv;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_custom_layout);
        customLayout= (CustomLayout) findViewById(R.id.customviewgroup);
        btn1= (Button) customLayout.findViewById(R.id.customlayout_btn1);
        btn2= (Button) customLayout.findViewById(R.id.customlayout_btn2);
        tv= (TextView) customLayout.findViewById(R.id.customlayout_tv);
        btn1.setOnClickListener(this);
        btn2.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.customlayout_btn1:
                tv.setText("btn1");
                break;
            case R.id.customlayout_btn2:
                tv.setText("btn2");
                break;
        }
    }
}
