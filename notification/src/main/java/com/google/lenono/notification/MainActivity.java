package com.google.lenono.notification;

import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Build;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.app.NotificationCompat;
import android.view.View;

public class MainActivity extends AppCompatActivity {
    private NotificationManager nm;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        nm = (NotificationManager) getSystemService(Context.NOTIFICATION_SERVICE);

    }

    public void btn_click(View view) {
        NotificationCompat.Builder builder = new NotificationCompat.Builder(this);
        Bitmap bitmap = BitmapFactory.decodeResource(getResources(), R.mipmap.ic_launcher);
        Intent intent = new Intent(this, SecondActivity.class);
        PendingIntent pendingIntent = PendingIntent.getActivity(this, 200, intent, PendingIntent.FLAG_ONE_SHOT);
        builder.setTicker("通知来了")
                .setSmallIcon(R.mipmap.ic_launcher)
                .setContentInfo("你加薪了")
                .setContentText("从今日起你加薪20%，请到财务室更新。")
                .setContentTitle("加薪通知")
                .setContentIntent(pendingIntent)
                .setAutoCancel(true)
                .setOngoing(true);
        nm.notify(1, builder.build());
    }
}
