package com.google.lenono.internetdownloadparctice.utils;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.google.lenono.internetdownloadparctice.R;
import com.google.lenono.internetdownloadparctice.common.ManengerCache;
import com.google.lenono.internetdownloadparctice.common.News;

import java.util.List;

/**
 * Created by lenono on 2016-06-24.
 */
public class MyAdapter extends BaseAdapter {
    private Context context;
    private List<News> data;
    private ManengerCache manengerCache;

    public MyAdapter(Context context, List<News> data) {
        this.context = context;
        this.data = data;
        manengerCache = new ManengerCache();
    }

    @Override
    public int getCount() {
        return data.size();
    }

    @Override
    public Object getItem(int i) {
        return data.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        ViewHolder holder = null;
        if (view == null) {
            view = View.inflate(context, R.layout.item, null);
            holder = new ViewHolder();
            holder.iv = (ImageView) view.findViewById(R.id.iv);
            holder.tv = (TextView) view.findViewById(R.id.tv);
            holder.tv2 = (TextView) view.findViewById(R.id.tv2);
            view.setTag(holder);
        } else {
            holder = (ViewHolder) view.getTag();
        }
        holder.tv.setText(data.get(i).getTitle());
        Log.i("bbb", data.get(i).getTitle() + "");
        holder.tv2.setText(data.get(i).getDescription());

        String path = data.get(i).getLitpic().toString();
        if (path !=3573707+""&&path!=null) {
            String imagePath = "http://www.3dmgame.com" + path;
            manengerCache.getCache(imagePath, holder.iv);
        } else {
            holder.iv.setImageResource(R.mipmap.ic_launcher);
        }
        return view;
    }

    static class ViewHolder {
        ImageView iv;
        TextView tv;
        TextView tv2;
    }
}
