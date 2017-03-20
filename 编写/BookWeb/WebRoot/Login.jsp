<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>登录</title>

<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/static/style.css"></link>
<script>
	function changeVcode(){
		document.getElementById("imgVcode").src="vcode.jpg?r="+Math.random();
	}
</script>
</head>

<body>
	<jsp:include page="inc/head.jsp" />
	<div id="wrap">
		<form method="post" action="login">
    	<table width="100%">
        	<tr>
            	<td width="100" class="label">用户名</td>
                <td width="300">
                	<input type="text" name="loginName" class="text" value="${empty param.loginName?cookie.loginName.value:param.loginName}"/>                    
                </td>
                <td>
                	<div class="err">${err_loginName}</div>
                </td>
            </tr>
            <tr>
            	<td width="100" class="label">密码</td>
                <td>
                	<input type="password" name="password" class="text" value="${param.password}"/>
                </td>
                <td>
                	<div class="err">${err_password}</div>
                </td>
            </tr>
            <tr>
            	<td width="100" class="label" valign="top">验证码</td>
                <td>
                	<input type="text" name="vcode" class="text" style="width:100px"/><br/>
                	<img src="vcode.jpg" id="imgVcode" onclick="changeVcode()"/>
                </td>
                <td>
                	<div class="err">${err_vcode}</div>
                </td>
            </tr>
           
            <tr>
            	<td width="100" class="label"></td>
                <td>
                	<input type="submit" value="登录"/>
                	 <p>访问次数${count} </p>          
                </td>
            </tr>
        </table>
		</form>
    </div>
</body>
</html>
