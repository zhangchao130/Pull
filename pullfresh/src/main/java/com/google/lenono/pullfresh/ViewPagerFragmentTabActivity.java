package com.google.lenono.pullfresh;


import android.graphics.Color;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.PagerTabStrip;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import java.util.ArrayList;
import java.util.List;

public class ViewPagerFragmentTabActivity extends AppCompatActivity {
    ViewPager viewPager;
    PagerTabStrip pagerTabStrip;
    Fragment01 fragment01;
    Fragment02 fragment02;
    Fragment03 fragment03;
    List<Fragment> fragmentList = new ArrayList<>();
    String[] str = {"标题1", "标题2", "标题3"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_pager_fragment_tab);
        viewPager = (ViewPager) findViewById(R.id.myvierpager_fragment02);
        fragment01 = new Fragment01();
        fragment02 = new Fragment02();
        fragment03 = new Fragment03();
        fragmentList.add(fragment01);
        fragmentList.add(fragment02);
        fragmentList.add(fragment03);
        pagerTabStrip = (PagerTabStrip) findViewById(R.id.myvierpagertab_fragment02);
        pagerTabStrip.setTabIndicatorColor(Color.parseColor("#0000ff"));
        pagerTabStrip.setBackgroundColor(Color.parseColor("#00ff00"));
        viewPager.setAdapter(new MyAdapter(getSupportFragmentManager()));
    }

    class MyAdapter extends FragmentPagerAdapter {
        public MyAdapter(FragmentManager fm) {
            super(fm);
        }

        @Override
        public Fragment getItem(int position) {
            return fragmentList.get(position);
        }

        @Override
        public int getCount() {
            return fragmentList.size();
        }

        @Override
        public CharSequence getPageTitle(int position) {
            return str[position];
        }
    }
}
