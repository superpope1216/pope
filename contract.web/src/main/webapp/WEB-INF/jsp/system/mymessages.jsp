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
					<li class="active">我的消息</li>
				</ol>
			</div>
			<div class="wrapper">
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
			</div>
		</div>
	</div>

	<script type="text/javascript">
		
	</script>
	<script type="text/javascript"
		src="${pageContext.request.contextPath}/static/pageJs/system/mymessages.js"></script>
</body>
</html>