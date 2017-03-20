<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="/struts-tags" prefix="s" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>无标题文档</title>
<link rel="stylesheet" type="text/css" href="style.css"/>
<script src="js/My97DatePicker/WdatePicker.js"></script>
</head>
<body>
<div id="head">
	<jsp:include page="/inc/head.jsp" />
	<div id="right">
		<ul>
			
		</ul>
	</div>	
	<form action="add" method="post" enctype="multipart/form-data" >
	<table style="clear:both;">
    	<s:hidden value="id"/>
		<tr>
			<td>姓名</td>
			<td>
				<s:textfield name="name" />		
			</td>			
			<td></td>
		</tr>
		<tr>
			<td>性别</td>
			<td>
				<s:radio list="#{'男':'男','女':'女'}" name="gender"/>
			</td>			
			<td></td>
		</tr>
		<tr>
			<td>生日</td>
			<td>
				<s:textfield name="brithday" cssClass="txt Wdate" onclick="WdatePicker({skin:'ext',readOnly:true})"/>
			</td>			
			<td></td>
		</tr>
		<tr>
       		<td>头像</td>
                <td>
                	<s:file name="upload" cssClass="file"/> 
                </td>
                <td>
                	<div class="err"></div>
                </td>
           </tr>    	
		<tr>
			<td></td>
			<td>
				<input type="submit" value="提交"/>
			</td>			
			<td></td>
		</tr>						
	</table>
	</form>
</div>
</body>
</html>

