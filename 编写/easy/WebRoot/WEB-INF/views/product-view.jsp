<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>


<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<jsp:include page="inc/scripts.jsp" />
</head>
<body>
<jsp:include page="inc/header.jsp" />
<jsp:include page="inc/childNav.jsp" />
<div id="position" class="wrap">
	您现在的位置：<a href="index.html">易买网</a> &gt; <a href="product-list_${id}.html">${product.easybuyProductCategory.epcName}</a> &gt;${product.easybuyProductCategory.epcName}
</div>
<div id="main" class="wrap">
	<div class="lefter">
	<jsp:include page="inc/cpfl.jsp"/>
	</div>
	<div id="product" class="main">
		<h1>${product.epName}</h1>
		<div class="infos">
			<div class="thumb"><img src="images/product/${product.epFileName}" width=250px height=250px /></div>
			<div class="buy">
				<p>商城价：<span class="price">￥${product.epPrice}</span></p>
				<p>库　存：${product.epStock != 0 ? "有货":"无货"}</p>
				<p>商品名：${product.epName}</p>
				<div class="button"><input type="button" name="button" value="" onclick="goBuy(1)" /><a href="#">放入购物车</a></div>
			</div>
			<div class="clear"></div>
		</div>
		<div class="introduce">
			<h2><strong>商品详情</strong></h2>
			<div class="text">
				${product.epDescription}
			</div>
		</div>
	</div>

	<div class="clear"></div>
</div>
<jsp:include page="inc/foot.jsp" />
</body>
</html>
