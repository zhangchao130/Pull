package com.google.lenono.internetdownloadparctice;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.IBinder;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;

import com.google.lenono.internetdownloadparctice.SQLite.NewsDaoService;
import com.google.lenono.internetdownloadparctice.common.FileCache;
import com.google.lenono.internetdownloadparctice.common.MemoryCache;
import com.google.lenono.internetdownloadparctice.common.News;
import com.google.lenono.internetdownloadparctice.utils.MyAdapter;

import java.util.ArrayList;
import java.util.List;

public class NewsActivity extends AppCompatActivity {
    private FileCache fileCache;
    private int pageSize = 10;
    private int pageIndex = 1;
    private ListView lv;
    public static List<News> data;
    public static MyAdapter adapter;
    public static NewsDaoService newsDaoService;
    private SecondService.MyBinder myBinder;
    private MemoryCache memoryCache;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_news);
        Intent intent = new Intent(this, SecondService.class);
        fileCache = new FileCache();
        memoryCache = new MemoryCache();

        bindService(intent, new ServiceConnection() {
            @Override
            public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
                myBinder = (SecondService.MyBinder) iBinder;
                myBinder.updata();
            }

            @Override
            public void onServiceDisconnected(ComponentName componentName) {

            }
        }, Context.BIND_AUTO_CREATE);


        lv = (ListView) findViewById(R.id.newsactivity_lv);
        data = new ArrayList<News>();
        adapter = new MyAdapter(this, data);
        lv.setAdapter(adapter);
        //   newsDaoService = new NewsDaoService(this);
        // data.addAll(newsDaoService.getAllNewsListData());

//        lv.setOnScrollListener(new AbsListView.OnScrollListener() {
//            boolean flg = false;
//
//            @Override
//            public void onScrollStateChanged(AbsListView absListView, int i) {
//                if (i == 0 && flg) {
//                    pageIndex++;
//                    updateListView();
//                }
//            }
//
//            @Override
//            public void onScroll(AbsListView absListView, int i, int i1, int i2) {
//
//                if (i + i1 == i2) {
//                    flg = true;
//                } else
//                    flg = false;
//            }
//        });
//
//    }
//
//    public void updateListView() {
//        data.clear();
//        List<News> temp = newsDaoService.getAllNewsListDataScroll(pageSize, pageIndex);
//        if (temp.size() == 0 && pageIndex != 1) { //判读temp的个数 ，pageIndex 不等于1
//            pageIndex = 1;
//            updateListView();
//        }
//        data.addAll(temp);
//        adapter.notifyDataSetChanged();
//    }
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        fileCache.clear();
        memoryCache.clear();
    }
}