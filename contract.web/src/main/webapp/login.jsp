<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<%@ include file="/jsp/public/top.jsp"%>
<link href="${pageContext.request.contextPath}/static/css/login.css"
	rel="stylesheet" type="text/css" />
<script type="text/javascript"
	src="${pageContext.request.contextPath}/static/pageJs/login.js"></script>
</head>
<body style="background:url(${pageContext.request.contextPath}/static/img/login/login.png) no-repeat center center fixed;background-size: 100%;">
	<table style="color: white">
		<tr>
			<td align="left"><img
				src="${pageContext.request.contextPath}/static/img/logo.png"></td>
			<td style="font-size: 35px;">|实验室管理系统</td>
		</tr>
	</table>
	<div class="main-login">

		<form id="loginForm" name="loginForm">
			<h2>用户登录</h2>
			<div class="form-group">
				<input type="text" name="loginName" id="loginName" required class="form-control" style=" border-radius:0px;height:43px;" placeholder="请输入用户名">
			</div>
			<div class="form-group">
				<input type="password" name="password" id="password" required style=" border-radius:0px;height:43px;"  required="" class="form-control" 
				placeholder="请输入密码" ></div>
			<div class="login_link">&nbsp;</div>
			<button class="btn btn-lg btn-primary btn-block" id="btnLogin" type="button">登录</button>


			<!-- <a class="btn btn-lg btn-info btn-block" href="https://show.metinfo.cn/muban/M1156014/381/member/register_include.php?lang=cn">没有账号？现在去注册</a> 
			 -->
		</form>

	</div>


</body>
</html>