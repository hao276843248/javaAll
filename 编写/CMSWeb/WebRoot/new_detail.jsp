<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
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
			<jsp:include page="inc/xwzx.jsp" />
			<jsp:include page="inc/lxnm.jsp" />
		</div>
		<!--left-->
		<div id="right">
		<jsp:include page="get">
			<jsp:param value="${param.id}" name="id" />
			<jsp:param name="include" value="true" />
		</jsp:include>
			<div class="position">
				<span>您的位置：<a href="index.jsp">首页&nbsp;></a>${c.cname}</span>新闻资讯
			</div>
			<div class="web_box">
				<div class="content">
					<div class="c-top">
						<div class="title">${c.title}</div>
						<div class="time">更新时间：<fmt:formatDate value="${c.addtime}" pattern="yyyy-MM-dd"/> </div>
					</div>
					<!--c-top end-->
					<div class="clear"></div>
					<div class="contents">
						${c.content}
					</div>
					<!--content end-->
					<div class="pagenav">
						<dl>
							<jsp:include page="preContent"/>
				          	<jsp:include page="nextContent"/>
				          	
				          	<c:if test="${preContent!=null}">	
				            <dd class="s"><strong>上一篇：</strong><a href="new_detail.jsp?id=${preContent.id}">${preContent.title}</a></dd>
				            </c:if>
				            
				            <c:if test="${nextContent!=null}">
				            <dd class="x"><strong>下一篇：</strong><a href="new_detail.jsp?id=${nextContent.id}">${nextContent.title}</a></dd>
				          	</c:if>
						</dl>
					</div>
					<!--pagenav end-->
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
