package com.google.lenono.servicedemo;

import android.app.IntentService;
import android.app.Service;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Environment;
import android.os.Handler;
import android.os.IBinder;
import android.os.Message;
import android.widget.Toast;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

public class IntentService01 extends IntentService {
    MyHandler myHandler = null;

    public IntentService01() {
        super("IntentService01");
        myHandler = new MyHandler();
    }

    class MyHandler extends Handler {
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);

            if (msg.what == 1) {
                Toast.makeText(getApplicationContext(), "下载完成", Toast.LENGTH_LONG).show();
            }
        }
    }

    @Override
    protected void onHandleIntent(Intent intent) {
        boolean flg = saveFile(HttpUtils(intent.getStringExtra("name")), "girl.jpg");
        if (flg) {
            myHandler.sendEmptyMessage(1);
        }

    }

    public boolean saveFile(byte[] data, String fileName) {
        boolean flag = false;
        if (Environment.getExternalStorageState().equals(Environment.MEDIA_MOUNTED)) {
            File root = Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_DOWNLOADS);
            File file = new File(root, fileName);
            FileOutputStream fos = null;
            try {
                fos = new FileOutputStream(file);
                fos.write(data, 0, data.length);
            } catch (Exception e) {
                e.printStackTrace();
            } finally {
                if (fos != null) {
                    try {
                        fos.close();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            }
            flag = true;
            return flag;
        }
        return flag;
    }

    public byte[] HttpUtils(String urlPath) {
        ByteArrayOutputStream baos = null;
        try {
            URL url = new URL(urlPath);
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            connection.setDoInput(true);
            connection.setRequestMethod("GET");
            connection.setReadTimeout(10000);
            connection.setConnectTimeout(10000);
            connection.connect();
            if (connection.getResponseCode() == 200) {
                InputStream is = connection.getInputStream();
                baos = new ByteArrayOutputStream();
                byte[] b = new byte[100];
                int len = -1;
                while ((len = is.read(b)) != -1) {
                    baos.write(b, 0, len);
                }
                is.close();
                byte[] result = baos.toByteArray();
                if (result != null) {
                    baos.close();
                }
                return result;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
}
