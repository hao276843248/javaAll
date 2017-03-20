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
    
    <title>My JSP 'ajax3333.jsp' starting page</title>
    
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
		window.onload =function(){
			var name=document.getElementById("name");
			name.onblur=function(){
				var xmlHttp=createXMLHttpRequest();
				
				xmlHttp.open("POST","<c:url value='/yanzheng' />",true);
				
				xmlHttp.setRequestHeader("Content-Type","application/x-www-form-urlencoded");
		
				var a=name.value;
				xmlHttp.send("h=" + a);
				
				xmlHttp.onreadystatechange = function(){
				
					if(xmlHttp.readyState==4 && xmlHttp.status==200 ){
						var text=xmlHttp.responseText;
						//获取服务器响应，判断是否为1  是则获取span，添加内容为“用户已注册”
						var span = document.getElementById("err");
						
						if(text==1){
							span.innerHTML="用户已存在，请更换！";
						}else{
							span.innerHTML="";
						};
					};
				};
			};
		};
	</script>

  </head>
  
  <body>
    <h1>演示用户名是否被注册</h1>
    <form action="" method="post">
    	用户名：<input type="text" name="name" id="name" /><span id="err"></span><br/>
    	密	码：<input type="password" id="password" name="password"/><br/>
    		  <input type="button" value="注册"/>	
    </form>
    <c:url value='/yanzheng' />
  </body>
</html>
