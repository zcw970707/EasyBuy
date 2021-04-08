package com.ymIntnet.service.impl;

import com.ymIntnet.dao.EasyBuyUserDao;
import com.ymIntnet.dao.impl.EasyBuyUserDaoImpl;
import com.ymIntnet.entity.EasyBuyUser;
import com.ymIntnet.service.EasyBuyUserService;

import java.util.List;

public class EasyBuyUserServiceImpl implements EasyBuyUserService {
    EasyBuyUserDao  ebd = new EasyBuyUserDaoImpl();
    @Override
    public List<EasyBuyUser> userFind() {
        return ebd.userFind();
    }

    @Override
    public List<EasyBuyUser> loginFind(String name, String password) {
        return ebd.loginFind(name,password);
    }

    @Override
    public int userRegister(EasyBuyUser ebu) {
        return ebd.userRegister(ebu);
    }

    @Override
    public int userModify(EasyBuyUser ebu) {
        return ebd.userModify(ebu);
    }

    @Override
    public int userDelete(EasyBuyUser ebu) {
        return ebd.userDelete(ebu);
    }
}
