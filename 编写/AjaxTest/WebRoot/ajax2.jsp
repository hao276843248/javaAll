<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'ajax.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
	<script type="text/javascript">
		//创建异步对象
		function createXMLHttpRequest(){
			try { 
				return new XMLHttpRequest(); //大多数浏览器
			}catch (e) {
				try{
					return new ActiveXObject("Msxml2.XMLHTTP");//IE6.0
				}catch (e) {
					try {
						return new ActiveXObject("Microsoft.XMLHTTP");//IE5.5
					}catch (e) {
						alert("你用的浏览器不支持");
						throw e;
					}
				}
			}
		}
		window.onload=function(){//文档加载完毕后加载
			var btn=document.getElementById("btn");
			btn.onclick=function(){//给按钮的点击事件注册监听器
				/*
					ajax 的四步操作，得到服务器响应
					把响应结果显示到H1元素中
				*/
				//1.得到异步对象
				var xmlHttp = createXMLHttpRequest();
				//2.打开服务器连接
				
				xmlHttp.open("GET","<c:url value='/AServlet' />",true);
			
				//3.发送请求
				xmlHttp.send(null);//GET请求没有请求体，但也要给出Null，否则FireFox可能不能发送
				//4.给异步对象的onreadystatechange事件注册监听器
				xmlHttp.onreadystatechange = function(){
					//双重判断：xmlHttp的状态为4，以及服务器响应的状态码为200
					
					if(xmlHttp.readyState  == 4 && xmlHttp.status == 200){
						//获取服务器响应结束
						var text = xmlHttp.responseText;
						//获取h1元素
						var h1= document.getElementById("h1");
						h1.innerHTML = text;
					};
				};
			};
		};
	</script>
  </head>
  
  <body>
    <button  id="btn">点击这里</button>
    <h1 id="h1"></h1>
   <c:url value='/AServlet'/>
  </body>
</html>
