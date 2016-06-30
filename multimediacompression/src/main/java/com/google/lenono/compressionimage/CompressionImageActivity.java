package com.google.lenono.compressionimage;

import android.graphics.Bitmap;
import android.os.Handler;
import android.os.Message;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import com.google.lenono.multimediacompression.R;

public class CompressionImageActivity extends AppCompatActivity {
    Button btn01;
    ImageView iv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_compression_image);
        btn01 = (Button) findViewById(R.id.compression01_btn01);
        iv = (ImageView) findViewById(R.id.iv);
        btn01.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                new Thread() {
                    @Override
                    public void run() {
                        byte[] data = HttpUtils.request("http://img0.imgtn.bdimg.com/it/u=3675135198,1516761238&fm=11&gp=0.jpg");
                        Bitmap bitmap = Imagecompression.getCompressonImage(data,100, 100);
                        Message msg = Message.obtain();
                        msg.obj = bitmap;
                        handler.sendMessage(msg);
                    }
                }.start();
            }
        });
    }

    Handler handler = new Handler() {
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            Bitmap bitmap = (Bitmap) msg.obj;
            iv.setImageBitmap(bitmap);
        }
    };
}
