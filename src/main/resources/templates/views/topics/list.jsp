<%@page language="java" contentType="text/html; charset=UTF-8"%>
<%@ include file="/common/taglibs.jsp"%>
<!DOCTYPE html>
<html lang="en">
<head>
	<link rel="stylesheet" href="${ctx }/css/jquery.fileupload.css">
	<script src="${ctx }/js/page/jqPaginator.min.js" type="text/javascript"></script>
    <link href="${ctx }/css/page/myPage.css" rel="stylesheet" type="text/css" />
</head>
<body>
	<div class="row">
		<div class="col-sm-12">
			<h1 class="page-header">话题管理</h1>
		</div>
	</div>
	<div class="row">
		<div class="col-sm-12">
			<div class="panel panel-default">
				<div class="panel-heading text-right">
					<div class="row" >
					
						<form class="form-inline" action="${ctx }/topics/importopic" method="post" 
							enctype="multipart/form-data">
							<div class="form-group">
							    <div class="input-group">
							      <div class="input-group-addon">国际化语言:</div>
							      <select name="langid" class="form-control">
							      		<option value="-1">请选择</option>
							      	<c:forEach var="language" items="${languagesSort }">
							      		<option value="${language.id}" >${language.hbcode} ${language.cnname}</option>
							      	</c:forEach>	
							      </select>
							    </div>  
							  </div>
							  <div class="form-group"> 
							  		<span class="btn btn-success fileinput-button">
										<span>上传文件</span>
										<input id="fileupload" type="file" name="file" multiple>
									</span>
							  </div>
									<input type="submit" value="导入Excel"/>
									
									
						<a href="${ctx }/topics/exportopic" class="btn btn-primary" id="exce"><span
							class="fa fa-plus-circle fa-fw"></span> 导出国家</a>
							
							<!-- <form class="form-inline" role="form" action="" method="get"> -->
							<input name="page" type="hidden" value="${topicsPaginator.page }"/>
							  <div class="form-group">
							    <div class="input-group">
							      <div class="input-group-addon">话题名称:</div>
							      	<input type="text" name="name" id="name" value="${topic.name}"/>
							    </div>
							  </div>
							
								<input type="button" class="btn btn-primary" value="搜索" onclick="search()"/>
								<a href=" " id ="asearch"></a>
							  <!-- <button type="submit" class="btn btn-primary">搜索 </button> -->&nbsp;&nbsp;
							  <a href="${ctx }/topics/add?tid=0" class="btn btn-primary" id="add"><span
										class="fa fa-plus-circle fa-fw"></span> 添加话题</a>
							
							<!-- </form> -->
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
									<th>话题ID</th>
									<th>话题图标</th>
									<th>话题类型</th>
									<th>话题名称</th>
									<th></th>

								</tr>
							</thead>
							<tbody>
								<c:forEach var="item" items="${topics}">
									<tr class="tid" value="${item.tid }">
										<td>${item.tid}</td>
										<td><img src="${upyunhttp}${item.topicicon }!30" height="30"/></td>
										<td>${item.topictype==0?'Hubii':'自编' }</td>
										<td>${item.name }</td>
										<td>
											<div class="btn-group">
												<a class="btn btn-primary" href="#"><i
													class="icon-wrench icon-white"></i>操作</a> <a
													class="btn btn-primary dropdown-toggle"
													data-toggle="dropdown" href="#"><span class="caret"></span></a>
												<ul class="dropdown-menu">
												
													<li><a href="${ctx }/topics/add?tid=${item.tid}"><i
															class="fa fa-pencil fa-fw"></i>修改</a></li>
												<%-- <c:if test="${item.topictype=='1'}"> 
													<li><a
														href="${ctx }/topics/delete?tid=${item.tid}"><i
															class="fa fa-trash-o fa-fw" ></i>删除</a></li>
												</c:if> --%>
													<li><a
														href="${ctx }/topics/allkeyword?tid=${item.tid}"><i
															class="fa fa-pencil fa-fw" ></i>设置所有国家关键字</a></li>	
													<li><a
														href="${ctx }/globalization/list?objid=${item.tid}&objtype=2"><i
															class="fa fa-pencil fa-fw" ></i>国际化管理</a></li>	
														
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
					        <input type="hidden" id="PageCount" runat="server" value="${topicsPaginator.totalCount}"/>
					        <!-- 总页数 -->
					        <input type="hidden" id="countindex" runat="server" value="${topicsPaginator.totalPages}"/>
					        <!-- 当前第几页 -->
					        <input type="hidden" id="Pagedq" runat="server" value="${topicsPaginator.page}"/>
					        <!-- 请求的地址 -->
					        <input type="hidden" id="pageUrl" runat="server" value="${ctx }/topics/list"/>
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
	
	<script type="text/javascript">
		
		function del(num){
			var url="${ctx}/topics/delete";
			var tid=num;
			$.get(url, {
				"tid" : tid
			}, function(data) {
				window.location.reload();
			});
			
			
		}
		
		
		function search(){
			var url = "${ctx}/topics/list";
			var name = $("#name").val();
			
			//alert("FFF"+name+" "+url+"?name="+name);
			var a= document.getElementById("asearch");
			 a.href = url+"?name="+name;  
			a.click();
		}
		
	
	</script>

</body>
</html>
