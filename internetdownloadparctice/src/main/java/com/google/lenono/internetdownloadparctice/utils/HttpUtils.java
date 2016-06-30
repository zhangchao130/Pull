package com.google.lenono.internetdownloadparctice.utils;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;

/**
 * Created by lenono on 2016-06-24.
 */
public class HttpUtils {

    public static byte[] request(String urlPath) {
        ByteArrayOutputStream baos = null;
        try {
            URL url = new URL(urlPath);

            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            connection.setConnectTimeout(10000);
            connection.setReadTimeout(10000);
            connection.setDoInput(true);
            connection.setRequestMethod("GET");
            connection.connect();
            if (connection.getResponseCode() == 200) {
                InputStream is = connection.getInputStream();
                baos = new ByteArrayOutputStream();
                byte[] b = new byte[1024 * 4];
                int len = -1;
                while ((len=is.read(b, 0, b.length)) != -1) {
                    baos.write(b, 0, len);
                }
                is.close();
                return baos.toByteArray();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }


        return null;
    }

}
