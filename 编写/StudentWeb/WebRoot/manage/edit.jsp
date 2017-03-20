<%@page import="entity.Student"%>
<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
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
</head>
<body>
<div id="head">
	<jsp:include page="/inc/head.jsp" />
	<div id="right">
		<ul>
			
		</ul>
	</div>	
	<form action="edit" method="post" enctype="multipart/form-data" >
	<table style="clear:both;">
    	<input type="hidden" name="id" value="${s.id}"/>
		<tr>
			<td>年级</td>
			<td>
				<select name="nianji">
					<option>请选择年级</option>
					<option value="S1" <c:if test="${s.nianji=='S1'}">selected="selected"</c:if>>S1</option>
					<option value="S2" <c:if test="${s.nianji=='S2'}">selected="selected"</c:if>>S2</option>
					<option value="Y2" <c:if test="${s.nianji=='Y2'}">selected="selected"</c:if>>Y2</option>
				</select>			
			</td>			
			<td></td>
		</tr>
		<tr>
			<td>姓名</td>
			<td>
				<input type="text" name="name" value="${s.name}"/>			
			</td>			
			<td></td>
		</tr>
		<tr>
			<td>性别</td>
			<td>
				<input type="radio" name="sex" value="男"<c:if test="${s.gender=='男'}">checked="checked"</c:if>/>男
				
				<input type="radio" name="sex" value="女"<c:if test="${s.gender=='女'}">checked="checked"</c:if>/>女
				
			</td>			
			<td></td>
		</tr>
		<tr>
			<td>密码</td>
			<td>
				<input type="password" name="password" value="${s.mima}"/>			
			</td>			
			<td></td>
		</tr>
		<tr>
			<td>确认密码</td>
			<td>
				<input type="password" name="repwd" value="${s.mima}" />				
			</td>			
			<td></td>
		</tr>
		<tr>
			<td>电话</td>
			<td>
				<input type="text" name="phone"value="${s.dianhua}"/>
			</td>			
			<td></td>
		</tr>
		<tr>
			<td>地址</td>
			<td>
				<input type="text" name="address" value="${s.dizhi}"/>
			</td>			
			<td></td>
		</tr>
		<tr>
			<td>生日</td>
			<td>
				<input type="text" name="birthday" value="${s.shengri}"/>
			</td>			
			<td></td>
		</tr>
		<tr>
       		<td>头像</td>
                <td>
                	<input type="file" name="pic" class="text" />
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

