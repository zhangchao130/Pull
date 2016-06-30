package com.google.lenono.boradcastreceiver;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.util.Log;

/**
 * Created by lenono on 2016-06-23.
 */
public class BroadcastService03 extends BroadcastReceiver {
    @Override
    public void onReceive(Context context, Intent intent) {
        Log.i("aaa", "广播3来啦");
    }
}
