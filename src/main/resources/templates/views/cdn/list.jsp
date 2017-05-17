<%@page language="java" contentType="text/html; charset=UTF-8"%>
<%@ include file="/common/taglibs.jsp"%>
<!DOCTYPE html>
<html lang="en">
<head>
<script src="${ctx }/js/page/jqPaginator.min.js" type="text/javascript"></script>
    <link href="${ctx }/css/page/myPage.css" rel="stylesheet" type="text/css" />
<script type="text/javascript"
	src="${ctx }/js/plugins/My97DatePicker/WdatePicker.js"></script>
</head>
<body>
	<div class="row">
		<div class="col-sm-12">
			<h1 class="page-header">操作记录</h1>
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
								<div class="input-group col-xs-8">
									<div class="input-group-addon">任务Id:</div>
									<input class="form-control" type="text" name="TaskId"
										value="${TaskId}" />
								</div>
							</div>
							<button type="submit" class="btn btn-primary">搜索</button>
						
							
							<a class="btn btn-primary" href="${ctx }/cdn/add?TaskId=${TaskId}">新增cdn推送任务</a>
							
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
									<th>任务Id</th>
									<th>刷新对象路径</th>
									<th>状态</th>
									<th>进度百分比</th>
									<th>创建时间</th>
									
									<th></th>
								</tr>
							</thead>
							<tbody>
								<c:forEach var="item" items="${list}" >
									<tr class="id" value="${item.id }">
										<td>${item.TaskId}</td>
										<td>${item.ObjectPath }</td>
										<td>
										<c:if test="${item.Status eq 'Complete' }">完成</c:if>
										<c:if test="${item.Status eq 'Refreshing' }">刷新中</c:if>
										<c:if test="${item.Status eq 'Failed' }">刷新失败</c:if>
										<c:if test="${item.Status eq 'Pending' }">等待刷新</c:if>
										
										</td>
										<td>${item.Process}</td>
										<td>${item.CreationTime}</td>
										<td>
                                              
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
					        <input type="hidden" id="pageUrl" runat="server" value="${ctx }/cdn/list"/>
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
