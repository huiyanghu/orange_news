<%@page language="java" contentType="text/html; charset=UTF-8"%>
<%@ include file="/common/taglibs.jsp"%>
<!DOCTYPE html>
<html lang="en">
<head>
</head>
<body>
	<div class="row">
		<div class="col-sm-12">
			<h1 class="page-header">【${topic.topicname }】二级分类下的标签</h1>
		</div>
	</div>
	<div class="row">
		<div class="col-sm-12">
			<div class="panel panel-default">
				<div class="panel-heading text-right">
				</div>
				<!-- /.panel-heading -->
				<div class="panel-body">
					<div class="table-responsive">
						<table class="table table-striped table-bordered table-hover"
							id="dataTables-example">
							<thead>
								<tr>
									<th>标签图</th>
									<th>标签名称</th>
									<th>国家</th>
									<th>语言</th>
									<th>类型</th>
									<th>状态</th>
									<th>创建人</th>
									<th></th>

								</tr>
							</thead>
							<tbody>
								<c:forEach var="item" items="${contags}">
									<tr class="id" value="${item.id }">
										<th><img src="${upyunhttp }${item.tagicon }" height="30"/></th>
										<td>${item.tagname }</td>
										<td>${item.countrycode }</td>
										<td>
										   <c:forEach var="it" items="${langs }">
										     <c:if test="${item.langid eq it.id}">${it.cnname }</c:if>
										   </c:forEach>
										</td>
										<td>
										  <c:if test="${item.tagtype ==0 }">通用词语</c:if>
										  <c:if test="${item.tagtype ==1 }">特殊词语</c:if>
										</td>
										<td>
										   <c:if test="${item.status ==0 }">激活</c:if>
										   <c:if test="${item.status ==-1 }">禁用</c:if>
										</td>
										<td><coolook:status type="1" value="${item.updateuid }"/></td>
										<td>
											<div class="btn-group">
												<a class="btn btn-primary" href="#"><i
													class="icon-wrench icon-white"></i>操作</a> <a
													class="btn btn-primary dropdown-toggle"
													data-toggle="dropdown" href="#"><span class="caret"></span></a>
												<ul class="dropdown-menu">
												
													<li><a href="${ctx }/contopic/deleteTT?tagid=${item.id}&topicid=${topic.tid}"><i
															class="fa fa-pencil fa-fw"></i>删除</a></li>
													<li><a href="${ctx }/contags/add?id=${item.id}"><i
															class="fa fa-pencil fa-fw"></i>修改</a></li>
														
												</ul>
											</div>

										</td>

									</tr>
								</c:forEach>
							</tbody>
						</table>
						<div class="row">
							<div class="col-sm-12 text-center">
									<ul class="pagination">
										<li>
											<a href="#">当前：${contagsPaginator.page}页，总共:${contagsPaginator.totalCount}条,总页数:${contagsPaginator.totalPages }页</a>
										</li>
										<c:if test="${contagsPaginator.page>1}">
											<li><a href="${ctx }/contopic/mstags?page=${contagsPaginator.prePage}${searchstr}">上一页</a></li>
										</c:if>
										
										<c:if test="${contagsPaginator.page<contagsPaginator.totalPages}">
											<li><a href="${ctx }/contopic/mstags?page=${contagsPaginator.nextPage}${searchstr}">下一页</a></li>
										</c:if>

									</ul>
							</div>
						</div>
					</div>
				</div>
			</div>
		</div>
	</div>
</body>
</html>