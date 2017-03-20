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
	
	<style>
		#tblSearch{text-align:center;}
	</style>
	
	<script src="js/jquery.min.js"></script>
	<script src="js/jquery.easyui.min.js"></script>
	<script src="js/locale/easyui-lang-zh_CN.js"></script>
  </head>
  
  <body>
  	<!-- 布局 -->
    <div class="easyui-layout" data-options="fit:true">
    	<!-- 左边栏(搜索条件) -->
    	<div data-options="region:'west',title:'搜索条件',width:190,split:true">
    		<form id="frmSearch">
    			<table width="100%" id="tblSearch">
    				<tr>
    					<td><select id="cmbBrand" name="brandId"></select></td>
    				</tr>
    				<tr>
    					<td><select id="cmbType" name="typeId"></select></td>
    				</tr>
    				<tr>
    					<td><select id="cmbPrice" name="maxPrice"></select></td>
    				</tr>
    				<tr>
    					<td><select id="cmbPixel" name="maxPrice"></select></td>
    				</tr>
    				<tr>
    					<td><input id="title" type="text" name="title" style="width:160px;" title="请输入标题关键字" /></td>
	    			</tr>
	    			<tr>
	    				<td>
	    					<a id="btnSearch" class="easyui-linkbutton" data-options="iconCls:'icon-search',width:160">搜索</a>
	    				</td>
	    			</tr>
	    			<tr>
	    				<td>
	    					<a id="btnReset" class="easyui-linkbutton" data-options="iconCls:'icon-reload',width:160">重置</a>
	    				</td>
	    			</tr> 
    			</table>
    		</form>
    	</div>
    	<!-- 中栏(主体部分) -->
    	<div data-options="region:'center',title:'结果'">
    		<table id="dgCamera" class="easyui-datagrid" >
    			<thead>
    				<tr>
    					<th data-options="field:'image',formatter:imageFmt">图片</th>
    					<th data-options="field:'title',width:600">标题</th>
    					<th data-options="field:'brand',width:100,formatter:brandFmt">品牌</th>
	    				<th data-options="field:'types',width:70,formatter:typeFmt">类型</th>	    				
	    				<th data-options="field:'price',width:70,sortable:true">价格</th>
	    				<th data-options="field:'pixel',width:70,sortable:true">像素数</th>
	    				<th data-options="field:'zoom',width:70,sortable:true,formatter:zoomFmt">变焦倍数</th>	
    				</tr>
    			</thead>
    		</table>
    	</div>
    </div>
    
    <script type="text/javascript">
    <!--
    	$(function(){
    		//创建品牌下拉列表组件
    		$("#cmbBrand").combobox({
    			width:160,
    			url:"listBrand.action",
    			valueField:"id",
    			textField:"name",
    			editable:false
    		});
    		//创建分类下拉列表组件
    		$("#cmbType").combobox({
    			width:160,
    			url:"listType.action",
    			valueField:"id",
    			textField:"name",
    			editable:false
    		});
    		//创建价格下拉列表
    		$("#cmbPrice").combobox({
    			width:160,
    			valueField:"value",
    			textField:"label",
    			data:[
    				{label:"全部价格",value:"0"},
    				{label:"1000元以下",value:"1000"},
    				{label:"3000元以下",value:"3000"},
    				{label:"5000元以下",value:"5000"},
    				{label:"10000元以下",value:"10000"},
    				{label:"20000元以下",value:"20000"}
    			],
    			value:"0",
    			editable:false
    		});
    		//创建像素数下拉列表
    		$("#cmbPixel").combobox({
    			width:160,
    			valueField:"value",
    			textField:"label",
    			data:[
    				{label:"全部像素数",value:"0"},
    				{label:"800万以上",value:"800"},
    				{label:"1000万以上",value:"1000"},
    				{label:"1200万以上",value:"1200"},
    				{label:"1500万以上",value:"1500"},
    				{label:"2000万以上",value:"2000"}    				
    			],
    			value:"0",
    			editable:false
    		});
    		
    		//重置按钮点击事件
    		$("#btnReset").linkbutton({
    			onClick:function(){
    				$("#frmSearch").form("reset");
    			}
    		});
    		
    		$("#dgCamera").datagrid({
    			url:"listCamera.action",
    			pagination:true,
    			singleSelect:true
    		})
    		
    	});
    	
    	//图片列格式化函数
    	function imageFmt(value){
    		return "<img src='images/product/"+value+"' width='60' height='40'/>";
    				
    	}
    	//品牌列格式化函数
    	function brandFmt(value){
    		return value.name;
    	}
    	//类型列格式化函数
    	function typeFmt(value){
    		return value.name;
    	}
    	//变焦倍数列格式化函数
    	function zoomFmt(value){
    		if(value==-1){
    			return "视镜头而定"
    		}
    		else if(value=="0"){
    			return "无光学变焦";
    		}
    		else{
    			return value;
    		}
    	}
    	//搜素按钮点击事件
    	$("#btnSearch").click(function(){
    		var brandId=$("#cmbBrand").combobox("getValue");
    		var typeId=$("#cmbType").combobox("getValue");
    		var maxPrice=$("#cmbPrice").combobox("getValue");
    			var minPixel=$("#cmbPixel").combobox("getValue");
    			var title=$("#title").val();    			
    			$("#dgCamera").datagrid({
    				pageNumber:1,
    				sortName:"id",
    				sortOrder:"asc",
    				queryParams:{
    					brandId:brandId,
    					typeId:typeId,
    					maxPrice:maxPrice,
    					minPixel:minPixel,
    					title:title
    				}
    			}); 
    	});
    	
    -->
    </script>
    
   </body>
</html>


