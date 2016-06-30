package com.google.lenono.actionbar;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.view.Window;

public class ToolBarActivity extends AppCompatActivity {
    private Toolbar toolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        supportRequestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_tool_bar);
        toolbar = (Toolbar) findViewById(R.id.toolbar);
        //设置导航图标
        toolbar.setNavigationIcon(R.mipmap.ic_launcher);
        toolbar.setNavigationOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                Log.i("aaa","toolbar Onclick");
            }
        });
      //  toolbar.setLogo(R.mipmap.ic_launcher);
        toolbar.setTitle("title");
        toolbar.setSubtitle("subtitle");
        toolbar.inflateMenu(R.menu.toolbarview_menu);
        toolbar.setOnMenuItemClickListener(new Toolbar.OnMenuItemClickListener() {
                                               @Override
                                               public boolean onMenuItemClick(MenuItem item) {
                                                   switch (item.getItemId()) {
                                                       case R.id.toolbar01:
                                                           Log.i("aaa", "toolbar01");
                                                           break;
                                                       case R.id.toolbar02:
                                                           Log.i("aaa", "toolbar02");
                                                           break;
                                                       case R.id.toolbar03:
                                                           Log.i("aaa", "toolbar03");
                                                           break;
                                                   }

                                                   return true;
                                               }
                                           }

        );
    }
}
