<%@page import="java.text.SimpleDateFormat"%>
<%@page import="cn.hao.book.entity.Book"%>
<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath }/static/style.css"/>
<title>无标题文档</title>
<script>
	function toPage(i){
		document.getElementById("pageIndex").value=i;
		document.getElementById("frmSearch").submit();
	}
</script>
</head>
<body>
	<jsp:include page="/inc/head.jsp" />
	<div id="wrap">
		<table width="100%">
			<tr>
				<td align="left">
					<form  method="post" id="frmSearch">
					<input type="hidden" name="pageIndex" id="pageIndex"/>
						<table>
							<tr>
								<td>
									<input type="text" name="title" value="${param.title}"/>
								</td>
								<td>
									<input type="button" value="搜索" onclick="toPage(1)"/>
								</td>
							</tr>
						</table>
					</form>
				</td>
				<td align="right">
					<input type="button" value="退出登录" onclick="location.href='${pageContext.request.contextPath}/logout'"/>
					<input type="button" value="添加图书" onclick="location.href='${pageContext.request.contextPath}/manage/ADD.jsp'"/>
				</td>
			</tr>
		</table>
    	<table width="100%" cellpadding="0" cellspacing="0" id="books">
        	<tr id="thead">
        		<td width="50">图片</td>
            	<td width="150">标题</td>
            	<td width="150">作者</td>
            	<td width="150">出版社</td>
            	<td width="100">出版日期</td>
            	<td width="50">定价</td>
                <td width="50">操作</td>
            </tr>
           
            	<c:forEach var="a" items="${p.result}" varStatus="x">
            	<tr class="book" <c:if test="${x.index%2==0}">bgcolor="dbf5c2"</c:if> >
	            	<td><img src="upload/${a.pic}" width="50"/></td>
	            	<td><a href="#">${a.title}</a></td>
	            	<td>${a.author}</td>
	            	<td>${a.publisher.name}</td>
	            	<td><fmt:formatDate value="${a.pubdate}" pattern="yyyy年MM月dd日"/> </td>
	            	<td>${a.price}</td>
	                <td>
	                	<a href="${pageContext.request.contextPath}/manage/update?id=${a.id}">编辑</a>
	                    <a href="${pageContext.request.contextPath}/manage/delete?id=${a.id}">删除</a>
	                </td>                                                
          		</tr>  
            	</c:forEach>
            	
            
        </table>
        <table width="100%" cellpadding="0" cellspacing="0" id="books">
        	<tr class="book">
            	<td align="left">
            		<c:if test="${p.pageIndex>1}">
                 		<a href="javascript:toPage(1)">首页</a> 
                    	<a href="javascript:toPage(${p.pageIndex-1})">上页</a> 
                    </c:if>
                    <c:if test="${p.pageIndex<p.pageCount}">
                    <a href="javascript:toPage(${p.pageIndex+1})">下页</a> 
                    <a href="javascript:toPage(${p.pageCount})">尾页</a>
                    </c:if>
                </td>
            	<td align="right">第${p.pageIndex}页 共${p.pageCount}页   每页显示${p.pageSize}条 共${p.rowCount}条</td>                                  
            </tr>
        </table>
    </div>
    

</body>
</html>
