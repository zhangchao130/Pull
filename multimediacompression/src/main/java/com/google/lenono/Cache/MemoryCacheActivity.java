package com.google.lenono.Cache;

import android.content.DialogInterface;
import android.graphics.Bitmap;
import android.os.Handler;
import android.os.Message;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import com.google.lenono.compressionimage.HttpUtils;
import com.google.lenono.compressionimage.Imagecompression;
import com.google.lenono.multimediacompression.R;

public class MemoryCacheActivity extends AppCompatActivity implements View.OnClickListener {
    Button btn1, btn2;
    ImageView iv1, iv2;
    MomeryCache momeryCache;
    final String urlPath = "http://img5.imgtn.bdimg.com/it/u=2778594908,1075061475&fm=21&gp=0.jpg";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_memory_cache);
        btn1 = (Button) findViewById(R.id.momerycache_btn01);
        btn2 = (Button) findViewById(R.id.momerycache_btn02);
        iv1 = (ImageView) findViewById(R.id.momerycache_iv01);
        iv2 = (ImageView) findViewById(R.id.momerycache_iv02);
        btn1.setOnClickListener(this);
        btn2.setOnClickListener(this);
        momeryCache = new MomeryCache();
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.momerycache_btn01:
                new Thread(new Runnable() {
                    @Override
                    public void run() {
                        byte[] data = HttpUtils.request(urlPath);
                        Bitmap bitmap = Imagecompression.getCompressonImage(data, 80, 80);
                        momeryCache.addBitmapToLruCache(urlPath, bitmap);
                        Message message = Message.obtain();
                        message.obj = momeryCache.getBitmapFromLruCache(urlPath);
                        handler.sendMessage(message);
                    }
                }).start();


                break;
            case R.id.momerycache_btn02:
                Log.i("aaa","11111");
                Bitmap bitmap = momeryCache.getBitmapFromLruCache(urlPath);
                if (bitmap != null) {
                    Log.i("aaa","22222");
                    iv2.setImageBitmap(bitmap);
                }
                break;

        }
    }

    Handler handler = new Handler() {
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            iv1.setImageBitmap((Bitmap) msg.obj);
        }
    };
}
