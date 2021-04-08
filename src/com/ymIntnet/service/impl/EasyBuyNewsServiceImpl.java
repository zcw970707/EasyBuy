package com.ymIntnet.service.impl;

import com.ymIntnet.dao.EasyBuyNewsDao;
import com.ymIntnet.dao.impl.EasyBuyNewsDaoImpl;
import com.ymIntnet.entity.EasyBuyNews;
import com.ymIntnet.service.EasyBuyNewsService;

import java.util.List;

public class EasyBuyNewsServiceImpl implements EasyBuyNewsService {
    EasyBuyNewsDao ebd = new EasyBuyNewsDaoImpl();
    @Override
    public List<EasyBuyNews> newsFindAll() {
        return ebd.newsFindAll();
    }
}
