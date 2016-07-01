package com.google.lenono.pullfresh;

import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import com.handmark.pulltorefresh.library.PullToRefreshBase;
import com.handmark.pulltorefresh.library.PullToRefreshListView;

import java.util.Arrays;
import java.util.LinkedList;

public class MainActivity extends AppCompatActivity {
    PullToRefreshListView pullToRefreshListView;
    ListView listView;
    LinkedList<String> linkedList;
    String[] citys = {"bj", "sh", "jz", "zz", "ay", "wh", "xj", "ly", "xx","ss"};
    ArrayAdapter<String> arrayAdapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        pullToRefreshListView = (PullToRefreshListView) findViewById(R.id.pulltorefresh);

        listView = pullToRefreshListView.getRefreshableView();
        linkedList = new LinkedList<String>();
        linkedList.addAll(Arrays.asList(citys));
        arrayAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, linkedList);
        listView.setAdapter(arrayAdapter);

        pullToRefreshListView.setOnRefreshListener(new PullToRefreshBase.OnRefreshListener2<ListView>() {
            @Override
            public void onPullDownToRefresh(PullToRefreshBase<ListView> refreshView) {
                Toast.makeText(MainActivity.this, "down data", Toast.LENGTH_LONG).show();
                new MyExecute().execute("down data");
            }

            @Override
            public void onPullUpToRefresh(PullToRefreshBase<ListView> refreshView) {
                Toast.makeText(MainActivity.this, "up data", Toast.LENGTH_LONG).show();
                new MyExecute().execute("up data");
            }
        });
    }

    class MyExecute extends AsyncTask<String, Void, LinkedList<String>> {

        @Override
        protected LinkedList<String> doInBackground(String... voids) {
            try {
                Thread.sleep(3000);
                if (voids[0].equals("up data")) {
                    linkedList.addLast("up data");
                    return linkedList;
                } else if (voids[0].equals("down data")) {
                    linkedList.addFirst("down data");
                    return linkedList;
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            return null;
        }

        @Override
        protected void onPostExecute(LinkedList<String> aVoid) {
            super.onPostExecute(aVoid);
            if (aVoid != null) {
                arrayAdapter.notifyDataSetChanged();
                pullToRefreshListView.onRefreshComplete();
            }
        }
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        linkedList.clear();
    }
}
