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
			<h1 class="page-header">${appevent.eventname }_${appevent.modelname }_${appevent.objTypeName }_${appevent.actionTypeName }</h1>
		</div>
	</div>
	<div class="row">
		<div class="col-sm-12">
			<div class="panel panel-default">
				<div class="panel-heading text-right">
					<div class="row">
						<form class="form-inline" role="form" action="${ctx}/event/statistics" method="get">
							<input type="hidden" name="id" value="${appevent.id }">
							<div class="form-group">
							    <div class="input-group">
							      <div class="input-group-addon">渠道:</div>
							      <select name="channelid" id="channelid" class="form-control">
							      		<option value="" >请选择</option>
							      		<c:forEach var="uitem" items="${channellist }">
							      			<option value="${uitem.id }" <c:if test="${channelid==uitem.id }">selected</c:if> >${uitem.channelname }</option>
							      		</c:forEach>
							      </select>
							    </div>
							  </div>
							<div class="form-group">
							    <div class="input-group">
							      <div class="input-group-addon">开始日期:</div>
							      <input class="form-control" name="starttime" type="text" placeholder="输入开始日期" onClick="WdatePicker({dateFmt:'yyyy-MM-dd HH:mm:ss'})" value="${starttime }">
							    </div>
							  </div>
							 <div class="form-group">
							    <div class="input-group">
							      <div class="input-group-addon">结束日期:</div>
							      <input class="form-control" name="endtime" type="text" placeholder="输入结束时间" onClick="WdatePicker({dateFmt:'yyyy-MM-dd HH:mm:ss'})"  value="${endtime }">
							    </div>
							  </div>
							<button type="submit" class="btn btn-primary">搜索</button>
						</form>



						<%-- <a href="${ctx }/event/addEdit" class="btn btn-primary" id="add"><span
							class="fa fa-plus-circle fa-fw"></span> 添加事件</a> --%>
					</div>
				</div>
				<!-- /.panel-heading -->
				<div class="panel-body">
					<div class="table-responsive">
					<h1>${count}</h1>
					</div>
				</div>
			</div>
		</div>
	</div>
	
</body>
</html>
