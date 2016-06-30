package com.google.lenono.internetdownloadparctice.common;

import android.graphics.Bitmap;
import android.util.LruCache;

/**
 * Created by lenono on 2016-06-27.
 */
public class MemoryCache {
    private LruCache<String, Bitmap> lruCache;

    public MemoryCache() {
        final int maxMemory = (int) Runtime.getRuntime().maxMemory();
        int cacheMemory = maxMemory / 8;
        lruCache = new LruCache<String, Bitmap>(cacheMemory) {
            @Override
            protected int sizeOf(String key, Bitmap value) {
                return value.getRowBytes() * value.getHeight() / 1024;
            }
        };
    }

    ;

    public synchronized void addBitmapToLruCache(String urlPaht, Bitmap bitmap) {
        if (urlPaht != null) {
            if (bitmap != null) {
                lruCache.put(urlPaht, bitmap);
            }
        }
    }

    public Bitmap getBitmapFromLruCache(String urlPath) {
        Bitmap bitmap = null;
        if (urlPath != null) {
            if (lruCache.get(urlPath) != null) {
                bitmap = lruCache.get(urlPath);
            }
        }
        return bitmap;
    }

    public synchronized void removeBitmapFromLruCache(String urlPath) {
        if (urlPath != null) {
            Bitmap bitmap = lruCache.get(urlPath);
            if (bitmap != null) {
                bitmap.recycle();
            }
        }
    }

    public void clear() {
        if (lruCache.size() > 0) {
            lruCache.evictAll();
        }
    }


}
