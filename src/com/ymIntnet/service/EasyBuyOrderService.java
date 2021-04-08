package com.ymIntnet.service;

import com.ymIntnet.entity.EasyBuyOrder;

import java.util.Date;
import java.util.List;

public interface EasyBuyOrderService {
    public List<EasyBuyOrder> easyBuyOrderIdFind(String id);
    public int easyBuyOrderInsert(EasyBuyOrder ebo);
    public int easyBuyOrderModify(String id,int eo_status);
    public int easyBuyOrderDelete(String id);
    public List<EasyBuyOrder> allFind(String id, String name);
}
