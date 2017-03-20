<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="/struts-tags" prefix="s" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>主页</title>
<link rel="stylesheet" type="text/css" href="style.css"/>
<script src="<%=path%>/js/My97DatePicker/WdatePicker.js"></script>
<style type="text/css">
input{
	
	width:80px;
	height:35px;
}
</style>
<script>
	function toPage(i){
		document.getElementById("pageIndex").value=i;
		document.getElementById("frmSearch").submit();
	}
</script>
</head>
<body>
<div id="head">
	<jsp:include page="/inc/head.jsp" />
	<div id="right">
		<ul>
		</ul>
	</div>
</div>	
    	<input  type="button" value="添加" onclick="location.href='add.jsp'"/>
    	<s:form action="find" id="frmSearch" method="post">
    		<s:hidden name="pageIndex" id="pageIndex"/>
    		<s:textfield name="name"/>
    		<input type="button" value="搜索" onclick="toPage(1)"/>
    	</s:form>
    		<table style="margin:0 auto;"id="shanglist" width="80%" cellpadding="0" cellspacing="0" border="1px">
				<tr>
					<th width="60" align="center" >头像</th>
                    <th width="80" align="center" >姓名</th>
                    <th width="50"	align="center">性别</th>
                    <th width="70" 	align="center">生日</th>
                    <th width="50"	align="center">操作</th>	
				</tr>
				<s:iterator value="p.result" >
                <tr>
                	<td><img src="upload/<s:property value="pic"/>" width="50" /></td>
                    <td width="80" align="center"><s:property value="name"/> </td>
                    <td width="50"	align="center"><s:property value="gender"/> </td>
                    <td width="70" 	align="center"><s:property value="brithday"/></td>
                    <td><s:a action="get"> 
                    	<s:param name="id" value="id"/>
                    	编辑
                    </s:a>
                    <s:a action="delete">
                    	<s:param name="id" value="id"/>
                    	删除
                    </s:a>
                    </td>														
				</tr>
				</s:iterator> 
				
			</table>
			 <table  style="margin:0 auto;"id="shanglist" width="80%" cellpadding="0" cellspacing="0" border="1px">
        	<tr class="book">
            	<td >
            		<s:if test="p.pageIndex>1">
                 		<a href="javascript:toPage(1)">首页</a> 
                    	<a href="javascript:toPage(${p.pageIndex-1})">上页</a> 
                    </s:if>
                    <s:if test="p.pageIndex<p.pageCount">    
                    <a href="javascript:toPage(${p.pageIndex+1})">下页</a>
                    <a href="javascript:toPage(${p.pageCount})">尾页</a>                  
                    </s:if>     
                </td>
            	<td >第${p.pageIndex}页 共${p.pageCount}页   每页显示${p.pageSize}条 共${p.rowCount}条</td>                                  
            </tr>
        </table>


</body>
</html>

