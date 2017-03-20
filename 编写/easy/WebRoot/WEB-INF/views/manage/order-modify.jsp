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
		<h2>修改订单</h2>
		<div class="manage">
			<form action="manage-result.html">
				<table class="form">
					<tr>
						<td class="field">订单ID：</td>
						<td><input type="text" class="text" name="orderId" value="100000" readonly="readonly" /></td>
					</tr>
					<tr>
						<td class="field">订购人姓名：</td>
						<td><input type="text" class="text" name="name" value="张三" /></td>
					</tr>
					<tr>
						<td class="field">订购人地址：</td>
						<td><input type="text" class="text" name="address" value="北京市" /></td>
					</tr>
<tr>
						<td class="field">订购时间：</td>
						<td><input type="text" class="text" name="createdate" value="2010-10-10" /></td>
					</tr>
<tr>
						<td class="field">订购金额：</td>
						<td><input type="text" class="text" name="cost" value="300" /></td>
					</tr>
<tr>
						<td class="field">发货状态：</td>
						<td><input type="radio" class="" checked="checked" name="status" value="1" />已发货
<input type="radio" class="" name="status" value="2" />未发货</td>
					</tr>
					<tr>
						<td></td>
						<td><label class="ui-blue"><input type="submit" name="submit" value="更新" /></label></td>
					</tr>
				</table>
			</form>
		</div>
	</div>
	<div class="clear"></div>
</div>
<jsp:include page="../inc/foot.jsp" />
</body>
</html>
