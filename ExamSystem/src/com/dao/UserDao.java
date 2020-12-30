package com.dao;

import com.entity.Users;
import com.util.DBUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class UserDao {
    public static int add(Users user){
        Connection conn=null;
        PreparedStatement state=null;
        int result=0;
        String sql="insert into t_user (userName,userPswd,sex,email) values(?,?,?,?)";
        try {//获取连接
            conn= DBUtil.getConnection();
            state= conn.prepareCall(sql);
            state.setString(1,user.getUserName());
            state.setString(2,user.getUserPswd());
            state.setString(3,user.getSex());
            state.setString(4,user.getEmail());
            result=state.executeUpdate();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }finally {
            DBUtil.close(null,state,conn);
        }
        return result;
    }
    public static List searchAll(){
        //获取数据库的用户信息
        List list=new ArrayList();
        String sql="select * from t_user";
        Connection con=null;
        PreparedStatement state=null;
        ResultSet resultSet=null;
        try {
            con=DBUtil.getConnection();
            state=con.prepareCall(sql);
            resultSet= state.executeQuery();
            while (resultSet.next()){
                Integer id=resultSet.getInt("id");
                String userName=resultSet.getString("userName");
                String password=resultSet.getString("userPswd");
                String sex=resultSet.getString("sex");
                String email=resultSet.getString("email");
                Users user=new Users(id,userName,password,sex,email);
                list.add(user);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            DBUtil.close(resultSet,state,con);
        }
    return list;
    }

    public static int deleteById(String id){
        Connection con=null;
        PreparedStatement state=null;
        String sql="delete from t_user where id=?";
        int result=0;
        try {
            con=DBUtil.getConnection();
            state=con.prepareCall(sql);
            state.setInt(1,Integer.valueOf(id));
            result=state.executeUpdate();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return result;
    }
    public static Users searchById(String id){
        String sql="select * from t_user where id=?";
        Connection con=null;
        PreparedStatement state=null;
        ResultSet resultSet=null;
        Users user=null;
        try {
            con=DBUtil.getConnection();
            state=con.prepareCall(sql);
            state.setInt(1,Integer.valueOf(id));
            resultSet= state.executeQuery();
            while (resultSet.next()) {
                String userName=resultSet.getString("userName");
                String password = resultSet.getString("userPswd");
                String sex = resultSet.getString("sex");
                String email = resultSet.getString("email");
                user = new Users(Integer.valueOf(id), userName, password, sex, email);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            DBUtil.close(resultSet,state,con);
        }
        return user;
    }
    public static Integer updateById(Users user){
        Connection con=null;
        PreparedStatement state=null;
        Integer result=null;
        String sql="update t_user set userName=?,userPswd=?,sex=?,email=? where id=?";
        try {
            con=DBUtil.getConnection();
            state= con.prepareCall(sql);
            state.setInt(5,user.getId());
            state.setString(1, user.getUserName());
            state.setString(2,user.getUserPswd());
            state.setString(3, user.getSex());
            state.setString(4, user.getEmail());
            result= state.executeUpdate();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return result ;
    }
    public static int login(String userName,String password){
        String sql="select count(*) from t_user where userName=? and userPswd=?";
        Connection con=null;
        PreparedStatement state=null;
        ResultSet resultSet=null;
        int result=0;
        try {
            con=DBUtil.getConnection();
            state=con.prepareCall(sql);
            state.setString(1,userName);
            state.setString(2,password);
            resultSet= state.executeQuery();
            while (resultSet.next()) {
               result=resultSet.getInt("count(*)");

            }
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            DBUtil.close(resultSet,state,con);
        }
        return result;
    }
}
