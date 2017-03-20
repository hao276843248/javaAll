<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@taglib uri="/struts-tags"  prefix="s"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<s:action name="groups" namespace="/background"/>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<jsp:include page="/inc/scripts.jsp"/>
<script>
	function toPage(i){
		document.getElementById("pageIndex").value=i;
		document.getElementById("frmSearch").submit();
	}
</script>
</head>
<body>
	<div id="wrap">
        <jsp:include page="/inc/head.jsp"/>   
        <div id="topic">
        	<div id="tlabel">联系人列表</div>
        	<jsp:include page="/inc/oper.jsp" />           
        </div>
        <div id="search">
        	<div id="search-left">
            	<s:form method="post" action="listContact" id="frmSearch">
			    	<%-- 页号隐藏域 --%>
					<input type="hidden" name="pageIndex" id="pageIndex"/>					
					
					<s:select list="#request.groups" listKey="id" listValue="name" name="groupId" headerKey="" headerValue="所有分组"/> 
					<s:textfield name="name"/>                    
                    <input type="button" value="搜索" onclick="toPage(1)"/>
                    <a href="export">导出通讯录</a>
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
        <s:iterator value="p.results" var="contact">
        <div class="row">
        	<div class="row-wrap">
                <div class="c1"><a href="getContact2?id=${id}" target="_blank">
                	<s:property value="#contact.name"/>
                </a></div>
                <div class="c2">
                	<s:property value="#contact.sex"/>
                </div>  
                <div class="c3">
                	<s:property value="#contact.title"/>
                </div>    
                <div class="c3">
                	<s:property value="#contact.group.name"/>
                </div>
                <div class="c4">
                	<s:property value="#contact.phone"/>
                </div> 
                <div class="c4">
                	<s:a action="getContact">
                		<s:param name="id" value="id"/>
                		编辑
                	</s:a>
                	<s:a action="deleteContact">
                		<s:param name="id" value="id"/>
                		删除
                	</s:a>
                		
                   <%--  <a href="update?id=<s:property value="id"/>">编辑</a> --%>
                   <%--  <a href="delete?id=${id}">删除</a>    --%>     
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
             	第${p.pageIndex}页 共${p.pageCount}页 每页显示${p.pageSize}条 共${p.rowCount}条
                </div>   
            </div>     
        </div>
    </div>    
</body>
</html>

