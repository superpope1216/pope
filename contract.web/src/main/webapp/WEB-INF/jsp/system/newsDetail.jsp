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
					<li><a href="#">系统管理</a></li>
					<li class="active">新闻详情</li>
				</ol>
			</div>
			<div class="wrapper">
				<div class="col-md-12 col-sm-12">
					<div class="panel">
						<div class="panel-body">
							<h3 id="newTitle" style="text-align:center;"></h3>
							<p id="newContent"></p>
						</div>

					</div>
				</div>
			</div>
			<script type="text/javascript">
				var wid="${wid}";
			</script>
			<script type="text/javascript"
				src="${pageContext.request.contextPath}/static/pageJs/system/newsdetail.js"></script>
</body>
</html>