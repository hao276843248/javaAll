<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@taglib uri="/struts-tags" prefix="s" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<s:action name="groups" namespace="/background"/>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<jsp:include page="/inc/scripts.jsp" />
<script >
	function refreshVcode(){
		document.getElementById("imgVcode").src="../images/vcode.jpg?r="+Math.random()
	}
	
</script>
</head>
<body>
	<div id="wrap">
       
            <jsp:include page="/inc/head.jsp" />
         
        <div id="topic">
        	<div id="tlabel">修改联系人</div>
        	<jsp:include page="/inc/oper.jsp" />          
        </div>
		
		<s:form action="updateContact" method="post" enctype="multipart/form-data">
			<s:hidden name="id"/>
            <div class="field">
                <div class="label">姓名:</div>
                <div class="editor">
                	<s:textfield name="name" cssClass="txt"/>
                </div>
            </div>
            <div class="err">
            	<s:fielderror fieldName="name"/>
            </div>
            
            <div class="field">
                <div class="label">性别:</div>
                <div class="editor">
                	<s:radio list="#{'男':'男','女':'女'}" name="sex"/>                   
                </div>
            </div>
            <div class="err">
            	<s:fielderror fieldName="sex"/>
            </div>            
            
            <div class="field">
                <div class="label">照片:</div>
                <div class="editor">
                	<s:file name="upload" cssClass="file"/>                    
                </div>
            </div>  
            <div class="err">
            	<s:fielderror fieldName="upload"/>
            </div> 
            
            
            <div class="field">
                <div class="label">头衔:</div>
                <div class="editor">
                	<s:textfield name="title" cssClass="txt"/>                    
                </div>
            </div>
            <div class="err">
            	<s:fielderror fieldName="title"/>
            </div>            
            
            <div class="field">
                <div class="label">分组:</div>
                <div class="editor">
                	<s:select list="#request.groups" listKey="id" listValue="name"  name="group.id" class="sel" headerKey="" headerValue="请选择分组"/>					
                </div>
            </div>   
            <div class="err">
            	<s:fielderror fieldName="group.id"/>
            </div>   
            
            <div class="field">
                <div class="label">生日:</div>
                <div class="editor">
                	<s:textfield name="birthday" class="txt Wdate" onclick="WdatePicker({skin:'ext',readOnly:true})"/>
                </div>
            </div>       
            <div class="err">
            	<s:fielderror fieldName="birthday"/>
            </div>                         
                              
			<div class="field">
                <div class="label">电话:</div>
                <div class="editor">
                	<s:textfield name="phone" cssClass="txt"/>                    
                </div>
            </div>       
            <div class="err">
            	<s:fielderror fieldName="phone"/>
            </div>                 
            
            <div class="field">
                <div class="label">Email:</div>
                <div class="editor">
                	<s:textfield name="email" cssClass="txt"/>                    
                </div>
            </div>  
            <div class="err">
            	<s:fielderror fieldName="email"/>
            </div>   
            
            <div class="field">
                <div class="label">QQ:</div>
                <div class="editor">
                	<s:textfield name="qq" cssClass="txt"/>                    
                </div>
            </div>  
            <div class="err">
            	<s:fielderror fieldName="qq"/>
            </div>              
            
            <div class="field">
                <div class="label">地址:</div>
                <div class="editor">
                	<s:textfield name="address" cssClass="txt"/>                    
                </div>
            </div>  
            <div class="err">
            	<s:fielderror fieldName="address"/>
            </div>   
            
            <div class="field mul">
                <div class="label">描述:</div>
                <div class="editor">
                	<s:textarea name="description" cssClass="tarea"></s:textarea>                    
                </div>
            </div>  
            <div class="err">
            	<s:fielderror fieldName="description"/>
            </div>   
			
            <div class="field mul">
                <div class="label">验证码:</div>
                <div class="editor">
                	<s:textfield name="vcode" cssClass="txt"/>                    
                    <img src="../images/vcode.jpg" class="vcode" id="imgVcode" onclick="refreshVcode()"/>
                </div>
            </div>
            <div class="err">
            	<s:fielderror fieldName="vcode"/>
            </div>                     
            
            <div class="field">
                <div class="label"></div>
                <div class="editor">
                    <input type="submit" value="修改"/>
                    <input type="reset" value="重置"/>                    
                </div>
            </div>
       </s:form>
    </div>    
</body>
</html>

