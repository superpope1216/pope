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
					<li class="active">消息编辑</li>
				</ol>
			</div>
			<div class="wrapper">
				<div class="col-md-12 col-sm-12">
					<div class="panel">
						<div class="panel-body">
							<form class="form-horizontal" id="zdbsForm">
								<table style="width: 100%" class="mainTable">
									<tr>
										<td class="tbl-one-text" style="width: 15%;"><input
											type="hidden" name="wid" value="">消息名称<span
											class="myrequrire">*</span></td>
										<td class="tbl-one-edit-value" style="width: 85%;"><input
											type="text" class="form-control" name="name"
											placeholder="请输入消息名称" required></td>
									</tr>
									<tr>
										<td class="tbl-one-text" style="width: 15%;">接收人类型<span
											class="myrequrire">*</span></td>
										<td class="tbl-one-edit-value" style="width: 85%;"><select name="messageType" class="form-control" required>
												<option value=''>--请选择--</option>
											</select></td>
									</tr>
									<tr id="divDepart" style="display: none;">
										<td class="tbl-one-text" style="width: 15%;">部门信息<span
											class="myrequrire">*</span></td>
										<td class="tbl-one-edit-value" style="width: 85%;"><div class="input-group">
												<input type="hidden" name="messageReceiveDepart"
													id="messageReceiveDepart" value="" /> <input type="text"
													class="form-control" readonly id="txtDepartment"
													name="txtDepartment" placeholder="请选择部门信息" required>
												<span class="input-group-addon" id="btnSelectBm"><i
													class="icon caret"></i></span>
											</div></td>
									</tr>
									<tr id="divTeam" style="display: none;">
										<td class="tbl-one-text" style="width: 15%;">科室小组<span
											class="myrequrire">*</span></td>
										<td class="tbl-one-edit-value" style="width: 85%;"><select id="messageReceiveTeam" class="form-control"
												name="messageReceiveTeam" required placeholder="请选择科室小组"></select></td>
									</tr>
									<tr id="divPerson" style="display: none;">
										<td class="tbl-one-text" style="width: 15%;">用户信息<span
											class="myrequrire">*</span></td>
										<td class="tbl-one-edit-value" style="width: 85%;"><select id="messageReceiveMan" class="form-control"
												name="messageReceiveMan" required placeholder="请选择用户信息"></select></td>
									</tr>
									<tr >
										<td class="tbl-one-text" style="width: 15%;"><input type="hidden" name="content" />消息内容<span
											class="myrequrire">*</span></td>
										<td class="tbl-one-edit-value" style="width: 85%;"><div style="width: 100%;">
												<SCRIPT id="txtcontent" align="center" name="txtcontent"
													type=text/plain></SCRIPT>
											</div></td>
									</tr>
									</table>
									<div class="form-group">
										<div class="col-md-10 col-sm-10"
											style="text-align: center; margin: 0 auto;">

											<button class="btn btn-primary btnQuery" type="button"
												id="btnSave">保存</button>
											<button class="btn btn-default btnQuery" type="button"
												id="btnBack">返回</button>
										</div>
									</div>
							</form>

						</div>

					</div>
				</div>
			</div>
			<div id="menuContent" class="menuContent"
				style="display: none; z-index: 999999999; background: #f1f1f1; position: absolute;">
				<ul id="treeDemo" class="ztree" style="margin-top: 0; width: 100%;"></ul>
			</div>
			<script type="text/javascript">
				var wid = "${wid}";
			</script>
			<script type="text/javascript"
				src="${pageContext.request.contextPath}/static/pageJs/system/messageedit.js"></script>
</body>
</html>