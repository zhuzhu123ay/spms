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
<title>职工信息管理系统-职工</title>
<link rel="stylesheet" href="bootstrap/css/bootstrap.min.css">
</head>
<body>

	 <table class="table table-striped" border="0" cellspacing="0" cellpadding="0">
		<tr>
			<th>id</th>
			<th>用户名</th>
			<th>密码</th>
			<th>性别</th>
			<th>年龄</th>
			<th>删除/更新</th>
		</tr>
		<c:forEach items="${list }" var="staff" varStatus="s">
			<tr>
				<td>${s.index+1}</td>
				<td>${staff.username }</td>
				<td>${staff.password }</td>
				<td>${staff.gender }</td>
				<td>${staff.age }</td>
				<td><a class="text-danger glyphicon glyphicon-remove"
					href="dropStaff?id=${staff.id }"></a> <a
					class="text-success glyphicon glyphicon-refresh"
					href="toUpdateStaff?id=${staff.id }"></a></td>
			</tr>
		</c:forEach>
	</table> 
</body>
</html>