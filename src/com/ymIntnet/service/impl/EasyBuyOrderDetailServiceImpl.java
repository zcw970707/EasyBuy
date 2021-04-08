package com.ymIntnet.service.impl;

import com.ymIntnet.dao.EasyBuyOrderDetailDao;
import com.ymIntnet.dao.impl.EasyBuyOrderDetailDaoImpl;
import com.ymIntnet.entity.EasyBuyOrder;
import com.ymIntnet.entity.EasyBuyOrderDetail;
import com.ymIntnet.entity.EasyBuyProduct;
import com.ymIntnet.entity.ShopCar;
import com.ymIntnet.service.EasyBuyOrderDetailService;

import java.util.List;

public class EasyBuyOrderDetailServiceImpl implements EasyBuyOrderDetailService {
    EasyBuyOrderDetailDao ebodd = new EasyBuyOrderDetailDaoImpl();

    @Override
    public List<EasyBuyOrderDetail> OrderDetailDaoFindAll(List<ShopCar> scList, List<EasyBuyOrder> ebodList) {
        return ebodd.OrderDetailDaoFindAll(scList,ebodList);
    }

    @Override
    public int OrderDetailInsert(String id) {
        return ebodd.OrderDetailInsert(id);
    }

    @Override
    public int OrderDetailDelete(int eod_id) {
        return ebodd.OrderDetailDelete(eod_id);
    }




}
