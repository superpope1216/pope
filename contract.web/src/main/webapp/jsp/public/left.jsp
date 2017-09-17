<%@page import="com.pope.contract.code.MenuLevel"%>
<%@page import="com.pope.contract.entity.system.Permission"%>
<%@page import="com.pope.contract.util.CommonUtil"%>
<%@page import="com.pope.contract.entity.system.Role"%>
<%@page import="java.util.List"%>
<%@page import="com.pope.contract.util.ConstantUtil"%>
<%@page import="com.pope.contract.dto.LoginInfo"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%
	String _open = request.getParameter("open");
	String _select = request.getParameter("select");
	if (_open == null) {
		_open = "";
	}
	if (_select == null) {
		_select = "";
	}
%>
<script type="text/javascript">
		var $open="<%=_open%>";
		var $select="<%=_select%>";
</script>
<script type="text/javascript"
	src="${pageContext.request.contextPath}/static/pageJs/left.js"></script>
<nav class="menu sidebar" data-ride="menu"
	style="margin-bottom: 20px; width: 180px">
	<div class="col-sm-12 sidebar-image" style="margin-bottom: 20px;">
		<div class="col-sm-5">
			<a href="${pageContext.request.contextPath}/personUserInfo/index">
				<img src="${pageContext.request.contextPath}/static/img/header.jpg"
				class="img-circle" alt="圆形图片" id="btnPersonUserInfo">
			</a>
		</div>
		<%
			LoginInfo loginInfo = (LoginInfo) session.getAttribute(ConstantUtil.USER_SESSION_NAME);
			Role currentRole = (Role) session.getAttribute(ConstantUtil.USER_CURRENT_ROLE);
			Role role = currentRole;
		%>
		<div class="col-sm-7 clolor-white"><%=loginInfo.getName()%></div>
	</div>
	<ul id="treeMenu" class="tree tree-menu" data-ride="tree"
		style="margin-bottom: 30px;">
		<%
			List<Permission> permissions = role.getPermissions();
			boolean findSecond = false, findThree = false;

			if (CommonUtil.isNotEmptyList(permissions)) {
				StringBuilder secondMenu = new StringBuilder();
				StringBuilder threeMenu = new StringBuilder();
				String secondUrl = "", secondName = "";
				int i = 0;

				for (Permission per : permissions) {
					String select2 = "";
					String icon = per.getIcon();
					if (icon != null && !"".equals(icon)) {

					} else {
						icon = "icon-tasks";
					}
					i++;
					if (i == 1 && (request.getParameter("open") == null || "".equals(request.getParameter("open")))
							&& (request.getParameter("select") == null || "".equals(request.getParameter("select")))) {
						select2 = "active";
					}
					if (CommonUtil.isNotEmptyList(per.getList())) {
		%>
		<li class="<%=select2%>"><a href="#" dataflag="1"
			datawid="<%=per.getWid()%>" style="color: white;"><i
				class="icon <%=icon%>"></i><%=per.getName()%></a>
			<ul>
				<%
					for (Permission per2 : per.getList()) {
				%>
				<li><a dataflag="2" datawid="<%=per2.getWid()%>"
					href='javascript:void(0);' dataurl="<%=per2.getUrl()%>"><%=per2.getName()%></a></li>
				<%
					}
				%>
			</ul></li>
		<%
			} else {
		%>
		<li><a dataflag="1" datawid="<%=per.getWid()%>" 
			dataurl="<%=per.getUrl()%>" href="javascript:void(0);"
			style="color: white;"><i class="icon <%=icon%>"></i><%=per.getName()%></a></li>
		<%
			}
				}
			}
		%>
		<li><a dataflag="1" datawid="-100" 
			dataurl="/myMessages/index" href="javascript:void(0);"
			style="color: white;"><i class="icon icon-comment"></i>您有新的消息：<span id="aMessage" class="label label-danger">0</span></a></li>
	</ul>
</nav>
