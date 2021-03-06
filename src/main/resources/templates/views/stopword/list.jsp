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
			<h1 class="page-header">停止词管理</h1>
		</div>
	</div>
	<div class="row">
		<div class="col-sm-12">
			<div class="panel panel-default">
				<div class="panel-heading text-right">
					<div class="row">
					<form class="form-inline" role="form" action="${ctx }/stopword/list" method="get">
							<!-- <input name="page" type="hidden" value="${listPaginator.page }"/> -->
							  <div class="form-group">
							    <div class="input-group">
							      <div class="input-group-addon">key:</div>
							      	<input class="form-control" type="text" name="stopword" value="${bean.stopword}"/>
							    </div>
							  </div>
							  <div class="form-group">
							    <div class="input-group" >
							      <div class="input-group-addon">语言:</div>
							      <select name="langid" class="form-control">
							      		<option value="0">请选择</option>
							      		<c:forEach var="langitem" items="${languagesSort }">
							      			<option value="${langitem.id }" <c:if test="${bean.langid ==langitem.id }">selected</c:if>>${langitem.hbcode }  ${langitem.cnname }</option>
							      		</c:forEach>
							      </select>
							    </div>
							  </div>
							  <button type="submit" class="btn btn-primary">搜索 </button>&nbsp;&nbsp;
								<a href="${ctx }/stopword/add?id=0" class="btn btn-primary" id="add"><span
									class="fa fa-plus-circle fa-fw"></span> 添加停止词</a>
							</form>
					</div>
				</div>
				<!-- /.panel-heading -->
				<div class="panel-body">
					<div class="table-responsive">
						<div class="row">
							<div class="col-sm-12">
								<table class="table table-striped table-bordered table-hover"
							id="dataTables-example">
							<thead>
								<tr>
									<th>ID</th>
									<th>停止词</th>
									<th>语言</th>
									<th>操作</th>
								</tr>
							</thead>
							<tbody>
								<c:forEach var="item" items="${list}">
									<tr class="cid" value="${item.id }">
										<td>${item.id }</td>
										<td>${item.stopword }</td>
										<td>
										<c:forEach items="${languages }" var="iteml">
										<c:if test="${iteml.id ==item.langid }">${iteml.cnname }</c:if>
										</c:forEach>
										</td>
										<td>
											<div class="btn-group">
												<a class="btn btn-primary" href="#"><i
													class="icon-wrench icon-white"></i>操作</a> <a
													class="btn btn-primary dropdown-toggle"
													data-toggle="dropdown" href="#"><span class="caret"></span></a>
												<ul class="dropdown-menu">
													<li><a
														href="${ctx }/stopword/add?id=${item.id}"><i
															class="fa fa-pencil fa-fw"></i>修改</a></li>
													<li><a
														href="${ctx }/stopword/delete?id=${item.id}"><i
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
					        <input type="hidden" id="PageCount" runat="server" value="${listPaginator.totalCount}"/>
					        <!-- 总页数 -->
					        <input type="hidden" id="countindex" runat="server" value="${listPaginator.totalPages }"/>
					        <!-- 当前第几页 -->
					        <input type="hidden" id="Pagedq" runat="server" value="${listPaginator.page}"/>
					        <!-- 请求的地址 -->
					        <input type="hidden" id="pageUrl" runat="server" value="${ctx }/stopword/list"/>
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
		</div>
	</div>
	
</body>
</html>
