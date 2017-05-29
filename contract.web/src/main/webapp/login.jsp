<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<%@ include file="/jsp/public/top.jsp"%>
<script type="text/javascript" src="${pageContext.request.contextPath}/static/pageJs/login.js"></script>
</head>
<body>
	<div class="container">
	<br><br><br><br>
	<form class="form-horizontal" id="loginForm">
		<div class="form-group">
			<label for="loginName" class="col-sm-2 required">账号</label>
			<div class="col-md-6 col-sm-10">
				<input type="text" class="form-control" name="loginName"
					placeholder="用户名">
			</div>
		</div>
		<div class="form-group">
			<label for="exampleInputPassword4" class="col-sm-2 required">密码</label>
			<div class="col-md-6 col-sm-10">
				<input type="password" class="form-control" name="password"
					 placeholder="密码">
			</div>
		</div>
		<div class="form-group">
			<div class="col-sm-offset-2 col-sm-10">
				<div class="checkbox">
					<label> <input type="checkbox"> 记住我
					</label>
				</div>
			</div>
		</div>
		<div class="form-group">
			<div class="col-sm-offset-2 col-sm-10">
				<button type="button" id="btnLogin" class="btn btn-default">登录</button>
			</div>
		</div>
	</form>
	</div>
</body>
</html>