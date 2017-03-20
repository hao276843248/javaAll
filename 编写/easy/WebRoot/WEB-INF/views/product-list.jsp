<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
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
	您现在的位置：<a href="index.html">易买网</a> &gt; <a href="product-list_${id}.html">${product.results[0].easybuyProductCategory.epcName}</a> &gt;${product.results[0].easybuyProductCategory.epcName}
</div>
<div id="main" class="wrap">
	<div class="lefter">
			<jsp:include page="inc/cpfl.jsp"/>
		<div class="spacer"></div>
		<div class="last-view">
			<h2>最近浏览</h2>
			<dl class="clearfix">
				<dt><img src="images/product/0_tiny.gif" /></dt>
				<dd><a href="product-view.html">法国德菲丝松露精品巧克力500g/盒</a></dd>
				<dt><img src="images/product/0_tiny.gif" /></dt>
				<dd><a href="product-view.html">法国德菲丝松露精品巧克力500g/盒</a></dd>
			</dl>
			<script type="text/javascript">
				document.write("Cookie中记录的购物车商品ID："+ getCookie("product") + "，可以在动态页面中进行读取");
			</script>
		</div>
	</div>
	<div class="main">
		<div class="product-list">
			<h2>全部商品</h2>
			<div class="clear"></div>
			<ul class="product clearfix">
			<c:forEach items="${product.results}" var="product1" >
					<li>
						<dl>
							<dt><a href="product-view_${product1.epId}.html" target="_blank"><img src="images/product/${product1.epFileName}" /></a></dt>
							<dd class="title"><a href="product-view_${product1.epId}.html" target="_blank">${product1.epName}</a></dd>
							<dd class="price">${product1.epPrice}</dd>
						</dl>
					</li>
			</c:forEach>
			</ul>
			<div class="clear"></div>
			<jsp:include page="inc/toPage.jsp" />
			
			<form:form  id="frmSearch" action="product-list_${id}">
				<input type="hidden" name="id" value="${id}" />
				<input type="hidden" name="pageIndex"  />
			</form:form>
		</div>
	</div>
	<div class="clear"></div>
</div>
<jsp:include page="inc/foot.jsp" />
</body>
</html>
