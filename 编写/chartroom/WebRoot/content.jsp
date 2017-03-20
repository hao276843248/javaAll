<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="/struts-tags" prefix="s" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<s:iterator value="content">
<s:if test="ip!=currentIP">
	<div class="cleft">
		<div class="ip"><s:property value="ip"/></div>            
	    <div class="content">
	       	<p><s:property value="content"/></p>
	    </div>
		<div style="clear:both;"></div>
	</div>
</s:if>
<s:else>
	<div class="cright">
	    <div class="ip"><s:property value="ip"/></div>            
	    <div class="content">
	      	<p><s:property value="content"/></p>
	    </div>
		<div style="clear:both;"></div>	
	</div>  
</s:else>
</s:iterator>   