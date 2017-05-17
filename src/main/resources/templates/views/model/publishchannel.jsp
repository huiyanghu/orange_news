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
			<h1 class="page-header">【${appmodel.modelname }】发布渠道</h1>
		</div>
	</div>
	<div class="row">
		<div class="col-sm-12">
			<div class="panel panel-default">
				<div class="panel-heading">请选择渠道</div>
				<div class="panel-body">
					<div class="row">
						<form id="addform" class="form-horizontal" action="${ctx }/model/publishchannelupdate" method="post">
							<input name="id" type="hidden" value="${appmodel.id }" />
							<table class="table table-striped table-bordered table-hover"
							id="dataTables-example">
							<thead>
								<tr>
									<th>渠道名称</th>
									<th>渠道代码</th>
									<th><input type="checkbox" id="allcheckbox"></th>
								</tr>
							</thead>
							<tbody>
							
								<c:forEach var="item" items="${channels }">
									<tr>
										<td>${item.channelname }</td>
										<td>${item.channelcode }</td>
										<td><input type="checkbox" name="channel" value="${item.id }" <c:if test="${item.type=='1'}">checked</c:if>></td>
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
										更新发布渠道
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
