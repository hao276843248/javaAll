<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'index.jsp' starting page</title>
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
   <form action="aaa.action" method="post">
        	姓名：<input type="text" name="name"/><br/>
   			年龄：<input type="text" name="age"/><br/>
   			性别：<input type="text" name="sex"/><br/>
   			身高：<input type="text" name="hight"/><br/>
   			职业：<input type="text" name="zhiye"/><br/>
   			<input type="submit" value="提交">
   </form>
   
   <hr/>
   <form action="aaa.action" method="post">
        	姓名：<input type="text" name="name1" value="${name}"/><br/>
   			年龄：<input type="text" name="age1" value="${age}"/><br/>
   			性别：<input type="text" name="sex1" value="${sex}"/><br/>
   			身高：<input type="text" name="hight1" value="${hight}"/><br/>
   			职业：<input type="text" name="zhiye1" value="${zhiye}"/><br/>
   			<input type="submit" value="提交">
   </form>
  </body>
</html>






