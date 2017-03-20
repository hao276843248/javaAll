<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
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
		<span>当前位置:后台--内容管理</span>
	</div>
	<div id="shadow"></div>
	<form>
	
	
	<table width="100%" class="list" border="0" cellpadding="0" cellspacing="0">
		<thead>
			<tr>
				<th width="200">昵称</th>
				<th width="300">Email</th>
				<th width="300">添加时间</th>
				<th>操作</th>
			</tr>
		</thead>
		<tr>
			<td>昵称昵称昵称昵称昵称</td>
			<td>nickname@email.com</td>
			<td>14-10-20 14:02:13</td>
			<td>
				<a href="reply.jsp">查看/回复</a>
				<a href="#">删除</a>
			</td>
		</tr>
		<tr>
			<td>昵称昵称昵称昵称昵称</td>
			<td>nickname@email.com</td>
			<td>14-10-20 14:02:13</td>
			<td>
				<a href="reply.jsp">查看/回复</a>
				<a href="#">删除</a>
			</td>
		</tr>
		<tr>
			<td>昵称昵称昵称昵称昵称</td>
			<td>nickname@email.com</td>
			<td>14-10-20 14:02:13</td>
			<td>
				<a href="reply.jsp">查看/回复</a>
				<a href="#">删除</a>
			</td>
		</tr>
		<tr>
			<td>昵称昵称昵称昵称昵称</td>
			<td>nickname@email.com</td>
			<td>14-10-20 14:02:13</td>
			<td>
				<a href="reply.jsp">查看/回复</a>
				<a href="#">删除</a>
			</td>
		</tr>
		<tr>
			<td>昵称昵称昵称昵称昵称</td>
			<td>nickname@email.com</td>
			<td>14-10-20 14:02:13</td>
			<td>
				<a href="reply.jsp">查看/回复</a>
				<a href="#">删除</a>
			</td>
		</tr>
		<tr>
			<td>昵称昵称昵称昵称昵称</td>
			<td>nickname@email.com</td>
			<td>14-10-20 14:02:13</td>
			<td>
				<a href="reply.jsp">查看/回复</a>
				<a href="#">删除</a>
			</td>
		</tr>
		<tr>
			<td>昵称昵称昵称昵称昵称</td>
			<td>nickname@email.com</td>
			<td>14-10-20 14:02:13</td>
			<td>
				<a href="reply.jsp">查看/回复</a>
				<a href="#">删除</a>
			</td>
		</tr>
		<tr>
			<td>昵称昵称昵称昵称昵称</td>
			<td>nickname@email.com</td>
			<td>14-10-20 14:02:13</td>
			<td>
				<a href="reply.jsp">查看/回复</a>
				<a href="#">删除</a>
			</td>
		</tr>
		<tr>
			<td>昵称昵称昵称昵称昵称</td>
			<td>nickname@email.com</td>
			<td>14-10-20 14:02:13</td>
			<td>
				<a href="reply.jsp">查看/回复</a>
				<a href="#">删除</a>
			</td>
		</tr>
		<tr>
			<td>昵称昵称昵称昵称昵称</td>
			<td>nickname@email.com</td>
			<td>14-10-20 14:02:13</td>
			<td>
				<a href="reply.jsp">查看/回复</a>
				<a href="#">删除</a>
			</td>
		</tr>
	</table>
	</form>
	<div id="shadow"></div>
	<table width="100%">
		<tr>
			<td width="50%" align="left">
				<a href="#">首页</a>
				<a href="#">上页</a>
				<a href="#">下页</a>
				<a href="#">尾页</a>
			</td>
			<td width="50%" align="right">
				<a href="#">第1页</a>
				<a href="#">共12页</a>
				<a href="#">每页显示10条</a>
				<a href="#">共112条</a>
			</td>
		</tr>
	</table>
	
</body>
</html>
