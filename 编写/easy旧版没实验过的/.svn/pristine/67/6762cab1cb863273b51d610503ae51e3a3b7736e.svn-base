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
<jsp:include page="inc/scripts.jsp" />
<script>
	function toPage(i){
		document.getElementById("pageIndex").value=i;
		document.getElementById("frmSearch").submit();
	}
</script>
</head>
<body>
<jsp:include page="inc/header.jsp" />
<jsp:include page="inc/childNav.jsp" />
<div id="position" class="wrap">
	您现在的位置：<a href="index.html">易买网</a> &gt; 在线留言
</div>
<div id="main" class="wrap">
	<div class="lefter">
		<jsp:include page="inc/cpfl.jsp"/>
	</div>
	<div class="main">
		<div class="guestbook">
			<h2>全部留言</h2>
			<ul>
				<c:forEach items="${commentFind.results}" var="comment">
					<li>
						<dl>
							<dt>${comment.ecContent}</dt>
							<dd class="author">网友：${comment.ecNickName} <span class="timer">${comment.ecCreateTime}</span></dd>
							<dd>${comment.ecReply}</dd>
						</dl>
					</li>
				</c:forEach>
			</ul>
			<div class="clear"></div>
			
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
			<div id="reply-box">
			<form:form  method="post" id="frmSearch" modelAttribute="comment">
			<form:hidden path="pageIndex" id="pageIndex"/>
					<table>
						<tr>
							<td class="field">昵称：</td>
							<td><form:input path="guestName" class="text" /></td>
						</tr>
						
						<tr>
							<td class="field">留言内容：</td>
							<td><form:textarea path="guestContent"></form:textarea></td>
						</tr>
						<tr>
							<td></td>
							<td><label class="ui-blue"><input type="submit" value="提交留言" /></label></td>
						</tr>
					</table>
				</form:form>
			</div>
		</div>
	</div>
	<div class="clear"></div>
</div>
<jsp:include page="inc/foot.jsp" />
</body>
</html>
