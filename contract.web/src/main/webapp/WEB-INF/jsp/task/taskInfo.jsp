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
					<li class="active">项目任务</li>
				</ol>
			</div>
			<div class="wrapper">
				<div class="panel">
					<div class="panel-body">
						<form action="#" method="post">
							<div class="search">


								<input type="text" class="text" name="topic"
									placeholder="送样人/样品批次号/样品编号" class="queryCondition"> &nbsp;
								<button class="btn btn-primary btnQuery" type="button" id="btnQuery">查询</button>
							</div>
						</form>
					</div>
				</div>
				<div class="panel">
					<div class="panel-body">
					<div class="pull-right">
							<button class="btn btn-primary btnQuery" id="btnSubmitSh">提交审核</button>
					</div>
						<br> <br>
						<table class="table table-bordered datatable table-hover"
							id="mainTable">
							<thead>
								<tr>
								<th class="text-center" style="width: 80px;"><input
										type="checkbox" name="selAll" /></th>
									<th class="text-center">任务分类</th>
									<th class="text-center">任务名称</th>
									<th class="text-center">责任人</th>
									<th class="text-center">计划开始时间</th>
									<th class="text-center">计划结束时间</th>
									<th class="text-center">实际开始时间</th>
									<th class="text-center">实际结束时间</th>
									<th class="text-center">任务审核人</th>
									<th class="text-center">任务状态</th>
									<th data-width="160px" class="text-center">操作</th>
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
	
	<script id="tblUserInfoTpl" type="text/x-jquery-tmpl">
				<tr>
					<td class="text-center"><input type="checkbox" name="chkSingle" value="{{= wid}}" data-rwzt="{{= rwzt}}"></td>
					<td class="text-center">{{= rwlx}}</td>
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
						    <button type="button" style="margin-left:4px;" class="btn btn-xs btn-primary" data-option="detail" data-key="{{= wid}}">详</button>
          					<button type="button" style="margin-left:4px;" class="btn btn-xs btn-danger" data-option="delete" data-key="{{= wid}}"><i class="icon icon-times"></i></button>
        				</div>
					</td>
				</tr>
			</script>
	<script type="text/javascript"
		src="${pageContext.request.contextPath}/static/pageJs/task/taskInfo.js"></script>
</body>
</html>