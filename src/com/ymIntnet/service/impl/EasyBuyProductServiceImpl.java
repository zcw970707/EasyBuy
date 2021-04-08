package com.ymIntnet.service.impl;

import com.ymIntnet.dao.EasyBuyProductDao;
import com.ymIntnet.dao.impl.EasyBuyProductDaoImpl;
import com.ymIntnet.entity.EasyBuyProduct;
import com.ymIntnet.service.EasyBuyProductService;

import java.util.List;

public class EasyBuyProductServiceImpl implements EasyBuyProductService {
    EasyBuyProductDao ed = new EasyBuyProductDaoImpl();
    @Override
    public List<EasyBuyProduct> shopFind(int id) {
        return ed.shopFind(id);
    }

    @Override
    public List<EasyBuyProduct> browseFind(int id) {
        return ed.browseFind(id);
    }

    @Override
    public List<EasyBuyProduct> hotSellFind() {
        return ed.hotSellFind();
    }

    @Override
    public int productInsert(EasyBuyProduct pro) {
        return ed.productInsert(pro);
    }
}
