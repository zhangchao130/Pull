package com.google.lenono.animat;

import android.graphics.drawable.AnimationDrawable;
import android.graphics.drawable.Drawable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

public class FrameAnimatJavaActivity extends AppCompatActivity implements View.OnClickListener {
    Button btn1, btn2;
    ImageView iv;
    AnimationDrawable animationDrawable;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_frame_animat_java);
        btn1 = (Button) findViewById(R.id.frame_animat_java_btn1);
        btn2 = (Button) findViewById(R.id.frame_animat_java_btn2);
        iv = (ImageView) findViewById(R.id.frame_animat_java_iv);
        btn1.setOnClickListener(this);
        btn2.setOnClickListener(this);
        animationDrawable = new AnimationDrawable();
        for (int i = 1; i <= 6; i++) {
            int RsId = getResources().getIdentifier("pic" + i, "drawable", "com.google.lenono.animat");
            Drawable drawable = getResources().getDrawable(RsId);
            animationDrawable.addFrame(drawable, 200);
            animationDrawable.setOneShot(false);
        }
        iv.setImageDrawable(animationDrawable);


    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.frame_animat_java_btn1:
                animationDrawable.start();
                break;
            case R.id.frame_animat_java_btn2:
                animationDrawable.stop();
                break;
        }
    }
}
