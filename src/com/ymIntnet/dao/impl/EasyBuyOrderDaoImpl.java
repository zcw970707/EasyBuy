package com.ymIntnet.dao.impl;

import com.ymIntnet.dao.BaseDao;
import com.ymIntnet.dao.EasyBuyOrderDao;
import com.ymIntnet.entity.EasyBuyOrder;
import com.ymIntnet.entity.EasyBuyOrderDetail;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class EasyBuyOrderDaoImpl extends BaseDao implements EasyBuyOrderDao {

    @Override
    public List<EasyBuyOrder> easyBuyOrderIdFind(String id) {
        String sql = "select * from easybuy_order where EO_ID='"+id+"'";
        List<EasyBuyOrder> eboList = new ArrayList<>();
        rs = query(sql,null);
        try {
            while (rs.next()){
                EasyBuyOrder ebo = new EasyBuyOrder();
                ebo.setEo_id(rs.getString("EO_ID"));
                ebo.setEo_user_id(rs.getString("EO_USER_ID"));
                ebo.setEo_user_name(rs.getString("EO_USER_NAME"));
                ebo.setEo_user_address(rs.getString("EO_USER_ADDRESS"));
                ebo.setEo_create_time(rs.getDate("EO_CREATE_TIME"));
                ebo.setEo_cost(rs.getInt("EO_COST"));
                ebo.setEo_status(rs.getInt("EO_STATUS"));
                ebo.setEo_type(rs.getInt("EO_TYPE"));
                eboList.add(ebo);
            }
        }catch (SQLException e){
            e.printStackTrace();
        }
        return eboList;
    }

    @Override
    public int easyBuyOrderInsert(EasyBuyOrder ebo) {
        String sql = "insert into easybuy_order values(?,?,?,?,?,?,?,?)";
        System.out.println();
        Object[]obj={ebo.getEo_id(),ebo.getEo_user_id(),ebo.getEo_user_name(),ebo.getEo_user_address(),
                    ebo.getEo_create_time(),ebo.getEo_cost(),ebo.getEo_status(),ebo.getEo_type()};
        return update(sql,obj);
    }

    @Override
    //UPDATE Person SET Address = 'Zhongshan 23', City = 'Nanjing'
   // WHERE LastName = 'Wilson'

    public int easyBuyOrderModify(String id, int eo_status) {
        String sql = "update easybuy_order set EO_STATUS="+eo_status+" where EO_ID="+id+"";
        return update(sql,null);
    }

    @Override
    public int easyBuyOrderDelete(String id) {
        String sql = "delete from easybuy_order where EO_ID ="+id+"";
        return update(sql,null);
    }

    public List<EasyBuyOrder> allFind(String id, String name) {
        String sql = "select * from easybuy_order where 1=1";
        List<EasyBuyOrder> ebList = new ArrayList<>();
        if (id!=null&&id!=""){
            sql+=" and EO_ID='"+id+"'";
        }
        if (name!=null&&name!=""){
            sql+=" and EO_USER_ID='"+name+"'";
        }
        rs = query(sql,null);
        try {
            while (rs.next()){
                EasyBuyOrder ebo = new EasyBuyOrder();
                ebo.setEo_type(rs.getInt("EO_TYPE"));
                ebo.setEo_cost(rs.getDouble("EO_COST"));
                ebo.setEo_status(rs.getInt("EO_STATUS"));
                ebo.setEo_create_time(rs.getDate("EO_CREATE_TIME"));
                ebo.setEo_user_address(rs.getString("EO_USER_ADDRESS"));
                ebo.setEo_user_name(rs.getString("EO_USER_NAME"));
                ebo.setEo_user_id(rs.getString("EO_USER_ID"));
                ebo.setEo_id(rs.getString("EO_ID"));
                ebList.add(ebo);
            }
        }catch (SQLException e){
           e.printStackTrace();
        }

        return ebList;
    }
}
