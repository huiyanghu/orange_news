<%@page language="java" contentType="text/html; charset=UTF-8"%>
<%@ include file="/common/taglibs.jsp"%>
<!DOCTYPE html>
<html lang="en">
<head>
	<script type="text/javascript" src="${ctx }/js/plugins/My97DatePicker/WdatePicker.js"></script>
	<script src="${ctx }/js/page/jqPaginator.min.js" type="text/javascript"></script>
    <link href="${ctx }/css/page/myPage.css" rel="stylesheet" type="text/css" />
</head>
<body>
	<div class="row">
		<div class="col-sm-12">
			<h1 class="page-header">任务管理</h1>
		</div>
	</div>
	<div class="row">
		<div class="col-sm-12">
			<div class="panel panel-default">
				<div class="panel-heading text-right">
					<div class="row">
						<form class="form-inline" role="form" action="" method="get">
							<input name="page" type="hidden" value="1" />
							<div class="form-group">
								<div class="input-group">
									<div class="input-group-addon">任务标题:</div>
									<input class="form-control" type="text" name="title" value="${userjob.title}" />
								</div>
							</div>
							<button type="submit" class="btn btn-primary">搜索</button>
							<a class="btn btn-primary" href="${ctx }/userjob/add?id=" >新增任务</a>
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
									<th>标题</th>
									<th>描述</th>
									<th>时间</th>
									<th>状态</th>
									<th>ck币</th>
									<th>排序</th>
									<th></th>
								</tr>
							</thead>
							<tbody>
								<c:forEach var="item" items="${userjobs}">
									<tr class="id" value="${item.id }">
										<td>${item.id}</td>
										<td>${item.title }</td>
										<td>${item.desc }</td>
										<td>
										<fmt:formatDate value="${item.createtime}" type="date" pattern="yyyy-MM-dd HH:mm:ss"/>
										</td>
										<td>
										<c:if test="${item.status==0}">正常</c:if>
										<c:if test="${item.status==1}">禁用</c:if>
										</td>
										<td>${item.ckcoins}</td>
										<td>${item.sortvalue}</td>
										<td>
										 <div class="btn-group">
												<a class="btn btn-primary" href="#"><i
													class="icon-wrench icon-white"></i>操作</a> <a
													class="btn btn-primary dropdown-toggle"
													data-toggle="dropdown" href="#"><span class="caret"></span></a>
												<ul class="dropdown-menu">

													<li><a href="${ctx }/userjob/add?id=${item.id}"><i
															class="fa fa-pencil fa-fw"></i>修改</a></li>
													<li><a href="${ctx }/userjob/delete?id=${item.id}"><i
															class="fa fa-trash-o fa-fw"></i>删除</a></li>
							
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
					        <input type="hidden" id="PageCount" runat="server" value="${pageUtil.recordCount}"/>
					        <!-- 总页数 -->
					        <input type="hidden" id="countindex" runat="server" value="${pageUtil.pagecount}"/>
					        <!-- 当前第几页 -->
					        <input type="hidden" id="Pagedq" runat="server" value="${pageUtil.currentPage}"/>
					        <!-- 请求的地址 -->
					        <input type="hidden" id="pageUrl" runat="server" value="${ctx }/userjob/list"/>
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
