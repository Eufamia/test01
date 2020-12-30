package SessionTest;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.Enumeration;

@WebServlet(name = "SearchServlet")
public class SearchServlet extends HttpServlet {

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //获取私人储物柜
       HttpSession session= request.getSession();
       Enumeration<String> goodNames=session.getAttributeNames();
       /* for (String goodName:goodNames) {
            不可以用
        }*/
        //response.setContentType("text/html;charset=utf-8");
        while (goodNames.hasMoreElements()){//遍历私人储物柜
            String goodName=goodNames.nextElement();
           int goodNum=(int) session.getAttribute(goodName);
            System.out.println(goodName+"----->"+goodNum);
        }
    }
}
