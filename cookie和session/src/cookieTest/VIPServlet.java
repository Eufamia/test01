package cookieTest;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "VIPServlet")
public class VIPServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String userName,money;
        //获取请求参数
       userName =request.getParameter("userName");
       money=request.getParameter("money");
       //注册
        Cookie cookie=new Cookie("userName",userName);
        Cookie cookie1=new Cookie("money",money);
        //3.将cookie信息交给浏览器
        response.addCookie(cookie);
        response.addCookie(cookie1);
        //cookie1.setMaxAge(60);//这是代表在硬盘中存活一分钟
        //通知浏览器将点餐页面打开
        request.getRequestDispatcher("/menu.html").forward(request,response);//这是请求转发
        //有一个需要注意的点，因为cookie是在浏览器消亡时被销毁，所以在一次打开浏览器时，即使输入不同的人名，因为money只有一个，所以仍然使用同一个money
        //Cookie cookie=new Cookie(String,String);里面只能存储String类型的数据
        //如果将cookie传递给浏览器,收到请求之后，使用response做出响应
        //response.addCookie(cookie);
        //下一个servlet如何读取上一个的cookie,声明一个Cookie数组，从请求头当中获取cookie
        //Cookie cookies[]=request.getCookies();
        //通过getName()和getValue获取key和value
/**
 * 关于cookie，我的电脑会出现一些问题，无法把cookie添加到响应头，但是有的时候又是可以的，这这个我也是很迷惑，暂无解
 * 使用谷歌是不行，使用火狐又是可以的*/
    }
}
