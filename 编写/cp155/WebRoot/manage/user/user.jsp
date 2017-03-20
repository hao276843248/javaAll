<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
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
<script language="javascript" type="text/javascript">

function checkform()
{
	 
	

	if (document.getElementById('password1id').value=="")
	{
		alert("原密码不能为空");
		return false;
	}
	if (document.getElementById('password2id').value=="")
	{
		alert("新密码不能为空");
		return false;
	}
	
	if (document.getElementById('password2id').value.length<6)
	{
		alert("新密码长度必须大于6位");
		return false;
	}
	if (document.getElementById('password2id').value != document.getElementById('password3id').value)
	{
		alert("新密码与新密码确认不一致");
		return false;
	}	 
	return true;
	
}


</script>

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
                            <td align="center" background="images/index1_36.gif"><a href="#" class="font3"><strong>修改密码</strong></a></td>
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
                        
                        <form action="houtaimethod!changepwd2.action" method="post" onsubmit="return checkform()">
                        <table width="100%" border="0" cellpadding="0" cellspacing="1" bgcolor="#BBD3EB">
                          
                          <tr>
                            
                            <td height="27" width="30%" align="center" background="images/index1_72.gif" bgcolor="#FFFFFF" >
                           <span style="font-weight: bold;"> 原密码:</span>
                            </td>
                            <td height="27"  width="70%" align="left" background="images/index1_72.gif" bgcolor="#FFFFFF">
                             <input  type="password" name="password1"  id='password1id'  size="30"  />
                            </td>
                           
                          </tr>
                          
                          <tr>
                            
                            <td height="27" width="30%" align="center" background="images/index1_72.gif" bgcolor="#FFFFFF" >
                           <span style="font-weight: bold;"> 新密码：</span>
                            </td>
                            <td height="27"  width="70%" align="left" background="images/index1_72.gif" bgcolor="#FFFFFF">
                             <input  type="password" name="password2"  id='password2id'  size="30"  />
                            </td>
                           
                          </tr>
                          
                          <tr>
                            
                            <td height="27" width="30%" align="center" background="images/index1_72.gif" bgcolor="#FFFFFF" >
                           <span style="font-weight: bold;"> 确认密码：</span>
                            </td>
                            <td height="27"  width="70%" align="left" background="images/index1_72.gif" bgcolor="#FFFFFF">
                             <input  type="password" name="password3"  id='password3id'  size="30"  />
                            </td>
                           
                          </tr>
                          
                          <tr>
                            
                            <td height="27" width="30%" align="center" background="images/index1_72.gif" bgcolor="#FFFFFF" >
                           <span style="font-weight: bold;"> 操作：</span>
                            </td>
                            <td height="27"  width="70%" align="left" background="images/index1_72.gif" bgcolor="#FFFFFF">
                              <input type="submit" value="提交" style="width: 60px" />
				&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
				<input  onclick="javascript:history.go(-1);" style="width: 60px" type="button" value="返回" />
                            </td>
                           
                          </tr>
                         
                          
                          
                        </table>
                        </form>
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

