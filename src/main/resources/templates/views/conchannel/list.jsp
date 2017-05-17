<%@page language="java" contentType="text/html; charset=UTF-8"%>
<%@ include file="/common/taglibs.jsp"%>
<!DOCTYPE html>
<html lang="en">
<head>
</head>
<body>
	<div class="row">
		<div class="col-sm-12">
			<h1 class="page-header">渠道管理</h1>
		</div>
	</div>
	<div class="row">
		<div class="col-sm-12">
			<div class="panel panel-default">
				<div class="panel-heading text-right">
					<div class="row">
						<a href="${ctx }/conchannel/add?id=0" class="btn btn-primary" id="add"><span
							class="fa fa-plus-circle fa-fw"></span> 添加渠道</a>
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
									<th>来源渠道</th>
									<th>来源国家</th>
									<th>状态</th>
									<th>创建人</th>
									<th></th>

								</tr>
							</thead>
							<tbody>
								<c:forEach var="item" items="${conchannels}">
									<tr class="id" value="${item.id }">
										<td>${item.id }</td>
										<td>${item.channelname }</td>
										<td>${item.countryid==0?"所有国家":"单独国家" }</td>
										<td>${item.status==0?"支持":"失效" }</td>
										<td><coolook:status type="1" value="${item.createuid }"/></td>
										<td>
											<div class="btn-group">
												<a class="btn btn-primary" href="#"><i
													class="icon-wrench icon-white"></i>操作</a> <a
													class="btn btn-primary dropdown-toggle"
													data-toggle="dropdown" href="#"><span class="caret"></span></a>
												<ul class="dropdown-menu">
												
													<li><a href="${ctx }/conchannel/add?id=${item.id}"><i
															class="fa fa-pencil fa-fw"></i>修改</a></li>
														
													<li><a
														href="${ctx }/conchannel/delete?id=${item.id}"><i
															class="fa fa-trash-o fa-fw" ></i>删除</a></li>
												</ul>
											</div>

										</td>

									</tr>
								</c:forEach>
							</tbody>
						</table>
						<%-- <div class="row">
							<div class="col-sm-12 text-center">
									<ul class="pagination">
										<li>
											<a href="#">当前：${channellistPaginator.page}页，总共:${channellistPaginator.totalCount}条,总页数:${channellistPaginator.totalPages }页</a>
										</li>
										<c:if test="${channellistPaginator.page>1}">
											<li><a href="${ctx }/channel/list?page=${channellistPaginator.prePage}${searchstr}">上一页</a></li>
										</c:if>
										
										<c:if test="${channellistPaginator.page<channellistPaginator.totalPages}">
											<li><a href="${ctx }/channel/list?page=${channellistPaginator.nextPage}${searchstr}">下一页</a></li>
										</c:if>

									</ul>
							</div>
						</div> --%>
					</div>
				</div>
			</div>
		</div>
	</div>
</body>
</html>
