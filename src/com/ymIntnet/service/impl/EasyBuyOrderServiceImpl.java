package com.ymIntnet.service.impl;

import com.ymIntnet.dao.EasyBuyOrderDao;
import com.ymIntnet.dao.impl.EasyBuyOrderDaoImpl;
import com.ymIntnet.entity.EasyBuyOrder;
import com.ymIntnet.service.EasyBuyOrderService;

import java.util.List;

public class EasyBuyOrderServiceImpl implements EasyBuyOrderService {
    EasyBuyOrderDao ebod = new EasyBuyOrderDaoImpl();

    @Override
    public List<EasyBuyOrder> easyBuyOrderIdFind(String id) {
        return ebod.easyBuyOrderIdFind(id);
    }

    @Override
    public int easyBuyOrderInsert(EasyBuyOrder ebo) {
        return ebod.easyBuyOrderInsert(ebo);
    }

    @Override
    public int easyBuyOrderModify(String id, int eo_status) {
        return ebod.easyBuyOrderModify(id,eo_status);
    }

    @Override
    public int easyBuyOrderDelete(String id) {
        return ebod.easyBuyOrderDelete(id);
    }

    @Override
    public List<EasyBuyOrder> allFind(String id, String name) {
        return ebod.allFind(id,name);
    }


}
