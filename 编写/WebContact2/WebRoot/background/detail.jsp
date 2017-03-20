<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@taglib uri="/struts-tags"  prefix="s"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>


<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<jsp:include page="/inc/scripts.jsp" />
</head>
<body>
	<div id="wrap">
        
           <jsp:include page="/inc/head.jsp" />
        
        <div id="topic">
        	<div id="tlabel">详细信息</div>
        	<jsp:include page="/inc/oper.jsp" />           
        </div>  
		<form>        	
        	<div id="photo">
            	<img src="../upload/<s:property value='photo'/>" height="128"/>
            </div>
        	<div id="fields"> 
                <div class="field odd">
                    <div class="label">姓名:</div>
                    <div class="content">
                    	<s:property value="name"/>
                    </div>
                </div>
                <div class="field">
                    <div class="label">性别:</div>
                    <div class="content">
                    	<s:property value="sex"/>
                    </div>
                </div>
                <div class="field odd">
                    <div class="label">头衔:</div>
                    <div class="content">
                    	<s:property value="title"/>
                    </div>
                </div>
                <div class="field">
                    <div class="label">分组:</div>
                    <div class="content">
                    	<s:property value="group.name"/>
                    </div>
                </div>   
                <div class="field odd">
                    <div class="label">生日:</div>
                    <div class="content">
						<s:property value="birthday"/>
					</div>
                </div>               
                <div class="field">
                    <div class="label">电话:</div>
                    <div class="content">
                    	<s:property value="phone"/>
                    </div>
                </div>            
                <div class="field odd">
                    <div class="label">Email:</div>
                    <div class="content">
                    	<s:property value="email"/>
                    </div>
                </div>  
                <div class="field">
                    <div class="label">QQ:</div>
                    <div class="content">
                    	<s:property value="qq"/>
                    </div>
                </div>  
                <div class="field odd">
                    <div class="label">地址:</div>
                    <div class="content">
                    	<s:property value="address"/>
                    </div>
                </div>  
                
                <div class="field">
                    <div class="label">描述:</div>
                    <div class="content">
                    	<s:property value="description"/>
                    </div>
                </div>  
                                
                
            </div>
           
            
        </form>
        
    </div>    
</body>
</html>

