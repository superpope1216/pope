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
					<li><a href="#">批次管理</a></li>
					<li class="active">样品批次详情</li>
				</ol>
			</div>
			<div class="wrapper">
				<table style="width: 100%;">
					<tr>
						<td style="width: 50%; position: relative;">
							<div class="panel">
								<div class="panel-body">
									<table style="width: 100%; margin-top: 5px;">
										<tr>
											<td align="left">
												<h3>批次详情</h3>
											</td>
										</tr>
									</table>
									
									<form class="form-horizontal" id="userForm"
										style="margin-top: 10px;">

										<div class="form-group"><label
												for="name" class="col-sm-2">类别</label>
											<div class="col-md-4 col-sm-4">
												<p class="form-control-static" name="pclb_display"></p>
											</div>
											<label for="gh" class="col-sm-2">二级分类</label>
											<div class="col-md-4 col-sm-4">
												<p class="form-control-static" name="ejfl"></p>
											</div>
										</div>
										<div class="form-group">
											<label for="phone" class="col-sm-2 ">批次名称</label>
											<div class="col-md-4 col-sm-4">
													<p class="form-control-static" name="pcmc"></p>
											</div>
											<label for="email" class="col-sm-2 ">样品批号</label>
											<div class="col-md-4 col-sm-4">
												<p class="form-control-static" name="ypph"></p>
											</div>
										</div>
										<div class="form-group">
											<label for="phone" class="col-sm-2 ">数量</label>
											<div class="col-md-4 col-sm-4">
												<p class="form-control-static" name="sl"></p>
											</div>
											<label for="department" class="col-sm-2 ">品牌</label>
											<div class="col-md-4 col-sm-4">
												<p class="form-control-static" name="pp_display"></p> 
											</div>
										</div>
										<div class="form-group">
											<label for="phone" class="col-sm-2 ">数量单位</label>
											<div class="col-md-4 col-sm-4">
												<p class="form-control-static" name="sldw_display"></p>
											</div>
											<label for="department" class="col-sm-2 ">存放地</label>
											<div class="col-md-4 col-sm-4">
												<p class="form-control-static" name="cfd"></p>
											</div>
										</div>
										<div class="form-group">
											<label for="phone" class="col-sm-2 ">单价</label>
											<div class="col-md-4 col-sm-4">
												<p class="form-control-static" name="dj"></p>
											</div>
											<label for="department" class="col-sm-2 ">货币单位</label>
											<div class="col-md-4 col-sm-4">
											<p class="form-control-static" name="hbdw_display"></p>
											</div>
										</div>
										<div class="form-group">
											<label for="birthday" class="col-sm-2 ">控制时间点</label>
											<div class="col-md-4 col-sm-4">
												<p class="form-control-static" name="kzsjd"></p>
											</div>
											<label for="degree" class="col-sm-2 ">送样时间</label>
											<div class="col-md-4 col-sm-4">
												<p class="form-control-static" name="sysj"></p>
											</div>
										</div>
										<div class="form-group">

											<label for="jobcategory" class="col-sm-2 ">对方单位</label>
											<div class="col-md-10 col-sm-10">
												<p class="form-control-static" name="gys"></p>
											</div>
										</div>
										<div class="form-group">
											<label for="phone" class="col-sm-2 ">送样人</label>
											<div class="col-md-4 col-sm-4">
												<p class="form-control-static" name="syr"></p>
											</div>
											<label for="phone" class="col-sm-2 ">送样单位</label>
											<div class="col-md-4 col-sm-4">
											<p class="form-control-static" name="sydw_display"></p>
											</div>

										</div>
										<div class="form-group">
											<label for="phone" class="col-sm-2 ">送样项目负责人</label>
											<div class="col-md-4 col-sm-4">
												<p class="form-control-static" name="syxmfzr"></p>
											</div>
											<label for="phone" class="col-sm-2 ">审核时间</label>
											<div class="col-md-4 col-sm-4">
												<p class="form-control-static" name="shsj"></p>
											</div>

										</div>
										<div class="form-group">
											<label for="phone" class="col-sm-2 ">样品状态监控</label>
											<div class="col-md-4 col-sm-4">
												<p class="form-control-static" name="pczt_display"></p>
											</div>
											<label for="phone" class="col-sm-2 ">合同号</label>
											<div class="col-md-4 col-sm-4">
												<p class="form-control-static" name="hth"></p>
											</div>

										</div>

										<div class="form-group">
											<label for="jobcategory" class="col-sm-2 ">分析项目</label>
											<div class="col-md-10 col-sm-10">
												<p class="form-control-static" name="fxxm_display"></p>
											</div>
										</div>
										<div class="form-group">
											<label for="jobcategory" class="col-sm-2">备注</label>
											<div class="col-md-10 col-sm-10">
												<p class="form-control-static" name="bz"></p>
											</div>
										</div>
									</form>
								</div>
							</div>
						</td>
						<td style="width: 50%; position: relative;">
							<div class="panel"
								style="height: 100%; top: 2px; width: 100%; position: absolute; margin: 0px; padding: 0px;">
								<div class="panel-body">

									<table style="width: 100%; margin-top: 5px;">
										<tr>
											<td align="left">
												<h3>批次内样品详情</h3>
											</td>
										</tr>
									</table>
									<table class="table table-bordered datatable table-hover"
										id="mainTable">
										<thead>
											<tr>
												<th class="text-center">样品编号</th>
												<th class="text-center">样品批次号</th>
												<th class="text-center">样品原有编号</th>
												<th class="text-center">样品性质</th>
												<th class="text-center">样品二维码</th>
												<th class="text-center">分析项目</th>
											</tr>
										</thead>
										<tbody id="tblDetailInfo">
										</tbody>
									</table>
									<div class="pull-right">
										<div id='pageInfo' class="pagination"></div>
									</div>
								</div>


							</div>
						</td>
					</tr>
				</table>


			</div>
		</div>
	</div>
<script id="tblDetailInfoTpl" type="text/x-jquery-tmpl">
				<tr>
					<td class="text-center">{{= ypbh}}</td>
					<td class="text-center">{{= ypph}}</td>
					<td class="text-left">{{= ypyybh}}</td>
					<td class="text-left">{{= ypxz}}</td>
					<td class="text-left">{{= ypewm}}</td>
					<td class="text-left">{{= fxxm_display}}</td>
				</tr>
			</script>
	<script type="text/javascript">
		var wid = "${wid}";
		var modifyType = "${type}";
	</script>
	<script type="text/javascript"
		src="${pageContext.request.contextPath}/static/pageJs/project/batchInfoDetailView.js"></script>
</body>
</html>