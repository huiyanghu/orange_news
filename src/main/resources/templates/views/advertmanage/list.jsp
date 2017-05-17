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
			<c:if test="${advertManage.itype==0 }">文章页广告</c:if>
			<c:if test="${advertManage.itype==1 }">浮屏页</c:if>
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
								value="${advertManagesPaginator.page }" />
								<!-- 渠道号搜索 -->
								<c:if test="${advertManage.itype==0}">
								<div class="form-group ">
							      <div class="input-group col-xs-14">
									<div class="input-group-addon">渠道:</div>
									<select id="cid" name="cid" class="form-control">
											 <option value="-1"
												 <c:if test="${advertManage.cid==0}">selected</c:if>>请选择</option> 
											<c:forEach var="item" items="${conchannellist}">
											
												<option value="${item.id}" <c:if test="${advertManage.cid==item.id}">selected="selected"</c:if> >
													${item.channelname}
													</option>
											</c:forEach>
										</select>
									
									
								  </div>
							     </div>
                              </c:if>
                              <c:if test="${advertManage.itype==1}">
                              <!-- 国家搜索 -->
                              <div class="form-group ">
							      <div class="input-group col-xs-10">
									<div class="input-group-addon">国家:</div>
									    <select class="form-control" name="countrycode" id="countrycode">
									    <option value="">请选择</option>
									       <c:forEach var="item" items="${hbcountrysSort}">
											<option value="${item.code}"
												<c:if test="${advertManage.countrycode==item.code}">selected</c:if>>${item.code} ${item.cnname}</option>
											</c:forEach>
									    </select>
								  </div>
							     </div>
							     <!-- 语言搜索 -->
							      <div class="form-group ">
							      <div class="input-group col-xs-10">
									<div class="input-group-addon">语言:</div>
									    <select class="form-control" name="langid" id="langid">
									     <option value="0">请选择</option>
									       <c:forEach var="item" items="${hblanguagesSort}">
											<option value="${item.id}"
												<c:if test="${advertManage.langid==item.id}">selected</c:if>>${item.hbcode}&nbsp;&nbsp;&nbsp;&nbsp;${item.hbname}</option>
											</c:forEach>
									    </select>
								  </div>
							     </div>
                              </c:if>
							<button type="submit" class="btn btn-primary" >搜索</button>
							&nbsp;&nbsp; <a href="${ctx }/advertmanage/add?id=&itype=${advertManage.itype}"
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
									<c:if test="${advertManage.itype==0 }">
									<th>渠道id</th>
									</c:if>
									<th>名称</th>
									<th>url</th>
									<c:if test="${advertManage.itype==1 }">
									<th>国家</th>
									<th>语言</th>
									<th>描述</th>
									</c:if>
									
									<th>图片</th>
									<th>创建时间</th>
									<th>创建人</th>
									<th>状态</th>
									<th></th>

								</tr>
							</thead>
							<tbody>
								<c:forEach var="item" items="${advertManages}">
									<tr class="id" value="${item.id }">
										<td>${item.id }</td>
										<c:if test="${advertManage.itype==0 }">
										<td>${item.cid }</td>
										</c:if>
										<td>${item.advertname }</td>
										<td>${item.adverturl}</td>
										<c:if test="${advertManage.itype==1 }">
										 <td>${item.countrycode }</td>
										 <td>${item.langid }</td>
										 <td>${item.desc }</td>
										</c:if>
										<td>
										<c:if test="${not empty item.advertpic }">
										  <img alt="picture" src="${upyunhttp }${item.advertpic }" style="width: 50px;height: 50px;">
										</c:if>
										</td>
										<td><fmt:formatDate value="${item.createtime}" type="date" pattern="yyyy-MM-dd HH:mm:ss"/></td>
										<td>${item.creater }</td>
										<td>
										<c:if test="${item.status==0 }">正常</c:if>
										<c:if test="${item.status==2 }">禁用</c:if>
										</td>
										<td>
											<div class="btn-group">
												<a class="btn btn-primary" href="#"><i
													class="icon-wrench icon-white"></i>操作</a> <a
													class="btn btn-primary dropdown-toggle"
													data-toggle="dropdown" href="#"><span class="caret"></span></a>
												<ul class="dropdown-menu">
													<li>
													   <a href="${ctx }/advertmanage/add?id=${item.id}">
													     <i class="fa fa-pencil fa-fw"></i>修改
													   </a>
													</li>
													<li>
													   <a href="${ctx }/advertmanage/delete?id=${item.id}&itype=${advertManage.itype}">
													     <i class="fa fa-pencil fa-fw"></i>删除
													   </a>
													</li>

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
					        <input type="hidden" id="PageCount" runat="server" value="${advertManagesPaginator.totalCount}"/>
					        <!-- 总页数 -->
					        <input type="hidden" id="countindex" runat="server" value="${advertManagesPaginator.totalPages}"/>
					        <!-- 当前第几页 -->
					        <input type="hidden" id="Pagedq" runat="server" value="${advertManagesPaginator.page}"/>
					        <!-- 请求的地址 -->
					        <input type="hidden" id="pageUrl" runat="server" value="${ctx }/advertmanage/list"/>
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
