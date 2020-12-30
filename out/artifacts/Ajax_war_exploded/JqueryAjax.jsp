
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
  <head>
      <script type="text/javascript" src="JS/Jquery3.5.1.js"></script>
    <title>bmi的计算(局部刷新)</title>
      <script type="text/javascript">
        $(function (){
            $("#btn").click(function (){
                var id=$("#id").val();//获取省份编号的值
                //发起请求
                $.ajax({
                    url:"queryProvince",
                    dataType:"json",
                    data:{"id":id},
                    contentType:"text/html;charset=utf-8",
                    type:"get",//这个是请求方式
                    success:function (resp){
                        //alert(resp.pname);测试
                        $("#pname").val(resp.pname);
                        $("#sname").val(resp.sname);
                        $("#capital").val(resp.capital);
                    }
                })
            })
        })
      </script>
  </head>
  <body>
  <table>
      <tr align="=right">
          <td>省份编号：</td>
          <td><input type="text" id="id"></td>
          <td><input type="button" value="搜索" id="btn"></td>
      </tr>
      <tr align="=right">
          <td>省份名称:</td>
          <td><input type="text" id="pname"></td>
      </tr>
      <tr align="=right">
          <td>省份简称：</td>
          <td><input type="text" id="sname"></td>
      </tr>
      <tr align="=right">
          <td>省会名称：</td>
          <td><input type="text" id="capital"></td>
      </tr>

  </table>
  </body>
</html>
