<%@page import="cn.hao.easybuy.controller.ControllerBean"%>
<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>后台管理 - 易买网</title>
<link rel="stylesheet" href="css/demo.css" type="text/css">
  <link rel="stylesheet" href="css/zTreeStyle/zTreeStyle.css" type="text/css">
  <script type="text/javascript" src="js/jquery-1.4.4.min.js"></script>
  <script type="text/javascript" src="js/jquery.ztree.core.min.js"></script>
  
  <script LANGUAGE="JavaScript">
   var zTreeObj;
   // zTree 的参数配置，深入使用请参考 API 文档（setting 配置详解）
  var setting = {
	data: {
		simpleData: {
			enable: true,
			idKey: "id",
			pIdKey: "pId",
			rootPId: 0
		}
	}
};
   // zTree 的数据属性，深入使用请参考 API 文档（zTreeNode 节点数据详解）
   var treeNodes = {};
   $(document).ready(function(){
      zTreeObj = $.fn.zTree.init($("#treeDemo"), setting, treeNodes);
   });
  </SCRIPT>
 </HEAD>
<BODY>
<%
	ControllerBean c=new ControllerBean();
	c.EasybuyProductCategory();
	request.setAttribute("a", c.EasybuyProductCategory());
 %>
<div>
   <ul id="treeDemo" class="ztree"></ul>
</div>
<p>${a}</p>
</BODY>
</HTML>