<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<div id="menu-mng" class="lefter">
			<div class="box">
				<dl>
					<dt>用户管理</dt>
					<dd>
						<em><a href="user-add.html">新增</a> </em><a href="user.html">用户管理</a>
					</dd>
					<dt>商品信息</dt>
					<dd>
						<em><a href="productClass-add.html">新增</a> </em><a
							href="productClass.html">分类管理</a>
					</dd>
					<dd>
						<em><a href="product-add.html">新增</a> </em><a href="product.html">商品管理</a>
					</dd>
					<dt>订单管理</dt>
					<dd>
						<a href="order.html">订单管理</a>
					</dd>
					<dt>留言管理</dt>
					<dd>
						<a href="guestbook.html">留言管理</a>
					</dd>
					<dt>新闻管理</dt>
					<dd>
						<em><a href="news-add.html">新增</a> </em><a href="news.html">新闻管理</a>
					</dd>
				</dl>
			</div>
		</div>