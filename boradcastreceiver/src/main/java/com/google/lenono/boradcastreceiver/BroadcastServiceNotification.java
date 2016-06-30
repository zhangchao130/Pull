package com.google.lenono.boradcastreceiver;

import android.app.NotificationManager;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.support.v7.app.NotificationCompat;

/**
 * Created by lenono on 2016-06-23.
 */
public class BroadcastServiceNotification extends BroadcastReceiver {
    @Override
    public void onReceive(Context context, Intent intent) {
        NotificationManager manager = (NotificationManager) context.getSystemService(Context.NOTIFICATION_SERVICE);
        NotificationCompat.Builder builder = new NotificationCompat.Builder(context);
        builder.setTicker("新的通知来了...");
        builder.setSmallIcon(R.mipmap.ic_launcher);
        builder.setContentTitle("您的快递到了");
        builder.setContentText("你的快递已经被签收");
        manager.notify(100, builder.build());
    }
}
