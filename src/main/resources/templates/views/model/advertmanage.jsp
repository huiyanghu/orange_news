<%@page language="java" contentType="text/html; charset=UTF-8"%>
<%@ include file="/common/taglibs.jsp"%>
<!DOCTYPE html>
<html lang="en">
<head>
<link rel="stylesheet" href="${ctx }/css/jquery.fileupload.css">
</head>
<body>
	<div class="row">
		<div class="col-sm-12">
			<h1 class="page-header">【${apmodel.modelname }】模块广告</h1>
		</div>
	</div>
	<div class="row">
		<div class="col-sm-12">
			<div class="panel panel-default">
				<div class="panel-heading">模块广告</div>
				<div class="panel-body">
				
						<div class="panel-body">
					<div class="table-responsive">
						<table class="table table-striped table-bordered table-hover"
							id="dataTables-example">
							<thead>
								<tr>
									<th>广告ID</th>
									<th>广告名称</th>
									<th>广告描述</th>
									<th>状态</th>
									<th></th>
								</tr>
							</thead>
							<tbody>
								<c:forEach var="item" items="${advertlist}">
									<tr class="id" value="${item.id }">
										<td>${item.id}</td>
										<td>${item.adname}</td>
										<td>${item.addesc}</td>
										<td><coolook:status type="0" value="${item.status}"/></td>
										<td>
											<div class="btn-group">
												<a class="btn btn-primary" href="#"><i
													class="icon-wrench icon-white"></i>操作</a> <a
													class="btn btn-primary dropdown-toggle"
													data-toggle="dropdown" href="#"><span class="caret"></span></a>
												<ul class="dropdown-menu">
												
													<c:if test="${item.status==0}">	
													<li><a
														href="${ctx }/model/openorclose?status=1&id=${item.id}&modelid=${apmodel.id}"><i
															class="fa fa-trash-o fa-fw" ></i>禁用</a></li>
													</c:if>	
													
													<c:if test="${item.status==1}">
													<li><a
														href="${ctx }/model/openorclose?status=0&id=${item.id}&modelid=${apmodel.id}"><i
															class="fa fa-trash-o fa-fw" ></i>开启</a></li>		
													</c:if>
												</ul>
											</div>

										</td>

									</tr>
								</c:forEach>
							</tbody>
						</table>
					</div>
				</div>
				
				
				
				
				
					<%-- <div class="row">
						<form id="addform" class="form-horizontal" action="${ctx }/model/advertmanageupdate" method="post">
							<input name="id" type="hidden" value="${apmodel.id }" />
							<table class="table table-striped table-bordered table-hover"
							id="dataTables-example">
							<thead>
								<tr>
									<th>广告ID</th>
									<th>广告名称</th>
									<th>广告描述</th>
									<th>广告状态</th>
									<th></th>
								</tr>
							</thead>
							<tbody>
							
								<c:forEach var="item" items="${channels }">
									<tr>
										<td>${item.channelname }</td>
										<td>${item.channelcode }</td>
										<td><input type="checkbox" name="channel" value="${item.id }" <c:if test="${fn:contains(str,item.id)}">checked</c:if>></td>
									</tr>
								</c:forEach>	
							</tbody>
							</table>						
							<div class="form-actions text-center">
								<div class="col-sm-1"></div>
								<div class="col-sm-8">
									<a href="${ctx }/model/list" class="btn btn-info"><span
										class="fa fa-arrow-left fa-fw"></span> 返回</a> &nbsp;&nbsp;
									<button class="btn btn-primary" type="submit">
										<span class="fa fa-floppy-o fa-fw"></span>
										更新模块广告状态
									</button>
								</div>
							</div>
						</form>
					</div> --%>
				</div>
			</div>
		</div>
	</div>
	<script type="text/javascript">
		$(function(){
			$("#allcheckbox").click(function(){ 
			    if(this.checked){
			        $("input[name='channel']").each(function(){
			            this.checked = true;
			        }); 
			    }else{ 
			        $("input[name='channel']").each(function(){
			            this.checked = false;
			        }); 
			    } 
			});
		});
	</script>
	</body>
</html>
