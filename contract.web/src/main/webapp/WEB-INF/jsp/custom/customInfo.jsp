<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<%@ include file="/jsp/public/top.jsp"%>
<style type="text/css">
#modelViewCustomInfo .form-group {
	margin-bottom: 3px;
}
</style>
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
					<li class="active">客户档案信息</li>
				</ol>
			</div>
			<div class="wrapper">
				<div class="panel">
					<div class="panel-body">
						<form action="#" method="post">
							<div class="search">
								<input type="text" class="text" id="queryCondition"
									placeholder="客户编号/客户名称" class="queryCondition"> &nbsp;
								<button class="btn btn-primary btnQuery" type="button"
									id="btnQuery">查询</button>
							</div>
						</form>
					</div>
				</div>
				<div class="panel">
					<div class="panel-body">
						<div class="pull-left">
							<button class="btn btn-primary btnQuery" id="btnAdd"
								style="display: none; margin-bottom: 15px;">新建</button>
							&nbsp;&nbsp;

						</div>
						<table class="mainTable table-hover" id="mainTable">
							<thead>
								<tr>
									<td class="text-center" style="width: 80px;"><input
										type="checkbox" name="selAll" /></td>
									<td class="text-center">客户编码</td>
									<td class="text-center">客户名称</td>
									<td class="text-center">客户类别</td>
									<td class="text-center">客户公司信息</td>
									<td class="text-center">联系方式</td>
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
	<div class="modal fade" id="modelAddCustomAccountInfo"
		style="z-Index: 99999999999">
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
									value=""> <input type="hidden" name="dqbh" value="">
									<input type="hidden" name="customId" value="">预存账号编号<span
									class="myrequrire">*</span></td>
								<td class="tbl-one-edit-value"><input type="text" readonly
									name="accountNumber" placeholder="请输入账户编号" required></td>
								
							</tr>
							<tr>
								<td class="tbl-one-text">预存账户信息<span class="myrequrire">*</span>
								</td>
								<td class="tbl-one-edit-value"><input type="text"
									class="form-control" name="bankAccount" placeholder="请输入银行账户"
									required></td>
							</tr>
							<tr>
								<td class="tbl-one-text">预存账户余额<span class="myrequrire">*</span>
								</td>
								<td class="tbl-one-edit-value"><input type="text" class="form-control" name="accountMoney"
									placeholder="请输入账户余额" required></td>
							</tr>
						</table>
					</form>
				</div>
				<div class="modal-footer">
					<button type="button" class="btn btn-default" data-dismiss="modal">关闭</button>
					<button type="button" class="btn btn-primary"
						id="btnSaveCustomAccountInfo">保存</button>
				</div>
			</div>
		</div>
	</div>

	<div class="modal fade" id="modelViewCustomInfo">
		<div class="modal-dialog modal-lg">
			<div class="modal-content">
				<div class="modal-header">
					<button type="button" class="close" data-dismiss="modal">
						<span aria-hidden="true">×</span><span class="sr-only">关闭</span>
					</button>
					<h4 class="modal-title">客户详情</h4>
				</div>
				<div class="modal-body">
					<table style="width: 100%; margin-top: 5px;">
						<tr>
							<td align="left">
								<h3>客户详情</h3>
							</td>
							<td align="right">
								<button class="btn pull-right btn-primary btnQuery"
									id="btnAddAccount" style="margin-bottom: 15px;">新建客户账户</button>
							</td>
						</tr>
					</table>
					<form class="form-horizontal" id="customViewForm"
						style="margin-top: 10px;">
						<table class="mainTable">
							<tr>
								<td class="tbl-two-text">客户名称</td>
								<td class="tbl-two-edit-value"><input type="hidden" name="wid"><p class="form-control-static" name="customName"></p></td>
								<td class="tbl-two-text">客户编号</td>
								<td class="tbl-two-edit-value"><p class="form-control-static" name="customNumber"></p></td>
							</tr>
							<tr>
								<td class="tbl-two-text">客户类别</td>
								<td class="tbl-two-edit-value"><p class="form-control-static" name="customType"></p></td>
								<td class="tbl-two-text">客户联系方式</td>
								<td class="tbl-two-edit-value"><p class="form-control-static" name="contractWay"></p></td>
							</tr>
							<tr>
								<td class="tbl-two-text">客户基本信息</td>
								<td class="tbl-two-edit-value" colspan="3"><p class="form-control-static" name="linkMan"></p></td>
							</tr>
							<tr>
								<td class="tbl-two-text">客户公司名称</td>
								<td class="tbl-two-edit-value" colspan="3"><p class="form-control-static" name="companyName"></p></td>
							</tr>
							<tr>
								<td class="tbl-two-text">客户公司地址</td>
								<td class="tbl-two-edit-value" colspan="3"><p class="form-control-static" name="companyAddress"></p></td>
							</tr>
							<tr>
								<td class="tbl-two-text">客户银行账户</td>
								<td class="tbl-two-edit-value" colspan="3"><p class="form-control-static" name="companyAccount"></p></td>
							</tr>
							<tr>
								<td class="tbl-two-text">客户开户行</td>
								<td class="tbl-two-edit-value" colspan="3"><p class="form-control-static" name="companyPreAccount"></p></td>
							</tr>
						</table>
					</form>
					<br>
					<table class="mainTable table-hover"
						id="mainAccountTable">
						<thead>
							<tr>
								<td class="text-center">预存账户编号</td>
								<td class="text-center">预存账户信息</td>
								<td class="text-center">预存账户余额</td>
								<td data-width="160px" class="text-center">操作</td>
							</tr>
						</thead>
						<tbody id="tblAccountInfo">
						</tbody>
					</table>
				</div>
				<div class="modal-footer">
					<button type="button" class="btn btn-default" data-dismiss="modal">关闭</button>
				</div>
			</div>
		</div>
	</div>
	<div class="modal fade" id="modelEdidCustomInfo">
		<div class="modal-dialog modal-lg">
			<div class="modal-content">
				<div class="modal-header">
					<button type="button" class="close" data-dismiss="modal">
						<span aria-hidden="true">×</span><span class="sr-only">关闭</span>
					</button>
					<h4 class="modal-title">编辑</h4>
				</div>
				<div class="modal-body">
					<form class="form-horizontal" id="customForm"
						style="margin-top: 10px;">
						<table class="mainTable">
							<tr>
								<td class="tbl-two-text"><input type="hidden" name="wid"
									value=""> <input type="hidden" name="dqbh" value="">客户名称<span
									class="myrequrire">*</span></td>
								<td class="tbl-two-edit-value"><input type="text"
									class="form-control" name="customName" placeholder=""
									required></td>
									<td class="tbl-two-text">客户编号<span
									class="myrequrire">*</span></td>
								<td class="tbl-two-edit-value"><input type="text"  readonly
									name="customNumber" placeholder="" required></td>
							</tr>
							<tr>
								<td class="tbl-two-text">客户类别<span
									class="myrequrire">*</span></td>
								<td class="tbl-two-edit-value"><select name="customType" class="form-control" required>
									<option value=''>--请选择--</option>
								</select></td>
									<td class="tbl-two-text">客户联系方式<span
									class="myrequrire">*</span></td>
								<td class="tbl-two-edit-value"><input type="text" class="form-control" name="contractWay"
									placeholder="" required></td>
							</tr>
							<tr>
								<td class="tbl-two-text">客户基本信息<span
									class="myrequrire">*</span></td>
								<td class="tbl-two-edit-value" colspan="3"><input type="text" class="form-control" name="linkMan"
									placeholder="" required></td>
							</tr>
							<tr>
								<td class="tbl-two-text">客户公司名称<span
									class="myrequrire">*</span></td>
								<td class="tbl-two-edit-value" colspan="3"><input type="text" class="form-control" name="companyName"
									placeholder="" required></td>
							</tr>
							<tr>
								<td class="tbl-two-text">客户公司地址<span
									class="myrequrire">*</span></td>
								<td class="tbl-two-edit-value" colspan="3"><input type="text" class="form-control" name="companyAddress"
									placeholder="" required></td>
							</tr>
							<tr>
								<td class="tbl-two-text">客户银行账户<span
									class="myrequrire">*</span></td>
								<td class="tbl-two-edit-value" colspan="3"><input type="text" class="form-control" name="companyAccount"
									placeholder="" required></td>
							</tr>
							<tr>
								<td class="tbl-two-text">客户开户行<span
									class="myrequrire">*</span></td>
								<td class="tbl-two-edit-value" colspan="3"><input type="text" class="form-control" name="companyPreAccount"
									placeholder="" required></td>
							</tr>
						</table>
						
					</form>

				</div>
				<div class="modal-footer">
					<button type="button" class="btn btn-default" data-dismiss="modal">关闭</button>
					<button type="button" class="btn btn-primary"
						id="btnSaveCustomInfo">保存</button>
				</div>
			</div>
		</div>
	</div>
	<script type="text/javascript">
		var buttonsPermission = "${buttons}";
		var token="${token}";
	</script>
	<script type="text/javascript"
		src="${pageContext.request.contextPath}/static/pageJs/custom/customInfo.js"></script>
</body>
</html>