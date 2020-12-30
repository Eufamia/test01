package FilterTest;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import java.io.IOException;

@WebFilter(filterName = "TwoFilter")
public class TwoFilter implements Filter {
    public void destroy() {
    }

    public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain) throws ServletException, IOException {
       //可以对拦截的请求增强
        //因为post方法获取的请求参数默认是ISO设置使用post方法获取请求对象字符集为utf-8
        req.setCharacterEncoding("utf-8");
        //这种情况下，在servlet中就不用再次设置字符集了
        chain.doFilter(req, resp);
    }

    public void init(FilterConfig config) throws ServletException {

    }

}
