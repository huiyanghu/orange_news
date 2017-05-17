<%@page language="java" contentType="text/html; charset=UTF-8"%>
<%@ include file="/common/taglibs.jsp"%>
<!DOCTYPE html>
<html lang="en">
<head>
</head>
<body>
	<div class="row">
		<div class="col-sm-12">
			<h1 class="page-header">版本下载列表</h1>
		</div>
	</div>
	<div class="row">
		<div class="col-sm-12">
			<div class="panel panel-default">
				<div class="panel-heading text-right">
					<div class="row">
							
						</div>
				
				</div>
				<!-- /.panel-heading -->
				<div class="panel-body">
					<div class="table-responsive">
						<table class="table table-striped table-bordered table-hover"
							id="dataTables-example">
							<thead>
								<tr>
									<th>版本号</th>
									<th>版本描述</th>
									<th>渠道名称</th>
									<th>下载地址</th>
									<!-- <th></th> -->

								</tr>
							</thead>
							<tbody>
								<c:forEach var="item" items="${versionlist}">
									<tr class="id" value="${item.id }">
										<td>${item.versioncode}</td>
										<td>${item.versiondesc}</td>
										<td><coolook:status type="3" value="${item.channelid }"/></td>
										<td><a href="${item.download}">下载</a></td>
										<%-- <td>
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
												</ul>
											</div>

										</td> --%>

									</tr>
								</c:forEach>
							</tbody>
						</table>
						
						<%-- <div class="row">
							<div class="col-sm-12 text-center">
									<ul class="pagination">
										<li>
											<a href="#">当前：${advertlistPaginator.page}页，总共:${advertlistPaginator.totalCount}条,总页数:${advertlistPaginator.totalPages }页</a>
										</li>
										<c:if test="${advertlistPaginator.page>1}">
											<li><a href="${ctx }/advert/list?page=${advertlistPaginator.prePage}${searchstr}">上一页</a></li>
										</c:if>
										
										<c:if test="${advertlistPaginator.page<advertlistPaginator.totalPages}">
											<li><a href="${ctx }/advert/list?page=${advertlistPaginator.nextPage}${searchstr}">下一页</a></li>
										</c:if>

									</ul>
							</div>
						</div> --%>
						
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
	
	
	</script>
	
	
</body>
</html>
