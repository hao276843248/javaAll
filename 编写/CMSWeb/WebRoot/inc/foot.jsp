<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>

<div class="footer">
	<div class="subnav">
		<p>
			<a href="index.jsp?a=1" title="网站首页" >网站首页</a>
			<a href="about.jsp?a=2" title="公司简介">公司简介</a>
			<a href="products.jsp?cid=1&a=3" title="产品中心">产品中心</a>
			<a href="cases.jsp?cid=12&a=4" title="合作案例">合作案例</a>
			<a href="news.jsp?cid=9&a=5" title="新闻资讯">新闻资讯</a>
			<a href="download.jsp?cid=13&a=6" title="资料下载">资料下载</a>
			<a href="zhao.jsp?cid=14&a=7" title="人才招聘">人才招聘</a>
			<a href="message.jsp?a=8" title="在线留言">在线留言</a>
			<a href="contact.jsp?a=9" title="联系我们" class="last">联系我们</a>
		</p>
	</div>
	<div class="copyright">
		<p>荣旭自动化科技有限公司 版权所有 2014 【BMAP】【GMAP】</p>
		<p>电话：0769-89229908 传真：0769-88739965 联系人：李先生</p>
		<p>*本网站中所涉及的图片、文字等资料均属于荣旭自动化科技有限公司所有，未经许可不得转载*</p>
		<p>《中华人民共和国电信与信息服务业务经营许可证》编号：粤ICP备10217736号</p>
	</div>
</div>