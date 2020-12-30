package com.util;


import java.sql.*;

public class DBUtil {
    static {
        try {//注册驱动
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
    public static Connection getConnection() throws SQLException {
//获取连接jdbc:mysql://localhost:3306/bjpowernode?serverTimezone=GMT
        return DriverManager.getConnection("jdbc:mysql://localhost:3306/bjpowernode?serverTimezone=GMT",
                "root","123456");
    }
    public static void close(ResultSet resultSet, Statement statement,Connection connection){
        if(resultSet!=null){
            try {
                resultSet.close();
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        }
        if(statement!=null){
            try {
                statement.close();
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        }
        if(connection!=null){
            try {
                connection.close();
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        }
    }
}
