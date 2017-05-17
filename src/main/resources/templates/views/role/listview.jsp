<%@page language="java" contentType="text/html; charset=UTF-8"%>
<%@ include file="/common/taglibs.jsp"%>
<!DOCTYPE html>
<html lang="en">
<head>
<link rel="stylesheet" href="${ctx }/css/zTreeStyle/zTreeStyle.css" type="text/css">
<script type="text/javascript" src="${ctx }/js/jquery.ztree.all-3.5.min.js"></script>
</head>
<body>
			<div class="row">
				<div class="col-sm-12">
					<h1 class="page-header">角色管理</h1>
				</div>
			</div>
			<div class="row">
				<div class="col-sm-12">
					<div class="panel panel-default">
						<div class="panel-heading">请选择其中一个角色节点：</div>
						<div class="panel-body">
							<div class="row">

								<form name="addroleform" id="addroleform"
									class="form-horizontal">
									<div class="form-group">
										<label for="textarea" class="control-label col-sm-2">权限树：</label>
										<div class="controls col-sm-8">
											<ul id="treeDemo" class="ztree"></ul>
										</div>
									</div>
									<input name="roleid" id="roleid" type="hidden" value="" />
									<div class="form-group">
										<label for="textarea" class="control-label col-sm-2">您选择角色为：</label>
										<div class="controls col-sm-8">
											<input class="input-xlarge disabled" id="rolename"
												type="text" placeholder="请选择角色…" disabled required
												required-message="请选择角色">
										</div>
									</div>
									<div class="form-actions">
										<div class="col-sm-1"></div>
										<div class="col-sm-8">
											<a href="#" id="addmenu" class="btn btn-primary">添加角色</a>
											<a href="#" id="updatamenu" class="btn btn-info">修改角色</a>
											<a href="#" id="deletmenu" class="btn btn-danger">删除角色</a>
											<a href="#" id="selectmenu" class="btn btn-success">选择权限</a>
										</div>
									</div>
								</form>
							</div>


						</div>
					</div>
				</div>
			</div>
<SCRIPT type="text/javascript">
	var setting = {
		check: {
			enable: true,
			chkStyle: "radio",
			radioType: "level"
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
	var zNodes =[{id:"${myparentid}",pId:-1,name:"所有角色",open:true,nocheck:true}<coolook:tree type="1"/>];
	var code;		
	function onCheck(e, treeId, treeNode) {
		$("#roleid").attr("value",treeNode.id );
		$("#rolename").attr("value",treeNode.name );
	}	
	function setCheck() {
		var type = $("#level").attr("checked")? "level":"all";
		setting.check.radioType = type;
		$.fn.zTree.init($("#treeDemo"), setting, zNodes);
	}
	$(document).ready(function(){
		setCheck();			
		$("#level").bind("change", setCheck);
		$("#all").bind("change", setCheck);
	});
	$(document).ready(function(){
		$("#addmenu").on('click', function(e){
			var roleid = $("#roleid").val();
			if(roleid==null||roleid==""){
				roleid = 0;
			}
			location.href="${ctx}/role/add?type=add&id=0&pid="+roleid;
		});
		$("#updatamenu").on('click', function(e){
			var roleid = $("#roleid").val();
			if(roleid==null||roleid==""){
				roleid = 0;
			}
			location.href="${ctx}/role/add?type=update&id="+roleid+"&pid=0";
		});
		$("#deletmenu").on('click', function(e){
		  var roleid = $("#roleid").val();
		  var paras = {id: roleid};
			$.get('${ctx}/role/delete', paras, function(res){
			//	alert("res:"+res);
			//	alert("JSON.stringify:"+JSON.stringify(res));
           //	 var resjson = jQuery.parseJSON(res);
				//alert("resjson"+resjson);
                if(res.status == 0){
               	 	//window.location.href="${ctx}/menu/list";
               	 	window.history.go(0);
               	 
                }else{
                	alert("服务端异常");
                }
              });
		});
		$("#selectmenu").on('click', function(e){
			  var roleid = $("#roleid").val();
			location.href="${ctx}/role/menuselect?roleid="+roleid;
		});
	});
	</script>
</body>
</html>
