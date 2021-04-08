package com.ymIntnet.service.impl;

import com.ymIntnet.dao.browseDao;
import com.ymIntnet.dao.impl.browseDaoImpl;
import com.ymIntnet.entity.Browse;
import com.ymIntnet.service.browseService;

import java.util.List;

public class browseServiceImpl implements browseService {
    browseDao bd = new browseDaoImpl();
    @Override
    public List<Browse> findAll() {
        return bd.findAll();
    }

    @Override
    public int browseInsert(Browse bb) {
        return bd.browseInsert(bb);
    }

    @Override
    public int deleteAll() {
        return bd.deleteAll();
    }
}
