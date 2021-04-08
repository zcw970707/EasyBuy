package com.ymIntnet.service.impl;

import com.ymIntnet.dao.EasyBuyProductCategoryDao;
import com.ymIntnet.dao.impl.EasyBuyProductCategoryDaoImpl;
import com.ymIntnet.entity.EasyBuyProductCategory;
import com.ymIntnet.service.EasyBuyProductCategoryService;

import java.util.List;

public class EasyBuyProductCategoryServiceImpl implements EasyBuyProductCategoryService {
    EasyBuyProductCategoryDao ed = new EasyBuyProductCategoryDaoImpl();
    @Override
    public List<EasyBuyProductCategory> findAllParents() {
        return ed.findAllParents();
    }

    @Override
    public List<EasyBuyProductCategory> findParentId(int id) {
        return ed.findParentId(id);
    }
}
