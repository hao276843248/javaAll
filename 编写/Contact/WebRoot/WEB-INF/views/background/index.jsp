<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core"  prefix="c" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<jsp:include page="../inc/scripts.jsp"/>
<script>
	function toPage(i){
		document.getElementById("pageIndex").value=i;
		document.getElementById("frmSearch").submit();
	}
</script>
</head>
<body>
	<div id="wrap">
        <jsp:include page="../inc/head.jsp"/>   
        <div id="topic">
        	<div id="tlabel">联系人列表</div>
        	<jsp:include page="../inc/oper.jsp" />          
        </div>
        <div id="search">
        	<div id="search-left">
            	<form:form  method="post" id="frmSearch" modelAttribute="searchForm">
            		<input type="hidden" name="pageIndex" id="pageIndex"/>
            		<form:select path="groupId" items="${group}" itemValue="id" itemLabel="name" cssClass="sel"></form:select>	
                    <form:input path="name"/>
                    <input type="button" value="搜索" onclick="toPage(1)"/>
                    <a href="export.html">导出通讯录</a>
                </form:form>
            </div>
        	<div id="search-right">
            	<a href="add.html">添加联系人</a>
            </div>            
        </div>
        <div id="head">
        	<div class="row-wrap">
                <div class="c1">姓名</div>
                <div class="c2">性别</div>  
                <div class="c3">头衔</div>    
                <div class="c3">分组</div>
                <div class="c4">电话</div> 
                <div class="c4">操作</div>    	             
            </div>
        </div>
     
        <c:forEach items="${p.results}" var="contact">
        
        <div class="row">
        	<div class="row-wrap">
                <div class="c1">
                	${contact.name}          
                </div>
                <div class="c2">${contact.sex}</div>  
                <div class="c3">${contact.title}</div>    
                <div class="c3">${contact.group.name}</div>
                <div class="c4">${contact.phone}</div> 
                <div class="c4">
                	<a href="update_${contact.id}.html">编辑</a>
                	<a href="delete_${contact.id}.html">删除</a>
                </div>    	             
            </div>
        </div>

        </c:forEach>
        <div id="pagenav">
        	<div class="row-wrap">
                <div id="nav1">
                	<c:if test="${p.pageIndex>1}">
                    <a href="javascript:toPage(1)">首页</a>
                    <a href="javascript:toPage(${p.pageIndex-1})">上页</a>        
                    </c:if>
                    
                    <c:if test="${p.pageIndex<p.pageCount}">    
                    <a href="javascript:toPage(${p.pageIndex+1})">下页</a>
                    <a href="javascript:toPage(${p.pageCount})">尾页</a>                  
                    </c:if>     
                </div>
                <div id="nav2">
                    第${p.pageIndex}页
                    共${p.pageCount}页
                    每页${p.pageSize}条
                    共${p.rowCount}条
                </div>   
            </div>     
        </div>
        
    </div>    
</body>
</html>

