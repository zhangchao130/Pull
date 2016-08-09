package com.google.lenono.pullfresh;

import android.support.v4.app.Fragment;
import android.graphics.Color;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class ViewPagerFragmentActivity extends FragmentActivity implements View.OnClickListener, ViewPager.OnPageChangeListener {
    Fragment01 fragment01;
    Fragment02 fragment02;
    Fragment03 fragment03;
    ViewPager viewPager;
    List<Fragment> fragmentList;
    LinearLayout ll1, ll2, ll3;
    TextView tv1, tv2, tv3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_pager_fragment);
        ll1 = (LinearLayout) findViewById(R.id.ll1);
        ll2 = (LinearLayout) findViewById(R.id.ll2);
        ll3 = (LinearLayout) findViewById(R.id.ll3);
        tv1 = (TextView) findViewById(R.id.tv1);
        tv2 = (TextView) findViewById(R.id.tv2);
        tv3 = (TextView) findViewById(R.id.tv3);
        fragmentList = new ArrayList<>();
        fragment01 = new Fragment01();
        fragment02 = new Fragment02();
        fragment03 = new Fragment03();
        fragmentList.add(fragment01);
        fragmentList.add(fragment02);
        fragmentList.add(fragment03);
        viewPager = (ViewPager) findViewById(R.id.myvierpager_fragment);
        viewPager.setAdapter(new MyFragmentAdapter(getSupportFragmentManager()));
        viewPager.addOnPageChangeListener(this);
        viewPager.setCurrentItem(0);
        ll1.setOnClickListener(this);
        ll2.setOnClickListener(this);
        ll3.setOnClickListener(this);
    }

    class MyFragmentAdapter extends FragmentPagerAdapter {


        public MyFragmentAdapter(FragmentManager fm) {
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
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.ll1:
                viewPager.setCurrentItem(0);
                break;
            case R.id.ll2:
                viewPager.setCurrentItem(1);
                break;
            case R.id.ll3:
                viewPager.setCurrentItem(2);
                break;
        }
    }

    @Override
    public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

    }

    @Override
    public void onPageSelected(int position) {
        setTextColor(position);
    }

    @Override
    public void onPageScrollStateChanged(int state) {

    }

    public void setTextColor(int position) {
        reSetTextColor();
        switch (position) {
            case 0:
                tv1.setTextColor(Color.parseColor("#ff0000"));
                break;
            case 1:
                tv2.setTextColor(Color.parseColor("#00ff00"));
                break;
            case 2:
                tv3.setTextColor(Color.parseColor("#0000ff"));
                break;
        }
    }

    public void reSetTextColor() {
        tv1.setTextColor(Color.parseColor("#000000"));
        tv2.setTextColor(Color.parseColor("#000000"));
        tv3.setTextColor(Color.parseColor("#000000"));
    }
}
