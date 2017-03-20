<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>无标题文档</title>
<link rel="stylesheet" type="text/css" href="css/style.css" />
<style>
.txt {
	width: 150px;
}
</style>
<script>
	function refreshVcode() {
		var imgVcode = document.getElementById("imgVcode");
		imgVcode.src = "vcode.jpg?r=" + Math.random();
	}
</script>
</head>
<body>
	<div id="login">
		<div class="title">
			<span>登录</span>
		</div>
		<form action="login" method="post">
			<table width="100%" border="0">
				<tr class="fitem">
					<td class="flabel">用户名</td>
					<td class="finput"><input type="text" name="userName"
						class="txt" value="${param.loginName}" />
					</td>
				</tr>
				<tr class="ferror">
					<td></td>
					<td>${err_userName}</td>
				</tr>
				<tr class="fitem">
					<td class="flabel">密码</td>
					<td class="finput"><input type="password" name="password"
						class="txt" value="${param.password}" />
					</td>
				</tr>
				<tr class="ferror">
					<td></td>
					<td>${err_password}</td>
				</tr>
				<tr class="fitem">
					<td class="flabel" valign="top">验证码</td>
					<td class="finput"><input type="text" name="vcode" class="txt" /><br />
						<img id="imgVcode" src="vcode.jpg" width="150" height="50"
						onclick="refreshVcode()" />
					</td>
				</tr>
				<tr class="ferror">
					<td></td>
					<td>${err_vcode}</td>
				</tr>
				<tr class="fitem">
					<td class="flabel"></td>
					<td class="finput"><input type="submit" value="登录" class="btn" />
					</td>
				</tr>
			</table>
		</form>
	</div>


</body>
</html>
