<%@page language="java" contentType="text/html; charset=UTF-8"%>
<%@ include file="/common/taglibs.jsp"%>
<!DOCTYPE html>
<html lang="en">
<head>
<script type="text/javascript" src="${ctx }/js/plugins/My97DatePicker/WdatePicker.js"></script>
<script type="text/javascript">
function checkAllBox(obj){
	 var answer= document.getElementsByName("checkbox");
	 if(obj.checked==true){
	  for(var i=0;i<answer.length;i++){
	   answer[i].checked = true;
	  }
	 }else{
	  for(var i=0;i<answer.length;i++){
	   answer[i].checked = false;
	  }
	 }
}
function passlist(){
	 var ids=""; 
	 var answer= document.getElementsByName("checkbox");
	 for(var i=0;i<answer.length;i++){
		 if(answer[i].checked == true){
			 ids=ids+$(answer[i]).val()+",";
		 }
	}
	 if(ids==null||ids==""){
		 alert("请选择要批量发布的锁屏文章");
		 return;
	 }
	 if(confirm("确定要批量发布吗?")){
	 	var href="${ctx }/screen/publishlist?ids=";
		href=href+ids;
		$("#passlist").attr("href",href); 
	 }else{
		 return;
	 }
	
	
}

</script>
</head>
<body>
	<div class="row">
		<div class="col-sm-12">
			<h1 class="page-header"><coolook:status type="2" value="${applockscreen.countryid }"/> 锁屏管理</h1>
		</div>
	</div>
	<div class="row">
		<div class="col-sm-12">
			<div class="panel panel-default">
				<div class="panel-heading text-right">
					
					<div class="row">
							<form class="form-inline" role="form" action="" method="get">
							<input name="page" type="hidden" value="${applockscreensPaginator.page }"/>
							  <div class="form-group">
							    <div class="input-group">
							      <div class="input-group-addon">国家名称:</div>
							      <select name="countrycode" class="form-control">
							      		<option value="">请选择</option>
							      		<c:forEach var="uitem" items="${countrysSort }">
							      			<option value="${uitem.code }" <c:if test="${applockscreen.countrycode ==uitem.code }">selected</c:if>>${uitem.code} ${uitem.cnname }</option>
							      		</c:forEach>
							      </select>
							    </div>
							  </div>
							  <div class="form-group">
							    <div class="input-group">
							      <div class="input-group-addon">日期:</div>
							      <input class="form-control" name="starttime" type="text" placeholder="输入开始日期"  value="${applockscreen.starttime }" onClick="WdatePicker()"/>
							    </div>
							  </div>
							   <div class="form-group">
							    <div class="input-group">
							      <div class="input-group-addon">状态:</div>
							      <select name="isshow" class="form-control">
							      		<option value="-1" ${applockscreen.isshow==-1?"selected":"" }>所有</option>
							      		<option value="0" ${applockscreen.isshow==0?"selected":"" }>未审核</option>
							      		<option value="1" ${applockscreen.isshow==1?"selected":"" }>已发布</option>
							      </select>
							    </div>
							  </div>
							  <button type="submit" class="btn btn-primary">搜索 </button>&nbsp;&nbsp;
							 <%--  <a href="${ctx }/screen/add?id=0&countryid=${applockscreen.countryid }" class="btn btn-primary" id="add"><span
							class="fa fa-plus-circle fa-fw"></span> 添加锁屏</a>&nbsp;&nbsp; --%>
							
							</form>
						</div>
					
				</div>
				<!-- /.panel-heading -->
				<form action="${ctx }/screen/updaterank" method="post">
				<input type="hidden" name="countrycode" value="${applockscreen.countrycode }">
				<input type="hidden" name="starttime" value="${applockscreen.starttime }">
				<input type="hidden" name="isshow" value="${applockscreen.isshow }">
				<div class="panel-heading text-left">
						<div class="row">
						&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
						<input type="checkbox" id="checkbox" onclick="checkAllBox(this);"/>&nbsp;&nbsp;&nbsp;&nbsp;
						<a href="" class="btn btn-primary" id="passlist" onclick="passlist();"><span
							class="fa fa-plus-circle fa-fw"></span> 批量发布</a>&nbsp;&nbsp;
						</div>
				</div>
				
				<div class="panel-body">
					<div class="table-responsive">
						<table class="table table-striped table-bordered table-hover"
							id="dataTables-example">
							<thead>
								<tr>
								   <th></th>
									<th>ID</th>
									<th>图片</th>
									<th>类型</th>
									<th>标题</th>
									<th>国家</th>
									<th>发布日期</th>
									<th>发布人</th>
									<th>是否显示</th>
									<th>排序</th>
									<th></th>
								</tr>
							</thead>
							<tbody>
								<c:forEach var="item" items="${applockscreens}">
									<tr class="id" value="${item.id }">
											<td><input type="checkbox" name="checkbox"
												value="${item.id }" /></td>
											<td>${item.id }</td>
										<td><img src="${upyunhttp }${item.img}!30"/></td>
										<td>
											<c:if test="${item.type==1}">文章锁屏</c:if>
											<c:if test="${item.type==2}">广告锁屏</c:if>
										</td>
										<td>${item.title}</td>
										<td>
										<c:if test="${item.countrycode=='00'}">所有国家</c:if>
										<c:if test="${item.countrycode!='00'}">${item.countrycode}</c:if>
										</td>
										<%-- <fmt:parseDate value="${item.datatime}" var="pubtime" pattern="yyyy-MM-dd HH:mm:ss"/> --%>
										<td><fmt:formatDate value="${item.datatime }" type="both" pattern="MM-dd HH:mm"/></td>
										<td><coolook:status type="1" value="${item.createuid }"/></td>
										<td>${item.isshow==0?"发布":"未发布"}</td>
										<td><input type="text" name="${item.id }" value="${item.rank }" size="1"></td>
										<td>
											<div class="btn-group">
												<a class="btn btn-primary" href="#"><i
													class="icon-wrench icon-white"></i>操作</a> <a
													class="btn btn-primary dropdown-toggle"
													data-toggle="dropdown" href="#"><span class="caret"></span></a>
												<ul class="dropdown-menu">
												
													<li><a href="${ctx }/screen/add?id=${item.id}&countryid=${applockscreen.countryid }"><i
															class="fa fa-pencil fa-fw"></i>修改</a></li>
													<li><a
														href="${ctx }/screen/delete?id=${item.id}&countryid=${applockscreen.countryid }"><i
															class="fa fa-trash-o fa-fw" ></i>删除</a></li>
													<li><a
														href="${ctx }/screen/publish?id=${item.id}&countryid=${applockscreen.countryid }"><i
															class="fa fa-pencil fa-fw" ></i>发布</a></li>
												</ul>
											</div>

										</td>
									</tr>
								</c:forEach>
							</tbody>
						</table>
						<div style = "text-align:right;">
						<button type="submit" class="btn btn-primary" style="">更新排序 </button>
						</div>
						<%-- <div class="row">
							<div class="col-sm-12 text-center">
									<ul class="pagination">
										<li>
											<a href="#">当前：${applockscreensPaginator.page}页，总共:${applockscreensPaginator.totalCount}条,总页数:${applockscreensPaginator.totalPages }页</a>
										</li>
										<c:if test="${applockscreensPaginator.page>1}">
											<li><a href="${ctx }/screen/list?page=${applockscreensPaginator.prePage}${searchstr}">上一页</a></li>
										</c:if>
										
										<c:if test="${applockscreensPaginator.page<applockscreensPaginator.totalPages}">
											<li><a href="${ctx }/screen/list?page=${applockscreensPaginator.nextPage}${searchstr}">下一页</a></li>
										</c:if>

									</ul>
							</div>
						</div> --%>
					</div>
				</div>
				</form>
			</div>
		</div>
	</div>
</body>
</html>
