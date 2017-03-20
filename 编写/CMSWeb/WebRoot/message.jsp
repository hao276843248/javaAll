<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<jsp:include page="inc/scripts.jsp" />
<script>
	function refreshVcode() {
		var imgVcode = document.getElementById("imgVcode");
		imgVcode.src = "vcode.jpg?r=" + Math.random();
	}
</script>
</head>

<body>
	<!--页头开始-->
	<jsp:include page="inc/head.jsp" />
	<!--页头结束-->
	<div class="clear"></div>
	<div class="main">
		<div id="left">
			<jsp:include page="inc/guwm.jsp" />
			<jsp:include page="inc/lxnm.jsp" />
		</div>
		<!--left-->
		<div id="right">
			<div class="position">
				<span>您的位置：<a href="index.html">首页&nbsp;></a>在线留言</span>在线留言
			</div>
			<div class="web_box">
				<div class="content">
					<dl class="bottom_e">
						<dt>免费提交留言</dt>
						<dd class="contents_m">
							<form action="message.asp" method="post" name="guest"
								onSubmit="return fn_CheckForm(this);">
								<input type=hidden name=action value="g" />
								<p>
									<label class="b"><font color="red">*</font>称呼：</label><input
										type="text" name="name" class="longtxt" value=""
										maxlength="255" />
								</p>
								<p>
									<label class="e"><font color="red">*</font>E_Mail：</label><input
										type="text" name="email" class="longtxt" value=""
										maxlength="255" />
								</p>
								<p>
									<label>联系电话：</label><input type="text" name="tel"
										class="longtxt" value="" maxlength="255" /><strong>(请填写您的手机或者座机号码
										)</strong>
								</p>
								<p>
									<label>企业名称：</label><input type="text" name="company"
										class="longtxt" value="" maxlength="255" />
								</p>
								<p>
									<label>公司地址：</label><input type="text" name="addr"
										class="longtxt" value="" maxlength="255" />
								</p>
								<p>
									<label class="y"><font color="red">*</font>验证码：</label><input
										maxlength="4" name="checkcode" size="8" />
										<img id="imgVcode" src="vcode.jpg" align="absbottom"    width="104"  onclick="refreshVcode()"/>
								</p>
								<p>
									<label class="b"><font color="red">*</font>标题：</label><input
										type="text" name="title" class="longtxt" value=""
										maxlength="255" />
								</p>
								<p id="textarea">
									<label class="n"><font color="red">*</font>内容：</label>
									<textarea name="content" cols="40" rows="5"></textarea>
								</p>
								<div class="sbts">
									<input name="" type="submit" value="提交" /><input name=""
										type="reset" value="重置" />
								</div>
							</form>
						</dd>
					</dl>
				</div>
				<!--content end-->
			</div>
		</div>
	</div>
	<!--页脚开始-->
	<jsp:include page="inc/foot.jsp" />
	<!--页脚结束-->
</body>
</html>
