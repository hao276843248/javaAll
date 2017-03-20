<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"  %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<jsp:include page="../inc/script.jsp" />
<script >
	function topage(i){
		document.getElementById("pageIndex").value=i;
		document.getElementById("for").submit();
	}
</script>
</head>
<body>
	<jsp:include page="../inc/head.jsp"/>
	<div id="shadow"></div>
	
	<div class="path">
		<span>当前位置:后台--内容管理</span>
	</div>
	<div id="shadow"></div>
	<form id="for" action="list" method="post">
	<input type="hidden" name="pageIndex" id="pageIndex"/> 
	<div class="oper">
		<span>
			<a href="add.jsp">+添加内容</a>
			<jsp:include page="/background/category/list">
				<jsp:param value="true" name="include"/>
			</jsp:include>
			<select name="cid" class="btn">
				<option value="">请选择分类</option>
				<c:forEach items="${cate}" var="cate">
					<option value="${cate.id}" ${param.cid==cate.id?"selected='selected'":""} >${cate.name}</option>
				</c:forEach>
			</select>
			<input type="text" name="title" value="${param.title}" title="请输入标题" onfocus="inputFocus(this)" onblur="inputBlur(this)"/>
			<input type="submit" value="搜索" onclick="topage(1)"/>
		</span>
	</div>
	<table width="100%" class="list" border="0" cellpadding="0" cellspacing="0">
		<thead>
			<tr>
				<th width="600">标题</th>
				<th width="150">分类</th>
				<th>操作</th>
			</tr>
		</thead>
		<c:forEach items="${cs}" var="c">
		<tr>
			<td>${c.title}</td>
			<td>${c.cname}</td>
			<td>
				<a href="edit.jsp?id=${c.id}">编辑</a>
				<a href="delete?id=${c.id}">删除</a>
			</td>
		</tr>
		</c:forEach>
	</table>
	</form>
	<div id="shadow"></div>
	<table width="100%">
		<tr>
			<td width="50%" align="left">
			<c:if test="${p.pageIndex>1}">
				<a href="javascript:topage(1)">首页</a>
				<a href="javascript:topage(${p.pageIndex-1})">上页</a>
			</c:if>	
			<c:if test="${p.pageIndex<p.pageCount}">
				<a href="javascript:topage(${p.pageIndex+1})">下页</a>
				<a href="javascript:topage(${p.pageCount})">尾页</a>
			</c:if>	
			</td>
			<td width="50%" align="right">
				<a href="#">第${p.pageIndex}页</a>
				<a href="#">共${p.pageCount}页</a>
				<a href="#">每页显示${p.pageSize}条</a>
				<a href="#">共${p.rowCount}条</a>
			</td>
		</tr>
	</table>
	
</body>
</html>
