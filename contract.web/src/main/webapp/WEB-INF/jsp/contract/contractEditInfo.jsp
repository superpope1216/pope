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
													<div class="pull-right">
														<button class="btn btn-primary btnQuery" type="button"
															id="btnSave">保存</button>
													</div>
												</h3>
											</td>
										</tr>
									</table>
									<form class="form-horizontal" id="userForm"
										style="margin-top: 10px;">
										<div class="form-group">
											<input type="hidden" name="wid" value=""> <input
												type="hidden" name="dqbh" value=""><label for="name"
												class="col-sm-2 required">合同类型</label>
											<div class="col-md-4 col-sm-4">
												<select name="htlx" class="form-control" required>
													<option value=''>--请选择--</option>
												</select>
											</div>
											<label for="gh" class="col-sm-2 required">合同名称</label>
											<div class="col-md-4 col-sm-4">
												<input type="text" class="form-control" name="htmc"
													placeholder="请输入合同名称" required>
											</div>
										</div>
										<div class="form-group">
											<label for="phone" class="col-sm-2 required">合同编号</label>
											<div class="col-md-4 col-sm-4">
												<input type="text" readonly class="form-control" name="htbh"
													placeholder="请输入合同编号" required>
											</div>
											<label for="email" class="col-sm-2 required">合同甲方</label>
											<div class="col-md-4 col-sm-4">
												<input type="hidden" name="htjf" value="" />
												<p class="form-control-static" name="p_htjf"></p>

											</div>
										</div>
										<div class="form-group">
											<label for="phone" class="col-sm-2 required">项目负责人</label>
											<div class="col-md-4 col-sm-4">
												<input type="hidden" name="xmfzr" value="" />
												<p class="form-control-static" name="p_xmfzr"></p>
											</div>
											<label for="department" class="col-sm-2 required">合同金额</label>
											<div class="col-md-4 col-sm-4">
												<input type="hidden" name="htje" value="0" />
												<p class="form-control-static" name="p_htje">0</p>
											</div>
										</div>
										<div class="form-group">
											<label for="phone" class="col-sm-2 required">合同折扣</label>
											<div class="col-md-4 col-sm-4">
												<input type="text" class="form-control" name="htzk"
													placeholder="请输入合同折扣" required>
												
											</div>
											<label for="department" class="col-sm-2 required">合同时间</label>
											<div class="col-md-4 col-sm-4">
												<input type="hidden" name="htsj" value="" />
												<p class="form-control-static" name="p_htsj"></p>

											</div>
										</div>
										<div class="form-group">
											<label for="phone" class="col-sm-2 required">合同执行时间</label>
											<div class="col-md-4 col-sm-4">
												<input type="text" class="form-control" name="htzxsj"
													placeholder="请输入合同执行时间" onClick="WdatePicker()" required>

											</div>
											<label for="department" class="col-sm-2 required">对方账号</label>
											<div class="col-md-4 col-sm-4">
												<input type="hidden" name="dfzh" value="" />
												<p class="form-control-static" name="p_dfzh"></p>
											</div>
										</div>
										<div class="form-group">
											<label for="birthday" class="col-sm-2">备注</label>
											<div class="col-md-8 col-sm-8">
												<input type="text" class="form-control" name="bz"
													placeholder="请输入备注">
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
												<button class="btn btn-primary btnQuery" type="button"
													id="btnAddFxxm">添加</button>
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

	<div class="modal fade" id="modelEdithBatchDetailInfo">
		<div class="modal-dialog ">
			<div class="modal-content">
				<div class="modal-header">
					<button type="button" class="close" data-dismiss="modal">
						<span aria-hidden="true">×</span><span class="sr-only">关闭</span>
					</button>
					<h4 class="modal-title">编辑</h4>
				</div>
				<div class="modal-body">
					<form class="form-horizontal" id="batchDetailForm">
						<div class="form-group">
							<input type="hidden" name="wid" value=""> <input
								type="hidden" name="pcwid" value=""> <input
								type="hidden" name="dqbh" value=""> <label for="name"
								class="col-sm-2 required">样品编号</label>
							<div class="col-md-8 col-sm-8">
								<input type="text" readonly class="form-control" name="ypbh"
									placeholder="请输入样品编号" required>
							</div>
						</div>
						<div class="form-group">
							<label for="gh" class="col-sm-2 required">样品批次号</label>
							<div class="col-md-8 col-sm-8">
								<input type="text" class="form-control" name="ypph" readonly
									required>
							</div>
						</div>
						<div class="form-group">
							<label for="gh" class="col-sm-2 required">样品原有编号</label>
							<div class="col-md-8 col-sm-8">
								<input type="text" class="form-control" name="ypyybh"
									placeholder="请输入样品原有编号" required>
							</div>
						</div>
						<div class="form-group">
							<label for="gh" class="col-sm-2 required">样品性质</label>
							<div class="col-md-8 col-sm-8">
								<input type="text" class="form-control" name="ypxz"
									placeholder="请输入样品性质" required>
							</div>
						</div>
						<div class="form-group">
							<label for="gh" class="col-sm-2 required">样品二维码</label>
							<div class="col-md-8 col-sm-8">
								<input type="text" class="form-control" name="ypewm"
									placeholder="请输入样品二维码">
							</div>
						</div>
						<div class="form-group">
							<label for="department" class="col-sm-2 required">分析项目</label>
							<div class="col-md-8 col-sm-8">
								<select name="fxxm" multiple="multiple" class="form-control"
									required>
									<option value=''>--请选择--</option>
								</select>
							</div>
						</div>
					</form>

				</div>
				<div class="modal-footer">
					<button type="button" class="btn btn-default" data-dismiss="modal">关闭</button>
					<button type="button" class="btn btn-primary"
						id="btnSaveDetailInfo">保存</button>
				</div>
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
		src="${pageContext.request.contextPath}/static/pageJs/contract/contractEditInfo.js"></script>
</body>
</html>