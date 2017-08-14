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
					<li class="active">请假审核</li>
				</ol>
			</div>
			<div class="wrapper">
				<div class="panel">
					<div class="panel-body">
						<ul class="nav nav-tabs">
							<li class="active"><a data-tab href="#dshContent">待审核</a></li>
							<li><a data-tab href="#jxzContent">进行中</a></li>
							<li><a data-tab href="#ywcContent">已完成</a></li>
							<li><a data-tab href="#shbtgContent">审核不通过</a></li>
						</ul>
						<div class="tab-content">
							<div class="tab-pane active" id="dshContent">
								<br>
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
											<th data-width="150px" class="text-center">操作</th>
										</tr>
									</thead>
									<tbody id="tblLevelInfo">
									</tbody>
								</table>
								<div class="pull-right">
									<div id='pageInfo' class="pagination"></div>
								</div>
							</div>
							<div class="tab-pane" id="jxzContent">
								<br>
								<table class="table table-bordered datatable table-hover"
									id="jxzTable">
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
										</tr>
									</thead>
									<tbody id="tblJxzLevelInfo">
									</tbody>
								</table>
								<div class="pull-right">
									<div id='jxzPageInfo' class="pagination"></div>
								</div>
							</div>
							<div class="tab-pane" id="ywcContent">
								<br>
								<table class="table table-bordered datatable table-hover"
									id="ywcTable">
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
										</tr>
									</thead>
									<tbody id="tblYwcLevelInfo">
									</tbody>
								</table>
								<div class="pull-right">
									<div id='ywcPageInfo' class="pagination"></div>
								</div>
							</div>
							<div class="tab-pane" id="shbtgContent">
								<br>
								<table class="table table-bordered datatable table-hover"
									id="btgTable">
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
										</tr>
									</thead>
									<tbody id="tblBtgLevelInfo">
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
					<td class="text-center">
						<div class="btn-group">
          					<button type="button" data-key='{{= wid}}' data-option='examineLeave' class="btn btn-xs btn-primary"><i class="icon icon-edit"></i>通过</button>
							<button type="button" data-key='{{= wid}}' data-option='examineNotPassLeave' style="margin-left:4px;" class="btn btn-xs btn-danger"><i class="icon icon-times"></i>不通过</button>
        			    </div>
				   </td>
				</tr>
			</script>
			
			<script id="tblLevelInfoTpl2" type="text/x-jquery-tmpl">
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
				</tr>
			</script>
		<script type="text/javascript"
			src="${pageContext.request.contextPath}/static/pageJs/usermanage/userleaveExamine.js"></script>
</body>
</html>