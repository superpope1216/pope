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
					<li><a href="${pageContext.request.contextPath}/supplyTotal/index?open=200&select=210">耗材管理</a></li>
					<li class="active">耗材领用详情</li>
				</ol>
			</div>
			<div class="wrapper">

				<div class="panel">
					<div class="panel-body">
						<ul class="nav nav-tabs">
							<li class="active"><a data-tab href="#lydContent">领用单详情</a></li>
							<li><a data-tab href="#sgdContent">申购单详情</a></li>
							<li><a data-tab href="#shdContent">损坏单详情</a></li>
						</ul>
						<div class="tab-content">
							<div class="tab-pane active" id="lydContent">
								<br>
								<table class="mainTable table-hover"
									id="lydMainTable">
									<thead>
										<tr>
											<td class="text-center">耗材分类</td>
											<td class="text-center">品名</td>
											<td class="text-center">领用数量</td>
											<td class="text-center">领用人</td>
											<td class="text-center">领用时间</td>
											<td class="text-center">归还数量</td>
											<td class="text-center">状态</td>
										</tr>
									</thead>
									<tbody id="tblLydInfo">
									</tbody>
								</table>
								<div class="pull-right">
									<div id='lydPageInfo' class="pagination"></div>
								</div>
							</div>
							
							<div class="tab-pane " id="sgdContent">
								<br>
								<table class="mainTable table-hover"
									id="sgdMainTable">
									<thead>
										<tr>
											<td class="text-center">耗材分类</td>
											<td class="text-center">品名</td>
											<td class="text-center">购买数量</td>
											<td class="text-center">购买人</td>
											<td class="text-center">购买时间</td>
											<td class="text-center">状态</td>
										</tr>
									</thead>
									<tbody id="tblSgdInfo">
									</tbody>
								</table>
								<div class="pull-right">
									<div id='sgdPageInfo' class="pagination"></div>
								</div>
							</div>
							
							<div class="tab-pane " id="shdContent">
								<br>
								<table class="mainTable table-hover"
									id="shdMainTable">
									<thead>
										<tr>
											<td class="text-center">耗材分类</td>
											<td class="text-center">品名</td>
											<td class="text-center">损坏数量</td>
											<td class="text-center">损坏人</td>
											<td class="text-center">损坏时间</td>
											<td class="text-center">状态</td>
										</tr>
									</thead>
									<tbody id="tblShdInfo">
									</tbody>
								</table>
								<div class="pull-right">
									<div id='shdPageInfo' class="pagination"></div>
								</div>
							</div>
						</div>
					</div>
				</div>
			</div>
		</div>
	</div>
	
	<script type="text/javascript">
		var buttonsPermission = "${buttons}";
		var hcid="${hcid}";
	</script>
	<script id="tblLydInfoTpl" type="text/x-jquery-tmpl">
				<tr>
					
					<td class="text-center">{{= hcfl_display}}</td>
					<td class="text-center">{{= pm}}</td>
					<td class="text-center">{{= lysl}}</td>
					<td class="text-center">{{= userid_display}}</td>
					<td class="text-left">{{= sqsj}}</td>
					<td class="text-left">{{= ghsl}}</td>
					<td class="text-left">{{= rwzt_display}}</td>
				</tr>
			</script>
			
			<script id="tblInfoTpl" type="text/x-jquery-tmpl">
				<tr>
					
					<td class="text-center">{{= hcfl_display}}</td>
					<td class="text-center">{{= pm}}</td>
					<td class="text-center">{{= lysl}}</td>
					<td class="text-center">{{= userid_display}}</td>
					<td class="text-left">{{= sqsj}}</td>
					<td class="text-left">{{= rwzt_display}}</td>
				</tr>
			</script>
	<script type="text/javascript"
		src="${pageContext.request.contextPath}/static/pageJs/supply/supplyTotalDetailInfo.js"></script>
</body>
</html>