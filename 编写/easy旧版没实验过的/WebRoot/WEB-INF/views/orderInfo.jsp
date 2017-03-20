<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<jsp:include page="inc/scripts.jsp" />
</head>
<body>
<jsp:include page="inc/header.jsp" />
<jsp:include page="inc/childNav.jsp" />
<div id="register" class="wrap">
	<div class="shadow">
		<em class="corner lb"></em>
		<em class="corner rt"></em>
		<div class="box">
			<h1>欢迎进入易买网订单页面</h1>
			<ul class="steps clearfix">
				<li class="current"><em></em>填写订单信息</li>
				<li class="last"><em></em>购买成功</li>
			</ul>
			<form id="regForm" method="post" action="reg-result.html" onsubmit="">
				<table>
                <tr>
						<td class="field">收货人：</td>
						<td><input class="text" type="text" name="userId"  /><span></span></td>
					</tr>
				
                      <tr>
						<td class="field">收货地址：</td>
						<td><textarea name="address" cols="28" rows="5">
                        
                        </textarea><span></span></td>
					</tr>
					<tr>
						<td></td>
						<td><label class="ui-green"><input type="submit" name="submit" value="购买" /></label></td>
					</tr>
				</table>
			</form>
		</div>
	</div>
	<div class="clear"></div>
</div>
<jsp:include page="inc/foot.jsp" />
</body>
</html>
