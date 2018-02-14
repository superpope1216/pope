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
					<li><a
						href="${pageContext.request.contextPath}/custom/index?open=300&select=301">客户管理</a></li>
					<li class="active">客户账户历史信息</li>
				</ol>
			</div>

			<div class="wrapper">
				<div class="panel">
					<div class="panel-body">
						<table style="width: 100%; margin-top: 5px;">
							<tr>
								<td class="td-left-bold">
									<h3>
										<span class="span-left-border">账户信息</span>
									</h3>
								</td>
								<td align="right"></td>
							</tr>
						</table>
						<form class="form-horizontal" id="customForm">
							<table class="mainTable">
								<tr>
									<td class="tbl-three-text">客户编码</td>
									<td class="tbl-three-edit-value">
										<p class="form-control-static" name="customNumber"></p>
									</td>
									<td class="tbl-three-text">客户名称</td>
									<td class="tbl-three-edit-value">
										<p class="form-control-static" name="customName"></p>
									</td>
									<td class="tbl-three-text">预存账号编号</td>
									<td class="tbl-three-edit-value">
										<p class="form-control-static" name="accountNumber"></p>
									</td>
								</tr>
								<tr>
									<td class="tbl-three-text">预存银行信息</td>
									<td class="tbl-three-edit-value">
										<p class="form-control-static" name="bankAccount"></p>
									</td>
									<td class="tbl-three-text">预存账户余额</td>
									<td class="tbl-three-edit-value" colspan="3">
										<p class="form-control-static" name="accountMoney"></p>
									</td>
								</tr>
							</table>
						</form>
					</div>
				</div>
				<div class="panel">
					<div class="panel-body">

						<table style="width: 100%; margin-top: 0px;">
							<tr>
								<td class="td-left-bold">
									<h3>
										<span class="span-left-border">账户历史信息</span>
									</h3>
								</td>
								<td align="right"></td>
							</tr>
						</table>
						<ul class="nav nav-tabs">
							<li class="active"><a data-tab href="#ckjlContent">存款记录</a></li>
							<li><a data-tab href="#htjlContent">合同记录</a></li>
						</ul>
						<div class="tab-content">
							<div class="tab-pane active" id="ckjlContent">
								<table class="mainTable table-hover" id="mainCkjlTable">
									<thead>
										<tr>
											<td class="text-center">存款时间</td>
											<td class="text-center">变动金额</td>
											<td class="text-center">余额</td>
										</tr>
									</thead>
									<tbody id="tblCkjlDetailInfo">
									</tbody>
								</table>
								<div class="pull-right">
									<div id='pageCkjlInfo' class="pagination"></div>
								</div>
							</div>
							<div class="tab-pane" id="htjlContent">
								<table class="mainTable table-hover" id="mainTable">
									<thead>
										<tr>
											<td class="text-center">合同时间</td>
											<td class="text-center">合同编号</td>
											<td class="text-center">合同名称</td>
											<td class="text-center">合同类型</td>
											<td class="text-center">变动金额</td>
											<td class="text-center">余额</td>
										</tr>
									</thead>
									<tbody id="tblDetailInfo">
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
		</div>

		<script type="text/javascript">
			var wid = "${wid}";
		</script>

		<script type="text/javascript"
			src="${pageContext.request.contextPath}/static/pageJs/custom/customInfoDetail.js"></script>
</body>
</html>