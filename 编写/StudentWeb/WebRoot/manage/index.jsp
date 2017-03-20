<%@page import="java.text.SimpleDateFormat"%>
<%@page import="entity.Student"%>
<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt"  prefix="fmt"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>主页</title>
<link rel="stylesheet" type="text/css" href="style.css"/>
<style type="text/css">
input{
	
	width:80px;
	height:35px;
}
</style>
<script>
	function toPage(i){
		document.getElementById("pageIndex").value=i;
		document.getElementById("frmSearch").submit();
	}
</script>
</head>
<body>
<div id="head">
	<jsp:include page="/inc/head.jsp" />
	<div id="right">
		<ul>
		</ul>
	</div>
</div>	
    	<input  type="button" value="添加" onclick="location.href='add.jsp'"/>
    	<input type="button" value="退出登录" onclick="location.href='../logout'"/>
    		<table style="margin:0 auto;"id="shanglist" width="80%" cellpadding="0" cellspacing="0" border="1px">
				<tr>
					<th width="60" align="center" >头像</th>
                    <th width="80" align="center" >姓名</th>
                    <th width="50"	align="center">性别</th>
                    <th width="50"	align="center">年级</th>
                    <th width="50"	align="center">电话</th>
                    <th width="70" 	align="center">生日</th>
                    <th width="70" 	align="center">地址</th>
                    <th width="50"	align="center">操作</th>	
				</tr>
				<c:forEach items="${p.result}" varStatus="x"  var="ss"> 
                <tr <c:if test="${x.index%2==0}">style="background-color: #D3C3C3"</c:if> >
                	<td><img src="upload/${ss.pic}" width="50" /></td>
                    <td width="80" align="center">${ss.name}</td>
                    <td width="50"	align="center">${ss.gender}</td>
                    <td width="50"	align="center">${ss.nianji}</td>
                    <td width="50"	align="center">${ss.dianhua}</td>
                    <td width="70" 	align="center"><fmt:formatDate value="${ss.shengri}" pattern="yyyy年MM月dd日"/></td>
                    <td width="70" 	align="center">${ss.dizhi}</td>
                    <td width="50" align="center">
                    <a href="edit?id=${ss.id}">修改</a>
                    <a href="delete?id=${ss.id}">删除</a>				
                    </td>															
				</tr>
				</c:forEach>
				
			</table>
			 <table  style="margin:0 auto;"id="shanglist" width="80%" cellpadding="0" cellspacing="0" border="1px">
        	<tr class="book">
            	<td >
            		<c:if test="${p.pageIndex>1}">
                 		<a href="show?pageIndex=1">首页</a> 
                    	<a href="show?pageIndex=${p.pageIndex-1}">上页</a> 
                    </c:if>
                    <c:if test="${p.pageIndex<p.pageCount}">
                    <a href="show?pageIndex=${p.pageIndex+1}">下页</a> 
                    <a href="show?pageIndex=${p.pageCount}">尾页</a>
                    </c:if>
                </td>
            	<td >第${p.pageIndex}页 共${p.pageCount}页   每页显示${p.pageSize}条 共${p.rowCount}条</td>                                  
            </tr>
        </table>


</body>
</html>

