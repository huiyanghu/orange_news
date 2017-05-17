<%@page language="java" contentType="text/html; charset=UTF-8"%>
<%@ include file="/common/taglibs.jsp"%>
<!DOCTYPE html>
<html lang="en">
<head>
</head>
<body>
	<div class="row">
		<div class="col-sm-12">
			<h1 class="page-header">动作信息管理</h1>
		</div>
	</div>
	<div class="row">
		<div class="col-sm-12">
			<div class="panel panel-default">
				<div class="panel-heading text-right">
					<div class="row">
					</div>
				</div>
				<!-- /.panel-heading -->
				<div class="panel-body">
					<div class="table-responsive">
						<table class="table table-striped table-bordered table-hover"
							id="dataTables-example">
							<thead>
								<tr>
									<th>UUID</th>
									<th>应用ID</th>
									<th>渠道ID</th>
									<th>应用版本</th>
									<th>动作目标</th>
									<th>动作类型</th>
									<th>目标ID</th>
									<th>动作时间</th>
									<th></th>

								</tr>
							</thead>
							<tbody>
								<c:forEach var="item" items="${actionlist}">
									<tr class="id" value="${item.uuid }">
										<td>${item.uuid }</td>
										<td><coolook:status type="4" value="${item.appid }"/></td>
										<td><coolook:status type="3" value="${item.channelid }"/></td>
										<td>${item.appversion }</td>
										<td><coolook:status type="16" value="${item.objtype }"/></td>
										<td><coolook:status type="17" value="${item.actiontype }"/></td>
										<td>${item.objvalue }</td>
										<td><fmt:formatDate value="${item.actiontimes}"  pattern="yyyy-MM-dd HH:mm:ss"/></td>
										
										<%-- <td>
											<div class="btn-group">
												<a class="btn btn-primary" href="#"><i
													class="icon-wrench icon-white"></i>操作</a> <a
													class="btn btn-primary dropdown-toggle"
													data-toggle="dropdown" href="#"><span class="caret"></span></a>
												<ul class="dropdown-menu">
												
													<li><a href="${ctx }/gather/actionlist?uuid=${item.uuid}"><i
															class="fa fa-pencil fa-fw"></i>动作详情</a></li>
														
													<li><a
														href="${ctx }/gather/delete?id=${item.uuid}"><i
															class="fa fa-trash-o fa-fw" ></i>设备详情</a></li>
												</ul>
											</div>

										</td> --%>

									</tr>
								</c:forEach>
							</tbody>
						</table>
						<div class="row">
							<div class="col-sm-12 text-center">
									<ul class="pagination">
										<li>
										<a href="#">当前：${pageUtil.currentPage}页，总共:${pageUtil.recordCount}条,总页数:${pageUtil.pagecount }页</a></li>
										<c:if test="${pageUtil.currentPage>1}">
											<li><a href="${ctx }/gather/actionlist?page=1&uuid=${uuid}">首页</a></li>
										</c:if>	
										<c:if test="${pageUtil.currentPage>1}">
											<li><a href="${ctx }/gather/actionlist?page=${pageUtil.currentPage-1}${searchstr}&uuid=${uuid}">上一页</a></li>
										</c:if>
										<c:if test="${pageUtil.currentPage<pageUtil.pagecount}">
											<li><a href="${ctx }/gather/actionlist?page=${pageUtil.currentPage+1}${searchstr}&uuid=${uuid}">下一页</a></li>
										</c:if> 
										<c:if test="${pageUtil.currentPage<pageUtil.pagecount}">
											<li><a href="${ctx }/gather/actionlist?page=${pageUtil.pagecount}&uuid=${uuid}">尾页</a></li>
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
