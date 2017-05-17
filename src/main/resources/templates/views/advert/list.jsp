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
			<h1 class="page-header">广告管理</h1>
		</div>
	</div>
	<div class="row">
		<div class="col-sm-12">
			<div class="panel panel-default">
				<div class="panel-heading text-right">
					<div class="row">
							<form class="form-inline" role="form" action="" method="get">
							<input name="page" type="hidden" value="${advertlistPaginator.page }"/>
							<div class="form-group">
							    <div class="input-group col-xs-6">
							      <div class="input-group-addon">国家:</div>
								      	<input class="form-control"  type="text" name="countrycode" value="${advert.countrycode}"/>
							   	  </div>
							   </div>
							  <div class="form-group">
							    <div class="input-group">
							      <div class="input-group-addon">广告名称:</div>
							      	<input class="form-control" type="text" name="adname" value="${advert.adname}"/>
							    </div>
							  </div>
							  <div class="form-group">
							    <div class="input-group" >
							      <div class="input-group-addon">应用名称:</div>
							      <select name="appid" class="form-control" onchange="modellist(this.value)">
							      		<option value="">请选择</option>
							      		<c:forEach var="appitem" items="${applications }">
							      			<option value="${appitem.id }" <c:if test="${advert.appid ==appitem.id }">selected</c:if>>${appitem.appname }</option>
							      		</c:forEach>
							      </select>
							    </div>
							  </div>
							  <div class="form-group">
							    <div class="input-group">
							      <div class="input-group-addon">模块名称:</div>
							      <select name="modelid" class="form-control" id="works">
							      		<option value="">请选择</option>
							      		<%-- <c:if test="${advert.modelid>0}"> --%>
							      		<c:forEach var="modelitem" items="${modellist }">
							      			<option value="${modelitem.id }" <c:if test="${advert.modelid ==modelitem.id }">selected</c:if>>${modelitem.modelname }</option>
							      		</c:forEach>
							      		<%-- </c:if> --%>
							      </select>
							    </div>
							  </div>
							  
							  <div class="form-group">
							    <div class="input-group" >
							      <div class="input-group-addon">语言:</div>
							      <select name="langid" class="form-control">
							      		<option value="">请选择</option>
							      		<c:forEach var="langitem" items="${hblanguagesSort }">
							      			<option value="${langitem.id }" <c:if test="${advert.langid ==langitem.id }">selected</c:if>>${langitem.hbcode } ${langitem.cnname }</option>
							      		</c:forEach>
							      </select>
							    </div>
							  </div>
							  <button type="submit" class="btn btn-primary">搜索 </button>&nbsp;&nbsp;
							  <a href="${ctx }/advert/add?id=0" class="btn btn-primary" id="add"><span
							class="fa fa-plus-circle fa-fw"></span> 添加广告</a>
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
									<th>广告ID</th>
									<th>广告名称</th>
									<th>广告描述</th>
									<th>图片</th>
									<th>星级</th>
									<th>广告状态</th>
									<th>类型</th>
									<th>应用</th>
									<th>模块</th>
									<th>国家</th>
									<th>语言</th>
									<th>创建人</th>
									<th>创建时间</th>
									<th></th>

								</tr>
							</thead>
							<tbody>
								<c:forEach var="item" items="${advertlist}">
									<tr class="id" value="${item.id }">
										<td>${item.id}</td>
										<td>${item.adname}</td>
										<td>${item.addesc}</td>
										<td>
										<c:if test="${not empty item.adimg}"><img src="${upyunhttp }${item.adimg}!30"/></c:if></td>
										<td>${item.starlv }</td>
										<td><coolook:status type="0" value="${item.status}"/></td>
										<td><coolook:status type="5" value="${item.adtype}"/></td>
										<td><coolook:status type="4" value="${item.appid}"/></td>
										<td><coolook:status type="8" value="${item.modelid}"/></td>
										<td>${item.countrycode }</td>
										<td><coolook:status type="13" value="${item.langid}"/></td>
										<td><coolook:status type="1" value="${item.createuid}"/></td>
										<td><fmt:formatDate value="${item.createtime }" type="both" pattern="YY-MM-dd HH:mm"/></td>
										<td>
											<div class="btn-group">
												<a class="btn btn-primary" href="#"><i
													class="icon-wrench icon-white"></i>操作</a> <a
													class="btn btn-primary dropdown-toggle"
													data-toggle="dropdown" href="#"><span class="caret"></span></a>
												<ul class="dropdown-menu">
												
													<li><a href="${ctx }/advert/add?id=${item.id}"><i
															class="fa fa-pencil fa-fw"></i>修改</a></li>
														
													<li><a
														href="${ctx }/advert/delete?id=${item.id}"><i
															class="fa fa-trash-o fa-fw" ></i>删除</a></li>
													<c:if test="${item.status==0}">	
													<li><a
														href="${ctx }/advert/openorclose?status=1&id=${item.id}"><i
															class="fa fa-pencil fa-fw" ></i>禁用</a></li>
													</c:if>	
													
													<c:if test="${item.status==1}">
													<li><a
														href="${ctx }/advert/openorclose?status=0&id=${item.id}"><i
															class="fa fa-pencil fa-fw" ></i>开启</a></li>		
													</c:if>
													<li><a
														href="${ctx }/screen/importscreen?screenstatus=2&screenid=${item.id}"><i
															class="fa fa-pencil fa-fw" ></i>导入锁屏</a></li>
													<li><a onclick="return checkTitleAndName('${item.id}','${item.adtitle}','${item.adname}')" ><i 
															class="fa fa-pencil fa-fw" ></i>添加到置顶图</a></li>
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
					        <input type="hidden" id="PageCount" runat="server" value="${advertlistPaginator.totalCount}"/>
					        <!-- 总页数 -->
					        <input type="hidden" id="countindex" runat="server" value="${advertlistPaginator.totalPages}"/>
					        <!-- 当前第几页 -->
					        <input type="hidden" id="Pagedq" runat="server" value="${advertlistPaginator.page}"/>
					        <!-- 请求的地址 -->
					        <input type="hidden" id="pageUrl" runat="server" value="${ctx }/advert/list"/>
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
	
	function modellist(id){
		var url="${ctx }/advert/ajaxwb?appid="+id;
		
		var ajax = false;
	    if(window.XMLHttpRequest) { 
	        ajax = new XMLHttpRequest();
	        if (ajax.overrideMimeType) {//设置MiME类别
	            ajax.overrideMimeType("text/xml");
	        }
	    }else if (window.ActiveXObject) {     // IE浏览器
	        try{
	            ajax = new ActiveXObject("Msxml2.XMLHTTP");
	        }catch (e){
	            try{
	                ajax = new ActiveXObject("Microsoft.XMLHTTP");
	            }catch(e){}
	        }
	    }
	    if (!ajax){     
	        window.alert("不能创建XMLHttpRequest对象实例.");
	        return false;
	    }               
	    ajax.open("GET", url, true);
	    ajax.send(null);
	    ajax.onreadystatechange = function(){ 
	           if (ajax.readyState == 4 && ajax.status == 200){ 
	            	var date = ajax.responseText; 
	            	$('#works').html(date);
	           } 
	    } 
	}
	
	function checkTitleAndName(id,adtitle,adname){
	    if((adtitle.trim() == "" || adtitle.trim() == null) && (adname.trim() == "" || adname.trim() == null)){
				
				if(confirm("广告标题为空,要继续添加置顶图吗?")){
					window.location.href = '${ctx }/advert/addtoapptop?id='+id+'&countrycode=${advert.countrycode}'+
							'&adname=${advert.adname}&appid=${advert.appid}'+
							'&modelid=${advert.modelid}&langid=${advert.langid}';
				}else{
					return false;
				}
				
		}else{
			window.location.href = '${ctx }/advert/addtoapptop?id='+id+'&countrycode=${advert.countrycode}'+
			'&adname=${advert.adname}&appid=${advert.appid}'+
			'&modelid=${advert.modelid}&langid=${advert.langid}';
		} 
	}
</script>
	
	
</body>
</html>
