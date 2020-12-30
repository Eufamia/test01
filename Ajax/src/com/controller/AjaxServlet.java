package com.controller;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

public class AjaxServlet extends HttpServlet {


    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
       /* 测试是否可以接收数据,System.out.println("接收了异步请求");可以接收
        */

          //接收请求参数
        String name=request.getParameter("name");
        Float height=Float.valueOf(request.getParameter("height"));
        String weight=request.getParameter("weight");
        //计算BMI
      Float bmi=Float.valueOf(weight)/(height*height);
        String info="";
        if(bmi>=18.5&&bmi<=23.9){
            info="您的身材正常";
        }else if(bmi<18.5){
            info="您的体重偏瘦";
        }else if (bmi>23.9){
            info="你的身材偏胖";
        }
        info="姓名："+name+",您的BMI值为"+bmi+"，"+info+"。";
        //用响应对象向ajax送数据
        response.setContentType("text/html;charset=utf-8;");
        PrintWriter out= response.getWriter();
        out.print(info);
        out.flush();
        out.close();

    }
}
