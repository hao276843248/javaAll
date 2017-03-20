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

线路名称：<input name="title" type="text"  value="${title }">

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
                           
                            <td height="27" align="center" background="images/index1_72.gif" bgcolor="#FFFFFF">线路名称</td>
                            <td height="27" align="center" background="images/index1_72.gif" bgcolor="#FFFFFF">报名用户</td>
                            <td height="27" align="center" background="images/index1_72.gif" bgcolor="#FFFFFF">姓名</td>
                            <td height="27" align="center" background="images/index1_72.gif" bgcolor="#FFFFFF">联系电话</td>
                            <td height="27" align="center" background="images/index1_72.gif" bgcolor="#FFFFFF">备注</td>
                            <td height="27" align="center" background="images/index1_72.gif" bgcolor="#FFFFFF">状态</td>
                            <td height="27" align="center" background="images/index1_72.gif" bgcolor="#FFFFFF">报名时间</td>
                           
                          
                           
                            <td align="center" background="images/index1_72.gif" bgcolor="#FFFFFF">操作</td>
                          </tr>
                          <c:forEach items="${list}"  var="bean">
                          <tr>
                            <td height="26" align="center" bgcolor="#FFFFFF" style="font-weight: bold;">${bean.content.title }&nbsp;</td>
                            <td height="26" align="center" bgcolor="#FFFFFF" style="font-weight: bold;">${bean.user.username }&nbsp;</td>
                            <td height="26" align="center" bgcolor="#FFFFFF" style="font-weight: bold;">${bean.xingming }&nbsp;</td>
                            <td height="26" align="center" bgcolor="#FFFFFF" style="font-weight: bold;">${bean.dianhua }&nbsp;</td>
                            <td height="26" align="center" bgcolor="#FFFFFF" style="font-weight: bold;">${bean.beizhu }&nbsp;</td>
                            <td height="26" align="center" bgcolor="#FFFFFF" style="font-weight: bold;">${bean.zhuangtai }&nbsp;</td>
                            <td height="26" align="center" bgcolor="#FFFFFF" style="font-weight: bold;">${fn:substring(bean.createtime,0, 19)}&nbsp;</td>
                            
                        
                           

                            <td align="center" bgcolor="#FFFFFF" style="font-weight: bold;">
                           
  							<c:if test="${bean.zhuangtai=='未处理'}">
  							<a href="${url2 }delete.action?id=${bean.id }">处理报名</a>&nbsp; &nbsp; &nbsp;
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

