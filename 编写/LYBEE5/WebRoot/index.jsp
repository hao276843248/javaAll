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
		SimpleDateFormat sdf=new SimpleDateFormat("yyyy年MM月dd日 HH:mm:ss:ss");
		
		Connection conn=null;
		PreparedStatement pstmt=null;
		ResultSet res=null;
		try{
			conn=DBHelper.getConnection();
			pstmt=conn.prepareStatement("SELECT nickName,content,ip,addTime from MESSAGE ORDER BY id DESC ");	
			res=pstmt.executeQuery();
			while(res.next()){
			%>
			<div class="content">
				<div class="title">
					<span class="label">昵称:</span>
					<span class="text"><%=res.getString("nickName") %></span>
					<span class="sp">|</span>
					<span class="label">IP:</span>
					<span class="text"><%=res.getString("ip") %></span>
					<span class="sp">|</span>
					<span class="label">时间:</span>
					<span class="text"><%=sdf.format(res.getTimestamp("addTime")) %></span>
				</div>
				<div class="message">
					<%=res.getString("content") %>
				</div>
			</div>
			
			<%
			}	
		}catch(Exception e){
			System.out.print(e.getMessage());
		}finally{
			DBHelper.closeAll(conn, pstmt, res);
		}
	 %>

	<div id="form">
		<form action="save.jsp" method="post">
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
