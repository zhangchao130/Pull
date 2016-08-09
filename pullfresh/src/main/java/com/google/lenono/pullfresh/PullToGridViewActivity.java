package com.google.lenono.pullfresh;

import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.GridView;
import android.widget.ListView;

import com.handmark.pulltorefresh.library.PullToRefreshBase;
import com.handmark.pulltorefresh.library.PullToRefreshGridView;
import com.handmark.pulltorefresh.library.extras.SoundPullEventListener;

import java.util.Arrays;
import java.util.LinkedList;

public class PullToGridViewActivity extends AppCompatActivity {
    String[] citys = {"bj", "sh", "jz", "zz", "ay", "wh", "xj", "ly", "xx"};
    PullToRefreshGridView pullToRefreshGridView;
    GridView gridView;
    LinkedList<String> linkedList;
    ArrayAdapter<String> arrayAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pull_to_grid_view);
        pullToRefreshGridView = (PullToRefreshGridView) findViewById(R.id.pulltorefresh_grid);
        gridView = pullToRefreshGridView.getRefreshableView();
        linkedList = new LinkedList<String>();
        linkedList.addAll(Arrays.asList(citys));
        arrayAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, linkedList);
        gridView.setAdapter(arrayAdapter);
        SoundPullEventListener<ListView> soundPullEventListener=new SoundPullEventListener<>(this);
        soundPullEventListener.addSoundEvent(PullToRefreshBase.State.PULL_TO_REFRESH,R.raw.pull_event);
        soundPullEventListener.addSoundEvent(PullToRefreshBase.State.RESET,R.raw.reset_sound);
        soundPullEventListener.addSoundEvent(PullToRefreshBase.State.REFRESHING, R.raw.refreshing_sound);
        pullToRefreshGridView.setOnRefreshListener(new PullToRefreshBase.OnRefreshListener2<GridView>() {
            @Override
            public void onPullDownToRefresh(PullToRefreshBase<GridView> refreshView) {
                new MyExecute().execute("down data");
            }

            @Override
            public void onPullUpToRefresh(PullToRefreshBase<GridView> refreshView) {
                new MyExecute().execute("up data");
            }
        });

    }

    class MyExecute extends AsyncTask<String, Void, LinkedList<String>> {
        String[] citys = {"北京", "上海", "焦作", "郑州", "安阳", "武汉", "新疆", "洛阳", "新乡"};

        @Override
        protected LinkedList<String> doInBackground(String... strings) {
            if (strings[0].equals("down data")) {
                linkedList.addAll(0,Arrays.asList(citys));
                return linkedList;
            } else if (strings[0].equals("up data")) {
                linkedList.addAll(Arrays.asList(citys));
                return linkedList;
            }
            return null;
        }

        @Override
        protected void onPostExecute(LinkedList<String> strings) {
            super.onPostExecute(strings);
            if (strings != null) {
                arrayAdapter.notifyDataSetChanged();
                pullToRefreshGridView.onRefreshComplete();
            }
        }
    }
}
