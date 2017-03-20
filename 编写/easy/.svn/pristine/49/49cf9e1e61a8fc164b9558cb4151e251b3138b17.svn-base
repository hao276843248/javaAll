<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>后台管理 - 易买网</title>
<jsp:include page="../inc/scripts.jsp" /></head>
<body>
<jsp:include page="../inc/manageHeader.jsp" />
<div id="main" class="wrap">
	<jsp:include page="../inc/ManageLeft.jsp" />
	<div class="main">
		<h2>用户管理</h2>
		<div class="manage">
			<table class="list">
				<tr>
					<th>ID</th>
					<th>姓名</th>
					<th>性别</th>
					<th>Email</th>
					<th>手机</th>
					<th>操作</th>
				</tr>
				<c:forEach items="${pUser.results}" var="user" varStatus="i">
					<tr>
					<td class="first w4 c">${i.index+1}</td>
					<td class="w1 c">${user.euUserName}</td>
					<td class="w2 c">${user.euSex}</td>
					<td>${user.euEmail}</td>
					<td class="w4 c">${user.euMobile}</td>
					<td class="w1 c"><a href="update-modify_${user.euUserId}.html">修改</a>
					<c:if test="${i.index!=0}"><a href="delete_${user.euUserId}.html">删除</a></c:if>
					</td>
				</tr>
				</c:forEach>
				
			</table>
		</div>
	</div>
	<div class="clear"></div>
</div>
<jsp:include page="../inc/foot.jsp" />
</body>
</html>
