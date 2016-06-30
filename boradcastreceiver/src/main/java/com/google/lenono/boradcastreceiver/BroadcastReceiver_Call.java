package com.google.lenono.boradcastreceiver;

import android.app.Service;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.IBinder;
import android.telecom.TelecomManager;
import android.telephony.TelephonyManager;
import android.text.style.TtsSpan;
import android.util.Log;

public class BroadcastReceiver_Call extends BroadcastReceiver {
    @Override
    public void onReceive(Context context, Intent intent) {
        if (intent.getAction().equals(Intent.ACTION_NEW_OUTGOING_CALL)) {
            String number = intent.getStringExtra(Intent.EXTRA_PHONE_NUMBER);
            Log.i("ccc", "拨打的电话是：" + number);

        } else {
            TelephonyManager telephonyManager = (TelephonyManager) context.getSystemService(Context.TELEPHONY_SERVICE);
            switch (telephonyManager.getCallState()) {
                case TelephonyManager.CALL_STATE_RINGING:
                    String incoming_number = intent.getStringExtra("incoming_number");
                    Log.i("ccc", "来电是:" + incoming_number);
                    break;
                case TelephonyManager.CALL_STATE_OFFHOOK:
                    Log.i("ccc", "接电话：");
                    break;
                case TelephonyManager.CALL_STATE_IDLE:
                    Log.i("ccc", "挂电话");
                    break;
            }

        }

    }
}
