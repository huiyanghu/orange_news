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
			<c:if test="${actiondata.modelid>0&&actiondata.objtype==-5&&actiondata.actiontype==-5 }">
			<h1 class="page-header">【${models.modelname}】模块对象数据统计</h1>
			</c:if>
			<c:if test="${actiondata.objtype>-5 }">
			<h1 class="page-header">【${models.modelname}-${objtype}】对象动作数据统计</h1>
			</c:if>
		</div>
	</div>
	<div class="row">
		<div class="col-sm-12">
			<div class="panel panel-default">
				<div class="panel-heading text-right">
					<div class="row">
						<form class="form-inline" role="form" action="${ctx}/actionstatistic/statistic" method="get">
						<div class="form-group">
							    <div class="input-group">
							      <div class="input-group-addon">渠道:</div>
							      <select name="channelid" id="channelid" class="form-control">
							      		<option value="" >请选择</option>
							      		<c:forEach var="uitem" items="${channellist }">
							      			<option value="${uitem.id }" <c:if test="${actiondata.channelid==uitem.id }">selected</c:if> >${uitem.channelname }</option>
							      		</c:forEach>
							      </select>
							    </div>
							  </div>
							  <div class="form-group">
							    <div class="input-group">
							      <div class="input-group-addon">模块:</div>
							      <select name="modelid" id="modelid" class="form-control">
							      		<option value="" >请选择</option>
							      		<c:forEach var="uitem" items="${modellist }">
							      			<option value="${uitem.id }" <c:if test="${actiondata.modelid==uitem.id }">selected</c:if> >${uitem.modelname }</option>
							      		</c:forEach>
							      </select>
							    </div>
							  </div>
							  <div class="form-group">
							    <div class="input-group">
							      <div class="input-group-addon">对象类型:</div>
							      <select name="objtype" id="objtype" class="form-control">
							      		<option value="">请选择</option>
							      		<c:forEach var="obj" items="${objmap }">
							      			<option value="${obj.key }" <c:if test="${actiondata.objtype==obj.key }">selected</c:if> >${obj.value}</option>
							      		
							      		</c:forEach>
							      		
							      </select>
							    </div>
							  </div>
							  
							  <div class="form-group">
							    <div class="input-group">
							      <div class="input-group-addon">动作类型:</div>
							      <select name="actiontype" id="actiontype" class="form-control">
							      		<option value="">请选择</option>
							      		<c:forEach var="action" items="${actionmap }">
							      			<option value="${action.key }" <c:if test="${actiondata.actiontype==action.key }">selected</c:if> >${action.value}</option>
							      		
							      		</c:forEach>
							      </select>
							    </div>
							  </div>
							  
							  
							  <div class="form-group">
							    <div class="input-group">
							      <div class="input-group-addon">开始日期:</div>
							      <input class="form-control" name="starttime" id="starttime" type="text" placeholder="输入开始日期"  value="${actiondata.starttime }" onClick="WdatePicker()"/>
							    </div>
							  </div>
							  <div class="form-group">
							    <div class="input-group">
							      <div class="input-group-addon">结束日期:</div>
							      <input class="form-control" name="endtime" id="endtime" type="text" placeholder="输入结束日期"  value="${actiondata.endtime }" onClick="WdatePicker()"/>
							    </div>
							  </div>
							   
							   <input type="submit" value="搜索" />
							</form>
					
					
					</div>
				</div>
				<!-- /.panel-heading -->
				<div class="panel-body">
					<div class="table-responsive">
						<table class="table table-striped table-bordered table-hover"
							id="dataTables-example">
							<thead>
								<tr>
									<c:if test="${actiondata.modelid>0&&actiondata.objtype==-5&&actiondata.actiontype==-5 }">
									<th>对象名称</th>
									</c:if>
									<c:if test="${actiondata.objtype>-5 }">
									<th>名称</th>
									</c:if>
									<th>事件数量</th>
									<th></th>

								</tr>
							</thead>
							<tbody>
								<c:forEach var="item" items="${map}">
									<tr class="id">
										<td>${item.key }</td>
										<td>${item.value }</td>
										<td>

										</td>

									</tr>
								</c:forEach>
							</tbody>
						</table>
					</div>
				</div>
			</div>
		</div>
	</div>
</body>
</html>
