<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<DIV id=pagerMain class=apage>
           <c:choose>
           	  	<c:when test="${p.pageIndex>1}">
           	  		<a href="news.jsp?cid=${param.cid}&pageIndex=1" title="首页">首页</a> 
              		<a href="news.jsp?cid=${param.cid}&pageIndex=${p.pageIndex-1}" title="上一页">上一页</a>
           	  	</c:when>
           	  	<c:otherwise>
           	  		<font color=#999999 title="首页">/首页</font>               
              		<font color=#999999 title="上一页"> 上一页</font> 
           	  	</c:otherwise>
           	</c:choose>
           	 <c:forEach begin="1" end="${p.pageCount}" var="i">
           	  	<c:choose>
           	  		<c:when test="${i==p.pageIndex}"><b>${i}</b></c:when>
           	  		<c:otherwise>
           	  			<a href="news.jsp?cid=${param.cid}&pageIndex=${i}">${i}</a>
           	  		</c:otherwise>
           	  	</c:choose>
           	  </c:forEach>           	  
              <c:choose>
           	  	<c:when test="${p.pageIndex<p.pageCount}">
           	  		<a href="news.jsp?cid=${param.cid}&pageIndex=${p.pageIndex+1}" title="下一页">下一页</a> 
              		<a href="news.jsp?cid=${param.cid}&pageIndex=${p.pageCount}" title="尾页">尾页</a>
           	  	</c:when>
           	  	<c:otherwise>
           	  		<font color=#999999 title="下一页">下一页</font>               
              		<font color=#999999 title="尾页">尾页</font> 
           	  	</c:otherwise>
           	  	</c:choose>
               <b>${p.pageSize}</b>条/页，<b><span class="tx">${p.pageIndex}</span>/${p.pageCount}</b>，共<b><span id='recordcount'>${p.rowCount}</span></b>条
              </DIV>