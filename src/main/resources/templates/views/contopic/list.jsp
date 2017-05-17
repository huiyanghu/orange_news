<%@page language="java" contentType="text/html; charset=UTF-8"%>
<%@ include file="/common/taglibs.jsp"%>
<!DOCTYPE html>
<html lang="zh-Hans">
<head>
<title>coolook</title>
<link rel="stylesheet" href="${ctx }/css/zTreeStyle/zTreeStyle.css" type="text/css">
<script type="text/javascript" src="${ctx }/js/jquery.ztree.all-3.5.min.js"></script>
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
				beforeExpand: beforeExpand,
				onExpand: onExpand,
				onCheck: onCheck
			}
		};
		function createNodes(maxNodesNumInLevel, maxLevel, curLevel, curPId) {
			if (maxNodesNumInLevel<5) {
				maxNodesNumInLevel = 5;
			}
			var nodes = [], num = 0;
			while(num<3) {
				num = parseInt(Math.random()*1024)%maxNodesNumInLevel+1;
			}
			for (var i=0; i<num; i++) {
				var id = curPId ? curPId + "-" + i : "" + i, isParent = (parseInt(Math.random()*9999)%3!=0),
				node = {id: id, pId : curPId, name : "N" + id};
				nodes.push(node);
				if (isParent && curLevel<maxLevel) {
					nodes = nodes.concat(createNodes(maxNodesNumInLevel, maxLevel, curLevel+1, id));
				}
			}
            return nodes;
		}
		var curExpandNode = null;
		function beforeExpand(treeId, treeNode) {
			var pNode = curExpandNode ? curExpandNode.getParentNode():null;
			var treeNodeP = treeNode.parentTId ? treeNode.getParentNode():null;
			var zTree = $.fn.zTree.getZTreeObj("treeDemo");
			for(var i=0, l=!treeNodeP ? 0:treeNodeP.children.length; i<l; i++ ) {
				if (treeNode !== treeNodeP.children[i]) {
					zTree.expandNode(treeNodeP.children[i], false);
				}
			}
			while (pNode) {
				if (pNode === treeNode) {
					break;
				}
				pNode = pNode.getParentNode();
			}
			if (!pNode) {
				singlePath(treeNode);
			}

		}
		function singlePath(newNode) {
			if (newNode === curExpandNode) return;

            var zTree = $.fn.zTree.getZTreeObj("treeDemo"),
                    rootNodes, tmpRoot, tmpTId, i, j, n;

            if (!curExpandNode) {
                tmpRoot = newNode;
                while (tmpRoot) {
                    tmpTId = tmpRoot.tId;
                    tmpRoot = tmpRoot.getParentNode();
                }
                rootNodes = zTree.getNodes();
                for (i=0, j=rootNodes.length; i<j; i++) {
                    n = rootNodes[i];
                    if (n.tId != tmpTId) {
                        zTree.expandNode(n, false);
                    }
                }
            } else if (curExpandNode && curExpandNode.open) {
				if (newNode.parentTId === curExpandNode.parentTId) {
					zTree.expandNode(curExpandNode, false);
				} else {
					var newParents = [];
					while (newNode) {
						newNode = newNode.getParentNode();
						if (newNode === curExpandNode) {
							newParents = null;
							break;
						} else if (newNode) {
							newParents.push(newNode);
						}
					}
					if (newParents!=null) {
						var oldNode = curExpandNode;
						var oldParents = [];
						while (oldNode) {
							oldNode = oldNode.getParentNode();
							if (oldNode) {
								oldParents.push(oldNode);
							}
						}
						if (newParents.length>0) {
							zTree.expandNode(oldParents[Math.abs(oldParents.length-newParents.length)-1], false);
						} else {
							zTree.expandNode(oldParents[oldParents.length-1], false);
						}
					}
				}
			}
			curExpandNode = newNode;
		}
		function onExpand(event, treeId, treeNode) {
			curExpandNode = treeNode;
		}
		var zNodes =[{id:0,pId:-1,name:"所有分类",open:true}<coolook:tree type="1"/>];
		var code;		
		
		function onCheck(e, treeId, treeNode) {
			$("#tid").attr("value",treeNode.id );
			$("#topicname").attr("value",treeNode.name );
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
			var menuid = $("#tid").val();
			if(menuid==null||menuid==""){
				menuid = 0;
			}
			location.href="${ctx}/contopic/add?type=add&id=0&pid="+menuid;
		});
		$("#updatamenu").on('click', function(e){
			var menuid = $("#tid").val();
			if(menuid==null||menuid==""){
				menuid = 0;
			}
			location.href="${ctx}/contopic/add?type=update&id="+menuid+"&pid=0";
		});
		$("#deletmenu").on('click', function(e){
		  var menuid = $("#tid").val();
		  if(menuid>0){
				location.href="${ctx}/contopic/delete?id="+menuid;
			}
		});
		
		$("#mstags").on('click', function(e){
			  var menuid = $("#tid").val();
			  if(menuid>0){
					location.href="${ctx}/contopic/mstags?tpid="+menuid;
				}
			});
		
		$("#addtags").on('click', function(e){
			  var menuid = $("#tid").val();
			  if(menuid>0){
					location.href="${ctx}/contopic/addtags?tpid="+menuid;
				}
			});
	});
	</script>
</head>
<body>
	<div class="row">
		<div class="col-sm-12">
			<h1 class="page-header">分类列表</h1>
		</div>
	</div>
	<div class="row">
		<div class="col-sm-12">
			<div class="panel panel-default">
				<div class="panel-heading">您需要选择节点才能添加</div>
				<div class="panel-body">
					<div class="row">
						<form name="addroleform" class="form-horizontal" id="addroleform">
							<div class="form-group">
								<label for="textarea" class="control-label col-sm-2">分类树：</label>
								<div class="controls col-sm-8">
									<ul id="treeDemo" class="ztree"></ul>
								</div>
							</div>
							<input name="id" id="tid" type="hidden" value="" />
							<div class="form-group">
								<label for="textarea" class="control-label col-sm-2">操作节点为：</label>
								<div class="controls col-sm-8">
									<input class="input-xlarge disabled" id="topicname" type="text"
										placeholder="请选择功能…" disabled required
										required-message="请选择功能节点">
								</div>
							</div>

							<div class="form-actions">
								<div class="col-sm-1"></div>
								<div class="col-sm-8">
								    <a href="#" id="mstags" class="btn btn-primary">标签管理</a>
									<a href="#" id="addtags" class="btn btn-primary">添加标签</a>
									<br><br>
									
									<a href="#" id="addmenu" class="btn btn-primary">添加分类</a>
									<a href="#" id="updatamenu" class="btn btn-info">修改分类</a>
									<a href="#" id="deletmenu" class="btn btn-danger">删除分类</a>

								</div>
							</div>
						</form>
					</div>


				</div>
			</div>
			</div>
			</div>
</body>
</html>
