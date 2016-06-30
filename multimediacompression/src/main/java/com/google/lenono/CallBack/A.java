package com.google.lenono.CallBack;

/**
 * Created by lenono on 2016-06-27.
 */
public class A {
    public void loadFile(String urlStr, final CallBack callBack) {
        new Thread() {
            @Override
            public void run() {
                String str = "aaa";
                callBack.getResult(str);
            }
        }.start();
    }

    public interface CallBack {
        public void getResult(String str);
    }
}
