<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="/struts-tags" prefix="s"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>
<%--  分别调用action将课程选项列表和学历选项列表加载到请求作用域中  --%>
<s:action name="group" namespace="/background" />

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<jsp:include page="/inc/scripts.jsp" />

</head>
<body>
<script >
		function toPage(i){
			document.getElementById("hidPageIndex").value=i;
			
			//提交搜索表单
    		document.getElementById("frmSearch").submit();
		}
	</script>
	<div id="wrap">
		<jsp:include page="/inc/head.jsp" />
		<div id="topic">
			<div id="tlabel">联系人列表</div>
			<jsp:include page="/inc/user.jsp" />
		</div>
		<div id="search">
			<div id="search-left">
				<s:form action="list" id="frmSearch">
				<input type="hidden" name="pageIndex" id="hidPageIndex"/>
					<s:select list="#request.group" listKey="id" listValue="name"
						name="groupID" headerKey="" headerValue="所有分组" />
					<s:textfield name="name" cssClass="txt" />
					<input type="submit" value="搜索" />
					<a href="excel.action">导出通讯录</a>
				</s:form>
			</div>
			<div id="search-right">
				<a href="add.jsp">添加联系人</a>
			</div>
		</div>
		<div id="head">
			<div class="row-wrap">
				<div class="c1">姓名</div>
				<div class="c2">性别</div>
				<div class="c3">头衔</div>
				<div class="c3">分组</div>
				<div class="c4">电话</div>
				<div class="c4">操作</div>
			</div>
		</div>

		<%-- 
    	如果不通过var属性设置变量名，则<s:iterator>标签将从集合中取出的对象直接压入值栈
    	在<s:iterator>标签内可以直接通过<s:property>标签访问对象的属性
   		 --%>
   		<s:iterator value="p.results">
		<div class="row">
			<div class="row-wrap">
				<div class="c1">
					<s:a action="get" target="_blank">
                		<s:param name="id" value="id"/>
                		<s:param name="view" value="'detail'"/>
                		<s:property value="name"/>
                	</s:a>      
				</div>
				<div class="c2"><s:property value="sex" /></div>
				<div class="c3"><s:property value="title" /></div>
				<div class="c3"><s:property value="group.name" /></div>
				<div class="c4"><s:property value="phone" /></div>
				<div class="c4">
				<s:a action="get">
					
					<s:param name="id" value="id" />编辑
				</s:a>
				<s:a action="delete.action">
					<s:param name="id" value="id" />删除
				</s:a>
				</div>
			</div>
		</div>
		</s:iterator>

		<div id="pagenav">
			<div class="row-wrap">
				<div id="nav1">
				<s:if test="p.pageIndex>1">
					<a href="javascript:toPage(1)">首页</a>
					<a href="javascript:toPage(${p.pageIndex-1})">上页</a> 
				</s:if>
				<s:if test="p.pageIndex<p.pageCount">
					<a href="javascript:toPage(${p.pageIndex+1})">下页</a> 
					<a href="javascript:toPage(${p.pageCount})">尾页</a>
				</s:if>
				</div>
				<div id="nav2">
					第${p.pageIndex}页
					共${p.pageCount}页 
					每页${p.pageSize}条
					共${p.rowCount}条
				</div>
			</div>
		</div>
	</div>
	
</body>
</html>

