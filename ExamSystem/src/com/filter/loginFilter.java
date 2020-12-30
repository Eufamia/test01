package com.filter;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebFilter(filterName = "loginFilter")
public class loginFilter implements Filter {
    public void destroy() {
    }

    public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain) throws ServletException, IOException {
       HttpSession session=null;
        //获取URI
        HttpServletRequest request=(HttpServletRequest)req;
        String uri= request.getRequestURI();
        //如果本次请求和login相关，直接转到登录页面
        if(uri.contains("login")||"/ExamSystem/".equals(uri)){//这种判断可以避免空指针，因为如果uri为空，又放在前面的话就会有空指针
            chain.doFilter(req, resp);
            return;
        }
        //如果访问的是其他文件

        session=request.getSession(false);
        if(session!=null){
            chain.doFilter(req, resp);
            return;
        }
        request.getRequestDispatcher("loginError.html").forward(req,resp);
//有问题，经过debug测试，为默认页面时走的路径是对的，但是仍然是跳转到了loginError.html
       // 跳转到login,html是没问问题的
    }

    public void init(FilterConfig config) throws ServletException {

    }

}
