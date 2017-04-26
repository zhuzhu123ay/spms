<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<base href="<%=basePath %>">
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>职工信息管理系统-产品</title>
<link rel="stylesheet" href="bootstrap/css/bootstrap.min.css">

</head>
<body>
	<!-- <nav class="navbar navbar-inverse">
		<div class="container-fluid">
			<div class="navbar-header">
				<a class="navbar-brand" href="#">
					职工信息管理系统
				</a>
			</div>
		</div>
	</nav> -->
	<div class="container">
		<%-- <div class="row">
			<c:if test="${empty student }">
				<a href="login.jsp">登录</a>|
				<a href="register.jsp">没有账号？注册</a>
			</c:if>
			<c:if test="${!empty staff }">
				<Strong>欢迎您：</strong>
				<em>${staff.username }</em>
				<a href="logout" class="pull-right">退出</a>
			</c:if>
		</div> --%>
		<!-- 信息提示 -->
			<c:if test="${!empty msg }">
				<div class="alert alert-danger" role="alert">
				  <span class="glyphicon glyphicon-exclamation-sign" aria-hidden="true"></span>
				 ${msg }
				</div>
			</c:if>
		<div class="row">			
			<form class="navbar-form navbar-left" role="search" method="post" action="queryProduct">
				
				<div class="form-group">
					<input type="text" class="form-control" placeholder="Search" name="name"  >
				</div>
				<a class="btn btn-default" href="toAddProduct">添加</a>
			<!-- 	<a class="btn btn-success" href="toQueryProduct">查询</a>  -->
				<input type="submit" class="btn btn-success" value="查询"/>
			</form>			
			<table class="table table-striped">
				<tr>
					<th>产品编号</th>
					<th>产品生产日期</th>
					<th>产品名称</th>
					<th>产品价格</th>
					<th style="width:100px;overflow:hidden">产品用途</th>
					<th>删除/更新</th>
				</tr>
				<c:forEach items="${list }" var="product" varStatus="s">
					<tr>
						<td>${s.index+1 }</td>
						<td>${product.productDate }</td>
						<td>${product.productName }</td>
						<td>${product.productPrice }</td>
						<td>${product.productUse }</td>
						<td>
							<a class="text-danger glyphicon glyphicon-remove" href="dropProduct?productId=${product.productId }"></a>
							<a class="text-success glyphicon glyphicon-refresh" href="toUpdateProduct?productId=${product.productId }"></a>
						</td>
					</tr>
				</c:forEach>
			</table>
		</div>
	</div>
</body>
</html>