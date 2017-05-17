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
			<h1 class="page-header">【${appchannel.channelname }】发布模块</h1>
		</div>
	</div>
	<div class="row">
		<div class="col-sm-12">
			<div class="panel panel-default">
				<div class="panel-heading">请选择模块</div>
				<div class="panel-body">
					<div class="row">
						<form id="addform" class="form-horizontal" action="${ctx }/channel/modelupdate" method="post">
							<input name="id" type="hidden" value="${appchannel.id }" />
							<table class="table table-striped table-bordered table-hover"
							id="dataTables-example">
							<thead>
								<tr>
									<th>模块名称</th>
									<th>模块描述</th>
									<th>模块标识</th>
									<th>模块状态</th>
									<th><input type="checkbox" id="allcheckbox"/></th>
								</tr>
							</thead>
							<tbody>
							
								<c:forEach var="item" items="${modellist }">
									<tr>
										<td>${item.modelname }</td>
										<td>${item.modeldesc }</td>
										<td>${item.modelcode }</td>
										<td><coolook:status type="0" value="${item.status}"/></td>
										<td><input type="checkbox" name="appmodel" value="${item.id }" <c:if test="${item.ischoose=='1'}">checked</c:if>></td>
									</tr>
								</c:forEach>	
							</tbody>
							</table>						
							<div class="form-actions text-center">
								<div class="col-sm-1"></div>
								<div class="col-sm-8">
									<a href="${ctx }/channel/list" class="btn btn-info"><span
										class="fa fa-arrow-left fa-fw"></span> 返回</a> &nbsp;&nbsp;
									<button class="btn btn-primary" type="submit">
										<span class="fa fa-floppy-o fa-fw"></span>
										更新发布模块
									</button>
								</div>
							</div>
						</form>
					</div>
				</div>
			</div>
		</div>
	</div>
	
	<script type="text/javascript">
		$(function(){
			
			$("#allcheckbox").click(function(){ 
			    if(this.checked){
			        $("input[name='appmodel']").each(function(){
			            this.checked = true;
			        }); 
			    }else{ 
			        $("input[name='appmodel']").each(function(){
			            this.checked = false;
			        }); 
			    } 
			});
		});
	</script>

	</body>
</html>
