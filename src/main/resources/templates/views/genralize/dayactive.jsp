<%@page language="java" contentType="text/html; charset=UTF-8"%>
<%@ include file="/common/taglibs.jsp"%>
<!DOCTYPE html>
<html lang="en">
<head>
<script type="text/javascript" src="${ctx }/js/plugins/My97DatePicker/WdatePicker.js"></script>
</head>
<body>
	<div class="row">
		<div class="col-sm-12">
			<h1 class="page-header">【活跃统计】</h1>
		</div>
	</div>
	<div class="row">
		<div class="col-sm-12">
			<div class="panel panel-default">
				<div class="panel-heading text-right">
					<div class="row">
						<form class="form-inline" role="form" action="${ctx}/genralize/dayactive" method="get">
							  <c:if test="${sessionScope.sysuser.roleid !=  1001 }">
							  <div class="form-group">
							   <div class="input-group">
								<div class="input-group-addon">渠道：</div>
									<select id="channelid" name="channelid" class="form-control">
									<option value="0" >全部</option>
										<c:forEach items="${channellist }" var="iteml">
											<option value="${iteml.id }"
												<c:if test="${iteml.id ==channelid }">selected</c:if>>${iteml.channelname }</option>
										</c:forEach>
									</select>
								</div>
								</div>
							</c:if>
							  <div class="form-group">
							    <div class="input-group">
							      <div class="input-group-addon">开始日期:</div>
							      <input class="form-control" name="starttime" id="starttime" type="text" placeholder="输入开始日期"  value="${gad.starttime }" onClick="WdatePicker()"/>
							    </div>
							  </div>
							  <div class="form-group">
							    <div class="input-group">
							      <div class="input-group-addon">结束日期:</div>
							      <input class="form-control" name="endtime" id="endtime" type="text" placeholder="输入结束日期"  value="${gad.endtime }" onClick="WdatePicker()"/>
							    </div>
							  </div>
							   
							   <input type="submit" value="搜索" />
							</form>
					
					
					</div>
				</div>
				<!-- /.panel-heading -->
				<div class="panel-body">
				<div class="col-sm-12">
					<div class="col-sm-6">uuid活跃:${newlydatas}</div>
					<div class="col-sm-6">imei活跃:${newlydatas1}</div>
				</div>
					<%-- <div class="table-responsive">
						<table class="table table-striped table-bordered table-hover"
							id="dataTables-example">
							<!-- <thead>
								<tr>
									<th>UUID</th>
									<th>应用ID</th>
									<th>渠道ID</th>
									<th>应用版本</th>
									<th></th>

								</tr>
							</thead> -->
							<tbody>
								<c:forEach var="item" items="${newlydatas}">
									<tr class="id" value="${item.uuid }">
										<td>${item.key }</td>
										<td><coolook:status type="4" value="${item.appid }"/></td>
										<td><coolook:status type="3" value="${item.channelid }"/></td>
										<td>${item.value }</td>
										<td>

										</td>

									</tr>
								</c:forEach>
							</tbody>
						</table>
						
						
					</div> --%>
				</div>
			</div>
		</div>
	</div>
</body>
</html>
