package com.ymIntnet.dao.impl;

import com.ymIntnet.dao.BaseDao;
import com.ymIntnet.dao.EasyBuyOrderDao;
import com.ymIntnet.dao.EasyBuyOrderDetailDao;
import com.ymIntnet.entity.EasyBuyOrder;
import com.ymIntnet.entity.EasyBuyOrderDetail;
import com.ymIntnet.entity.EasyBuyProduct;
import com.ymIntnet.entity.ShopCar;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class EasyBuyOrderDetailDaoImpl extends BaseDao implements EasyBuyOrderDetailDao {

    @Override
    public List<EasyBuyOrderDetail> OrderDetailDaoFindAll(List<ShopCar> scList,List<EasyBuyOrder> ebodList) {
        String sql = "select * from easybuy_order_detail";
        List<EasyBuyOrderDetail> eList = new ArrayList<>();
        rs = query(sql,null);
        try {
            while (rs.next()){
                EasyBuyOrderDetail eod = new EasyBuyOrderDetail();
                eod.setEod_id(rs.getInt("EOD_ID"));
                eod.setEo_id(rs.getString("EO_ID"));
                int [] ep_id=new int[scList.size()];
                int [] eod_quantity=new int[scList.size()];
                double[] eod_cost = new double[scList.size()];
                for (int i = 0; i <scList.size() ; i++) {
                    ep_id[i]=scList.get(i).getEbp().getEpId();
                    eod_quantity[i]=scList.get(i).getShopCount();
                    eod_cost[i]=scList.get(i).getShopCarTotalPrice();
                }
                eod.setEp_id(ep_id);
                eod.setEod_quantity(eod_quantity);
                eod.setEod_cost(eod_cost);
                eod.setEbodList(ebodList);
                eod.setScList(scList);
                eList.add(eod);
            }
        }catch (SQLException e){
            e.printStackTrace();
        }
        return eList;
    }

    @Override
    public int OrderDetailInsert(String id) {
        String sql = "insert into easybuy_order_detail(EO_ID) values ('"+id+"')";
        return update(sql,null);
    }

    @Override
    public int OrderDetailDelete(int eod_id) {
        String sql = "delete from easybuy_order_detail where EOD_ID = "+eod_id+"";
        return update(sql,null);
    }

}
