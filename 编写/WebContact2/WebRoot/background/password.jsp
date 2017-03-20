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
<jsp:include page="/inc/scripts.jsp" />
<script>
	function refreshVcode(){
		document.getElementById("imgVcode").src="../images/vcode.jpg?r="+Math.random();
	}

</script>
</head>
<body>
	<div id="wrap">
        <div id="title">
            <jsp:include page="/inc/head.jsp" />
        </div>    
         <div id="topic">
        	<div id="tlabel">修改密码</div>
        	<jsp:include page="/inc/oper.jsp" />          
        </div>
            <s:form action="updatePassword" method="post">
            <div class="field">
                <div class="label">原密码:</div>
                <div class="editor">
                	<s:password name="oldPwd" cssClass="txt"/>
                </div>
            </div>
            <div class="err">
            	<s:fielderror fieldName="oldPwd"/>
            </div>   
            
            <div class="field">
                <div class="label">新密码:</div>
                <div class="editor">
                	<s:password name="newPwd" cssClass="txt"/>
                </div>
            </div>
            <div class="err">
            	<s:fielderror fieldName="newPwd"/>
            </div>   
            
            <div class="field">
                <div class="label">确认新密码:</div>
                <div class="editor">
                	<s:password name="rePwd" cssClass="txt"/>
                </div>
            </div>
            <div class="err">
            	<s:fielderror fieldName="rePwd"/>
            </div>           
            
            <div class="field mul">
                <div class="label">验证码:</div>
                <div class="editor">
                	<s:textfield name="vcode" class="txt"/>
                    <img src="../images/vcode.jpg" class="vcode" id="imgVcode" onclick="refreshVcode()"/>
                </div>
            </div>
            <div class="err">
            	<s:fielderror fieldName="vcode"/>
            </div>
                     
            
            <div class="field">
                <div class="label"></div>
                <div class="editor">
                    <input type="submit" value="确定"/>
                    <input type="reset" value="重置"/>                                        
                </div>
            </div>
            
        </s:form>
        
    </div>    
</body>
</html>

