package cookieTest;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@WebServlet(name = "OrderServlet")
public class OrderServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Map<String,Integer> map=new HashMap();
        response.setContentType("text/html;charset=utf-8");
        PrintWriter out= response.getWriter();
        map.put("西红柿炒鸡蛋盖饭",30);
        map.put("土豆炒肉丝盖饭",20);
        map.put("鸡腿饭",25);
        String order=request.getParameter("order"),userName=null;
        Integer money=null,balance=null,xiaoFei=null;
        Cookie cookieArray[]=null,newCard=null;
        cookieArray=request.getCookies();//从第一个servleT获取cookies的方法
        for (Cookie cookie:cookieArray){
            if("userName".equals(cookie.getName())) {
                userName = cookie.getValue();
            }else if("money".equals(cookie.getName())) {
            /*    String m=cookie.getValue();
                System.out.println();*/
                money=100;Integer.valueOf(cookie.getValue());//这里老是出现格式化异常
                Integer qian=map.get(order);
                if("鸡腿饭".equals(order)){
                    if (money>=qian){
                        balance=money-qian;
                        xiaoFei=map.get(order);
                        newCard=new Cookie("money",balance+"");
                    }else {
                        out.print("用户"+userName+"余额不足，请充值");
                    }
                    //System.out.println(money>=qian?"点餐鸡腿饭成功":"点餐失败");
                } if("西红柿炒鸡蛋盖饭".equals(order)){
                    if (money>=qian){
                        balance=money-qian;
                        xiaoFei=map.get(order);
                        newCard=new Cookie("money",balance+"");
                    }else {
                        out.print("用户"+userName+"余额不足，请充值");
                    }
                    //System.out.println(money>=qian?"西红柿炒鸡蛋盖饭":"点餐失败");
                }if("土豆炒肉丝盖饭".equals(order)){
                    if (money>=qian){
                        balance=money-qian;
                        xiaoFei=map.get(order);
                        newCard=new Cookie("money",balance+"");
                    }else {
                        out.print("用户"+userName+"余额不足，请充值");
                    }
                    //System.out.println(money>=qian?"土豆炒肉丝盖饭成功":"点餐失败");
                }
                if (money>=qian){
                    balance=money-qian;
                    xiaoFei=map.get(order);
                    newCard=new Cookie("money",balance+"");
                }
            }
        }
        //少了一步，将cookie还给浏览器
        response.addCookie(newCard);
        out.print("用户："+userName+"；\n点餐"+order+"；\n消费金额："+xiaoFei+";\n余额："+balance+"。");
       /* for (Cookie cookie:cookieArray) {
            System.out.println(cookie.getName()+"----->"+cookie.getValue());
        }*/
    }
}
