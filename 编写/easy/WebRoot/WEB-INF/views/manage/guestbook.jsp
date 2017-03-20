<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>后台管理 - 易买网</title>
<link type="text/css" rel="stylesheet" href="../css/style.css" />
<script type="text/javascript" src="../scripts/function-manage.js"></script>
<script>
	function toPage(i){
		document.getElementById("pageIndex").value=i;
		document.getElementById("frmSearch").submit();
	}
</script>
</head>
<body>
<jsp:include page="../inc/manageHeader.jsp" />
<div id="main" class="wrap">
	<jsp:include page="../inc/ManageLeft.jsp" />
	<div class="main">
		<h2>留言管理</h2>
		<div class="manage">
			<table class="list">
				<tr>
					<th>ID</th>
					<th>姓名</th>
					<th>留言内容</th>
					<th>状态</th>
					<th>操作</th>
				</tr>
				<c:forEach items="${p.results}" var="com" varStatus="i">
					<tr>
						<td class="first w4 c">${com.ecId}</td>
						<td class="w1 c">${com.ecNickName}</td>
						<td>${com.ecContent}</td>
						<td class="w1 c">${com.ecReply==null? "未回复":"已回复" }</td>
						<td class="w1 c"><a href="guestbook-modify_${com.ecId}.html">回复</a> <a href="deleteCommetn_${com.ecId}.html">删除</a></td>
					</tr>
				</c:forEach>
			</table>
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
			<form:form  id="frmSearch" action="guestbook.html" method="post" methodParam="CommentForm">
				<input type="hidden" name="pageIndex"  id="pageIndex"/>
			</form:form>
		</div>
	</div>
	<div class="clear"></div>
</div>
<jsp:include page="../inc/foot.jsp" />
</body>
</html>

