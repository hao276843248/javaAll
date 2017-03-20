<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.springframework.org/tags/form"  prefix="form"%>
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
<jsp:include page="inc/scripts.jsp" />
</head>
<body>
<jsp:include page="inc/header.jsp" />
<jsp:include page="inc/childNav.jsp" />
<div id="register" class="wrap">
	<div class="shadow">
		<em class="corner lb"></em> <em class="corner rt"></em>
		<div class="box">
			<h1>欢迎回到易买网</h1>
			<form:form id="loginForm" method="post" modelAttribute="loginForm" 
				onsubmit="return checkForm(this)">
				<table >
					<tr>
						<td class="field">用户名：</td>
						<td class="shu"><form:input class="text" path="userName"
							onfocus="FocusItem(this)" onblur="CheckItem(this);" />
						</td>
						<td><form:errors path="userName" cssClass="error"></form:errors></td>
					</tr>
					<tr>
						<td class="field">登录密码：</td>
						<td><form:password class="text"  id="passWord"
							path="password"  />
							
						</td>
						<td><form:errors path="password" cssClass="error"></form:errors></td>
					</tr>

					<tr>
						<td></td>
						<td><label class="ui-green"><input type="submit"
								name="submit" value="立即登录" />
						</label>
						</td>
					</tr>
				</table>
			</form:form>
		</div>
	</div>
	<div class="clear"></div>
</div>
<jsp:include page="inc/foot.jsp" />
</body>
</html>
