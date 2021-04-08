package com.ymIntnet.dao;

import java.sql.*;

public class BaseDao {
    private String driver="com.mysql.jdbc.Driver";//驱动字符串
    private String url="jdbc:mysql://localhost:3306/master";//连接字符串
    private String user="root";
    private String password="123456";

    protected Connection con=null;//连接对象
    protected PreparedStatement ps=null;//预编译对象
    protected ResultSet rs=null;


    //获取连接：
    public Connection getConnection(){

        try{
            if(con==null || con.isClosed()){
                Class.forName(driver);//加载驱动
                con= DriverManager.getConnection(url,user,password);

            }
        }catch(SQLException e){
            e.printStackTrace();
        }catch(ClassNotFoundException e){
            e.printStackTrace();
        }

        return con;
    }

    //关闭：
    public void closeAll(Connection con,PreparedStatement ps,ResultSet rs){

        try{
            if(rs!=null){
                rs.close();
            }
            if(ps!=null){
                ps.close();
            }
            if(con!=null){
                con.close();
            }

        }catch(SQLException e){
            e.printStackTrace();
        }

    }


    //通用增删改：
    public int update(String sql,Object[] param){

        int num=-1;//默认失败
        try{
            con=getConnection();
            ps=con.prepareStatement(sql);//预编译
            if(param!=null){
                //给问号赋值：
                for(int i=0;i<param.length;i++){
                    ps.setObject(i+1, param[i]);
                }
            }

            num=ps.executeUpdate();
        }catch(SQLException e){
            e.printStackTrace();
        }finally{
            closeAll(con, ps, rs);
        }

        return num;
    }

    //通用查询：
    public ResultSet query(String sql,Object[] obj){

        try{
            con=getConnection();
            ps=con.prepareStatement(sql);
            if(obj!=null){
                for(int i=0;i<obj.length;i++){
                    ps.setObject(i+1, obj[i]);
                }
            }
            rs=ps.executeQuery();
        }catch(SQLException e){
            e.printStackTrace();
        }

        return rs;

    }
}
