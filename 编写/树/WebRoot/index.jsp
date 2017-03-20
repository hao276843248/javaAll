<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<!DOCTYPE html>
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8"/>
    <title></title>
<script type="text/javascript" src="jQueryeasyui/Scripts/jquery-1.8.0.min.js"></script>
<script type="text/javascript" src="jQueryeasyui/Scripts/jquery.easyui.min.js"></script>
<link rel="stylesheet" href="jQueryeasyui/Content/themes/default/easyui.css" type="text/css"></link>
<link rel="stylesheet" href="jQueryeasyui/Content/themes/icon.css" type="text/css"></link>
</head>
     <style type="text/css">
        * {
            margin: 0 auto;
        }
li{
list-style:none;
}
        .container {
            width: 850px;
        }

        .tree_container {
            margin: 10px auto;
            width: 240px;
            height: 500px;
            float: left;
            border: solid 1px #808080;
            text-align: left;
            overflow: auto;
        }

        .edit_container {
            margin: 10px auto;
            width: 600px;
            height: 500px;
            float: right;
            border: solid 1px #808080;
            text-align: left;
            position: relative;
            overflow: auto;
        }

        .textbox {
            width: 80%;
        }

        .table {
            width: 100%;
        }

            .table td {
                text-align: left;
                font-size: 16px;
            }

            .table th {
                text-align: center;
                width: 100px;
            }

        .dept_desc {
            height: 300px;
            width: 80%;
        }

        .rbl_status {
            width: 100%;
        }
    </style>
    <!-- <script type="text/javascript">
    $(function(){
   
    $(".easyui-tree").tree({
    url:"getNodes.action",
    onClick:function(node){
    getNode(node.id);
    
    }
    });
    })
        function getNode(id) {
       
            $.getJSON("getDeptById.action", "dept.deptid=" + id, function (data) {
                $("#DeptName").val(data.deptname);
                $("#DeptCode").val(data.deptcode);
                $("#Description").html(data.description);
                $("#DeptId").val(data.deptid);
                $("#parentid").val(data.parentid);
                if (data.status == true) {
                    $("#status_1").attr("checked", "checked");
                } else {
                    $("#status_0").attr("checked", "checked");
                }
                
            });
        }//点击不同的按钮执行不同的操作
        $(function () {
            /* $("#addDept").click(function () {
                $("#opeType").val("Add");  
                document.myform.submit(); 
            }); */
            $("#addDept").click(function () {
                var name=$("#DeptName").val();
                var code=$("#DeptCode").val();
                var des=$("#Description").html();
                var id=$("#DeptId").val();
                $.post("addDept.action","dept.deptcode="+code+"&dept.deptname="+name+
                "&dept.description="+des+"&dept.parentid="+id,function(data){
                	$("#mes").html(data.mes);
                	$(".easyui-tree").tree({
    					url:"getNodes.action",
    					onClick:function(node){
    					getNode(node.id);
    					}
    				});
                })
            });
            
            /* $("#updateDept").click(function () {
                $("#opeType").val("Edit");
                document.myform.submit(); 
            }); */
            $("#updateDept").click(function () {
                var name=$("#DeptName").val();
                var code=$("#DeptCode").val();
                var des=$("#Description").html();
                var id=$("#DeptId").val();
                var pid=$("#parentid").val();
                alert("dept.deptid="+id+"&dept.deptcode="+code+"&dept.deptname="+name+
                "&dept.description="+des+"&dept.parentid="+pid)
                $.post("updateDept.action","dept.deptid="+id+"&dept.deptcode="+code+"&dept.deptname="+name+
                "&dept.description="+des+"&dept.parentid="+pid,function(data){
                	$("#mes").html(data.mes);
                	$(".easyui-tree").tree({
    					url:"getNodes.action",
    					onClick:function(node){
    					getNode(node.id);
    					}
    				});
                })
            });
            /* 
            $("#delDept").click(function () {
                $("#opeType").val("Del");
                document.myform.submit(); 
            }); */
            $("#delDept").click(function () {
                var id=$("#DeptId").val();
                $.post("delDept.action","dept.deptid="+id,function(data){
                	$("#mes").html(data.mes);
                	$(".easyui-tree").tree({
    					url:"getNodes.action",
    					onClick:function(node){
    					getNode(node.id);
    					}
    				});
                })
            });
        })
    </script> -->
    <script type="text/javascript">
    function getNode(id) {
       
            $.getJSON("getDeptById.action", "dept.deptid=" + id, function (data) {
                $("#DeptName").val(data.deptname);
                $("#DeptCode").val(data.deptcode);
                $("#Description").html(data.description);
                $("#DeptId").val(data.deptid);
                $("#parentid").val(data.parentid);
                if (data.status == true) {
                    $("#status_1").attr("checked", "checked");
                } else {
                    $("#status_0").attr("checked", "checked");
                }
                
            });
        }
    
    $(document).ready(function(){
  		 var tree = $("#tree");
  		 tree.getChildByid(0);
	});
	jQuery.fn.extend({
	  getChildByid: function(pid) {
	  		var tree = $(this);
		  $.getJSON("getChildByid.action", "dept.parentid=" + pid, function (data) {
	             for(i = 0; i < data.length; i ++){
	             	/* var li = $("<li></li>");
	             	var a = $("<a></a>");
	             	a.append("+");
	             	li.append(a).append(data[i].deptname);
	             	li.attr("cid",data[i].deptid); */
	       			
	       			var li = $("<li></li>");
	             	var a = $("<a></a>");
	       			var b = $("<a></a>");
	             	a.append("<img src='sum.png'/>");
			0b.append(data[i].deptname);
	             	li.append(a).append(b);
	             	li.attr("cid",data[i].deptid);
			b.attr("cid",data[i].deptid);
	       		
			b.bind("click", function(){
				var b=$(this);
				getNode(b.attr("cid"));
			});
	             	a.bind("click", function(){
  						var pli = $(this).parent();
  						
  						var ul = pli.find("ul");
  						if(ul.html()){
  						ul.remove();
  						}else{
  						ul = $("<ul></ul>");
  						pli.append(ul);
  						//alert(pli.attr("cid"));
  						ul.getChildByid(pli.attr("cid"));
  						}
  						
					});
					tree.append(li);
	             	//tree.append("<li><a> + </a>"+data[i].name+"</li>");
	             }
	        });
	  }
	});
	</script>
