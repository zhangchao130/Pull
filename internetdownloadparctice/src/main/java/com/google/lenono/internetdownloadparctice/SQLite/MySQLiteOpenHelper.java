package com.google.lenono.internetdownloadparctice.SQLite;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by lenono on 2016-06-24.
 */
public class MySQLiteOpenHelper extends SQLiteOpenHelper {
    public MySQLiteOpenHelper(Context context) {
        super(context, "news.db", null, 1);

    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        sqLiteDatabase.execSQL("create table if not exists news(id varchar(100) primary key,typeid varchar(10),typeid2 varchar(10),"
                + "sortrank varchar(100),flag varchar(20),ismake varchar(10),channel varchar(10),arcrank varchar(10),"
                + "click varchar(50),money varchar(10),title varchar(500),shorttitle varchar(100),color varchar(10),"
                + "writer varchar(50),source varchar(50),litpic varchar(200),pubdate varchar(100),"
                + "senddate varchar(100),mid varchar(20),keywords varchar(50),lastpost varchar(10),scores varchar(10),"
                + "goodpost varchar(10),badpost varchar(10),voteid varchar(10),notpost varchar(10),description varchar(1000),"
                + "filename varchar(10),dutyadmin varchar(20),tackid varchar(10),mtype varchar(10),weight varchar(50),"
                + "fby_id varchar(10),game_id varchar(10),feedback varchar(10),typedir varchar(100),typename varchar(50),"
                + "corank varchar(10),isdefault varchar(10),defaultname varchar(100),namerule varchar(100),namerule2 varchar(100),"
                + "ispart varchar(10),moresite varchar(10),siteurl varchar(10),sitepath varchar(50),typeurl varchar(100))");

    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

    }
}
