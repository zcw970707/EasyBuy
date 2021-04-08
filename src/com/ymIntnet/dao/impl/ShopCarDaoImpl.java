package com.ymIntnet.dao.impl;

import com.ymIntnet.dao.BaseDao;
import com.ymIntnet.dao.ShopCarDao;
import com.ymIntnet.entity.EasyBuyProduct;
import com.ymIntnet.entity.ShopCar;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ShopCarDaoImpl extends BaseDao implements ShopCarDao {
    @Override
    public List<ShopCar> shopCarFindAll() {
        String sql = "select * from shopcar as sc,easybuy_product as ebp where sc.epId=ebp.EP_ID";
        List<ShopCar> scList = new ArrayList<>();
        rs=query(sql,null);
        try {
            while (rs.next()){
                ShopCar sc = new ShopCar();
                EasyBuyProduct ebp = new EasyBuyProduct();
                ebp.setEpId(rs.getInt("EP_ID"));
                ebp.setEpNam(rs.getString("EP_NAME"));
                ebp.setEpPrice(rs.getInt("EP_PRICE"));
                ebp.setEpFileName(rs.getString("EP_FILE_NAME"));
                sc.setEbp(ebp);
                sc.setShopCarId(rs.getInt("shopCarId"));
                sc.setShopCount(rs.getInt("shopCount"));
                sc.setShopCarTotalPrice(rs.getDouble("shopCarTotalPrice"));
                scList.add(sc);
            }
        }catch (SQLException e){
            e.printStackTrace();
        }
        return scList;
    }

    @Override
    public int shopCarInsert(ShopCar sc) {
        String sql = "insert into shopcar(epId,shopCount,shopCarTotalPrice) values(?,?,?)";
        Object[]obj={sc.getEbp().getEpId(),sc.getShopCount(),sc.getShopCarTotalPrice()};
        return update(sql,obj);
    }

    @Override
    public int shopCarDelete(ShopCar sc) {
        String sql = "delete from shopcar where shopCarId="+sc.getShopCarId()+"";
        return update(sql,null);
    }

    @Override
    //UPDATE 表名称 SET 列名称 = 新值 WHERE 列名称 = 某值
    public int shopCarModify(ShopCar sc) {
        String sql = "update shopcar set shopCount = "+sc.getShopCount()+",shopCarTotalPrice="+sc.getShopCarTotalPrice()+" where shopCarId="+sc.getShopCarId()+"";
        return update(sql,null);
    }

    @Override
    public List<ShopCar> shopCarIdFindAll(int id) {
        String sql = "select * from shopcar as sc,easybuy_product as ebp where sc.epId=ebp.EP_ID and shopCarId=?";
        List<ShopCar> scList = new ArrayList<>();
        Object[]obj = {id};
        rs=query(sql,obj);
        try {
            while (rs.next()){
                ShopCar sc = new ShopCar();
                EasyBuyProduct ebp = new EasyBuyProduct();
                ebp.setEpId(rs.getInt("EP_ID"));
                ebp.setEpNam(rs.getString("EP_NAME"));
                ebp.setEpPrice(rs.getInt("EP_PRICE"));
                ebp.setEpFileName(rs.getString("EP_FILE_NAME"));
                ebp.setEpStock(rs.getInt("EP_STOCK"));
                sc.setEbp(ebp);
                sc.setShopCarId(rs.getInt("shopCarId"));
                sc.setShopCount(rs.getInt("shopCount"));
                sc.setShopCarTotalPrice(rs.getDouble("shopCarTotalPrice"));
                scList.add(sc);
            }
        }catch (SQLException e){
            e.printStackTrace();
        }
        return scList;
    }
}
