<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
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

		<title>My JSP 'login.jsp' starting page</title>

		<meta http-equiv="pragma" content="no-cache">
		<meta http-equiv="cache-control" content="no-cache">
		<meta http-equiv="expires" content="0">
		<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
		<meta http-equiv="description" content="This is my page">
	 <script type="text/javascript" src="js/easyui/jquery.min.js"></script>
		<script type="text/javascript" src="js/easyui/jquery.easyui.min.js"></script>
		<style type="text/css">
body {
	background: black
}
h1 {
	font-size: 30px;
	font-weight: 700;
	text-shadow: 0 1px 4px rgba(0, 0, 0, .2)
}

.login-box {
	width: 410px;
	margin: 120px auto 0 auto;
	text-align: center;
	padding: 30px;
	background: white;
	border-radius: 10px;
}
.login-box .name,.login-box .password,.login-box .code,.login-box .remember
	{
	font-size: 16px;
	text-shadow: 0 1px 2px rgba(0, 0, 0, .1)
}

.login-box .remember input {
	box-shadow: none;
	width: 15px;
	height: 15px;
	margin-top: 25px
}

.login-box .remember {
	padding-left: 40px
}

.login-box .remember label {
	display: inline-block;
	height: 42px;
	width: 70px;
	line-height: 34px;
	text-align: left
}

.login-box label {
	display: inline-block;
	width: 100px;
	text-align: right;	
	vertical-align: middle
}
button {
	cursor: pointer;
	width: 150px;
	height: 30px;
	padding: 0;
	background: black;
	border: 1px solid #ff730e;
	border-radius: 6px;
	font-weight: 700;
	color: #fff;
	font-size: 16px;
	letter-spacing: 15px;
	margin-top: 10px;	
	margin-left:100px;
	text-shadow: 0 1px 2px rgba(0, 0, 0, .1)
}
#error{
	margin-left:100px
	
}
</style>
		<script type="text/javascript">
function check(){
	 alert(1);
	 var name=$("#name").val();
	 var password=$("#password").val();
	
	 if(name==""){
		 $("#error").html("昵称不能为空！");
		 return false;
	 }
	 if(password==""){
		 $("#error").html("密码不能为空！");
		 return false;
	 }
	 return true;
}



</script>
	</head>

	<body>
	<center>
		<div class="login-box">
			<h1>
				java12134后台登录
			</h1>
			<form action="backadmin?method=login" method="post"
				onsubmit="return check();">
				<table>
					<tr class="name">
						<td>
							<label>
								昵 称：
							</label>
						</td>
						<td>
							<input type="text" id="name" name="name" tabindex="1"
								autocomplete="off" />
						</td>
					</tr>
					<tr class="password">
						<td>
							<label>
								密 码：
							</label>
						</td>
						<td>
							<input type="password" name="password" maxlength="16"
								id="password" tabindex="2" />
						</td>
					</tr>
					<tr>
						<td colspan="2">
							<button type="submit" tabindex="5"">
								进入后台
							</button>
							<br>
							
							<font id="error" style="font-size: 20px;" color="red">${error
								} </font>
						</td>
					</tr>


				</table>
			</form>
		</div>
		</center>
	</body>
</html>
