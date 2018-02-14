<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<%@ include file="/jsp/public/top.jsp"%>
<script language="javascript">
	var flowSet = "${flowSetType}";
</script>
</head>
<body>
	<div class="main">
		<%@ include file="/jsp/public/header.jsp"%>
		<%@ include file="/jsp/public/left.jsp"%>
		<div class="main-content">
			<div class="position">
				<ol class="breadcrumb">
					<li><a href="#"><i class="icon icon-home"></i> 位置</a></li>
					<li><a href="#">请假管理</a></li>
					<li class="active">请假信息</li>
				</ol>
			</div>
			<div class="wrapper">
				<div class="panel">
					<div class="panel-body">
						<form class="form-horizontal" id="queryContractForm">
							<table class="mainQueryTable">
								<tr>
									<td class="tbl-three-text">工号/姓名</td>
									<td class="tbl-three-edit-value">
											<input type="text" class="form-control" name="queryCondition"
												id="queryCondition" placeholder="请输入工号/姓名进行查询"
												>
										</td>
									<td class="tbl-three-text">审核状态</td>
									<td class="tbl-three-edit-value"><select name="queryPxlx"
										class="form-control">
											<option value=''>--请选择--</option>
											<option value='1'>草稿</option>
											<option value='100'>待审核</option>
											<option value='101'>进行中</option>
											<option value='102'>已完成</option>
											<option value='-99'>审核不通过</option>
									</select>
									</td>
									<td>
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
						<div class="pull-left">
							<button class="btn btn-primary btnQuery" id="btnNew">请假</button>
						</div>
						<br> <br>
						<table class="mainTable table-hover" id="mainTable">
							<thead>
								<tr>
									<td class="text-center">姓名</td>
									<td class="text-center">工号</td>
									<td class="text-center">请假类型</td>
									<td class="text-center">请假名称</td>
									<td class="text-center">请假开始时间</td>
									<td class="text-center">请假结束时间</td>
									<td class="text-center">请假时长</td>
									<td class="text-center">任务状态</td>
									<!-- <th data-width="130px" class="text-center">操作</th> -->
								</tr>
							</thead>
							<tbody id="tblLevelInfo">
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
	<div class="modal fade" id="modelEdithLevelInfo">
		<div class="modal-dialog">
			<div class="modal-content">
				<div class="modal-header">
					<button type="button" class="close" data-dismiss="modal">
						<span aria-hidden="true">×</span><span class="sr-only">关闭</span>
					</button>
					<h4 class="modal-title">编辑</h4>
				</div>
				<div class="modal-body">
					<form class="form-horizontal" id="levelForm">
						<table style="width: 100%" class="mainTable">
							<tr>
								<td class="tbl-one-text"><input type="hidden" name="wid"
									value=""> <input type="hidden" name="taskstatus"
									value=""> 请假类型<span class="myrequrire">*</span></td>
								<td class="tbl-one-edit-value"><select name="type"
									class="form-control" required placeholder="请选择请假类型">
								</select></td>
							</tr>
							<tr>
								<td class="tbl-one-text">请假名称<span class="myrequrire">*</span></td>
								<td class="tbl-one-edit-value"><input type="text"
									class="form-control" name="name" placeholder="请输入请假名称" required></td>
							</tr>
							<tr>
								<td class="tbl-one-text">请假开始时间<span class="myrequrire">*</span></td>
								<td class="tbl-one-edit-value"><input type="text" id="txtStartDate"
									class="form-control" name="starttime" placeholder="请选择请假开始时间"
									required onFocus="WdatePicker({ dateFmt:'yyyy-MM-dd HH:mm',maxDate:'#F{$dp.$D(\'txtEndDate\')}'})"></td>
							</tr>
							<tr>
								<td class="tbl-one-text">请假结束时间<span class="myrequrire">*</span></td>
								<td class="tbl-one-edit-value"><input type="text" id="txtEndDate"
									class="form-control" name="endtime" placeholder="请选择请假结束时间"
									required onFocus="WdatePicker({ dateFmt:'yyyy-MM-dd HH:mm ',minDate:'#F{$dp.$D(\'txtStartDate\')}' })"></td>
							</tr>
							<tr>
								<td class="tbl-one-text">备注</td>
								<td class="tbl-one-edit-value"><textarea name="content"
										class="form-control" placeholder="请输入备注信息">
								</textarea></td>
							</tr>
						</table>
					</form>
				</div>
				<div class="modal-footer">
					<button type="button" class="btn btn-default" data-dismiss="modal">关闭</button>
					<!-- <button type="button" class="btn btn-primary" id="btnSaveLeaveInfo">保存草稿</button> -->
					<button type="button" class="btn btn-primary" id="btnShLeaveInfo">提交审核</button>
				</div>
			</div>
		</div>
	</div>

	<script type="text/javascript">
		var flag = "${flag}";
	</script>
	<script id="tblLevelInfoTpl" type="text/x-jquery-tmpl">
				<tr>
					<td class="text-center">
						{{if userInfo}}
							{{= userInfo.name1}}
						{{/if}} 
					</td>
					<td class="text-center">
						{{if userInfo}}
							{{= userInfo.gh}}
						{{/if}}
					</td>
					<td class="text-left">
						{{if qjlxSjzd}}
							{{= qjlxSjzd.lbmc}}
						{{/if}}
					</td>
					<td class="text-left">{{= name}}</td>
					<td class="text-left">{{= starttime}}</td>
					<td class="text-left">{{= endtime}}</td>
					<td class="text-left">{{= time}}</td>
					<td class="text-left">
						{{if taskstatusSjzd}}
							{{= taskstatusSjzd.lbmc}}
						{{/if}}
					</td>
				</tr>
			</script>
	<script type="text/javascript"
		src="${pageContext.request.contextPath}/static/pageJs/usermanage/userleaveInfo.js"></script>
</body>
</html>