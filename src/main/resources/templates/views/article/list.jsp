<%@page language="java" contentType="text/html; charset=UTF-8"%>
<%@ include file="/common/taglibs.jsp"%>
<!DOCTYPE html>
<html lang="en">
<head>
<script src="${ctx }/js/jquery-1.11.0.js" type="text/javascript"></script>
<script src="${ctx }/js/page/jqPaginator.min.js" type="text/javascript"></script>
<link href="${ctx }/css/page/myPage.css" rel="stylesheet" type="text/css" />
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
function deletelist(){
	 var ids=""; 
	 var answer= document.getElementsByName("checkbox");
	 for(var i=0;i<answer.length;i++){
		 if(answer[i].checked == true){
			 ids=ids+$(answer[i]).val()+",";
		 }
	 }
	 if(ids==null||ids==""){
		 alert("请选择要删除的文章");
		 return;
	 }
	var href="${ctx }/article/deletelist?ids=";
	href=href+ids;
	$("#deletelist").attr("href",href);
	
	
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
		 alert("请选择要批量发布的国际化语言:文章");
		 return;
	 }
	 if(confirm("确定要批量发布吗?")){
		var href="${ctx }/article/passlist?ids=";
		href=href+ids;
		$("#passlist").attr("href",href);
	 }else{
		 return;
	 }
	
	
}


	function checkTitleAndPic(id,title,titlepic){
		if(title.trim() == "" || title.trim() == null){
			if(confirm("标题为空,要继续添加置顶图吗?")){
				
				if(titlepic.trim() == "" || titlepic.trim() == null){
					if(confirm("标题图片为空,要继续添加置顶图吗?")){
						window.location.href = '${ctx }/article/addtoapptop?ids='+id+'&id=${article.id}'
								+'&countrycode=${article.countrycode}&publicationid=${article.publicationid}'+
								'&channelid=${article.channelid}&langid=${article.langid}&status=${status}'+
								'&keywords=${article.keywords}&topicid=${article.topicsid}&starttime=${article.starttime}'+
								'&endtime=${article.endtime}';
					}else{
						return false;
					}
				}
				window.location.href = '${ctx }/article/addtoapptop?ids='+id+'&id=${article.id}'
				+'&countrycode=${article.countrycode}&publicationid=${article.publicationid}'+
				'&channelid=${article.channelid}&langid=${article.langid}&status=${status}'+
				'&keywords=${article.keywords}&topicid=${article.topicsid}&starttime=${article.starttime}'+
				'&endtime=${article.endtime}';
			}
		}else if(titlepic.trim() == "" || titlepic.trim() == null){
			if(confirm("标题图片为空,要继续添加置顶图吗?")){
				window.location.href = '${ctx }/article/addtoapptop?ids='+id+'&id=${article.id}'
				+'&countrycode=${article.countrycode}&publicationid=${article.publicationid}'+
				'&channelid=${article.channelid}&langid=${article.langid}&status=${status}'+
				'&keywords=${article.keywords}&topicid=${article.topicsid}&starttime=${article.starttime}'+
				'&endtime=${article.endtime}';
			}else{
				return false;
			}
			
		}else{
			window.location.href = '${ctx }/article/addtoapptop?ids='+id+'&id=${article.id}'
			+'&countrycode=${article.countrycode}&publicationid=${article.publicationid}'+
			'&channelid=${article.channelid}&langid=${article.langid}&status=${status}'+
			'&keywords=${article.keywords}&topicid=${article.topicsid}&starttime=${article.starttime}'+
			'&endtime=${article.endtime}';
		}
	}
		

