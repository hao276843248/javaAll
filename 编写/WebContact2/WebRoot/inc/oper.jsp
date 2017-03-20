<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@taglib uri="/struts-tags" prefix="s" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<div id="oper">
	<%-- <span>欢迎,<s:property value="#session.user.userName"/></span> --%>
	<span>欢迎,${sessionScope.user.userName}</span>
	<a href="../background/password.jsp">修改密码</a>
	<a href="../logout">退出登录</a>                          
</div> 