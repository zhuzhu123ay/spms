<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<% 
	//当用户访问localhost:8888/sms_web的时候，会跳转到首页
	request
	.getRequestDispatcher("/toIndex")
	.forward(request,response);
%>