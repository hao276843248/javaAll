<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<div id="oper">
	<span>欢迎，${sessionScope.user.userName}</span>
	<a href="password.html">修改密码</a>
	<a href="../logout.html">退出登录</a>                          
</div>  
