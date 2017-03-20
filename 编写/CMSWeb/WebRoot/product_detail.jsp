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
<!--点击弹开JQ-->
<link rel="stylesheet" href="css/slimbox.css" type="text/css"
	media="screen" />
<script type="text/javascript" src="js/mootools.js"></script>
<script type="text/javascript" src="js/slimbox.js"></script>
</head>

<body>
	<!--页头开始-->
	<jsp:include page="inc/head.jsp" />
	<!--页头结束-->
	<div class="clear"></div>
	<div class="main">
		<div id="left">
			<jsp:include page="inc/category.jsp" />
			<jsp:include page="inc/lxnm.jsp" />
		</div>
		<!--left-->
		<div id="right">
			<div class="position">
				<span>您的位置：<a href="index.jsp">首页&nbsp;></a>蚀刻工艺</span>机器视觉检测设备
			</div>
			<div class="web_box">
				<jsp:include page="get">
					<jsp:param value="${param.id}" name="id" />
					<jsp:param name="include" value="true" />
				</jsp:include>
				<div class="content">
					<div class="all-list">
						<div class="left_img">
							<a href="${c.pic}" rel="lightbox[]"><img
								src="${c.pic}" width="240" height="180" />
							</a><br />
							<font color="#0570A7"><strong>注：点击上图可查看大图</strong>
							</font>
						</div>
						<div class="w_right">
							<div class="title">${c.title}</div>
							<div class="intro">
								${c.content}
							</div>
						</div>
					</div>
					<!--all-list-->
					<dl class="bottom_e ">
						<dt class="title">产品信息</dt>
						<dd class="products">
							<p>东莞市腾旭五金制品有限公司成立于2000年，是专业生产加工精密金属元件的加工制造与贸易相结合的工贸高新科技企业。公司现拥有先进的自动化光电蚀刻工艺生产线。</p>
							<p>公司拥有四条先进的蚀刻生产线及ISO9001:2008的品质管控体系，产品广泛应用于：家电、电子通讯、精密五金、医疗、石油化工、军工、精密工
								程应用元件 等行业，能足客户临时的和超大量的订单，日蚀刻面积达1000平方
								米，月生产能力达5000万只（片）{视产品类型而定}。在质量管控方面，公司拥
								有一批敬岗爱业的专业技术人员，各道工序专人把关，确保产品质量能达到....</p>
						</dd>
					</dl>
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
