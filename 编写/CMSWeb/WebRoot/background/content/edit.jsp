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
<jsp:include page="../inc/script.jsp" />
<script src="<%=path %>/js/ckeditor/ckeditor.js">
</script>
</head>
<body>
	<jsp:include page="../inc/head.jsp"/>
	<div id="shadow"></div>
	
	<div class="path">
		<span>当前位置:后台--内容管理--添加内容</span>
	</div>
	<div id="shadow"></div>
	<form action="update" method="post">
	<table width="100%" border="0">
		<tr class="fitem">
			<td class="flabel">分类</td>
			<td class="finput">
				<jsp:include page="/background/category/list">
					<jsp:param value="true" name="include"/>
				</jsp:include>
				<select name="cid" class="btn">
					<option value="">请选择分类</option>
					<c:forEach items="${cate}" var="category">
					<option value="${category.id}" ${c.cid==category.id?"selected='selected'":"" }>${category.name}</option>
					</c:forEach>					
				</select>
			</td>
		</tr>
		<tr class="ferror">
			<td></td>
			<td>${err_cid}</td>
		</tr>
		<tr class="fitem">
			<td class="flabel">标题</td>
			<td class="finput">
				<input type="text" name="title" class="txt" style="width:600px;" value="${c.title}"/>
			</td>
		</tr>
		<tr class="ferror">
			<td></td>
			<td>${err_title}</td>
		</tr>
		<tr class="fitem">
			<td class="flabel">链接</td>
			<td class="finput">
				<input type="text" name="link" class="txt" style="width:600px;" value="${c.link}"/>
			</td>
		</tr>
		<tr class="ferror">
			<td></td>
			<td></td>
		</tr>
		<tr class="fitem">
			<td class="flabel" valign="top">内容</td>
			<td class="finput">
				<textarea name="content" id="ar1" style="width:600px;height:300px;padding:0px;" class="txt" >${c.content}</textarea>
				<script>
					CKEDITOR.replace("content",
							{width:600}
					);
				</script>

			</td>
		</tr>
		<tr class="ferror">
			<td></td>
			<td>${err_content}</td>
		</tr>
		<tr class="fitem">
			<td class="flabel">图片</td>
			<td class="finput">
				<input type="text" name="pic" class="txt" style="width:500px;" value="${c.pic}"/>
				<br/>
				<iframe src="upload.jsp" width="602" height="26" frameborder="0" scrolling="no"></iframe>
			</td>
		</tr>

		<tr class="ferror">
			<td></td>
			<td></td>
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
