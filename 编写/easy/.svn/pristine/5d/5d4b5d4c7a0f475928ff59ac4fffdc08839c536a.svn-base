<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.springframework.org/tags/form"  prefix="form"%>
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
			<h1>欢迎注册易买网</h1>
			<ul class="steps clearfix">
				<li class="current"><em></em>填写注册信息</li>
				<li class="last"><em></em>注册成功</li>
			</ul>
			<form:form  method="post"  modelAttribute="registForm">
				<table>
                <tr>
						<td class="field">登陆名：</td>
						<td><form:input   path="userId"  class="text"/><span>*</span></td>
						<td><form:errors path="userId" cssClass="error"></form:errors></td>
					</tr>
					<tr>
						<td class="field">真实姓名：</td>
						<td><form:input   path="userName"  class="text"/><span></span></td>
						<td><form:errors path="userName" cssClass="error"></form:errors></td>
					</tr>
					<tr>
						<td class="field">登录密码：</td>
						<td><form:password   path="passWord"  class="text"/><span></span></td>
						<td><form:errors path="passWord" cssClass="error"></form:errors></td>
					</tr>
					<tr>
						<td class="field">确认密码：</td>
						<td><form:password   path="rePassword"  class="text"/><span></span></td>
						<td><form:errors path="rePassword" cssClass="error"></form:errors></td>
					</tr>
					<tr>
						<td class="field">性别：</td>
						<td><form:radiobutton path="sex" value="男" label="男"/>	
                			<form:radiobutton path="sex" value="女" label="女"/>	
                			<span></span>
                		</td>
                		<td><form:errors path="sex" cssClass="error"></form:errors></td>
					</tr>
                    <tr>
						<td class="field">邮箱地址：</td>
						<td><form:input   path="email"  class="text"/><span></span></td>
						<td><form:errors path="email" cssClass="error"></form:errors></td>
					</tr>
                    <tr>
						<td class="field">出生日期：</td>
						<td><form:input path="birthday" cssClass="txt Wdate" onclick="WdatePicker({skin:'ext',readOnly:true})"/><span></span></td>
						<td><form:errors path="birthday" cssClass="error"></form:errors></td>
					</tr>
                    <tr>
						<td class="field">身份证号：</td>
						<td><form:input   path="cardId"  class="text"/><span></span></td>
						<td><form:errors path="cardId" cssClass="error"></form:errors></td>
					</tr>
                       <tr>
						<td class="field">电话号码：</td>
						<td><form:input   path="phone"  class="text"/><span></span></td>
						<td><form:errors path="phone" cssClass="error"></form:errors></td>
					</tr>
                      <tr>
						<td class="field">联系地址：</td>
						<td><form:textarea path="address" cols="28" rows="5"/><span></span></td>
						<td><form:errors path="address" cssClass="error"></form:errors></td>
					</tr>
					<tr>
						<td></td>
						<td><label class="ui-green"><input type="submit" name="submit" value="提交注册" /></label></td>
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
