<%@page language="java" contentType="text/html; charset=UTF-8"%>
<%@ include file="/common/taglibs.jsp"%>
<!DOCTYPE html>
<html lang="en">
<head>
</head>
<body>
	<div class="row">
		<div class="col-sm-12">
			<h1 class="page-header">推送管理</h1>
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
									<th>文章标题</th>
									<th>国家</th>
									<th>推送状态</th>
									<th>推送数量</th>
									<th>推送时间</th>
									<th></th>
								</tr>
							</thead>
							<tbody>
									<tr class="id" value="${appPushInfo.id }">
										<td>${appPushInfo.title}</td>
										<td><coolook:status type="2" value="${appPushInfo.cid}"/></td>
										<td><coolook:status type="14" value="${appPushInfo.status}"/></td>
										<td>${appPushInfo.pushnum}</td>
										<td><fmt:formatDate value="${appPushInfo.pushtime}" type="both" pattern="yyyy-MM-dd hh:mm:ss"/></td>
										<td>
										
										</td>
									</tr>
							</tbody>
						</table>
					</div>
				</div>
			</div>
		</div>
	</div>
	
</body>
</html>
