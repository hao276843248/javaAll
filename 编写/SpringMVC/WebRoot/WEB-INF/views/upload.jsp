<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'upload.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
  </head>
  
  <body>
   <form:form method="post" enctype="multipart/form-data" modelAttribute="uploadForm" >
   		<table>
   			<tr>
   				<td>标题</td>
   				<td><form:input path="title" />
   					<form:errors path="title"/>
   				</td>
   			</tr>
   			<tr>
   				<td>文件</td>
   				<td><input type="file" name="upload" />
   					<form:errors path="upload"/>
   				</td>
   			</tr>
   			<tr>
   				<td></td>
   				<td><input type="submit" value="提交"/></td>
   			</tr>
   		</table>
   </form:form>
  </body>
</html>
