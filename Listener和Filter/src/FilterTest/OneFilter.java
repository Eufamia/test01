package FilterTest;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import java.io.IOException;
import java.io.PrintWriter;

//@WebFilter(filterName = "OneFilter")
public class OneFilter implements Filter {
    public void destroy() {
    }

    public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain) throws ServletException, IOException {
       String age=req.getParameter("age");


        if(Integer.valueOf(age)<70)
        {
            chain.doFilter(req, resp);//图片为什么无法现实出现？这句话无法放行
            //可以显示，但是是乱码

        }else {
            resp.setContentType("text/html;charset=utf-8");//这句话如果不写在分支里，会造成上面显示数据为图片的乱码
            PrintWriter out= resp.getWriter();//这个要写在else里面。因为如果写在外面会有IllegalStateException出现
            out.print("拒绝访问");
        }
    }
}