function gettopicsbycountry(){
	if($("#countrycode").val().trim().length==0){
		return;
	}
	var param={};
	param.code=$("#countrycode").val().trim();
	$.ajax({
        url: "${ctx}/article/gettopicsbycountry",
        type: 'GET',
        dataType: 'json',
        data:param,
        error: function () {
        },
        success: function (data) {
        	$("#topicid").html('');
			$("#topicid").append('<option value="-1">请选择</option>');	
			for(var i=0;i<data.length;i++){
				<c:forEach var="topics" items="${hbtopics}"> 
					if("${topics.tid}"==data[i].topic){
						$("#topicid").append("<option value="+data[i].topic+">"+"${topics.name}"+"</option>");
					}
				</c:forEach>  
			}
			var topicsid="${article.topicsid}";
			$("#topicid").val(topicsid<=0?-1:topicsid);
        }
    });
}
$().ready(function(){
	var countrycode=$("#countrycode").val();
	if(countrycode.length>0){
		gettopicsbycountry();
	}
});
</script>
</head>
<body>
	<div class="row">
		<div class="col-sm-12">
			<h1 class="page-header">文章管理</h1>
		</div>
	</div>
	<div class="row">
		<div class="col-sm-12">
			<div class="panel panel-default">
				<div class="panel-heading text-right">
					<div class="row">
							<form class="form-inline" role="form" action="" method="get">
							<input name="page" type="hidden" value="1"/>
							<div class="form-group">
							    <div class="input-group">
							      <div class="input-group-addon">文章编号:</div>
							      	<input class="form-control" type="text" name="id" <c:if test="${article.id==0}">value=""</c:if> value="${article.id}"/>
							    </div>
							  </div>
							<div class="form-group">
							    <div class="input-group">
							      <div class="input-group-addon">国家:</div>
								      	<input class="form-control" id="countrycode" type="text" name="countrycode" value="${article.countrycode}" onblur="gettopicsbycountry();"/>
							   	  </div>
							   </div>
							   <div class="form-group">
							    <div class="input-group">
							      <div class="input-group-addon">媒体:</div>
							      <select name="publicationid" class="form-control">
							      		<option value="-1">请选择</option>
							      	<c:forEach var="publication" items="${publications }">
							      		<option value="${publication.id}" <c:if test="${article.publicationid==publication.id}">selected="selected"</c:if>>${publication.name}</option>
							      	</c:forEach>	
							      </select>
							    </div>
							  </div>
							   <div class="form-group">
							    <div class="input-group">
							      <div class="input-group-addon">来源渠道:</div>
							      <select name="channelid" class="form-control">
							      		<option value="-1">请选择</option>
							      	<c:forEach var="channel" items="${channellist }">
							      		<option value="${channel.id}" <c:if test="${article.channelid==channel.id}">selected="selected"</c:if>>${channel.channelname}</option>
							      	</c:forEach>	
							      </select>
							    </div>
							  </div>
							   <div class="form-group">
							    <div class="input-group">
							      <div class="input-group-addon">国际化语言:</div>
							      <select name="langid" class="form-control" onclick="sortByhbcode()">
							      		<option value="-1">请选择</option>
							      	<c:forEach var="language" items="${languagesSort }">
							      		<option value="${language.id}" <c:if test="${article.langid==language.id}">selected="selected"</c:if>>${language.hbcode} ${language.cnname}</option>
							      	</c:forEach>	
							      </select>
							    </div>
							    
							  </div>
							  <div class="form-group">
							    <div class="input-group">
							      <div class="input-group-addon">稿件属性:</div>
								      	<select id="attr" name="attr" class="form-control">
											<option value="-1"
												<c:if test="${article.attr=='-1'}">selected</c:if>>请选择</option>
											<option value="0"
												<c:if test="${article.attr=='0'}">selected</c:if>>文字文章</option>
											<option value="1"
												<c:if test="${article.attr=='1'}">selected</c:if>>图文文章</option>
											<option value="2"
												<c:if test="${article.attr=='2'}">selected</c:if>>视频文章</option>
											<option value="3"
												<c:if test="${article.attr=='3'}">selected</c:if>>链接文章</option>
											<option value="4"
												<c:if test="${article.attr=='4'}">selected</c:if>>H5游戏文章</option>
											<option value="5"
												<c:if test="${article.attr=='5'}">selected</c:if>>竞猜文章</option>
											<option value="6"
												<c:if test="${article.attr=='6'}">selected</c:if>>游戏文章</option>
										</select>
							   	  </div>
							   </div>
							   <div class="form-group">
							    <div class="input-group">
							      <div class="input-group-addon">状态:</div>
								      	<select name="status" class="form-control ">
									      		<option value="-1" <c:if test="${article.status==-1 }">selected</c:if>>请选择</option>
									      		<option value="0" <c:if test="${article.status==0 }">selected</c:if>>正常</option>
									      		<option value="2" <c:if test="${article.status==2 }">selected</c:if>>预发布</option>
									      		<option value="1" <c:if test="${article.status==1 }">selected</c:if>>未审核</option>
									      </select>
							   	  </div>
							   </div>
							   
							 <%--   <div class="form-group">
							    <div class="input-group">
							      <div class="input-group-addon">作者:</div>
							      	<input class="form-control" type="text" name="author" value="${article.author}"/>
							    </div>
							  </div> --%>
							
							<div class="form-group">
							    <div class="input-group">
							      <div class="input-group-addon">关键字:</div>
							      	<input class="form-control" type="text" name="keywords" value="${article.keywords}"/>
							    </div>
							  </div>
							
							  <div class="form-group">
							    <div class="input-group">
							      <div class="input-group-addon">话题:</div>
								      	<select id="topicid" name="topicid" class="form-control ">
									      		<option value="-1">请选择</option>
									      	<c:forEach var="topic" items="${hbtopics }">
									      		<option value="${topic.tid}" <c:if test="${article.topicsid==topic.tid }">selected</c:if>>${topic.name}</option>
									      	</c:forEach>	
									      </select>
							   	  </div>
							   </div>
							  
							  <div class="form-group">
							    <div class="input-group">
							      <div class="input-group-addon">开始日期:</div>
							      <input class="form-control" name="starttime" type="text" placeholder="输入开始日期" onClick="WdatePicker()" value="${article.starttime }">
							    </div>
							  </div>
							 <div class="form-group">
							    <div class="input-group">
							      <div class="input-group-addon">结束日期:</div>
							      <input class="form-control" name="endtime" type="text" placeholder="输入结束时间" onClick="WdatePicker()"  value="${article.endtime }">
							    </div>
							  </div>
							  <button type="submit" class="btn btn-primary">搜索 </button>&nbsp;&nbsp;
							  <a href="${ctx }/article/add?id=0" class="btn btn-primary" id="add"><span
							class="fa fa-plus-circle fa-fw"></span> 添加文章</a>&nbsp;&nbsp;
							
							</form>
						</div>
				</div>
				<div class="panel-heading text-left">
						<div class="row">
						&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
						<input type="checkbox" id="checkbox" onclick="checkAllBox(this);"/>&nbsp;&nbsp;&nbsp;&nbsp;
						<a href="" class="btn btn-primary" id="passlist" onclick="passlist();"><span
							class="fa fa-plus-circle fa-fw"></span> 批量发布</a>&nbsp;&nbsp;
						<a href="" class="btn btn-primary" id="deletelist" onclick="deletelist();"><span
							class="fa fa-plus-circle fa-fw"></span> 批量删除</a>&nbsp;&nbsp;
						</div>
				</div>
				<!-- /.panel-heading -->
				<div class="panel-body">
					<div class="table-responsive">
						<table class="table table-striped table-bordered table-hover"
							id="dataTables-example">
							<thead>
								<tr>
								    <th></th>
									<th>ID</th>
									<th>标题</th>
									<th>类型</th>
									<th>国家</th>
									<!-- <th>渠道</th> -->
									<th>话题</th>
									<th>媒体</th>
									<!-- <th>来源</th> -->
									<th>状态</th>
									<th>发布时间</th>
									<th>创建时间</th>
									<th>创建人</th>
									<th></th>
								</tr>
							</thead>
							<tbody>
								<c:forEach var="item" items="${articles}">
									<tr class="id" value="${item.id }">
									<td>
									 <input type="checkbox" name="checkbox" value="${item.id }"/>
									</td>
										<td>${item.id}</td>
										<td>${fn:substring(item.title,0,20)}<c:if test="${fn:length(item.title)>20}">...</c:if></td>
										<td>
											<c:if test="${item.ctype==0 }">普</c:if>
											<c:if test="${item.ctype==1 }">荐</c:if>
											<c:if test="${item.ctype==2 }">顶</c:if>
										</td>
										<td>${item.countrycode}</td>
									<%-- 	<td><coolook:status type="11" value="${item.channelid}"/></td> --%>
										<td><coolook:status type="9" value="${item.topicsid}"/></td>
										<td><coolook:status type="10" value="${item.publicationid}"/></td>
										<%-- <td>${item.source}</td> --%>
										<td>
											<c:if test="${item.status==0 }">正常</c:if>
											<c:if test="${item.status==2 }">预发布</c:if>
											<c:if test="${item.status==1 }">未审核</c:if>
										</td>
										<td><fmt:formatDate value="${item.subtime}" type="both" pattern="MM-dd HH:mm"/></td>
										<td><fmt:formatDate value="${item.createtime}" type="both" pattern="MM-dd HH:mm"/></td>
										<td><coolook:status type="1" value="${item.createuid}"/></td>
										<td>
											<div class="btn-group">
												<a class="btn btn-primary" href="#"><i
													class="icon-wrench icon-white"></i>操作</a> <a
													class="btn btn-primary dropdown-toggle"
													data-toggle="dropdown" href="#"><span class="caret"></span></a>
												<ul class="dropdown-menu">
												
													<li><a href="${ctx }/article/add?id=${item.id}"><i
															class="fa fa-pencil fa-fw"></i>修改</a></li>
													<li><a
														href="${ctx }/article/delete?id=${item.id}"><i
															class="fa fa-trash-o fa-fw" ></i>删除</a></li>
													<li><a
														href="${ctx }/articlescontent/add?id=${item.id}"><i
															class="fa fa-pencil fa-fw" ></i>文章内容管理</a></li>
													<c:if test="${item.status==1}">	
													<li><a
														href="${ctx }/article/auditing?id=${item.id}"><i
															class="fa fa-pencil fa-fw" ></i>审核</a></li>
													</c:if>			
													<li><a
														href="http://www.coolook.top/article/${item.id}.html"  target="_blank"><i
															class="fa fa-pencil fa-fw" ></i>预览</a></li>
															
													<li><a href="${ctx }/screen/importscreen?screenstatus=1&screenid=${item.id}"><i
															class="fa fa-pencil fa-fw"></i>导入锁屏</a></li>	
													<c:if test="${item.status !=2 }">
													<li><a href="${ctx }/article/pushadd?id=${item.id}"><i
															class="fa fa-pencil fa-fw"></i>推送</a></li>
													</c:if>	
													<c:if test="${item.status !=2 }">
													<li><a href="${ctx }/article/pushadd2?id=${item.id}"><i
															class="fa fa-pencil fa-fw"></i>推送2</a></li>
													</c:if>	
													<c:if test="${item.attr==1 }">
													<li>
													<a onclick="return checkTitleAndPic('${item.id}','${item.title}','${item.titlepic}')"><i
															class="fa fa-pencil fa-fw"></i>添加到置顶图</a></li></c:if>	
													<c:if test="${item.channelid==1 }">
													   <c:if test="${not empty item.linkurl }">
													<li><a
														href="${ctx }/article/viewsource?id=${item.id}" target="_blank"><i
															class="fa fa-pencil fa-fw" ></i>查看原文</a></li>
													   </c:if>
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
					        <input type="hidden" id="countindex" runat="server" value="${pageUtil.pagecount>=1000?1000:pageUtil.pagecount}"/>
					        <!-- 当前第几页 -->
					        <input type="hidden" id="Pagedq" runat="server" value="${pageUtil.currentPage}"/>
					        <!-- 请求的地址 -->
					        <input type="hidden" id="pageUrl" runat="server" value="${ctx }/article/list"/>
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
