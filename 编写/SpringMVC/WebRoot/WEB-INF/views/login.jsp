<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.springframework.org/tags/form"  prefix="form"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'login.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->

  </head>
  
  <body>
  	<%-- modelAttribute属性表示用模型中的LoginForm对象与表单结合，初始化数据 --%>
   <form:form method="post" modelAttribute="loginform" >
   	<table>
   		<tr>
   			<td>登录名</td>
   			<td><form:input path="loginName"/>
   				<form:errors path="loginName"/>
   			</td>
   			
   		</tr>
   		<tr>
   			<td>密码</td>
   			<td><form:password path="password" />
   				<form:errors path="password"/>
   			</td>
   			
   		</tr>
   		<tr>
   			<td></td>
   			<td><input type="submit" value="登录" /></td>
   			<td></td>
   		</tr>
   	</table>
   </form:form>
  </body>
</html>
