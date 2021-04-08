package com.ymIntnet.entity;

import com.ymIntnet.dao.EasyBuyOrderDao;

import java.util.List;

//订单详情实体类
public class EasyBuyOrderDetail {
    private int eod_id;//订单详情id，自增
    private String eo_id;//订单id
    private int[] ep_id;//每条订单的各个商品id数组
    private int[] eod_quantity;//每条订单各个商品的数量数组
    private double[] eod_cost;//每条订单各个商品的小计数组
    private List<ShopCar> scList;//购物车所有信息，用来给订单详情实体类三个数组赋值
    private List<EasyBuyOrder> ebodList;

    public EasyBuyOrderDetail() {
    }

    public int getEod_id() {
        return eod_id;
    }

    public void setEod_id(int eod_id) {
        this.eod_id = eod_id;
    }

    public String getEo_id() {
        return eo_id;
    }

    public void setEo_id(String eo_id) {
        this.eo_id = eo_id;
    }

    public int[] getEp_id() {
        return ep_id;
    }

    public void setEp_id(int[] ep_id) {
        this.ep_id = ep_id;
    }

    public int[] getEod_quantity() {
        return eod_quantity;
    }

    public void setEod_quantity(int[] eod_quantity) {
        this.eod_quantity = eod_quantity;
    }

    public double[] getEod_cost() {
        return eod_cost;
    }

    public void setEod_cost(double[] eod_cost) {
        this.eod_cost = eod_cost;
    }

    public List<ShopCar> getScList() {
        return scList;
    }

    public void setScList(List<ShopCar> scList) {
        this.scList = scList;
    }

    public List<EasyBuyOrder> getEbodList() {
        return ebodList;
    }

    public void setEbodList(List<EasyBuyOrder> ebodList) {
        this.ebodList = ebodList;
    }
}
