package com.ymIntnet.dao.impl;

import com.ymIntnet.dao.BaseDao;
import com.ymIntnet.dao.EasyBuyNewsDao;
import com.ymIntnet.entity.EasyBuyNews;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class EasyBuyNewsDaoImpl extends BaseDao implements EasyBuyNewsDao {

    @Override
    public List<EasyBuyNews> newsFindAll() {
        String sql = "select * from easybuy_news";
        List<EasyBuyNews> newsList = new ArrayList<>();
        rs=query(sql,null);
        try {
            while (rs.next()){
                EasyBuyNews news = new EasyBuyNews();
                news.setEnId(rs.getInt("EN_ID"));
                news.setEnTitle(rs.getString("EN_TITLE"));
                news.setEnContent(rs.getString("EN_CONTENT"));
                news.setEnCreateTime(rs.getDate("EN_CREATE_TIME"));
                newsList.add(news);
            }
        }catch (SQLException e){
            e.printStackTrace();
        }finally {
            closeAll(con,ps,rs);
        }
        return newsList;
    }
}
