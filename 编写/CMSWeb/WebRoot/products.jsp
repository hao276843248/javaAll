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
<!--页头开始-->
<jsp:include page="inc/head.jsp" />
<!--页头结束-->
<div class="clear"></div>
<div class="main">
	<div id="left">
    	<jsp:include page="inc/category.jsp" />
        <jsp:include page="inc/lxnm.jsp" />
    </div><!--left-->
    <div id="right">
     	<jsp:include page="list">
    		<jsp:param value="${param.cid}" name="cid"/>
    		<jsp:param name="include" value="true"/>
    		<jsp:param value="10" name="pageSize"/>
    	</jsp:include>
    	<div class="position"><span>您的位置：<a href="index.html">首页&nbsp;></a>${cs[0].cname}</span>产品中心</div>
        <div class="web_box">
                     	<div class="content">
                           <ul class="products">
                                <c:forEach items="${cs}" var="c">
                                <li> <a href="product_detail.jsp?id=${c.id}"><img src="${c.pic}" width="160" height="120" alt="" /></a><span><a href="#">${c.title}</a></span></li>
                                </c:forEach>
                            </ul>
                            <!-- pageMain -->
                            <jsp:include page="inc/pagerMain.jsp" />
                             <!-- pageEnd -->
                       </div><!--content end-->
                  </div>
    </div>
</div>
<!--页脚开始-->
<jsp:include page="inc/foot.jsp" />
<!--页脚结束-->
</body>
</html>
