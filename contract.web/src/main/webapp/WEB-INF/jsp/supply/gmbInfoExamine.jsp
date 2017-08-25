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
					<li class="active">项目任务审核</li>
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
											<th class="text-center">耗材分类</th>
											<th class="text-center">耗材编号</th>
											<th class="text-center">品名</th>
											<th class="text-center">购买数量</th>
											<th class="text-center">购买人</th>
											<th class="text-center">购买时间</th>
											<th data-width="160px" class="text-center">操作</th>
										</tr>
									</thead>
									<tbody id="tblTaskInfo">
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
											<th class="text-center">耗材分类</th>
											<th class="text-center">耗材编号</th>
											<th class="text-center">品名</th>
											<th class="text-center">购买数量</th>
											<th class="text-center">购买人</th>
											<th class="text-center">购买时间</th>
										</tr>
									</thead>
									<tbody id="tblJxzTaskInfo">
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
											<th class="text-center">耗材分类</th>
											<th class="text-center">耗材编号</th>
											<th class="text-center">品名</th>
											<th class="text-center">购买数量</th>
											<th class="text-center">购买人</th>
											<th class="text-center">购买时间</th>
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
								<table class="table table-bordered datatable table-hover"
									id="btgTable">
									<thead>
										<tr>
											<th class="text-center">耗材分类</th>
											<th class="text-center">耗材编号</th>
											<th class="text-center">品名</th>
											<th class="text-center">购买数量</th>
											<th class="text-center">购买人</th>
											<th class="text-center">购买时间</th>
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
					<td class="text-center">{{= hcfl_display}}</td>
					<td class="text-center">{{= xhppch}}</td>
					<td class="text-center">{{= pm}}</td>
					<td class="text-center">{{= lysl}}</td>
					<td class="text-center">{{= userid_display}}</td>
					<td class="text-left">{{= sqsj}}</td>
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
					
					<td class="text-center">{{= hcfl_display}}</td>
					<td class="text-center">{{= xhppch}}</td>
					<td class="text-center">{{= pm}}</td>
					<td class="text-center">{{= lysl}}</td>
					<td class="text-center">{{= userid_display}}</td>
					<td class="text-left">{{= sqsj}}</td>
				</tr>
			</script>
		<script type="text/javascript"
			src="${pageContext.request.contextPath}/static/pageJs/supply/gmbInfoExamine.js"></script>
</body>
</html>