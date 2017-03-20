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
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
	<script type="text/javascript" src="js/jquery-1.11.1.js"></script>
	<script type="text/javascript">
	<!--
	$(function(){
	
		$.get("list.action",function(regions){
			for(var i=0;i<regions.length;i++){
				var option=$("<option>",{value:regions[i].id,text:regions[i].name});
				$("#sheng").append(option);
			}
		});
		
		$("#sheng").change(function(){
			$("#xian option:gt(0)").remove();
			$("#shi option:gt(0)").remove();
			var id=$(this).val();
			$.get("list.action",{parentId:id},function(regions){
				for(var i=0;i<regions.length;i++){
					var option=$("<option>",{value:regions[i].id,text:regions[i].name});
					$("#shi").append(option);
				}
			});
		});
		
		$("#shi").change(function(){
			var id=$(this).val();
			$("#xian option:gt(0)").remove();
			$.get("list.action",{parentId:id},function(regions){
				for(var i=0;i<regions.length;i++){
					var option=$("<option>",{value:regions[i].id,text:regions[i].name});
					$("#xian").append(option);
				}
			});
		});
			
		
		
	
	
	
	});
		
		
		
	-->
	</script>
  </head>
  
  <body>
    <select id="sheng">
    	<option value="">请选择省</option>
    </select>
    <select id="shi">
    	<option value="">请选择市</option>
    </select >
    <select id="xian">
    	<option value="">请选择区县</option>
    </select>
  </body>
</html>
