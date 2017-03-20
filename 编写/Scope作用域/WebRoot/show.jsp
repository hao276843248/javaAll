<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<h1>Show.jsp</h1>
<%--输出页面作用域中的数据--%>
<%=pageContext.getAttribute("value")%><br/>
<%--输出请求作用域中的数据--%>
<%=request.getAttribute("value")%><br/>
<%--输出会话作用域中的数据--%>
<%=session.getAttribute("value")%><br/>
<%--输出应用程序作用域中的数据--%>
<%=application.getAttribute("value")%><br/>