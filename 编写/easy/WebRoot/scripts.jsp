<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<title>易买网 - 首页</title>
<link type="text/css" rel="stylesheet" href="<%=path%>/css/style.css" />
<!-- <script type="text/javascript" src="scripts/function.js"></script> -->
<script type="text/javascript" src="<%=path%>/js/jquery-1.11.1.js"></script>
<script src="<%=path%>/js/My97DatePicker/WdatePicker.js"></script>

<link rel="stylesheet" href="<%=path%>/demoStyle/demo.css" type="text/css">
  <link rel="stylesheet" href="<%=path%>/zTreeStyle/zTreeStyle.css" type="text/css">
  <script type="text/javascript" src="<%=path%>/jquery-1.4.2.js"></script>
  <script type="text/javascript" src="<%=path%>/jquery.ztree.core-3.x.js"></script>