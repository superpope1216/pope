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
										style="margin-top: 10px;" style="display:none;">

										<div class="form-group">
											<input type="hidden" name="wid" value="">  <input
								type="hidden" name="dqbh" value=""><label
												for="name" class="col-sm-2 required">类别</label>
											<div class="col-md-4 col-sm-4">
												<select name="pclb" class="form-control" required>
													<option value=''>--请选择--</option>
												</select>
											</div>
											<label for="gh" class="col-sm-2 required">二级分类</label>
											<div class="col-md-4 col-sm-4">
												<input type="text" class="form-control" name="ejfl"
													placeholder="请输入二级分类" required>
											</div>
										</div>
										<div class="form-group">
											<label for="phone" class="col-sm-2 required">批次名称</label>
											<div class="col-md-4 col-sm-4">
												<input type="text" class="form-control" name="pcmc"
													placeholder="请输入批次名称" required>
											</div>
											<label for="email" class="col-sm-2 required">样品批号</label>
											<div class="col-md-4 col-sm-4">
												<input type="text" readonly class="form-control" name="ypph"
													placeholder="请输入邮样品批号" required>
											</div>
										</div>
										<div class="form-group">
											<label for="phone" class="col-sm-2 required">数量</label>
											<div class="col-md-4 col-sm-4">
												<input type="text" class="form-control" name="sl"
													placeholder="请输入数量" required>
											</div>
											<label for="department" class="col-sm-2 required">品牌</label>
											<div class="col-md-4 col-sm-4">
												<select name="pp" class="form-control" required>
													<option value=''>--请选择--</option>
												</select>
											</div>
										</div>
										<div class="form-group">
											<label for="phone" class="col-sm-2 required">数量单位</label>
											<div class="col-md-4 col-sm-4">
												<select name="sldw" class="form-control" required>
													<option value=''>--请选择--</option>
												</select>
											</div>
											<label for="department" class="col-sm-2 required">存放地</label>
											<div class="col-md-4 col-sm-4">
												<input type="text" class="form-control" name="cfd"
													placeholder="请输入存放地" required>
											</div>
										</div>
										<div class="form-group">
											<label for="phone" class="col-sm-2 required">单价</label>
											<div class="col-md-4 col-sm-4">
												<input type="text" class="form-control" name="dj"
													placeholder="请输入单价" required>
											</div>
											<label for="department" class="col-sm-2 required">货币单位</label>
											<div class="col-md-4 col-sm-4">
												<select name="hbdw" class="form-control" required>
													<option value=''>--请选择--</option>
												</select>
											</div>
										</div>
										<div class="form-group">
											<label for="birthday" class="col-sm-2 required">控制时间点</label>
											<div class="col-md-4 col-sm-4">
												<input type="text" class="form-control" name="kzsjd"
													placeholder="请输入控制时间点" onClick="WdatePicker()" required>
											</div>
											<label for="degree" class="col-sm-2 required">送样时间</label>
											<div class="col-md-4 col-sm-4">
												<input type="text" class="form-control" name="sysj"
													placeholder="请输入送样时间" onClick="WdatePicker()" required>
											</div>
										</div>
										<div class="form-group">

											<label for="jobcategory" class="col-sm-2 required">对方单位</label>
											<div class="col-md-10 col-sm-10">
												<input type="text" class="form-control" name="gys"
													placeholder="请输入对方单位" required>
											</div>
										</div>
										<div class="form-group">
											<label for="phone" class="col-sm-2 required">送样人</label>
											<div class="col-md-4 col-sm-4">
												<input type="text" class="form-control" name="syr"
													placeholder="请输入送样人" required>
											</div>
											<label for="phone" class="col-sm-2 required">送样单位</label>
											<div class="col-md-4 col-sm-4">
											<select name="sydw" class="form-control" required>
													<option value=''>--请选择--</option>
												</select>
											</div>

										</div>
										<div class="form-group">
											<label for="phone" class="col-sm-2 required">送样项目负责人</label>
											<div class="col-md-4 col-sm-4">
												<input type="text" class="form-control" name="syxmfzr"
													placeholder="请输入送样项目负责人" required>
											</div>
											<label for="phone" class="col-sm-2 required">审核时间</label>
											<div class="col-md-4 col-sm-4">
												<input type="text" class="form-control" name="shsj"
													placeholder="请输入审核时间" onClick="WdatePicker()" required>
											</div>

										</div>
										<!-- 
										<div class="form-group">
											<label for="phone" class="col-sm-2 required">样品状态监控</label>
											<div class="col-md-4 col-sm-4">
												<select name="pczt" class="form-control" required>
													<option value=''>--请选择--</option>
												</select>
											</div>
											<label for="phone" class="col-sm-2 ">合同号</label>
											<div class="col-md-4 col-sm-4">
												<input type="text" readonly class="form-control" name="hth"
													placeholder="" >
											</div>

										</div>
										 -->
										<div class="form-group">
											<label for="jobcategory" class="col-sm-2 required">分析项目</label>
											<div class="col-md-10 col-sm-10">
												<select id="fxxm" name="fxxm" class="form-control"
													multiple="multiple" required>
													<option value=''>--请选择--</option>
												</select>
											</div>
										</div>
										<div class="form-group">
											<label for="jobcategory" class="col-sm-2">备注</label>
											<div class="col-md-10 col-sm-10">
												<input type="text" class="form-control" name="bz"
													placeholder="请输入备注">
											</div>
										</div>
										<div class="form-group">
											<div class="col-sm-12">
												<button class="btn pull-right btn-primary btnQuery"
													type="button" id="btnSave">保存</button>
											</div>
										</div>
									</form>
									<form class="form-horizontal" id="userFormView"
										style="margin-top: 10px;" style="display:none;">
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
										<div class="form-group">
											<div class="col-sm-12">
												<button class="btn pull-right btn-primary btnQuery"
													type="button" id="btnEdit">编辑</button>
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
											<td align="right">
												<button class="btn btn-danger btnQuery" type="button"
													id="btnLrjs">录入结束</button>
												<button class="btn btn-primary btnQuery" type="button"
													id="btnLryp">录入样品</button>
											</td>
										</tr>
									</table>
									<table class="table table-bordered datatable table-hover"
										id="mainTable">
										<thead>
											<tr>
												<th class="text-center">样品编号</th>
												<th class="text-center">样品原有编号</th>
												<th class="text-center">样品性质</th>
												<th class="text-center">样品二维码</th>
												<th class="text-center">分析项目</th>
												<th class="text-center" style="width:50px;">操作</th>
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

	<div class="modal fade" id="modelEdithBatchDetailInfo">
		<div class="modal-dialog ">
			<div class="modal-content">
				<div class="modal-header">
					<button type="button" class="close" data-dismiss="modal">
						<span aria-hidden="true">×</span><span class="sr-only">关闭</span>
					</button>
					<h4 class="modal-title">编辑</h4>
				</div>
				<div class="modal-body">
					<form class="form-horizontal" id="batchDetailForm">
						<div class="form-group">
							<input type="hidden" name="wid" value=""> <input
								type="hidden" name="pcwid" value=""> <input
								type="hidden" name="dqbh" value=""> <label for="name"
								class="col-sm-2 required">样品编号</label>
							<div class="col-md-8 col-sm-8">
								<input type="text" readonly class="form-control" name="ypbh"
									placeholder="请输入样品编号" required>
							</div>
						</div>
						<div class="form-group">
							<label for="gh" class="col-sm-2 required">样品批次号</label>
							<div class="col-md-8 col-sm-8">
								<input type="text" class="form-control" name="ypph" readonly
									required>
							</div>
						</div>
						<div class="form-group">
							<label for="gh" class="col-sm-2 required">样品原有编号</label>
							<div class="col-md-8 col-sm-8">
								<input type="text" class="form-control" name="ypyybh"
									placeholder="请输入样品原有编号" required>
							</div>
						</div>
						<div class="form-group">
							<label for="gh" class="col-sm-2 required">样品性质</label>
							<div class="col-md-8 col-sm-8">
								<input type="text" class="form-control" name="ypxz"
									placeholder="请输入样品性质" required>
							</div>
						</div>
						<div class="form-group">
							<label for="gh" class="col-sm-2 required">样品二维码</label>
							<div class="col-md-8 col-sm-8">
								<input type="text" class="form-control" name="ypewm"
									placeholder="请输入样品二维码" required>
							</div>
						</div>
						<div class="form-group">
							<label for="department" class="col-sm-2 required">分析项目</label>
							<div class="col-md-8 col-sm-8">
								<select name="fxxm" multiple="multiple" class="form-control" required>
									<option value=''>--请选择--</option>
								</select>
							</div>
						</div>
					</form>

				</div>
				<div class="modal-footer">
					<button type="button" class="btn btn-default" data-dismiss="modal">关闭</button>
					<button type="button" class="btn btn-primary"
						id="btnSaveDetailInfo">保存</button>
				</div>
			</div>
		</div>
	</div>
	<script type="text/javascript">
		var wid = "${wid}";
		var modifyType = "${type}";
	</script>
	<script id="tblDetailInfoTpl" type="text/x-jquery-tmpl">
				<tr>
					<td class="text-center">{{= ypbh}}</td>
					<td class="text-left">{{= ypyybh}}</td>
					<td class="text-left">{{= ypxz}}</td>
					<td class="text-left">{{= ypewm}}</td>
					<td class="text-left">{{= fxxm_display}}</td>
					<td class="text-center">
						<div class="btn-group">
          					<button type="button" style="margin-left:4px;" class="btn btn-xs btn-danger" data-option="delete" data-key="{{= wid}}"><i class="icon icon-times"></i></button>
        				</div>
					</td>
				</tr>
			</script>
	<script type="text/javascript"
		src="${pageContext.request.contextPath}/static/pageJs/project/batchInfoDetail.js"></script>
</body>
</html>