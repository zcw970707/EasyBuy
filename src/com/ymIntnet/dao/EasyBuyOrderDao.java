package com.ymIntnet.dao;

import com.ymIntnet.entity.EasyBuyOrder;
import com.ymIntnet.entity.EasyBuyOrderDetail;

import java.util.Date;
import java.util.List;

public interface EasyBuyOrderDao {
    public List<EasyBuyOrder> easyBuyOrderIdFind(String id);
    public int easyBuyOrderInsert(EasyBuyOrder ebo);
    public int easyBuyOrderModify(String id,int eo_status);
    public int easyBuyOrderDelete(String id);
    public List<EasyBuyOrder> allFind(String id, String name);
}
