package com.google.lenono.ThreeCache;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import com.google.lenono.multimediacompression.R;

public class ThreeCacheActivity extends AppCompatActivity {
    Button btn1, btn2;
    ImageView iv1, iv2;
    ManengerCache manengerCache;
    String urlPath = "http://img0.imgtn.bdimg.com/it/u=2822063245,2815167399&fm=21&gp=0.jpg";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_three_cache);
        btn1 = (Button) findViewById(R.id.threecache_btn01);
        btn2 = (Button) findViewById(R.id.threecache_btn02);
        iv1 = (ImageView) findViewById(R.id.iv1);
        iv2 = (ImageView) findViewById(R.id.iv2);
        manengerCache = new ManengerCache();
        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                manengerCache.getCache(urlPath, iv1);
            }
        });
        btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                manengerCache.getCache(urlPath, iv2);
            }
        });
    }
}
