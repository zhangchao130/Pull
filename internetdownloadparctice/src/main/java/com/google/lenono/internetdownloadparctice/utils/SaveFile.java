package com.google.lenono.internetdownloadparctice.utils;

import android.os.Environment;
import android.util.Log;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

/**
 * Created by lenono on 2016-06-24.
 */
public class SaveFile {
    public static boolean save(byte[] data, String litpic) {
        Log.i("aaa", "sd卡挂载:" + Environment.getExternalStorageState().equals(Environment.MEDIA_MOUNTED) + "");
        boolean flag = false;
        if (Environment.getExternalStorageState().equals(Environment.MEDIA_MOUNTED)) {
            File root = Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_DOWNLOADS);
            File file = new File(root, litpic);
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
}
