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
		<title>My JSP 'top.jsp' starting page</title>
		<meta http-equiv="pragma" content="no-cache">
		<meta http-equiv="cache-control" content="no-cache">
		<meta http-equiv="expires" content="0">
		<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
		<meta http-equiv="description" content="This is my page">
		<link href="<%=basePath%>/css/style.css" rel="stylesheet" />
		<script type="text/javascript" src="<%=basePath%>/js/jquery-1.11.1.js"></script>
		<style type="text/css">
#top-wrapper {
	background: black;
	height: 200px
}

h1 {
	vertical-align: center;
}
#div {
	background: green;
	height: 30px
}
#sy {
	width: 120px;
	height: 30px
}

</style>
	</head>

	<body>
		<div>
			<div id="top-wrapper" align="center">
				<div id="top" class="container">
					<div id="logo">
						<h1>
							<a href="#" style="color: white"><font face="华文彩云" size="+30">Java1234论坛</font>
							</a>
						</h1>
						<p>
							<a href="http://www.java1234.com/" rel="nofollow"
								style="color: white"><i>Java1234知识分享网</i> </a>
						</p>
						<p>
				<font color="white">当前用户:</font>
				<a href="admin?method=admininfo&hname=${name}" style="color: white">${name}</a>
				
				<a href="pro/login.jsp" style="color: white">[注销]</a>
			</p>
					</div>
				</div>
			</div>
			<div id="div">
				<center>
				<input id="sy" class="easyui-linkbutton" value="首页">
				<input id="sy" class="easyui-linkbutton" value="聊天室">
				<input id="sy" class="easyui-linkbutton" value="帖子室">
				</center>
			</div>
			
		</div>
	</body>
</html>
