package com.google.lenono.animat;

import android.graphics.drawable.AnimationDrawable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import com.google.lenono.animat.R;

public class FrameAnimatActivity extends AppCompatActivity implements View.OnClickListener {
    Button btn1, btn2;
    ImageView iv;
    AnimationDrawable animationDrawable;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_frame_animat);
        btn1 = (Button) findViewById(R.id.frame_animat_btn1);
        btn2 = (Button) findViewById(R.id.frame_animat_btn2);
        iv = (ImageView) findViewById(R.id.frame_animat_iv);
        btn1.setOnClickListener(this);
        btn2.setOnClickListener(this);
        animationDrawable = (AnimationDrawable) iv.getBackground();

    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.frame_animat_btn1:
                animationDrawable.start();
                break;

            case R.id.frame_animat_btn2:
                animationDrawable.stop();
                break;

        }
    }
}
