package com.google.lenono.pullfresh;

import android.graphics.Color;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.PagerTitleStrip;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import java.util.ArrayList;
import java.util.List;

public class ViewPagerFragmentTitleActivity extends AppCompatActivity {
    ViewPager viewPager;
    PagerTitleStrip pagerTitleStrip;
    String[] str = {"标题1", "标题2", "标题3"};
    List<Fragment> fragmentList;
    Fragment01 fragment01;
    Fragment02 fragment02;
    Fragment03 fragment03;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_pager_fragment_title);
        viewPager = (ViewPager) findViewById(R.id.myvierpager_fragment03);
        pagerTitleStrip = (PagerTitleStrip) findViewById(R.id.myvierpagertitle_fragment03);
        pagerTitleStrip.setBackgroundColor(Color.parseColor("#5500ff00"));
        fragmentList = new ArrayList<>();
        fragment01 = new Fragment01();
        fragment02 = new Fragment02();
        fragment03 = new Fragment03();
        fragmentList.add(fragment01);
        fragmentList.add(fragment02);
        fragmentList.add(fragment03);
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
