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
<body>
<div id="templatemo_container">
	

	<%@ include file="head.jsp" %>
    
    
    
    
    
    <div id="templatemo_content">
    	
        <h3>线路报名列表:-----><a href="wangzhanmethod!contentupdate3.action?id=${content.id }">${content.title }</a></h3>
              <hr />  
              
                    
                    
                    
           <table >
           <c:forEach items="${list}" var="bean">
           <tr>
           <td width="30%">
          
           <span style="font-size: 20px;"> ${bean.xingming }</span>
           
            </td> 
            <td width="30%">
          
           <span style="font-size: 20px;"> ${bean.user.username }</span>
           
            </td> 
            <td width="20%">
          
           <span style="font-size: 20px;"> ${bean.zhuangtai }</span>
           
            </td> 
           <td align="right" width="10%">
          &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
           ${fn:substring(bean.createtime,0, 10)}</td>
           </tr>
            </c:forEach>
            
            <tr>
           <td colspan="2">
          ${pagerinfo }
            </td> 
          
           </tr>
           </table>
        
        
        
        
        
        <div class="cleaner"></div>
    </div>
    
    <%@ include file="bottom.jsp" %>
    
</div> <!-- end of container -->
</body>
</html>
