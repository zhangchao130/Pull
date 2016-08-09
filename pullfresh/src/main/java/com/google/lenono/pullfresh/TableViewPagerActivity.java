package com.google.lenono.pullfresh;

import android.graphics.Color;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.PagerTabStrip;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;

public class TableViewPagerActivity extends AppCompatActivity {
    ViewPager viewPager;
    PagerTabStrip pagerTabStrip;
    ArrayList<View> views = new ArrayList<View>();
    ArrayList<String> list = new ArrayList<String>();
    public String Tag = "tag";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_table_view_pager);
        viewPager = (ViewPager) findViewById(R.id.activity_viewpager);
        pagerTabStrip = (PagerTabStrip) findViewById(R.id.tableviewpager);
        pagerTabStrip.setDrawFullUnderline(false);
//        pagerTabStrip.setBackgroundColor(this.getResources().getColor(Color.));

        View view1 = LayoutInflater.from(this).inflate(R.layout.tab1, null);
        View view2 = LayoutInflater.from(this).inflate(R.layout.tab2, null);
        View view3 = LayoutInflater.from(this).inflate(R.layout.tab3, null);
        views.add(view1);
        views.add(view2);
        views.add(view3);
        list.add("title1");
        list.add("title2");
        list.add("title3");
        viewPager.setAdapter(new MyAdapter());


    }

    class MyAdapter extends PagerAdapter {
        @Override
        public int getCount() {
            return views.size();
        }

        @Override
        public void destroyItem(ViewGroup container, int position, Object object) {
         //   super.destroyItem(container, position, object);
            container.removeView(views.get(position));
        }

        @Override
        public CharSequence getPageTitle(int position) {
            return list.get(position);
        }

        @Override
        public Object instantiateItem(ViewGroup container, int position) {
            container.addView(views.get(position));
            return views.get(position);
        }

        @Override
        public boolean isViewFromObject(View view, Object object) {
            return view == object;
        }
    }
}
