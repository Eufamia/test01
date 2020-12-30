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


@WebServlet(name = "UpdateServlet")
public class UpdateServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {


        response.setContentType("text/html;charset=utf-8");
        //首先获取id
        String id=request.getParameter("userId");

        //out.print(id);
        Users user=new Users();
        user=UserDao.searchById(id);
        //通过输出流将得到的用户信息写到浏览器中
        PrintWriter out= response.getWriter();
        out.print("<form action='update1' method='get'>" +
                "    <table align='center' border='1' width='50%'>" +
                "        <tr>" +
                "            <td align='right'>用户编号:</td>" +
                "            <td><input type='text' name='userId' value="+user.getId()+"></td>" +
                "        </tr>" +
                "        <tr>" +
                "            <td align='right'>用户姓名:</td>" +
                "            <td><input type='text' name='userName' value="+user.getUserName()+"></td>" +
                "        </tr>" +
                "        <tr>" +
                "            <td align='right'>用户密码:</td>" +
                "            <td><input type='password' name='password' value="+user.getUserPswd()+"></td>" +
                "        </tr>" +
                "        <tr>" +
                "            <td align='right'>用户性别:</td>" +
                "            <td><input type='text' name='sex' value="+user.getSex()+">" +
                "        </tr>" +
                "        <tr>" +
                "            <td align='right'>用户邮箱:</td>" +
                "            <td><input type='text' name='email' value="+user.getEmail()+"></td>" +
                "        </tr>" +
                "        </tr>" +
                "        <tr align='center'>" +
                "            <td colspan='2'><input type='submit' value='修改'>" +
                "                <input type='reset' value='重置'></td>" +
                "        </tr>" +
                "    </table>");

        //update信息userName: jary
        //password: 123
        //sex: 男
        //email: mike@163.com


    }
}
