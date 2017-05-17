<%@page language="java" contentType="text/html; charset=UTF-8"%>
<%@ include file="/common/taglibs.jsp"%>
<!DOCTYPE html>
<html lang="en">
<head>
</head>
<body>
	<div class="row">
		<div class="col-sm-12">
			<h1 class="page-header">媒体统计信息</h1>
		</div>
	</div>
	<div class="row">
		<div class="col-sm-12">
			<div class="panel panel-default">
				<div class="panel-heading text-right">
					<div class="row">

						<form class="form-inline" role="form" action="" method="get">
							<%-- <input name="page" type="hidden" value="${conpublicationsPaginator.page }"/> --%>
							<div class="form-group">
								<div class="input-group col-xs-8">
									<div class="input-group-addon">国家:</div>
									<select name="countryid" class="form-control">
										<option value="">请选择</option>
										<c:forEach var="country" items="${countrysSort }">
											<option value="${country.cid }"
												<c:if test="${country.cid == countryid }">selected</c:if>>${country.code } ${country.cnname }</option>
										</c:forEach>
									</select>
								</div>
							</div>
							<button type="submit" class="btn btn-primary">搜索</button>
							&nbsp;&nbsp;
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
									<th>国家名称</th>
									<th>媒体数量</th>
									<th>近7天的平均数量</th>
									<th>一个月的数量</th>
									<th></th>

								</tr>
							</thead>
							<tbody>
								<c:forEach var="item" items="${statisticlist}">
									<tr class="id" value="">
										<td>${item.countryname }</td>
										<td>${item.publicationsum}</td>
										<td>${item.avgesum }</td>
										<td>${item.monthsum }</td>
										<td></td>

									</tr>
								</c:forEach>
							</tbody>
						</table>
						<%-- <div class="row">
							<div class="col-sm-12 text-center">
									<ul class="pagination">
										<li>
											<a href="#">当前：${conpublicationsPaginator.page}页，总共:${conpublicationsPaginator.totalCount}条,总页数:${conpublicationsPaginator.totalPages }页</a>
										</li>
										<c:if test="${conpublicationsPaginator.page>1}">
											<li><a href="${ctx }/conpublication/list?page=${conpublicationsPaginator.prePage}${searchstr}">上一页</a></li>
										</c:if>
										
										<c:if test="${conpublicationsPaginator.page<conpublicationsPaginator.totalPages}">
											<li><a href="${ctx }/conpublication/list?page=${conpublicationsPaginator.nextPage}${searchstr}">下一页</a></li>
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
