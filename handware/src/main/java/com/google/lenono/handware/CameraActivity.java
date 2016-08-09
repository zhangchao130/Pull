package com.google.lenono.handware;

import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Environment;
import android.provider.MediaStore;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import java.io.File;
import java.io.FileOutputStream;

public class CameraActivity extends AppCompatActivity {
    ImageView iv;
    Button btn1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_camera);
        iv = (ImageView) findViewById(R.id.camera_iv);
        btn1 = (Button) findViewById(R.id.camera_btn1);
        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
                startActivityForResult(intent, 100);
            }
        });
    }
    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (requestCode == 100 && resultCode == RESULT_OK) {
            Bundle bundle = data.getExtras();
            //系统固定格式
            Bitmap bitmap = (Bitmap) bundle.get("data");
            saveBitmapToSDcard(bitmap, Environment.getExternalStorageDirectory().getAbsolutePath(), "myphoto.png");
            iv.setImageBitmap(bitmap);

        }
        super.onActivityResult(requestCode, resultCode, data);
    }
    public void saveBitmapToSDcard(Bitmap bitmap, String path, String fileName) {
        if (Environment.MEDIA_MOUNTED.equals(Environment.getExternalStorageState())) {
            String filepath=path +File.separator+ fileName;
            File file = new File(filepath);
            FileOutputStream fos = null;
            try {
                fos = new FileOutputStream(file);
                bitmap.compress(Bitmap.CompressFormat.PNG, 100, fos);
                Log.i("aaa",filepath);
                fos.flush();
                fos.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}
