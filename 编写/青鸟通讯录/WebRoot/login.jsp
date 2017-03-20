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
        	<div id="tlabel">用户登录</div>        	     
        </div>  
		<s:form action="login" method="post">
            <div class="field">
                <div class="label">用户名:</div>
                <div class="editor">
                	<s:textfield name="userName" cssClass="txt"/>
                </div>
            </div>
            <div class="err">
            	<s:fielderror fieldName="userName"/>
            </div>
            
            <div class="field">
                <div class="label">密码:</div>
                <div class="editor">
                	<s:password name="password" cssClass="txt"/>                    
                </div>
            </div>
            <div class="err">
            	<s:fielderror fieldName="password"/>
            </div>           
            
            <div class="field mul">
                <div class="label">验证码:</div>
                <div class="editor">                	
                    <s:textfield name="vcode" cssClass="txt"/>
                    <img src="images/vcode.jpg" class="vcode" id="imgVcode" onclick="refreshVcode()"/>
                </div>
            </div>
            <div class="err">
            	<s:fielderror fieldName="vcode"/>
            </div>
                     
            
            <div class="field">
                <div class="label"></div>
                <div class="editor">
                    <s:submit value="登录"/>
                	<s:reset value="重置"/>                          
                    <a href="regist.jsp">注册新用户</a>
                </div>
            </div>
     	
        </s:form>  
        <s:debug/>    
    </div>    
</body>
</html>


