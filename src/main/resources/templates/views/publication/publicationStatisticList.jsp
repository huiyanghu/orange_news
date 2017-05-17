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
									<select name="countrycode" class="form-control">
										<option value="">请选择</option>
										<c:forEach var="country" items="${countrysSort }">
											<option value="${country.code }"
												<c:if test="${country.code == countrycode }">selected</c:if>>${country.code } ${country.cnname }</option>
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
									<th>索引</th>
									<th>媒体id</th>
									<th>媒体名称</th>
									<th>一个月的数量</th>
									<th>
									
									</th>

								</tr>
							</thead>
							<tbody>
								<c:forEach var="item" items="${articalStatisticVos}"
									varStatus="status">
									<tr class="id" value="">
										<td>${status.index+1 }</td>
										<td>${item.id }</td>
										<td>${item.name }</td>
										<td>${item.count}</td>


										<td><a class="btn btn-primary" target="_black"
											href="${ctx }/article/list?publicationid=${item.id }">查看媒体</a>
											<%-- <a class="btn btn-primary" target="_black"
											href="${ctx }/globalrule/list?page=1&rulename=&pid=${item.id }&nid=${nid }">查看HB媒体配置规则</a> --%>
											<a class="btn btn-primary" target="_black"
											href="${ctx }/globalrule/list?page=1&pid=${item.id }">查看HB媒体配置规则</a>
											<a class="btn btn-primary" target="_black"
											href="${ctx }/listrule/list?page=1&pid=${item.id }">查看自己抓取的媒体配置规则</a>



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
