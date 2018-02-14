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
					<li><a href="#">进行培训</a></li>
					<li class="active">个人进修培训信息</li>
				</ol>
			</div>
			<div class="wrapper">
				<div class="panel">
					<div class="panel-body">
						&nbsp;&nbsp;
						<table class="mainTable table-hover"
							id="mainTable">
							<thead>
								<tr>
									<td class="text-center">培训类型</td>
									<td class="text-center">培训名称</td>
									<td class="text-center">培训人</td>
									<td class="text-center">开始时间</td>
									<td class="text-center">结束时间</td>
									<td class="text-center">培训费用</td>
									<td class="text-center">任务状态</td>
								</tr>
							</thead>
							<tbody id="tblUserInfo">
							</tbody>
						</table>
						<div class="pull-right">
							<div id='pageInfo' class="pagination"></div>
						</div>
					</div>
				</div>
			</div>
		</div>
	</div>
	<script type="text/javascript">
		var buttonsPermission = "${buttons}";
	</script>
	<script type="text/javascript"
		src="${pageContext.request.contextPath}/static/pageJs/pxgl/personPxglInfo.js"></script>
</body>
</html>