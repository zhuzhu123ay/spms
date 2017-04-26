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
<title>职工信息管理系统-添加产品</title>
<link rel="stylesheet" href="bootstrap/css/bootstrap.min.css">

</head>
<script>
	$.validator.setDefaults({
    submitHandler: function() {
      alert("提交事件!");
    }});
	$().ready(function() {
    $("#commentForm").validate();});
</script>
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
			<c:if test="${empty student }">
				<a href="login.jsp">登录</a>|
				<a href="register.jsp">没有账号？注册</a>
			</c:if>
			<c:if test="${!empty student }">
				<Strong>欢迎您：</strong>
				<em>${student.username }</em>
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
			<form action="addProduct" method="post" class="form-horizontal" id="commentForm">
				 <div class="form-group">
					<label class="col-sm-2 control-label">产品生产日期</label>
					<div class="col-sm-6">
						<input type="date" class="form-control" name="productDate" id="pdDate" minlength="2" required>
			
					</div>
				</div> 
				<div class="form-group">
					<label class="col-sm-2 control-label">产品名称</label>
					<div class="col-sm-6">
						<input type="text" class="form-control" name="productName" id="pdName" minlength="2" required>
						<p style="color:red" id="name"></p>
					</div>
				</div>
				<div class="form-group">
					<label class="col-sm-2 control-label">产品价格</label>
					<div class="col-sm-6">
						<input type="number" class="form-control" name="productPrice" id="pdPrice" required>
						<p style="color:red" id="price"></p>
					</div>
				</div>
				<div class="form-group">
					<label class="col-sm-2 control-label">产品用途</label>
					<div class="col-sm-6">
						<textarea class="form-control" name="productUse" id="pdUse"></textarea>
						 <p style="color:red" id="use"></p>
					</div>
				</div>
				<div class="form-group">
					<div class="col-sm-12 text-center">
						<input type="submit" value="保存" class="btn btn-default" onclick="checkForm();">
						<a class="btn btn-default" href="toIndex">取消</a>
					</div>
				</div>
			</form>
		</div>
	</div>
</body>
<script type="text/javascript">
	function checktxt(){
		var pdDate=document.getElementById("productDate").value;
		if(pdDate==null||pdDate==""){
			document.getElementById("date").style.display="block";
		} else {
		    document.getElementById("date").style.display="none";
		  }
	}
</script>
<!-- <script type="text/javascript">
function Logger() {
	alert("信息提交成功！");
}
function checkForm() {
    if(realise1()==true&&realise2()==true&&realise3()&&realise4()==true)
    {
       Logger();
       return true;
    }
    else
    {  
        realise1();
        realise2();
        realise3();
        realise4();
        return false;
       }
        Logger();
       return true;
  }

function realise1() {	
    if ($("#pdDate").val()=="")
        {  
             $("#date").text("请输入产品生产日期");
              return false;      
         } 
         return true; 
    } 
function realise2()
{
 if($("#pdPrice").val()=="")
 {
     $("#price").text("请输入产品价格");
   return false;
  }  
  return true;
 }   
    
    function realise3()
    {
     if($("#pdUse").val()=="")
    {
     $("#use").text("请输入产品用途");
      return false;
     }
     return true;
     }
  
 function realise4()
 {
	 if($("#pdName").val()=="")
	    {
	     $("#name").text("请输入产品名称");
	      return false;
	     }
	     return true;
  }  
 

	</script> -->
</html>