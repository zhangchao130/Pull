package com.google.lenono.boradcastreceiver;

import android.content.BroadcastReceiver;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class BroadcastReceiverActivity01 extends AppCompatActivity {
    Button btn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_broadcast_receiver01);
        btn = (Button) findViewById(R.id.broadcastrecevier_activity01_btn01);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent();
                intent.setAction("mybroadcastrecevier");
                sendOrderedBroadcast(intent, null);
            }
        });
    }
}
