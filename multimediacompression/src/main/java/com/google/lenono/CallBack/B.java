package com.google.lenono.CallBack;

import android.os.Bundle;
import android.os.PersistableBundle;
import android.support.v7.app.AppCompatActivity;

/**
 * Created by lenono on 2016-06-27.
 */
public class B extends AppCompatActivity {


    @Override
    public void onCreate(Bundle savedInstanceState, PersistableBundle persistentState) {
        super.onCreate(savedInstanceState, persistentState);
        A a = new A();
        a.loadFile("", new A.CallBack() {
            @Override
            public void getResult(String str) {

            }
        });
    }
}
