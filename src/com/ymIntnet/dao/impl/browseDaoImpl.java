package com.ymIntnet.dao.impl;

import com.ymIntnet.dao.BaseDao;
import com.ymIntnet.dao.browseDao;
import com.ymIntnet.entity.Browse;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class browseDaoImpl extends BaseDao implements browseDao {
    @Override
    public List<Browse> findAll() {
        String sql = "select * from browse order by bId DESC";
        List<Browse> bList = new ArrayList<>();
        rs=query(sql,null);
        try {
            while (rs.next()){
                Browse bb = new Browse();
                bb.setBrowseId(rs.getInt("bId"));
                bb.setBrowseName(rs.getString("bName"));
                bb.setImgAddress(rs.getString("imgAdress"));
                bList.add(bb);
            }
        }catch (SQLException e){
            e.printStackTrace();
        }
        return bList;
    }

    @Override
    public int browseInsert(Browse bb) {
        String sql= "insert into browse(bName,imgAdress) values(?,?)";
        Object[]obj={bb.getBrowseName(),bb.getImgAddress()};
        return update(sql,obj);
    }

    @Override
    public int deleteAll() {
        String sql = "delete from browse";
        return update(sql,null);
    }

}
