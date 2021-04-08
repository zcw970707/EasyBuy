package com.ymIntnet.entity;

import java.util.Date;

//用户数据实体类
public class EasyBuyUser {
    private String euUserId;//用户名
    private String euUserName;//真实姓名
    private String euPassword;//密码
    private String euSex;//性别：T-男，F-女
    private Date euBirthday;//生日
    private String euIdentityCode;//身份证
    private String euEmail;//邮箱
    private String euMobile;//手机
    private String euAddress;//地址
    private int euStatus;//状态：1-普通用户，2-管理员

    public EasyBuyUser() {
    }

    public String getEuUserId() {
        return euUserId;
    }

    public void setEuUserId(String euUserId) {
        this.euUserId = euUserId;
    }

    public String getEuUserName() {
        return euUserName;
    }

    public void setEuUserName(String euUserName) {
        this.euUserName = euUserName;
    }

    public String getEuPassword() {
        return euPassword;
    }

    public void setEuPassword(String euPassword) {
        this.euPassword = euPassword;
    }

    public String getEuSex() {
        return euSex;
    }

    public void setEuSex(String euSex) {
        this.euSex = euSex;
    }

    public Date getEuBirthday() {
        return euBirthday;
    }

    public void setEuBirthday(Date euBirthday) {
        this.euBirthday = euBirthday;
    }

    public String getEuIdentityCode() {
        return euIdentityCode;
    }

    public void setEuIdentityCode(String euIdentityCode) {
        this.euIdentityCode = euIdentityCode;
    }

    public String getEuEmail() {
        return euEmail;
    }

    public void setEuEmail(String euEmail) {
        this.euEmail = euEmail;
    }

    public String getEuMobile() {
        return euMobile;
    }

    public void setEuMobile(String euMobile) {
        this.euMobile = euMobile;
    }

    public String getEuAddress() {
        return euAddress;
    }

    public void setEuAddress(String euAddress) {
        this.euAddress = euAddress;
    }

    public int getEuStatus() {
        return euStatus;
    }

    public void setEuStatus(int euStatus) {
        this.euStatus = euStatus;
    }
}
