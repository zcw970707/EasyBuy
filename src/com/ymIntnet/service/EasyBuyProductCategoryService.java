package com.ymIntnet.service;

import com.ymIntnet.entity.EasyBuyProductCategory;

import java.util.List;

public interface EasyBuyProductCategoryService {
    //查询所有父分类
    public List<EasyBuyProductCategory> findAllParents();
    //根据父分类id查询对应的子分类集合
    public List<EasyBuyProductCategory> findParentId(int id);
}
