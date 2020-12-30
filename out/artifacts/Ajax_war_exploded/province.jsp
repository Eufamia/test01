
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>省份查询</title>
    <script type="text/javascript">
        function search(){
            //创建异步对象
            var xml=new XMLHttpRequest();
            //绑定事件
            xml.onreadystatechange = function (){
                //对服务端获取的数据进行操作
                var data;
                var jsonObj;
                if(xml.readyState==4&&xml.status==200) {
                   data = xml.responseText;
                  jsonObj=eval("("+data+")");
                   //var array=data.split("&");可以使用符号来做标记，但是这样的代码会比json麻烦
                }
              // alert( xml.responseText);
                /*document.getElementById("pname").value=array[0];
                document.getElementById("capital").value=array[1];*/
                document.getElementById("pname").value=jsonObj.pname;
               document.getElementById("capital").value=jsonObj.capital;
               document.getElementById("sname").value=jsonObj.sname;
            }
            //初始化请求
            var id=document.getElementById("id").value;
            xml.open("get","queryProvince?id="+id,true);
            //发送请求
            xml.send();
        }
    </script>
</head>
<body>
<table>
    <tr align="=right">
        <td>省份编号：</td>
        <td><input type="text" id="id"></td>
        <td><input type="button" value="搜索" onclick="search()"></td>
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
