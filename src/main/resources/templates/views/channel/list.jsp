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
			<h1 class="page-header">渠道管理</h1>
		</div>
	</div>
	<div class="row">
		<div class="col-sm-12">
			<div class="panel panel-default">
				<div class="panel-heading text-right">
					<div class="row">
						<a href="${ctx }/channel/add?id=0" class="btn btn-primary" id="add"><span
							class="fa fa-plus-circle fa-fw"></span> 添加渠道</a>
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
									<th>应用</th>
									<th>渠道代码</th>
									<th>渠道名称</th>
									<th>开始时间</th>
									<th>结束时间</th>
									<th>状态</th>
									<th>创建人</th>
									<th></th>

								</tr>
							</thead>
							<tbody>
								<c:forEach var="item" items="${channellist}">
									<tr class="id" value="${item.id }">
										<td>${item.id }</td>
										<td><coolook:status type="4" value="${item.appid }"/></td>
										<td>${item.channelcode }</td>
										<td>${item.channelname }</td>
										<td><fmt:formatDate value="${item.starttime }" type="both" pattern="yyyy-MM-dd HH:mm:ss"/></td>
										<td><fmt:formatDate value="${item.endtime }" type="both" pattern="yyyy-MM-dd HH:mm:ss"/></td>
										<td>${item.status==0?"正常":"停用" }</td>
										<td><coolook:status type="1" value="${item.createuid }"/></td>
										<td>
											<div class="btn-group">
												<a class="btn btn-primary" href="#"><i
													class="icon-wrench icon-white"></i>操作</a> <a
													class="btn btn-primary dropdown-toggle"
													data-toggle="dropdown" href="#"><span class="caret"></span></a>
												<ul class="dropdown-menu">
												
													<li><a href="${ctx }/channel/add?id=${item.id}"><i
															class="fa fa-pencil fa-fw"></i>修改</a></li>
													<li><a href="${ctx }/channel/addtoken?id=${item.id}"><i
															class="fa fa-pencil fa-fw"></i>生成token</a></li>
													<li><a
														href="${ctx }/channel/delete?id=${item.id}"><i
															class="fa fa-trash-o fa-fw" ></i>删除</a></li>
													<li><a
														href="${ctx }/channel/model?id=${item.id}&appid=${item.appid}"><i
															class="fa fa-pencil fa-fw" ></i>模块管理</a></li>
													<li><a
														href="${ctx }/channel/DescriptionEditor?id=${item.id}&type=1"><i
															class="fa fa-pencil fa-fw" ></i>商务说明编辑</a></li>
													<li><a
														href="${ctx }/channel/DescriptionEditor?id=${item.id}&type=2"><i
															class="fa fa-pencil fa-fw" ></i>版权信息编辑</a></li>
													<li><a
														href="${ctx }/channel/DescriptionEditor?id=${item.id}&type=3"><i
															class="fa fa-pencil fa-fw" ></i>隐私权政策编辑</a></li>
													<li><a
														href="${ctx }/channel/DescriptionEditor?id=${item.id}&type=4"><i
															class="fa fa-pencil fa-fw" ></i>隐私协议编辑</a></li>								
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
					        <input type="hidden" id="PageCount" runat="server" value="${channellistPaginator.totalCount}"/>
					        <!-- 总页数 -->
					        <input type="hidden" id="countindex" runat="server" value="${channellistPaginator.totalPages}"/>
					        <!-- 当前第几页 -->
					        <input type="hidden" id="Pagedq" runat="server" value="${channellistPaginator.page}"/>
					        <!-- 请求的地址 -->
					        <input type="hidden" id="pageUrl" runat="server" value="${ctx }/channel/list"/>
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
