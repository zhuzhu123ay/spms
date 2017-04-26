<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>职工人员管理系统-登录</title>
<link rel="stylesheet" href="bootstrap/css/bootstrap.min.css">
</head>
<link href="css/style.css" rel="stylesheet" type="text/css" />
<script language="JavaScript" src="js/jquery.js"></script>
<script src="js/cloud.js" type="text/javascript"></script>

<script language="javascript">
	$(function(){
    $('.loginbox').css({'position':'absolute','left':($(window).width()-692)/2});
	$(window).resize(function(){  
    $('.loginbox').css({'position':'absolute','left':($(window).width()-692)/2});
    })  
});  
</script>

</head>

<body
	style="background-color: #1c77ac; background-image: url(images/light.png); background-repeat: no-repeat; background-position: center top; overflow: hidden;">



	<div id="mainBody">
		<div id="cloud1" class="cloud"></div>
		<div id="cloud2" class="cloud"></div>
	</div>


	<div class="logintop">
		<span>职工人员管理系统</span>
		<ul>
			<li><a href="#">回首页</a></li>
			<li><a href="#">帮助</a></li>
			<li><a href="#">关于</a></li>
		</ul>
	</div>

	<div class="loginbody">


		<div class="loginbox">
			<form action="login" method="post" class="form-horizontal">
				<ul>
					<li><input name="username" type="text" class="loginuser"
						value="admin" /></li>
					<li><input name="password" type="password" class="loginpwd"
						value="密码" /></li>
<%-- 						<p style="color:red" ><%=request.getAttribute("msg")%></p>
 --%>	
 						<p style="color:red" >${msg}</p>
 						<li><input name="" type="submit" class="loginbtn" value="登录" />
						<label><input name="" type="checkbox" value=""
							checked="checked" />记住密码</label> <label><a href="register.jsp">没有账号？请注册</a></label></li>
							
					
				</ul>
			</form>

		</div>

	</div>



	<div class="loginbm">版权所有 2016</div>
</body>
</html>
