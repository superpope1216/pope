<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<%@ include file="/jsp/public/top.jsp"%>
<script language="javascript">
	var flowSet="${flowSetType}";
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
					<li><a href="#">系统管理</a></li>
					<li class="active">请假管理</li>
				</ol>
			</div>
			<div class="wrapper">
				<div class="panel">
					<div class="panel-body">
						<div class="pull-left">
							<button class="btn btn-primary btnQuery" id="btnNew">请假</button>
						</div>
						<br> <br>
						<table class="table table-bordered datatable table-hover"
							id="mainTable">
							<thead>
								<tr>
									<th class="text-center">姓名</th>
									<th class="text-center">工号</th>
									<th class="text-center">请假类型</th>
									<th class="text-center">请假名称</th>
									<th class="text-center">请假开始时间</th>
									<th class="text-center">请假结束时间</th>
									<th class="text-center">请假时长</th>
									<th class="text-center">任务状态</th>
									<th data-width="130px" class="text-center">操作</th>
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
						<div class="form-group">
							<input type="hidden" name="wid" value=""> 
							<input type="hidden" name="taskstatus" value="">
							<label
								for="type" class="col-sm-2 required">请假类型</label>
							<div class="col-md-8 col-sm-8">
								<select name="type" class="form-control" required placeholder="请选择请假类型">
								</select>
							</div>
						</div>
						<div class="form-group">
							<label for="name" class="col-sm-2 required">请假名称</label>
							<div class="col-md-8 col-sm-8">
								<input type="text" class="form-control" name="name"
									placeholder="请输入请假名称" required>
							</div>
						</div>
						<div class="form-group">
							<label for="starttime" class="col-sm-2 required">请假开始时间</label>
							<div class="col-md-8 col-sm-8">
								<input type="text" class="form-control" name="starttime"
									placeholder="请选择请假开始时间" required onFocus="WdatePicker({ dateFmt:'yyyy-MM-dd HH:mm ' })">
							</div>
						</div>
						<div class="form-group">
							
							<label for="endtime" class="col-sm-2 required">请假结束时间</label>
							<div class="col-md-8 col-sm-8">
								<input type="text" class="form-control" name="endtime"
									placeholder="请选择清洁结束时间" required onFocus="WdatePicker({ dateFmt:'yyyy-MM-dd HH:mm ' })">
							</div>
						</div>
						<div class="form-group">
							<label for="content" class="col-sm-2">备注</label>
							<div class="col-md-8 col-sm-8">
								<textarea name="content" class="form-control" placeholder="请输入备注信息">
								</textarea>
							</div>
						</div>

					</form>

				</div>
				<div class="modal-footer">
					<button type="button" class="btn btn-default" data-dismiss="modal">关闭</button>
					<button type="button" class="btn btn-primary" id="btnSaveLeaveInfo">保存草稿</button>
					<button type="button" class="btn btn-primary" id="btnShLeaveInfo">提交审核</button>
				</div>
			</div>
		</div>
	</div>


	<script id="tblLevelInfoTpl" type="text/x-jquery-tmpl">
				<tr>
					<td class="text-center">
						{{if userInfo}}
							{{= userInfo.name}}
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
					<td class="text-center"><div class="btn-group">
							{{if taskstatus=="01"}}

          								<button type="button" data-key='{{= wid}}' data-option='editLeave' class="btn btn-xs btn-primary"><i class="icon icon-edit"></i>编辑</button>
			
          								<button type="button" data-key='{{= wid}}' data-option='deleteLeave' style="margin-left:4px;" class="btn btn-xs btn-danger"><i class="icon icon-times"></i>删除</button>
							{{/if}}
        			</div></td>
				</tr>
			</script>
	<script type="text/javascript"
		src="${pageContext.request.contextPath}/static/pageJs/usermanage/userleaveInfo.js"></script>
</body>
</html>