<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>无标题文档</title>
<link rel="stylesheet" type="text/css" href="style.css"/>
<style type="text/css">

</style>

</head>
<body>
<div id="head">
	<div id="left">
		<h1>学生管理系统</h1>
	</div>
	<div id="right">
		<ul>
		</ul>
	</div>
</div>	
    	<form method="post" action="login">
    	<table width="100%"  style="margin:0 auto;">
        	<tr >
            	<td width="100" class="label">用户名</td>
                <td width="300">
                	<input type="text" name="loginName" class="text" value="${empty param.loginName?cookie.value:param.loginName}"/>                    
                </td>
                <td>
                	<div class="err">${err_loginName}</div>
                </td>
            </tr>
            <tr>
            	<td width="100" class="label">密码</td>
                <td>
                	<input type="password" name="password" class="text"/>
                </td>
                <td>
                	<div class="err">${err_password}</div>
                </td>
            </tr>
            <tr>
            	<td width="100" class="label"></td>
                <td>
                	<input type="submit" value="登录"/>
                	            
                </td>
            </tr>
        </table>
		</form>
</body>
</html>

