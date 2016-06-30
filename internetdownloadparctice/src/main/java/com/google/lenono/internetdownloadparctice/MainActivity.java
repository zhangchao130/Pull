package com.google.lenono.internetdownloadparctice;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.google.lenono.internetdownloadparctice.SQLite.NewsDaoService;


public class MainActivity extends AppCompatActivity {
    private NewsDaoService newsDaoService;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button btn = (Button) findViewById(R.id.mainactivity_btn01);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, NewsActivity.class);
                startActivity(intent);
            }
        });
       // newsDaoService =new NewsDaoService(this);
        Intent intent = new Intent();
        intent.setAction("newserviceaction");
        startService(intent);

    }
}
