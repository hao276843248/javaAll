<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
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
		<h2>订单管理</h2>
		<div class="manage">
			<div class="search">
				<form method="get">
					订单号：<input type="text" class="text" name="orderId" /> 订货人：<input type="text" class="text" name="userName" /> <label class="ui-blue"><input type="submit" name="submit" value="查询" /></label>
				</form>
			</div>
			<div class="spacer"></div>
			<table class="list">
				<tr>
					<th>ID</th>
					<th>姓名</th>
					<th>发货地址</th>
					<th>状态</th>
					<th>操作</th>
				</tr>
				<tr>
					<td class="first w4 c">1</td>
					<td class="w1 c">张三丰</td>
					<td>高老庄</td>
					<td class="w1 c">发货</td>
					<td class="w1 c"><a href="order-modify.html">修改</a> <a href="javascript:Delete(1);">删除</a></td>
				</tr>
				<tr>
					<td class="first w4 c">1</td>
					<td class="w1 c">张三丰</td>
					<td>花果山</td>
					<td class="w1 c">审核通过</td>
					<td class="w1 c"><a href="order-modify.html">修改</a> <a href="javascript:Delete(1);">删除</a></td>
				</tr>
			</table>
			<div class="pager">
				<ul class="clearfix">
					<li><a href="#">上一页</a></li>
					<li class="current">1</li>
					<li><a href="#">2</a></li>
					<li><a href="#">3</a></li>
					<li><a href="#">4</a></li>
					<li><a href="#">5</a></li>
					<li><a href="#">下一页</a></li>
				</ul>
			</div>
		</div>
	</div>
	<div class="clear"></div>
</div>
<jsp:include page="../inc/foot.jsp" />
</body>
</html>
