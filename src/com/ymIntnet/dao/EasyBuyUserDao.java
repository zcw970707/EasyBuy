package com.ymIntnet.dao;

import com.ymIntnet.entity.EasyBuyUser;

import java.util.List;

public interface EasyBuyUserDao {
    public List<EasyBuyUser> userFind();//查询所有
    public List<EasyBuyUser> loginFind(String name,String password);//登录验证
    public int userRegister(EasyBuyUser ebu);//注册
    public int userModify(EasyBuyUser ebu);//修改
    public int userDelete(EasyBuyUser ebu);//删除
}
