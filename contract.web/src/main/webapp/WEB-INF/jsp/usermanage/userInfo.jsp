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
					<li><a href="#">系统管理</a></li>
					<li class="active">用户管理</li>
				</ol>
			</div>
			<div class="wrapper">
				<div class="panel">
					<div class="panel-body">
						<form action="#" method="post">
							<div class="search">
								用户信息： <input type="text" class="text" id="queryCondition"
									placeholder="可根据工号、姓名搜索" class="queryCondition"> &nbsp;
								<button class="btn btn-primary btnQuery" type="button"
									id="btnQuery">查询</button>
							</div>
						</form>
					</div>
				</div>
				<div class="panel">
					<div class="panel-body">
						<div class="pull-left">
							<button class="btn btn-primary btnQuery" style="display: none;"
								id="btnNew">新 建</button>
						</div>

						&nbsp;&nbsp;
						<div class="pull-right">
							&nbsp;&nbsp;
							<button class="btn btn-primary btnQuery" style="display: none;"
								id="btnExport">导出</button>
						</div>
						<br> <br>
						<table class="mainTable table-hover" id="mainTable">
							<thead>
								<tr>
									<td class="text-center">姓名</td>
									<td class="text-center">工号</td>
									<td class="text-center">部门信息</td>
									<td class="text-center">小组</td>
									<td class="text-center">学位</td>
									<td class="text-center">职位类别</td>
									<td class="text-center">职位</td>
									<td data-width="130px" class="text-center">操作</td>
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
	<div class="modal fade" id="modelEdithUserInfo">
		<div class="modal-dialog modal-lg">
			<div class="modal-content">
				<div class="modal-header">
					<button type="button" class="close" data-dismiss="modal">
						<span aria-hidden="true">×</span><span class="sr-only">关闭</span>
					</button>
					<h4 class="modal-title">编辑</h4>
				</div>
				<div class="modal-body">
					<form class="form-horizontal" id="userForm">
						<table style="width: 100%" class="mainTable">
							<tr>
								<td class="tbl-two-text"><input type="hidden" name="wid"
									value=""> 人员名称<span class="myrequrire">*</span></td>
								<td class="tbl-two-edit-value"><input type="text"
									class="form-control" name="name1" placeholder="请输入人员名称"
									required> </select></td>
								<td class="tbl-two-text">员工号<span class="myrequrire">*</span>
								</td>
								<td class="tbl-two-edit-value"><input type="text"
									class="form-control" name="gh" placeholder="请输入员工号" required>
								</td>
							</tr>
							<tr>
								<td class="tbl-two-text">手机号<span class="myrequrire">*</span></td>
								<td class="tbl-two-edit-value"><input type="text"
									class="form-control" name="phone" placeholder="请输入手机号" required>
									</select></td>
								<td class="tbl-two-text">邮箱地址<span class="myrequrire">*</span>
								</td>
								<td class="tbl-two-edit-value"><input type="text"
									class="form-control" name="email" placeholder="请输入邮箱地址"
									required></td>
							</tr>
							<tr>
								<td class="tbl-two-text">部门信息<span class="myrequrire">*</span></td>
								<td class="tbl-two-edit-value"><div class="input-group">
										<input type="hidden" name="department" id="department"
											value="" /> <input type="text" class="form-control" readonly
											id="txtDepartment" name="txtDepartment" placeholder="请选择部门信息"
											required> <span class="input-group-addon"
											id="btnSelectBm"><i class="icon caret"></i></span>

									</div></td>
								<td class="tbl-two-text">科室小组<span class="myrequrire">*</span>
								</td>
								<td class="tbl-two-edit-value"><select id="team"
									class="form-control" name="team" required placeholder="请选择科室小组"></select>
								</td>
							</tr>
							<tr>
								<td class="tbl-two-text">出生年月<span class="myrequrire">*</span></td>
								<td class="tbl-two-edit-value">	<input type="text" class="form-control" name="birthday"
									placeholder="请输入出生年月" onClick="WdatePicker()" required>
									</select></td>
								<td class="tbl-two-text">学位
								</td>
								<td class="tbl-two-edit-value"><input type="text" class="form-control" name="degree"
									placeholder="请输入学位"></td>
							</tr>
							
							<tr>
								<td class="tbl-two-text">职位类别<span class="myrequrire">*</span></td>
								<td class="tbl-two-edit-value"><select class="form-control" name="jobcategory"
									placeholder="请输入职位类别" required></select></td>
								<td class="tbl-two-text">职位<span class="myrequrire">*</span
								</td>
								<td class="tbl-two-edit-value">
								<input type="text" class="form-control" name="job"
									placeholder="请输入职位" required></td>
							</tr>
							
							<tr>
								<td class="tbl-two-text">合同有效期(月)<span class="myrequrire">*</span></td>
								<td class="tbl-two-edit-value"><input type="text" class="form-control" name="contractvalidity"
									placeholder="请输入合同有效期" required></td>
								<td class="tbl-two-text">合同签订时间<span class="myrequrire">*</span
								</td>
								<td class="tbl-two-edit-value">
								<input type="text" class="form-control" name="contracttime"
									onClick="WdatePicker()" placeholder="请输入合同签订时间" required></td>
							</tr>
							<tr>
								<td class="tbl-two-text">权限信息<span class="myrequrire">*</span></td>
								<td class="tbl-two-edit-value" colspan="1"><select id="userInfoRole" name="userInfoRole"
									class="form-control" multiple="multiple" required>
								</select></td>
								<td colspan="2">&nbsp;</td>
							</tr>
						</table>

					</form>

				</div>
				<div class="modal-footer">
					<button type="button" class="btn btn-default" data-dismiss="modal">关闭</button>
					<button type="button" class="btn btn-primary" id="btnSaveUserInfo">保存</button>
				</div>
			</div>
		</div>
	</div>

	<div id="menuContent" class="menuContent"
		style="display: none; z-index: 999999999; background: #f1f1f1; position: absolute;">
		<ul id="treeDemo" class="ztree" style="margin-top: 0; width: 100%;"></ul>
	</div>
	<script type="text/javascript">
		var buttonsPermission = "${buttons}";
	</script>
	<script type="text/javascript"
		src="${pageContext.request.contextPath}/static/pageJs/usermanage/userInfo.js"></script>
</body>
</html>