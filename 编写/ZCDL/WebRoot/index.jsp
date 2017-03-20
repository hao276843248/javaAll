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
</head>

<body>
	<form name="dataForm" id="dataForm" action="a.jsp" method="post">
    	<table class="td" border="0" cellspacing="5" cellpadding="0" align="center">
        	<tr>
            <td align="center" colspan="2" style="text-align:center" class="test_tanledetail2">用户注册</td>
            </tr>
            <tr>
            	<td class="text_tabledetai12">用户名</td>
                <td><input type="text" name="username" value="" /></td>
            </tr>
            <tr>
 				<td class="text_tabledetai12">密码</td>
                <td><input type="password" name="password" value="" /></td>
            </tr>
            <tr>
 				<td class="text_tabledetai12">确认密码</td>
                <td><input type="password" name="Qpassword" value="" /></td>
            </tr>
            <tr>
 				<td class="text_tabledetai12">邮箱</td>
                <td><input type="text" name="email" value="" /></td>
            </tr>
            <tr>
 				<td style="text-align:center;" colspan="2">
                	<input type="submit" value="注册" />
                	<a src="deng.htmi"><input type="button" value="去登录" /></a>
                </td>
            </tr>
        </table>
    </form>

</body>
</html>
