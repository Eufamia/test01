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
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

//@WebServlet(name = "SearchServlet")
public class SearchServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
       //获取用户信息
        List<Users> list=new ArrayList();
        list= UserDao.searchAll();
        //调用响应体来输出用户信息
        response.setContentType("text/html;charset=utf-8");
        PrintWriter out=response.getWriter();
        out.print("<table align='center' border='1'>" );
        out.print("<tr>" );
        out.print("<th>用户编号</th>");
        out.print("<th>用户姓名</th>");
        out.print("<th>用户密码</th>");
        out.print("<th>用户性别</th>");
        out.print("<th>用户邮箱</th>");
        out.print("<th>操作</th>" );
        out.print("</tr>");
        for(Users user:list){
            out.print("<tr>");
            out.print("<td>"+user.getId()+"</td>");
            out.print("<td>"+user.getUserName()+"</td>");
            out.print("<td>*******</td>");
            out.print("<td>"+user.getSex()+"</td>");
            out.print("<td>"+user.getEmail()+"</td>");
            out.print("<td><a href='delete?userId="+user.getId()+"'>删除信息</a></td>");
            out.print("<td><a href='update?userId="+user.getId());
            out.print("'>更新信息</a></td>");
            out.print("</tr>");
        }
          out.print("</table>");


    }
}
