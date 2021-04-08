package com.ymIntnet.service;

import com.ymIntnet.entity.EasyBuyProduct;

import java.util.List;

public interface EasyBuyProductService {
    public List<EasyBuyProduct> shopFind(int id);
    public List<EasyBuyProduct> browseFind(int id);
    public List<EasyBuyProduct> hotSellFind();
    public int productInsert(EasyBuyProduct pro);
}
