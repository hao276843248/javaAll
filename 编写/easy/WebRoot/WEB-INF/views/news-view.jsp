<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
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
	您现在的位置：<a href="index.html">易买网</a> &gt; 阅读新闻   
</div>
<div id="main" class="wrap">
	<div class="left-side">
		<div class="news-list">
			<h4>最新留言</h4>
				<c:forEach items="${commentFind.results}" var="commentFind">
					<ul>
						<li><a href="guestbook.html" target="_blank">${commentFind.ecContent}</a></li>
					</ul>
				</c:forEach>
		</div>
		<div class="spacer"></div>
		<div class="news-list">
			<h4>新闻动态</h4>
				<c:forEach items="${news.results}" var="news">
					<ul>
						<li><a href="news-view_${news.enId}.html" >${news.enTitle}</a></li>
					</ul>
				</c:forEach>
		</div>
	</div>
	<div id="news" class="right-main">
		<h1>${newssss.enTitle}</h1>
		<div class="content">
			${newssss.enContent}
		</div>
	</div>
	<div class="clear"></div>
</div>
<jsp:include page="inc/foot.jsp" />
</body>
</html>
