<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
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
	<script type="text/javascript">
	
	
	</script>
<style>

body {
	font-family: Microsoft YaHei, Segoe UI, Tahoma, Arial, Verdana,
		sans-serif;
	font-size: 12px;
	color: #fff;
	height: 100%;
	line-height: 1;
	background: #999
}

</style>
  </head>
  
  <body>
  <center>
  <h1>登录错误，请重新登录！</h1> 
  <div class="msg">
				<p>对不起：登陆失败！请检查用户名或密码并重新登陆。</p>
				<p>正在重新进入登陆界面...</p>
				<script type="text/javascript">
					setTimeout("location.href='pro/login.jsp'", 3000);
				</script>
			</div>
	</center>
  </body>
</html>
