package com.ymIntnet.entity;

public class ShopCar {
    private int shopCarId;//购物车条目id
    private EasyBuyProduct ebp;//商品对象,删除时查找id，删除购物车商品
    private int shopCount=1;//商品数量
    private double shopCarTotalPrice;//商品小计

    public ShopCar() {
    }

    public int getShopCarId() {
        return shopCarId;
    }

    public void setShopCarId(int shopCarId) {
        this.shopCarId = shopCarId;
    }

    public EasyBuyProduct getEbp() {
        return ebp;
    }

    public void setEbp(EasyBuyProduct ebp) {
        this.ebp = ebp;
    }

    public int getShopCount() {
        return shopCount;
    }

    public void setShopCount(int shopCount) {
        this.shopCount = shopCount;
    }

    public double getShopCarTotalPrice() {
        return shopCarTotalPrice;
    }

    public void setShopCarTotalPrice(double shopCarTotalPrice) {
        this.shopCarTotalPrice = shopCarTotalPrice;
    }
}
