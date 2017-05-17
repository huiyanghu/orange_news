<%@page language="java" contentType="text/html; charset=UTF-8"%>
<%@ include file="/common/taglibs.jsp"%>
<!DOCTYPE html>
<html lang="en">
<head>
<link rel="stylesheet" href="${ctx }/css/zTreeStyle/zTreeStyle.css"
	type="text/css">
<script type="text/javascript"
	src="${ctx }/js/jquery.ztree.all-3.5.min.js"></script>
<SCRIPT type="text/javascript">
		var setting = {
			check: {
				enable: true
			},
			data: {
				simpleData: {
					enable: true
				}
			},
			callback: {
				onCheck: onCheck
			}
		};

		var zNodes =[{id:0,pId:-1,name:"所有角色",open:true,checked:false}<coolook:tree type="1"/>];
		var code;		
		
		function onCheck(e, treeId, treeNode) {
			var zTree = $.fn.zTree.getZTreeObj("treeDemo"),
			nodes = zTree.getCheckedNodes(true);
			var treeid="";
			for (var i=0, l=nodes.length; i<l; i++) {
				if(i==0){
					treeid=nodes[i].id;
				}else{
					treeid=treeid+","+nodes[i].id;
				}
			}
			$("#treeid").attr("value",treeid);
		}	
		function setCheck() {
			//var type = $("#level").attr("checked")? "level":"all";
			//setting.check.radioType = type;
			//setting.check.chkboxType = { "Y" : "s", "N" : "" };
			$.fn.zTree.init($("#treeDemo"), setting, zNodes);
		}
		
		$(document).ready(function(){
			setCheck();			
			$("#level").bind("change", setCheck);
			$("#all").bind("change", setCheck);
		});
		
		
	</script>
</head>
<body>
	<div class="row">
		<div class="col-sm-12">
			<h1 class="page-header">角色功能管理</h1>
		</div>
	</div>
	<div class="row">
		<div class="col-sm-12">
			<div class="panel panel-default">
				<div class="panel-heading">修改[${sysrole.rolename }]的权限，请选择其中节点：</div>
				<div class="panel-body">
					<div class="row">

						<form class="form-horizontal" name="addroleform" id="addroleform"
							action="${ctx }/role/menuselectaction">
							<input name="roleid" id="roleid" type="hidden"
								value="${sysrole.roleid }" />
							<div class="form-group">
								<label for="textarea" class="control-label col-sm-2">功能树：</label>
								<div class="controls col-sm-8">
									<ul id="treeDemo" class="ztree"></ul>
								</div>
							</div>

							<div class="form-actions">
								<div class="col-sm-1"></div>
								<div class="col-sm-8">

									<a href="${ctx }/role/list" class="btn btn-info"><span
										class="fa fa-arrow-left fa-fw"></span> 返回</a>
									<button class="btn btn-primary" type="submit">
										<span class="fa fa-floppy-o fa-fw"></span> 更新权限
									</button>
								</div>
							</div>
							<input name="treeid" id="treeid" type="hidden" value="" />
						</form>
					</div>


				</div>
			</div>
		</div>
	</div>
</body>
</html>
