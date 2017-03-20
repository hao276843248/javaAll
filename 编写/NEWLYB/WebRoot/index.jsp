<%@page import="cn.hao.lyb.entity.Message"%>
<%@page import="java.text.SimpleDateFormat"%>
<%@page import="oracle.net.aso.p"%>
<%@page import="cn.bdqn.jdbc.DBHelper"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.PreparedStatement"%>
<%@page import="java.sql.Connection"%>
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
<link rel="stylesheet" type="text/css" href="style.css" />
<script>

</script>
</head>
<body>

	
	<div id="title">
		<span>青鸟留言板</span>
	</div>
	<%
		SimpleDateFormat sdf=new SimpleDateFormat("yyyy年MM月dd日 HH:mm:ss:SS");
		List<Message> a=(List<Message>)request.getAttribute("message");
		for(Message c:a){
		%>
			<div class="content">
				<div class="title">
					<span class="label">昵称:</span>
					<span class="text"><%=c.getName()%></span>
					<span class="sp">|</span>
					<span class="label">IP:</span>
					<span class="text"><%=c.getIp()%></span>
					<span class="sp">|</span>
					<span class="label">时间:</span>
					<span class="text"><%=sdf.format(c.getDate()) %></span>
					<span class="lable"><a href="delete?id=<%=c.getId()%>"  >删除</a></span>
				</div>
				<div class="message" id="a">
					<%=c.getContent() %>
				</div>
			</div>
		<%
		}
	 %>

	<div id="form">
		<form action="save" method="post">
		<table width="100%">
			<tr>
				<td width="100" align="right">昵称</td>
				<td>
					<input type="text" name="nickName"/>
				</td>
			</tr>
			<tr>
				<td valign="top" align="right">内容</td>
				<td>
					<textarea name="content" cols="80" rows="6"></textarea>
				</td>
			</tr>
			<tr>
				<td></td>
				<td>
					<input type="submit" value="提交"/>
					<input type="reset" value="重置"/>
				</td>
			</tr>
		</table>
		</form>
	</div>
	
	<div id="foot">
		&copy;北大青鸟 版权所有
	</div>
	
</body>
</html>
