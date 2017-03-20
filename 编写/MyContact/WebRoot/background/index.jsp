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
            	<s:form action="list" method="post" id="frmSearch">
            		<s:hidden name="pageIndex" id="pageIndex"/>
                	<s:action name="groups" namespace="/background"/>
                	<s:select list="#request.groups" listKey="id" listValue="name" name="groupId" cssClass="sel" headerKey="" headerValue="所有分组"/>					
                    <s:textfield name="name"/>
                    
                    <input type="button" value="搜索" onclick="toPage(1)"/>
                    <a href="export.action">导出通讯录</a>
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
                <div class="c2"><s:property value="sex"/></div>  
                <div class="c3"><s:property value="title"/></div>    
                <div class="c3"><s:property value="group.name"/></div>
                <div class="c4"><s:property value="phone"/></div> 
                <div class="c4">
                	<s:a action="get">
                		<s:param name="id" value="id"/>
                		编辑
                	</s:a>
                	<s:a action="delete">
                		<s:param name="id" value="id"/>
                		删除
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

