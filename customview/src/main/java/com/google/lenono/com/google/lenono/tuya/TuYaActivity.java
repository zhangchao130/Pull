package com.google.lenono.com.google.lenono.tuya;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.DisplayMetrics;

import com.google.lenono.customview.R;

public class TuYaActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        DisplayMetrics displayMetrics = new DisplayMetrics();
        getWindowManager().getDefaultDisplay().getMetrics(displayMetrics);
        TuYaView tuYaView = new TuYaView(this, displayMetrics.widthPixels, displayMetrics.heightPixels);
        setContentView(tuYaView);
    }
}
