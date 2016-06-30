package com.google.lenono.internetdownloadparctice.utils;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;

import java.io.ByteArrayOutputStream;

/**
 * Created by lenono on 2016-06-29.
 */
public class BitmapToByte {
    public static byte[] byteFromBitmap(Bitmap bitmap){
        ByteArrayOutputStream baos=new ByteArrayOutputStream();
        bitmap.compress(Bitmap.CompressFormat.PNG,100,baos);
        return baos.toByteArray();
    }
}
