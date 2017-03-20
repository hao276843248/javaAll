<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'index.jsp' starting page</title>
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<link rel="stylesheet" type="text/css" href="js/themes/default/easyui.css" id="cssTheme"/>
	<link rel="stylesheet" type="text/css" href="js/themes/icon.css"/>
	
	<script src="js/jquery.min.js"></script>
	<script src="js/jquery.easyui.min.js"></script>
	<script src="js/locale/easyui-lang-zh_CN.js"></script>
  </head>
  
  <body>
  	<!-- 布局 -->
    <div class="easyui-layout" data-options="fit:true">
    	<!-- 左边栏(搜索条件) -->
    	<div data-options="region:'west',title:'搜索条件',width:190">
    		<form id="frmSearch">
    			<table width="100%" id="tblSearch">
    				<tr>
    					<td><select id="cmbBrand" name="brandId"></select></td>
    				</tr>
    			</table>
    		</form>
    	</div>
    	<!-- 中栏(主体部分) -->
    	<div data-options="region:'center',title:'结果'">
    	</div>
    </div>
    
    
    <script type="text/javascript">
    <!--
    	$(function(){
    		alert("s")
    		$("#cmbBrand").combobox({
    			width:160,
    			url:"listBrand.action",
    			valueField:"id",
    			textField:"name",
    			editable:false
    		});
    	
    	
    	});
    -->
    </script>
    
   </body>
</html>








