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

		<title>My JSP 'main.jsp' starting page</title>

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
#north {
	background: yellow
}
</style>
		<script type="text/javascript">
		$(function(){
			var bk="bk.jsp";
			var tz="tz.jsp";
			var hf="hf.jsp";
			var yh="yh.jsp";
			var xz="xz.jsp";
			var curPage='${mainPage}';
			if(bk.indexOf(curPage)>=0&&curPage!=""){
				$("#bk").addClass("active");
			} else if(tz.indexOf(curPage)>=0&&curPage!=""){
				$("#tz").addClass("active");
			} else if(hf.indexOf(curPage)>=0&&curPage!=""){
				$("#hf").addClass("active");
			} else if(yh.indexOf(curPage)>=0&&curPage!=""){
				$("#yh").addClass("active");
			}else if(xz.indexOf(curPage)>=0&&curPage!=""){
				$("#xz").addClass("active");
			}
		})
		
		</script>
	</head>
	<body class="easyui-layout">
		<div data-options="region:'north',title:'欢迎来到JAVA1234论坛',split:true"
			style="height: 120px;" id="north">
			<center>
				<font face="华文彩云" size="+30">Java1234论坛</font>
				<br>
				<a href="back/login.jsp" style="color: back">[注销]</a>
			</center>
		</div>
		<div data-options="region:'west',title:'菜单',split:true"
			style="width: 200px;">
			<ul>
			<li id="bk"><a href="backadmin?method=bk"> <span>板块管理</span></a></li>
			<li id="tz"><a href="backadmin?method=tz"> <span>帖子管理</span></a></li>
			<li id="hf"><a href="backadmin?method=hf"> <span>回复管理</span></a></li>
			<li id="yh"><a href="backadmin?method=yh"></i> <span>用户管理</span></a></li>		
			<li id="xz"><a href="backadmin?method=xz"></i> <span>下载管理</span></a></li>			
		</ul>
			
		</div>
		<div data-options="region:'center',title:'首页'"
			style="padding: 5px; background: #eee;">
			<jsp:include page="${mainPage}"></jsp:include>
			</div>
	</body>

</html>
