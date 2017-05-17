<%@page language="java" contentType="text/html; charset=UTF-8"%>
<%@ include file="/common/taglibs.jsp"%>
<!DOCTYPE html>
<html lang="en">
<head>
		
</head>
	<body>
		<div class="row">
			<div class="col-sm-12">
				<h1 class="page-header">文章规则</h1>
			</div>
		</div>
		
		<div class="row">
			<div class="col-sm-12">
				<div class="panel panel-default">
					<%-- <div class="panel-heading text-right">
						<div class="row">
						   <form class="form-inline" role="form" action="${ctx }/conrulev2/list" method="get" >
							 <input class="form-control" id="id" name="id" type="hidden"  value="${bean.id }" />		
							 <input class="form-control" id="lid" name="lid" type="hidden"  value="${bean.lid }" />	
									<input name="page" type="hidden" value="${listPaginator.page }"/>
									<div class="form-group">
										<div class="input-group ">
									      <div class="input-group-addon">规则名称:</div> 
									      	<input class="form-control" type="text" id="rulename" name="rulename" value="${bean.rulename }"/>
									   	</div>
								    </div>
									<div class="input-group" >
									   <div class="input-group-addon">状态:</div>
									      <select id="status" name="status" class="form-control" >
											<option value="-1" <c:if test="${bean.status==-1 }">selected='selected'</c:if>>请选择</option>
											<option value="0" <c:if test="${bean.status==0 }">selected='selected'</c:if>>正常</option>
											<option value="1" <c:if test="${bean.status==1 }">selected='selected'</c:if>>禁用</option>
										  </select>
									 </div>
									  <a href="${ctx }/conrulev2/add?id=0" class="btn btn-primary" id="add"><span
										class="fa fa-plus-circle fa-fw"></span> 添加</a>
										<button type="submit" class="btn btn-primary" id="search">搜索 </button>&nbsp;&nbsp;
								</form>
					</div>
		
			</div> --%>
			<div class="panel-body">
					<div class="table-responsive">
						<table class="table table-striped table-bordered table-hover"
							id="dataTables-example">
							<thead>
								<tr>
									<th>规则名称</th>
									<th>创建时间</th>
									<th>状态</th>
									<th></th>
								</tr>
							</thead>
							<tbody>
								<c:forEach var="item" items="${list}">
 									 <tr value="${item.id }">
 										<td>${item.rulename}</td>
										<td>
											<script language="javascript" >
                                        var str='${item.createtime}';
                                         Date.prototype.format = function (format) {     
                                                var o = {     
                                                    "M+": this.getMonth() + 1,     
                                                    "d+": this.getDate(),     
                                                    "h+": this.getHours(),     
                                                    "m+": this.getMinutes(),     
                                                    "s+": this.getSeconds(),     
                                                    "q+": Math.floor((this.getMonth() + 3) / 3),     
                                                    "S": this.getMilliseconds()     
                                                }     
                                                if (/(y+)/.test(format)) {     
                                                    format = format.replace(RegExp.$1, (this.getFullYear() + "").substr(4 - RegExp.$1.length));     
                                                }     
                                                for (var k in o) {     
                                                    if (new RegExp("(" + k + ")").test(format)) {     
                                                        format = format.replace(RegExp.$1, RegExp.$1.length == 1 ? o[k] : ("00" + o[k]).substr(("" + o[k]).length));     
                                                    }     
                                                }     
                                                return format;     
                                            }  
                                          document.write(new Date(parseInt(str)).format("yyyy-MM-dd hh:mm:ss")); 
                                        </script>
										</td>
										<td>
											<c:if test="${item.status==0}">正常</c:if>
											<c:if test="${item.status==1}">禁用</c:if>
										</td>
										<td width="10%">
											<div class="btn-group">
												<a class="btn btn-primary" href="#"><i
													class="icon-wrench icon-white"></i>操作</a> <a
													class="btn btn-primary dropdown-toggle"
													data-toggle="dropdown" href="#"><span class="caret"></span></a>
												<ul class="dropdown-menu">
												
													<li><a href="${ctx }/conrulev2/details?id=${item.id}&lid=${bean.lid}"><i
															class="fa fa-pencil fa-fw"></i>查看详情</a></li>
													<li><a href="${ctx }/conrulev2/add?id=${item.id}&lid=${bean.lid}"><i
															class="fa fa-pencil fa-fw"></i>修改</a></li>
													<li><a href="${ctx }/conrulev2/delete?id=${item.id}"><i
															class="fa fa-trash-o fa-fw" ></i>删除</a></li>
												</ul>
												
											</div>
										</td>
									</tr>
								</c:forEach>
							</tbody>
						</table>
						
						<div class="row">
							<div class="col-sm-12 text-center">
								<ul class="pagination">
									<li><a href="#">当前：${listPaginator.page}页，总共:${listPaginator.totalCount}条,总页数:${listPaginator.totalPages }页</a></li>
									<c:if test="${listPaginator.page>1}">
										<li><a href="${ctx }/conrulev2/list?page=${listPaginator.prePage}${searchstr}">上一页</a></li>
									</c:if>
									<c:if test="${listPaginator.page<listPaginator.totalPages}">
										<li><a
											href="${ctx }/conrulev2/list?page=${listPaginator.nextPage}${searchstr}">下一页</a></li>
									</c:if>
									
								</ul>
							</div>
						</div>
		</body>
</html>














