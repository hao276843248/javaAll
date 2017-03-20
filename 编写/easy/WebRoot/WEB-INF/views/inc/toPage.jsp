<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core"  prefix="c" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<div class="pager">
				<ul class="clearfix">
					<c:if test="${p.pageIndex>1}">
                    <li><a href="javascript:toPage(1)">首页</a></li>
                    <li><a href="javascript:toPage(${p.pageIndex-1})">上页</a></li>        
                    </c:if>
                   	<c:forEach begin="1" end="${p.pageCount}" var="i">
           	  			<c:choose>
	           	  			<c:when test="${i==p.pageIndex}"><li class="current">${i}</li></c:when>
	           	  			<c:otherwise>
	           	  			<li><a href="javascript:toPage(${i})">${i}</a></li>
	           	  			</c:otherwise>
           	  			</c:choose>
           	 		</c:forEach>  
                    <c:if test="${p.pageIndex<p.pageCount}">    
                   	<li><a href="javascript:toPage(${p.pageIndex+1})">下页</a></li>
                   	<li><a href="javascript:toPage(${p.pageCount})">尾页</a></li>                  
                    </c:if>
				</ul>
			</div>