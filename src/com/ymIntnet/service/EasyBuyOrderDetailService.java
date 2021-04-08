package com.ymIntnet.service;

import com.ymIntnet.entity.EasyBuyOrder;
import com.ymIntnet.entity.EasyBuyOrderDetail;
import com.ymIntnet.entity.ShopCar;

import java.util.List;

public interface EasyBuyOrderDetailService {
    public List<EasyBuyOrderDetail> OrderDetailDaoFindAll(List<ShopCar> scList,List<EasyBuyOrder> ebodList);
    public int OrderDetailInsert(String id);
    public int OrderDetailDelete(int eod_id);
}
