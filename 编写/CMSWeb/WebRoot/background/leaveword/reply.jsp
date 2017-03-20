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
		<span>当前位置:后台--留言管理--回复留言</span>
	</div>
	<div id="shadow"></div>
	<form>
	
	
	<table width="100%" border="0">		
		<tr class="fitem">
			<td class="flabel">用户昵称</td>
			<td class="ftxt">昵称昵称昵称昵称</td>
		</tr>
		<tr class="fitem">
			<td class="flabel">留言时间</td>
			<td class="ftxt">21-10-14 14:03:16</td>
		</tr>
		<tr class="fitem">
			<td class="flabel" >联系电话</td>
			<td class="ftxt">21-10-14 14:03:16</td>
		</tr>
		<tr class="fitem">
			<td class="flabel" >企业名称</td>
			<td class="ftxt">21-10-14 14:03:16</td>
		</tr>
		<tr class="fitem">
			<td class="flabel" >公司地址</td>
			<td class="ftxt">21-10-14 14:03:16</td>
		</tr>
		<tr class="fitem">
			<td class="flabel" valign="top">留言内容</td>
			<td class="finput">
				<textarea readonly="readonly" style="width:600px;height:100px;padding:0px;" class="txt">留言内容留言内容留言内容留言内容</textarea>
			</td>
		</tr>
		<tr class="fitem">
			<td class="flabel" valign="top">回复内容</td>
			<td class="finput">
				<textarea name="content" style="width:600px;height:200px;padding:0px;" class="txt"></textarea>
			</td>
		</tr>
		<tr class="ferror">
			<td></td>
			<td>错误信息</td>
		</tr>		
		<tr class="fitem">
			<td class="flabel"></td>
			<td class="finput">
				<input type="submit" value="保存回复" class="btn"/>
				<input type="checkbox" value="true"/>显示留言 
			</td>
		</tr>
	</table>

	
	</form>

</body>
</html>
