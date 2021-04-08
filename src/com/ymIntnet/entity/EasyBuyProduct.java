package com.ymIntnet.entity;
//商品数据实体类
public class EasyBuyProduct {
    private int epId;//商品ID
    private String epNam;//商品名称
    private String epDescription;//商品描述
    private int epPrice;//价格
    private int epStock;//库存
    private EasyBuyProductCategory epcId;//类别ID,外键
    private int epcChildId;//二级分类ID
    private String epFileName;//上传文件路径

    public EasyBuyProduct() {
    }

    public int getEpId() {
        return epId;
    }

    public void setEpId(int epId) {
        this.epId = epId;
    }

    public String getEpNam() {
        return epNam;
    }

    public void setEpNam(String epNam) {
        this.epNam = epNam;
    }

    public String getEpDescription() {
        return epDescription;
    }

    public void setEpDescription(String epDescription) {
        this.epDescription = epDescription;
    }

    public int getEpPrice() {
        return epPrice;
    }

    public void setEpPrice(int epPrice) {
        this.epPrice = epPrice;
    }

    public int getEpStock() {
        return epStock;
    }

    public void setEpStock(int epStock) {
        this.epStock = epStock;
    }

    public EasyBuyProductCategory getEpcId() {
        return epcId;
    }

    public void setEpcId(EasyBuyProductCategory epcId) {
        this.epcId = epcId;
    }

    public int getEpcChildId() {
        return epcChildId;
    }

    public void setEpcChildId(int epcChildId) {
        this.epcChildId = epcChildId;
    }

    public String getEpFileName() {
        return epFileName;
    }

    public void setEpFileName(String epFileName) {
        this.epFileName = epFileName;
    }
}
