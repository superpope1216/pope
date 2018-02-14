<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<%@ include file="/jsp/public/top.jsp"%>
</head>
<body>
	<div class="main">
		<%@ include file="/jsp/public/header.jsp"%>
		<%@ include file="/jsp/public/left.jsp"%>
		<div class="main-content">
			<div class="position">
				<ol class="breadcrumb">
					<li><a href="#"><i class="icon icon-home"></i> 位置</a></li>
					<li class="active">系统首页</li>
				</ol>
			</div>
			<div class="wrapper">
			<div class="panel">
				<div class="panel-body text-primary" 
					style="font-size: 26px;text-transform: uppercase;padding-top:60px;;text-align:center;color: white;margin:0 auto;height: 180px; background: url(../static/img/center-header.png) no-repeat center center fixed;  background-size: 100% 100%; -moz-background-size: 100% 100%;">
						<p><%=loginInfo.getName() %>，您好！欢迎进入实验室管理系统</p>
				</div>
			</div>
				<table style="width: 100%;">
					<tr>
						<td style="width: 50%; position: relative;">
							<div class="panel">
								<div class="panel-body" id="panel1">
									<div class="list">
										<header>
											<h3>
												<i class="icon-list-ul"></i>公司新闻
											</h3>
										</header>
										<div class="items items-hover" id="divNews"></div>
									</div>
									<div class="pull-right">
										<div id='pageInfoNews' class="pagination"></div>
									</div>
								</div>
							</div>
						</td>
						<td style="width: 50%; position: relative;">
							<div class="panel">
								<div class="panel-body" id="panel2">

									<div class="list">
										<header>
											<h3>
												<i class="icon-list-ul"></i>消息中心
											</h3>
										</header>
										<div class="items items-hover" id="divXx">
											<div class="items items-hover" id="divMessages"></div>
										</div>
										<div class="pull-right">
											<div id='pageInfoMessages' class="pagination"></div>
										</div>
									</div>
								</div>
							</div>
						</td>
					</tr>
				</table>


			</div>
		</div>
	</div>

	<script type="text/javascript">
		
	</script>
	<script type="text/javascript"
		src="${pageContext.request.contextPath}/static/pageJs/center/center.js"></script>
</body>
</html>