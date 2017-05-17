<%@page language="java" contentType="text/html; charset=UTF-8"%>
<%@ include file="/common/taglibs.jsp"%>
<!DOCTYPE html>
<html lang="en">
<head>
	<script src="${ctx }/js/page/jqPaginator.min.js" type="text/javascript"></script>
    <link href="${ctx }/css/page/myPage.css" rel="stylesheet" type="text/css" />
</head>
<body>
	<div class="row">
		<div class="col-sm-12">
			<h1 class="page-header">自定义事件管理</h1>
		</div>
	</div>
	<div class="row">
		<div class="col-sm-12">
			<div class="panel panel-default">
				<div class="panel-heading text-right">
					<div class="row">
						<form class="form-inline" role="form" action="${ctx}/event/list" method="get">
							<div class="form-group">
								<div class="input-group">
									<div class="input-group-addon">事件名称:</div>
									<input type="text" name="eventname" value="${param.eventname }"/>
								</div>
							</div>
							<button type="submit" class="btn btn-primary">搜索</button>
							&nbsp;&nbsp; <a href="${ctx }/event/addEdit"
								class="btn btn-primary" id="add"><span
								class="fa fa-plus-circle fa-fw"></span> 添加事件</a>
						</form>



						<%-- <a href="${ctx }/event/addEdit" class="btn btn-primary" id="add"><span
							class="fa fa-plus-circle fa-fw"></span> 添加事件</a> --%>
					</div>
				</div>
				<!-- /.panel-heading -->
				<div class="panel-body">
					<div class="table-responsive">
						<table class="table table-striped table-bordered table-hover"
							id="dataTables-example">
							<thead>
								<tr>
									<th>事件id</th>
									<th>事件名称</th>
									<th>应用名称</th>
									<th>模块名称</th>
									<th>动作类型</th>
									<th>事件类型</th>
									<th>事件状态</th>
									<th>创建人</th>
									<th></th>
								</tr>
							</thead>
							<tbody>
								<c:forEach var="item" items="${listAppEvent}">
									<tr class="userid" value="${item.eventname }">
										<td>${item.id}</td>
										<td>${item.eventname}</td>
										<td>${item.appname }</td>
										<td>${item.modelname }</td>
										<td>${item.actionTypeName}</td>
										<td>${item.objTypeName}</td>
										<c:if test="${item.state==0}"><td>正常</td></c:if>
										<td>${item.username }</td>
										</td>
										<td>
											<div class="btn-group">
												<a class="btn btn-primary" href="#"><i
													class="icon-wrench icon-white"></i>操作</a> <a
													class="btn btn-primary dropdown-toggle"
													data-toggle="dropdown" href="#"><span class="caret"></span></a>
												<ul class="dropdown-menu">
													<li><a
														href="${ctx }/event/update?id=${item.id}"><i
															class="fa fa-pencil fa-fw"></i>修改</a></li>
													<li><a
														href="${ctx }/event/delete?id=${item.id}"><i
															class="fa fa-trash-o fa-fw"></i>删除</a></li>
													<li><a
														href="${ctx }/event/createAndroidCode?id=${item.id}"><i
															class="fa fa-pencil fa-fw"></i>生成代码</a></li>
													<li><a
														href="${ctx }/event/statistics?id=${item.id}"><i
															class="fa fa-pencil fa-fw"></i>统计数据</a></li>
													<%-- <li><a
														href="${ctx }/event/showData?id=${item.id}"><i
															class="fa fa-pencil fa-fw"></i>显示数据</a></li>	 --%>				
													<li class="divider"></li>
												</ul>
											</div>
										</td>
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
					        <input type="hidden" id="PageCount" runat="server" value="${listAppEventPaginator.totalCount}"/>
					        <!-- 总页数 -->
					        <input type="hidden" id="countindex" runat="server" value="${listAppEventPaginator.totalPages }"/>
					        <!-- 当前第几页 -->
					        <input type="hidden" id="Pagedq" runat="server" value="${listAppEventPaginator.page}"/>
					        <!-- 请求的地址 -->
					        <input type="hidden" id="pageUrl" runat="server" value="${ctx }/event/list"/>
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
