package com.google.lenono.compressionimage;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.util.Log;

/**
 * Created by lenono on 2016-06-27.
 */
public class Imagecompression {
    public static Bitmap getCompressonImage(byte[] data, int picWidth, int picHeight) {
        Bitmap initBitmap = BitmapFactory.decodeByteArray(data, 0, data.length);
        Log.i("aaa", "原始图片字节数：" + initBitmap.getByteCount());
        BitmapFactory.Options options = new BitmapFactory.Options();
        options.inJustDecodeBounds = true;
        Bitmap beforeBitmap = BitmapFactory.decodeByteArray(data, 0, data.length, options);
        //原始图片的大小
        int width;
        int height;
        width = options.outWidth;
        height = options.outHeight;
        Log.i("aaa", "原始图片的宽：" + width + "原始图片高：" + height);
        options.inSampleSize = calculateSampleSize(options, picWidth, picHeight);
        Log.i("aaa", "比率inSampleSize" + options.inSampleSize);
        options.inJustDecodeBounds = false;
        Bitmap afterBitmap = BitmapFactory.decodeByteArray(data, 0, data.length, options);
        Log.i("aaa", "结果图片的大小：" + afterBitmap.getByteCount());

        return afterBitmap;
    }

    public static int calculateSampleSize(BitmapFactory.Options options, int reqWidth, int reqHeight) {

        int width = options.outWidth;
        int height = options.outHeight;
        int inSampleSize = 1;
        if (width > reqWidth || height > reqHeight) {
            int reqWidthRadio = Math.round((float) width / reqWidth);
            int reqHeigthRadio = Math.round((float) height / reqHeight);
            inSampleSize = reqWidthRadio < reqHeigthRadio ? reqWidthRadio : reqHeigthRadio;
        }
        return inSampleSize;
    }

}
