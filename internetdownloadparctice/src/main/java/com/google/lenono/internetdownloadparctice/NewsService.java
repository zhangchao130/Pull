package com.google.lenono.internetdownloadparctice;

import android.app.Service;
import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Handler;
import android.os.IBinder;
import android.os.Message;
import android.util.Log;
import android.widget.Toast;

import com.google.lenono.internetdownloadparctice.SQLite.NewsDaoService;
import com.google.lenono.internetdownloadparctice.common.ManengerCache;
import com.google.lenono.internetdownloadparctice.common.News;
import com.google.lenono.internetdownloadparctice.utils.BitmapToByte;
import com.google.lenono.internetdownloadparctice.utils.HttpUtils;
import com.google.lenono.internetdownloadparctice.common.Imagecompression;
import com.google.lenono.internetdownloadparctice.utils.JsonUtils;
import com.google.lenono.internetdownloadparctice.utils.SaveFile;

import java.io.UnsupportedEncodingException;

public class NewsService extends Service {
    private String urlPath = "http://www.3dmgame.com/sitemap/api.php?row=10&typeid=1&paging=1&page=";
    private MyHandler handler = new MyHandler();
    private NewsDaoService newsDaoService;
    private News news;

    public NewsService() {
    }

    class MyHandler extends Handler {
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            if (msg.what == 1) {
                Toast.makeText(getApplicationContext(), "下载成功", Toast.LENGTH_LONG).show();
            }
        }
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        newsDaoService = new NewsDaoService(getApplicationContext());
        new Thread() {
            @Override
            public void run() {
                super.run();
                for (
                        int index = 1;
                        index < 3; index++)

                {
                    byte[] data = HttpUtils.request(urlPath + index);
                    if (data != null) {
                        Log.i("aaa", "Http解析成功");
                        try {
                            String json = new String(data, "utf-8");
                            for (int i = 0; i < 10; i++) {
                                news = new News();
                                news = JsonUtils.jsonList(json, i);
                                Log.i("aaa", news.toString());
                                newsDaoService.insert(news);
                                //         String imageName = news.getLitpic().toString();
//                                String[] str = imageName.split("/");
//                                String fileName = str[str.length - 1];
//                                String litpic = "http://www.3dmgame.com" + imageName;
//                                Log.i("aaa", litpic);
//                                byte[] image = HttpUtils.request(litpic);
//                                if (image != null) {
//                                    if (news.getLitpic() != null) {
//
//                                        Bitmap bitmap = imagecompression.getCompressonImage(image, 70, 70);
//                                        byte[] byteFile = BitmapToByte.byteFromBitmap(bitmap);
//                                        Log.i("aaa", fileName);
//                                        boolean flg = SaveFile.save(byteFile, fileName);
//                                        Log.i("aaa", flg + "");
//                                    }
//                                }
                            }

                        } catch (UnsupportedEncodingException e) {
                            e.printStackTrace();
                        }
                    }
                }
                handler.sendEmptyMessage(1);
            }
        }.start();


        return START_REDELIVER_INTENT;
    }

    @Override
    public IBinder onBind(Intent intent) {
        // TODO: Return the communication channel to the service.
        throw new UnsupportedOperationException("Not yet implemented");
    }
}
