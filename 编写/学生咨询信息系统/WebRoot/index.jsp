<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>无标题文档</title>
<link href="css/style.css" rel="stylesheet" type="text/css"/>
<script>
	function toPage(i){
		document.getElementById("pageIndex").value=i;
		document.getElementById("frmSearch").submit();
	}
</script>
</head>
<body>
	<div id="title">
    	<div id="logo" onclick="location.href='show'"></div>
        <div id="oper">
        	<a href="add.jsp">+添加学生</a>
        </div>
    </div>
    <form action="show" method="post" id="frmSearch">
    <div id="search">
    	
    	
			<table>
            	<tr>
                	<td class="lbl">姓名</td>
                    <td>
                    	<input type="text" name="name" class="txt" value="${tj.name}"/>
                    </td>
                	<td class="lbl">意向课程</td>
                    <td>
                    	<select name="cid">
                        <option value="0">任意</option>
                        <option value="1" <c:if test="${tj.cid==1}">selected="selected"</c:if>>ACCP</option>
                        <option value="2" <c:if test="${tj.cid==2}">selected="selected"</c:if>>BNET</option>
                        <option value="3" <c:if test="${tj.cid==3}">selected="selected"</c:if>>学士后(java)</option>
                        <option value="4" <c:if test="${tj.cid==4}">selected="selected"</c:if>>学士后(.net)</option>
                        <option value="5" <c:if test="${tj.cid==5}">selected="selected"</c:if>>启蒙星</option>                                                                                                               
                        </select>
                    </td>
                	<td class="lbl">上课时间</td>
                    <td>
                    	<select name="time">
                        	<option value="0">任意</option>
                        	<option value="1"<c:if test="${tj.time==1}">selected="selected"</c:if>>脱产</option>
                        	<option value="2"<c:if test="${tj.time==2}">selected="selected"</c:if>>业余</option>
                    	</select>
                    </td>
                	<td class="lbl">学历</td>
                    <td>
                    	<select name="eid">
                        	<option value="0">任意</option>
                        	<option value="1"<c:if test="${tj.eid==1}">selected="selected"</c:if>>小学</option>
	                        <option value="2"<c:if test="${tj.eid==2}">selected="selected"</c:if>>初中</option>
	                        <option value="3"<c:if test="${tj.eid==3}">selected="selected"</c:if>>高中</option>
	                        <option value="4"<c:if test="${tj.eid==4}">selected="selected"</c:if>>职高/技校</option>
	                        <option value="5"<c:if test="${tj.eid==5}">selected="selected"</c:if>>大专</option>
	                        <option value="6"<c:if test="${tj.eid==6}">selected="selected"</c:if>>大本</option>                                                        
	                        <option value="7"<c:if test="${tj.eid==7}">selected="selected"</c:if>>研究生</option>
	                        <option value="8"<c:if test="${tj.eid==8}">selected="selected"</c:if>>硕士</option>                                                        
	                        <option value="9"<c:if test="${tj.eid==9}">selected="selected"</c:if>>博士</option>
	                        <option value="10"<c:if test="${tj.eid==10}">selected="selected"</c:if>>博士后</option>                                                                                                                
	                    </select>
                    </td> 
                    <td class="lbl">状态</td>
                    <td>
                    	<select name="state">
                        	<option value="0" ${param.state==0?"selected='selected'":""}>任意</option>
                        	<option value="1" ${param.state==1?"selected='selected'":""}>跟进中</option>
                        	<option value="2" ${param.state==2?"selected='selected'":""}>已缴费</option>
                        	<option value="3" ${param.state==3?"selected='selected'":""}>已放弃</option>
                        </select>
                    </td>
                    <td>
                    	<input type="button" value="搜索" onclick="toPage(1)"/>                        
                    </td>                                                           
                </tr>
            </table>
        
    </div>
    <div class="row thead">
    	<div class="col c1">姓名</div>
    	<div class="col c3">性别</div>
        <div class="col c3">年龄</div>
    	<div class="col c1">意向课程</div>
    	<div class="col c3">时间</div>
    	<div class="col c3">学历</div>
        <div class="col c3">状态</div>
    	<div class="col c2">联系方式</div>    
		<div class="col c2">咨询日期</div>                                             
    	<div class="col c1">操作</div>                                                
    </div>
    <c:forEach items="${s}" var="s" varStatus="x" >
    <div class="row <c:if test="${x.index%2==0}">odd</c:if>">
    	<div class="col c1">${s.name}</div>
    	<div class="col c3">${s.sex}</div>
    	<div class="col c3">${s.age}</div>        
    	<div class="col c1">${s.course}</div>
    	<div class="col c3"><c:choose>
    	<c:when test="${s.time=='1'}">脱产</c:when>
    	<c:when test="${s.time=='2'}">业余</c:when>
    	</c:choose></div>
    	<div class="col c3">${s.education}</div>
        <div class="col c3 <c:choose>
    	<c:when test="${s.state=='1'}">yellow</c:when>
    	<c:when test="${s.state=='2'}">green</c:when>
    	<c:when test="${s.state=='3'}">red</c:when>
    	</c:choose>">
   		<c:choose>
    	<c:when test="${s.state=='1'}">跟进中</c:when>
    	<c:when test="${s.state=='2'}">已交费</c:when>
    	<c:when test="${s.state=='3'}">已放弃</c:when>
    	</c:choose>
    	</div>
    	<div class="col c2">${s.contact}</div>
		<div class="col c2"><fmt:formatDate value="${s.addTime}" pattern="yyyy年MM月dd" /></div>                                                
    	<div class="col c1">
        	<a href="update?id=${s.id}">编辑</a>
        	<a href="delete?id=${s.id}">删除</a>            
        </div>                                                
    </div>
    </c:forEach>
    
    <div class="pagination">
    	<table cellpadding="0" cellspacing="0" border="0">
        	<tr>
            	<td>
                	<c:if test="${p.pageIndex>1}">
                 		<a href="javascript:toPage(1)">首页</a> 
                    	<a href="javascript:toPage(${p.pageIndex-1})">上页</a> 
                    </c:if>
                    <c:if test="${p.pageIndex<p.pageCount}">
                   	 	<a href="javascript:toPage(${p.pageIndex+1})">下页</a> 
                    	<a href="javascript:toPage(${p.pageCount})">尾页</a>
                    </c:if>  
                </td>
                <td>
                	<span>
                    	每页  
                        <select name="pageSize" id="pageSize" class="sel">
                            <option value="10" ${param.pageSize==10?"selected='selected'":""}>10</option>
                            <option value="20" ${param.pageSize==20?"selected='selected'":""}>20</option>
                            <option value="30" ${param.pageSize==30?"selected='selected'":""}>30</option>
                            <option value="40" ${param.pageSize==40?"selected='selected'":""}>40</option>
                            <option value="50" ${param.pageSize==50?"selected='selected'":""}>50</option>                                                
                        </select>
        				条
                    </span>  
                </td>
                <td>
                	<span>
                    	第  
				        <input type="text" name="pageIndex" id="pageIndex" value="${p.pageIndex}" class="txt"/>
				        页
                    </span> 
                </td>
                <td>
                	<span>共 ${p.pageCount} 页</span> 
                </td>
                <td>
                	<span>
			        	<input type="submit" value="Go!" class="btn" onclick="toPage(1)"/>	
			       	</span>
                </td>
            </tr>
    	</table>                                                                                
    </div>
    </form>
    
</body>
</html>

