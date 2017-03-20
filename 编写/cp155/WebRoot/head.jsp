<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>


<div id="templatemo_menu">
    	<ul>
            <li><a href="." >主页</a></li>
            <li><a href="wangzhanmethod!contentlist.action?leixing=1">热点新闻</a></li>
            <li><a href="wangzhanmethod!contentlist.action?leixing=2">景点介绍</a></li>
            <li><a href="wangzhanmethod!contentlist.action?leixing=3" >旅游线路</a></li>
            <li><a href="wangzhanmethod!contentlist.action?leixing=4" >餐饮酒店</a></li>
            <li><a href="wangzhanmethod!contentlist.action?leixing=5">人文风采</a></li>
            <li><a href="register.jsp">用户注册</a></li>
            <c:if test="${user==null}">
            <li><a href="login.jsp">用户登录</a></li>
            </c:if>
            <c:if test="${user!=null}">
            <li><a href="wangzhanmethod!loginout.action">用户退出</a></li>
            </c:if>
        </ul>
    </div>

	<div id="templatemo_banner">
    	
        <div id="site_title">
            <h1>
            <a href="." >
          
            	<span style="font-size: 40px;font-weight: bold;">
            	&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
            	旅游网站</span>
            </a></h1>
            <c:if test="${user!=null}">
         <marquee>  欢迎${user.username }登录本网站</marquee>
            </c:if>
            
        </div>
        
        <div id="search_box">
            <form action="wangzhanmethod!contentlist.action" method="post">
                <input type="text" value="请输入搜索关键字" name="title" size="10" id="searchfield" title="searchfield" onfocus="clearText(this)" onblur="clearText(this)" />
                <input type="submit" name="Search" value="" alt="Search" id="searchbutton" title="Search" />
            </form>
        </div>
    
    </div> <!-- templatemo_banner -->
