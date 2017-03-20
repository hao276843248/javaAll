<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core"  prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
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
</head>
<body>
	<div id="title">
    	<div id="logo" onclick="location.href='show'"></div>
        <div id="oper">
        	<a href="add.jsp">+添加学生</a>
        </div>
    </div>
    <div id="search">
    	<form>
			<table>
            	<tr>
                	<td class="lbl">姓名</td>
                    <td>
                    	<input type="text" name="name" class="txt"/>
                    </td>
                	<td class="lbl">意向课程</td>
                    <td>
                    	<select name="course">
                        	<option value="">任意</option>
                        	<option value="ACCP">ACCP</option>
                        	<option value="BNET">BNET</option>
                        	<option value="学士后">学士后</option>
                        	<option value="启蒙星">启蒙星</option>                                                                                                                
                        </select>
                    </td>
                	<td class="lbl">上课时间</td>
                    <td>
                    	<select name="time">
                        	<option value="">任意</option>
                        	<option value="1">脱产</option>
                        	<option value="2">业余</option>
                        </select>
                    </td>
                	<td class="lbl">学历</td>
                    <td>
                    	<select name="education">
                        	<option value="">任意</option>
                        	<option value="1">小学</option>
                        	<option value="2">初中</option>
                        	<option value="3">高中</option>
                        	<option value="4">职高/技校</option>
                        	<option value="5">大专</option>
                        	<option value="6">大本</option>                                                        
                        	<option value="5">研究生</option>
                        	<option value="6">硕士</option>                                                        
                        	<option value="5">博士</option>
                        	<option value="6">博士后</option>                                                                                                                
                        </select>
                    </td> 
                    <td class="lbl">状态</td>
                    <td>
                    	<select name="course">
                        	<option value="">任意</option>
                        	<option value="1">跟进中</option>
                        	<option value="2">已缴费</option>
                        	<option value="3">已放弃</option>
                        </select>
                    </td>
                    <td>
                    	<input type="submit" value="搜索"/>                        
                    </td>                                                           
                </tr>
            </table>
        </form>
    </div>
    <form action="update" method="post">
    	<table id="frm" cellpadding="0" cellspacing="0" width="100%">
    	<input type="hidden" name="id" value="${s.id}"/>
        	<tr>
            	<td class="lbl">姓名</td>
                <td width="110">
                	<input type="text" name="name" class="txt" value="${s.name}"/>
                </td> 
                <td class="msg">请输入姓名</td>
            </tr>
            <tr class="odd">
            	<td class="lbl">性别</td>
                <td>
					<input type="radio" name="sex" id="male"   value="男"<c:if test="${s.sex=='男'}">checked="checked"</c:if> /><label for="male">男</label>
					<input type="radio" name="sex" id="female" value="女"<c:if test="${s.sex=='女'}">checked="checked"</c:if> /><label for="female">女</label>                    
                </td> 
                <td class="msg"></td>
            </tr>
            <tr>
            	<td class="lbl">生日</td>
                <td>
                	<input type="text" name="birthday" class="txt" value="<fmt:formatDate value="${s.birthday}" pattern="yyyy-MM-dd"/>" />
                	
                </td> 
                <td class="msg"></td>
            </tr>
            <tr class="odd">
            	<td class="lbl">意向课程</td>
                <td>
					<select name="course">
                        <option value="" >任意</option>
                        <option value="1" <c:if test="${s.cid==1}">selected="selected"</c:if>>ACCP</option>
                        <option value="2" <c:if test="${s.cid==2}">selected="selected"</c:if>>BNET</option>
                        <option value="3" <c:if test="${s.cid==3}">selected="selected"</c:if>>学士后(java)</option>
                        <option value="4" <c:if test="${s.cid==4}">selected="selected"</c:if>>学士后(.net)</option>
                        <option value="5" <c:if test="${s.cid==5}">selected="selected"</c:if>>启蒙星</option>                                                                                                                
                    </select>
                </td> 
                <td class="msg"></td>
            </tr>
            <tr>
            	<td class="lbl">上课时间</td>
                <td>
                	<select name="time">
                        <option value="">任意</option>
                        <option value="1"<c:if test="${s.time==1}">selected="selected"</c:if>>脱产</option>
                        <option value="2"<c:if test="${s.time==2}">selected="selected"</c:if>>业余</option>
                    </select>
                </td> 
                <td class="msg"></td>
            </tr>
            <tr class="odd">
            	<td class="lbl">学历</td>
                <td>
                	<select name="education">
                        <option value="">任意</option>
                        <option value="1"<c:if test="${s.eid==1}">selected="selected"</c:if>>小学</option>
                        <option value="2"<c:if test="${s.eid==2}">selected="selected"</c:if>>初中</option>
                        <option value="3"<c:if test="${s.eid==3}">selected="selected"</c:if>>高中</option>
                        <option value="4"<c:if test="${s.eid==4}">selected="selected"</c:if>>职高/技校</option>
                        <option value="5"<c:if test="${s.eid==5}">selected="selected"</c:if>>大专</option>
                        <option value="6"<c:if test="${s.eid==6}">selected="selected"</c:if>>大本</option>                                                        
                        <option value="7"<c:if test="${s.eid==7}">selected="selected"</c:if>>研究生</option>
                        <option value="8"<c:if test="${s.eid==8}">selected="selected"</c:if>>硕士</option>                                                        
                        <option value="9"<c:if test="${s.eid==9}">selected="selected"</c:if>>博士</option>
                        <option value="10"<c:if test="${s.eid==10}">selected="selected"</c:if>>博士后</option>                                                                                                                
                    </select>
                </td> 
                <td class="msg"></td>
            </tr>
            <tr>
            	<td class="lbl">联系方式</td>
                <td>
                	<input type="text" name="contact" class="txt" value="${s.contact}"/>
                </td> 
                <td class="msg"></td>
            </tr>
            <tr class="odd">
            	<td class="lbl">状态</td>
                <td>
                	<select name="state">
                        <option value="">任意</option>
                        <option value="1"<c:if test="${s.state==1}">selected="selected"</c:if>>跟进中</option>
                        <option value="2"<c:if test="${s.state==2}">selected="selected"</c:if>>已缴费</option>
                        <option value="3"<c:if test="${s.state==3}">selected="selected"</c:if>>已放弃</option>
                    </select>
                </td> 
                <td class="msg"></td>
            </tr>
            <tr>
            	<td class="lbl"></td>
                <td>
                	<input type="submit" value="添加"/>
                	<input type="reset" value="重置"/>                    
                </td> 
                <td class="msg"></td>
            </tr>
        </table>
    </form>
    
</body>
</html>
