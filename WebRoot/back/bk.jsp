<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
	<head>
		<base href="<%=basePath%>">

		<title>My JSP 'bk.jsp' starting page</title>

		<meta http-equiv="pragma" content="no-cache">
		<meta http-equiv="cache-control" content="no-cache">
		<meta http-equiv="expires" content="0">
		<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
		<meta http-equiv="description" content="This is my page">
		<link rel="stylesheet" type="text/css"
			href="js/easyui/themes/default/easyui.css">
		<link rel="stylesheet" type="text/css"
			href="js/easyui/themes/icon.css">
		<link rel="stylesheet" type="text/css" href="js/easyui/demo/demo.css">
		<script type="text/javascript" src="js/easyui/jquery.min.js"></script>
		<script type="text/javascript" src="js/easyui/jquery.easyui.min.js"></script>
		<style type="text/css">
		
		
		</style>
		<script type="text/javascript">
	
	function toupdate(uid){
			 $.get('bclass?method=toupdate&id='+uid,null,function(data,status,xhr){
				$.messager.alert("消息",data);
				var json=eval("("+data+")");
				if (json.flag) {
					$.messager.alert("错误消息",'没有找到相关信息！！');
				}else{
					 $("#dd").dialog('open');
	            	 $("#id1").val(json.uid);
	            	 $("#uname1").val(json.uname);	            	 
	            	 $("#upwd1").val(json.upwd);
	            	 $("#exp1").val(json.exp);
	            	 $("#money1").val(json.money);
	            	 $("#birth1").val(json.birth);
	            	 $("#picture1").val(json.picture);
	            	 $("#spe1").val(json.spe);
	            	 $("#authId1").val(json.authMsg);            	 
				}
			});
		};
	function del(uid){
		 $.get('bclass?method=del&id='+uid,null,function(data,status,xhr){
			$.messager.alert("消息",'删除成功！');
			var json=eval("("+data+")");
			if (json.flag) {
				$("#datagrid").datagrid('reload');
			}else{
				$.messager.alert("消息",'没有删除成功！！');
			}
		});
	};	
	$(function(){
	$("#datagrid").datagrid({
	url:'bclass?method=sel',
	title:'版块信息',	
	columns : [ [{
				field : 'id',                                                        
				title : '', 
				width : 50,
				formatter:function(val,rowData,index){
        		var str1= "<input type='checkbox' value='"+rowData.uid+"'>";
       			return str1;                  
      			},
			},{
				field : 'classId',                                                        
				title : '编号', 
				width : 300
			}, {
				field : 'className',
				title : '小版块名称 ',
				width : 300
			},{
				field : 'classPicture',
				title : '小版块logo',
				width : 300
			},{
				field : 'userName',
				title : '版主',
				width : 300
			},{
                field:"op",
                title:'操作',
                width:500,
                formatter:function(val,rowData,index){
                  var str1= "<a href='javascript:del("+rowData.uid+")'>删除</a>";
                  var str2= "<a href='javascript:toupdate("+rowData.uid+")'>修改</a>";
                  return str1          +            str2;                  
                },               
       		 }          
            ]],
           
            singleSelect:true,
            pagination:true,  //显示分页工具栏
			pageSize:2,  //设置每页显示记录数  注意：必须配合pageList一起使用
			pageList:[2,4,6,8,10], //可以选择的每页显示记录数
	});
	
	//
	$("#up").on("click",function(){$.post('bclass?method=update',$("#f1").serialize(),function(data,status,xhr){
		$.messager.alert("错误消息",data);
		var json=eval("("+data+")");
		if (json.flag) {
			$("#dd").dialog('close');
			$("#datagrid").datagrid('reload');
		}
	});
	});
	//
	$("#add").on("click",function(){
		$("#dd2").dialog('open');
	});
	$("#tj").on("click",function(){$.post('bclass?method=add',$("#f2").serialize(),function(data,status,xhr){
		$.messager.alert("错误消息",data);
		var json=eval("("+data+")");
		if (json.flag) {
			$("#dd2").dialog('close');
			$("#datagrid").datagrid('reload');
		}
	});
	});
	//
	$("#sel").on("click",function(){
		$('#datagrid').datagrid('load',{
			name3: $("#name3").val(),
			bid3: $("#bid3").val()
		});
	});
	
	});
	

	
	</script>

	</head>

	<body>

		<form id="f3">
		
			<label for="name3">
				版块名称:
			</label>
			<input id="name3" name="name3" class="easyui-validatebox">
			<label for="bid3">
				版主:
			</label>
			<input id="bid3" class="easyui-combobox" name="bid3"
				data-options="valueField:'uid',textField:'uname',url:'bclass?method=getbname'" />
			<input id="sel" class="easyui-linkbutton" value="查询"
				style="width: 50px; height: 30px">
			<input id="add" class="easyui-linkbutton" value="添加版块"
				style="width: 100px; height: 30px">
			<input id="dels" class="easyui-linkbutton" value="批量删除"
				style="width: 100px; height: 30px">
		</form>

		<table id="datagrid" class="easyui-datagrid" width="1350px"
			height="500px"></table>

		<div id="dd" class="easyui-dialog" style="width: 600px; height: 500px"
			data-options="closed:true">
			<center>
				<form id="f1">
					<p>
						<h1>
							版块修改
						</h1>
					</p>
					
					<p>
						<label for="bname1">
							板块名称：
						</label>
						<input id="bname1" name="bname1" class="easyui-validatebox"
							required="true">
					</p>
					<p>
						<label for="info1">
							板块介绍：
						</label>
						<input id="info1" name="info1" class="easyui-validatebox"
							required="true">
					</p>
					<p>
						<label for="picture1">
							logo：
						</label>
						<input id="picture1" name="picture1" class="easyui-validatebox"
							required="true">
					</p>
					<p>

						<label for="uname1">
							版主:
						</label>
						<input id="uname1" name="uname1" class="easyui-validatebox"
							required="true">
					</p>

					<p>
						<input id="up" class="easyui-linkbutton" value="修改">
					</p>

				</form>
			</center>
		</div>

		<div id="dd2" class="easyui-dialog"
			style="width: 600px; height: 500px" data-options="closed:true">
			<center>
				<form id="f2">
					<p>
						<h1>
							版块添加
						</h1>
					</p>
					<p>
						<label for="bname2">
							板块名称：
						</label>
						<input id="bname2" name="bname2" class="easyui-validatebox"
							required="true">
					</p>
					<p>
						<label for="info2">
							板块介绍：
						</label>
						<input id="info2" name="info2" class="easyui-validatebox"
							required="true">
					</p>
					<p>
						<label for="picture2">
							logo：
						</label>
						<input id="picture2" name="picture2" class="easyui-validatebox"
							required="true">
					</p>
					<p>

						<label for="uname2">
							版主:
						</label>
						<input id="uname2" name="uname2" class="easyui-validatebox"
							required="true">
					</p>
					<p>
						<input id="tj" class="easyui-linkbutton" value="添加">
					</p>

				</form>
			</center>
		</div>
	</body>
</html>
