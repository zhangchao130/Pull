package com.google.lenono.internetdownloadparctice.SQLite;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.google.lenono.internetdownloadparctice.common.News;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by lenono on 2016-06-24.
 */
public class NewsDao {
    private MySQLiteOpenHelper helper;

    public NewsDao(Context context) {
        helper = new MySQLiteOpenHelper(context);
    }

    public boolean insert(News news) {
        SQLiteDatabase db = null;
        try {
            db = helper.getReadableDatabase();
            ContentValues values = new ContentValues();
            values.put("id", news.getId());
            values.put("typeid", news.getTypeid());
            values.put("typeid2", news.getTypeid2());
            values.put("sortrank", news.getSortrank());
            values.put("flag", news.getFlag());
            values.put("ismake", news.getIsmake());
            values.put("channel", news.getChannel());
            values.put("arcrank", news.getArcrank());
            values.put("click", news.getClick());
            values.put("money", news.getMoney());
            values.put("title", news.getTitle());
            values.put("shorttitle", news.getShorttitle());
            values.put("color", news.getColor());
            values.put("writer", news.getWriter());
            values.put("source", news.getSource());
            values.put("litpic", news.getLitpic());
            values.put("pubdate", news.getPubdate());
            values.put("senddate", news.getSenddate());
            values.put("mid", news.getMid());
            values.put("keywords", news.getKeywords());
            values.put("lastpost", news.getLastpost());
            values.put("scores", news.getScores());
            values.put("goodpost", news.getGoodpost());
            values.put("badpost", news.getBadpost());
            values.put("voteid", news.getVoteid());
            values.put("notpost", news.getNotpost());
            values.put("description", news.getDescription());
            values.put("filename", news.getFilename());
            values.put("dutyadmin", news.getDutyadmin());
            values.put("tackid", news.getTackid());
            values.put("mtype", news.getMtype());
            values.put("weight", news.getWeight());
            values.put("fby_id", news.getFby_id());
            values.put("game_id", news.getGame_id());
            values.put("feedback", news.getFeedback());
            values.put("typedir", news.getTypedir());
            values.put("typename", news.getTypename());
            values.put("corank", news.getCorank());
            values.put("isdefault", news.getIsdefault());
            values.put("defaultname", news.getDefaultname());
            values.put("namerule", news.getNamerule());
            values.put("namerule2", news.getNamerule2());
            values.put("ispart", news.getIspart());
            values.put("moresite", news.getMoresite());
            values.put("siteurl", news.getSiteurl());
            values.put("sitepath", news.getSitepath());
            values.put("typeurl", news.getTypeurl());
            db.insert("news", null, values);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (db != null) {
                db.close();
            }
        }
        return false;
    }

