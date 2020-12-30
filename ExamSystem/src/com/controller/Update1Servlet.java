package com.controller;

import com.dao.UserDao;
import com.entity.Users;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "Update1Servlet")
public class Update1Servlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Users user=new Users();
        response.setContentType("text/html;charset=utf-8");//字符集得问题
        user.setId(Integer.valueOf(request.getParameter("userId")));
        user.setUserName(request.getParameter("userName"));
        user.setUserPswd(request.getParameter("password"));
        user.setSex(request.getParameter("sex"));
        user.setEmail(request.getParameter("email"));
        System.out.println(user.getEmail());
       Integer result= UserDao.updateById(user);
        PrintWriter out=response.getWriter();
        out.print(result==1?"更新成功":"更新失败");
    }
}
