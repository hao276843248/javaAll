<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<div id="templatemo_footer">

        <ul class="footer_menu">
			<li><a href="wangzhanmethod!contentlist.action?leixing=1">热点新闻</a></li>
            <li><a href="wangzhanmethod!contentlist.action?leixing=2">景点介绍</a></li>
            <li><a href="wangzhanmethod!contentlist.action?leixing=3" >旅游线路</a></li>
            <li><a href="wangzhanmethod!contentlist.action?leixing=4" >餐饮酒店</a></li>
            <li><a href="wangzhanmethod!contentlist.action?leixing=5">人文风采</a></li>
            <li><a href="register.jsp">用户注册</a></li>
            <c:if test="${user==null}">
            <li><a href="login.jsp">用户登录</a></li>
            </c:if>
            <c:if test="${user!=null}">
            <li><a href="wangzhanmethod!loginout.action">用户退出</a></li>
            </c:if>
            <li><a href="manage/login.jsp">管理后台</a></li>
        </ul>
    
       
</div> <!-- end of footer -->
