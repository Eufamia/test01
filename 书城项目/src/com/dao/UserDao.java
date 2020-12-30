package com.dao;

import com.enity.User;
import com.util.DBUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class UserDao {
    public UserDao(){

    }
    public Integer insert(User user){
        Connection con=null;
        PreparedStatement state=null;
        int result=0;
        String sql="insert into user (username,passwords,email)values (?,?,?)";
        try {
            con= DBUtil.getConnection();
            state=con.prepareCall(sql);
            state.setString(1,user.getUsername());
            state.setString(2, user.getPasswords());
            state.setString(3, user.getEmail());
            result=state.executeUpdate();

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }finally {
            DBUtil.close(null,state,con);
        }
        return result;
    }
    public Integer login(User user){
        Connection con=null;
        PreparedStatement state=null;
       ResultSet results=null;
        String sql="select id,username,passwords from user where username=? and passwords=?";
        try {
            con= DBUtil.getConnection();
            state=con.prepareCall(sql);
            state.setString(1,user.getUsername());
            state.setString(2, user.getPasswords());
            results=state.executeQuery();
            while (results.next()){
                user.setId(results.getInt("id"));
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }finally {
            DBUtil.close(results,state,con);
        }
     return user.getId();
    }
}
