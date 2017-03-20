<%@page import="cn.bdqn.el.entity.User"%>
<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'Show.jsp' starting page</title>
    
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
  	<% 
  		//向页面范围存入数据
  		//pageContext.setAttribute("msg","存在页面作用域中的数据");
  		//向请求作用域中存入数据
  		//request.setAttribute("msg","存在请求作用域中的数据");
  		//向请求作用域中存入数据
  		//session.setAttribute("msg","存在会话作用域中的数据");
  		//向请求作用域中存入数据
  		application.setAttribute("msg","存在应用程序作用域中的数据");
  		
  		//创建User对象，存入请求作用域
  		User user=new User(1,"admin","123456");
  		request.setAttribute("user",user);
  		
  		//创建Map集合，存入请求作用域
  		Map<String,String> map=new HashMap<String,String>();
  		map.put("user-name","tom");
  		map.put("password","123456");
  		
  		request.setAttribute("map",map);
  		request.setAttribute("str","");
  		request.setAttribute("nums",new ArrayList());
  		
  	%>
  
  	<%--获取客户端提交的数据--%>
    ${param.userName}<br/>
    ${paramValues.hobby[0]}
    ${paramValues.hobby[1]}
    ${paramValues.hobby[2]}
    ${paramValues.hobby[3]}
    <br/>
    <%--获取作用域中的数据--%>
    <%--
    ${pageScope.msg}<br/>
    ${requestScope.msg}<br/>
    ${sessionScope.msg}<br/>
    ${applicationScope.msg}<br/>
    --%>
    ${msg}
    <br/>
    <%--获取cookie中的数据 --%>
    ${cookie.msg.value}
    <br/>
    <%--输出对象属性--%>
    ${requestScope.user["name"]}<br/>
    ${requestScope.user.password}<br/>
    <%--如果属性名或者键包含特殊符号，则必须使用[]形式访问--%>
    ${requestScope.map["user-name"]}<br/>
    ${requestScope.map.password}<br/>
    <%--使用empty运算符判断空 --%>
    ${empty requestScope.admin?"不存在admin":"存在admin"}<br/>
    ${empty requestScope.str}<br/>
    ${empty requestScope.nums}<br/>
    <br/>
  </body>
</html>








