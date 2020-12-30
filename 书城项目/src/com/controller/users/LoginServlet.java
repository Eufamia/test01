package com.controller.users;

import com.dao.UserDao;
import com.enity.User;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class LoginServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String username=  request.getParameter("username");
        String passwords=  request.getParameter("passwords");
        //System.out.println("hello");
        User user=new User(null,username,passwords,null);
        UserDao dao=new UserDao();
        Integer result=dao.login(user);
        if(result==null){
            request.getRequestDispatcher("login.jsp").forward(request,response);
            request.setAttribute("msg","用户名不存在或者密码错误！");
        }else {
            request.getRequestDispatcher("login_success.jsp").forward(request,response);
        }
    }


}
