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
					<li><a href="#">合同管理</a></li>
					<li class="active">合同详情</li>
				</ol>
			</div>
			<div class="wrapper">
				<table style="width: 100%;">
					<tr>
						<td style="width: 50%; position: relative;">
							<div class="panel">
								<div class="panel-body">
									<table style="width: 100%; margin-top: 5px;">
										<tr>
											<td align="left">
												<h3>
													<div class="pull-left">合同详情</div>
												</h3>
											</td>
										</tr>
									</table>
									<form class="form-horizontal" id="userForm"
										style="margin-top: 10px;">
										<div class="form-group">
											<input type="hidden" name="wid" value=""> <input
												type="hidden" name="dqbh" value=""><label for="name"
												class="col-sm-2 ">合同类型</label>
											<div class="col-md-4 col-sm-4">
												<p class="form-control-static" name="htlx"></p>
											</div>
											<label for="gh" class="col-sm-2 ">合同名称</label>
											<div class="col-md-4 col-sm-4">
													<p class="form-control-static" name="htmc"></p>
											</div>
										</div>
										<div class="form-group">
											<label for="phone" class="col-sm-2 ">合同编号</label>
											<div class="col-md-4 col-sm-4">
												 <p class="form-control-static" name="htbh"></p>
											</div>
											<label for="email" class="col-sm-2 ">合同甲方</label>
											<div class="col-md-4 col-sm-4">
												<p class="form-control-static" name="htjf"></p>

											</div>
										</div>
										<div class="form-group">
											<label for="phone" class="col-sm-2 ">项目负责人</label>
											<div class="col-md-4 col-sm-4">
												<p class="form-control-static" name="xmfzr"></p>
											</div>
											<label for="department" class="col-sm-2 ">合同金额</label>
											<div class="col-md-4 col-sm-4">
												<p class="form-control-static" name="htje">0</p>
											</div>
										</div>
										<div class="form-group">
											<label for="phone" class="col-sm-2 ">合同折扣</label>
											<div class="col-md-4 col-sm-4">
												<p class="form-control-static" name="htzk">0</p>
											</div>
											<label for="department" class="col-sm-2 required">合同时间</label>
											<div class="col-md-4 col-sm-4">
												<p class="form-control-static" name="htsj"></p>
											</div>
										</div>
										<div class="form-group">
											<label for="phone" class="col-sm-2 required">合同执行时间</label>
											<div class="col-md-4 col-sm-4">
												<p class="form-control-static" name="htzxsj"></p>

											</div>
											<label for="department" class="col-sm-2 required">对方账号</label>
											<div class="col-md-4 col-sm-4">
												<p class="form-control-static" name="dfzh"></p>
											</div>
										</div>
										<div class="form-group">
											<label for="birthday" class="col-sm-2">备注</label>
											<div class="col-md-8 col-sm-8">
												<p class="form-control-static" name="bz"></p>
											</div>
										</div>
									</form>
								</div>
							</div>
							<div class="panel">
								<div class="panel-body">
									<table class="table table-bordered datatable table-hover"
										id="mainContractFxxmInfo">
										<thead>
											<tr>
												<th class="text-center">分析项目</th>
												<th class="text-center">单价</th>
												<th class="text-center">数量</th>
												<th class="text-center">折扣</th>
												<th class="text-center">总价</th>
											</tr>
										</thead>
										<tbody id="tblContractFxxmInfo">
										</tbody>
									</table>
								</div>
							</div>
						</td>
						<td style="width: 50%; position: relative;">
							<div class="panel"
								style="height: 100%; top: 2px; width: 100%; position: absolute; margin: 0px; padding: 0px;">
								<div class="panel-body">

									<table style="width: 100%; margin-top: 5px;">
										<tr>
											<td align="left">
												<h3>添加分析项目</h3>
											</td>
											<td align="right">
											</td>
										</tr>
									</table>
									<div class="col-md-7 col-md-7">
										<table class="table table-bordered datatable table-hover"
											id="mainBatchTable">
											<thead>
												<tr>
													<th style="width: 50px;"></th>
													<th class="text-center">样品批次</th>
													<th class="text-center">送样人</th>
													<th class="text-center">送样单位</th>
												</tr>
											</thead>
											<tbody id="tblBatchInfo">
											</tbody>
										</table>
									</div>
									<div class="col-md-5 col-md-5">
										<table class="table table-bordered datatable table-hover"
											id="mainFxxmTable">
											<thead>
												<tr>
													<th style="width: 50px;"></th>
													<th class="text-center">分析项目</th>
												</tr>
											</thead>
											<tbody id="tblFxxmDetailInfo">
											</tbody>
										</table>
									</div>
									<div class="pull-right">
										<div id='pageInfo' class="pagination"></div>
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
		var firstPcid = "${firstPcid}";
		var pcids = "${pcids}";
		var wid = "${wid}";
	</script>
	<script id="tblDetailInfoTpl" type="text/x-jquery-tmpl">
				<tr>
					<td class="text-center">{{= ypbh}}</td>
					<td class="text-center">{{= ypph}}</td>
					<td class="text-left">{{= ypyybh}}</td>
					<td class="text-left">{{= ypxz}}</td>
					<td class="text-left">{{= ypewm}}</td>
					<td class="text-left">{{= fxxm_display}}</td>
					<td class="text-center">
						<div class="btn-group">
          					<button type="button" style="margin-left:4px;" class="btn btn-xs btn-danger" data-option="delete" data-key="{{= wid}}"><i class="icon icon-times"></i></button>
        				</div>
					</td>
				</tr>
			</script>
	<script type="text/javascript"
		src="${pageContext.request.contextPath}/static/pageJs/contract/contractViewInfo.js"></script>
</body>
</html>