package com.ymIntnet.dao.impl;

import com.ymIntnet.dao.BaseDao;
import com.ymIntnet.dao.EasyBuyProductDao;
import com.ymIntnet.entity.EasyBuyProduct;
import com.ymIntnet.entity.EasyBuyProductCategory;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class EasyBuyProductDaoImpl extends BaseDao implements EasyBuyProductDao {
    @Override
    public List<EasyBuyProduct> shopFind(int id) {
        String sql="select * from easybuy_product_category as epc,easybuy_product as ep where epc.EPC_ID=ep.EPC_ID and ep.EPC_ID=?";
        Object[]obj={id};
        List<EasyBuyProduct> eList = new ArrayList<>();
        rs=query(sql,obj);
        try {
            while (rs.next()){
                EasyBuyProductCategory ebc = new EasyBuyProductCategory();
                EasyBuyProduct ebp = new EasyBuyProduct();
                ebc.setEpcId(rs.getInt("EPC_ID"));
                ebp.setEpId(rs.getInt("EP_ID"));
                ebp.setEpNam(rs.getString("EP_NAME"));
                ebp.setEpDescription(rs.getString("EP_DESCRIPTION"));
                ebp.setEpPrice(rs.getInt("EP_PRICE"));
                ebp.setEpStock(rs.getInt("EP_STOCK"));
                ebp.setEpcId(ebc);
                ebp.setEpcChildId(rs.getInt("EPC_CHILD_ID"));
                ebp.setEpFileName(rs.getString("EP_FILE_NAME"));
                eList.add(ebp);
            }
        }catch (SQLException e){
            e.printStackTrace();
        }finally {
            closeAll(con,ps,rs);
        }
        return eList;
    }

    @Override
    public List<EasyBuyProduct> browseFind(int id) {
        String sql="select * from easybuy_product where EP_ID=?";
        Object[]obj={id};
        List<EasyBuyProduct> eList = new ArrayList<>();
        rs=query(sql,obj);
        try {
            while (rs.next()){
                EasyBuyProductCategory ebc = new EasyBuyProductCategory();
                EasyBuyProduct ebp = new EasyBuyProduct();
                ebc.setEpcId(rs.getInt("EPC_ID"));
                ebp.setEpId(rs.getInt("EP_ID"));
                ebp.setEpNam(rs.getString("EP_NAME"));
                ebp.setEpDescription(rs.getString("EP_DESCRIPTION"));
                ebp.setEpPrice(rs.getInt("EP_PRICE"));
                ebp.setEpStock(rs.getInt("EP_STOCK"));
                ebp.setEpcId(ebc);
                ebp.setEpcChildId(rs.getInt("EPC_CHILD_ID"));
                ebp.setEpFileName(rs.getString("EP_FILE_NAME"));
                eList.add(ebp);
            }
        }catch (SQLException e){
            e.printStackTrace();
        }finally {
            closeAll(con,ps,rs);
        }
        return eList;
    }
    public List<EasyBuyProduct> hotSellFind() {
        String sql="select * from easybuy_product order by EP_STOCK DESC";
        List<EasyBuyProduct> eList = new ArrayList<>();
        rs=query(sql,null);
        try {
            while (rs.next()){
                EasyBuyProductCategory ebc = new EasyBuyProductCategory();
                EasyBuyProduct ebp = new EasyBuyProduct();
                ebc.setEpcId(rs.getInt("EPC_ID"));
                ebp.setEpId(rs.getInt("EP_ID"));
                ebp.setEpNam(rs.getString("EP_NAME"));
                ebp.setEpDescription(rs.getString("EP_DESCRIPTION"));
                ebp.setEpPrice(rs.getInt("EP_PRICE"));
                ebp.setEpStock(rs.getInt("EP_STOCK"));
                ebp.setEpcId(ebc);
                ebp.setEpcChildId(rs.getInt("EPC_CHILD_ID"));
                ebp.setEpFileName(rs.getString("EP_FILE_NAME"));
                eList.add(ebp);
            }
        }catch (SQLException e){
            e.printStackTrace();
        }finally {
            closeAll(con,ps,rs);
        }
        return eList;
    }

    @Override
    public int productInsert(EasyBuyProduct pro) {
        String sql = "insert into easybuy_product(EP_ID,EP_NAME,EP_DESCRIPTION,EP_PRICE,EP_STOCK,EPC_ID,EP_FILE_NAME) values(?,?,?,?,?,?,?)";
        Object[]obj={pro.getEpId(),pro.getEpNam(),pro.getEpDescription(),pro.getEpPrice(),pro.getEpStock(),pro.getEpcId().getEpcId(),pro.getEpFileName()};
        return update(sql,obj);
    }
}
