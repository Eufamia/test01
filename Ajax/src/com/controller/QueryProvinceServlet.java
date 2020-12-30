package com.controller;

import com.dao.ProvinceDao;
import com.enity.Province;
import com.fasterxml.jackson.databind.ObjectMapper;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "QueryProvinceServlet")
public class QueryProvinceServlet extends HttpServlet {

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //System.out.println("接收请求");
        //获取请求对象的id
       String id=request.getParameter("id");

        Province province=new Province();
       province=ProvinceDao.queryProvinceById(id);
        //province=ProvinceDao.queryProvinceById("5");//测试使用
       // System.out.println( ProvinceDao.queryProvinceById("5"));//测试使用

        //通过jackson获取json
        ObjectMapper om=new ObjectMapper();
        String json=om.writeValueAsString(province);
        System.out.println(json);
       // response.setContentType("text/html;charset=utf-8");
        //
        //也需要修改返回数据的格式
        response.setContentType("application/json;charset=utf-8");
        PrintWriter out= response.getWriter();
      out.print(json);
    }
}
