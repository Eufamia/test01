
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
  <head>
    <title>级联查询省市</title>
    <script type="text/javascript" src="JS/Jquery3.5.1.js"></script>
    <script type="text/javascript">
        //显示所有省的函数
        function proAjax(){
            $("#province").empty();
            $("#province").append("<option value=\"default\" >——请选择——</option>");
            $.ajax({
                url:"queryProvince",
                dataType:"json",
                success:function (resp){
                    //alert(resp);测试数据是否可以传过来
                    $.each(resp,function (index,element){
                        $("#province").append("<option value='"+element.id+"' >"+element.pname+"</option>");
                    })
                }
            })
        }
      $(function (){
        proAjax();
          //alert($("#province>:selected").val());
          $("#province").change(function (){
              //alert("hello");可以正确捕捉
              $("#city").empty();
              $("#city").append("<option value=\"default\" >——请选择——</option>");
              var pid= $("#province>:selected").val();
              $.get("queryCity",{pid:pid},cityAjax,"json")
          })
        })
    function cityAjax(resp){
            $.each(resp,function (index,element){
                $("#city").append("<option value='"+element.id+"'>"+element.name+"</option>")
            })
    }
    </script>
  </head>
  <body><center>
 <select id="province">
   <option value="default" >——请选择——</option>
 </select>
      <button id="btn"> 按钮</button>
  <select id="city">
    <option value="default" >——请选择——</option>
  </select>
  </center>
  </body>
</html>
