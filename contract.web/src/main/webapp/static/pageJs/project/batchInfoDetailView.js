/**
 * 
 */
$(document).ready(
		function() {
			queryDetail();
			
			queryDetailList();
			function queryDetailList(pageId){
				if(pageId==undefined){
					pageId=0;
				}
				doGet(basePath + "/batch/detail_list", "startPage="+pageId+"&pcwid=" + wid, function(data) {
					if(data && data.data){
						$('#tblDetailInfoTpl').tmpl(data.data.data).appendTo('#tblDetailInfo'); 
					}
					pageHelper("#pageInfo",data.data.page-1,data.data.total,function(pageId){
						queryDetailList(pageId);
					});
				});
				
			}
			function queryDetail() {
				doGet(basePath + "/batch/detailView", "wid=" + wid, function(data) {
					if (data && data.data) {
						var _details = data.data;
						doGetSelect2("T_CONTRACT_SJZD_PCLB", "#userForm [name='pclb']", _details.pclb);
						$("#userForm [name='pclb_display']").html(_details.pclb_display);
						$("#userForm [name='ejfl']").html(_details.ejfl);
						$("#userForm [name='pcmc']").html(_details.pcmc);
						$("#userForm [name='ypph']").html(_details.ypph);
						$("#userForm [name='sl']").html(_details.sl);
						$("#userForm [name='pp_display']").html(_details.pp);
						$("#userForm [name='sldw_display']").html(_details.sldw);
						$("#userForm [name='cfd']").html(_details.cfd);
						$("#userForm [name='dj']").html(_details.dj);
						$("#userForm [name='hbdw_display']").html(_details.hbdw);
						$("#userForm [name='fxxm_display']").html(_details.fxxm_display);
						
						$("#userForm [name='kzsjd']").html(_details.kzsjd);
						$("#userForm [name='sysj']").html(_details.sysj);
						$("#userForm [name='gys']").html(_details.gys);
						$("#userForm [name='syr']").html(_details.syr);
						$("#userForm [name='sydw_display']").html(_details.sydw_display);
						$("#userForm [name='syxmfzr']").html(_details.syxmfzr);
						$("#userForm [name='shsj']").html(_details.shsj);
						$("#userForm [name='pczt_display']").html(_details.pczt_display);
						$("#userForm [name='hth']").html(_details.hth);
						$("#userForm [name='bz']").html(_details.bz);
					}
				});
			}

		})