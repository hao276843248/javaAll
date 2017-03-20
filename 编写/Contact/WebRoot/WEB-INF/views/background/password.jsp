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
<title>青鸟通讯录</title>
<jsp:include page="../inc/scripts.jsp" />
</head>
<body>
	<div id="wrap">
        <jsp:include page="../inc/head.jsp" />   
         <div id="topic">
        	<div id="tlabel">修改密码</div>
        	<jsp:include page="../inc/oper.jsp" />            
        </div>
		<form:form   method="post" modelAttribute="passwordForm">
            
            <div class="field">
                <div class="label">原密码:</div>
                <div class="editor">
                	<form:password path="oldPwd" cssClass="txt"/>                    
                </div>
            </div>
            <div class="err"><form:errors path="oldPwd"/></div>   
            
            <div class="field">
                <div class="label">新密码:</div>
                <div class="editor">
                    <form:password path="newPwd" cssClass="txt"/>
                </div>
            </div>
            <div class="err"><form:errors path="newPwd"/></div>   
            
            <div class="field">
                <div class="label">确认新密码:</div>
                <div class="editor">
                    <form:password path="rePwd" cssClass="txt"/>
                </div>
            </div>
            <div class="err"><form:errors path="rePwd"/></div>           
            
            <div class="field mul">
                <div class="label">验证码:</div>
                <div class="editor">
                    <form:input path="vcode" cssClass="txt"/>
                    <img src="../images/vcode.jpg" class="vcode" id="imgVcode" onclick="refreshVcode()"/>
                </div>
            </div>
            <div class="err"><form:errors path="vcode"/></div>                     
                     
            
            <div class="field">
                <div class="label"></div>
                <div class="editor">
                	<input type="submit" value="修改"/>
                	<input type="reset" value="重置"/>                                                           
                </div>
            </div>
            
        </form:form>
        
    </div>    
</body>
</html>


