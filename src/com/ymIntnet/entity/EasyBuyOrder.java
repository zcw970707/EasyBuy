package com.ymIntnet.entity;

import java.util.Date;
import java.util.List;

//订单实体类
public class EasyBuyOrder {
    private String eo_id;//订单id
    private String eo_user_id;//用户id
    private String eo_user_name;//用户真实姓名
    private Date eo_create_time;//订单创建时间
    private String eo_user_address;//用户地址
    private double eo_cost;//总金额
    private int eo_status;//订单状态
    private int eo_type;//支付类型
    public EasyBuyOrder() {
    }

    public String getEo_id() {
        return eo_id;
    }

    public void setEo_id(String eo_id) {
        this.eo_id = eo_id;
    }

    public String getEo_user_id() {
        return eo_user_id;
    }

    public void setEo_user_id(String eo_user_id) {
        this.eo_user_id = eo_user_id;
    }

    public String getEo_user_name() {
        return eo_user_name;
    }

    public void setEo_user_name(String eo_user_name) {
        this.eo_user_name = eo_user_name;
    }

    public Date getEo_create_time() {
        return eo_create_time;
    }

    public void setEo_create_time(Date eo_create_time) {
        this.eo_create_time = eo_create_time;
    }

    public String getEo_user_address() {
        return eo_user_address;
    }

    public void setEo_user_address(String eo_user_address) {
        this.eo_user_address = eo_user_address;
    }

    public double getEo_cost() {
        return eo_cost;
    }

    public void setEo_cost(double eo_cost) {
        this.eo_cost = eo_cost;
    }

    public int getEo_status() {
        return eo_status;
    }

    public void setEo_status(int eo_status) {
        this.eo_status = eo_status;
    }

    public int getEo_type() {
        return eo_type;
    }

    public void setEo_type(int eo_type) {
        this.eo_type = eo_type;
    }

}

