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
    
    <div class="fw_section blue_section">
    	
        <div class="fw_section_content">
    
            <a href="wangzhanmethod!contentlist.action?leixing=1"><h2>热点新闻</h2></a>
           <table>
           <c:forEach items="${list1}" var="bean">
           <tr>
           <td width="80%">
           <a href="wangzhanmethod!contentupdate3.action?id=${bean.id }">
            <span style="font-size: 20px;">${bean.title }</span>
            </a>
            </td> 
           <td align="right" width="20%">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; ${fn:substring(bean.createtime,0, 10)}</td>
           </tr>
            </c:forEach>
           </table>
            
           
            
           
            
          
            
            
	  </div>
            
    </div> <!-- end of blue section -->
    
    <div class="fw_section green_section">
    
    	<div class="fw_section_content">
    
            <a href="wangzhanmethod!contentlist.action?leixing=3"><h2>旅游线路</h2></a>
           <table>
           <c:forEach items="${list3}" var="bean">
           <tr>
           <td width="80%">
           <a href="wangzhanmethod!contentupdate3.action?id=${bean.id }">
            <span style="font-size: 20px;">${bean.title }</span>
            </a>
            </td> 
           <td align="right" width="20%">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; ${fn:substring(bean.createtime,0, 10)}</td>
           </tr>
            </c:forEach>
           </table>
            
	  </div>
    
    </div> <!-- end of green section -->
    
    <div id="templatemo_content">
    	
        <div id="side_column">
        	
            <div class="section_w280">
            
            	<a href="wangzhanmethod!contentlist.action?leixing=2"><h3>景点介绍</h3></a>
                
              <div class="news_section">
                    	<img class="image_wrapper" src="images/templatemo_image_02.jpg" alt="image" />
                        
               </div>
                    
                    
                    
                    <table>
           <c:forEach items="${list2}" var="bean">
           <tr>
           <td width="80%">
           <a href="wangzhanmethod!contentupdate3.action?id=${bean.id }">
           <span style="font-size: 20px;"> ${bean.title }</span>
           </a>
            </td> 
           <td align="right" width="20%">${fn:substring(bean.createtime,5, 10)}</td>
           </tr>
            </c:forEach>
           </table>

            </div>
        <c:forEach items="${list6}" var="bean">
          <marquee>
          <span style="font-size: 15px;font-weight: bold;">${bean.user.username }报名参加了${bean.content.title }线路</span>
          </marquee>
        </c:forEach>
        </div>
        
        <div id="main_column">
        
        	<div class="section_w560">
        
				<a href="wangzhanmethod!contentlist.action?leixing=4"><h3>餐饮酒店</h3></a>
                    
                <img class="image_wrapper fl_image" src="images/templatemo_image_01.jpg" alt="image" />
                   
              <table>
           <c:forEach items="${list4}" var="bean">
           <tr>
           <td width="80%">
           <a href="wangzhanmethod!contentupdate3.action?id=${bean.id }">
            <span style="font-size: 20px;">${bean.title }</span>
            </a>
            </td> 
           <td align="right" width="20%">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; ${fn:substring(bean.createtime,0, 10)}</td>
           </tr>
            </c:forEach>
           </table>
                
                <div class="cleaner"></div>
        	</div>
            
            <div class="section_w560">
            
            	<a href="wangzhanmethod!contentlist.action?leixing=5"><h3>人文风采</h3></a>
            
                <table>
           <c:forEach items="${list5}" var="bean">
           <tr>
           <td width="80%">
           <a href="wangzhanmethod!contentupdate3.action?id=${bean.id }">
            <span style="font-size: 20px;">${bean.title }</span>
            </a>
            </td> 
           <td align="right" width="20%">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; ${fn:substring(bean.createtime,0, 10)}</td>
           </tr>
            </c:forEach>
           </table>
				
                <div class="cleaner_h20"></div>
                
                
              <div class="cleaner"></div>
                            
            </div>
            
            <div class="cleaner"></div>
        </div>
        
        <div class="cleaner"></div>
    </div>
    
    <%@ include file="bottom.jsp" %>
    
</div> <!-- end of container -->
</body>
</html>
