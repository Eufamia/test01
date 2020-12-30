package ServletContext;

import javax.servlet.ServletContextAttributeEvent;
import javax.servlet.ServletContextAttributeListener;

public class ServletContextAttributeListenerTest implements ServletContextAttributeListener {
    @Override
    public void attributeAdded(ServletContextAttributeEvent sce) {
        //这个是全局作用域对象添加数据的方法
    }

    @Override
    public void attributeRemoved(ServletContextAttributeEvent sce) {
       // 这个是监听全局作用域对象删除数据的方法
    }

    @Override
    public void attributeReplaced(ServletContextAttributeEvent sce) {
        //这个是监听全局作用域更新数据的方法
       // 这三个方法的测试是需要加断点来测试的
    }
}
