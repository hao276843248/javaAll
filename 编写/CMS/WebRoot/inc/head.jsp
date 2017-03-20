<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<div class="header">
    <div class="h_top">
        <p><span><a href="#" title="中文版" class="zh">中文</a>|&nbsp;<a href="#" title="English" class="en">English</a></span><i>欢迎来到荣旭自动化科技有限公司网站！服务热线：0769-89229908</i></p>
    </div>
    <div class="h_con">
        <h1 class="logo"><a href="#" title=""><img src="images/logo1.jpg" alt="" title="深圳市易创峰电子有限公司"/></a></h1>
        <div class="search">
						  <script language="Javascript">
                                                  function fn_searchForm()
                                                  {
                                                      if (document.listform.key.value=="" || document.listform.key.value=="(请输入搜索关键字)"){
                                                          alert("(请输入搜索关键字)");
                                                          document.listform.skeyword.focus();
                                                      }else{
                                                          listform.action="#";
                                                          document.listform.submit();
                                                      }
                                                  }</script>
                          <form action="search.html">
                                                       <input name="key" type="text"  class="read"  id="key" value="(请输入搜索关键字)" size="35"  onFocus="this.value=''"/>
                                                       <input name="" type="submit" value=""  class="bt"/>
                                                       <input name="act" type="hidden" value="seartch" />
                                                   </form>   
                    </div>
    </div>
    <div class="h_nav">
        <ul>
            <li><a href="index.jsp" title="网站首页" class="cur">网站首页</a></li>
            <li><a href="about.html"title="公司简介">公司简介</a></li>
            <li><a href="products.html" title="产品中心">产品中心</a></li>
            <li><a href="cases.html" title="合作案例">合作案例</a></li>
            <li><a href="news.jsp?categoryId=9" title="新闻资讯">新闻资讯</a></li>
            <li><a href="download.html" title="资料下载">资料下载</a></li>
            <li><a href="zhao.html" title="人才招聘">人才招聘</a></li>
            <li><a href="message.html" title="在线留言">在线留言</a></li>
            <li class="nobot"><a href="contact.html" title="联系我们" >联系我们</a></li>
        </ul>
    </div>
    <div id="flash">
                     <div class="flash_box">
                     <SCRIPT type=text/javascript>
                             	
    imgUrl1="images/banner_25.jpg";
    imgtext1="11"
    imgLink1=escape("#");
    //imgLink1="";
    
    imgUrl2="images/banner_25.jpg";
    imgtext2="22"
    imgLink2=escape("#");
    //imgLink2="";
    
  
    imgUrl3="images/banner_25.jpg";
    imgtext3="33"
    imgLink3=escape("#");
    //imgLink3="";
	

     var focus_width=993
     var focus_height=307
     var text_height=0
     var swf_height = focus_height+text_height
     
     var pics=imgUrl1+"|"+imgUrl2+"|"+imgUrl3
     var links=imgLink1+"|"+imgLink2+"|"+imgLink3
     var texts=imgtext1+"|"+imgtext2+"|"+imgtext3
     var flashCode = '<object classid="clsid:d27cdb6e-ae6d-11cf-96b8-444553540000" codebase="http://fpdownload.macromedia.com/pub/shockwave/cabs/hotdeploy/flash/swflash.cab#version=6,0,0,0" width="'+ focus_width +'" height="'+ swf_height +'">';
     flashCode = flashCode + '<param name="allowScriptAccess" value="sameDomain"><param name="movie" value="focus2.swf"><param name="quality" value="high"><param name="bgcolor" value="#F0F0F0">';
     flashCode = flashCode + '<param name="menu" value="false"><param name=wmode value="opaque">';
     flashCode = flashCode + '<param name="FlashVars" value="pics='+pics+'&links='+links+'&texts='+texts+'&borderwidth='+focus_width+'&borderheight='+focus_height+'&textheight='+text_height+'">';
     flashCode = flashCode + '<embed src="focus2.swf" quality="high" pluginspage="http://www.macromedia.com/go/getflashplayer" type="application/x-shockwave-flash" width="'+ focus_width +'" height="'+ swf_height +'" FlashVars="pics='+pics+'&links='+links+'&texts='+texts+'&borderwidth='+focus_width+'&borderheight='+focus_height+'&textheight='+text_height+'"></embed>';
     flashCode = flashCode + '</object>';
     document.write(flashCode)
                             </SCRIPT>
                     </div>
           </div><!--flash end-->
</div>