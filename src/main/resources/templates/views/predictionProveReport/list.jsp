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
	function ischeck(){
		var flag=false;
		<c:forEach items="${list}" var="item" varStatus="status" >
			if(${item.status}==2){
				flag=true;
			}
		</c:forEach>
		if(flag==true){
			var src="${ctx }"+"/predictionTopic/clearing?id="+"${predictionProveReport.pid}";
			$("#href").attr("href",src);
		}else{
			alert("请审核证明");
		} 
	}
	
</script>
</head>
<body>
	<div class="row">
		<div class="col-sm-12">
			<h1 class="page-header"> 投诉与证明</h1>
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
								   <div class="input-group col-xs-10">
									<div class="input-group-addon">竞猜Id:</div>
									 <input class="form-control" type="text" name="pid" value="${predictionProveReport.pid}"/>
								</div>
							</div>
							<div class="form-group">
								<div class="input-group">
									<div class="input-group-addon">类型:</div>
									<select name="itype" class="form-control "> 
									  <option value="0" <c:if test="${predictionProveReport.itype==0 || predictionProveReport.itype==-1}">selected="selected"</c:if>>用户证明</option>
									  <option value="2" <c:if test="${predictionProveReport.itype==2}">selected="selected"</c:if>>系统证明</option>
									  <option value="1" <c:if test="${predictionProveReport.itype==1}">selected="selected"</c:if>>竞猜举报</option>
									  <option value="3" <c:if test="${predictionProveReport.itype==3}">selected="selected"</c:if>>证明举报</option>
									   <option value="4" <c:if test="${predictionProveReport.itype==4}">selected="selected"</c:if>>应用建议</option>
									</select>
								</div>
							</div>
							<div class="form-group">
								<div class="input-group">
									<div class="input-group-addon">状态:</div>
									<select name="status" class="form-control "> 
									  <option value="0" <c:if test="${predictionProveReport.status==0 || predictionProveReport.status==-1}">selected="selected"</c:if>>未审核</option>
									  <option value="2" <c:if test="${predictionProveReport.status==2}">selected="selected"</c:if>>已选用</option>
									</select>
								</div>
							</div>
							<button type="submit" class="btn btn-primary">搜索</button>
							<a class="btn btn-primary" href="${ctx }/predictionProveReport/add?id=&pid=${pid}&uuid=${uuid}&flag=${flag}" >添加证明</a>
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
									<th>竞猜Id</th>
									<!-- <th>详情</th>
									<th>url</th> -->
									<th>类型</th>
									<th>状态</th>
									<!-- <th>图片</th> -->
									<th>时间</th>
									<!-- <th>sysuid</th> -->
									<th></th>
								</tr>
							</thead>
							<tbody>
								<c:forEach var="item" items="${list}">
									<tr class="id" value="${item.id }">
										<td>${item.id}</td>
										<td>${item.uuid }</td>
										<td>${item.pid }</td>
										<%-- <td>${item.desc }</td>
										<td>${item.urls }</td> --%>
										<td>
										  <c:if test="${item.itype==0}">用户证明</c:if>
										  <c:if test="${item.itype==1}">竞猜举报</c:if>
										  <c:if test="${item.itype==2}">系统证明</c:if>
										  <c:if test="${item.itype==3}">证明举报</c:if>
										   <c:if test="${item.itype==4}">应用建议</c:if>
										</td>
										<td>
										  <c:if test="${item.status==0}">未审核</c:if>
										  <c:if test="${item.status==2}">已选用</c:if>
										  <c:if test="${item.status==1}">删除</c:if>
										</td>
										<%-- <td>
								           <img  src="${upyunhttp }${item.picpath }" style="width: 50px;height: 50px;">
                                        </td> --%>
										<td><fmt:formatDate value="${item.createtime}" type="date" pattern="yyyy-MM-dd HH:mm:ss"/></td>
										<%-- <td>${item.sysuid}</td> --%>
										 <td>
										 <div class="btn-group">
												<a class="btn btn-primary" href="#"><i
													class="icon-wrench icon-white"></i>操作</a> <a
													class="btn btn-primary dropdown-toggle"
													data-toggle="dropdown" href="#"><span class="caret"></span></a>
												<ul class="dropdown-menu">
                                                    <li><a href="${ctx }/predictionProveReport/detail?id=${item.id}"><i
															class="fa fa-pencil fa-fw"></i>查看详情</a></li> 
													 <li><a href="${ctx }/predictionProveReport/add?id=${item.id}&flag=${flag}"><i
															class="fa fa-pencil fa-fw"></i>修改</a></li> 
														 <li><a href="${ctx }/predictionProveReport/delete?id=${item.id}&itype=${item.itype}&pid=${pid}&flag=${flag}"><i
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
					        <input type="hidden" id="PageCount" runat="server" value="${pageUtil.recordCount}"/>
					        <!-- 总页数 -->
					        <input type="hidden" id="countindex" runat="server" value="${pageUtil.pagecount}"/>
					        <!-- 当前第几页 -->
					        <input type="hidden" id="Pagedq" runat="server" value="${pageUtil.currentPage}"/>
					        <!-- 请求的地址 -->
					        <input type="hidden" id="pageUrl" runat="server" value="${ctx }/predictionProveReport/list"/>
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
	<c:if test="${flag!=null && flag==1 }">
   <div class="row">
		<div class="col-sm-12" align="left">
			<table class="table table-striped table-bordered table-hover" id="dataTables-example">
							<tr>
							  <td>	
							       <a class="btn btn-primary" id="href" href="" onclick="ischeck()">
			                                                                             去结算  
		                            </a>
		                       </td>
							</tr>
			</table>
		</div>
	</div>
	</c:if>
</body>
</html>
