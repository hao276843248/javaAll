<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
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
<style type="text/css">
* {
	margin: 0;
	padding: 0;
	font-family: "微软雅黑";
}

ul {
	list-style: none;
	background: #777;
}

.nav2 {
	padding: 0;
}

.nav3 {
	padding: 0;
}

.nav1 {
	margin: 100px 0 0 100px;
	padding: 0;
}

/*设置a标签的属性  区块，宽高，下划线删除，改变默认颜色*/
.nav1 a {
	display: block;
	width: 100px;
	height: 36px;
	line-height: 36px;
	text-decoration: none;
	color: #fff;
	text-align: center;
}

.nav1 a:hover {
	background: #ffaaaa;
	color: #000;
	transition: all 1s;
}

.nav1 li {
	position: relative;
}

li {
	text-align: center;
}

.nav1 {
	width: 110px;
}

.nav1 a {
	width: 110px;
}
/*悬浮不同的nav中的li 设置不同颜色*/
.li1:hover {
	background: #999;
}

.li2:hover {
	background: #bbb;
}

.li3:hover {
	background: #aaa;
}
/*	设置绝对定位 从nav1的ul开始，相对定位是nav中的li，也就是ul的父级元素
	因为nav1的宽度是110px;所以想让nav1下的ul紧贴nav1，设置left110-px,最好是 110px;
	并且设置子元素隐藏
*/
.nav1 ul {
	position: absolute;
	left: 109px;
	top: 0;
	display: none;
}

/*就是当鼠标悬浮在li1 上面的时候，让他子元素中的 nav2 显示可见  当鼠标悬浮在nv2中的li2 上面的时候，则让他子元素中的 nav3 显示可见*/
.li1:hover .nav2 {
	background: #999;
	display: block;
}

.li2:hover .nav3 {
	background: #bbb;
	display: block;
}

/*单独设置每个nav 下的a 的宽度，以及nav 的绝对定位，*/
.haizei .li2>a {
	width: 110px;
}

.haizei .li3>a {
	width: 120px;
}

.quanyecha .li2>a {
	width: 130px;
}

.quanyecha .nav3 {
	left: 130px;
}

.quanyecha .li3>a {
	width: 140px;
}

.huoying .li2>a {
	width: 140px;
}

.huoying .li3>a {
	width: 150px;
}

.huoying .nav3 {
	left: 140px;
}

.shumabaobei .li2>a {
	width: 150px;
}

.shumabaobei .nav3 {
	left: 150px;
}

.shumabaobei .li3>a {
	width: 160px;
}

.sishen .li2>a {
	width: 120px;
}

.sishen .nav3 {
	left: 120px;
}

.sishen .li3>a {
	width: 120px;
}
</style>
<script type="text/javascript">
	//创建异步对象
	function createXMLHttpRequest() {
		try {
			return new XMLHttpRequest(); //大多数浏览器
		} catch (e) {
			try {
				return new ActiveXObject("Msxml2.XMLHTTP");//IE6.0
			} catch (e) {
				try {
					return new ActiveXObject("Microsoft.XMLHTTP");//IE5.5
				} catch (e) {
					alert("你用的浏览器不支持");
					throw e;
				}
			}
		}
	}
	window.onload = function() {//文档加载完毕后加载
		var btn = document.getElementById("btn");
		btn.onclick = function() {//给按钮的点击事件注册监听器
			/*
				ajax 的四步操作，得到服务器响应
				把响应结果显示到H1元素中
			 */
			//1.得到异步对象
			var xmlHttp = createXMLHttpRequest();
			//2.打开服务器连接
			/************修改post方法，指定请求方式为psot*****************/
			xmlHttp.open("POST", "<c:url value='/AServlet' />", true);
			/************设置请求头：Content-Type*****************/
			xmlHttp.setRequestHeader("Content-Type",
					"application/x-www-form-urlencoded");
			//3.发送请求
			/************发送是指定请求体*****************/
			xmlHttp.send("name=zhang张三san&ps=123");//GET请求没有请求体，但也要给出Null，否则FireFox可能不能发送
			//4.给异步对象的onreadystatechange事件注册监听器
			xmlHttp.onreadystatechange = function() {
				//双重判断：xmlHttp的状态为4，以及服务器响应的状态码为200

				if (xmlHttp.readyState == 4 && xmlHttp.status == 200) {
					//获取服务器响应结束
					var text = xmlHttp.responseText;
					//获取h1元素
					var h1 = document.getElementById("h1");
					h1.innerHTML = text;
				}
				;
			};
		};
	};
</script>
</head>

<body>
	<button id="btn">点击这里</button>
	<h1 id="h1"></h1>
	<c:url value='/AServlet' />

	<div class="nav">
		<ul class="nav1">
			<li class="li1 haizei"><a href="">海贼王</a>
				<ul class="nav2">
					<li class="li2"><a href="">你好，海贼</a>
						<ul class="nav3">
							<li class="li3"><a href="">你好，海贼</a></li>
						</ul>
					</li>
				</ul>
			</li>

			<li class="li1 quanyecha"><a href="">犬夜叉</a>
				<ul class="nav2">
					<li class="li2"><a href="">你好，犬夜叉</a>
						<ul class="nav3">
							<li class="li3"><a href="">你好，犬夜叉</a></li>
						</ul>
					</li>
				</ul>
			</li>

			<li class="li1 huoying"><a href="">火影忍者</a>
				<ul class="nav2">
					<li class="li2"><a href="">你好，火影忍者</a>
						<ul class="nav3">
							<li class="li3"><a href="">你好，火影忍者</a></li>
						</ul>
					</li>
				</ul>
			</li>


			<li class="li1 shumabaobei"><a href="">数码宝贝</a>
				<ul class="nav2">
					<li class="li2"><a href="">你好，数码宝贝</a>
						<ul class="nav3">
							<li class="li3"><a href="">你好，数码宝贝</a></li>
						</ul>
					</li>
				</ul>
			</li>


			<li class="li1 sishen"><a href="">死神</a>
				<ul class="nav2">
					<li class="li2"><a href="">你好，死神</a>
						<ul class="nav3">
							<li class="li3"><a href="">你好，死神</a></li>
						</ul>
					</li>
				</ul>
			</li>
		</ul>
	</div>
</body>
</html>
