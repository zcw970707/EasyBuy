package com.ymIntnet.entity;

import java.util.Date;

//新闻实体类
public class EasyBuyNews {
    private int enId;//新闻ID
    private String enTitle;//标题
    private String enContent;//内容
    private Date enCreateTime;//日期

    public EasyBuyNews() {
    }

    public int getEnId() {
        return enId;
    }

    public void setEnId(int enId) {
        this.enId = enId;
    }

    public String getEnTitle() {
        return enTitle;
    }

    public void setEnTitle(String enTitle) {
        this.enTitle = enTitle;
    }

    public String getEnContent() {
        return enContent;
    }

    public void setEnContent(String enContent) {
        this.enContent = enContent;
    }

    public Date getEnCreateTime() {
        return enCreateTime;
    }

    public void setEnCreateTime(Date enCreateTime) {
        this.enCreateTime = enCreateTime;
    }
}
