<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<%
	request.setCharacterEncoding("UTF-8");
	String username=request.getParameter("username");
	String password=request.getParameter("password");
	String email=request.getParameter("email");
	out.println(username);
	out.println(password);
	out.println(email);
%>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>无标题文档</title>
<script type="text/javascript">
        var duration = 5000;
        var timer = null;
        var endTime = new Date().getTime() + duration;
        function interval() {
            var n = (endTime - new Date().getTime()) / 1000;
            if (n < 0) return;
            document.getElementById("timeout").innerHTML = n.toFixed(0);
            setTimeout(interval, 10);
        }
        function stopJump() {
            clearTimeout(timer);
            document.getElementById("jumphint").style.display = "none";
        }
        window.onload = function() {
            timer = setTimeout("window.location.href='index.jsp'", duration);
            interval();
        };
</script>
</head>

<body>
<span id="jumphint" font-size=63px>系统在<span id="timeout"></span>秒后将自动返回</span>
</body>
</html>