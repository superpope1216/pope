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
					<li><a href="#">客户管理</a></li>
					<li class="active">客户账户历史信息</li>
				</ol>
			</div>
			<div class="wrapper">
				<div class="panel">
					<div class="panel-body">
						<form class="form-horizontal" id="customForm"
							style="margin-top: 10px;">
							<div class="form-group">
								<label for="name" class="col-sm-1 ">客户编码</label>
								<div class="col-md-3 col-sm-3">
									<p class="form-control-static" name="customNumber"></p>
								</div>
								<label for="gh" class="col-sm-1 ">客户名称</label>
								<div class="col-md-3 col-sm-3">
									<p class="form-control-static" name="customName"></p>
								</div>
								<label for="name" class="col-sm-1">账号编号</label>
								<div class="col-md-3 col-sm-3">
									<p class="form-control-static" name="accountNumber"></p>
								</div>
							</div>
							<div class="form-group">
								<label for="gh" class="col-sm-1 ">银行账户</label>
							
								<div class="col-md-3 col-sm-3">
									<p class="form-control-static" name="bankAccount"></p>
								</div>
								<label for="gh" class="col-sm-1 ">账户余额</label>
								<div class="col-md-3 col-sm-3">
									<p class="form-control-static" name="accountMoney"></p>
								</div>
							</div>
						</form>
					</div>
				</div>
				<div class="panel">
					<div class="panel-body">

						<table style="width: 100%; margin-top: 0px;">
							<tr>
								<td align="left">
									<h3>客户合同列表</h3>
								</td>
								<td align="right"></td>
							</tr>
						</table>
						<table class="table table-bordered datatable table-hover"
							id="mainTable">
							<thead>
								<tr>
									<th class="text-center">合同时间</th>
									<th class="text-center">合同编号</th>
									<th class="text-center">合同名称</th>
									<th class="text-center">合同类型</th>
									<th class="text-center">变动金额</th>
									<th class="text-center">余额</th>
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

	<script type="text/javascript">
		var wid = "${wid}";
	</script>

	<script type="text/javascript"
		src="${pageContext.request.contextPath}/static/pageJs/custom/customInfoDetail.js"></script>
</body>
</html>