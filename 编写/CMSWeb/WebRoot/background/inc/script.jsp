<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<title>青鸟CMS</title>
<link rel="stylesheet" type="text/css" href="<%=path%>/css/style.css"/>
<script src="<%=path%>/js/util.js"></script>