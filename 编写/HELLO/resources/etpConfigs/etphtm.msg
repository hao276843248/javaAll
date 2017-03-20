<html>
<head>
<title>错误信息提示</title>
<meta http-equiv='Content-Type' content='text/html; charset=GB2312'>
<script language='javaScript'>
	function showMsg(){
		if(document.all.errorDetialMsg.style.display==''){
			document.all.errorDetialMsg.style.display='none';
			document.all.btn.innerHTML='>>>>>>>...';
		}else{
			document.all.errorDetialMsg.style.display='';
			document.all.btn.innerHTML='<<<<<<<...';
		}
	}
</script>

<link rel='stylesheet' href='../js/style.css' type='text/css'>
</head>
<body leftmargin='0' topmargin='0' marginwidth='0' marginheight='0'>
<table CELLSPACING='0' CELLPADDING='0' WIDTH='100%' BORDER='0'>
 <tr><td BGCOLOR=#cccccc height='3'><img SRC='../images/spacer.gif' WIDTH='1' HEIGHT='3'></td></tr>
 </table>
  
 <table width='100%' border='0' cellspacing='0' cellpadding='0' height='57'>
  <tr>
  <td valign='middle' width='300'><img src='../images/logo.gif' width='300' height='55'></td>
  </tr>
  </table>
  <table width='100%' border='0' cellspacing='0' cellpadding='0'>
  <tr>
  <td height='18'>&nbsp;</td>
  </tr>
  </table>
  <table width='100%' border='0' cellspacing='0' cellpadding='0'>
  <tr>
  <td align='center'>
  <p>&nbsp;</p>
  <table width='100%' border='0' cellspacing='0' cellpadding='0'>
  <tr>
  <td align='left'>
  
  <p><b><BR><BR>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;对不起，您的交易出现以下错误</b></p>
  <table width='50%' border='0' cellspacing='0' cellpadding='0' align='center'>
  		<tr aligh='left'>
   		<td height='30' colspan='2'><font face='黑体' size='4'>错 误 信 息:</font></td>
   		</tr>
   		<tr aligh='center'>
   		<td height='44' width='329'><$1>
   		<td colspan='2' align='right'>
   		<label id='btn' onclick='javaScript:showMsg();'>>>>>>>...</label> </td>
   		</tr>
   		<tr> 
   		<td colspan='2'><label id='errorDetialMsg' style='display: none'><br><$2></label></td>
   		</tr>
   		</table>
   		<p>&nbsp;</p>
   </td>
   </tr>
   </table>
   <TABLE WIDTH='100%' BORDER='0' CELLSPACING='0' CELLPADDING='0'> 
   	<TR>
   		<TD BGCOLOR='B2B2B2'><IMG SRC='../images/spacer.gif' WIDTH='1' HEIGHT='1'></TD>
   	</TR>
   	<TR>
   		<TD ALIGN='center' HEIGHT='22' VALIGN='BOTTOM'><FONT COLOR=#7f7f7f> </FONT></TD>
   </TR>
   </TABLE>
   
   </body>
   </html>
