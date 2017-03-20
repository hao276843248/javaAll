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


</head>
<body  onload="createCode();">
<div id="templatemo_container">
	

	<%@ include file="head.jsp" %>
    
    
    
    
    
    <div id="templatemo_content">
    	
        <h3>我要报名:-----><a href="wangzhanmethod!contentupdate3.action?id=${content.id }">${content.title }</a></h3>
              <hr />  
              
                    
                    
                    
           <form action="wangzhanmethod!baoming2.action?contentid=${content.id }"  method="post" >
<TABLE class=sel_table border=1 cellSpacing=0 cellPadding=0 width="100%">
  <THEAD>
  <TR >
    <TH width="30%" align="right">姓名：</TH>
    <TH width="70%">
    <textarea rows="7" cols="50" name="xingming" ></textarea>
    
    </TH>
   </THEAD>
   <THEAD>
  <TR >
    <TH width="30%" align="right">联系电话：</TH>
    <TH width="70%">
    <textarea rows="7" cols="50" name="dianhua" ></textarea>
    
    </TH>
   </THEAD>
   
   <THEAD>
  <TR >
    <TH width="30%" align="right">备注：</TH>
    <TH width="70%">
    <textarea rows="7" cols="50" name="beizhu" ></textarea>
    
    </TH>
   </THEAD>
   
    
   
   <THEAD>
  <TR >
    <TH width="30%" align="right">操作：</TH>
    <TH width="70%">
    <INPUT   value=提交 type="submit"  /> 

   	&nbsp;&nbsp;&nbsp;&nbsp;
   	<INPUT  value=返回 type="button" onclick="javascript:history.go(-1)"  /> 
   					
   </THEAD>
   
   
   
  </TABLE>
  </form>
        
        
        
        
        
        <div class="cleaner"></div>
    </div>
    
    <%@ include file="bottom.jsp" %>
    
</div> <!-- end of container -->
</body>
</html>
