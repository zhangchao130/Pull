package com.google.lenono.internetdownloadparctice.utils;

import com.google.lenono.internetdownloadparctice.common.News;

import org.json.JSONObject;

/**
 * Created by lenono on 2016-06-24.
 */
public class JsonUtils {
    public static News jsonList(String json, int obj) {
        try {
            News news = new News();
            JSONObject jsonObject = new JSONObject(json);
            JSONObject jsonObject1 = jsonObject.getJSONObject("data");
            JSONObject jsonObject2 = jsonObject1.getJSONObject(obj+"");
            String id = jsonObject2.getString("id");
            String typeid = jsonObject2.getString("typeid");
            String typeid2 = jsonObject2.getString("typeid2");
            String sortrank = jsonObject2.getString("sortrank");
            String flag = jsonObject2.getString("flag");
            String ismake = jsonObject2.getString("ismake");
            String channel = jsonObject2.getString("channel");
            String arcrank = jsonObject2.getString("arcrank");
            String click = jsonObject2.getString("click");
            String money = jsonObject2.getString("money");
            String title = jsonObject2.getString("title");
            String shorttitle = jsonObject2.getString("shorttitle");
            String color = jsonObject2.getString("color");
            String writer = jsonObject2.getString("writer");
            String source = jsonObject2.getString("source");
            String litpic = jsonObject2.getString("litpic");
            String pubdate = jsonObject2.getString("pubdate");
            String senddate = jsonObject2.getString("senddate");
            String mid = jsonObject2.getString("mid");
            String keywords = jsonObject2.getString("keywords");
            String lastpost = jsonObject2.getString("lastpost");
            String scores = jsonObject2.getString("scores");
            String goodpost = jsonObject2.getString("goodpost");
            String badpost = jsonObject2.getString("badpost");
            String voteid = jsonObject2.getString("voteid");
            String notpost = jsonObject2.getString("notpost");
            String description = jsonObject2.getString("description");
            String filename = jsonObject2.getString("filename");
            String dutyadmin = jsonObject2.getString("dutyadmin");
            String tackid = jsonObject2.getString("tackid");
            String mtype = jsonObject2.getString("mtype");
            String weight = jsonObject2.getString("weight");
            String fby_id = jsonObject2.getString("fby_id");
            String game_id = jsonObject2.getString("game_id");
            String feedback = jsonObject2.getString("feedback");
            String typedir = jsonObject2.getString("typedir");
            String typename = jsonObject2.getString("typename");
            String corank = jsonObject2.getString("corank");
            String isdefault = jsonObject2.getString("isdefault");
            String defaultname = jsonObject2.getString("defaultname");
            String namerule = jsonObject2.getString("namerule");
            String namerule2 = jsonObject2.getString("namerule2");
            String ispart = jsonObject2.getString("ispart");
            String moresite = jsonObject2.getString("moresite");
            String siteurl = jsonObject2.getString("siteurl");
            String sitepath = jsonObject2.getString("sitepath");
            String typeurl = jsonObject2.getString("typeurl");
            news.setId(id);
            news.setTypeid(typeid);
            news.setTypeid2(typeid2);
            news.setSortrank(sortrank);
            news.setFlag(flag);
            news.setIsmake(ismake);
            news.setChannel(channel);
            news.setArcrank(arcrank);
            news.setClick(click);
            news.setMoney(money);
            news.setTitle(title);
            news.setShorttitle(shorttitle);
            news.setColor(color);
            news.setWriter(writer);
            news.setSource(source);
            news.setLitpic(litpic);
            news.setPubdate(pubdate);
            news.setSenddate(senddate);
            news.setMid(mid);
            news.setKeywords(keywords);
            news.setLastpost(lastpost);
            news.setScores(scores);
            news.setGoodpost(goodpost);
            news.setBadpost(badpost);
            news.setVoteid(voteid);
            news.setNotpost(notpost);
            news.setDescription(description);
            news.setFilename(filename);
            news.setDutyadmin(dutyadmin);
            news.setTackid(tackid);
            news.setMtype(mtype);
            news.setWeight(weight);
            news.setFby_id(fby_id);
            news.setGame_id(game_id);
            news.setFeedback(feedback);
            news.setTypedir(typedir);
            news.setTypename(typename);
            news.setCorank(corank);
            news.setIsdefault(isdefault);
            news.setDefaultname(defaultname);
            news.setNamerule(namerule);
            news.setNamerule2(namerule2);
            news.setIspart(ispart);
            news.setMoresite(moresite);
            news.setSiteurl(siteurl);
            news.setSitepath(sitepath);
            news.setTypeurl(typeurl);
            return news;
        } catch (Exception e) {
            e.printStackTrace();
        }

        return null;
    }
}
