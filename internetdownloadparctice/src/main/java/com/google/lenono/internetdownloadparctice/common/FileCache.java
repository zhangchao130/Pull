package com.google.lenono.internetdownloadparctice.common;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Environment;
import android.util.Log;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

/**
 * Created by lenono on 2016-06-27.
 */
public class FileCache {
    //SDcard根目录 mnt
    private static final File SD_ROOT = Environment.getExternalStorageDirectory();
    //缓存目录 file_cache
    private String cache_folder = Environment.DIRECTORY_DOWNLOADS;
    //判断是否加载成功
    boolean isCount = false;
    //缓存目录对象 mnt/file_cache
    private static File CACHE_FOLDER = null;

    public FileCache() {
        if (!Environment.getExternalStorageState().equals(Environment.MEDIA_MOUNTED)) {
            Log.i("aaa", "sdcard挂载出错");
        } else {
            isCount = true;
            CACHE_FOLDER = new File(SD_ROOT, cache_folder);
            if (CACHE_FOLDER != null) {
                CACHE_FOLDER.mkdirs();
            }
        }
    }

    public synchronized void saveFileToSDcard(byte[] data, String urlPath) {
        FileOutputStream fos = null;
        if (isCount) {
            if (!CACHE_FOLDER.exists()) {
                return;
            }
            //获得地址 最后一个/ +1的
            String fileName = urlPath.substring(urlPath.lastIndexOf("/") + 1);
            File saveFile = new File(CACHE_FOLDER, fileName);
            try {
                fos = new FileOutputStream(saveFile);
                fos.write(data, 0, data.length);
                Log.i("aaa", "saveFile:" + saveFile.getAbsolutePath());
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

        }
    }

    public Bitmap getFileFromSDcard(String urlPath) {
        Bitmap bitmap = null;
        if (isCount) {
            if (urlPath != null) {
                String fileName = urlPath.substring(urlPath.lastIndexOf("/") + 1);
                File getFile = new File(CACHE_FOLDER, fileName);
                if (getFile.exists()) {
                    bitmap = BitmapFactory.decodeFile(getFile.getAbsolutePath());
                }
            }
        }
        return bitmap;
    }

    public boolean removeFileFormSDcard(String urlPath) {
        if (isCount) {
            if (urlPath != null) {
                String fileName = urlPath.substring(urlPath.lastIndexOf("/") + 1);
                File deleteFile = new File(CACHE_FOLDER, fileName);
                if (deleteFile.exists()) {
                    return deleteFile.delete();
                }
            }
        }

        return false;
    }

    public void clear() {
        if (isCount) {
            File[] allCacheFile = CACHE_FOLDER.listFiles();
            for (File file : allCacheFile) {
                file.delete();
            }
        }
    }
}
