<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<div class="box">
			<h2>商品分类</h2>
			<dl>
				<c:forEach items="${productcategoryForm}" var="group" >
					<c:choose>
						<c:when test="${group.epcId == group.epcParentId}">
							<dt>${group.epcName}</dt>
						</c:when>
	           	  		<c:otherwise >
	           	  			<dd>${group.epcName}</dd>
	           	  		</c:otherwise>
					</c:choose>
					
				</c:forEach>
			</dl>
		</div>