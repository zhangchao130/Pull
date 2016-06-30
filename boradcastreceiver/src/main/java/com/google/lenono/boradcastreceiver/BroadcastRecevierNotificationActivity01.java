package com.google.lenono.boradcastreceiver;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class BroadcastRecevierNotificationActivity01 extends AppCompatActivity {
    Button btn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_broadcast_recevier_notification01);
        btn = (Button) findViewById(R.id.broadcastrecevierbotification_activity01_btn01);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent();
                intent.setAction("notificationrecevier");
                sendBroadcast(intent);
            }
        });
    }
}
