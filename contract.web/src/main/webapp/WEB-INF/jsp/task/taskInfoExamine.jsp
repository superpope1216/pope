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
					<li><a href="#">任务管理</a></li>
					<li class="active">任务审核</li>
				</ol>
			</div>
			<div class="wrapper">
				<div class="panel">
					<div class="panel-body">
						<ul class="nav nav-tabs">
							<li class="active"><a data-tab href="#dshContent">待审核</a></li>
							<li><a data-tab href="#ywcContent">已完成</a></li>
							<li><a data-tab href="#shbtgContent">审核不通过</a></li>
						</ul>
						<div class="tab-content">
							<div class="tab-pane active" id="dshContent">
								<br>
								<table class="mainTable table-hover"
									id="mainTable">
									<thead>
										<tr>
											<td class="text-center">任务名称</td>
											<td class="text-center">责任人</td>
											<td class="text-center">计划开始时间</td>
											<td class="text-center">计划结束时间</td>
											<td class="text-center">实际开始时间</td>
											<td class="text-center">实际结束时间</td>
											<td class="text-center">任务审核人</td>
											<td class="text-center">任务状态</td>
											<td data-width="160px" class="text-center">操作</td>
										</tr>
									</thead>
									<tbody id="tblTaskInfo">
									</tbody>
								</table>
								<div class="pull-right">
									<div id='pageInfo' class="pagination"></div>
								</div>
							</div>
							<div class="tab-pane" id="ywcContent">
								<br>
								<table class="mainTable table-hover"
									id="ywcTable">
									<thead>
										<tr>
											<td class="text-center">任务名称</td>
											<td class="text-center">责任人</td>
											<td class="text-center">计划开始时间</td>
											<td class="text-center">计划结束时间</td>
											<td class="text-center">实际开始时间</td>
											<td class="text-center">实际结束时间</td>
											<td class="text-center">任务审核人</td>
											<td class="text-center">任务状态</td>
										</tr>
									</thead>
									<tbody id="tblYwcTaskInfo">
									</tbody>
								</table>
								<div class="pull-right">
									<div id='ywcPageInfo' class="pagination"></div>
								</div>
							</div>
							<div class="tab-pane" id="shbtgContent">
								<br>
								<table class="mainTable table-hover"
									id="btgTable">
									<thead>
										<tr>
											<td class="text-center">任务名称</td>
											<td class="text-center">责任人</td>
											<td class="text-center">计划开始时间</td>
											<td class="text-center">计划结束时间</td>
											<td class="text-center">实际开始时间</td>
											<td class="text-center">实际结束时间</td>
											<td class="text-center">任务审核人</td>
											<td class="text-center">任务状态</td>
										</tr>
									</thead>
									<tbody id="tblBtgTaskInfo">
									</tbody>
								</table>
								<div class="pull-right">
									<div id='btgPageInfo' class="pagination"></div>
								</div>
							</div>
						</div>
					</div>
				</div>
			</div>
		</div>

		<script id="tblTaskInfoTpl" type="text/x-jquery-tmpl">
				<tr>
					<td class="text-center">{{= rwmc}}</td>
					<td class="text-center">{{= rwfpr_display}}</td>
					<td class="text-center">{{= jhkssj}}</td>
					<td class="text-left">{{= jhjssj}}</td>
					<td class="text-left">{{= sjkssj}}</td>
					<td class="text-left">{{= sjjssj}}</td>
					<td class="text-left">{{= rwshr_display}}</td>
					<td class="text-left">{{= rwzt_display}}</td>
					<td class="text-center">
						<div class="btn-group">
						    <button type="button" style="margin-left:4px;" class="btn btn-xs btn-primary" data-option="pass" data-key="{{= wid}}">通过</button>
          					<button type="button" style="margin-left:4px;" class="btn btn-xs btn-danger" data-option="notPass" data-key="{{= wid}}"><i class="icon icon-times"></i>不通过</button>
        				</div>
					</td>
				</tr>
			</script>

		<script id="tblTaskInfoTpl2" type="text/x-jquery-tmpl">
				<tr>
					<td class="text-center">{{= rwmc}}</td>
					<td class="text-center">{{= rwfpr_display}}</td>
					<td class="text-center">{{= jhkssj}}</td>
					<td class="text-left">{{= jhjssj}}</td>
					<td class="text-left">{{= sjkssj}}</td>
					<td class="text-left">{{= sjjssj}}</td>
					<td class="text-left">{{= rwshr_display}}</td>
					<td class="text-left">{{= rwzt_display}}</td>
				</tr>
			</script>
		<script type="text/javascript"
			src="${pageContext.request.contextPath}/static/pageJs/task/taskInfoExamine.js"></script>
</body>
</html>