<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<jsp:include page="../inc/script.jsp" />
</head>
<body>
	<jsp:include page="../inc/head.jsp"/>
	<div id="shadow"></div>
	
	<div class="path">
		<span>当前位置:后台--分类管理--修改分类</span>
	</div>
	<div id="shadow"></div>
	<form action="update" method="post">
	<input type="hidden" name="id" value="${c.id}"/>
	<table width="100%" border="0">
		<tr class="fitem">
			<td class="flabel">分类名</td>
			<td class="finput">
				<input type="text" name="name" class="txt" value="${c.name}"/>
			</td>
		</tr>
		<tr class="ferror">
			<td></td>
			<td>${err_name }</td>
		</tr>
		<tr class="fitem">
			<td class="flabel"></td>
			<td class="finput">
				<input type="submit" value="保存分类" class="btn"/>
			</td>
		</tr>
	</table>
	</form>

</body>
</html>
