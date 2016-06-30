package com.google.lenono.ThreeCache;

import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

/**
 * Created by lenono on 2016-06-27.
 */
public class WebCache {
    public byte[] getWebFile(String urlPath) {
        ByteArrayOutputStream baos = null;
        try {
            URL url = new URL(urlPath);
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            connection.setRequestMethod("GET");
            connection.setDoInput(true);
            connection.setReadTimeout(10000);
            connection.setConnectTimeout(10000);
            connection.connect();
            if (connection.getResponseCode() == 200) {
                InputStream is = connection.getInputStream();
                baos = new ByteArrayOutputStream();
                byte[] data = new byte[1024 * 4];
                int len = -1;
                while ((len = is.read(data, 0, data.length)) != -1) {
                    baos.write(data, 0, len);
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

    public void getWebCache(final String urlPath, final CallBack callBack) {
        new Thread(new Runnable() {
            @Override
            public void run() {
                byte[] data = getWebFile(urlPath);
                callBack.getResult(data);
            }
        }).start();
    }

    public interface CallBack {
        public void getResult(byte[] data);
    }
}
