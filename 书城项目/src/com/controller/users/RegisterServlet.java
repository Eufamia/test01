package com.controller.users;

import com.dao.UserDao;
import com.enity.User;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "RegisterServlet")
public class RegisterServlet extends HttpServlet {

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
       UserDao dao=new UserDao();
       String username=request.getParameter("username");
       String passwords=request.getParameter("passwords");
       String email=request.getParameter("email");
       // System.out.println(username+"---"+passwords+"----"+email);测试接收的数据是否正常
        User user=new User(null,username,passwords,email);
        int result=dao.insert(user);
        //如果注册成功就跳转到成功页面，如果失败返回注册页面
        if (result==1){
            request.getRequestDispatcher("regist_success.jsp").forward(request,response);
        }else {
            request.getRequestDispatcher("regist.jsp").forward(request, response);
        }

    }
}
