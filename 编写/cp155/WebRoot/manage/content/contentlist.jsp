<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
 <base href="<%=basePath%>">
<meta http-equiv="Content-Type" content="text/html; charset=gb2312" />
<title>旅游网站后台管理</title>
<!-- 调用CSS，JS -->
<link href="images/style.css" rel="stylesheet" type="text/css" />
<style type="text/css">
<!--
body {
	margin-left: 0px;
	margin-top: 0px;
	margin-right: 0px;
	margin-bottom: 0px;
	font-family: "宋体";
	font-size: 12px;
	color: #333333;
	background-color: #2286C2;
}
-->
</style>
</head>
<body>
<table width="100%" border="0" cellspacing="0" cellpadding="0">
  <%@ include file="../head.jsp" %>
  
  
  <tr>
    <td colspan="2">
      <table width="100%" border="0" cellspacing="10" cellpadding="0">
        
        <tr>
          <td width="10%" valign="top">
            <table width="100%" border="0" cellspacing="0" cellpadding="0">
              <tr>
                <td width="8" height="8"><img src="images/index1_23.gif" width="8" height="29" /></td>
                <td width="99%" background="images/index1_24.gif"></td>
                <td width="8" height="8"><img src="images/index1_26.gif" width="8" height="29" /></td>
              </tr>
              <tr>
                <td background="images/index1_45.gif"></td>
                <td bgcolor="#FFFFFF" style="padding:0 2px 0 2px; vertical-align:top;height:500px;">
                  
                  <%@ include file="../left.jsp" %>
                  
                  
                </td>
                <td background="images/index1_47.gif"></td>
              </tr>
              <tr>
                <td width="8" height="8"><img src="images/index1_91.gif" width="8" height="8" /></td>
                <td background="images/index1_92.gif"></td>
                <td width="8" height="8"><img src="images/index1_93.gif" width="8" height="8" /></td>
              </tr>
            </table>
          </td>
          <td width="70%" valign="top">
            <table width="100%" border="0" cellspacing="0" cellpadding="0">
              <tr>
                <td width="8" height="8"><img src="images/index1_28.gif" width="8" height="39" /></td>
                <td width="99%" background="images/index1_40.gif">
                  <table border="0" cellspacing="0" cellpadding="0">
                    <tr>
                      <td>
                        <table width="90" border="0" cellspacing="0" cellpadding="0">
                          <tr>
                            <td width="5"><img src="images/index1_35.gif" width="5" height="39" /></td>
                            <td align="center" background="images/index1_36.gif"><a href="#" class="font3"><strong>${titletitle }</strong></a></td>
                            <td width="5"><img src="images/index1_38.gif" width="5" height="39" /></td>
                          </tr>
                        </table>
                      </td>
                      
                      
                    </tr>
                  </table>
                </td>
                <td width="8" height="8"><img src="images/index1_43.gif" width="8" height="39" /></td>
              </tr>
              <tr>
                <td background="images/index1_45.gif"></td>
                <td bgcolor="#FFFFFF" style="height:490px; vertical-align:top;">
                  <table width="100%" border="0" cellspacing="10" cellpadding="0">
                    <tr>
                      <td>
                        <table width="100%" border="0" cellpadding="0" cellspacing="1" bgcolor="#C4E7FB">
                          <tr>
                            <td>
                              <table width="100%" border="0" cellpadding="0" cellspacing="5" bgcolor="#FFFFFF">
                                <tr>
                                  <td>&nbsp;
                                  <form action="${url }" method="post">
<a href="${url2 }add.action?leixing=${leixing }"><span style="font-size: 25px;font-weight: bold;">添加新内容</span></a>
标题：<input name="title" type="text"  value="${title }">

<input type="submit"  value="查询"/>
									</form>
                                  </td>
                                </tr>
                              </table>
                            </td>
                          </tr>
                        </table>
                      </td>
                    </tr>
                    <tr>
                      <td>
                        <table width="100%" border="0" cellpadding="0" cellspacing="1" bgcolor="#BBD3EB">
                          <tr>
                           
                            <td height="27" align="center" background="images/index1_72.gif" bgcolor="#FFFFFF">标题</td>
                            <td height="27" align="center" background="images/index1_72.gif" bgcolor="#FFFFFF">点击数</td>
                            <td height="27" align="center" background="images/index1_72.gif" bgcolor="#FFFFFF">添加时间</td>
                            <td height="27" align="center" background="images/index1_72.gif" bgcolor="#FFFFFF">是否推荐</td>
                           
                          
                           
                            <td align="center" background="images/index1_72.gif" bgcolor="#FFFFFF">操作</td>
                          </tr>
                          <c:forEach items="${list}"  var="bean">
                          <tr>
                            <td height="26" align="center" bgcolor="#FFFFFF" style="font-weight: bold;">${bean.title }&nbsp;</td>
                            <td height="26" align="center" bgcolor="#FFFFFF" style="font-weight: bold;">${bean.dianjicishu }&nbsp;</td>
                            <td height="26" align="center" bgcolor="#FFFFFF" style="font-weight: bold;">${fn:substring(bean.createtime,0, 19)}&nbsp;</td>
                            <td height="26" align="center" bgcolor="#FFFFFF" style="font-weight: bold;">${bean.tuijian }&nbsp;</td>
                        
                           

                            <td align="center" bgcolor="#FFFFFF" style="font-weight: bold;">
                            <a href="wangzhanmethod!contentupdate3.action?id=${bean.id }" target="_blank">查看</a> &nbsp; &nbsp; &nbsp;
  							<a href="${url2 }update.action?id=${bean.id }">修改</a> &nbsp; &nbsp; &nbsp;
  							<a href="${url2 }delete.action?id=${bean.id }">删除</a>&nbsp; &nbsp; &nbsp;
  							
  							<c:if test="${bean.tuijian=='未推荐'}">
  							<a href="${url2 }delete2.action?id=${bean.id }">推荐</a>&nbsp; &nbsp; &nbsp;
  							</c:if>
  							
  							<c:if test="${bean.tuijian=='推荐'}">
  							<a href="${url2 }delete3.action?id=${bean.id }">取消推荐</a>&nbsp; &nbsp; &nbsp;
  							</c:if>
  							
  						
                            </td>
                          </tr>
                          </c:forEach>
                          
                        </table>
                      </td>
                    </tr>
                    <tr>
                      <td>
                        <table width="100%" border="0" cellpadding="0" cellspacing="1" bgcolor="#E1E5E8">
                          <tr>
                            <td>
                              <table width="100%" border="0" cellpadding="0" cellspacing="5" bgcolor="#FDFDFF">
                                <tr>
                                  <td>&nbsp;${pagerinfo }</td>
                                </tr>
                              </table>
                            </td>
                          </tr>
                        </table>
                      </td>
                    </tr>
                    
                  </table>
				  
				 
				  <h3></h3>
                </td>
                
              </tr>
              
            </table>
          </td>
        </tr>
      </table>
    </td>
  </tr>
</table>
</body>
</html>

