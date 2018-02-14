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
					<li><a href="${pageContext.request.contextPath}/custom/index?open=300&select=301">客户管理</a></li>
					<li class="active">客户账户信息</li>
				</ol>
			</div>
			<div class="wrapper">
				<div class="panel">
					<div class="panel-body">
						<form action="#" method="post">
							<div class="search">
								<input type="text" class="text" id="queryCondition"
									placeholder="客户编号/客户名称" class="queryCondition">
								&nbsp;
								<button class="btn btn-primary btnQuery" type="button"
									id="btnQuery">查询</button>
							</div>
						</form>
					</div>
				</div>
				<div class="panel">
					<div class="panel-body">
						<div class="pull-left">
						</div>
						<table class="mainTable table-hover"
							id="mainTable">
							<thead>
								<tr>
									<td class="text-center">客户名称</td>
									<td class="text-center">预存账户编号</td>
									<td class="text-center">预存账户信息</td>
									<td class="text-center">预存账户余额</td>
									<td data-width="160px" class="text-center">操作</td>
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
<div class="modal fade" id="modelAddCustomAccountInfo">
		<div class="modal-dialog">
			<div class="modal-content">
				<div class="modal-header">
					<button type="button" class="close" data-dismiss="modal">
						<span aria-hidden="true">×</span><span class="sr-only">关闭</span>
					</button>
					<h4 class="modal-title">编辑</h4>
				</div>
				<div class="modal-body">
					<form class="form-horizontal" id="customAccountForm"
						style="margin-top: 10px;">
						<table class="mainTable">
							<tr>
								<td class="tbl-one-text"><input type="hidden" name="wid"
									value=""><input type="hidden" name="dqbh" value="">
									<input type="hidden" name="customId" value="">预存账号编号<span
									class="myrequrire">*</span></td>
								<td class="tbl-one-edit-value"><input type="text" readonly
									name="accountNumber" placeholder="请输入账户编号" required></td>
								
							</tr>
							<tr>
								<td class="tbl-one-text">预存账户信息<span class="myrequrire">*</span>
								</td>
								<td class="tbl-one-edit-value"><input type="text"
									class="form-control" name="bankAccount" readonly placeholder="请输入银行账户"
									required></td>
							</tr>
							<tr>
								<td class="tbl-one-text">预存账户余额<span class="myrequrire">*</span>
								</td>
								<td class="tbl-one-edit-value"><input type="text" class="form-control" name="accountMoney"
									placeholder="请输入预存账户余额" required></td>
							</tr>
						</table>
					</form>

				</div>
				<div class="modal-footer">
					<button type="button" class="btn btn-default" data-dismiss="modal">关闭</button>
					<button type="button" class="btn btn-primary" id="btnSaveCustomAccountInfo">保存</button>
				</div>
			</div>
		</div>
	</div>
	<script type="text/javascript">
		var buttonsPermission = "${buttons}";
	</script>
	<script type="text/javascript"
		src="${pageContext.request.contextPath}/static/pageJs/custom/customAccountInfo.js"></script>
</body>
</html>