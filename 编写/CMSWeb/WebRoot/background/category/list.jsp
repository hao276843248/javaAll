<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<jsp:include page="../inc/script.jsp" />
</head>
<body>
	<jsp:include page="../inc/head.jsp"/>
	<div id="shadow"></div>
	
	<div class="path">
		<span>当前位置:后台--分类管理</span>
	</div>
	<div id="shadow"></div>
	<form method="post">
	<div class="oper">
		<span>
			<a href="add.jsp">+添加分类</a>
			<input type="text" name="name" value="请输入分类名" title="请输入分类名" onfocus="inputFocus(this)" onblur="inputBlur(this)"/>
			<input type="submit" value="搜索"/>
		</span>
	</div>
	</form>
	<table width="100%" class="list" border="0" cellpadding="0" cellspacing="0">
		<thead>
			<tr>
				<th width="200">分类</th>
				<th>操作</th>
			</tr>
		</thead>
		<c:forEach items="${cate}" var="c">
		<tr>
			<td>${c.name}</td>
			<td>
				<a href="update?id=${c.id}">编辑</a>
				<a href="delete?id=${c.id}">删除</a>
			</td>
		</tr>
		</c:forEach>
	</table>
</body>
</html>
