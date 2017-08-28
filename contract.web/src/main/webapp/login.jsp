<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<%@ include file="/jsp/public/top.jsp"%>
<link href="${pageContext.request.contextPath}/static/css/login.css" rel="stylesheet" type="text/css" />
<script type="text/javascript"
	src="${pageContext.request.contextPath}/static/pageJs/login.js"></script>
</head>
<body>

	<div class="main-login">

		<div class="login-content">
			<h2>用户登录</h2>

			<form action="" method="post" id="loginForm" name="loginForm">
				<div class="login-info">
					<span class="user">&nbsp;</span> <input name="loginName"
						id="loginName" type="text" value="" class="login-input" />
				</div>
				<div class="login-info">
					<span class="pwd">&nbsp;</span> <input name="password"
						id="password" type="password" value="" class="login-input" />
				</div>
				<!-- 
				<div class="login-oper">
					<input style="margin: 1px 10px 0px 2px; float: left;" name=""
						type="checkbox" value="" checked="checked" /><span>记住密码</span>
				</div>
				 -->
				 <div class="login-oper">
				 </div>
				<div class="login-oper">
					<input name="" type="button" id="btnLogin" value="登 录"
						class="login-btn" /> <input name="" type="button" id="btnClear" value="重 置"
						class="login-reset" />
				</div>
			</form>
		</div>

	</div>


</body>
</html>