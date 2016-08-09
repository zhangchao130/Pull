package com.google.lenono.tweenanimat;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.ImageView;

import com.google.lenono.animat.R;

public class AlphaTweenAnimatActivity extends AppCompatActivity implements View.OnClickListener {
    Button btn1, btn2, btn3, btn4, btn5;
    ImageView iv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_alpha_tween_animat);
        btn1 = (Button) findViewById(R.id.tween01_btn01);
        btn2 = (Button) findViewById(R.id.tween01_btn02);
        btn3 = (Button) findViewById(R.id.tween01_btn03);
        iv = (ImageView) findViewById(R.id.tween01_iv01);
        btn4 = (Button) findViewById(R.id.tween01_btn04);
        btn5 = (Button) findViewById(R.id.tween01_btn05);
        btn1.setOnClickListener(this);
        btn2.setOnClickListener(this);
        btn3.setOnClickListener(this);
        btn4.setOnClickListener(this);
        btn5.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.tween01_btn01:
                Animation animation = AnimationUtils.loadAnimation(AlphaTweenAnimatActivity.this, R.anim.alpha_xml);
                iv.startAnimation(animation);
                break;
            case R.id.tween01_btn02:
                Animation animation1 = AnimationUtils.loadAnimation(AlphaTweenAnimatActivity.this, R.anim.scale_xml);
                iv.startAnimation(animation1);
                break;
            case R.id.tween01_btn03:
                Animation animation2 = AnimationUtils.loadAnimation(AlphaTweenAnimatActivity.this, R.anim.translate);
                iv.startAnimation(animation2);
                break;
            case R.id.tween01_btn04:
                Animation animation3 = AnimationUtils.loadAnimation(AlphaTweenAnimatActivity.this, R.anim.roate_xml);
                iv.startAnimation(animation3);
                break;
            case R.id.tween01_btn05:
                Animation animation4=AnimationUtils.loadAnimation(AlphaTweenAnimatActivity.this,R.anim.set_xml);
                iv.startAnimation(animation4);
                break;
        }
    }
}
