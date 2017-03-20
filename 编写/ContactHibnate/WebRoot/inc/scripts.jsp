<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<title>青鸟通讯录</title>
<link href="<%=path%>/style/style.css" rel="stylesheet" type="text/css"/>
<script src="<%=path%>/js/My97DatePicker/WdatePicker.js"></script>