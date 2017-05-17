<%@page language="java" contentType="text/html; charset=UTF-8"%>
<%@ include file="/common/taglibs.jsp"%>
<!DOCTYPE html>
<html lang="en">
<head>
	<script src="${ctx }/js/page/jqPaginator.min.js" type="text/javascript"></script>
    <link href="${ctx }/css/page/myPage.css" rel="stylesheet" type="text/css" />
<script type="text/javascript">
	function changeStatus(tagid,topicid,ttid,status,userid,obj){
		$.ajax({
				type:
				"GET",
				async:true,
				dataType: 'json',//${ctx }/contags/updateTrainTagStatus?tagid=${item.id}&ttid=${item.topicid }&status=${item.status }&userid=${item.updateuid }
				url:"${ctx }/contags/updateTrainTagStatus",
				data: { //发送给数据库的数据
					tagid:tagid,
					topicid:topicid,
					ttid:ttid,
					status:status,
					userid:userid},	
				success: 
					function(data) {
						if(data.status==0){
							var $status=$(obj).parent().parent().parent().parent().parent().find('.status');
							var statusText=$(obj).find('i').html();
							if($.trim(statusText)=="激活"){
								$status.html("激活");
							}else if($.trim(statusText)=="禁用"){
								$status.html("禁用");
							}else if($.trim(statusText)=="未审核"){
								$status.html("未审核");
							}
							$("#items"+ttid).remove();
						}else{
							alert("更改状态失败");
						} 
					},
				});
	}
	
	function get2topic(){
		$.ajax({
			type:
			"GET",
			async:true,
			dataType: 'json',
			url:"${ctx }/contags/get2topic",
			data: { //发送给数据库的数据
				ptid:$("#ptid").val()
				},	
			success: 
				function(data) {
					if(data.status==0){
					  var list=data.ctopics;
					  var selOpt = $("#ctid option");
                      selOpt.remove();
                      $("#ctid").append("<option value=''>请选择</option>");
						for(var i=0;i<list.length;i++){
							$("#ctid").append("<option value='"+list[i].tid+"'>"+list[i].topicname+"</option>");
						}
					}
				},
			});
		
		
		
	}
	
</script>
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
						   <c:if test="${conTagsTopicsPaginator.page == null }">
						       <input name="page" type="hidden" value="1" />
						   </c:if>
						   <c:if test="${conTagsTopicsPaginator.page != null }">
						       <input name="page" type="hidden" value="${conTagsTopicsPaginator.page }" />
						   </c:if>
							
							<div class="form-group">
								<%-- <div class="input-group">
							      <div class="input-group-addon">国家:</div>
							      	<select name="countrycode" class="form-control">
							      		<option value="">请选择</option>
							      		<c:forEach var="country" items="${countrys }">
							      			<option value="${country.code }" <c:if test="${country.code ==conTagsTopics.countrycode }">selected</c:if>>${country.cnname }</option>
							      		</c:forEach>
							      	</select>
							   	  </div> --%>

								<div class="input-group">
									<div class="input-group-addon">状态:</div>
									<select name="status" class="form-control">
										<option value="" selected>请选择</option>
										<option value="0" <c:if test="${conTagsTopic.status eq 0}">selected</c:if>>正确</option>
										<option value="-1" <c:if test="${conTagsTopic.status eq -1}">selected</c:if>>错误</option>
										<option value="1" <c:if test="${conTagsTopic.status eq 1}">selected</c:if>>未审核</option>
									</select>
								</div>
								<div class="input-group">
									<div class="input-group-addon">一级分类:</div>
									<select name="ptid" id="ptid" onchange="return get2topic();" class="form-control">
										<option value="">请选择</option>
										<c:forEach var="item" items="${ptopics }">
											<!-- <c:if test="${conTagsTopic.status eq 0}">selected</c:if> -->
											<option value="${item.tid }" <c:if test="${pid eq item.tid }">selected</c:if>>${item.topicname}</option>
										</c:forEach>
									</select>
								</div>

								<div class="input-group">
									<div class="input-group-addon">二级分类:</div>
									<select name="ctid" id="ctid" class="form-control">
										<option value="">请选择</option>
										<c:forEach var="item" items="${ctopics }">
											<!-- <c:if test="${conTagsTopic.status eq 0}">selected</c:if> -->
											<option value="${item.tid }" <c:if test="${conTagsTopic.topicid eq item.tid }">selected</c:if>>${item.topicname}</option>
										</c:forEach>
									</select>
								</div>
							</div>

							<button type="submit" class="btn btn-primary">搜索</button>
							&nbsp;&nbsp;
						</form>
					</div>
				</div>
				<!-- /.panel-heading -->
				<div class="panel-body">
					<div class="table-responsive">
						<table class="table table-striped table-bordered table-hover" id="dataTables-example">
							<thead>
								<tr>
									<th>ID</th>
									<th>二级分类</th>
									<th>标签名称</th>
									<th>更新时间</th>
									<th>操作人</th>
									<th>状态</th>
									<th>操作</th>
								</tr>
							</thead>
							<tbody>
								<c:forEach var="item" items="${conTagsTopics}">
									<tr class="id" value="${item.id }" id="items${item.id }">
										<td>${item.id }</td>
										<td>${item.topicname }</td>
										<td>${item.tagname }</td>
										<td>${item.updatetime }</td>
										<td><coolook:status type="1" value="${item.updateuid }" /></td>
										<td class="status"><c:if test="${item.status ==0 }">正确</c:if> <c:if test="${item.status ==1 }">未审核</c:if> <c:if test="${item.status ==-1 }">错误</c:if></td>
										<td>
											<a href="#" class="btn btn-primary" onclick="changeStatus(${item.tagid },${item.topicid },${item.id},0,${item.updateuid },this)">正确</a>
											<a href="#" class="btn btn-danger" onclick="changeStatus(${item.tagid },${item.topicid },${item.id},-1,${item.updateuid },this)">错误</a>
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
					        <input type="hidden" id="PageCount" runat="server" value="${conTagsTopicsPaginator.totalCount}"/>
					        <!-- 总页数 -->
					        <input type="hidden" id="countindex" runat="server" value="${conTagsTopicsPaginator.totalPages }"/>
					        <!-- 当前第几页 -->
					        <input type="hidden" id="Pagedq" runat="server" value="${conTagsTopicsPaginator.page}"/>
					        <!-- 请求的地址 -->
					        <input type="hidden" id="pageUrl" runat="server" value="${ctx }/contags/listtrain"/>
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
