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
<jsp:include page="inc/scripts.jsp"/>
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
    	<jsp:include page="inc/news_menu.jsp"/>
    	<!--新闻资讯导航菜单结束-->        
        <!--联系我们开始-->
        <jsp:include page="inc/contact.jsp"/>
    	<!--联系我们结束-->
    </div>
	<!--左边栏结束-->    
	<!--右边栏开始-->    
    <div id="right">
    	<jsp:include page="list">
    		<jsp:param name="include" value="true"/>
    		<jsp:param name="pageSize" value="10"/>
    	</jsp:include>
    	
    	<div class="position"><span>您的位置：<a href="index.html">首页&nbsp;></a>${p.results[0].categoryName}</span>新闻资讯</div>
        <div class="web_box">	
        	<!--内容列表开始-->        	
            <div class="content">
             <ul class="news">
             <c:forEach items="${p.results}" var="content">
              <li><a href="new_detail.jsp?id=${content.id}"><span><fmt:formatDate value="${content.addTime}" pattern="yy-MM-dd"/></span>${content.title}</a></li>
             </c:forEach> 
           	</ul>
           <DIV id=pagerMain class=apage>
           	  <c:choose>
           	  	<c:when test="${p.pageIndex>1}">
           	  		<a href="news.jsp?categoryId=${param.categoryId}&pageIndex=1" title="首页">首页</a> 
              		<a href="news.jsp?categoryId=${param.categoryId}&pageIndex=${p.pageIndex-1}" title="上一页">上一页</a>
           	  	</c:when>
           	  	<c:otherwise>
           	  		<font color=#999999 title="首页">首页</font>               
              		<font color=#999999 title="上一页"> 上一页</font> 
           	  	</c:otherwise>
           	  </c:choose>
           
           	  <c:forEach begin="1" end="${p.pageCount}" var="i">
           	  	<c:choose>
           	  		<c:when test="${i==p.pageIndex}"><b>${i}</b></c:when>
           	  		<c:otherwise>
           	  			<a href="news.jsp?categoryId=${param.categoryId}&pageIndex=${i}">${i}</a>
           	  		</c:otherwise>
           	  	</c:choose>           	  
           	  </c:forEach>           	  
              
              <c:choose>
           	  	<c:when test="${p.pageIndex<p.pageCount}">
           	  		<a href="news.jsp?categoryId=${param.categoryId}&pageIndex=${p.pageIndex+1}" title="下一页">下一页</a> 
              		<a href="news.jsp?categoryId=${param.categoryId}&pageIndex=${p.pageCount}" title="尾页">尾页</a>
           	  	</c:when>
           	  	<c:otherwise>
           	  		<font color=#999999 title="下一页">下一页</font>               
              		<font color=#999999 title="尾页">尾页</font> 
           	  	</c:otherwise>
           	  </c:choose>
              
              <b>${p.pageSize}</b>条/页，<b><span class="tx">${p.pageIndex}</span>/${p.pageCount}</b>，共<b><span id='recordcount'>${p.rowCount}</span></b>条
              </DIV>
           </div>
        	<!--内容列表结束-->           
      </div>
    </div>
	<!--右边栏结束->    
</div>
<!--主体结束-->
<!--页脚开始-->
<jsp:include page="inc/foot.jsp" />
<!--页脚结束-->
</body>
</html>
