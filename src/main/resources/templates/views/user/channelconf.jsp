<%@page language="java" contentType="text/html; charset=UTF-8"%>
<%@ include file="/common/taglibs.jsp"%>
<!DOCTYPE html>
<html lang="en">
<head>
</head>
<body>
			<div class="row">
			<div class="col-sm-12">
				<h1 class="page-header">用户渠道配置</h1>
			</div>
		</div>
		<div class="row">
			<div class="col-sm-12">
				<div class="panel panel-default">
					<div class="panel-heading">请填写以下选项：</div>
					<div class="panel-body">
						<div class="row">
							<form id="editUserChannelConf" class="form-horizontal"
								action="${ctx }/user/updatechannelconf" method="post">
								<input name="userid" type="hidden" value="${sysuser.userid }" />
								<input name="channelidlist" type="hidden" id = "channelidlist"/>
								<div class="form-group">
									<label for="input01" class="control-label col-sm-2">用户名:</label>
									<div class="controls col-sm-8">
										${sysuser.username}
									</div>
								</div>
								<div class="form-group">
									<label class="control-label col-sm-2">渠道:</label>
									<table class="table table-striped table-bordered table-hover"
							id="dataTables-example" style="width:55%">
										<thead>
											<tr>
												<th></th>
												<th>ID</th>
												<th>渠道代码</th>
												<th>渠道名称</th>
												<th>渠道描述</th>
											</tr>
										</thead>
										<tbody>
											<c:forEach var="item" items="${appchannels}">
												<tr class="id" value="${item.id }">
													<td><input type="checkbox" 
														<c:forEach var="ite" items="${userchannels}">
															<c:if test="${item.id eq ite.channelid}">checked = "true"</c:if>
														</c:forEach>
													></td>
													
													<td>${item.id }</td>
													<td>${item.channelcode }</td>
													<td>${item.channelname }</td>
													<td>${item.channeldesc }</td>
												</tr>
											</c:forEach>
										</tbody>
									</table>
									
								</div>
								
								
								</div>
								<div class="form-actions">
									<div class="col-sm-1"></div>
									<div class="col-sm-8">
										<a href="${ctx }/user/list" class="btn btn-info"><span class="fa fa-arrow-left fa-fw"></span> 返回</a>
										&nbsp;&nbsp;
										<button class="btn btn-primary" type="submit" onclick = 'ck()'><span class="fa fa-floppy-o fa-fw"></span> 确认修改</button>
									</div>
								</div>
							</form>
						</div>
					</div>
				</div>
			</div>
		</div>
		
	<script>
    	function ck(){
    		var result = "";
    		var tbodyObj = document.getElementById('dataTables-example');
       		 $("table :checkbox").each(function(key,value){
            		if($(value).prop('checked')){
            			result += (tbodyObj.rows[key + 1].cells[1].innerHTML + " ");
           			 }
       		 })
       		document.getElementById("channelidlist").value = result;
    	}
	</script>
		
</body>
</html>
