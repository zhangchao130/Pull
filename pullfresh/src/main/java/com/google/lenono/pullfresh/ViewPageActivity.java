package com.google.lenono.pullfresh;

import android.os.AsyncTask;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.handmark.pulltorefresh.extras.viewpager.PullToRefreshViewPager;


import com.handmark.pulltorefresh.library.PullToRefreshBase;

public class ViewPageActivity extends AppCompatActivity implements PullToRefreshBase.OnRefreshListener<ViewPager> {
    PullToRefreshViewPager pullToRefreshViewPager;
    ViewPager viewPager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_page);
        pullToRefreshViewPager = (PullToRefreshViewPager) findViewById(R.id.refresh_viewpager);
        viewPager = pullToRefreshViewPager.getRefreshableView();
        viewPager.setAdapter(new SampleViewPagerAdapter());

    }

    @Override
    public void onRefresh(PullToRefreshBase<ViewPager> refreshView) {

    }

    static class SampleViewPagerAdapter extends PagerAdapter {
        static int[] sDrawable = {R.drawable.gdwhite, R.drawable.gd, R.drawable.gdwhite, R.drawable.gd};

        //R.drawable.gd, R.drawable.gdred, R.drawable.gdwhite
        @Override
        public int getCount() {
            return sDrawable.length;
        }

        @Override
        public Object instantiateItem(ViewGroup container, int position) {
            ImageView iv = new ImageView(container.getContext());
            iv.setImageResource(sDrawable[position]);
            container.addView(iv, ViewPager.LayoutParams.MATCH_PARENT, ViewPager.LayoutParams.MATCH_PARENT);
            return iv;
        }

        @Override
        public void destroyItem(ViewGroup container, int position, Object object) {
            container.removeView((View) object);
        }

        @Override
        public boolean isViewFromObject(View view, Object object) {

            return view == object;
        }
    }

    class MyExecute extends AsyncTask<Void, Void, Void> {
        @Override
        protected Void doInBackground(Void... voids) {
            try {
                Thread.sleep(3000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            return null;
        }

        @Override
        protected void onPostExecute(Void aVoid) {
            pullToRefreshViewPager.onRefreshComplete();
            super.onPostExecute(aVoid);
        }
    }
}
