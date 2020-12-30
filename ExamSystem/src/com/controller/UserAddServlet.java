package com.controller;

import com.dao.UserDao;
import com.entity.Users;
import com.util.DBUtil;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

@WebServlet(name = "UserAddServlet")
public class UserAddServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
       response.setContentType("text/html;charset=utf-8");
        //读取用户信息
        //userName: mike
        //password: 1234
        //sex: 男
        //email: mike@163.com
        //通过请求头获取用户信息
        String userName, password, sex, email;
        userName=request.getParameter("userName");
        password=request.getParameter("password");
        sex=request.getParameter("sex");
        email=request.getParameter("email");

        //调用USerDao类将用户信息传到JDBC的insert命令中
        Users user=new Users(null,userName, password, sex, email);
        int result=UserDao.add(user);
        String res=(result==1?"用户注册成功！":"用户注册失败！");
        PrintWriter out= response.getWriter();
        out.print("<font size=\"40\" color=\"red\">"+res+"</font>");
    }
}
