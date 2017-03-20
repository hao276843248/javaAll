<%@page import="cn.bdqn.book.entity.Book"%>
<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>无标题文档</title>
<link rel="stylesheet" type="text/css" href="../css/style.css"/>
</head>

<body>
<jsp:include page="/inc/head.jsp" />
<div id="wrap">
	<form  method="post" enctype="multipart/form-data">		
		<input type="hidden" name="id" value="${book.id}"/>
    	<table width="100%">
        	<tr>
            	<td width="100" class="label">标题</td>
                <td width="300">
                	<input type="text" name="title" class="text" value="${book.title}"/>                    
                </td>
                <td>
                	<div class="err">请输入标题</div>
                </td>
            </tr>
            <tr>
            	<td width="100" class="label">作者</td>
                <td>
                	<input type="text" name="author" class="text" value="${book.author}"/>
                </td>
                <td>
                	<div class="err"></div>
                </td>
            </tr>
            <tr>
            	<td width="100" class="label">出版社</td>
                <td>
                	<jsp:include page="publishers"/>
                	<select name="publisherId">
                		<c:forEach items="${publishers}" var="publisher">
                		<option value="${publisher.id}" ${book.publisher.id==publisher.id?"selected='selected'":""}>
                			${publisher.name}
                		</option>                		
                		</c:forEach>
                	</select>
                </td>
				<td>
                	<div class="err"></div>
                </td>                
            </tr>
            <tr>
            	<td width="100" class="label">定价</td>
                <td>
                	<input type="text" name="price" class="text" value="${book.price}"/>
                </td>
				<td>
                	<div class="err"></div>
                </td>                
            </tr>
            <tr>
            	<td width="100" class="label">图片</td>
                <td>
                	<input type="file" name="pic" class="text"/>
                </td>
				<td>
                	<div class="err"></div>
                </td>                
            </tr>
            <tr>
            	<td width="100" class="label"></td>
                <td>
                	<input type="submit" value="修改"/>
                	<input type="reset" value="重置"/>                    
					<input type="button" value="返回" onclick="location.href='index.html'"/>                    
                </td>
            </tr>
        </table>
        </form>
    </div>
</body>
</html>
