package com.controller;

import com.dao.QuestionDao;
import com.entity.Question;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class QuestionAddServlet extends HttpServlet {


    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //获取参数
        String title,optionA,optionB,optionC,optionD,answer;
        title=request.getParameter("title");
        optionA=request.getParameter("optionA");
        optionB=request.getParameter("optionB");
        optionC=request.getParameter("optionC");
        optionD=request.getParameter("optionD");
        answer=request.getParameter("answer");
        //将参数添加到question对象中
        Question question=new Question(null,title,optionA,optionB,optionC,optionD,answer);
       int result= QuestionDao.questionAdd(question);
       //转到addInfo.jsp,输出更新的结果
        request.setAttribute("key",result);
        request.getRequestDispatcher("addInfo.jsp").forward(request,response);

    }
}
