<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'test.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->

  </head>
  
  <body>
  <c:set var="b" value="111" scope="page"></c:set>
  <c:choose>
  	<c:when test="${b>50&&b<90}">50-90</c:when>
  	<c:when test="${b>90}">90></c:when>
  	<c:otherwise>--aaaaa</c:otherwise>
  </c:choose>
  <br/>
  
   <c:if test="${true}">asd</c:if><br/>
  <% String[] a={"a","b","c"}; pageContext.setAttribute("a", a);%>
  <c:forEach items="${a}" var="a" varStatus="x">
  下标${x.index}，
  第${x.count}个元素，
  ${a}<br/>
  </c:forEach>
  </body>
</html>
