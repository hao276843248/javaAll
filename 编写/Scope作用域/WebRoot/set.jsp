<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<%
	//向页面作用域存入数据
	pageContext.setAttribute("value","页面作用域中的数据");
	//向请求作用域存入数据
	request.setAttribute("value","请求作用域中的数据");
	//向会话作用域存入数据
	session.setAttribute("value","会话作用域中的数据");
	//向应用程序作用域存入数据
	application.setAttribute("value","应用程序作用域中的数据");
	
	
	//转发到show.jsp
	//request.getRequestDispatcher("show.jsp").forward(request,response);
	//重定向到show.jsp
	response.sendRedirect("show.jsp");
%>


<%--输出页面作用域中的数据--%>
<%=pageContext.getAttribute("value")%><br/>
<%--输出请求作用域中的数据--%>
<%=request.getAttribute("value")%><br/>
<%--输出会话作用域中的数据--%>
<%=session.getAttribute("value")%><br/>
<%--输出应用程序作用域中的数据--%>
<%=application.getAttribute("value")%><br/>





