package com.controller;

import com.dao.UserDao;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "UserDeleteServlet")
public class UserDeleteServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //首先获取浏览器传回来的参数
        response.setContentType("text/html;charset=utf-8");
       String id= request.getParameter("userId");
       Integer result= UserDao.deleteById(id);
       PrintWriter out=response.getWriter();
       out.print("<font size=40px color=red>"+(result==1?"删除成功":"删除失败")+"</font>");
    }
}
