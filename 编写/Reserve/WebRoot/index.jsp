<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="/struts-tags" prefix="s"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>无标题文档</title>
<link rel="stylesheet" type="text/css" href="css/style.css"/>
<script src="js/My97DatePicker/WdatePicker.js"></script>
<script>
	function toPage(i){
		document.getElementById("pageIndex").value=i;
		document.getElementById("frmSearch").submit();
	}
</script>
</head>
<body>
	<div id="title"></div>
    
    <div id="main">        	
        <div id="topic">
            预约列表
            <div id="oper">
                <a href="add.html">添加预约</a>
            </div>

        </div>
        <div id="search">
		<s:form action="list" method="post" id="frmSearch">
			<s:hidden name="pageIndex" id="pageIndex"/>
			<s:textfield name="reserveDate" cssClass="txt Wdate" onclick="WdatePicker({skin:'ext',readOnly:true})"/>
        	<s:select list="#{8:'8:00',9:'9:00',10:'10:00',11:'11:00',12:'12:00',13:'13:00',14:'14:00',15:'15:00',16:'16:00',17:'17:00'}" name="beginTime"/>			
			<s:select list="#{8:'8:00',9:'9:00',10:'10:00',11:'11:00',12:'12:00',13:'13:00',14:'14:00',15:'15:00',16:'16:00',17:'17:00'}" name="endTime"/>
			<s:select list="#{1:'空闲',2:'已预订'}" name="status"/>
			
            <input type="button" value="搜索" onclick="toPage(1)"/>
        </s:form>
        </div>
		
        <div class="list">
            <div class="row head">
                <div class="row-wrap">
                    <div class="c3">日期</div>
                    <div class="c3">会议室</div>
					<div class="c3">状态</div>					
                    <div class="c3">占用时间</div>
					<div class="c3">预约人</div>
                    <div class="c3">操作</div>                
                </div>
            </div>
			<s:iterator value="p.results" var="row">
			<div class="row">
				
                <div class="row-wrap">
                	<s:if test="#row[1]!=null">
                		<div class="c3">
                			<s:property value="#row[1].reserveDate"/>
                		</div>
                	</s:if>
                	<s:else><div class="c3">----</div></s:else>
                    
                    <div class="c3"><s:property value="#row[0].name"/></div>
                    
                    <s:if test="#row[1]!=null">
                		<div class="c3">已预订</div>
                	</s:if>
                	<s:else><div class="c3">空闲</div></s:else>
                	                                        
                    <s:if test="#row[1]!=null">
                		<div class="c3">
                			<s:property value="#row[1].beginTime"/>-
                			<s:property value="#row[1].endTime"/>
                		</div>
                	</s:if>
                	<s:else><div class="c3">----</div></s:else> 
                   
					<s:if test="#row[1]!=null">
                		<div class="c3">
                			<s:property value="#row[1].name"/>                			
                		</div>
                	</s:if>
                	<s:else><div class="c3">----</div></s:else> 
                	
                	
                    <div class="c3">
                    	<s:if test="#row[1]==null">
                    		<s:a action="edit">
                    			<s:param name="id" value="#row[0].id"/>
                    			<s:param name="reserveDate" value="reserveDate"/>
                    			<s:param name="beginTime" value="beginTime"/>
                    			<s:param name="endTime" value="endTime"/>
                    			预订
                    		</s:a>
							
						</s:if>
					</div>                
                </div>
            </div>
			</s:iterator>
			
            <div class="pagination">
            	<div class="pg-left">
            		<s:if test="p.pageIndex>1">
                	<a href="javascript:toPage(1)">首页</a>
                	<a href="javascript:toPage(${p.pageIndex-1})">上页</a>
                	</s:if>
                	<s:if test="p.pageIndex<p.pageCount">
                	<a href="javascript:toPage(${p.pageIndex+1})">下页</a>
                	<a href="javascript:toPage(${p.pageCount})">尾页</a>   
                	</s:if>
                    [${p.pageIndex}/${p.pageCount}]                                                                         
                </div>            	          
            </div>
            
        </div>
    </div>
	<div id="foot">
    	&copy;2016&nbsp;通州北大青鸟
    </div>
</body>
</html>
