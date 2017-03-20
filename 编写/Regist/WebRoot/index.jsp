<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="/struts-tags" prefix="s"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>无标题文档</title>
<link rel="stylesheet" type="text/css" href="style.css"/>
</head>
<body>
	<div id="title">
    	<h1>用户注册</h1>
    </div>
    <div id="form">
    	<s:form method="post">
    	<table border="0" width="100%" cellpadding="0" cellspacing="0">
        	<tr>
            	<td class="lbl">用户名</td>
            	<td>
            		<s:textfield name="userName" cssClass="itxt"/>                	
					<span class="note">(长度为4-12个字符)</span>
                </td>                
            </tr>
			<tr>
            	<td></td>
            	<td class="errMsg">请输入用户名</td>                
            </tr>
            <tr class="odd">
            	<td class="lbl">密码</td>
            	<td>
            		<s:password name="password" cssClass="itxt"/>
					<span class="note">(长度为6-18个字符)</span>
                </td>                
            </tr>
			<tr class="odd">
            	<td></td>
            	<td class="errMsg">请输入密码</td>                  
            </tr>
            <tr>
            	<td class="lbl">确认密码</td>
            	<td>
                	<s:password name="rePwd" cssClass="itxt"/>
                </td>                
            </tr>
			<tr>
            	<td></td>
            	<td class="errMsg">请确认密码</td>                  
            </tr>
            <tr class="odd">
            	<td class="lbl">性别</td>
            	<td>
            		<s:radio list="#{1:'男',2:'女' }" name="sex"/>                	                    
                </td>                
            </tr>
			<tr class="odd">
            	<td></td>
            	<td class="errMsg">请选择性别</td>                
            </tr>
            <tr>
            	<td class="lbl">职位</td>
            	<td>
            		<s:action name="jobs" namespace="/"/>
            		<s:select list="#request.jobs" listKey="id" listValue="name" headerKey="" headerValue="请选择职位" name="job"/>
                	            
                </td>                
            </tr>
			<tr>
            	<td></td>
            	<td class="errMsg">请选择职位</td>                
            </tr>
            <tr class="odd">
            	<td class="lbl">爱好</td>
            	<td>
            		<s:action name="hobbies" namespace="/"/>
            		<s:checkboxlist list="#request.hobbies" listKey="id" listValue="name" name="hobby"/>                	    
                </td>                
            </tr>
			<tr class="odd">
            	<td></td>
            	<td class="errMsg">请选择爱好</td>                 
            </tr>
			<tr>
            	<td class="lbl">生日</td>
            	<td>
                	<s:textfield name="birthday" cssClass="itxt"/> 
					<span class="note">(年-月-日)</span>
                </td>                
            </tr>
			<tr>
            	<td></td>
            	<td class="errMsg">请输入生日</td>                
            </tr>
			<tr class="odd">
            	<td class="lbl">QQ号</td>
            	<td>
                	<s:textfield name="qq" cssClass="itxt"/>               
                </td>                
            </tr>
			<tr class="odd">
            	<td></td>
            	<td class="errMsg">请输入QQ号</td>                  
            </tr>
			<tr>
            	<td class="lbl">Email</td>
            	<td>
                	<s:textfield name="email" cssClass="itxt"/>           
                </td>                
            </tr>
			<tr>
            	<td></td>
            	<td class="errMsg">请输入Email</td>                 
            </tr>
			<tr class="odd">
            	<td class="lbl">URL</td>
            	<td>
                	<s:textfield name="url" cssClass="itxt"/> 
                </td>                
            </tr>
			<tr class="odd">
            	<td></td>
            	<td class="errMsg">请输入URL</td>               
            </tr>
            <tr>
            	<td class="lbl"></td>
            	<td>
            		<s:submit value="注册"/>
            		<s:reset value="重置"/>					                                    		
                </td>                
            </tr>
        </table>
        </s:form>
    </div>
</body>
</html>
