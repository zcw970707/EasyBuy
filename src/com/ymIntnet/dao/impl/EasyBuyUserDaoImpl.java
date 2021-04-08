package com.ymIntnet.dao.impl;

import com.ymIntnet.dao.BaseDao;
import com.ymIntnet.dao.EasyBuyUserDao;
import com.ymIntnet.entity.EasyBuyUser;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class EasyBuyUserDaoImpl extends BaseDao implements EasyBuyUserDao {
    @Override
    public List<EasyBuyUser> userFind() {
        String sql = "select *from easybuy_user";
        List<EasyBuyUser> ebuList = new ArrayList<>();
        rs=query(sql,null);
        try {
            while (rs.next()){
                EasyBuyUser ebu = new EasyBuyUser();
                ebu.setEuUserId(rs.getString("EU_USER_ID"));
                ebu.setEuUserName(rs.getString("EU_USER_NAME"));
                ebu.setEuPassword(rs.getString("EU_PASSWORD"));
                ebu.setEuSex(rs.getString("EU_SEX"));
                ebu.setEuBirthday(rs.getDate("EU_BIRTHDAY"));
                ebu.setEuIdentityCode(rs.getString("EU_IDENTITY_CODE"));
                ebu.setEuEmail(rs.getString("EU_EMAIL"));
                ebu.setEuMobile(rs.getString("EU_MOBILE"));
                ebu.setEuAddress(rs.getString("EU_MOBILE"));
                ebu.setEuStatus(rs.getInt("EU_STATUS"));
                ebuList.add(ebu);
            }
        }catch (SQLException e){
            e.printStackTrace();
        }finally {
            closeAll(con,ps,rs);
        }
        return ebuList;
    }

    @Override
    public List<EasyBuyUser> loginFind(String name, String password) {
        String sql = "select *from easybuy_user where EU_USER_NAME='"+name+"' and EU_PASSWORD='"+password+"'";
        List<EasyBuyUser> ebuList = new ArrayList<>();
        rs=query(sql,null);
        try {
            while (rs.next()){
                EasyBuyUser ebu = new EasyBuyUser();
                ebu.setEuUserId(rs.getString("EU_USER_ID"));
                ebu.setEuUserName(rs.getString("EU_USER_NAME"));
                ebu.setEuPassword(rs.getString("EU_PASSWORD"));
                ebu.setEuSex(rs.getString("EU_SEX"));
                ebu.setEuBirthday(rs.getDate("EU_BIRTHDAY"));
                ebu.setEuIdentityCode(rs.getString("EU_IDENTITY_CODE"));
                ebu.setEuEmail(rs.getString("EU_EMAIL"));
                ebu.setEuMobile(rs.getString("EU_MOBILE"));
                ebu.setEuAddress(rs.getString("EU_MOBILE"));
                ebu.setEuStatus(rs.getInt("EU_STATUS"));
                ebuList.add(ebu);
            }
        }catch (SQLException e){
            e.printStackTrace();
        }finally {
            closeAll(con,ps,rs);
        }
        return ebuList;
    }

    @Override
    public int userRegister(EasyBuyUser ebu) {
        String sql = "insert into easybuy_user values(?,?,?,?,?,?,?,?,?,?)";
        Object[]obj = {
                ebu.getEuUserId(),ebu.getEuUserName(),ebu.getEuPassword(),ebu.getEuSex(),ebu.getEuBirthday(),
                ebu.getEuIdentityCode(),ebu.getEuEmail(),ebu.getEuMobile(),ebu.getEuAddress(),ebu.getEuStatus()
        };
        return update(sql,obj);
    }

    @Override
    public int userModify(EasyBuyUser ebu) {
        String sql="update easybuy_user set EU_USER_NAME=?,EU_PASSWORD=?,EU_SEX=?,EU_BIRTHDAY=?,EU_MOBILE=?,EU_ADDRESS=?,EU_IDENTITY_CODE=?,EU_EMAIL=? where EU_USER_ID=?";
        System.out.println(ebu.getEuUserId()+"有吗");
        Object[]obj={ebu.getEuUserName(),ebu.getEuPassword(),ebu.getEuSex(),ebu.getEuBirthday(),
                     ebu.getEuMobile(),ebu.getEuAddress(),ebu.getEuIdentityCode(),ebu.getEuEmail(),ebu.getEuUserId()
                    };
        return update(sql,obj);
    }

    @Override
    public int userDelete(EasyBuyUser ebu) {
        String sql = "delete from easybuy_user where EU_USER_ID=?";
        Object[]obj = {ebu.getEuUserId()};
        return update(sql,obj);
    }
}
