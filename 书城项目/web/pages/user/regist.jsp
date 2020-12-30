<!DOCTYPE html>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
<meta charset="UTF-8">
<title>尚硅谷会员注册页面</title>
	<script type="text/javascript" src="../../static/css/Jquery3.5.1.js"></script>
	<%@include file="/pages/common/header.jsp"%>
<style type="text/css">
	.login_form{
		height:420px;
		margin-top: 25px;
	}


</style>

	<script type="text/javascript">
		//判断注册信息是否合法
		// 用户名5-12个字符，必须由数字字母下划线组成*/
		var flag=false;
		function  usernameVerify(){var username=$("#username");
			var error=$("span.errorMsg");
			username.blur(function (){
				username.attr("placeholder","请输入用户名");
				var usernamePatt=/^\w{5,12}$/;
				var error=$("span.errorMsg");
				if(!usernamePatt.test(username.val())){
					error.text("用户名不合法");
				}
			})
			username.focus(function (){//当文本框聚焦，让文本框里的值为空，同时不合法的信息也会消失
				username.attr("placeholder","");
				error.text("");
			})}
		function  passwordVerify(){
			var password=$("#password");
			var error=$("span.errorMsg");
			password.blur(function (){
				password.attr("placeholder","请输入密码");
				var passwordPatt=/^\w{5,12}$/;
				var error=$("span.errorMsg");
				if(!passwordPatt.test(password.val())){

					error.text("密码只能为5-12位的数字字母下划线");
				}
			})
			password.focus(function (){//当文本框聚焦，让文本框里的值为空，同时不合法的信息也会消失
				password.attr("placeholder","");
				error.text("");
			})}

		function  repasswordVerify(){//验证密码和上面的密码是否相同
			var repassword=$("#repwd");
			var error=$("span.errorMsg");
			repassword.blur(function (){
				repassword.attr("placeholder","确认密码");
				if(repassword.val()!=$("#password").val()) {
					error.text("两次密码不一致");
				}
			})
			repassword.focus(function (){//当文本框聚焦，让文本框里的值为空，同时不合法的信息也会消失
				repassword.attr("placeholder","");
				error.text("");
			})}
		function  emailVerify(){
			var email=$("#email");
			var error=$("span.errorMsg");
			email.blur(function (){
				email.attr("placeholder","请输入邮箱地址");
				var emailPatt=/^[a-z\d]+(\.[a-z\d]+)*@([\da-z](-[\da-z])?)+(\.{1,2}[a-z]+)$/;
				var error=$("span.errorMsg");
				if(!emailPatt.test(email.val())){
					error.text("邮箱不合法");
				}
			})
			email.focus(function (){//当文本框聚焦，让文本框里的值为空，同时不合法的信息也会消失
				email.attr("placeholder","");
				error.text("");
			})}

			//页面加载的时候函数执行
		//ajax是局部刷新。这里不适合
		$(function (){
			var error=$("span.errorMsg");
			error.attr("style","font-size:10px")
			usernameVerify();
			passwordVerify();
			repasswordVerify();
			emailVerify();
			$("#sub_btn").click(function (){

			})

		})
	</script>
</head>
<body>
		<div id="login_header">
			<img class="logo_img" alt="" src="../../static/img/logo.gif" >
		</div>
		
			<div class="login_banner">
			
				<div id="l_content">
					<span class="login_word">欢迎注册</span>
				</div>
				
				<div id="content">
					<div class="login_form">
						<div class="login_box">
							<div class="tit">
								<h1>注册尚硅谷会员</h1>
								<span class="errorMsg"></span>
							</div>
							<div class="form">
								<form action="register">
									<label>用户名称：</label>
									<input class="itxt" type="text" placeholder="请输入用户名" autocomplete="off" tabindex="1" name="username" id="username" />
									<br />
									<br />
									<label>用户密码：</label>
									<input class="itxt" type="password" placeholder="请输入密码" autocomplete="off" tabindex="1" name="password" id="password" />
									<br />
									<br />
									<label>确认密码：</label>
									<input class="itxt" type="password" placeholder="确认密码" autocomplete="off" tabindex="1"  id="repwd" />
									<br />
									<br />
									<label>电子邮件：</label>
									<input class="itxt" type="text" placeholder="请输入邮箱地址" autocomplete="off" tabindex="1" name="email" id="email" />
									<br />
									<br />
									<label>验证码：</label>
									<input class="itxt" type="text" style="width: 150px;" id="code"/>
									<img alt="" src="../../static/img/code.bmp" style="float: right; margin-right: 40px">
									<br />
									<br />
									<input type="submit" value="注册" id="sub_btn" />
									
								</form>
							</div>
							
						</div>
					</div>
				</div>
			</div>
		<%@include file="/pages/common/footer.jsp"%>
</body>
</html>