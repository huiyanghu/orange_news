<%@page language="java" contentType="text/html; charset=UTF-8"%>
<%@ include file="/common/taglibs.jsp"%>
<!DOCTYPE html>
<html lang="en">
<head>
</head>
<body>
	<div class="row">
		<div class="col-sm-12">
			<h1 class="page-header">基本信息管理</h1>
		</div>
	</div>
	<div class="row">
		<div class="col-sm-12">
			<div class="panel panel-default">
				<div class="panel-heading text-right">
					<div class="row">
							<form class="form-inline" role="form" action="" method="get">
							<input name="page" type="hidden" value="1"/>
							   
							   <div class="form-group">
							    <div class="input-group">
							      <div class="input-group-addon">iemi:</div>
							      	<input class="form-control" type="text" name="iemi" value="${userdata.iemi}"/>
							    </div>
							  </div>
							  <div class="form-group">
							    <div class="input-group">
							      <div class="input-group-addon">UUID:</div>
							      	<input class="form-control" type="text" name="uuid" value="${userdata.uuid}"/>
							    </div>
							  </div>
							
							  <button type="submit" class="btn btn-primary">搜索 </button>
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
									<th>UUID</th>
									<th>应用</th>
									<th>渠道</th>
									<th>应用版本</th>
									<th>IEMI</th>
									<th>国家ID</th>
									<th>国家代码</th>
									<th>IP</th>
									<th></th>

								</tr>
							</thead>
							<tbody>
								<c:forEach var="item" items="${gatherdata}">
									<tr class="id" value="${item.uuid }">
										<td>${item.uuid }</td>
										<td><coolook:status type="4" value="${item.appid }"/></td>
										<td><coolook:status type="3" value="${item.channelid }"/></td>
										<td>${item.appversion}</td>
										<td>${item.iemi}</td>
										<td>${item.countryid }</td>
										<td>${item.countrycode }</td>
										<td>${item.ip}</td>
										<td>
											<div class="btn-group">
												<a class="btn btn-primary" href="#"><i
													class="icon-wrench icon-white"></i>操作</a> <a
													class="btn btn-primary dropdown-toggle"
													data-toggle="dropdown" href="#"><span class="caret"></span></a>
												<ul class="dropdown-menu">
												
													<li><a href="${ctx }/gather/actionlist?uuid=${item.uuid}"><i
															class="fa fa-pencil fa-fw"></i>动作详情</a></li>
														
													<li><a href="${ctx }/gather/devicelist?uuid=${item.uuid}"><i
															class="fa fa-pencil fa-fw" ></i>设备详情</a></li>
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
										<a href="#">当前：${pageUtil.currentPage}页，总共:${pageUtil.recordCount}条,总页数:${pageUtil.pagecount }页</a></li>
										<c:if test="${pageUtil.currentPage>1}">
											<li><a href="${ctx }/gather/list?page=1">首页</a></li>
										</c:if>	
										<c:if test="${pageUtil.currentPage>1}">
											<li><a href="${ctx }/gather/list?page=${pageUtil.currentPage-1}${searchstr}">上一页</a></li>
										</c:if>
										<c:if test="${pageUtil.currentPage<pageUtil.pagecount}">
											<li><a href="${ctx }/gather/list?page=${pageUtil.currentPage+1}${searchstr}">下一页</a></li>
										</c:if> 
										<c:if test="${pageUtil.currentPage<pageUtil.pagecount}">
											<li><a href="${ctx }/gather/list?page=${pageUtil.pagecount}">尾页</a></li>
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
