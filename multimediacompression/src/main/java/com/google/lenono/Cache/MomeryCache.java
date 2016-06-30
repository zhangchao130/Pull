package com.google.lenono.Cache;

import android.graphics.Bitmap;
import android.util.LruCache;

/**
 * Created by lenono on 2016-06-27.
 */
public class MomeryCache {
    private LruCache<String, Bitmap> lruCache;

    public MomeryCache() {
        int maxMomery = (int) Runtime.getRuntime().maxMemory();
        int cacheMomery = maxMomery / 8;
        lruCache = new LruCache<String, Bitmap>(cacheMomery) {
            @Override
            protected int sizeOf(String key, Bitmap value) {

                return value.getRowBytes() * value.getHeight() / 1024;
            }
        };
    }

    public synchronized void addBitmapToLruCache(String key, Bitmap bitmap) {
    if (key!=null){
        if (bitmap!=null){
            lruCache.put(key,bitmap);
        }
    }

    }
    public Bitmap getBitmapFromLruCache(String key){
        if (key!=null){
            if (lruCache.get(key)!=null){
                return lruCache.get(key);
            }
        }
        return null;
    }
    public synchronized void removeBitmappFromLruCache(String key){
        if (key!=null){
            Bitmap bitmap=lruCache.get(key);
            if (bitmap!=null){
                bitmap.recycle();
            }
        }
    }

public void clean(){
    if (lruCache.size()>0){
        lruCache.evictAll();
    }
}
}
