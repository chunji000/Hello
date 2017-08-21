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

		<script type="text/javascript">
	function toupdate(uid){
			 $.get('backadmin?method=toupdate&id='+uid,null,function(data,status,xhr){
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
		 $.get('backadmin?method=del&id='+uid,null,function(data,status,xhr){
			$.messager.alert("消息",data);
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
	url:'backadmin?method=sel',
	title:'用户信息',	
	columns : [ [ {
				field : 'uid',                                                        
				title : 'ID', 
				width : 100
			}, {
				field : 'uname',
				title : '昵称 ',
				width : 100
			},{
				field : 'upwd',
				title : '登录密码',
				width : 100
			},{
				field : 'sex',
				title : '性别 ',
				width : 100
			},{
				field : 'picture',
				title : '头像',
				width : 100
			}
			,{
				field : 'birth',
				title : '生日 ',
				width : 100
			}
			,{
				field : 'exp',
				title : '经验值',
				width : 100
			}
			,{
              field : 'money',
              title : '金币 ',
              width : 100
            } 
            ,{
                field : 'spe',
                title : '擅长领域 ',
                width : 100
            },{
                field : 'regTime',
                title : '注册时间',
                width : 100
                },{
                field : 'lastTime',
                title : '上次登陆时间',
                width : 100
            },{
                field : 'authMsg',
                title : '用户类型',
                width : 100
             },
            {
                field:"op",
                title:'操作',
                width:100,
                formatter:function(val,rowData,index){
                  var str1= "<a href='javascript:del("+rowData.uid+")'>删除</a>";
                  var str2= "<a href='javascript:toupdate("+rowData.uid+")'>修改</a>";
                  return str1+str2;                  
                },               
       		 }          
            ]],
           
            singleSelect:true,
            pagination:true,  //显示分页工具栏
			pageSize:2,  //设置每页显示记录数  注意：必须配合pageList一起使用
			pageList:[2,4,6,8,10], //可以选择的每页显示记录数
	});
	
	//
	$("#up").on("click",function(){$.post('backadmin?method=update',$("#f1").serialize(),function(data,status,xhr){
		$.messager.alert("错误消息",data);
		var json=eval("("+data+")");
		if (json.flag) {
			$("#dd").dialog('close');
			$("#datagrid").datagrid('reload');
		}
	});
	});
	//
	$("#sel").on("click",function(){
		$('#datagrid').datagrid('load',{
			name3: $("#name3").val(),
			id3: $("#id3").val(),
			work3: $("#work3").val()
		});
	});
	
	});
	

	
	</script>

	</head>

	<body>
		<form id="f3">
			<label for="id3">
				用户编号：
			</label>
			<input id="id3" name="id3" class="easyui-validatebox">
			<label for="name3">
				用户昵称:
			</label>
			<input id="name3" name="name3" class="easyui-validatebox">
			<label for="work3">
				擅长领域:
			</label>
			<input id="work3" name="work3" class="easyui-validatebox">
			<input id="sel" class="easyui-linkbutton" value="查询" style="width: 50px;height: 30px">
		</form>

		<table id="datagrid" class="easyui-datagrid" width="1350px"
			height="500px"></table>

		<div id="dd" class="easyui-dialog" title="用户修改"
			style="width: 600px; height: 500px" data-options="closed:true">
			<center>
				<form id="f1">
					<p><h1>用户修改</h1></p>
					<p>
						<label for="id1">
							ID:
						</label>
						<input id="id1" name="id1" class="easyui-validatebox"
							data-options="readonly:true">
					</p>
					<p>
						<label for="uname1">
							昵称：
						</label>
						<input id="uname1" name="uname1" class="easyui-validatebox"
							required="true">
					</p>
					<p>
						<label for="sex1">
							性别：
						</label>
						<input id="sex1" name="sex1" type="radio" value="M">
						男
						<input id="sex1" name="sex1" type="radio" value="F">
						女
					</p>
					<p>
						<label for="upwd1">
							登陆密码：
						</label>
						<input id="upwd1" name="upwd1" class="easyui-validatebox"
							required="true">
					</p>
					<p>
						<label for="picture1">
							头像：
						</label>
						<input id="picture1" name="picture1" class="easyui-validatebox"
							required="true">
					</p>
					<p>
						<label for="birth1">
							生日：
						</label>
						<input id="birth1" name="birth1" class="easyui-validatebox"
							required="true">
					</p>
					<p>

						<label for="exp1">
							经验:
						</label>
						<input id="exp1" name="exp1" class="easyui-validatebox"
							required="true">
					</p>
					<p>

						<label for="money1">
							金币:
						</label>
						<input id="money1" name="money1" class="easyui-validatebox"
							required="true">
					</p>
					<p>

						<label for="spe1">
							擅长领域:
						</label>
						<input id="spe1" name="spe1" class="easyui-validatebox"
							required="true">
					</p>
					<p>

						<label for="authId1">
							用户类型:
						</label>
						<input id="authId1" name="authId1" class="easyui-validatebox"
							data-options="readonly:true">
					</p>
					<p>
						<input id="up" class="easyui-linkbutton" value="修改">
					</p>

				</form>
			</center>
		</div>
	</body>
</html>
