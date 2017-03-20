<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'upload.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
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
            timer = setTimeout("window.location.href='upload.jsp'", duration);
            interval();
        }

	</script>

  </head>
  

   <body>
    <h1>文件上传失败，长度超出限制</h1>
    ${exeption.message}
    <span id="jumphint"><h1>系统在<span id="timeout"></span>秒后将自动返回</h1></span>

  </body>
</html>
