<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
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
/>
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
			<jsp:include page="list">
				<jsp:param value="${param.cid}" name="cid" />
				<jsp:param name="include" value="true" />
				<jsp:param value="10" name="pageSize" />
			</jsp:include>
			<div class="position">
				<span>您的位置：<a href="index.jsp">首页&nbsp;></a>人才招聘</span>人才招聘
			</div>
			<div class="web_box">
				<div class="content">
					<ul class="news">
						<c:forEach items="${cs}" var="c">
							<li><a href="zhao_detail.jsp?id=${c.id}"><span><fmt:formatDate
											value="${c.addtime}" pattern="yyyy-MM-dd" /> </span>${c.title}</a>
							</li>
						</c:forEach>
					</ul>
					<!-- pageMain -->
					<jsp:include page="inc/pagerMain.jsp" />
					<!-- pageEnd -->
				</div>
			</div>
		</div>
	</div>
	<!--页脚开始-->
	<jsp:include page="inc/foot.jsp" />
	<!--页脚结束-->
</body>
</html>
