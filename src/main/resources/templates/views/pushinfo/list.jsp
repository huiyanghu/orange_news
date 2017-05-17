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
			<h1 class="page-header">文章推送历史管理</h1>
		</div>
	</div>
	<div class="row">
		<div class="col-sm-12">
			<div class="panel panel-default">
				<div class="panel-heading text-left">
					<div class="row">
					<form class="form-inline" role="form" action="" method="get">
							<input name="page" type="hidden" value="1"/>
							  <div class="input-group">
							      <div class="input-group-addon">国家:</div>
							      	<select name="cid" class="form-control">
							      		<option value="0">请选择</option>
							      		<c:forEach var="appPushInfo" items="${pushinfolistSort }">
							      			<option value="${appPushInfo.cid }" <c:if test="${bean.cid ==appPushInfo.cid }">selected</c:if>>${appPushInfo.code }  ${appPushInfo.cnname }</option>
							      		</c:forEach>
							      	</select>
							   	  </div>
							<div class="form-group">
							    <div class="input-group">
							      <div class="input-group-addon">文章ID:</div>
								      	<input class="form-control"  type="text" name="articleid" value="${bean.articleid}"/>
							   	  </div>
							   </div>
							    
							   <div class="form-group">
							    <div class="input-group">
							      <div class="input-group-addon">状态:</div>
								      	<select name="status" class="form-control ">
									      		<option value="-1">请选择</option>
									      		<option value="0" <c:if test="${bean.status==0 }">selected</c:if>>未推送</option>
									      		<option value="1" <c:if test="${bean.status==1 }">selected</c:if>>推送中</option>
									      		<option value="2" <c:if test="${bean.status==2 }">selected</c:if>>已推送</option>
									      		<option value="3" <c:if test="${bean.status==3 }">selected</c:if>>android推送失败</option>
									      		<option value="4" <c:if test="${bean.status==4 }">selected</c:if>>ios推送失败</option>
									      		<option value="5" <c:if test="${bean.status==5 }">selected</c:if>>android新渠道推送失败</option>
									      		<option value="7" <c:if test="${bean.status==5 }">selected</c:if>>android和ios推送失败</option>
									      </select>
							   	  </div>
							   </div>
							  
							  <div class="form-group">
							    <div class="input-group">
							      <div class="input-group-addon">开始日期:</div>
							      <input class="form-control" name="starttime" type="text" placeholder="输入开始日期" onClick="WdatePicker()" value="${bean.starttime }">
							    </div>
							  </div>
							 <div class="form-group">
							    <div class="input-group">
							      <div class="input-group-addon">结束日期:</div>
							      <input class="form-control" name="endtime" type="text" placeholder="输入结束时间" onClick="WdatePicker()"  value="${bean.endtime }">
							    </div>
							  </div>
							  <button type="submit" class="btn btn-primary">搜索 </button>&nbsp;&nbsp;
							
						</form>
				</div>
				<!-- /.panel-heading -->
				<div class="panel-body">
					<div class="table-responsive">
						<table class="table table-striped table-bordered table-hover"
							id="dataTables-example">
							<thead>
								<tr>
									<th>ID</th>
									<th>国家</th>
									<th>文章ID</th>
									<th>标题</th>
									<th>状态</th>
									<th>推送时间</th>
									<th>推送编号</th>
									<th></th>
								</tr>
							</thead>
							<tbody>
								<c:forEach var="pushinfo" items="${appPushInfos}">
									<tr>
										<td>${pushinfo.id }</td>
										<td>
											<c:forEach var="appPushInfo" items="${pushinfolistSort }">
								      			<c:if test="${pushinfo.cid ==appPushInfo.cid }">${appPushInfo.cnname }</c:if>
								      		</c:forEach>
										</td>
										<td>
										${pushinfo.articleid}
										<%-- <c:if test="${fn:startsWith(pushinfo.articleid, 'v2')==true }">
										  ${fn:substring(pushinfo.articleid, 2, fn:length{pushinfo.articleid})  }
										</c:if>
										<c:if test="${fn:startsWith(pushinfo.articleid, 'v2')==false }">
											${pushinfo.articleid}
										</c:if> --%>
									  </td>
										<td>${pushinfo.title}</td>
										<td>
								      		<c:if test="${pushinfo.status ==0 }">未推送</c:if>
								      		<c:if test="${pushinfo.status ==1 }">推送中</c:if>
								      		<c:if test="${pushinfo.status ==2 }">已推送</c:if>
								      		<c:if test="${pushinfo.status ==3 }">android推送失败</c:if>
								      		<c:if test="${pushinfo.status ==4 }">ios推送失败</c:if>
								      		<c:if test="${pushinfo.status ==5 }">android新渠道推送失败</c:if>
								      		<c:if test="${pushinfo.status ==7 }">android和ios推送失败</c:if>
										</td>
										<td>${pushinfo.pushtime}</td>
										<td>${pushinfo.pushnum}</td>
										<td>
											<div class="btn-group">
												<a class="btn btn-primary" href="#"><i
													class="icon-wrench icon-white"></i>操作</a> <a
													class="btn btn-primary dropdown-toggle"
													data-toggle="dropdown" href="#"><span class="caret"></span></a>
												<ul class="dropdown-menu">
												
													<li><a href="${ctx }/pushinfo/add?id=${pushinfo.id}"><i
															class="fa fa-pencil fa-fw"></i>修改</a></li>
													<li><a
														href="${ctx }/pushinfo/delete?id=${pushinfo.id}"><i
															class="fa fa-trash-o fa-fw" ></i>删除</a></li>
													<li>
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
					        <input type="hidden" id="PageCount" runat="server" value="${appPushInfosPaginator.totalCount}"/>
					        <!-- 总页数 -->
					        <input type="hidden" id="countindex" runat="server" value="${appPushInfosPaginator.totalPages}"/>
					        <!-- 当前第几页 -->
					        <input type="hidden" id="Pagedq" runat="server" value="${appPushInfosPaginator.page}"/>
					        <!-- 请求的地址 -->
					        <input type="hidden" id="pageUrl" runat="server" value="${ctx }/pushinfo/list"/>
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
	
</body>
</html>
