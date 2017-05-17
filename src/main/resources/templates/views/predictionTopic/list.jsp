<%@page language="java" contentType="text/html; charset=UTF-8"%>
<%@ include file="/common/taglibs.jsp"%>
<!DOCTYPE html>
<html lang="en">
<head>
	<script src="${ctx }/js/page/jqPaginator.min.js" type="text/javascript"></script>
    <link href="${ctx }/css/page/myPage.css" rel="stylesheet" type="text/css" />
<script type="text/javascript"
	src="${ctx }/js/plugins/My97DatePicker/WdatePicker.js"></script>
<script type="text/javascript">
function checkTitleAndPic(id,title,titlepic){
	if(title.trim() == "" || title.trim() == null){
		if(confirm("标题为空,要继续添加置顶图吗?")){
			
			if(titlepic.trim() == "" || titlepic.trim() == null){
				if(confirm("标题图片为空,要继续添加置顶图吗?")){
					window.location.href = '${ctx }/predictionTopic/addtoapptop?ids='+id+
					'&id=${predictionTopic.id}&title=${predictionTopic.title}'+
					'&status=${predictionTopic.status}&starttime=${param.starttime}'+
					'&endtime=${param.endtime}';
				}else{
					return false;
				}
			}
			window.location.href = '${ctx }/predictionTopic/addtoapptop?ids='+id+
			'&id=${predictionTopic.id}&title=${predictionTopic.title}'+
			'&status=${predictionTopic.status}&starttime=${param.starttime}'+
			'&endtime=${param.endtime}';
		}
	}else if(titlepic.trim() == "" || titlepic.trim() == null){
		if(confirm("标题图片为空,要继续添加置顶图吗?")){
			window.location.href = '${ctx }/predictionTopic/addtoapptop?ids='+id+
			'&id=${predictionTopic.id}&title=${predictionTopic.title}'+
			'&status=${predictionTopic.status}&starttime=${param.starttime}'+
			'&endtime=${param.endtime}';
		}else{
			return false;
		}
	}else{
		window.location.href = '${ctx }/predictionTopic/addtoapptop?ids='+id+
		'&id=${predictionTopic.id}&title=${predictionTopic.title}'+
		'&status=${predictionTopic.status}&starttime=${param.starttime}'+
		'&endtime=${param.endtime}';
	}

}
</script>
</head>
<body>
	<div class="row">
		<div class="col-sm-12">
			<h1 class="page-header">竞猜管理</h1>
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
									<div class="input-group-addon">竞猜Id:</div>
									<input class="form-control" type="text" name="id" value="${predictionTopic.id}" />
								</div>
							</div>
							<div class="form-group">
								<div class="input-group">
									<div class="input-group-addon">标题:</div>
									<input class="form-control" type="text" name="title" value="${predictionTopic.title}" />
								</div>
							</div>
							<div class="form-group">
								<div class="input-group">
									<div class="input-group-addon">状态:</div>
									<select name=status class="form-control ">
									    <option value="-1" 
										<c:if test="${predictionTopic.status==-1 }">selected="selected"</c:if>>请选择
										</option>
										<option value="1" 
										<c:if test="${predictionTopic.status==1 }">selected="selected"</c:if>>未激活
										</option>
										<option value="0" 
										<c:if test="${predictionTopic.status==0 }">selected="selected"</c:if>>正常
										</option>
										<option value="2" 
										<c:if test="${predictionTopic.status==2 }">selected="selected"</c:if>>结束
										</option>
										<option value="3" 
										<c:if test="${predictionTopic.status==3 }">selected="selected"</c:if>>结算
										</option>
										<option value="4" 
										<c:if test="${predictionTopic.status==4 }">selected="selected"</c:if>>已失效
										</option>
									</select>
								</div>
							</div>
							  <div class="form-group">
							    <div class="input-group">
							      <div class="input-group-addon">开始日期:</div>
							    <fmt:formatDate var="starttime_format" value="${predictionTopic.starttime}" type="date" pattern="yyyy-MM-dd HH:mm:ss"/>
							      <input class="form-control" name="starttime" type="text" placeholder="输入开始日期" onClick="WdatePicker({dateFmt:'yyyy-MM-dd HH:mm:ss'})" value="${starttime_format }">
							    </div>
							  </div>
							 <div class="form-group">
							    <div class="input-group">
							      <div class="input-group-addon">结束日期:</div>
							      <fmt:formatDate var="endtime_format" value="${predictionTopic.endtime}" type="date" pattern="yyyy-MM-dd HH:mm:ss"/>
							      <input class="form-control" name="endtime" type="text" placeholder="输入结束时间" onClick="WdatePicker({dateFmt:'yyyy-MM-dd HH:mm:ss'})"  value="${endtime_format}">
							    </div>
							  </div>
							<button type="submit" class="btn btn-primary">搜索</button>
							<%-- <a class="btn btn-primary" href="${ctx }/predictionTopic/add?id=">添加</a> --%>
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
									<th>标题</th>
									<th>开始时间</th>
									<th>结束时间</th>
									<th>关键词</th>
									<th>文章ID</th>
									<th>状态</th>
									<th>创建时间</th>
									<th></th>
								</tr>
							</thead>
							<tbody>
								<c:forEach var="item" items="${list}">
									<tr class="id" value="${item.id }">
										<td>${item.id}</td>
										<td>${item.uuid }</td>
										<td>${item.title }</td>
										<td>
										<fmt:formatDate value="${item.starttime}" type="date" pattern="yyyy-MM-dd HH:mm:ss"/>
										</td>
										<td>
										<fmt:formatDate value="${item.endtime}" type="date" pattern="yyyy-MM-dd HH:mm:ss"/>
										</td>
										<td>${item.keywords}</td>
										<td>${item.articleid}</td>
										<td>
										<c:if test="${item.status==0 }">正常</c:if>
										<c:if test="${item.status==1 }">未激活</c:if>
										<c:if test="${item.endtime<=date && item.status==2}">结束</c:if>
										<c:if test="${item.status==3}">结算</c:if>
										<c:if test="${item.status==4}">失效</c:if>
										</td>
										<td>
										<fmt:formatDate value="${item.createtime}" type="date" pattern="yyyy-MM-dd HH:mm:ss"/>
										</td>
										<td>
										 <div class="btn-group">
												<a class="btn btn-primary" href="#"><i
													class="icon-wrench icon-white"></i>操作</a> <a
													class="btn btn-primary dropdown-toggle"
													data-toggle="dropdown" href="#"><span class="caret"></span></a>
												<ul class="dropdown-menu">
												          <%--  <c:if test="${item.status != 3 }"> --%>
													        <li><a href="${ctx }/predictionTopic/add?id=${item.id}"><i
															class="fa fa-pencil fa-fw"></i>修改</a>
															</li>
															<%-- </c:if> --%>
															<li>
															   <a href="${ctx }/predictionTopic/details?id=${item.id}">
															      <i class="fa fa-pencil fa-fw"></i>查看详情
															   </a>
															</li>
															<li>
															   <a href="${ctx }/predictionProveReport/list?pid=${item.id}&itype=0" target="_blank">
															     <i class="fa fa-pencil fa-fw"></i>查看证明
															   </a>
															</li> 
															 <c:if test="${item.endtime<=date && item.status!=3}"> 
															<li>
															    <a href="${ctx }/predictionProveReport/list?pid=${item.id}&flag=1&uuid=${item.uuid}">
															       <i class="fa fa-pencil fa-fw"></i>结算
															    </a>
														    </li>
														 </c:if> 
														    <li>
															   <a href="${ctx }/predictionProveReport/list?pid=${item.id}&itype=1" target="_blank">
															     <i class="fa fa-pencil fa-fw"></i>查看投诉
															   </a>
															</li> 
															<c:if test="${item.status==3}">
															<li>
															   <a href="${ctx }/predictionTopic/result?id=${item.id}">
															     <i class="fa fa-pencil fa-fw"></i>查看结果
															   </a>
															</li>
															</c:if>
															<li>
															   <a onclick="return checkTitleAndPic('${item.id}','${item.title}','${item.titlepic}')">
															      <i class="fa fa-pencil fa-fw"></i>添加到置顶图
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
					        <input type="hidden" id="PageCount" runat="server" value="${pageUtil.recordCount}"/>
					        <!-- 总页数 -->
					        <input type="hidden" id="countindex" runat="server" value="${pageUtil.pagecount}"/>
					        <!-- 当前第几页 -->
					        <input type="hidden" id="Pagedq" runat="server" value="${pageUtil.currentPage}"/>
					        <!-- 请求的地址 -->
					        <input type="hidden" id="pageUrl" runat="server" value="${ctx }/predictionTopic/list"/>
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
