<%@page language="java" contentType="text/html; charset=UTF-8"%>
<%@ include file="/common/taglibs.jsp"%>
<!DOCTYPE html>
<html lang="en">
<head>
<script type="text/javascript"
	src="${ctx }/js/plugins/My97DatePicker/WdatePicker.js"></script>
</head>
<body>
	<div class="row">
		<div class="col-sm-12">
			<h1 class="page-header">第三方广告管理</h1>
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
									<div class="input-group-addon">任务标题:</div>
									<input class="form-control" type="text" name="countrycode" value="${channelad.countrycode}" />
								</div>
							</div>
							<button type="submit" class="btn btn-primary">搜索</button>
							<a class="btn btn-primary" href="${ctx }/userjob/add?id=" >新增任务</a>
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
									<th>国家</th>
									<th>语言</th>
									<th>渠道id</th>
									<th>图片</th>
									<th>创建时间</th>
									<th>上线时间</th>
									<th>下线时间</th>
									<th>状态</th>
									<th>创建人</th>
									<th>链接地址</th>
									<th></th>
								</tr>
							</thead>
							<tbody>
								<c:forEach var="item" items="${channelads}">
									<tr class="id" value="${item.id }">
										<td>${item.id}</td>
										<td>${item.countrycode }</td>
										<td>${item.langid }</td>
										<td>${item.cid }</td>
										<td>${item.picpath }</td>
										<td>
										<%-- <fmt:formatDate value="${item.createtime}" type="date" pattern="yyyy-MM-dd HH:mm:ss"/> --%>
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
										<%-- <fmt:formatDate value="${item.onlinetime}" type="date" pattern="yyyy-MM-dd HH:mm:ss"/>
										 --%><script language="javascript" >
												var str='${item.onlinetime}';
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
											</script>  </td>
										<td>
										<%-- <fmt:formatDate value="${item.downlinetime}" type="date" pattern="yyyy-MM-dd HH:mm:ss"/>
										 --%>
										 <script language="javascript" >
												var str='${item.downlinetime}';
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
											</script>  </td>
										<td>
										<c:if test="${item.status==0}">为发布</c:if>
										<c:if test="${item.status==1}">已上传</c:if>
										<c:if test="${item.status==2}">上传失败</c:if>
										<c:if test="${item.status==3}">已删除</c:if>
										</td>
										<td>${item.creater}</td>
										<td>${item.linkurl}</td>
										<td>
										 <div class="btn-group">
												<a class="btn btn-primary" href="#"><i
													class="icon-wrench icon-white"></i>操作</a> <a
													class="btn btn-primary dropdown-toggle"
													data-toggle="dropdown" href="#"><span class="caret"></span></a>
												<ul class="dropdown-menu">

													<li><a href="${ctx }/userjob/add?id=${item.id}"><i
															class="fa fa-pencil fa-fw"></i>修改</a></li>
													<li><a href="${ctx }/userjob/delete?id=${item.id}"><i
															class="fa fa-trash-o fa-fw"></i>删除</a></li>
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
									<li><a href="#">当前：${pageUtil.currentPage}页，总共:${pageUtil.recordCount}条,总页数:${pageUtil.pagecount }页</a></li>
									<c:if test="${pageUtil.currentPage>1}">
										<li><a href="${ctx }/dsfadvert/list?page=1${searchstr}">首页</a></li>
									</c:if>
									<c:if test="${pageUtil.currentPage>1}">
										<li><a
											href="${ctx }/dsfadvert/list?page=${pageUtil.currentPage-1}${searchstr}">上一页</a></li>
									</c:if>
									<c:if test="${pageUtil.currentPage<pageUtil.pagecount}">
										<li><a
											href="${ctx }/dsfadvert/list?page=${pageUtil.currentPage+1}${searchstr}">下一页</a></li>
									</c:if>
									<c:if test="${pageUtil.currentPage<pageUtil.pagecount}">
										<li><a
											href="${ctx }/dsfadvert/list?page=${pageUtil.pagecount}${searchstr}">尾页</a></li>
									</c:if>
								</ul>
							</div>
						</div>


					</div>
				</div>
			</div>
		</div>
	</div>

</body>
</html>
