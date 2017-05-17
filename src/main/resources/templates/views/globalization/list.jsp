<%@page language="java" contentType="text/html; charset=UTF-8"%>
<%@ include file="/common/taglibs.jsp"%>
<!DOCTYPE html>
<html lang="en">
<head>
</head>
<body>
	<div class="row">
		<div class="col-sm-12">
			<h1 class="page-header">国际化管理</h1>
		</div>
	</div>
	<div class="row">
		<div class="col-sm-12">
			<div class="panel panel-default">
				<div class="panel-heading text-right">
					<div class="row">
						<a href="${ctx }/globalization/add?id=0&objid=${objid}&objtype=${objtype}" class="btn btn-primary" id="add"><span
							class="fa fa-plus-circle fa-fw"></span> 添加国际化</a>
					</div>
				</div>
				<!-- /.panel-heading -->
				<div class="panel-body">
					<div class="table-responsive">
						<table class="table table-striped table-bordered table-hover"
							id="dataTables-example">
							<thead>
								<tr>
									<th>国际化ID</th>
									<th>国家语言</th>
									<th>国际化目标ID</th>
									<th>目标类型</th>
									<th>目标名称</th>
									<th>创建人</th>
									<th></th>

								</tr>
							</thead>
							<tbody>
								<c:forEach var="item" items="${globalizations}">
									<tr class="id" value="${item.id }">
										<td>${item.id }</td>
										<td><coolook:status type="13" value="${item.langid }"/></td>
										<td>${item.objid }</td>
										<td><coolook:status type="12" value="${item.objtype }"/></td>
										<td>${item.objvalues }</td>
										<td><coolook:status type="1" value="${item.createuid }"/></td>
										<td>
											<div class="btn-group">
												<a class="btn btn-primary" href="#"><i
													class="icon-wrench icon-white"></i>操作</a> <a
													class="btn btn-primary dropdown-toggle"
													data-toggle="dropdown" href="#"><span class="caret"></span></a>
												<ul class="dropdown-menu">
													<li><a
														href="${ctx }/globalization/add?id=${item.id}&objid=${objid}&objtype=${objtype}"><i
															class="fa fa-pencil fa-fw"></i>修改</a></li>
													<li><a
														href="${ctx }/globalization/delete?id=${item.id}&objid=${objid}&objtype=${objtype}"><i
															class="fa fa-trash-o fa-fw"></i>删除</a></li>
													
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
	
</body>
</html>
