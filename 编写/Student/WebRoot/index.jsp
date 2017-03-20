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
    <div class="row thead">
    	<div class="col c1">姓名</div>
    	<div class="col c3">性别</div>
        <div class="col c3">年龄</div>
    	<div class="col c1">意向课程</div>
    	<div class="col c3">时间</div>
    	<div class="col c1">学历</div>
        <div class="col c3">状态</div>
    	<div class="col c2">联系方式</div>    
		<div class="col c2">咨询日期</div>                                             
    	<div class="col c1">操作</div>                                                
    </div>
    <%-- 
    	如果不通过var属性设置变量名，则<s:iterator>标签将从集合中取出的对象直接压入值栈
    	在<s:iterator>标签内可以直接通过<s:property>标签访问对象的属性
    --%>
    <s:iterator value="p.results" status="s">
    <div 
    	<s:if test="#s.even">class="row"</s:if>
    	<s:else>class="row odd"</s:else>
    >
    	<%--显示学生姓名 --%>
    	<div class="col c1">
    		<s:property value="name"/>
    	</div>
    	<%--显示学生性别 --%>
    	<div class="col c3">
    		<s:property value="sex"/>
    	</div>
    	<%--显示学生年龄 --%>
    	<div class="col c3">
    		<s:property value="age"/>
    	</div>   
    	<%--显示意向课程名称 --%>     
    	<div class="col c1">
    		<s:property value="course.name"/>
    	</div>
    	<%--显示上课时间 --%>
    	<div class="col c3">
    		<s:if test="time==1">脱产</s:if>
    		<s:else>业余</s:else>
    	</div>
    	<%--显示学历名称 --%>
    	<div class="col c1">
    		<s:property value="education.name"/>
    	</div>
    	<%--显示学生状态 --%>
        <s:if test="stat==1">
        	<div class="col c3 yellow">跟进中</div>
        </s:if>
        <s:elseif test="stat==2">
        	<div class="col c3 green">已缴费</div>
        </s:elseif>
        <s:else>
        	<div class="col c3 red">已放弃</div>
        </s:else>    
        <%--显示联系方式 --%>    
    	<div class="col c2">
    		<s:property value="contact"/>
    	</div>
    	<%--显示添加时间 --%>
		<div class="col c2">
			<s:property value="addTime"/>
		</div>                                                
    	<div class="col c1">    
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
    </s:iterator>
    
    <div class="pagination">
    	<table cellpadding="0" cellspacing="0" border="0">
        	<tr>
            	<td>
            		<s:if test="p.pageIndex>1">
	                	<a href="javascript:toPage(1)">首页</a>                                    
	                    <a href="javascript:toPage(${p.pageIndex-1})">上页</a>  
                    </s:if>
                                           
                    <s:if test="p.pageIndex<p.pageCount">                                  
	                    <a href="javascript:toPage(${p.pageIndex+1})">下页</a>                                    
	                    <a href="javascript:toPage(${p.pageCount})">尾页</a>  
                    </s:if>
                </td>
                <td>
                	<span>
                    	每页  
                    	<s:select list="#{1:'1',2:'2',3:'3',4:'4',5:'5'}" cssClass="sel" name="pageSize" id="selPageSize" onchange="toPage(1)"/>                        
        				条
                    </span>  
                </td>
                <td>
                	<span>
                    	第<s:textfield name="pageIndex" cssClass="txt" id="txtPageIndex"/>页
                    </span> 
                </td>
                <td>
                	<span>共${p.pageCount}页</span> 
                </td>
                <td>
                	<span>
			        	<input type="button" value="Go!" class="btn" onclick="toPage()"/>	
			       	</span>
                </td>
            </tr>
    	</table>                                                                                
    </div>
    <script>
    	//分页函数pi:页号,ps:每页行数
    	function toPage(pi,ps){
    		//如果没有传递页号参数
    		if(!pi){
    			pi=document.getElementById("txtPageIndex").value;
    		}
    		//如果没有传递每页行数参数
    		if(!ps){
    			ps=document.getElementById("selPageSize").value;
    		}
    		//设置页号隐藏域的值
    		document.getElementById("hidPageIndex").value=pi;
    		//设置每页行数隐藏域的值
    		document.getElementById("hidPageSize").value=ps;
    		
    		//提交搜索表单
    		document.getElementById("frmSearch").submit();
    	}
    </script>
    
</body>
</html>









