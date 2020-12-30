<%--
  Created by IntelliJ IDEA.
  User: zhangjingwei
  Date: 2020/11/21
  Time: 19:11
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
  <head>
    <title>bmi的计算(局部刷新)</title>
      <script type="text/javascript">
        function doAjax(){
            //创建异步对象
            var obj=new XMLHttpRequest();
            //绑定事件
            obj.onreadystatechange=function (){
                //处理服务器端返回的数据
                //获取dom的值

                //alert(obj.readyState+"nihao"+obj.status);//这两个是异步对象的状态值和浏览器接收的状态码
                /*if(obj.readyState==4 && obj.status==200){
                    alert(obj.responseText);
                }*/

               var data=obj.responseText;
               document.getElementById("BMI").innerText=data;
                }//测试使用，是否可以正确接收信息

            //获取dom的值,不能写在onreadystatechange里面
            var name=document.getElementById("name").value;
            var weight=document.getElementById("weight").value;
            var height=document.getElementById("height").value;
            var info="name="+name+"&weight="+weight+"&height="+height;

            //初始请求
            obj.open("get","bmiAjax?"+info,true);
            //发送请求
            obj.send();
        }

      </script>
  </head>
  <body>
  <div>
      姓名：<input type="text" id="name"><br>
      身高：<input type="text" id="height"><br>
      体重：<input type="text" id="weight"><br>
      <input type="button" value="bmi的计算" onclick="doAjax()">
  </div>
   <br>
   <br>
    <div id="BMI">等待数据显示...</div>
  </body>
</html>
