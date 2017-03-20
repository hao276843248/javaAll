<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
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
<!--主体开始-->
<div class="main"> 
  <!--左边栏开始-->
  <div id="left"> 
    <!--新闻资讯导航菜单开始-->
    <jsp:include page="inc/news_menu.jsp" />
    <!--新闻资讯导航菜单结束--> 
    <!--联系我们开始-->
    <jsp:include page="inc/contact.jsp" />
    <!--联系我们结束--> 
  </div>
  <!--左边栏结束--> 
  <!--右边栏开始-->
  <jsp:include page="get">
  	<jsp:param name="include" value="true"/>
  </jsp:include>
  <div id="right">
    <div class="position"><span>您的位置：<a href="index.html">首页&nbsp;></a>${content.categoryName}</span>新闻资讯</div>
    <div class="web_box">
      <div class="content">
        <div class="c-top">
          <div class="title">${content.title}</div>
          <div class="time"> 更新时间：<fmt:formatDate value="${content.addTime}" pattern="yy-MM-dd"/></div>
        </div>
        <div class="contents">
          ${content.content}
        </div>
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
      </div>
    </div>
  </div>
  <!--右边栏结束--> 
</div>
<!--主体结束--> 
<!--页脚开始-->
<jsp:include page="inc/foot.jsp" />
<!--页脚结束-->
</body>
</html>
