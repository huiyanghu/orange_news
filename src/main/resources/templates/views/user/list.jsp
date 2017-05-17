<%@page language="java" contentType="text/html; charset=UTF-8"%>
<%@ include file="/common/taglibs.jsp"%>
<!DOCTYPE html>
<html lang="en">
<head>
</head>
<body>
	<div class="row">
		<div class="col-sm-12">
			<h1 class="page-header">用户管理</h1>
		</div>
	</div>
	<div class="row">
		<div class="col-sm-12">
			<div class="panel panel-default">
				<div class="panel-heading text-right">
					<div class="row">
						<a href="${ctx }/user/add?userid=0" class="btn btn-primary" id="add"><span
							class="fa fa-plus-circle fa-fw"></span> 添加用户</a>
					</div>
				</div>
				<!-- /.panel-heading -->
				<div class="panel-body">
					<div class="table-responsive">
						<table class="table table-striped table-bordered table-hover"
							id="dataTables-example">
							<thead>
								<tr>
									<th>用户名</th>
									<th>昵称</th>
									<th>性别</th>
									<th>创建时间</th>
									<th>状态</th>
									<th>角色</th>
									<th></th>

								</tr>
							</thead>
							<tbody>
								<c:forEach var="item" items="${list}">
									<tr class="userid" value="${item.userid }">
										<td>${item.username }</td>
										<td>${item.truename }</td>
										<td><c:if test="${item.sex eq 1}">女</c:if> <c:if
												test="${item.sex eq 0}">男</c:if></td>
										<td><fmt:formatDate value="${item.createtime }"
												type="both" /></td>
										<td><c:if test="${item.isstate eq -1}">已删除</c:if> <c:if
												test="${item.isstate eq 1}">禁用</c:if> <c:if
												test="${item.isstate eq 0}">正常</c:if></td>
										<td><c:forEach items="${rolelist}" var="roleitem">
												<c:if test="${roleitem.roleid eq item.roleid}">
										${roleitem.rolename }
									</c:if>
											</c:forEach></td>
										<td>
											<div class="btn-group">
												<a class="btn btn-primary" href="#"><i
													class="icon-wrench icon-white"></i>操作</a> <a
													class="btn btn-primary dropdown-toggle"
													data-toggle="dropdown" href="#"><span class="caret"></span></a>
												<ul class="dropdown-menu">
													<li><a
														href="${ctx }/user/edit?userid=${item.userid}"><i
															class="fa fa-pencil fa-fw"></i>修改</a></li>
													<li><a
														href="${ctx }/user/delete?userid=${item.userid}"><i
															class="fa fa-trash-o fa-fw"></i>删除</a></li>
													<li><c:if test="${item.roleid eq 4 && item.isstate eq 0}"><a
														href="${ctx }/user/channelconf?userid=${item.userid}"><i
															class="fa fa-cog fa-fw"></i>渠道配置</a></c:if></li>
													<li class="divider"></li>
													<li><a
														href="${ctx }/user/roleselect?userid=${item.userid}"><i
															class="i"></i>选择角色</a></li>
												</ul>
											</div>

										</td>

									</tr>
								</c:forEach>
							</tbody>
						</table>
						<div class="row">
							<div class="col-sm-6">
							
								<%-- <div class="dataTables_info" id="dataTables-example_info"
									role="alert" aria-live="polite" aria-relevant="all">总共:${page.totalResult}条,总页数:${page.totalPage }页</div>
								 --%>	
							</div>
							<%-- <div class="col-sm-6">
								<div class="dataTables_paginate paging_simple_numbers"
									id="dataTables-example_paginate">
									<ul class="pagination">
										<c:if test="${page.currentPage>1}">
											<li class="paginate_button previous"
												aria-controls="dataTables-example" tabindex="0"
												id="dataTables-example_previous"><a
												href="${ctx }/user/list?currentPage=1&checksearchname=${checksearchname}">Previous</a></li>
										</c:if>
										<c:forEach var="item" items="${pagelist}">
											<c:if test="${page.currentPage == item}">
												<li class="paginate_button active"
													aria-controls="dataTables-example" tabindex="0"><a
													href="#">${item}</a></li>
											</c:if>
											<c:if test="${page.currentPage != item}">
												<li class="paginate_button "
													aria-controls="dataTables-example" tabindex="0"><a
													href="${ctx }/user/list?currentPage=${item}&checksearchname=${checksearchname}">${item}</a></li>
											</c:if>
										</c:forEach>
										<c:if test="${page.currentPage<page.totalPage}">
											<li class="paginate_button next disabled"
												aria-controls="dataTables-example" tabindex="0"
												id="dataTables-example_next"><a
												href="${ctx }/user/list?currentPage=${page.totalPage}&checksearchname=${checksearchname}">Next</a></li>
										</c:if>
									</ul>
								</div>
							</div> --%>
						</div>
					</div>
				</div>
			</div>
		</div>
	</div>
	
</body>
</html>
