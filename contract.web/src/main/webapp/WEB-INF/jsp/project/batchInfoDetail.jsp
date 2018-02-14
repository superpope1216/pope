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
					<li><a href="${pageContext.request.contextPath}/batch/index?open=&select=130">批次管理</a></li>
					<li class="active">样品批次详情</li>
				</ol>
			</div>
			<div class="wrapper">
				<div class="panel">
					<div class="panel-body">
						<table style="width: 100%; margin-top: 5px;">
							<tr>
								<td class="td-left-bold">
									<h3>
										<span class="span-left-border">批次详情</span>
									</h3>
								</td>
								
								<td align="right">
									<button class="btn pull-right btn-primary btnQuery"
										type="button" id="btnEdit">编辑</button>
									<button class="btn pull-right btn-primary btnQuery"
										type="button" id="btnSave">保存</button>
									</div>
								</td>
							</tr>
						</table>
						<form class="form-horizontal" id="userForm"
							style="margin-top: 10px;" style="display:none;">
							<table style="width: 100%" class="mainTable">
								<tr>
									<td class="tbl-text"><input type="hidden" name="wid"
										value=""> <input type="hidden" name="dqbh" value="">
										类别<span class="myrequrire">*</span></td>
									<td class="tbl-four-edit-value"><select name="pclb"
										class="form-control" required >
											<option value=''>--请选择--</option>
									</select></td>
									<td class="tbl-text">二级分类<span class="myrequrire">*</span>
									</td>
									<td class="tbl-four-edit-value"><input type="text" class="form-control" name="ejfl"
										placeholder="请输入二级分类">
									</td>
									<td class="tbl-text">批次名称<span class="myrequrire">*</span>
									</td>
									<td class="tbl-four-edit-value"><input type="text" class="form-control" name="pcmc"
										placeholder="请输入批次名称" required>
									</td>
									<td class="tbl-text">样品批号<span class="myrequrire">*</span>
									</td>
									<td class="tbl-four-edit-value"><input type="text" readonly name="ypph"
										placeholder="请输入邮样品批号" required>
									</td>
								</tr>
								
								<tr>
									<td class="tbl-text">
										数量<span class="myrequrire">*</span></td>
									<td class="tbl-four-edit-value"><input type="text" class="form-control" name="sl"
										placeholder="请输入数量" required>
										</td>
									<td class="tbl-text">数量单位<span class="myrequrire">*</span>
									</td>
									<td class="tbl-four-edit-value"><select name="sldw" class="form-control" required>
										<option value=''>--请选择--</option>
									</select>
									</td>
									<td class="tbl-text">品牌
									</td>
									<td class="tbl-four-edit-value"><select name="pp" class="form-control">
										<option value=''>--请选择--</option>
									</select>
									</td>
									<td class="tbl-text">存放地<span class="myrequrire">*</span>
									</td>
									<td class="tbl-four-edit-value"><input type="text" class="form-control" name="cfd"
										placeholder="请输入存放地" required>
									</td>
								</tr>
								<tr>
									<!-- <td class="tbl-text">
										单价<span class="myrequrire">*</span></td>
									<td class="tbl-four-edit-value"><input type="text" class="form-control" name="dj"
										placeholder="请输入单价" required>
										</td>
									<td class="tbl-text">货币单位<span class="myrequrire">*</span>
									</td>
									<td class="tbl-four-edit-value"><select name="hbdw" class="form-control" required>
										<option value=''>--请选择--</option>
									</select>
									</td>
									 -->
									<td class="tbl-text">控制时间点<span class="myrequrire">*</span>
									</td>
									<td class="tbl-four-edit-value"><input type="text" class="form-control" name="kzsjd"
										placeholder="请输入控制时间点" onClick="WdatePicker()" required>
									</td>
									<td class="tbl-text">送样时间<span class="myrequrire">*</span>
									</td>
									<td class="tbl-four-edit-value"><input type="text" class="form-control" name="sysj"
										placeholder="请输入送样时间" onClick="WdatePicker()" required>
									</td>
									<td class="tbl-text">
										送样人<span class="myrequrire">*</span></td>
									<td class="tbl-four-edit-value"><input type="text" class="form-control" name="syr"
										placeholder="请输入送样人" required>
										</td>
									<td class="tbl-text">送样单位<span class="myrequrire">*</span>
									</td>
									<td class="tbl-four-edit-value"><select name="sydw" class="form-control" required>
										<option value=''>--请选择--</option>
									</select>
									</td>
								</tr>
								
								<tr>
									
									<td class="tbl-text">送样项目负责人<span class="myrequrire">*</span>
									</td>
									<td class="tbl-four-edit-value" colspan="3"><input type="text" class="form-control" name="syxmfzr"
										placeholder="请输入送样项目负责人" required>
									</td>
									<td class="tbl-text">
										分析项目<span class="myrequrire">*</span></td>
									<td class="tbl-four-edit-value" colspan="3"><select id="fxxm" name="fxxm" class="form-control"
										multiple="multiple" required>
										<option value=''>--请选择--</option>
									</select>
										</td>
								</tr>
								
								<tr>
									
									<td class="tbl-text">备注
									</td>
									<td class="tbl-four-edit-value" colspan="7"><input type="text" class="form-control" name="bz"
										placeholder="请输入备注">
									</td>
								</tr>
							</table>
						</form>
						<form class="form-horizontal" id="userFormView"
							style="margin-top: 10px;" style="display:none;">
							<table style="width: 100%" class="mainTable">
								<tr>
									<td class="tbl-text">类别</td>
									<td class="tbl-value">
										<p class="form-control-static" name="pclb_display"></p>
									</td>
									<td class="tbl-text">二级分类</td>
									<td class="tbl-value">
										<p class="form-control-static" name="ejfl"></p>
									</td>
									<td class="tbl-text">批次名称</td>
									<td class="tbl-value">
										<p class="form-control-static" name="pcmc"></p>
									</td>
									<td class="tbl-text">样品批号</td>
									<td class="tbl-value">
										<p class="form-control-static" name="ypph"></p>
									</td>
								</tr>
								<tr>
									<td class="tbl-text">数量</td>
									<td class="tbl-value">
										<p class="form-control-static" name="sl"></p>
									</td>
									<td class="tbl-text">品牌</td>
									<td class="tbl-value">
										<p class="form-control-static" name="pp_display"></p>
									</td>
									<td class="tbl-text">数量单位</td>
									<td class="tbl-value">
										<p class="form-control-static" name="sldw_display"></p>
									</td>
									<td class="tbl-text">存放地</td>
									<td class="tbl-value">
										<p class="form-control-static" name="cfd"></p>
									</td>
								</tr>
								<tr>
									<!-- <td class="tbl-text">单价</td>
									<td class="tbl-value">
										<p class="form-control-static" name="dj"></p>
									</td>
									<td class="tbl-text">货币单位</td>
									<td class="tbl-value"><p class="form-control-static"
											name="hbdw_display"></p></td> -->
									<td class="tbl-text">控制时间点</td>
									<td class="tbl-value"><p class="form-control-static"
											name="kzsjd"></p></td>
									<td class="tbl-text">送样时间</td>
									<td class="tbl-value"><p class="form-control-static"
											name="sysj"></p></td>
											<td class="tbl-text">送样人</td>
									<td class="tbl-value">
										<p class="form-control-static" name="syr"></p>
									<td class="tbl-text">送样单位</td>
									<td class="tbl-value"><p class="form-control-static"
											name="sydw_display"></p></td>
								</tr>
								<tr>
									
									<td class="tbl-text">送样项目负责人</td>
									<td class="tbl-value"><p class="form-control-static"
											name="syxmfzr"></p></td>
									<td class="tbl-text">审核时间</td>
									<td class="tbl-value"><p class="form-control-static"
											name="shsj"></p></td>
											<td class="tbl-text">样品状态监控</td>
									<td class="tbl-value" >
										<p class="form-control-static" name="pczt_display"></p>
									</td>
									<td class="tbl-text">合同号</td>
									<td class="tbl-value"><p
											class="form-control-static" name="hth"></p></td>
								</tr>
								<tr>
									<td class="tbl-text">分析项目</td>
									<td class="tbl-value" colSpan="3">
										<p class="form-control-static" name="fxxm_display"></p>
									</td>
									<td class="tbl-text">备注</td>
									<td class="tbl-value" colSpan="3"><p
											class="form-control-static" name="bz"></p></td>
								</tr>
							</table>
						</form>
					</div>
				</div>

			</div>
			<div class="wrapper">
				<div class="panel">
					<div class="panel-body">
						<table style="width: 100%; margin-top: 5px;">
							<tr>
								<td class="td-left-bold">
									<h3>
										<span class="span-left-border">批次内样品详情</span>
									</h3>
								</td>
								<td align="right">
									<button class="btn btn-danger btnQuery" type="button"
										id="btnLrjs">录入结束</button>
									<button class="btn btn-primary btnQuery" type="button"
										id="btnLryp">录入样品</button>
								</td>
							</tr>
						</table>
						<table class="mainTable table-hover" id="mainTable">
							<thead>
								<tr>
									<td class="text-center">样品编号</td>
									<td class="text-center">样品原有编号</td>
									<td class="text-center">样品性质</td>
									<td class="text-center">样品二维码</td>
									<td class="text-center">分析项目</td>
									<td class="text-center" style="width: 50px;">操作</td>
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
								<select name="fxxm" multiple="multiple" class="form-control"
									required>
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