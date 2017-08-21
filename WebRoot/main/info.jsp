<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
	<head>
		<base href="<%=basePath%>">

		<title>My JSP 'info.jsp' starting page</title>

		<meta http-equiv="pragma" content="no-cache">
		<meta http-equiv="cache-control" content="no-cache">
		<meta http-equiv="expires" content="0">
		<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
		<meta http-equiv="description" content="This is my page">
		<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->

	</head>

	<body>
	<CENTER>
		<div id="top" class="wrap" style="width: 1200px; margin: 0 auto;"></div>
		<jsp:include page="../main/top.jsp" />
		<div id="center"></div>
		<table style="col" width="1200px"  border="1" align="center" >
			<tr>
				<th>ID</th>
				<th>昵称</th>
				<th>生日</th>
				<th>性别</th>
				<th>头像</th>
				<th>经验值</th>
				<th>金币数量</th>
				<th>擅长领域</th>
				<th>用户权限</th>
				<th>操作</th>			
			</tr>
			<c:forEach var="v" items="${list}">
			<tr>
				<td>${v.infoId}</td>
				<td>${v.uname}</td>
				<td>${v.birth}</td>
				<td>${v.sex}</td>
				<td>${v.picture}</td>
				<td>${v.exp}</td>
				<td>${v.money}</td>
				<td>${v.spe}</td>
				<td>${v.authMsg}</td>
				<td><a href="#">操作</a></td>
			</tr>
			</c:forEach>
		</table>
		<div id="low"></div>
		<jsp:include page="../main/low.jsp" />
		</CENTER>
	</body>
</html>
