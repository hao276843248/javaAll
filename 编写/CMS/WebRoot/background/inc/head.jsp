<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<div id="title">
	<table width="100%" cellpadding="0" cellspacing="0">
		<tr>
			<td width="50%">
				<img src="<%=path%>/images/logo.jpg"/>
			</td>
			<td width="50%" align="right" id="info">
				<span>
					当前用户:${sessionScope.user.userName}&nbsp;<a href="<%=path%>/logout">退出登录</a>
				</span>
			</td>
		</tr>
	</table>
</div>
<ul id="nav">
	<li link="<%=path%>/background/user/list">用户管理</li>
	<li link="<%=path%>/background/category/list">分类管理</li>
	<li link="<%=path%>/background/content/list">内容管理</li>
	<li link="leaveword/list.html">留言管理</li>
</ul>






