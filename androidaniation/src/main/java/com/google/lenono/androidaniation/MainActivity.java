package com.google.lenono.androidaniation;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.view.animation.AnimationSet;
import android.view.animation.RotateAnimation;
import android.view.animation.ScaleAnimation;
import android.view.animation.TranslateAnimation;
import android.widget.Button;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    Button btn1, btn2, btn3, btn4, btn5;
    ImageView iv;
    Animation animation;
    Animation alphaAnimation;
    Animation translateAnimation;
    Animation scaleAnimation;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        iv = (ImageView) findViewById(R.id.iv);
        btn1 = (Button) findViewById(R.id.animation_btn1);
        btn2 = (Button) findViewById(R.id.animation_btn2);
        btn3 = (Button) findViewById(R.id.animation_btn3);
        btn4 = (Button) findViewById(R.id.animation_btn4);
        btn5 = (Button) findViewById(R.id.animation_btn5);
        btn1.setOnClickListener(this);
        btn2.setOnClickListener(this);
        btn3.setOnClickListener(this);
        btn4.setOnClickListener(this);
        btn5.setOnClickListener(this);

    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.animation_btn1:
                //透明度
            animation=new AlphaAnimation(0.1f,1.0f);
            animation.setDuration(3000);
            iv.startAnimation(animation);
                break;
            case R.id.animation_btn2:
                //四个参数 渐变动画 前两个是x轴 从0.1变到1.0  后两个是Y轴 从0.1到1.0
                animation=new ScaleAnimation(0.1f,1.0f,0.1f,1.0f);
                animation.setDuration(2000);
                iv.startAnimation(animation);
                break;
            case R.id.animation_btn3:
                //位移动画
                animation=new TranslateAnimation(0.1f,100.0f,1.0f,100.0f);
                animation.setDuration(3000);
                iv.startAnimation(animation);
                break;
            case R.id.animation_btn4:
               //旋转动画
                animation=new RotateAnimation(10,360,Animation.RELATIVE_TO_SELF,0.5f,Animation.RELATIVE_TO_SELF,0.5f);
                animation.setDuration(3000);
                iv.startAnimation(animation);
                break;
            case R.id.animation_btn5:
                //多个动画
                alphaAnimation=new AlphaAnimation(0.1f,1.0f);
                scaleAnimation=new ScaleAnimation(0.1f,1.0f,0.1f,1.0f);
                translateAnimation=new TranslateAnimation(0.1f,100.0f,1.0f,100.0f);
                AnimationSet set=new AnimationSet(true);
                set.addAnimation(alphaAnimation);
                set.addAnimation(scaleAnimation);
                set.addAnimation(translateAnimation);
                set.setDuration(3000);
                iv.startAnimation(set);
                break;
        }

    }
}
