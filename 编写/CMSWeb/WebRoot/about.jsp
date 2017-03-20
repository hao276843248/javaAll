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
				<span>您的位置：<a href="index.jsp">首页&nbsp;></a>公司简介</span>关于我们
			</div>
			<div class="web_box">
				<div class="content">
					<p>东莞市荣旭自动化科技有限公司成立于2010年，于2014年3月乔迁至东莞市石碣镇-旭阳高科科技园，正式成为UAG集团公司成员，厂房建筑面积达3200平方米。</p>
					<p>联合UAG集团公司，专业从事机器视觉设备研发与生产、非标自动化设备设计与制造、机器视觉系统研发等工业自动化应用领域研发与制造。全体员工80%以上都是大学以上学历，具有多年丰富实践工作经验的影像处理软件开发工程师(10人)、光学工程师（4人）、电气工程(6人)、机械设计工程师（8人）、系统应用工程师（10）、加工与装配（15）、其它等高科技人才共60人，竭诚为您提供全方位、全领域、全自动的技术与服务。</p>
				</div>
				<!--content end-->
			</div>
		</div>
	</div>
	<jsp:include page="inc/foot.jsp" />
</body>
</html>

