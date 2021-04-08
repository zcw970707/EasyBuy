package com.ymIntnet.entity;

import java.util.List;

//商品类别数据实体类
public class EasyBuyProductCategory {
    private int epcId;//类别ID
    private String epcName;//类别名称
    private int epcParentId;//父类别ID
    private List<EasyBuyProductCategory> list;
    public EasyBuyProductCategory() {
    }

    public int getEpcId() {
        return epcId;
    }

    public void setEpcId(int epcId) {
        this.epcId = epcId;
    }

    public String getEpcName() {
        return epcName;
    }

    public void setEpcName(String epcName) {
        this.epcName = epcName;
    }

    public int getEpcParentId() {
        return epcParentId;
    }

    public void setEpcParentId(int epcParentId) {
        this.epcParentId = epcParentId;
    }

    public List<EasyBuyProductCategory> getList() {
        return list;
    }

    public void setList(List<EasyBuyProductCategory> list) {
        this.list = list;
    }
}
