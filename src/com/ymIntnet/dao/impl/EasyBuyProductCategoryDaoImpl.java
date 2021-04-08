package com.ymIntnet.dao.impl;

import com.ymIntnet.dao.BaseDao;
import com.ymIntnet.dao.EasyBuyProductCategoryDao;
import com.ymIntnet.entity.EasyBuyProductCategory;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class EasyBuyProductCategoryDaoImpl extends BaseDao implements EasyBuyProductCategoryDao {
    @Override
    public List<EasyBuyProductCategory> findAllParents() {
        String sql = "select * from easybuy_product_category where EPC_PARENT_ID=0";
        List<EasyBuyProductCategory> list = new ArrayList<>();
        ResultSet res=query(sql,null);
        try {
            while (res.next()){
                EasyBuyProductCategory epc = new EasyBuyProductCategory();
                epc.setEpcId(res.getInt("EPC_ID"));
                epc.setEpcName(res.getString("EPC_NAME"));
                epc.setEpcParentId(res.getInt("EPC_PARENT_ID"));
                epc.setList(findParentId(epc.getEpcId()));
                list.add(epc);
            }
        }catch (SQLException e){
            e.printStackTrace();
        }finally {
            closeAll(con,ps,rs);
        }
        return list;
    }

    @Override
    public List<EasyBuyProductCategory> findParentId(int id) {
        String sql = "select * from easybuy_product_category where EPC_PARENT_ID=?";
        List<EasyBuyProductCategory> eeList = new ArrayList<>();
        Object[]obj = {id};
        rs = query(sql,obj);
        try {
            while (rs.next()){
                EasyBuyProductCategory epcc = new EasyBuyProductCategory();
                epcc.setEpcId(rs.getInt("EPC_ID"));
                epcc.setEpcName(rs.getString("EPC_NAME"));
                epcc.setEpcParentId(rs.getInt("EPC_PARENT_ID"));
                eeList.add(epcc);
            }
        }catch (SQLException e){
            e.printStackTrace();
        }
        return eeList;
    }
}
