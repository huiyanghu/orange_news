<%@page language="java" contentType="text/html; charset=UTF-8"%>
<%@ include file="/common/taglibs.jsp"%>
<!DOCTYPE html>
<html lang="en">
<head>
<script src="${ctx }/js/page/jqPaginator.min.js" type="text/javascript"></script>
    <link href="${ctx }/css/page/myPage.css" rel="stylesheet" type="text/css" />
	<script type="text/javascript" src="${ctx }/js/plugins/My97DatePicker/WdatePicker.js"></script>
</head>
<body>
	<div class="row">
		<div class="col-sm-12">
			<h1 class="page-header">日志管理</h1>
		</div>
	</div>
	<div class="row">
		<div class="col-sm-12">
			<div class="panel panel-default">
			<div class="panel-heading text-right">
						<div class="row">
							<form class="form-inline" role="form" action="" method="get">
							<input name="page" type="hidden" value="${listPaginator.page }"/>
							  <div class="form-group">
							    <div class="input-group">
							      <div class="input-group-addon">操作人:</div>
							      <select name="userid" class="form-control">
							      		<option value="">请选择</option>
							      		<c:forEach var="uitem" items="${users }">
							      			<option value="${uitem.userid }" <c:if test="${syslog.userid ==uitem.userid }">selected</c:if>>${uitem.truename }</option>
							      		</c:forEach>
							      </select>
							    </div>
							  </div>
							  <div class="form-group">
							    <div class="input-group">
							      <div class="input-group-addon">IP:</div>
							      <input class="form-control" name="ip" type="text" placeholder="输入IP地址" value="${syslog.ip }">
							    </div>
							  </div>
							  <div class="form-group">
							    <div class="input-group">
							      <div class="input-group-addon">开始日期:</div>
							      <input class="form-control" name="starttime" type="text" placeholder="输入开始日期" onClick="WdatePicker()" value="${syslog.starttime }">
							    </div>
							  </div>
							 <div class="form-group">
							    <div class="input-group">
							      <div class="input-group-addon">结束日期:</div>
							      <input class="form-control" name="endtime" type="text" placeholder="输入结束时间" onClick="WdatePicker()"  value="${syslog.endtime }">
							    </div>
							  </div>
							  <button type="submit" class="btn btn-primary">搜索 </button>&nbsp;&nbsp;
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
									<th>ID</th>
									<th>日志类型</th>
									<th>操作人</th>
									<th>IP</th>
									<th width="50%">内容</th>
									<th>操作时间</th>
								</tr>
							</thead>
							<tbody>
								<c:forEach var="item" items="${list}">
									<tr>
										<td>${item.id }</td>
										<td>${item.logtype }</td>
										<td><coolook:status type="1" value="${item.userid }"/></td>
										<td>${item.ip }</td>
										<td>${item.logcontent }</td>
										<td><fmt:formatDate value="${item.createdate}" type="both" pattern="MM-dd HH:mm"/></td>
									</tr>
								</c:forEach>
							</tbody>
						</table>
						<div class="col-sm-12 text-center">
					        <ul class="pagination" id="pagination">
						        
					        </ul>
					        <ul id="countabs">
					        
					        </ul>
					        <!-- 总条数 -->
					        <input type="hidden" id="PageCount" runat="server" value="${listPaginator.totalCount}"/>
					        <!-- 总页数 -->
					        <input type="hidden" id="countindex" runat="server" value="${listPaginator.totalPages}"/>
					        <!-- 当前第几页 -->
					        <input type="hidden" id="Pagedq" runat="server" value="${listPaginator.page}"/>
					        <!-- 请求的地址 -->
					        <input type="hidden" id="pageUrl" runat="server" value="${ctx }/log/list"/>
					        <!-- 请求的参数 -->
					        <input type="hidden" id="pageParameter" runat="server" value="${searchstr}"/>
					        <!--设置最多显示的页码数 可以手动设置 默认为7-->
					        <input type="hidden" id="visiblePages" runat="server" value="10" />
						</div>
					    <script src="${ctx }/js/page/myPage.js" type="text/javascript"></script>
					</div>
				</div>
			</div>
		</div>
	</div>
	
</body>
</html>
