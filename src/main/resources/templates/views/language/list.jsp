<%@page language="java" contentType="text/html; charset=UTF-8"%>
<%@ include file="/common/taglibs.jsp"%>
<!DOCTYPE html>
<html lang="en">
<head>
<link rel="stylesheet" href="${ctx }/css/jquery.fileupload.css">
</head>
<body>
	<div class="row">
		<div class="col-sm-12">
			<h1 class="page-header">语言管理</h1>
		</div>
	</div>
	<div class="row">
		<div class="col-sm-12">
			<div class="panel panel-default">
				<div class="panel-heading text-right">
					<div class="row">
						<form class="form-inline" action="${ctx }/language/importlanguage" method="post" 
							enctype="multipart/form-data">
							<div class="form-group">
							    <div class="input-group">
							      <div class="input-group-addon">国际化语言:</div>
							      <select name="langid" class="form-control">
							      		<option value="-1">请选择</option>
							      	<c:forEach var="language" items="${languagesSort }">
							      		<option value="${language.id}">${language.hbcode} ${language.cnname}</option>
							      	</c:forEach>	
							      </select>
							    </div>
							  </div>
							  <div class="form-group"> 
							  		<span class="btn btn-success fileinput-button">
										<span>上传文件</span>
										<input id="fileupload" type="file" name="file" multiple>
									</span>
							  </div>
									<input type="submit" value="导入Excel"/>
									
									
						<a href="${ctx }/language/exportlanguage" class="btn btn-primary" id="excelang"><span
							class="fa fa-plus-circle fa-fw"></span> 导出国家</a>
						<a href="${ctx }/language/add?id=0" class="btn btn-primary" id="add"><span
							class="fa fa-plus-circle fa-fw"></span> 添加语言</a>
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
									<th>ID</th>
									<th>英文名称</th>
									<th>hbid</th>
									<th>hbcode</th>
									<th>本地名称</th>
									<th>中文名称</th>
									<th>状态</th>
									<th></th>

								</tr>
							</thead>
							<tbody>
								<c:forEach var="item" items="${languages}">
									<tr class="id" value="${item.id }">
										<td>${item.id }</td>
										<td>${item.hbname }</td>
										<td>${item.hbid }</td>
										<td>${item.hbcode }</td>
										<td>${item.localname }</td>
										<td>${item.cnname }</td>
										<td><c:if test="${item.status=='0'}">正常</c:if>
											<c:if test="${item.status=='1'}">禁用</c:if>
											</td>
										<td>
											<div class="btn-group">
												<a class="btn btn-primary" href="#"><i
													class="icon-wrench icon-white"></i>操作</a> <a
													class="btn btn-primary dropdown-toggle"
													data-toggle="dropdown" href="#"><span class="caret"></span></a>
												<ul class="dropdown-menu">
												
													<li><a href="${ctx }/language/add?id=${item.id}"><i
															class="fa fa-pencil fa-fw"></i>修改</a></li>
													<%-- 	
													<li><a
														href="${ctx }/language/delete?id=${item.id}"><i
															class="fa fa-trash-o fa-fw" ></i>删除</a></li> --%>
													<li><a
														href="${ctx }/language/choosecountry?id=${item.id}"><i
															class="fa fa-pencil fa-fw" ></i>国家管理</a></li>
													<li><a
														href="${ctx }/globalization/list?objid=${item.id}&objtype=0"><i
															class="fa fa-pencil fa-fw" ></i>国际化管理</a></li>		
												</ul>
											</div>

										</td>

									</tr>
								</c:forEach>
							</tbody>
						</table>
						<%-- <div class="row">
							<div class="col-sm-12 text-center">
									<ul class="pagination">
										<li>
											<a href="#">当前：${channellistPaginator.page}页，总共:${channellistPaginator.totalCount}条,总页数:${channellistPaginator.totalPages }页</a>
										</li>
										<c:if test="${channellistPaginator.page>1}">
											<li><a href="${ctx }/channel/list?page=${channellistPaginator.prePage}${searchstr}">上一页</a></li>
										</c:if>
										
										<c:if test="${channellistPaginator.page<channellistPaginator.totalPages}">
											<li><a href="${ctx }/channel/list?page=${channellistPaginator.nextPage}${searchstr}">下一页</a></li>
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
