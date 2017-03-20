<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core"  prefix="c" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>青鸟相机商城</title>

<link href="css/style.css" type="text/css" rel="stylesheet"/>
<script>
	function toPage(i){
		document.getElementById("pageIndex").value=i;
		document.getElementById("frmSearch").submit();
	}
</script>
</head>

<body>
	<div id="title">
    	<h1>青鸟相机商城</h1>
    </div>
    <div class="search">
    	<form method="post" id="frmSearch">
    	<input type="hidden" name="pageIndex" id="pageIndex"/>
    	<table border="0">
        	<tr>
            	<td>
            	<jsp:include page="type"/>
                	<select class="sel" name="typeId">
                        <option value="" >请选择类型</option>
                        <c:forEach items="${type}" var="type">
                        	<option value="${type.id}" ${param.typeId==type.id?"selected='selected'":""}>${type.name}</option>
                        </c:forEach>
                    </select>
                </td>
                <td>		
                	<jsp:include page="brands"/>
                    <select class="sel" name="brandId">
                        <option value="">请选择品牌</option>
                        <c:forEach items="${brands}" var="brand">
                        	<option value="${brand.id}" ${brand.id==param.brandId?"selected='selected'":""}>${brand.name}</option>
                        </c:forEach>	
                    </select>
                </td>
                <td>		
                    <select class="sel" name="pixel">
                        <option value="">请选择像素数</option>
                        <option value="1000~1500" ${param.pixel=="1000~1500"?"selected='selected'":""}>1000万-1500万</option>
                        <option value="1500~2000" ${param.pixel=="1500~2000"?"selected='selected'":""}>1500万-2000万</option>
                        <option value="2500~3000" ${param.pixel=="2500~3000"?"selected='selected'":""}>2500万-3000万</option>
                        <option value="3000" ${param.pixel=="3000"?"selected='selected'":""}>3000万以上</option>
                    </select>					
                </td>
                <td>
                    <select class="sel" name="zoom">
                        <option value="">请选择光学变焦倍数</option>
                        <option value="-1" ${param.zoom=="-1"?"selected='selected'":""}>视镜头而定</option>
                        <option value="0" ${param.zoom=="0"?"selected='selected'":""}>无光学变焦</option>
                        <option value="10~20" ${param.zoom=="10~20"?"selected='selected'":""}>10倍-20倍</option>
                        <option value="20~30" ${param.zoom=="20~30"?"selected='selected'":""}>20倍-30倍</option>
                        <option value="30~40" ${param.zoom=="30~40"?"selected='selected'":""}>30倍-40倍</option>
                        <option value="40" ${param.zoom=="40"?"selected='selected'":""}>40倍以上</option>
                    </select>
                </td>
                <td>						
                    <select class="sel" name="color">
                        <option value="">请选择颜色</option>
                        <option value="红" ${param.color=="红"?"selected='selected'":""}>红</option>
                        <option value="黄" ${param.color=="黄"?"selected='selected'":""}>黄</option>
                        <option value="蓝" ${param.color=="蓝"?"selected='selected'":""}>蓝</option>
                        <option value="绿" ${param.color=="绿"?"selected='selected'":""}>绿</option>
                        <option value="粉" ${param.color=="粉"?"selected='selected'":""}>粉</option>
                        <option value="紫" ${param.color=="紫"?"selected='selected'":""}>紫</option>
                        <option value="黑" ${param.color=="黑"?"selected='selected'":""}>黑</option>
                        <option value="白" ${param.color=="白"?"selected='selected'":""}>白</option>							
                    </select>
                </td>
                <td>						
                    <select class="sel" name="lcd">
                        <option value="">请选择LCD屏幕尺寸</option>
                        <option value="2~3.5" ${param.lcd=="2~3.5"?"selected='selecte'":""}>2寸-3.5寸</option>
                        <option value="3.5~4" ${param.lcd=="3.5~4"?"selected='selecte'":""}>3.5寸-4寸</option>
                        <option value="4" ${param.lcd=="4"?"selected='selecte'":""}>4寸以上</option>
                    </select>
                </td>
                <td>						
                    <select class="sel" name="price">
                        <option value="">请选择价格</option>
                        <option value="0~1000" ${param.price=="0~1000"?"selected='selected'":""}>0-1000元</option>
                        <option value="1000~2000" ${param.price=="1000~2000"?"selected='selected'":""}>1000-2000元</option>
                        <option value="2000~3000" ${param.price=="2000~3000"?"selected='selected'":""}>2000-3000元</option>
                        <option value="3000~5000" ${param.price=="3000~5000"?"selected='selected'":""}>3000-5000元</option>
                        <option value="5000~10000" ${param.price=="5000~10000"?"selected='selected'":""}>5000-10000元</option>
                        <option value="10000" ${param.price=="10000"?"selected='selected'":""}>10000元以上</option>							
                    </select>
                </td>
                <td>
					<input type="text" name="title" class="txt" value="${param.title}"/>
				</td>
                <td>						
                    <input type="submit" value="搜索" class="btn"/>
                    <input type="submit" value="重置" class="btn"/>
				</td>
            </tr>
        </table>
    	</form>
    </div>
    <c:forEach items="${p.result}" var="camera">
    <div class="item">
    	<div class="item_l">
        	<img src="images/product/${camera.image}" width="100" height="100"/>
        </div>
        <div class="item_r">
			<div class="item_title">${camera.title}</div>
            <div class="item_pixel">${camera.pixel}万像素</div>
            <div class="item_zoom">${camera.zoom}倍光学变焦</div>
            <div class="item_lcd">${camera.lcd}英寸LCD</div>
            <div class="item_price">${camera.price}元</div>             
        </div>
    </div>
    </c:forEach>
    <div class="page">
    	<table width="100%">
        	<tr>
            	<td align="left">
                	<c:if test="${p.pageIndex>1}">
                		<a href="javascript:toPage(1)">首页</a> 
                		<a href="javascript:toPage(${p.pageIndex-1})">上页</a> 
                	</c:if>
                	
                	<c:if test="${p.pageIndex<p.pageCount}">
                		<a href="javascript:toPage(${p.pageIndex+1})">下页</a> 
                		<a href="javascript:toPage(${p.pageCount})">尾页</a>
                	</c:if>
                </td>
            	<td align="right">
                	第${p.pageIndex}页 共${p.pageCount}页 每页${p.pageSize}条 共${p.rowCount}条
                </td>                
            </tr>
        </table>
    </div>
</body>
</html>
