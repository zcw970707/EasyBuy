package com.ymIntnet.service.impl;

import com.ymIntnet.dao.ShopCarDao;
import com.ymIntnet.dao.impl.ShopCarDaoImpl;
import com.ymIntnet.entity.ShopCar;
import com.ymIntnet.service.ShopCarService;

import java.util.List;

public class ShopCarServiceImpl implements ShopCarService {
    ShopCarDao scd = new ShopCarDaoImpl();
    @Override
    public List<ShopCar> shopCarFindAll() {
        return scd.shopCarFindAll();
    }

    @Override
    public int shopCarInsert(ShopCar sc) {
        return scd.shopCarInsert(sc);
    }

    @Override
    public int shopCarDelete(ShopCar sc) {
        return scd.shopCarDelete(sc);
    }

    @Override
    public int shopCarModify(ShopCar sc) {
        return scd.shopCarModify(sc);
    }

    @Override
    public List<ShopCar> shopCarIdFindAll(int id) {
        return scd.shopCarIdFindAll(id);
    }
}
