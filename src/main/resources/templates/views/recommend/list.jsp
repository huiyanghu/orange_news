<%@page language="java" contentType="text/html; charset=UTF-8"%>
<%@ include file="/common/taglibs.jsp"%>
<!DOCTYPE html>
<html lang="en">
<head>
	<script src="${ctx }/js/page/jqPaginator.min.js" type="text/javascript"></script>
    <link href="${ctx }/css/page/myPage.css" rel="stylesheet" type="text/css" />
	<script type="text/javascript" src="${ctx }/js/plugins/My97DatePicker/WdatePicker.js"></script>
</head>
<body>
	<div class="row">
		<div class="col-sm-12">
			<h1 class="page-header">推荐管理</h1>
		</div>
	</div>
	<div class="row">
		<div class="col-sm-12">
			<div class="panel panel-default">
				<div class="panel-heading text-right">
					<div class="row">
							<form class="form-inline" role="form" action="" method="get">
							<input name="page" type="hidden" value="1"/>
							国家的推送次数：<input type="text" value="${num}" style="width:30px"/>
							  <div class="form-group">
							    <div class="input-group">
							      <div class="input-group-addon">国家:</div>
								      <select name="countrycode" class="form-control">
								      		<option value="-1">请选择</option>
								      	<c:forEach var="country" items="${countrysSort }">
								      		<option value="${country.code}" <c:if test="${pushInfo.countrycode==country.code }">selected</c:if>>${country.code} ${country.cnname}</option>
								      	</c:forEach>	
								      </select>
							    </div>
							  </div>
							  <div class="form-group">
							    <div class="input-group">
							      <div class="input-group-addon">开始日期:</div>
							      <input class="form-control" name="starttime" type="text" placeholder="输入发布时间" onClick="WdatePicker()" value="${pushInfo.starttime }">
							    </div>
							  </div>
							 <div class="form-group">
							    <div class="input-group">
							      <div class="input-group-addon">结束日期:</div>
							      <input class="form-control" name="endtime" type="text" placeholder="输入发布时间" onClick="WdatePicker()"  value="${pushInfo.endtime }">
							    </div>
							  </div>
							  <button type="submit" class="btn btn-primary">搜索 </button>&nbsp;&nbsp;
							  
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
									<th>文章标题</th>
									<th>文章类型</th>
									<th>国家</th>
									<th>发布时间</th>
									<th>推送状态</th>
									<th>推送时间</th>
									<th>推送时间</th> 
									<th></th>
								</tr>
							</thead>
							<tbody>
								<c:forEach var="item" items="${recommendarticles}">
									<tr class="id" value="${item.id }">
										<td><a href="http://www.coolook.top/article/${item.id }.html"  target="_blank">${item.title}</a></td>
										<td><coolook:status type="15" value="${item.attr}"/></td>
										<td>${item.countrycode}</td>
										<td><fmt:formatDate value="${item.createtime}" type="both" pattern="yyyy-MM-dd HH:mm:ss"/></td>
										<td><c:if test="${item.status==1 }">推送中</c:if>
											<c:if test="${item.status==2 }">已推送</c:if>
											<c:if test="${item.status==3 }">android失败</c:if>
											<c:if test="${item.status==4 }">ios失败</c:if>
											<c:if test="${item.status==7 }">android,ios失败</c:if>
											<c:if test="${item.status==0}">未推送</c:if>
										</td>
										<td><fmt:formatDate value="${item.pushtime}" type="both" pattern="yyyy-MM-dd HH:mm:ss"/></td>
										<td>
											<div class="btn-group">
												<a class="btn btn-primary" href="#"><i
													class="icon-wrench icon-white"></i>操作</a> <a
													class="btn btn-primary dropdown-toggle"
													data-toggle="dropdown" href="#"><span class="caret"></span></a>
												<ul class="dropdown-menu">
												<c:if test="${item.status !=2 }">
													<li><a href="${ctx }/recommend/add?id=${item.id}"><i
															class="fa fa-pencil fa-fw"></i>推送</a></li>
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
					        <input type="hidden" id="PageCount" runat="server" value="${pageUtil.recordCount}"/>
					        <!-- 总页数 -->
					        <input type="hidden" id="countindex" runat="server" value="${pageUtil.pagecount}"/>
					        <!-- 当前第几页 -->
					        <input type="hidden" id="Pagedq" runat="server" value="${pageUtil.currentPage}"/>
					        <!-- 请求的地址 -->
					        <input type="hidden" id="pageUrl" runat="server" value="${ctx }/recommend/list"/>
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
