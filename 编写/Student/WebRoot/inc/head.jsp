<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="/struts-tags" prefix="s"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>

<div id="title">
	<div id="logo" onclick="location.href='list.action'"></div>
	<div id="oper">
		<a href="add.jsp">+添加学生</a>
	</div>
</div>
<div id="search">
	<s:form action="list" method="post" id="frmSearch">
		<%-- 页号隐藏域 --%>
		<input type="hidden" name="pageIndex" id="hidPageIndex"/>
		<%-- 每页行数隐藏域 --%>
		<input type="hidden" name="pageSize" id="hidPageSize"/>
		<table>
			<tr>
				<td class="lbl">姓名</td>
				<td>
					<s:textfield name="s_name" cssClass="txt"/>					
				</td>
				<td class="lbl">意向课程</td>
				<td>
					<s:select list="#request.courses" listKey="id" listValue="name" name="s_courseId" headerKey="" headerValue="任意"/>                						
				</td>
				<td class="lbl">上课时间</td>
				<td>
					<s:select list="#{1:'脱产',2:'业余'}" name="s_time" headerKey="" headerValue="任意"/>                
				</td>
				<td class="lbl">学历</td>
				<td>
					<s:select list="#request.educations" listKey="id" listValue="name" name="s_educationId" headerKey="" headerValue="任意"/>
				</td>
				<td class="lbl">状态</td>
				<td>
					<s:select list="#{1:'跟进中',2:'已缴费',3:'已放弃'}" name="s_stat" headerKey="" headerValue="任意"/>
				</td>
				<td><input type="submit" value="搜索" /></td>
			</tr>
		</table>
	</s:form>
</div>