<body>
    <div class="container">
    <div class="tree_container">
<!-- 显示树的节点 -->
        <ul  id="tree">
           
        </ul>
	<!-- <a href="getNodes">a</a> -->
    </div>

    <div class="edit_container">

      <form action="handDept.action"  method="post" name="myform">
            
            <input type="hidden" value="Add" id ="opeType" name ="opeType"/>
            <table class="table">
                <tr>
                    <th>部门名称
                    </th>
                    <td>
                      <input type="text" value="" style="width: 272px; height: 21px"  id="DeptName" name="dept.deptname"/>
                        <input type="hidden" value="" name="dept.deptid" id="DeptId" />
                        <input type="hidden" value="" name="dept.parentid" id="parentid" />
                        <br />
                       
                    </td>
                </tr>
                <tr>
                    <th>部门代码
                    </th>
                    <td>
                        <input type="text" value="" style="width: 269px; height: 24px"  id="DeptCode" name="dept.deptcode" />
                        <br />
                     
                    </td>
                </tr>
                <tr>
                    <th>部门描述
                    </th>
                    <td>
                       <textarea style="width: 407px; height: 215px" id="Description" name="dept.description">

                       </textarea>
                        <br />
                       
                    </td>
                </tr>
                <tr>
                    <th>状&nbsp;&nbsp;态
                    </th>
                    <td>
                       
                        <input type="radio" name="dept.status" id="status_1" value="1"/>启用
                <input type="radio" name="dept.status" id="status_0" value="0"/>禁用
                    </td>
                </tr>
                <tr>
                    <td></td>
                    <td>
                        <input type="button" value="添加" id="addDept" class="button" />
                        <input type="button" value="修改" id="updateDept" class="button" />
                        <input type="button" value="删除" id="delDept" class="button" />
                    </td>
                </tr>
                <tr>
                	<td colspan="2" id="mes"></td>
                </tr>
            </table>
     </form>
        <div id="message"></div>
    </div>
</div>


   
</body>
</html>
