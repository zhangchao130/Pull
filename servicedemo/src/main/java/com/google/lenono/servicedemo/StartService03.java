package com.google.lenono.servicedemo;

import android.app.NotificationManager;
import android.app.Service;
import android.content.Context;
import android.content.Intent;
import android.os.Environment;
import android.os.Handler;
import android.os.IBinder;
import android.os.Message;
import android.support.v7.app.NotificationCompat;
import android.util.Log;
import android.widget.Toast;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;

public class StartService03 extends Service {
    private NotificationManager manager;
    private NotificationCompat.Builder builder;
    private MyHandler myHandler;

    public StartService03() {
    }

    @Override
    public void onCreate() {
        super.onCreate();
        myHandler = new MyHandler();
        manager = (NotificationManager) getSystemService(Context.NOTIFICATION_SERVICE);
        builder = new NotificationCompat.Builder(getApplicationContext());
        builder.setSmallIcon(R.mipmap.ic_launcher);
        builder.setContentTitle("下载图片");
        builder.setContentText("正在下载中....");

    }

    @Override
    public IBinder onBind(Intent intent) {
        // TODO: Return the communication channel to the service.
        throw new UnsupportedOperationException("Not yet implemented");
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        final String urlPath = intent.getStringExtra("urlPath");
        if (urlPath != null) {
            new Thread() {
                @Override
                public void run() {
                    super.run();
                    try {
                        byte[] data = HttpUtils(urlPath);
                        boolean flag = saveFile(data, "xiao.jpg");
                        Log.i("aaa", "flag=" + flag);
                        if (flag) {
                            myHandler.sendEmptyMessage(1);
                        }
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
            }.start();

        }


        return START_REDELIVER_INTENT;
    }

    public byte[] HttpUtils(String urlPath) {
        ByteArrayOutputStream baos = null;
        try {
            URL url = new URL(urlPath);
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            connection.setRequestMethod("GET");
            connection.setReadTimeout(10000);
            connection.setConnectTimeout(10000);
            connection.setDoInput(true);
            connection.connect();

            if (connection.getResponseCode() == 200) {
                int fileSize = connection.getContentLength();
                int currentSize = 0;
                InputStream inputStream = connection.getInputStream();
                baos = new ByteArrayOutputStream();
                byte[] b = new byte[10];
                int len = -1;
                while ((len = inputStream.read(b)) != -1) {
                    currentSize += len;
                    int currentRate = (int) (currentSize / (float) fileSize * 100);
                    Log.i("aaa", "currrntRate" + currentRate);
                    Message msg = Message.obtain();
                    msg.arg1 = currentRate;
                    myHandler.sendMessage(msg);

                    baos.write(b, 0, len);
                }
                inputStream.close();
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

    class MyHandler extends Handler {
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            if (msg.arg1 != 0) {

                try {
                    Thread.sleep(200);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                builder.setProgress(100, msg.arg1, false);
                manager.notify(100, builder.build());

            }
            if (msg.what == 1) {
                Log.i("aaa", "msg.what=" + msg.what);
                builder.setContentText("下载完成");
                manager.notify(100, builder.build());
                stopSelf();
                Toast.makeText(getApplicationContext(), "下载完成", Toast.LENGTH_LONG).show();
            }
        }
    }

    //    public boolean saveFile(byte[] data, String fileName) {
//        boolean flag = false;
//
//        Log.i("aaa","Environment.getExternalStorageState()==Environment.MEDIA_MOUNTED="+Environment.MEDIA_MOUNTED.equals(Environment.getExternalStorageState()));
//        if (Environment.MEDIA_MOUNTED.equals(Environment.getExternalStorageState())) {
//            File root = Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_DOWNLOADS);
//            File file = new File(root, fileName);
//            FileOutputStream fos = null;
//            try {
//                fos = new FileOutputStream(file);
//                fos.write(data, 0, data.length);
//                flag = true;
//
//            } catch (IOException e) {
//                e.printStackTrace();
//            } finally {
//                if (fos != null) {
//                    try {
//                        fos.close();
//                    } catch (IOException e) {
//                        e.printStackTrace();
//                    }
//                }
//            }
//            return flag;
//        }
//
//        return flag;
//    }
    private boolean saveFile(byte[] data, String fileName) throws Exception {
        boolean flag = false;
        //说明SD卡挂载成功
        Log.i("aaa", "Environment.getExternalStorageState().equals(Environment.MEDIA_MOUNTED)=" + (Environment.getExternalStorageState().equals(Environment.MEDIA_MOUNTED)));
        //==数值  equals字符串进行比较

        if (Environment.MEDIA_MOUNTED.equals(Environment.getExternalStorageState())) {
            //得到SD卡的保存路径 /mnt/sdcard/donwnload
            File root = Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_DOWNLOADS);
            //创建一个写入文件  /mnt/sdcard/download/filename
            File file = new File(root, fileName);
            Log.i("aaa", "file=" + file.getAbsolutePath());
            //往文件中写数据
            FileOutputStream fileOutputStream = new FileOutputStream(file);
            fileOutputStream.write(data, 0, data.length);
            flag = true;
            fileOutputStream.close();
        }
        return flag;
    }
}
