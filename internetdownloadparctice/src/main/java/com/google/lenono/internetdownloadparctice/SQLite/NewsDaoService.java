package com.google.lenono.internetdownloadparctice.SQLite;

import android.content.Context;

import com.google.lenono.internetdownloadparctice.common.News;

import java.util.List;

/**
 * Created by lenono on 2016-06-24.
 */
public class NewsDaoService {
    private NewsDao newsDao;

    public NewsDaoService(Context context) {
        newsDao = new NewsDao(context);
    }

    public boolean insert(News news) {
        return newsDao.insert(news);
    }

    public List<News> getAllNewsListData() {
        return newsDao.getAllNewsListData();
    }

    public List<News> getAllNewsListDataScroll(int pageSize, int pageIndex) {
        return newsDao.getAllNewsListDataScroll(pageSize, pageIndex);
    }
}
