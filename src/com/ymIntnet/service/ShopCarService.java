package com.ymIntnet.service;

import com.ymIntnet.entity.ShopCar;

import java.util.List;

public interface ShopCarService {
    public List<ShopCar> shopCarFindAll();
    public int shopCarInsert(ShopCar sc);
    public int shopCarDelete(ShopCar sc);
    public int shopCarModify(ShopCar sc);
    public List<ShopCar> shopCarIdFindAll(int id);
}
