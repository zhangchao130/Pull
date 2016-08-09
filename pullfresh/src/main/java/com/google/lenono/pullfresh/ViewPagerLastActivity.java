package com.google.lenono.pullfresh;

import android.support.v4.view.PagerAdapter;
import android.support.v4.view.PagerTabStrip;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;

public class ViewPagerLastActivity extends AppCompatActivity {
    ViewPager viewPager;
    PagerTabStrip pagerTabStrip;
    List<View> viewList = new ArrayList<View>();
    List<String> stringList = new ArrayList<String>();
    LayoutInflater inflater;
    MyAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_pager_last);
        viewPager = (ViewPager) findViewById(R.id.lastviewpager);
        pagerTabStrip = (PagerTabStrip) findViewById(R.id.lasttableviewpager);
        adapter = new MyAdapter();
        inflater = LayoutInflater.from(this);
        View tab1 = inflater.inflate(R.layout.tab1, null);
        viewList.add(tab1);
        stringList.add("title1");
        viewPager.setAdapter(adapter);
        viewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            private int i = 2;

            @Override
            public void onPageSelected(int position) {

            }

            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
                //positionOffset 偏移量取值[0,1) 偏移量大于一半才会加载新界面
            }

            @Override
            public void onPageScrollStateChanged(int state) {
                //在这里开启线程下次加载网路数据，更新UI操作
                View view = inflater.inflate(R.layout.tab2, null);
                viewList.add(view);
                stringList.add("title" + i);
                adapter.notifyDataSetChanged();
                i++;
            }
        });
    }

    class MyAdapter extends PagerAdapter {
        @Override
        public int getCount() {
            return viewList.size();
        }

        //销毁
        @Override
        public void destroyItem(ViewGroup container, int position, Object object) {
            // super.destroyItem(container, position, object);
            container.removeView(viewList.get(position));
        }

        //初始化
        @Override
        public Object instantiateItem(ViewGroup container, int position) {
            container.addView(viewList.get(position));
            return viewList.get(position);
        }

        @Override
        public CharSequence getPageTitle(int position) {
            return stringList.get(position);
        }

        @Override
        public boolean isViewFromObject(View view, Object object) {
            return view == object;
        }
    }
}