    public List<News> getAllNewsListData() {
        List<News> data = new ArrayList<News>();
        SQLiteDatabase db = null;
        Cursor cursor = null;
        try {
            db = helper.getReadableDatabase();
            cursor = db.query("news", null, null, null, null, null, null);
            while (cursor.moveToNext()) {
                String id = cursor.getString(cursor.getColumnIndex("id"));
                String typeid = cursor.getString(cursor.getColumnIndex("typeid"));
                String typeid2 = cursor.getString(cursor.getColumnIndex("typeid2"));
                String sortrank = cursor.getString(cursor.getColumnIndex("sortrank"));
                String flag = cursor.getString(cursor.getColumnIndex("flag"));
                String ismake = cursor.getString(cursor.getColumnIndex("ismake"));
                String channel = cursor.getString(cursor.getColumnIndex("channel"));
                String arcrank = cursor.getString(cursor.getColumnIndex("arcrank"));
                String click = cursor.getString(cursor.getColumnIndex("click"));
                String money = cursor.getString(cursor.getColumnIndex("money"));
                String title = cursor.getString(cursor.getColumnIndex("title"));
                String shorttitle = cursor.getString(cursor.getColumnIndex("shorttitle"));
                String color = cursor.getString(cursor.getColumnIndex("color"));
                String writer = cursor.getString(cursor.getColumnIndex("writer"));
                String source = cursor.getString(cursor.getColumnIndex("source"));
                String litpic = cursor.getString(cursor.getColumnIndex("litpic"));
                String pubdate = cursor.getString(cursor.getColumnIndex("pubdate"));
                String senddate = cursor.getString(cursor.getColumnIndex("senddate"));
                String mid = cursor.getString(cursor.getColumnIndex("mid"));
                String keywords = cursor.getString(cursor.getColumnIndex("keywords"));
                String lastpost = cursor.getString(cursor.getColumnIndex("lastpost"));
                String scores = cursor.getString(cursor.getColumnIndex("scores"));
                String goodpost = cursor.getString(cursor.getColumnIndex("goodpost"));
                String badpost = cursor.getString(cursor.getColumnIndex("badpost"));
                String voteid = cursor.getString(cursor.getColumnIndex("voteid"));
                String notpost = cursor.getString(cursor.getColumnIndex("notpost"));
                String description = cursor.getString(cursor.getColumnIndex("description"));
                String filename = cursor.getString(cursor.getColumnIndex("filename"));
                String dutyadmin = cursor.getString(cursor.getColumnIndex("dutyadmin"));
                String tackid = cursor.getString(cursor.getColumnIndex("tackid"));
                String mtype = cursor.getString(cursor.getColumnIndex("mtype"));
                String weight = cursor.getString(cursor.getColumnIndex("weight"));
                String fby_id = cursor.getString(cursor.getColumnIndex("fby_id"));
                String game_id = cursor.getString(cursor.getColumnIndex("game_id"));
                String feedback = cursor.getString(cursor.getColumnIndex("feedback"));
                String typedir = cursor.getString(cursor.getColumnIndex("typedir"));
                String typename = cursor.getString(cursor.getColumnIndex("typename"));
                String corank = cursor.getString(cursor.getColumnIndex("corank"));
                String isdefault = cursor.getString(cursor.getColumnIndex("isdefault"));
                String defaultname = cursor.getString(cursor.getColumnIndex("defaultname"));
                String namerule = cursor.getString(cursor.getColumnIndex("namerule"));
                String namerule2 = cursor.getString(cursor.getColumnIndex("namerule2"));
                String ispart = cursor.getString(cursor.getColumnIndex("ispart"));
                String moresite = cursor.getString(cursor.getColumnIndex("moresite"));
                String siteurl = cursor.getString(cursor.getColumnIndex("siteurl"));
                String sitepath = cursor.getString(cursor.getColumnIndex("sitepath"));
                String typeurl = cursor.getString(cursor.getColumnIndex("typeurl"));
                News news = new News( id, typeid, typeid2, sortrank, flag, ismake, channel, arcrank, click, money, title, shorttitle, color
                        , writer, source, litpic, pubdate, senddate, mid, keywords, lastpost, scores, goodpost, badpost, voteid, notpost, description, filename, dutyadmin, tackid, mtype,
                        weight, fby_id, game_id, feedback, typedir, typename, corank, isdefault, defaultname, namerule, namerule2, ispart, moresite, siteurl, sitepath,
                        typeurl);

                data.add(news);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (cursor != null && !cursor.isClosed()) {
                cursor.close();
            }

            if (db != null && db.isOpen()) {
                db.close();
            }

        }
        return data;
    }

    public List<News> getAllNewsListDataScroll(int pageSize, int pageIndex) {
        List<News> data = new ArrayList<News>();
        SQLiteDatabase db = null;
        Cursor cursor = null;
        try {
            db = helper.getReadableDatabase();
            int offset = (pageIndex - 1) * pageSize;
            cursor = db.query("news", null, null, null, null, null, "id",
                    String.valueOf(offset) + " , " + String.valueOf(pageSize));
            while (cursor.moveToNext()) {

                String id = cursor.getString(cursor.getColumnIndex("id"));
                String typeid = cursor.getString(cursor.getColumnIndex("typeid"));
                String typeid2 = cursor.getString(cursor.getColumnIndex("typeid2"));
                String sortrank = cursor.getString(cursor.getColumnIndex("sortrank"));
                String flag = cursor.getString(cursor.getColumnIndex("flag"));
                String ismake = cursor.getString(cursor.getColumnIndex("ismake"));
                String channel = cursor.getString(cursor.getColumnIndex("channel"));
                String arcrank = cursor.getString(cursor.getColumnIndex("arcrank"));
                String click = cursor.getString(cursor.getColumnIndex("click"));
                String money = cursor.getString(cursor.getColumnIndex("money"));
                String title = cursor.getString(cursor.getColumnIndex("title"));
                String shorttitle = cursor.getString(cursor.getColumnIndex("shorttitle"));
                String color = cursor.getString(cursor.getColumnIndex("color"));
                String writer = cursor.getString(cursor.getColumnIndex("writer"));
                String source = cursor.getString(cursor.getColumnIndex("source"));
                String litpic = cursor.getString(cursor.getColumnIndex("litpic"));
                String pubdate = cursor.getString(cursor.getColumnIndex("pubdate"));
                String senddate = cursor.getString(cursor.getColumnIndex("senddate"));
                String mid = cursor.getString(cursor.getColumnIndex("mid"));
                String keywords = cursor.getString(cursor.getColumnIndex("keywords"));
                String lastpost = cursor.getString(cursor.getColumnIndex("lastpost"));
                String scores = cursor.getString(cursor.getColumnIndex("scores"));
                String goodpost = cursor.getString(cursor.getColumnIndex("goodpost"));
                String badpost = cursor.getString(cursor.getColumnIndex("badpost"));
                String voteid = cursor.getString(cursor.getColumnIndex("voteid"));
                String notpost = cursor.getString(cursor.getColumnIndex("notpost"));
                String description = cursor.getString(cursor.getColumnIndex("description"));
                String filename = cursor.getString(cursor.getColumnIndex("filename"));
                String dutyadmin = cursor.getString(cursor.getColumnIndex("dutyadmin"));
                String tackid = cursor.getString(cursor.getColumnIndex("tackid"));
                String mtype = cursor.getString(cursor.getColumnIndex("mtype"));
                String weight = cursor.getString(cursor.getColumnIndex("weight"));
                String fby_id = cursor.getString(cursor.getColumnIndex("fby_id"));
                String game_id = cursor.getString(cursor.getColumnIndex("game_id"));
                String feedback = cursor.getString(cursor.getColumnIndex("feedback"));
                String typedir = cursor.getString(cursor.getColumnIndex("typedir"));
                String typename = cursor.getString(cursor.getColumnIndex("typename"));
                String corank = cursor.getString(cursor.getColumnIndex("corank"));
                String isdefault = cursor.getString(cursor.getColumnIndex("isdefault"));
                String defaultname = cursor.getString(cursor.getColumnIndex("defaultname"));
                String namerule = cursor.getString(cursor.getColumnIndex("namerule"));
                String namerule2 = cursor.getString(cursor.getColumnIndex("namerule2"));
                String ispart = cursor.getString(cursor.getColumnIndex("ispart"));
                String moresite = cursor.getString(cursor.getColumnIndex("moresite"));
                String siteurl = cursor.getString(cursor.getColumnIndex("siteurl"));
                String sitepath = cursor.getString(cursor.getColumnIndex("sitepath"));
                String typeurl = cursor.getString(cursor.getColumnIndex("typeurl"));
                News news = new News( id, typeid, typeid2, sortrank, flag, ismake, channel, arcrank, click, money, title, shorttitle, color
                        , writer, source, litpic, pubdate, senddate, mid, keywords, lastpost, scores, goodpost, badpost, voteid, notpost, description, filename, dutyadmin, tackid, mtype,
                        weight, fby_id, game_id, feedback, typedir, typename, corank, isdefault, defaultname, namerule, namerule2, ispart, moresite, siteurl, sitepath,
                        typeurl);

                data.add(news);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (!cursor.isClosed() && cursor != null) {
                cursor.close();
            }
            if (db.isOpen() && db != null) {
                db.close();
            }
        }
        return data;
    }
}
