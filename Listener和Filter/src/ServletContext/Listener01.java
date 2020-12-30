package ServletContext;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

public class Listener01 implements ServletContextListener{
    @Override//继承的这个接口监听是全局作用域的创建和销毁时刻
    public void contextInitialized(ServletContextEvent sce) {
        //监听全局作用域对象的创建时刻
        System.out.println("全局作用域对象被创建了！");
    }

    @Override
    public void contextDestroyed(ServletContextEvent sce) {
        //监听全局作用域被销毁的时刻
        System.out.println("全局作用域对象被销毁了");
    }
}
