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
<body style="background: #0288d1;filter:alpha(opacity=50)">
	<table style="color: white">
		<tr>
			<td align="left"><img
				src="${pageContext.request.contextPath}/static/img/icon.png"></td>
			<td style="font-size: 35px;">|实验室管理系统</td>
		</tr>
	</table>
	<div class="main-login">

		<div class="login-content"  style=" float: right; margin-right: 50px; margin-top: auto; margin-bottom: auto;">
			<h2>用户登录</h2>
			<form action="" method="post" id="loginForm" name="loginForm">
				
				<div class="login-info">
					<span class="user">&nbsp;</span> <input name="loginName"
						id="loginName" type="text" value="" class="login-input" placeholder="请输入用户名" />
				</div>
				<div class="login-info">
					<span class="pwd">&nbsp;</span> <input name="password"
						id="password" type="password" value="" class="login-input"  placeholder="请输入密码"/>
				</div>
				<!-- 
				<div class="login-oper">
					<input style="margin: 1px 10px 0px 2px; float: left;" name=""
						type="checkbox" value="" checked="checked" /><span>记住密码</span>
				</div>
				 -->
				<div class="login-oper"></div>
				<div class="login-oper">
					<input name="" type="button" id="btnLogin" value="登 录"
						class="login-btn" /> <input name="" type="button" id="btnClear"
						value="重 置" class="login-reset" />
				</div>
			</form>
		</div>

	</div>


</body>
</html>