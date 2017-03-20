<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
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
        	<a href="add.html">+添加学生</a>
        </div>
    </div>
    <div id="search">
    	<form >
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
                        	<option value="1">ACCP</option>
                        	<option value="2">BNET</option>
                        	<option value="3">学士后(Java)</option>
                        	<option value="4">学士后(.Net)</option>
                        	<option value="5">启蒙星</option>                                                                                                                  
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
                        	<option value="7">研究生</option>
                        	<option value="8">硕士</option>                                                        
                        	<option value="9">博士</option>
                        	<option value="10">博士后</option>                                                                                                                
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
    <form action="add" method="post">
    	<table id="frm" cellpadding="0" cellspacing="0" width="100%">
        	<tr>
            	<td class="lbl">姓名</td>
                <td width="110">
                	<input type="text" name="name" class="txt"/>
                </td> 
                <td class="msg">请输入姓名</td>
            </tr>
            <tr class="odd">
            	<td class="lbl">性别</td>
                <td>
					<input type="radio" name="sex" id="male" value="男"/><label for="male">男</label>
					<input type="radio" name="sex" id="female" value="女"/><label for="female">女</label>                    
                </td> 
                <td class="msg"></td>
            </tr>
            <tr>
            	<td class="lbl">生日(yyyy-MM-dd)</td>
                <td>
                	<input type="text" name="birthday" class="txt"/>
                </td> 
                <td class="msg"></td>
            </tr>
            <tr class="odd">
            	<td class="lbl">意向课程</td>
                <td>
					<select name="course">
                        <option value="">任意</option>
                        <option value="1">ACCP</option>
                        <option value="2">BNET</option>
                        <option value="3">学士后(java)</option>
                        <option value="4">学士后(.net)</option>
                        <option value="5">启蒙星</option>                                                                                                                
                    </select>
                </td> 
                <td class="msg"></td>
            </tr>
            <tr>
            	<td class="lbl">上课时间</td>
                <td>
                	<select name="time">
                        <option value="">任意</option>
                        <option value="1">脱产</option>
                        <option value="2">业余</option>
                    </select>
                </td> 
                <td class="msg"></td>
            </tr>
            <tr class="odd">
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
                        <option value="7">研究生</option>
                        <option value="8">硕士</option>                                                        
                        <option value="9">博士</option>
                        <option value="10">博士后</option>                                                                                                                
                    </select>
                </td> 
                <td class="msg"></td>
            </tr>
            <tr>
            	<td class="lbl">联系方式</td>
                <td>
                	<input type="text" name="contact" class="txt"/>
                </td> 
                <td class="msg"></td>
            </tr>
            <tr class="odd">
            	<td class="lbl">状态</td>
                <td>
                	<select name="state">
                        <option value="">任意</option>
                        <option value="1">跟进中</option>
                        <option value="2">已缴费</option>
                        <option value="3">已放弃</option>
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
