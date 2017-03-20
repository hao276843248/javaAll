<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
	<div class="menu">
            <h2>产品分类</h2>
            <ul class="part">
                <li><a href="products.jsp?cid=1">机器视觉检测设备</a></li>
                <li><a href="products.jsp?cid=2">专用光学检测设备</a></li>
                <li><a href="products.jsp?cid=3">机器视觉光源</a></li>
                <li><a href="products.jsp?cid=4">光源控制器</a></li>
                <li><a href="products.jsp?cid=5">图像采集卡</a></li>
                <li><a href="products.jsp?cid=6">工业相机</a></li>
                <li><a href="products.jsp?cid=7">工业镜头</a></li>
                <li><a href="products.jsp?cid=8">其 它</a></li>
             </ul>
        </div><!--menu-->