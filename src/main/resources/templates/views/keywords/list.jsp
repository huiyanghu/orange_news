<%@page language="java" contentType="text/html; charset=UTF-8"%>
<%@ include file="/common/taglibs.jsp"%>
<!DOCTYPE html>
<html lang="en">
<head>
</head>
<body>
	<div class="row">
		<div class="col-sm-12">
			<h1 class="page-header">热门搜索热词、敏感词管理</h1>
		</div>
	</div>
	<div class="row">
		<div class="col-sm-12">
			<div class="panel panel-default">
				<div class="panel-heading text-right">
					<div class="row">
						<a href="${ctx }/keywords/add?id=0&countryid=${countryid}" class="btn btn-primary" id="add"><span
							class="fa fa-plus-circle fa-fw"></span> 添加搜索热词和敏感词</a>
					</div>
				</div>
				<!-- /.panel-heading -->
				<div class="panel-body">
					<div class="table-responsive">
						<div class="row">
							<div class="col-sm-6">
								<table class="table table-striped table-bordered table-hover"
							id="dataTables-example">
							<thead>
								<tr>
									<th>热搜词</th>
									<th>操作</th>
								</tr>
							</thead>
							<tbody>
								<c:forEach var="item" items="${skeylist}">
									<tr class="cid" value="${item.id }">
										<td>${item.keyname }</td>
										<td>
											<div class="btn-group">
												<a class="btn btn-primary" href="#"><i
													class="icon-wrench icon-white"></i>操作</a> <a
													class="btn btn-primary dropdown-toggle"
													data-toggle="dropdown" href="#"><span class="caret"></span></a>
												<ul class="dropdown-menu">
													<li><a
														href="${ctx }/keywords/add?id=${item.id}&countryid=${item.countryid}"><i
															class="fa fa-pencil fa-fw"></i>修改</a></li>
													<li><a
														href="${ctx }/keywords/delete?id=${item.id}&countryid=${item.countryid}"><i
															class="fa fa-pencil fa-fw"></i>删除</a></li>
													
												</ul>
											</div>

										</td>

									</tr>
								</c:forEach>
							</tbody>
						</table>
							</div>
							<div class="col-sm-6">
								<table class="table table-striped table-bordered table-hover"
							id="dataTables-example">
							<thead>
								<tr>
									<th>敏感词</th>
									<th>操作</th>
								</tr>
							</thead>
							<tbody>
								<c:forEach var="item" items="${mkeylist}">
									<tr class="cid" value="${item.id }">
										<td>${item.keyname }</td>
										<td>
											<div class="btn-group">
												<a class="btn btn-primary" href="#"><i
													class="icon-wrench icon-white"></i>操作</a> <a
													class="btn btn-primary dropdown-toggle"
													data-toggle="dropdown" href="#"><span class="caret"></span></a>
												<ul class="dropdown-menu">
													<li><a
														href="${ctx }/keywords/add?id=${item.id}&countryid=${item.countryid}"><i
															class="fa fa-pencil fa-fw"></i>修改</a></li>
													<li><a
														href="${ctx }/keywords/delete?id=${item.id}&countryid=${item.countryid}"><i
															class="fa fa-pencil fa-fw"></i>删除</a></li>
													
												</ul>
											</div>
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
		</div>
	</div>
	
</body>
</html>
