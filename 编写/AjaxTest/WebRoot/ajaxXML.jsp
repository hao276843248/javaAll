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
			var h1= document.getElementById("h1");
			btn.onclick=function(){//给按钮的点击事件注册监听器
				if(h1.textContent!=""){
					h1.innerHTML="";
				}else{
						
				/*
					ajax 的四步操作，得到服务器响应
					把响应结果显示到H1元素中
				*/
				//1.得到异步对象
				var xmlHttp = createXMLHttpRequest();
				//2.打开服务器连接
				/************修改post方法，指定请求方式为psot*****************/
				xmlHttp.open("GET","<c:url value='/XML' />",true);
				/************设置请求头：Content-Type*****************/
				//xmlHttp.setRequestHeader("Content-Type","application/x-www-form-urlencoded");
				//3.发送请求
				/************发送是指定请求体*****************/
				xmlHttp.send(null);//GET请求没有请求体，但也要给出Null，否则FireFox可能不能发送
				//4.给异步对象的onreadystatechange事件注册监听器
				
				xmlHttp.onreadystatechange = function(){
					//双重判断：xmlHttp的状态为4，以及服务器响应的状态码为200
		
					if(xmlHttp.readyState  == 4 && xmlHttp.status == 200){
						//获取服务器响应结果（xml）
						var doc = xmlHttp.responseXML;
						//查询文档下名为student的所有元素，得到数组，再取下标0元素
						var ele=doc.getElementsByTagName("student")[0];
						
						var number=ele.getAttribute("number");//获取名为number的属性值
						var name;
						var age;
						var sex;
						if(window.addEventListener){
							name=ele.getElementsByTagName("name")[0].textContent;//其它浏览器支持
							age=ele.getElementsByTagName("age")[0].textContent;//其它浏览器支持
							sex=ele.getElementsByTagName("sex")[0].textContent;//其它浏览器支持
						}else{
							name=ele.getElementsByTagName("name")[0].text;//IE支持
							age=ele.getElementsByTagName("age")[0].text;//IE支持
							sex=ele.getElementsByTagName("sex")[0].text;//IE支持
						}
						
						var text=number+"-"+name+"-"+age+"-"+sex;
						//获取h1元素
						
						h1.innerHTML = text;
						
					};
				};
				};
			
			};
		};
	</script>
  </head>
  
  <body>
    <button  id="btn">点击这里</button>
    <h1 id="h1"></h1>
   <c:url value='/XMLServlet'/>
  </body>
</html>
