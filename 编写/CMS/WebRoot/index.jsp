<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<jsp:include page="inc/scripts.jsp" />
</head>

<body>
<!--页头开始-->
<jsp:include page="inc/head.jsp" />
<!--页头结束-->
<div class="clear"></div>
<!--主体开始-->
<div class="main">
	<!--公司简介开始-->
	<div class="about_box">
        <div class="about_index fl">
            <div class="left_tit fl">
                <h2>公司简介</h2>
                <div class="about_img"><img src="images/img_36.jpg" /></div>
            </div>
            <div class="right_info fr">
                <div class="info">
                        <p>东莞市荣旭自动化科技有限公司成立于2010年，于2014年3月乔
            迁至东莞市石碣镇-旭阳高科科技园，正式成为UAG集团公司成员，厂
            房建筑面积达3200平方米。 </p>
                        <p>联合UAG集团公司，专业从事机器视觉设备研发与生产、非标自
                        动化设备设计与制造、机器视觉系统研发等工业自动化应用领域研发
                        与制造。全体员工80%以上都是大学以上学历，具有多年丰富实践工
                        经验的影像处理软件开发工程师(10人)、光学工程师（4人）、电气
                        工程(6人)、机械设计工程师（8人）、系统应用工程师（10）、加
                        工与装配（15）、其它等高科技人才共60人....</p>
                </div>
                <div class="more fr"><a href="#">[更多]</a></div>
            </div>
        </div>
        <div class="viedo_index fr">
            <h2>视频展示</h2>
            <div class="video">
                 <object classid="clsid:D27CDB6E-AE6D-11cf-96B8-444553540000" codebase="http://download.macromedia.com/pub/shockwave/cabs/flash/swflash.cab#version=7,0,19,0" width="315" height="200">
                          <param name="movie" value="Flvplayer.swf" />
                          <param name="wmode" value="transparent"> 
                          <param name="quality" value="high" />
                          <param name="allowFullScreen" value="true" />
                          <param name="FlashVars" value="vcastr_file=index.flv" />
                          <embed src="Flvplayer.swf" wmode="transparent" allowfullscreen="true"  quality="high" flashvars="vcastr_file=index.flv" pluginspage="http://www.macromedia.com/go/getflashplayer" type="application/x-shockwave-flash" width="315" height="200"></embed>
                        </object>
            </div>
        </div>
    </div>
    <!--公司简介结束-->
    <!--产品中心开始-->
    <jsp:include page="list">
    	<jsp:param name="include" value="true"/>
    	<jsp:param name="pageIndex" value="1"/>
    	<jsp:param name="pageSize" value="8"/>
    	<jsp:param name="categoryName" value="产品中心"/>
    </jsp:include>
    <div class="product">
    	<h2><span class="fr"><a href="#">更多></a></span><i>产品中心</i></h2>
        <div class="pro">
          <div class="cardmain img-scroll">
               <span class="prev">&nbsp;</span>
               <span class="next">&nbsp;</span>
               <div class="img-list">
              <ul>
              <c:forEach items="${p.results}" var="content">
              <li> <a href="products_deail.html"><img src="${content.pic}" width="180" height="100" alt="" /></a><span><a href="#">${content.title}</a></span></li>
              </c:forEach>              
              </ul>
               </div>
              </div>
              <script type="text/javascript">
              function DY_scroll(wraper,prev,next,img,speed,or)
              {	
                  var wraper = $(wraper);
                  var prev = $(prev);
                  var next = $(next);
                  var img = $(img).find('ul');
                  var w = img.find('li').outerWidth(true);
                  var s = speed;
                  next.click(function()
                      {
                          img.animate({'margin-left':-w},function()
                          {
                              img.find('li').eq(0).appendTo(img);
                              img.css({'margin-left':0});
                              });
                      });
                  prev.click(function()
                  {
                      img.find('li:last').prependTo(img);
                      img.css({'margin-left':-w});
                      img.animate({'margin-left':0});
                      });
                  if (or == true)
                  {
                      ad = setInterval(function() { next.click();},s*770);
                      wraper.hover(function(){clearInterval(ad);},function(){ad = setInterval(function() { next.click();},s*970);});
                  }
              }
              DY_scroll('.img-scroll','.prev','.next','.img-list',3,true);// true为自动播放，不加此参数或false就默认不自动
              </script>
      </div>
    </div>
    <!--产品中心结束-->
    <div class="new_box">
    	<!--公司动态开始-->
    	<jsp:include page="list">
    		<jsp:param name="include" value="true"/>
    		<jsp:param name="categoryId" value="9"/>
    		<jsp:param name="pageSize" value="5"/>
    	</jsp:include>
    	<div class="new_com fl">
        	<h2><span class="fr"><a href="news.jsp?categoryId=9">更多></a></span><i>公司动态</i></h2>
            <ul>
            	<c:forEach items="${p.results}" var="content">
            	<li>
            		<span>[<fmt:formatDate value="${content.addTime}" pattern="yy.MM.dd"/>]</span>
            		<a href="#">${content.title}</a>
            	</li>
            	</c:forEach>                
            </ul>
        </div>
        <!--公司动态结束-->
        <!--业界动态开始-->
        <jsp:include page="list">
    		<jsp:param name="include" value="true"/>
    		<jsp:param name="categoryId" value="10"/>
    		<jsp:param name="pageSize" value="5"/>
    	</jsp:include>
        <div class="new_com other fl">
        	<h2><span class="fr"><a href="news.jsp?categoryId=10">更多></a></span><i>业界动态</i></h2>
            <ul>
            	<c:forEach items="${p.results}" var="content">
            	<li>
            		<span>[<fmt:formatDate value="${content.addTime}" pattern="yy.MM.dd"/>]</span>
            		<a href="#">${content.title}</a>
            	</li>
            	</c:forEach> 
            </ul>
        </div>
        <!--业界动态结束-->
        <!--技术支持开始-->
        <jsp:include page="list">
    		<jsp:param name="include" value="true"/>
    		<jsp:param name="categoryId" value="11"/>
    		<jsp:param name="pageSize" value="5"/>
    	</jsp:include>
        <div class="new_jc fr">
        	<h2><span class="fr"><a href="news.jsp?categoryId=11">更多></a></span><i>技术支持</i></h2>
            <ul>
            	<c:forEach items="${p.results}" var="content">
            	<li><a href="#">${content.title}</a></li>
                </c:forEach>
            </ul>
        </div>
        <!--技术支持结束-->
    </div>
    <div class="clear"></div>
     <!--服务客户开始-->
     <jsp:include page="list">
   		<jsp:param name="include" value="true"/>
   		<jsp:param name="categoryId" value="15"/>
   		<jsp:param name="pageSize" value="10"/>
   	</jsp:include>
     <div class="case">
     	<h2><span class="fr"><a href="#">更多></a></span><i>服务客户</i></h2>
        <div class="case_box">
 	         <div id="marquee1" class="marqueeleft">
	            <div style="width:8000px; padding:5px;">
	         	  <ul id="marquee1_1">
	         	  	<c:forEach items="${p.results}" var="content">
			        <li><a class="pic" href="showphoto.html"><img src="${content.pic}"></a><br /><a href="#" class="title">${content.title}</a></li>
			        </c:forEach>
                    
		          </ul>
		          <ul id="marquee1_2"></ul>
            	</div>
             </div><!--marqueeleft end-->    
             <script type="text/javascript">marqueeStart(1, "left");</script>
         </div>
     </div>
     <!--服务客户结束-->
     <div class="clear"></div>
     <!--友情链接开始-->
     <jsp:include page="list">
   		<jsp:param name="include" value="true"/>
   		<jsp:param name="categoryId" value="16"/>
   		<jsp:param name="pageSize" value="10"/>
   	</jsp:include>
     <div class="link">
     	<p class="link_list">
     		<c:forEach items="${p.results}" var="content">
     		<a href="${content.link}" target="_blank">${content.title}</a>
     		</c:forEach>
     	</p>
     </div>
     <!--友情链接结束-->
</div>
<!--主体结束-->
<!--页脚开始-->
<jsp:include page="inc/foot.jsp"/>
<!--页脚结束-->
</body>
</html>
