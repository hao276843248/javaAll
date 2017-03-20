<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="/struts-tags" prefix="s"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>无标题文档</title>
<link rel="stylesheet" type="text/css" href="css/style.css" />
<script src="js/My97DatePicker/WdatePicker.js"></script>
</head>
<body>
	<div id="title"></div>

	<div id="main">
		<div id="topic">预约列表</div>
		<div id="search">
			<s:form action="list" method="post" id="forSearch">
				<s:textfield name="reserveDate" cssClass="txt Wdate" onclick="WdatePicker({skin:'ext',readOnly:true})"/>
				<s:select list="#{8:'8:00',9:'9:00',10:'10:00',11:'11:00',12:'12:00',13:'13:00',14:'14:00',15:'15:00',16:'16:00',17:'17:00'}" name="beginTime"headerKey="请选择结束时间" headerValue=""/>
				<s:select list="#{8:'8:00',9:'9:00',10:'10:00',11:'11:00',12:'12:00',13:'13:00',14:'14:00',15:'15:00',16:'16:00',17:'17:00'}" name="endTime" headerKey="请选择开始时间" headerValue=""/> 
				<s:select list="#{1:'空闲',2:'已预订'}" name="status"/>
				<input type="submit" value="搜索" />
			</s:form>
		</div>
		<div class="list">
			<div class="row head">
				<div class="row-wrap">
					<div class="c3">日期</div>
					<div class="c3">会议室</div>
					<div class="c3">状态</div>
					<div class="c3">占用时间</div>
					<div class="c3">预约人</div>
					<div class="c3">操作</div>
				</div>
			</div>
			<s:iterator value="p.results" var="row">
			
				<div class="row">
					<div class="row-wrap">
						<s:if test="#row[1]!=null">
							<div class="c3">
								<s:property value="#row[1].reserveDate"/>
							</div>
						</s:if><s:else>----</s:else>
						
						<div class="c3"><s:property value="#row[0].name" /></div>
						<s:if test="#row[1]!=null">
							<div class="c3">空闲</div>
						</s:if><s:else><div class="c3">已预订</div></s:else>
						
						<s:if test="#row[1]!=null">
							<div class="c3">
								<s:property value="#row[1].beginTime"/>-
								<s:property value="#row[1].endTime"/>
							</div>
						</s:if><s:else><div class="c3">----</div></s:else> 
						
						<s:if test="#row[1]!=null">
                		<div class="c3">
                			<s:property value="#row[1].name"/>                			
                		</div>
                		</s:if>
                		<s:else><div class="c3">----</div></s:else> 
						
						<div class="c3">
							<a href="#">预订</a>
						</div>
					</div>
				</div>

			</s:iterator>	


			<div class="pagination">
				<div class="pg-left">
					<a href="#">首页</a> <a href="#">上页</a> <a href="#">下页</a> <a
						href="#">尾页</a> [1/3]
				</div>
			</div>

		</div>
	</div>
	<div id="foot">&copy;2016&nbsp;通州北大青鸟</div>
</body>
</html>
