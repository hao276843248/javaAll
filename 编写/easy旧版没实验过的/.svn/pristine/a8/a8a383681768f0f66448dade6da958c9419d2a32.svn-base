<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<div id="header" class="wrap">
	<div id="logo"><img src="<%=path %>/images/logo.gif" /></div>
	<div class="help">
		<c:choose>
			<c:when test="${session.user!=null}">
				<a href="#" class="shopping">购物车</a><a href="logout.html">欢迎${session.user.euUserName}</a><a href="register.html">注册</a><a href="guestbook.html">留言</a>
			</c:when>
			<c:otherwise>
				<a href="login.html">登录</a><a href="register.html">注册</a><a href="guestbook.html">留言</a>
			</c:otherwise>
		</c:choose>
		
	</div>
	<div class="navbar">
		<ul class="clearfix">
			<li class="current"><a href="#">首页</a></li>
			<li><a href="#">图书</a></li>
			<li><a href="#">百货</a></li>
			<li><a href="#">品牌</a></li>
			<li><a href="#">促销</a></li>
		</ul>
	</div>
</div>