package com.controller;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "CookieServlet")
public class CookieServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("第一个servlet");
        //多个浏览器之间的调用规则
        //1.重定向解决方案
        //response.sendRedirect("two");
        RequestDispatcher report = request.getRequestDispatcher("two");
        //这个使用的是请求，所以使用的是request方法调用的方法，向下一个servlet发送请求
        report.forward(request, response);
        //使用这种方法，浏览器的地址栏是不会变化的
    }
}
