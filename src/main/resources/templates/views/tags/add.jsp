<%@page language="java" contentType="text/html; charset=UTF-8"%>
<%@ include file="/common/taglibs.jsp"%>
<!DOCTYPE html>
<html lang="en">
<head>
<link rel="stylesheet" href="${ctx }/css/jquery.fileupload.css">
<link rel="stylesheet" href="${ctx }/css/zTreeStyle/zTreeStyle.css" type="text/css">
<script type="text/javascript" src="${ctx }/js/jquery.ztree.all-3.5.min.js"></script>
</head>
<body>
	<div class="row">
		<div class="col-sm-12">
			<h1 class="page-header">添加标签</h1>
		</div>
	</div>
	<div class="row">
		<div class="col-sm-12">
			<div class="panel panel-default">
				<div class="panel-heading">添加标签</div>
				<div class="panel-body">
					<div class="row">
						<form id="addform" class="form-horizontal" action="${ctx }/contags/saveorupdate" method="post">
							<input name="id" type="hidden" value="${conTags.id }" />
							<input name="frequency" type="hidden" value="${conTags.frequency }" />
							<input name="rank" type="hidden" value="${conTags.rank }" />
							<div class="row col-sm-6">
							<div class="form-group">
								<label for="channelname" class="control-label col-sm-2">标签名称：</label>
								<div class="controls col-sm-8">
									<input type="text" name="tagname" id="tagname"
										class="form-control" value="${conTags.tagname }" required
										required-message="请输入来标签名称" />
										  <c:if test="${conTags.id eq -1}">
										     批量添加标签:请用","去分割如(tag1,tag2,tag3)
										  </c:if>
								</div>
							</div>
							
							<c:choose>
							  <c:when test="${conTags.id eq -1 || conTags.id eq 0}">
							       <div class="form-group">
									<label for="mobile" class="control-label col-sm-2">国家：</label>
									<div class="controls col-sm-8">
										<select id="countrycode" name="countrycode" class="form-control">
												<option value="-1"
													<c:if test="${conTags.countrycode=='-1'}">selected</c:if>>请选择</option>
												<c:forEach var="item" items="${countrys}">
												<option value="${item.code}" 
													<c:if test="${sessionScope.sessioncountrycode == item.code}">selected</c:if>>${item.cnname}</option>
												</c:forEach>
											</select>
									</div>
								</div>
								
									<div class="form-group">
									<label for="mobile" class="control-label col-sm-2">语言：</label>
									<div class="controls col-sm-8">
										<select id="langid" name="langid" class="form-control">
												<option value="-1"
													<c:if test="${conTags.langid=='-1'}">selected</c:if>>请选择</option>
												<c:forEach var="item" items="${langs}">
												<option value="${item.id}"
													<c:if test="${sessionScope.sessionlangid == item.id}">selected</c:if>>${item.cnname}</option>
												</c:forEach>
											</select>
									</div>
								</div>
							  </c:when>
							  <c:otherwise>
								   <div class="form-group">
									<label for="mobile" class="control-label col-sm-2">国家：</label>
									<div class="controls col-sm-8">
										<select id="countrycode" name="countrycode" class="form-control">
												<option value="-1"
													<c:if test="${conTags.countrycode=='-1'}">selected</c:if>>请选择</option>
												<c:forEach var="item" items="${countrys}">
												<option value="${item.code}"
													<c:if test="${conTags.countrycode==item.code}">selected</c:if>>${item.cnname}</option>
												</c:forEach>
											</select>
									</div>
								</div>
								
									<div class="form-group">
									<label for="mobile" class="control-label col-sm-2">语言：</label>
									<div class="controls col-sm-8">
										<select id="langid" name="langid" class="form-control">
												<option value="-1"
													<c:if test="${conTags.langid=='-1'}">selected</c:if>>请选择</option>
												<c:forEach var="item" items="${langs}">
												<option value="${item.id}"
													<c:if test="${conTags.langid==item.id}">selected</c:if>>${item.cnname}</option>
												</c:forEach>
											</select>
									</div>
								</div>
							  </c:otherwise>
							</c:choose>
							
							
							<div class="form-group">
								<label for="email" class="control-label col-sm-2">类型：</label>
								<div class="controls col-sm-8">
									<select id="tagtype" name="tagtype" class="form-control">
									    <option value="0" <c:if test="${conTags.tagtype==0}">selected</c:if>>通用标签</option>
									     <option value="1" <c:if test="${conTags.tagtype==1}">selected</c:if>>特殊标签</option>
									</select>
								</div>
							</div>
							
								<div class="form-group">
								<label for="email" class="control-label col-sm-2">状态：</label>
								<div class="controls col-sm-8">
									<select id="status" name="status" class="form-control">
									    <option value="0" <c:if test="${conTags.status==0}">selected</c:if>>激活</option>
									     <option value="1" <c:if test="${conTags.status==1}">selected</c:if>>未审核</option>
									     <option value="-1" <c:if test="${conTags.status==-1}">selected</c:if>>禁用</option>
									</select>
								</div>
							</div>
							
							
							<div class="form-group">
								<label for="textarea" class="control-label col-sm-2">分类树：</label>
								<div class="controls col-sm-8">
									<ul id="treeDemo" class="ztree"></ul>
								</div>
							</div>
							
							<input name="tid" id="tid" type="hidden" value="${tid }" />
							
								</div>
								
								<c:if test="${conTags.id ne -1}">
								    <div class="row col-sm-6">
								<div class="form-group">
								<label for="input01" class="control-label col-sm-2">标签图片：</label>
								<div class="controls col-sm-8">
										<span class="btn btn-success fileinput-button">
									  					<span>标签图片</span> 
	       										 		<input id="fileupload" type="file" name="file" multiple>
	        							</span>
									<input type="hidden" name="tagicon" id="tagicon" value="${conTags.tagicon }" />
								</div>
							</div>
							<div class="form-group">
								<label class="control-label col-sm-2">标签图片：</label>
								<div class="controls col-sm-2">
									<c:choose>
        									<c:when test="${conTags.tagicon != null&&conTags.tagicon != '' }">
        										<img src="${upyunhttp }${conTags.tagicon}" id="titlepicimg" class="thumbnail" heiht="140">
        									</c:when>
        									<c:otherwise>
												<img src="data:image/svg+xml;base64,PD94bWwgdmVyc2lvbj0iMS4wIiBlbmNvZGluZz0iVVRGLTgiIHN0YW5kYWxvbmU9InllcyI/PjxzdmcgeG1sbnM9Imh0dHA6Ly93d3cudzMub3JnLzIwMDAvc3ZnIiB3aWR0aD0iMTQwIiBoZWlnaHQ9IjE0MCIgdmlld0JveD0iMCAwIDE0MCAxNDAiIHByZXNlcnZlQXNwZWN0UmF0aW89Im5vbmUiPjxkZWZzLz48cmVjdCB3aWR0aD0iMTQwIiBoZWlnaHQ9IjE0MCIgZmlsbD0iI0VFRUVFRSIvPjxnPjx0ZXh0IHg9IjQ1LjUiIHk9IjcwIiBzdHlsZT0iZmlsbDojQUFBQUFBO2ZvbnQtd2VpZ2h0OmJvbGQ7Zm9udC1mYW1pbHk6QXJpYWwsIEhlbHZldGljYSwgT3BlbiBTYW5zLCBzYW5zLXNlcmlmLCBtb25vc3BhY2U7Zm9udC1zaXplOjEwcHQ7ZG9taW5hbnQtYmFzZWxpbmU6Y2VudHJhbCI+MTQweDE0MDwvdGV4dD48L2c+PC9zdmc+" id="titlepicimg" class="thumbnail">
        									</c:otherwise>
        								</c:choose>
			    						<div id="progress" class="progress">
									        <div class="progress-bar progress-bar-success"></div>
									 	</div>
								</div>
							</div>
							</div>
								</c:if>
									
							
								
							<div class="form-actions">
								<div class="col-sm-1"></div>
								<div class="col-sm-12 text-center">
									<a href="${ctx }/contags/list" class="btn btn-info"><span
										class="fa fa-arrow-left fa-fw"></span> 返回</a> &nbsp;&nbsp;
									<button class="btn btn-primary" type="submit" onclick="return save();">
										<span class="fa fa-floppy-o fa-fw"></span>
										<c:if test="${conTags.id>0}">修改标签</c:if><c:if test="${conTags.id==0}">添加标签</c:if>
									</button>
								</div>
							</div>
						</form>
					</div>
				</div>
			</div>
		</div>
	</div>
	
	<script type="text/javascript" src="${ctx }/js/jquery.ui.widget.js"></script>
	<script type="text/javascript" src="${ctx }/js/jquery.fileupload.js"></script>
	<script type="text/javascript">
		$(function () {
		    $('#fileupload').fileupload({
		        url: '${ctx}/upload/upyun',
		        dataType: 'json',
		        done: function (e, data) {
		        	$("#titlepicimg").attr("src",""+data.result.imgsrc+"");
		        	$("#tagicon").attr("value",data.result.imgpath);
		        },
		        progressall: function (e, data) {
		            var progress = parseInt(data.loaded / data.total * 100, 10);
		            $('#progress .progress-bar').css('width',progress + '%' );
		        }
		    }).prop('disabled', !$.support.fileInput)
		        .parent().addClass($.support.fileInput ? undefined : 'disabled');
		});
		
		function save(){
			if($("#countrycode").val()==-1){
				alert("请选择国家");
			   return false;
			}else if($("#langid").val()==-1){
				alert("请选择语言");
				   return false;
			}
		}
		
	</script>
	
	
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

		
		
		var zNodes =[{id:0,pId:-1,name:"所有分类",open:true}<coolook:tree type="1"/>];
		var code;		
		function onCheck(e, treeId, treeNode) {
		//	$("#tid").attr("value",treeNode.id );
		//	$("#topicname").attr("value",treeNode.name );
			
			var zTree = $.fn.zTree.getZTreeObj("treeDemo"),
			nodes = zTree.getCheckedNodes(true);
		//	nodes =zTree.getChangeCheckedNodes();
			var treeid="";
			for (var i=0, l=nodes.length; i<l; i++) {
				if(i==0){
					treeid=nodes[i].id;
				}else{
					treeid=treeid+","+nodes[i].id;
				}
			}
			$("#tid").attr("value",treeid);
		}	
		function setCheck() {
			var type = $("#level").attr("checked")? "level":"all";
			setting.check.radioType = type;
			$.fn.zTree.init($("#treeDemo"), setting, zNodes);
	/* 		var zTree = $.fn.zTree.getZTreeObj("treeDemo");
			zTree.checkNode(3,true,true,true); */
		}
		
		$(document).ready(function(){
			setCheck();			
			$("#level").bind("change", setCheck);
			$("#all").bind("change", setCheck);
			
			$(".level0").children("span").each(function(i,n){
			     var obj = $(n);
			     if(obj.attr('id').indexOf('check')!=-1){
				     	obj.remove();
				     }
			    });
			$(".level1").children("span").each(function(i,n){
			     var obj = $(n);
			     if(obj.attr('id').indexOf('check')!=-1){
			     	obj.remove();
			     }
			   });
			
			//button chk checkbox_true_full
			
		});
		
	</script>
	
	</body>
</html>
