package SessionTest;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

public class Servlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
            //调用请求头对象获取参数
        String goodName=request.getParameter("goodsName");
        //调用请求对象，获取session，也就是用户在服务端的私人储物柜
        HttpSession session=request.getSession();//这种方式，如果用户在当前客户端已有Session就获取，没有就建
        //还有一个getSession(false);这个方式如果有就获取返回，如果没有 返回null
        //将用户选购商品添加到私人储物柜
        Integer goodNum=(Integer)session.getAttribute(goodName);
        if(goodNum==null){
            session.setAttribute(goodName,1);
        }else
        session.setAttribute(goodName,goodNum+1);
    }
}
