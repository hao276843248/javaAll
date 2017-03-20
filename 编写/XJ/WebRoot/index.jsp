<%@page import="cn.bdqn.jdbc.DBHelper"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.PreparedStatement"%>
<%@page import="java.sql.Connection"%>
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
        <form method="POST" action="CosUploadServlet" ENCTYPE="multipart/form-data">  
            <table>  
                <tr><td><input type="text" name="subject" /></td></tr>  
                <tr><td><input type="file" name="file1"/></td></tr>  
                <tr><td><input type="file" name="file2"/></td></tr>  
                <tr><td><input type="file" name="file3"/></td></tr>  
                <tr><td><input type="submit" value="上传"/></td></tr>  
            </table>            
        </form>  
        <br/>  
        <a href="CosDownloadServlet">下载</a>  
    </body>  
</html>
