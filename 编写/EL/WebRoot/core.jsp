<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%--导入JSTL的核心标签库 --%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'core.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
  </head>
  
  <body>
    <%-- 将数据存入页面作用域 --%>
    <%--<c:set var="code" value="hello,world!" scope="page"/> --%>
    <%pageContext.setAttribute("code","<h1>Hello,world!</h1>");%>
    <%-- 将页面作用域中的数据输出,自动对XML特殊字符进行转义 --%>
    <c:out value="${code}"/>
    <%-- 将页面作用域中的数据输出,不对XML特殊字符进行转义 --%>
    <c:out value="${code}" escapeXml="false"/>
    <%-- 如果EL表达式没有取出数据，则输出默认值 --%>
    <c:out value="${code}" default="Goodbye!"/>
    <%-- 移除页面作用域中的Code数据 --%>
    <c:remove var="code" scope="page"/>
    
    <c:set value="95" var="score" scope="page"/>
    <%--判断成绩是否及格 --%>
    <c:if test="${score>=60}">
    	<h1>及格了</h1>
    </c:if>
    <%--使用c:choose进行多重if判断 --%>
    <c:choose>
    	<c:when test="${score>=90}">优秀</c:when>
    	<c:when test="${score>=80}">良好</c:when>
    	<c:when test="${score>=60}">中等</c:when>
    	<c:otherwise>差</c:otherwise>
    </c:choose>
    <br/>
    <%--循环固定的次数 --%>
    <c:forEach begin="1" end="10" step="1" var="i">
    	第${i}次好好学习，天天向上<br/>
    </c:forEach>
    <%--遍历字符串数组中的每个字符串--%>
    <%
    	String[] fruits={"Apple","Banana","Orange","Mongo"};
    	pageContext.setAttribute("fruits",fruits);
    %>    
    <c:forEach items="${fruits}" var="fruit">
    	${fruit}<br/>
    </c:forEach>
    <%--在遍历过程中访问状态信息 --%>
    <c:forEach items="${fruits}" var="fruit" varStatus="s">
    	是否第一个元素:${s.first} 
    	是否最后一个元素:${s.last}
    	当前元素下标:${s.index}
    	已遍历数量:${s.count}
    	${fruit}<br/>
    </c:forEach>
  </body>
</html>




