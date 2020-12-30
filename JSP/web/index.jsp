<%--
  Created by IntelliJ IDEA.
  User: zhangjingwei
  Date: 2020/11/20
  Time: 10:27
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
获取全局作用域对象的值： ${applicationScope.key}
获取session对象的值：${sessionScope.key}
<%--获取session对象的值：${sessionScope.11111}这个key不能为数字--%>
获取request的值：${requestScope.key}
