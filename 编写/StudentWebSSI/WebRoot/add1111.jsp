<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>无标题文档</title>
<link rel="stylesheet" type="text/css" href="style.css"/>
<script src="<%=path%>/js/My97DatePicker/WdatePicker.js"></script>
<script type="text/javascript">
	function $(id){
		return document.gerElementById(id);
	}
	function mm_(){
		$("errmm").innerHTML="";
		var mm=$("mm").value.trim();
		var a=true;
		$("errmm").innerHTML=mm;
		if(mm.length==0){
			$("errmm").innerHTML="请输入密码";
			a=false;
		}else if(mm.length<6||mm.length>12){
			$("errmm").innerHTML="密码长度必须在6-12位之间";
			a=false;
		}
		return a;
	}
	
	function qrmm_(){
		$("errmm").innerHTML="";
		var mm=$("mm").value.trim();
		var rqmm=$("qrmm").value.trim();
		var a=true;
		$("errmm").innerHTML=mm;
		if(mm.length==0){
			$("errmm").innerHTML="请输入密码";
			a=false;
		}else if(mm.length<6||mm.length>12){
			$("errmm").innerHTML="密码长度必须在6-12位之间";
			a=false;
		}else if(mm!=qrmm){
			$("errmm").innrtHTML="两次次密码不一致";
			a=false;
		}
		return a;
	}
	
	function tijiao_(){
		return yhm()&& mm();		
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
	<form action="add" method="post" enctype="multipart/form-data">
	<table style="clear:both;">
		<tr>
			<td>年级</td>
			<td>
				<select name="nianji">
					<option >请选择年级</option>
					<option value="S1">S1</option>
					<option value="S2">S2</option>
					<option value="Y2">Y2</option>
				</select>			
			</td>			
			<td></td>
		</tr>
		<tr>
			<td>姓名</td>
			<td>
				<input type="text" name="name"/>			
			</td>			
			<td></td>
		</tr>
		<tr>
			<td>性别</td>
			<td>
				<input type="radio" name="sex" value="男" checked="checked"/>男
				<input type="radio" name="sex" value="女"/>女
			</td>			
			<td></td>
		</tr>
		<tr>
			<td>密码</td>
			<td>
				<input type="password" name="password" id="mm"/>			
				<span class="err" id="errmm"></span>
			</td>			
			<td></td>
		</tr>
		<tr>
			<td>确认密码</td>
			<td>
				<input type="password" name="repwd" id="qrmm"/>				
				<span class="err" id="errmm"></span>
			</td>			
			<td></td>
		</tr>
		<tr>
			<td>电话</td>
			<td>
				<input type="text" name="phone"/>
			</td>			
			<td></td>
		</tr>
		<tr>
			<td>地址</td>
			<td>
				<input type="text" name="address"/>
			</td>			
			<td></td>
		</tr>
		<tr>
			<td>生日(yyyy-mm-dd)</td>
			<td>
				<input type="text" name="birthday"/>
			</td>			
			<td></td>
		</tr>
		<tr>
       		<td>头像</td>
                <td>
                	<input type="file" name="pic" class="text" />
                </td>
                <td>
                	<div class="err"></div>
                </td>
        </tr>
		<tr>
			<td></td>
			<td>
				<input type="submit" value="提交" />
				<input type="button" value="返回" onclick="location.href='show'" />
			</td>			
			<td></td>
		</tr>		
		</table>
	 </form>	
</div>
</body>
</html>

