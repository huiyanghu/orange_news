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
			<h1 class="page-header">
			 项目管理
			</h1>
		</div>
	</div>
	<div class="row">
		<div class="col-sm-12">
			<div class="panel panel-default">
				<div class="panel-heading text-right">
					<div class="row">
						<form class="form-inline" role="form" action="" method="get">
							<input name="page" type="hidden"
								value="${deviceModelsPaginator.page }" />
						
                              <!-- 设备模块名称-->
                              <div class="form-group ">
							      <div class="input-group col-xs-8">
									<div class="input-group-addon">项目名称:</div>
									   <input class="form-control" type="text" name="projectname" value="${deviceModel.projectname }"/>
								  </div>
							     </div>
							    
							<button type="submit" class="btn btn-primary" >搜索</button>
							&nbsp;&nbsp; <a href="${ctx }/devicemodel/add?id=0"
								class="btn btn-primary" id="add"><span
								class="fa fa-plus-circle fa-fw"></span> 添加</a>
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
									<th>项目名称</th>
									<th>渠道id</th>
                                    <th>手机型号</th>
                                    <th>ROM</th>
                                    <th>RAM</th>
                                    <th>分辨率宽</th>
                                    <th>分辨率高</th>
                                    <th>版本</th>
                                     <th>状态</th>
                                     <th></th>
								</tr>
							</thead>
							<tbody>
								<c:forEach var="item" items="${deviceModels}">
									<tr class="id" value="${item.id }">
										<td>${item.id }</td>
										<td>${item.projectname }</td>
										<td>
										<c:forEach items="${channels}" var="channels">
										   <c:if test="${channels.id == item.channelid }">${channels.channelname }</c:if>
										</c:forEach>
										</td>
										<td>${item.modelname }</td>
										<td>${item.rom }</td>
										<td>${item.ram }</td>
										<td>${item.width }</td>
										<td>${item.height }</td>
										<td>${item.version }</td>
										<td>
										<c:if test="${item.status==0 }">正常</c:if>
										<c:if test="${item.status==1 }">禁用</c:if>
										</td>
										<td>
											<div class="btn-group">
												<a class="btn btn-primary" href="#"><i
													class="icon-wrench icon-white"></i>操作</a> <a
													class="btn btn-primary dropdown-toggle"
													data-toggle="dropdown" href="#"><span class="caret"></span></a>
												<ul class="dropdown-menu">
													<li><a href="${ctx }/devicemodel/add?id=${item.id}"><i
															class="fa fa-pencil fa-fw"></i>修改</a></li>
															<li><a href="${ctx }/devicemodel/delete?id=${item.id}"><i
															class="fa fa-pencil fa-fw"></i>删除</a></li>

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
					        <input type="hidden" id="PageCount" runat="server" value="${deviceModelsPaginator.totalCount}"/>
					        <!-- 总页数 -->
					        <input type="hidden" id="countindex" runat="server" value="${deviceModelsPaginator.totalPages}"/>
					        <!-- 当前第几页 -->
					        <input type="hidden" id="Pagedq" runat="server" value="${deviceModelsPaginator.page}"/>
					        <!-- 请求的地址 -->
					        <input type="hidden" id="pageUrl" runat="server" value="${ctx }/devicemodel/list"/>
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
