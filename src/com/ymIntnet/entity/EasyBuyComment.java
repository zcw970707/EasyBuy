package com.ymIntnet.entity;

import java.util.Date;

//留言实体类
public class EasyBuyComment {
    private int ecId;//留言ID
    private String ecContent;//内容
    private Date ecCreateTime;//发表日期
    private String ecReply;//回复内容
    private Date ecReplyTime;//回复时间
    private String ecNickName;//留言用户昵称

    public EasyBuyComment() {
    }

    public int getEcId() {
        return ecId;
    }

    public void setEcId(int ecId) {
        this.ecId = ecId;
    }

    public String getEcContent() {
        return ecContent;
    }

    public void setEcContent(String ecContent) {
        this.ecContent = ecContent;
    }

    public Date getEcCreateTime() {
        return ecCreateTime;
    }

    public void setEcCreateTime(Date ecCreateTime) {
        this.ecCreateTime = ecCreateTime;
    }

    public String getEcReply() {
        return ecReply;
    }

    public void setEcReply(String ecReply) {
        this.ecReply = ecReply;
    }

    public Date getEcReplyTime() {
        return ecReplyTime;
    }

    public void setEcReplyTime(Date ecReplyTime) {
        this.ecReplyTime = ecReplyTime;
    }

    public String getEcNickName() {
        return ecNickName;
    }

    public void setEcNickName(String ecNickName) {
        this.ecNickName = ecNickName;
    }
}
