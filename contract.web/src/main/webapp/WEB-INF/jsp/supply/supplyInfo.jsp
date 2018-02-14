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
					<li><a href="#">耗材管理</a></li>
					<li class="active">公共仓库</li>
				</ol>
			</div>
			<div class="wrapper">
				<div class="panel">
					<div class="panel-body">
						<form action="#" method="post">
							<div class="search">
								<input type="text" class="text" name="queryCondition"
									placeholder="请输入品名进行查询" class="queryCondition"
									id="queryCondition"> &nbsp;
								<button class="btn btn-primary btnQuery" type="button"
									id="btnQuery">查询</button>
							</div>
						</form>
					</div>
				</div>
				<div class="panel">
					<div class="panel-body">
						<div class="pull-left">
							<button class="btn btn-primary btnQuery"
								style="display: none; margin-bottom: 10px;" id="btnAdd">新
								建</button>
						</div>
						<div class="pull-right">
							<!-- <button class="btn btn-primary" style="width: 100px; margin-left: 10px;">导入</button> -->
							<button class="btn btn-primary btnQuery"
								style="display: none; margin-bottom: 10px;" id="btnExport">导出</button>
						</div>
						<table class="mainTable table-bordered" id="mainTable">
							<thead>
								<tr>
									<td style="width: 80px;" class="text-center"><input
										type="checkbox" name="selAll"></td>
									<td class="text-center">消耗品名</td>
									<td class="text-center">类别</td>
									<td class="text-center">有效期</td>
									<td class="text-center">数量</td>
									<td class="text-center">供应商</td>
									<td class="text-center" style="width:160px;">操作</td>
								</tr>
							</thead>
							<tbody id="tblSupplyInfo">
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


	<div class="modal fade" id="modelEdithSupplyInfo">
		<div class="modal-dialog modal-lg">
			<div class="modal-content">
				<div class="modal-header">
					<button type="button" class="close" data-dismiss="modal">
						<span aria-hidden="true">×</span><span class="sr-only">关闭</span>
					</button>
					<h4 class="modal-title">编辑</h4>
				</div>
				<div class="modal-body">
					<form class="form-horizontal" id="supplyForm">
						<table style="width: 100%" class="mainTable">
							<tr>
								<td class="tbl-two-text"><input type="hidden" name="wid"
									value=""> 分类<span class="myrequrire">*</span></td>
								<td class="tbl-two-edit-value"><select class="form-control"
									name="hcfl" required placeholder="请选择分类"></select></td>
								<td class="tbl-two-text">品名<span class="myrequrire">*</span></td>
								<td class="tbl-two-edit-value"><div class="input-group">
									<input type="text" class="form-control" name="pm">
									<div class="input-group-btn">
										<button type="button" class="btn btn-default dropdown-toggle"
											data-toggle="dropdown">
											<span class="caret"></span>
										</button>
										<ul class="dropdown-menu dropdown-menu-right" role="menu">
										</ul>
									</div>
									<!-- /btn-group -->
								</div>
								</td>
							</tr>
							<tr>
								<td class="tbl-two-text">消耗品录入时间<span class="myrequrire">*</span></td>
								<td class="tbl-two-edit-value"><input type="text" class="form-control" name="xhplrsj"
									placeholder="请输入录入时间" onClick="WdatePicker()" required></td>
								<td class="tbl-two-text">供应商<span class="myrequrire">*</span></td>
								<td class="tbl-two-edit-value"><input type="text" class="form-control" name="gys"
									placeholder="请输入供应商" required>
								</td>
							</tr>
							<tr>
								<td class="tbl-two-text">库存<span class="myrequrire">*</span></td>
								<td class="tbl-two-edit-value"><input type="text" class="form-control" name="kc"
									placeholder="请输入库存" required></td>
								<td class="tbl-two-text">数量单位<span class="myrequrire">*</span></td>
								<td class="tbl-two-edit-value"><select class="form-control" name="sldw" required
									placeholder="请选择数量单位"></select>
								</td>
							</tr>
							<tr>
								<td class="tbl-two-text">单价<span class="myrequrire">*</span></td>
								<td class="tbl-two-edit-value"><input type="text" class="form-control" name="dj"
									placeholder="请输入单价" required></td>
								<td class="tbl-two-text">货币单位<span class="myrequrire">*</span></td>
								<td class="tbl-two-edit-value"><select class="form-control" name="hbdw" required
									placeholder="请选择货币单位"></select>
								</td>
							</tr>
							<tr>
								<td class="tbl-two-text">有效期(天)<span class="myrequrire">*</span></td>
								<td class="tbl-two-edit-value"><input type="text" class="form-control" name="yxq"
									placeholder="请输入有效期" required></td>
								<td class="tbl-two-text" colspan="2">&nbsp;</td>
							</tr>
							<tr>
								<td class="tbl-two-text">备注</td>
								<td class="tbl-two-edit-value" colspan="3"><input type="text" class="form-control" name="bz"
									placeholder="请输入备注"></td>
							</tr>
						</table>


					</form>

				</div>
				<div class="modal-footer">
					<button type="button" class="btn btn-default" data-dismiss="modal">关闭</button>
					<button type="button" class="btn btn-primary"
						id="btnSaveSupplyInfo">保存</button>
				</div>
			</div>
		</div>
	</div>

	<div class="modal fade" id="modelViewSupplyInfo">
		<div class="modal-dialog modal-lg">
			<div class="modal-content">
				<div class="modal-header">
					<button type="button" class="close" data-dismiss="modal">
						<span aria-hidden="true">×</span><span class="sr-only">关闭</span>
					</button>
					<h4 class="modal-title">详情</h4>
				</div>
				<div class="modal-body">
					<form class="form-horizontal" id="supplyViewForm">
						<table style="width: 100%" class="mainTable">
							<tr>
								<td class="tbl-two-text"><input type="hidden" name="wid"
									value="">分类</td>
								<td class="tbl-two-edit-value"><p class="form-control-static" name="hcfl"></p></td>
								<td class="tbl-two-text">品名</td>
								<td class="tbl-two-edit-value"><p class="form-control-static" name="pm"></p></td>
							</tr>
							
									
						<tr>
								<td class="tbl-two-text">消耗品录入时间</td>
								<td class="tbl-two-edit-value"><p class="form-control-static" name="xhplrsj"></p></td>
								<td class="tbl-two-text">供应商</td>
								<td class="tbl-two-edit-value"><p class="form-control-static" name="gys"></p></td>
							</tr>
							<tr>
								<td class="tbl-two-text">库存</td>
								<td class="tbl-two-edit-value"><p class="form-control-static" name="kc"></p></td>
								<td class="tbl-two-text">数量单位</td>
								<td class="tbl-two-edit-value"><p class="form-control-static" name="sldw"></p></td>
							</tr>
							<tr>
								<td class="tbl-two-text">单价</td>
								<td class="tbl-two-edit-value"><p class="form-control-static" name="dj"></p></td>
								<td class="tbl-two-text">货币单位</td>
								<td class="tbl-two-edit-value"><p class="form-control-static" name="hbdw"></p></td>
							</tr>

							<tr>
								<td class="tbl-two-text">有效期(天)</td>
								<td class="tbl-two-edit-value"><p class="form-control-static" name="yxq"></p></td>
								<td class="tbl-two-text">预警数量</td>
								<td class="tbl-two-edit-value"><p class="form-control-static" name="yjsl"></p></td>
							</tr>
							<tr>
								<td class="tbl-two-text">备注</td>
								<td class="tbl-two-edit-value" colspan="3"><p class="form-control-static" name="bz"></p></td>
							</tr>
							</table>


					</form>

				</div>
				<div class="modal-footer">
					<button type="button" class="btn btn-default" data-dismiss="modal">关闭</button>
				</div>
			</div>
		</div>
	</div>

	<script type="text/javascript">
		var buttonsPermission = "${buttons}";
	</script>
	<script type="text/javascript"
		src="${pageContext.request.contextPath}/static/pageJs/supply/supplyInfo.js"></script>
</body>
</html>