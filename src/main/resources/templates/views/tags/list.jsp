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
			<h1 class="page-header">标签管理</h1>
		</div>
	</div>
	<div class="row">
		<div class="col-sm-12">
			<div class="panel panel-default">
				<div class="panel-heading text-right">
					<div class="row">
						<form class="form-inline" role="form" action="" method="get">
							<input name="page" type="hidden" value="${contagsPaginator.page }"/>
							<div class="form-group">
							    <div class="input-group">
							      <div class="input-group-addon">国家:</div>
							      	<select name="countrycode" class="form-control">
							      		<option value="">请选择</option>
							      		<c:forEach var="country" items="${countrysSort }">
							      			<option value="${country.code }" <c:if test="${country.code ==conTags.countrycode }">selected</c:if>>${country.code }  ${country.cnname }</option>
							      		</c:forEach>
							      	</select>
							   	  </div>
							    <div class="input-group">
							      <div class="input-group-addon">状态:</div>
							      	<select name="status" class="form-control">
							      		 <option value="" selected>请选择</option>
							      		 <option value="0" <c:if test="${conTags.status eq 0}">selected</c:if>>激活</option>
							      	     <option value="-1" <c:if test="${conTags.status eq -1}">selected</c:if>>禁用</option>
							      	</select>
							   	  </div>
							   	  
							    <div class="input-group">
							      <div class="input-group-addon">类型:</div>
							      	<select name="tagtype" class="form-control">
							      		<option value="">请选择</option>
							      		<option value="0" <c:if test="${conTags.tagtype eq 0}">selected</c:if>>通用</option>
							      		<option value="1" <c:if test="${conTags.tagtype eq 1}">selected</c:if>>特殊</option>
							      	</select>
							   	  </div>
							   </div>
							  
							  <button type="submit" class="btn btn-primary">搜索 </button>&nbsp;&nbsp;
							  <a href="${ctx }/contags/add?id=0" class="btn btn-primary" id="add"><span
								class="fa fa-plus-circle fa-fw"></span> 添加标签</a>
								
								 <a href="${ctx }/contags/add?id=-1" class="btn btn-primary" id="add"><span
								class="fa fa-plus-circle fa-fw"></span>批量添加</a>
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
									<th>标签图</th>
									<th>标签名称</th>
									<th>国家</th>
									<th>语言</th>
									<th>类型</th>
									<th>状态</th>
									<th>创建人</th>
									<th></th>

								</tr>
							</thead>
							<tbody>
								<c:forEach var="item" items="${contags}">
									<tr class="id" value="${item.id }">
										<td>${item.id }</td>
										<th><img src="${upyunhttp }${item.tagicon }" height="30"/></th>
										<td>${item.tagname }</td>
										<td>${item.countrycode }</td>
										<td>
										   <c:forEach var="it" items="${langs }">
										     <c:if test="${item.langid eq it.id}">${it.cnname }</c:if>
										   </c:forEach>
										</td>
										<td>
										  <c:if test="${item.tagtype ==0 }">通用词语</c:if>
										  <c:if test="${item.tagtype ==1 }">特殊词语</c:if>
										</td>
										<td>
										   <c:if test="${item.status ==0 }">激活</c:if>
										   <c:if test="${item.status ==1 }">未审核</c:if>
										   <c:if test="${item.status ==-1 }">禁用</c:if>
										</td>
										<td><coolook:status type="1" value="${item.updateuid }"/></td>
										<td>
											<div class="btn-group">
												<a class="btn btn-primary" href="#"><i
													class="icon-wrench icon-white"></i>操作</a> <a
													class="btn btn-primary dropdown-toggle"
													data-toggle="dropdown" href="#"><span class="caret"></span></a>
												<ul class="dropdown-menu">
												
													<li><a href="${ctx }/contags/add?id=${item.id}"><i class="fa fa-pencil fa-fw"></i>修改</a></li>
													<c:if test="${item.status != 0}">
													   <li><a href="${ctx }/contags/updateStatus?id=${item.id}&status=0"><i class="fa fa-pencil fa-fw"></i>激活</a></li>
													</c:if>
													<c:if test="${item.status != -1}">
													    <li><a href="${ctx }/contags/updateStatus?id=${item.id}&status=-1"><i class="fa fa-pencil fa-fw"></i>禁用</a></li>
													</c:if>
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
					        <input type="hidden" id="PageCount" runat="server" value="${contagsPaginator.totalCount}"/>
					        <!-- 总页数 -->
					        <input type="hidden" id="countindex" runat="server" value="${contagsPaginator.totalPages }"/>
					        <!-- 当前第几页 -->
					        <input type="hidden" id="Pagedq" runat="server" value="${contagsPaginator.page}"/>
					        <!-- 请求的地址 -->
					        <input type="hidden" id="pageUrl" runat="server" value="${ctx }/contags/list"/>
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
