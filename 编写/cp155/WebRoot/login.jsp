<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>旅游网站</title>
<meta name="keywords" content="travel website, free CSS, web templates" />
<meta name="description" content="Travel Site - free website template from www.865171.cn" />
<link href="templatemo_style.css" rel="stylesheet" type="text/css" />
<script language="javascript" type="text/javascript">
function clearText(field)
{
    if (field.defaultValue == field.value) field.value = '';
    else if (field.value == '') field.value = field.defaultValue;
}
</script>
<script language="javascript" type="text/javascript"> 
		
		
		var code ; //在全局 定义验证码
function createCode(){ 
code = "";
var codeLength = 4;//验证码的长度
var checkCode = document.getElementById("checkCode");
checkCode.value = "";

var selectChar = new Array(2,3,4,5,6,7,8,9,'A','B','C','D','E','F','G','H','J','K','L','M','N','P','Q','R','S','T','U','V','W','X','Y','Z');

for(var i=0;i<codeLength;i++) {
   var charIndex = Math.floor(Math.random()*32);
   code +=selectChar[charIndex];
}
if(code.length != codeLength){
   createCode();
}
checkCode.value = code;
}
		
		

		function checkregisterform(){
		
		var inputCode = document.getElementById("input1").value.toUpperCase();

if(inputCode.length <=0) {
   alert("请输入验证码！");
   return false;
}
else if(inputCode != code ){
   alert("验证码输入错误！");
   createCode();
   return false;
		
		
		
}
	 
	 if (document.getElementById('usernameid').value=="")
	{
		alert("用户名不能为空");
		return false;
	}
	

	if (document.getElementById('passwordid').value=="")
	{
		alert("密码不能为空");
		return false;
	}
	
	
	
	return true;
	
}




	</script>

</head>
<body  onload="createCode();">
<div id="templatemo_container">
	

	<%@ include file="head.jsp" %>
    
    
    
    
    
    <div id="templatemo_content">
    	
        <h3>用户登录</h3>
              <hr />  
              
                    
                    
                    
           <form action="wangzhanmethod!login2.action" onsubmit="return checkregisterform()" method="post" >
<TABLE class=sel_table border=1 cellSpacing=0 cellPadding=0 width="100%">
  <THEAD>
  <TR >
    <TH width="30%" align="right">用户名：</TH>
    <TH width="70%"><input type="text" name="username" size="45"  id="usernameid"/></TH>
   </THEAD>
   
    <THEAD>
  <TR >
    <TH width="30%" align="right">密码：</TH>
    <TH width="70%" ><input type="password" name="password" size="45" id="passwordid"/></TH>
   </THEAD>
   
  
   
    <THEAD>
  <TR >
    <TH width="30%" align="right">请输入验证码：</TH>
    <TH width="70%"><input type="text" id="input1" size="45"/></TH>
   </THEAD>
   
   <THEAD>
  <TR >
    <TH width="30%" align="right">验证码：</TH>
    <TH width="70%"><input type="text" id="checkCode" class="code" style="width: 55px" size="20" readonly="readonly"/> <a href="####" onclick="createCode()">看不清楚</a></TH>
   </THEAD>
   
   <THEAD>
  <TR >
    <TH width="30%" align="right">操作：</TH>
    <TH width="70%">
    <INPUT class=list-yd  value=提交 type="submit"  /> 

   	&nbsp;&nbsp;&nbsp;&nbsp;
   	<INPUT class=list-yd  value=返回 type="button" onclick="javascript:history.go(-1)"  /> 
   					
   </THEAD>
   
   
   
  </TABLE>
  </form>
        
        
        
        
        
        <div class="cleaner"></div>
    </div>
    
    <%@ include file="bottom.jsp" %>
    
</div> <!-- end of container -->
</body>
</html>
