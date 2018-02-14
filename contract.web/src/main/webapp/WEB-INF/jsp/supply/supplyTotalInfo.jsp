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
					<li class="active">耗材领用管理</li>
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
						<table class="mainTable table-bordered" id="mainTable">
							<thead>
								<tr>
									<td class="text-center">消耗品名</td>
									<td class="text-center">类别</td>
									<td class="text-center">数量</td>
									<td class="text-center">数量单位</td>
									<td class="text-center">预警数量</td>
									<td class="text-center">告警</td>
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
									value="">分类</td>
								<td class="tbl-two-edit-value"><p
										class="form-control-static" name="hcfl"></p></td>
								<td class="tbl-two-text">品名</td>
								<td class="tbl-two-edit-value"><p
										class="form-control-static" name="hcfl"></p></td>
							</tr>
							<tr>
								<td class="tbl-two-text">数量</td>
								<td class="tbl-two-edit-value"><p
										class="form-control-static" name="kc"></p></td>
								<td class="tbl-two-text">数量单位</td>
								<td class="tbl-two-edit-value"><p
										class="form-control-static" name="sldw"></p></td>
							</tr>
							<tr>
								<td class="tbl-two-text">单价</td>
								<td class="tbl-two-edit-value"><p
										class="form-control-static" name="dj"></p></td>
								<td class="tbl-two-text">货币单位</td>
								<td class="tbl-two-edit-value"><p
										class="form-control-static" name="hbdw"></p></td>
							</tr>
							<tr>
								<td class="tbl-two-text">预警数量<span class="myrequrire">*</span></td>
								<td class="tbl-two-edit-value"><input type="text"
									class="form-control" name="yjsl" placeholder="请输入预警数量" required></td>
								<td class="tbl-two-edit-value" colspan="2">&nbsp;
									</p>
								</td>
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
	<div class="modal fade" id="modelSlbSupplyInfo">
		<div class="modal-dialog">
			<div class="modal-content">
				<div class="modal-header">
					<button type="button" class="close" data-dismiss="modal">
						<span aria-hidden="true">×</span><span class="sr-only">关闭</span>
					</button>
					<h4 class="modal-title">领用</h4>
				</div>
				<div class="modal-body">
					<form class="form-horizontal" id="slbForm">
						<table style="width: 100%" class="mainTable">
							<tr>
								<td class="tbl-one-text"><input type="hidden" name="wid"
									value=""> <input type="hidden" name="hcid" value="">
									分类</td>
								<td class="tbl-one-edit-value"><p
										class="form-control-static" name="hcfl"></p></td>
							</tr>
							<tr>
								<td class="tbl-one-text">品名</td>
								<td class="tbl-one-edit-value"><p
										class="form-control-static" name="pm"></p></td>
							</tr>
							<tr>
								<td class="tbl-one-text">可领用数量</td>
								<td class="tbl-one-edit-value"><p
										class="form-control-static" name="kc"></p></td>
							</tr>
							<tr>
								<td class="tbl-one-text">领用数量<span class="myrequrire">*</span></td>
								<td class="tbl-one-edit-value"><input type="text"
									class="form-control" name="lysl" placeholder="请输入领用数量" required></td>
							</tr>
							<tr>
								<td class="tbl-one-text">归还数量<span class="myrequrire">*</span></td>
								<td class="tbl-one-edit-value"><input type="text"
									class="form-control" name="ghsl" placeholder="请输入归还数量" required></td>
							</tr>
							<tr>
								<td class="tbl-one-text">备注</td>
								<td class="tbl-one-edit-value"><input type="text"
									class="form-control" name="bz" placeholder="请输入备注"></td>
							</tr>
						</table>
					</form>
					<div class="modal-footer">
						<button type="button" class="btn btn-default" data-dismiss="modal">关闭</button>
						<button type="button" class="btn btn-primary"
							id="btnSaveSlbSupplyInfo">申请</button>
					</div>
				</div>
			</div>
		</div>
	</div>



	<div class="modal fade" id="modelGmbSupplyInfo">
		<div class="modal-dialog">
			<div class="modal-content">
				<div class="modal-header">
					<button type="button" class="close" data-dismiss="modal">
						<span aria-hidden="true">×</span><span class="sr-only">关闭</span>
					</button>
					<h4 class="modal-title">购买</h4>
				</div>
				<div class="modal-body">
					<form class="form-horizontal" id="gbForm">
						<table style="width: 100%" class="mainTable">
							<tr>
								<td class="tbl-one-text"><input type="hidden" name="wid"
									value=""> <input type="hidden" name="hcid" value="">
									分类</td>
								<td class="tbl-one-edit-value"><p
										class="form-control-static" name="hcfl"></p></td>
							</tr>
							<tr>
								<td class="tbl-one-text">品名</td>
								<td class="tbl-one-edit-value"><p
										class="form-control-static" name="pm"></p></td>
							</tr>
							<tr>
								<td class="tbl-one-text">申购数量<span class="myrequrire">*</span></td>
								<td class="tbl-one-edit-value"><input type="text"
									class="form-control" name="lysl" placeholder="请输入申购数量" required></td>
							</tr>
							<tr>
								<td class="tbl-one-text">备注</td>
								<td class="tbl-one-edit-value"><input type="text"
									class="form-control" name="bz" placeholder="请输入备注"></td>
							</tr>
							</table>
					</form>
					<div class="modal-footer">
						<button type="button" class="btn btn-default" data-dismiss="modal">关闭</button>
						<button type="button" class="btn btn-primary"
							id="btnSaveGmbSupplyInfo">申请</button>
					</div>
				</div>
			</div>
		</div>
	</div>
	<div class="modal fade" id="modelShbSupplyInfo">
		<div class="modal-dialog">
			<div class="modal-content">
				<div class="modal-header">
					<button type="button" class="close" data-dismiss="modal">
						<span aria-hidden="true">×</span><span class="sr-only">关闭</span>
					</button>
					<h4 class="modal-title">损坏</h4>
				</div>
				<div class="modal-body">
					<form class="form-horizontal" id="shbForm">
						<table style="width: 100%" class="mainTable">
							<tr>
								<td class="tbl-one-text"><input type="hidden" name="wid"
									value=""> <input type="hidden" name="hcid" value="">
									分类</td>
								<td class="tbl-one-edit-value"><p
										class="form-control-static" name="hcfl"></p></td>
							</tr>
							<tr>
								<td class="tbl-one-text">品名</td>
								<td class="tbl-one-edit-value"><p
										class="form-control-static" name="pm"></p></td>
							</tr>
							<tr>
								<td class="tbl-one-text">报损数量<span class="myrequrire">*</span></td>
								<td class="tbl-one-edit-value"><input type="text" class="form-control" name="lysl"
									placeholder="请输入损坏数量" required></td>
							</tr>
							<tr>
								<td class="tbl-one-text">备注</td>
								<td class="tbl-one-edit-value"><input type="text"
									class="form-control" name="bz" placeholder="请输入备注"></td>
							</tr>
							</table>
					</form>
					
					
					</form>
					<div class="modal-footer">
						<button type="button" class="btn btn-default" data-dismiss="modal">关闭</button>
						<button type="button" class="btn btn-primary"
							id="btnSaveShbSupplyInfo">申请</button>
					</div>
				</div>
			</div>
		</div>
	</div>

	<script type="text/javascript">
		var buttonsPermission = "${buttons}";
	</script>
	<script type="text/javascript"
		src="${pageContext.request.contextPath}/static/pageJs/supply/supplyTotalInfo.js"></script>
</body>
</html>