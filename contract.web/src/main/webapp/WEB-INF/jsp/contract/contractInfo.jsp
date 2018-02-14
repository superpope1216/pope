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
					<li class="active">合同管理</li>
				</ol>
			</div>
			<div class="wrapper">
				<div class="panel">
					<div class="panel-body">
						<form class="form-horizontal" id="queryContractForm">
							<table class="mainQueryTable">
								<tr>
									<td class="tbl-three-text">
										送样人
									</td>
									<td class="tbl-three-edit-value">
										<input type="text" class="form-control " name="querySyr" id="querySyr"
										placeholder="请输入送样人">
									</td>
										<td class="tbl-three-text">
										合同编号
									</td>
									<td class="tbl-three-edit-value">
										<input type="text" class="form-control " name="queryHtb" id="queryHtb"
										placeholder="请输入合同编号" >
									</td>
										<td class="tbl-three-text">
										样品批次号
									</td>
									<td class="tbl-three-edit-value">
										<input type="text" class="form-control " name="queryYppch" id="queryYppch"
										placeholder="请输入样品批次号" >
									</td>
								</tr>
								<tr>
									<td class="tbl-three-text">
										分析项
									</td>
									<td class="tbl-three-edit-value">
									<select name="pclb" class="form-control" id="queryFxxm">
													<option value=''>--请选择--</option>
												</select>
								
									<td class="tbl-three-edit-value" colspan="4">
										<button class="btn btn-primary btnQuery" type="button"
										id="btnQuery">查询</button>
									</td>
								</tr>
							</table>
						</form>
					</div>
				</div>
				<div class="panel">
					<div class="panel-body">
						<div class="pull-right">
							<button class="btn btn-primary btnQuery" id="btnSubmit"
								style="display: none;margin-bottom:15px;">提交审核</button>
							<button class="btn btn-primary btnQuery" id="btnDownload"
								style=";margin-bottom:15px;width:120px;">创建分包申请表</button>
								<button class="btn btn-primary btnQuery" id="btnExport"
								style="display: none;margin-bottom:15px;">导出</button>
						</div>
						<table class="mainTable table-hover"
							id="mainTable">
							<thead>
								<tr>
									<td class="text-center" style="width: 80px;"><input type="checkbox" name="selAll" /></td>
									<td class="text-center">时间</td>
									<td class="text-center">合同名称</td>
									<td class="text-center">合同编号</td>
									<td class="text-center">合同类型</td>
									<td class="text-center">对方名称</td>
									<td class="text-center">对方账号</td>
									<td class="text-center">金额</td>
									<td class="text-center">合同状态</td>
									<td data-width="80px" class="text-center">操作</td>
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
		src="${pageContext.request.contextPath}/static/pageJs/contract/contractInfo.js"></script>
</body>
</html>