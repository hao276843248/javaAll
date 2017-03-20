<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="/struts-tags" prefix="s"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<%--  分别调用action将课程选项列表和学历选项列表加载到请求作用域中  --%>
<s:action name="courses" namespace="/"/>
<s:action name="educations" namespace="/"/>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<jsp:include page="inc/scripts.jsp" />
</head>
<body>
	<jsp:include page="inc/head.jsp" />
    <s:form action="update" method="post">
    	<s:hidden name="id"/>
    	<table id="frm" cellpadding="0" cellspacing="0" width="100%" border="0">
        	<tr>
            	<td class="lbl" width="110">
            		<s:text name="label.name"/>
            	</td>
                <td width="150">
                	<s:textfield name="name" cssClass="txt"/>                	
                </td> 
                <td class="msg" width="200">
                	<s:fielderror fieldName="name"/>
                </td>
               	<td>&nbsp;</td>
            </tr>
            <tr class="odd">
            	<td class="lbl">性别</td>
                <td>
                	<s:radio list="#{'男':getText('label.male'),'女':getText('label.female')}" name="sex"/>					                   
                </td> 
                <td class="msg">
                	<s:fielderror fieldName="sex"/>
                </td>
                <td></td>
            </tr>
            <tr>
            	<td class="lbl">生日</td>
                <td>
                	<s:textfield name="birthday" cssClass="txt Wdate" onclick="WdatePicker({readOnly:true,skin:'ext'})"/>                	
                </td> 
                <td class="msg">
                	<s:fielderror fieldName="birthday"/>
                </td>
                <td></td>
            </tr>
            <tr class="odd">
            	<td class="lbl">意向课程</td>
                <td>
                	<s:select list="#request.courses" listKey="id" listValue="name" name="course.id" headerKey="" headerValue="任意"/>                	
                </td> 
                <td class="msg">
                	<s:fielderror fieldName="course.id"/>
                </td>
                <td></td>
            </tr>
            <tr>
            	<td class="lbl">上课时间</td>
                <td>
                	<s:select list="#{1:'脱产',2:'业余'}" name="time" headerKey="" headerValue="任意"/>                	
                </td> 
                <td class="msg">
                	<s:fielderror fieldName="time"/>
                </td>
                <td></td>
            </tr>
            <tr class="odd">
            	<td class="lbl">学历</td>
                <td>                	
                	<s:select list="#request.educations" listKey="id" listValue="name" name="education.id" headerKey="" headerValue="任意"/>                
                </td> 
                <td class="msg">
                	<s:fielderror fieldName="education.id"/>
                </td>
                <td></td>
            </tr>
            <tr>
            	<td class="lbl">联系方式</td>
                <td>
                	<s:textfield name="contact" cssClass="txt"/>                	
                </td> 
                <td class="msg">
                	<s:fielderror fieldName="contact"/>
                </td>
                <td></td>
            </tr>
            <tr class="odd">
            	<td class="lbl">状态</td>
                <td>
                	<s:select list="#{1:'跟进中',2:'已缴费',3:'已放弃'}" name="stat" headerKey="" headerValue="任意"/>                	
                </td> 
                <td class="msg">
                	<s:fielderror fieldName="stat"/>
                </td>
                <td></td>
            </tr>
            <tr>
            	<td class="lbl"></td>
                <td>
                	<s:submit key="label.update"/>
                	<s:reset key="label.reset"/>                	                    
                </td> 
                <td class="msg"></td>
                <td></td>
            </tr>
        </table>
    </s:form>
    
</body>
</html>
