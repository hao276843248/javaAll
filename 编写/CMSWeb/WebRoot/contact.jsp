<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<jsp:include page="inc/scripts.jsp" />
</head>

<body>
	<!--页头开始-->
	<jsp:include page="inc/head.jsp" />
	<!--页头结束-->
	<div class="clear"></div>
	<div class="main">
		<div id="left">
			<jsp:include page="inc/guwm.jsp" />
			<jsp:include page="inc/lxnm.jsp" />
		</div>
		<!--left-->
		<div id="right">
			<div class="position">
				<span>您的位置：<a href="index.html">首页&nbsp;></a>联系我们</span>联系我们
			</div>
			<div class="web_box">
				<div class="content">
					<p>地 址：东莞市石碣镇新风西路271号旭阳高科科技园</p>
					<p>电 话：0769-89229908</p>
					<p>传 真：0769-88739965</p>
					<p>联系人：李先生 15916825563</p>
					<p>业务邮箱：rongxumv@163.com</p>
					<p>技术邮箱：rxmvtech@163.com</p>
					<p>主 页：www.rxmv.net</p>
					<p>主 营：机器视觉检测系统、线材颜色检 测系统、机器视觉光源的生产等</p>
				</div>
				<!--content end-->
			</div>
		</div>
	</div>
	<!--页脚开始-->
	<jsp:include page="inc/foot.jsp" />
	<!--页脚结束-->
</body>
</html>
