<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
//http://localhost:8888/sms_web
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<base href="<%=basePath %>">
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>职工信息管理系统-修改产品</title>
<link rel="stylesheet" href="bootstrap/css/bootstrap.min.css">

</head>
<body>
	<nav class="navbar navbar-inverse">
	<div class="container-fluid">
		<div class="navbar-header">
			<a class="navbar-brand" href="#"> 职工信息管理系统 </a>
		</div>
	</div>
	</nav>
	<div class="container">
		<div class="row">
			<c:if test="${empty staff }">
				<a href="login.jsp">登录</a>|
				<a href="register.jsp">没有账号？注册</a>
			</c:if>
			<c:if test="${!empty staff }">
				<Strong>欢迎您：</strong>
				<em>${staff.username }</em>
				<a href="logout" class="pull-right">退出</a>
			</c:if>
		</div>
		<!-- 信息提示 -->
		<c:if test="${!empty msg }">
			<div class="alert alert-danger" role="alert">
				<span class="glyphicon glyphicon-exclamation-sign"
					aria-hidden="true"></span> ${msg }
			</div>
		</c:if>
		<div class="row">
			<form action="updateProduct" method="post" class="form-horizontal">
				<input type="hidden" class="form-control" name="productId" value="${product.productId }">
				 <div class="form-group">
					<label class="col-sm-2 control-label">产品生产日期</label>
					<div class="col-sm-6">
						<input type="text" class="form-control" name="productDate" value="${product.productDate }">
					</div>
				</div> 
				<div class="form-group">
					<label class="col-sm-2 control-label">产品名称</label>
					<div class="col-sm-6">
						<input type="text" class="form-control" name="productName" value="${product.productName }">
					</div>
				</div>
				<div class="form-group">
					<label class="col-sm-2 control-label">产品价格</label>
					<div class="col-sm-6">
						<input class="form-control" name="productPrice" value="${product.productPrice}">
					</div>
				</div>
				<div class="form-group">
					<label class="col-sm-2 control-label">产品用途</label>
					<div class="col-sm-6">
						<textarea class="form-control" name="productUse">${product.productUse }</textarea>
					</div>
				</div>
				<div class="form-group">
					<div class="col-sm-12 text-center">
						<input type="submit" value="保存" class="btn btn-default">
						<a class="btn btn-default" href="toIndex">取消</a>
					</div>
				</div>
			</form>
		</div>


	</div>



</body>
</html>