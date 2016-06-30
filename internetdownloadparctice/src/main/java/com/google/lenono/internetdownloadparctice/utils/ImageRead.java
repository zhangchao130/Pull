package com.google.lenono.internetdownloadparctice.utils;

import android.os.Environment;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;

/**
 * Created by lenono on 2016-06-24.
 */
public class ImageRead {
    public static byte[] readSD(String fileName) {
        ByteArrayOutputStream baos = null;
        try {
            FileInputStream fis = new FileInputStream(Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_DOWNLOADS) + File.separator + fileName);
            baos = new ByteArrayOutputStream();
            byte[] data = new byte[1024 * 4];
            int len = -1;
            while ((len = fis.read(data, 0, data.length)) != -1) {
                baos.write(data, 0, len);
            }
            fis.close();
            byte[] result = baos.toByteArray();
            if (result != null) {
                baos.close();
            }
            return result;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
}
