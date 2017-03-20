<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="/struts-tags" prefix="s"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<jsp:include page="/inc/scripts.jsp"/>
<script>
	function refreshVcode(){
		document.getElementById("imgVcode").src="images/vcode.jpg?r="+Math.random();
	}
</script>
</head>
<body>
	<div id="wrap">
        <jsp:include page="/inc/head.jsp"/> 
        <div id="topic">
        	<div id="tlabel">找回密码</div>        	     
        </div>  
		<h4>找回密码时发生错误，请稍后再试</h4>
    </div>    
</body>
</html>


