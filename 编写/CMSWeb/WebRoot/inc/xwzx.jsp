<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<div class="menu">
            <h2>新闻资讯</h2>
            <ul class="part">
                <li><a href="news.jsp?cid=9">公司动态</a></li>
                <li><a href="news.jsp?cid=10">业界动态</a></li>
                <li><a href="news.jsp?cid=11">技术支持</a></li>
             </ul>
        </div><!--menu-->