<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<jsp:include page="../inc/scripts.jsp"/>
<script src="<%=path%>/js/ckeditor/ckeditor.js"></script>
</head>
<body>
	<jsp:include page="../inc/head.jsp"/>
	<div id="shadow"></div>
	
	<div class="path">
		<span>当前位置:后台--内容管理--添加内容</span>
	</div>
	<div id="shadow"></div>
	<form action="add" method="post">
	
	
	<table width="100%" border="0">
		<tr class="fitem">
			<td class="flabel">分类</td>
			<td class="finput">
				<jsp:include page="/background/category/list">
					<jsp:param value="true" name="include"/>
				</jsp:include>
				<select name="categoryId" class="btn">
					<option value="">请选择分类</option>
					<c:forEach items="${categorys}" var="category">
					<option value="${category.id}">${category.name}</option>
					</c:forEach>					
				</select>
			</td>
		</tr>
		<tr class="ferror">
			<td></td>
			<td>错误信息</td>
		</tr>
		<tr class="fitem">
			<td class="flabel">标题</td>
			<td class="finput">
				<input type="text" name="title" class="txt" style="width:600px;"/>
			</td>
		</tr>
		<tr class="ferror">
			<td></td>
			<td>错误信息</td>
		</tr>
		<tr class="fitem">
			<td class="flabel">链接</td>
			<td class="finput">
				<input type="text" name="link" class="txt" style="width:600px;"/>
			</td>
		</tr>
		<tr class="ferror">
			<td></td>
			<td>错误信息</td>
		</tr>
		<tr class="fitem">
			<td class="flabel" valign="top">内容</td>
			<td class="finput">
				<textarea name="content" id="content" style="width:600px;height:300px;padding:0px;" class="txt"></textarea>
				<script>
					CKEDITOR.replace(
						"content",
						{
							skin:"moono",
							width:600
						}						
					);
				</script>
			</td>
		</tr>
		<tr class="ferror">
			<td></td>
			<td>错误信息</td>
		</tr>
		<tr class="fitem">
			<td class="flabel">图片</td>
			<td class="finput">
				<input type="text" class="txt" name="pic" style="width:500px;"/>
				<br/>
				<iframe src="upload.jsp" width="602" height="26" frameborder="0" scrolling="no"></iframe>
			</td>
		</tr>

		<tr class="ferror">
			<td></td>
			<td>错误信息</td>
		</tr>
		<tr class="fitem">
			<td class="flabel"></td>
			<td class="finput">
				<input type="submit" value="保存内容" class="btn"/>
			</td>
		</tr>
	</table>

	
	</form>

</body>
</html>
