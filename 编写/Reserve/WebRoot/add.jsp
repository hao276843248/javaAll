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
<title>无标题文档</title>
<link rel="stylesheet" type="text/css" href="css/style.css"/>
</head>
<body>
	<div id="title"></div>
    
    <div id="main">        
        <div id="topic">预订会议室</div>
        <s:form action="add" method="post">
           
            <div class="field">
                <div class="label">会议室:</div>
                <div class="editor">
                	<s:property value="room.name"/> 
                	<s:hidden name="room.id"/>
                </div>            
            </div>
           
            <div class="field">
                <div class="label">预订日期:</div>
                <div class="editor">
                	<s:property value="reserveDate"/>
                	<s:hidden name="reserveDate"/>
                </div>            
            </div>
			
			<div class="field">
                <div class="label">预订时间:</div>
                <div class="editor">
                	<s:property value="beginTime"/>:00-<s:property value="endTime"/>:00
                	<s:hidden name="beginTime"/>
                	<s:hidden name="endTime"/>
                </div>            
            </div>
                       
            <div class="field">
                <div class="label">预订人:</div>
                <div class="editor">
                	<s:textfield name="name" cssClass="txt"/>
                </div>            
            </div>
            <div class="err">请输入预订人</div>
            
            
            <div class="field">                
                <div class="buttons">
                    <input type="submit" value="预订"/>
                    <input type="reset" value="重置"/>                
                </div>            
            </div>                
        </s:form>    	
    </div>
   	<div id="foot">
    	&copy;2016&nbsp;通州北大青鸟
    </div>
</body>
</html>
