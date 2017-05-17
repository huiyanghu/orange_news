<%@page language="java" contentType="text/html; charset=UTF-8"%>
<%@ include file="/common/taglibs.jsp"%>
<!DOCTYPE html>
<html lang="en">
<head>
	<script src="${ctx }/js/page/jqPaginator.min.js" type="text/javascript"></script>
    <link href="${ctx }/css/page/myPage.css" rel="stylesheet" type="text/css" />
</head>
<body>
	<div class="row">
		<div class="col-sm-12">
			<h1 class="page-header">模块管理</h1>
		</div>
	</div>
	<div class="row">
		<div class="col-sm-12">
			<div class="panel panel-default">
				<div class="panel-heading text-right">
					<div class="row">
						<form class="form-inline" role="form" action="" method="get">
							<input name="page" type="hidden"
								value="${modellistPaginator.page }" />
							<div class="form-group">
								<div class="input-group">
									<div class="input-group-addon">应用名称:</div>
									<select name="appid" class="form-control">
										<option value="">请选择</option>
										<c:forEach var="uitem" items="${applications }">
											<option value="${uitem.id }"
												<c:if test="${appmodel.appid ==uitem.id }">selected</c:if>>${uitem.appname }</option>
										</c:forEach>
									</select>
								</div>
								
								<div class="input-group">
									<div class="input-group-addon">模块类型:</div>
									<select name="modeltype" class="form-control">
										<option value="-1">请选择</option>
									    <option value="0" <c:if test="${appmodel.modeltype ==0 }">selected="selected"</c:if>>广告</option>
										<option value="1" <c:if test="${appmodel.modeltype ==1 }">selected="selected"</c:if>>文章</option>
										<option value="2" <c:if test="${appmodel.modeltype ==2 }">selected="selected"</c:if>>游戏</option>
										<option value="3" <c:if test="${appmodel.modeltype ==3 }">selected="selected"</c:if>>锁屏</option>
									
									</select>
								</div>
								
							</div>

							<button type="submit" class="btn btn-primary">搜索</button>
							&nbsp;&nbsp; <a
								href="${ctx }/model/add?id=0&appid=${appmodel.appid }"
								class="btn btn-primary" id="add"><span
								class="fa fa-plus-circle fa-fw"></span> 添加模块</a>&nbsp;&nbsp;

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
									<th>模块id</th>
									<th>模块名称</th>
									<th>模块描述</th>
									<th>模块标识</th>
									<th>创建人</th>
									<th>应用名</th>
									<th>模块类型</th>
									<th>模块状态</th>
									<th></th>
								</tr>
							</thead>
							<tbody>
								<c:forEach var="item" items="${modellist}">
									<tr class="tid" value="${item.id }">
										<td>${item.id }</td>
										<td>${item.modelname}</td>
										<td>${item.modeldesc}</td>
										<td>${item.modelcode}</td>
										<td><coolook:status type="1" value="${item.createuid }" /></td>
										<td><coolook:status type="4" value="${item.appid }" /></td>
										<td><coolook:status type="7" value="${item.modeltype }" /></td>
										<td><coolook:status type="0" value="${item.status}" /></td>
										<td>
											<div class="btn-group">
												<a class="btn btn-primary" href="#"><i
													class="icon-wrench icon-white"></i>操作</a> <a
													class="btn btn-primary dropdown-toggle"
													data-toggle="dropdown" href="#"><span class="caret"></span></a>
												<ul class="dropdown-menu">

													<li><a href="${ctx }/model/add?id=${item.id}"><i
															class="fa fa-pencil fa-fw"></i>修改</a></li>
													<li><a href="${ctx }/model/delete?id=${item.id}"><i
															class="fa fa-trash-o fa-fw"></i>删除</a></li>
													<c:if test="${item.status=='0'}">
														<li><a
															href="${ctx }/model/publishchannel?id=${item.id}&appid=${item.appid}"><i
																class="fa fa-pencil fa-fw"></i>发布渠道</a></li>
													</c:if>
													<li><a href="${ctx }/model/advertmange?id=${item.id}"><i
															class="fa fa-trash-o fa-fw"></i>广告管理</a></li>
												</ul>
											</div>

										</td>

									</tr>
								</c:forEach>
							</tbody>
						</table>

					<div class="col-sm-12 text-center">
					        <ul class="pagination" id="pagination">
						        
					        </ul>
					        <ul id="countabs">
					        
					        </ul>
					        <!-- 总条数 -->
					        <input type="hidden" id="PageCount" runat="server" value="${modellistPaginator.totalCount}"/>
					        <!-- 总页数 -->
					        <input type="hidden" id="countindex" runat="server" value="${modellistPaginator.totalPages}"/>
					        <!-- 当前第几页 -->
					        <input type="hidden" id="Pagedq" runat="server" value="${modellistPaginator.page}"/>
					        <!-- 请求的地址 -->
					        <input type="hidden" id="pageUrl" runat="server" value="${ctx }/model/list"/>
					        <!-- 请求的参数 -->
					        <input type="hidden" id="pageParameter" runat="server" value="${searchstr}"/>
					        <!--设置最多显示的页码数 可以手动设置 默认为7-->
					        <input type="hidden" id="visiblePages" runat="server" value="10" />
					</div>
					    <script src="${ctx }/js/page/myPage.js" type="text/javascript"></script>

					</div>
				</div>
			</div>
		</div>
	</div>

</body>
</html>
