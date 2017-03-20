<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<jsp:include page="../inc/scripts.jsp" />
</head>
<body>
	<div id="wrap">
        <jsp:include page="../inc/head.jsp" /> 
        <div id="topic">
        	<div id="tlabel">修改联系人</div>
        	<jsp:include page="../inc/oper.jsp" />         
        </div>
		<form:form action="update.html" method="post" enctype="multipart/form-data" modelAttribute="contactForm">
			<form:hidden path="id"/>
            <div class="field">
                <div class="label">姓名:</div>
                <div class="editor">
                	<form:input path="name" cssClass="txt"/>                
                </div>
            </div>
            <div class="err"><form:errors path="name"/></div>
            
            <div class="field">
                <div class="label">性别:</div>
                <div class="editor">
                	<form:radiobutton path="sex" value="男" label="男"/>	
                	<form:radiobutton path="sex" value="女" label="女"/>				   
                </div>
            </div>
            <div class="err"><form:errors path="sex"/></div>            
            
            <div class="field">
                <div class="label">照片:</div>
                <div class="editor">
                	<input type="file" name="upload" class="file"/>                    
                </div>
            </div>  
            <div class="err"><form:errors path="upload"/></div> 
            
            
            <div class="field">
                <div class="label">头衔:</div>
                <div class="editor">
                	<form:input path="title" cssClass="txt" id="txtTitle"/>
                </div>
            </div>
            <div class="err"><form:errors path="title"/></div>            
            
            <div class="field">
                <div class="label">分组:</div>
                <div class="editor"> 
                	<form:select path="gid" items="${group}" itemValue="id" itemLabel="name" cssClass="sel"></form:select>
                </div>
            </div>   
            <div class="err"><form:errors path="gid"/></div>   
            
            <div class="field">
                <div class="label">生日:</div>
                <div class="editor">
                	<form:input path="birthday" cssClass="txt Wdate" onclick="WdatePicker({skin:'ext',readOnly:true})"/>
                </div>
            </div>       
            <div class="err"><form:errors path="birthday"/></div>                         
                              
			<div class="field">
                <div class="label">电话:</div>
                <div class="editor">
                	<form:input path="phone" cssClass="txt"/>                   
                </div>
            </div>       
            <div class="err"><form:errors path="phone"/></div>                 
            
            <div class="field">
                <div class="label">Email:</div>
                <div class="editor">
                    <form:input path="email" cssClass="txt"/>
                </div>
            </div>  
            <div class="err"><form:errors path="email"/></div>   
            
            <div class="field">
                <div class="label">QQ:</div>
                <div class="editor">
                    <form:input path="qq" cssClass="txt"/>
                </div>
            </div>  
            <div class="err"><form:errors path="qq"/></div>              
            
            <div class="field">
                <div class="label">地址:</div>
                <div class="editor">
                    <form:input path="address" cssClass="txt"/>
                </div>
            </div>  
            <div class="err"><form:errors path="address"/></div>   
            
            <div class="field mul">
                <div class="label">描述:</div>
                <div class="editor">
                	<form:textarea path="description" cssClass="tarea"/>                    
                </div>
            </div>  
            <div class="err"><form:errors path="description"/></div>   
			
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
                	<input type="submit" value="添加"/>
                	<input type="reset" value="重置"/>                                        
                </div>
            </div>
            
        </form:form>
        
    </div>    
</body>
</html>

