<%@page language="java" contentType="text/html; charset=UTF-8"%>
<%@ include file="/common/taglibs.jsp"%>
<!DOCTYPE html>
<html lang="en">
<head>
</head>
<body>
	<div class="row">
		<div class="col-sm-12">
			<h1 class="page-header">异常规则处理</h1>
		</div>
	</div>
	<div class="row">
		<div class="col-sm-12">
			<div class="panel panel-default">
				<!-- /.panel-heading -->
				<div class="panel-body">
					<div class="table-responsive">
						<table class="table table-striped table-bordered table-hover"
							id="dataTables-example">
							<thead>
								<tr>
									<th>文件名</th>
									<th>创建时间</th>
									<th>大小</th>
									<th></th>
								</tr>
							</thead>
							<tbody>
								<c:forEach var="item" items="${fiellist}">
									<tr >
										<td>${item.name}</td>
										<td>${item.date}</td>
										<td>${item.size}</td>
										<td>
											<a href="${ctx }/globalrule/errorhandel?filename=/ruleerror/${item.name}">删除</a>
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
