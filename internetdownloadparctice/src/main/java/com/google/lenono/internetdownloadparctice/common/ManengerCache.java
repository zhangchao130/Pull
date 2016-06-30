package com.google.lenono.internetdownloadparctice.common;

import android.graphics.Bitmap;
import android.os.Handler;
import android.util.Log;
import android.widget.ImageView;
import java.io.ByteArrayOutputStream;

/**
 * Created by lenono on 2016-06-27.
 */
public class ManengerCache {
    private WebCache webCache = new WebCache();
    private FileCache fileCache = new FileCache();
    private MemoryCache memoryCache = new MemoryCache();
    Handler handler = new Handler();

    public void getCache(final String urlPath, final ImageView imageView) {
        Bitmap bitmap = null;
        if (memoryCache.getBitmapFromLruCache(urlPath) != null) {
            Log.i("aaa", "111");
            bitmap = memoryCache.getBitmapFromLruCache(urlPath);
            imageView.setImageBitmap(bitmap);
        } else if (fileCache.getFileFromSDcard(urlPath) != null) {
            Log.i("aaa", "222");
            bitmap = fileCache.getFileFromSDcard(urlPath);
            memoryCache.addBitmapToLruCache(urlPath, bitmap);
            imageView.setImageBitmap(bitmap);
        } else {
            Log.i("aaa", "333");
            webCache.getWebCache(urlPath, new WebCache.CallBack() {
                @Override
                public void getResult(byte[] data) {
                    final Bitmap bitmap1 = Imagecompression.getCompressonImage(data, 50, 50);
                    byte[] d = bitmapToByte(bitmap1);
                    fileCache.saveFileToSDcard(d, urlPath);
                    memoryCache.addBitmapToLruCache(urlPath, bitmap1);
                    handler.post(new Runnable() {
                        @Override
                        public void run() {
                            imageView.setImageBitmap(bitmap1);
                        }
                    });
                }
            });

        }


    }

    public byte[] bitmapToByte(Bitmap bitmap) {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        bitmap.compress(Bitmap.CompressFormat.PNG, 100, byteArrayOutputStream);
        return byteArrayOutputStream.toByteArray();

    }

}

