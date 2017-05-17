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
			<h1 class="page-header">用户审核管理</h1>
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
									<div class="input-group-addon">uuid:</div>
									<input class="form-control" type="text" name="uuid" value="${userReview.uuid}" />
								</div>
								<div class="input-group">
									<div class="input-group-addon">状态:</div>
									<select class="form-control" name="status">
									     <option value="-1">请选择</option>
									     <option <c:if test="${userReview.status==0}">selected="selected"</c:if>  value="0">审核中</option>
									     <option <c:if test="${userReview.status==1}">selected="selected"</c:if>  value="1">已审核</option>
									     <option <c:if test="${userReview.status==2}">selected="selected"</c:if>  value="2">已驳回</option>
									</select>
								</div>
							</div>
							<button type="submit" class="btn btn-primary">搜索</button>
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
									<th>uuid</th>
									<th>姓名</th>
									<th>邮箱</th>
									<th>电话</th>
									<th>国家</th>
									<th>城市</th>
									<th>语言</th>
									<th>状态</th>
									<th>创建时间</th>
									<th>操作</th>
								</tr>
							</thead>
							<tbody>
								<c:forEach var="item" items="${userReviews}">
									<tr class="id" value="${item.id }">
										<td>${item.id}</td>
										<td>${item.uuid }</td>
										<td>${item.name }</td>
										<td>${item.email }</td>
										<td>${item.iphone }</td>
										<td>${item.countryCode }</td>
										<td>${item.city }</td>
										<td>${item.langid }</td>
										<td>
										<c:if test="${item.status==0}">审核中</c:if>
										<c:if test="${item.status==1}">已审核</c:if>
										<c:if test="${item.status==2}">已驳回</c:if>
										</td>
										<td>
										<jsp:useBean id="occurDate" class="java.util.Date" />
										<jsp:setProperty name="occurDate" property="time" value="${item.createtime}" />  
                                        <fmt:formatDate value="${occurDate}" type="both" pattern="yyyy-MM-dd HH:mm:ss" />
										</td>
										<td>
										 <div class="btn-group">
												<a class="btn btn-primary" href="#"><i
													class="icon-wrench icon-white"></i>操作</a> <a
													class="btn btn-primary dropdown-toggle"
													data-toggle="dropdown" href="#"><span class="caret"></span></a>
												<ul class="dropdown-menu">
													<%--此功能暂时不开放
													<li><a href="${ctx }/userreview/add?id=${item.id}"><i
															class="fa fa-pencil fa-fw"></i>修改</a></li> --%>
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
									<li><a href="#">当前：${pageUtil.currentPage}页，总共:${pageUtil.recordCount}条,总页数:${pageUtil.pagecount }页</a></li>
									<c:if test="${pageUtil.currentPage>1}">
										<li><a href="${ctx }/userreview/list?page=1${searchstr}">首页</a></li>
									</c:if>
									<c:if test="${pageUtil.currentPage>1}">
										<li><a
											href="${ctx }/userreview/list?page=${pageUtil.currentPage-1}${searchstr}">上一页</a></li>
									</c:if>
									<c:if test="${pageUtil.currentPage<pageUtil.pagecount}">
										<li><a
											href="${ctx }/userreview/list?page=${pageUtil.currentPage+1}${searchstr}">下一页</a></li>
									</c:if>
									<c:if test="${pageUtil.currentPage<pageUtil.pagecount}">
										<li><a
											href="${ctx }/userreview/list?page=${pageUtil.pagecount}${searchstr}">尾页</a></li>
									</c:if>
								</ul>
							</div>
						</div> --%>

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
					        <input type="hidden" id="pageUrl" runat="server" value="${ctx }/userreview/list"/>
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
