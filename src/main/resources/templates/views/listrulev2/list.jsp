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
				<h1 class="page-header">列表规则</h1>
			</div>
		</div>
		
		<div class="row">
			<div class="col-sm-12">
				<div class="panel panel-default">
					<div class="panel-heading text-left">
						<div class="row">
								<form class="form-inline" role="form" action="${ctx }/listrulev2/list" method="get" >
									<input name="page" type="hidden" value="1" />
									<div class="form-group">
										<div class="input-group">
									      <div class="input-group-addon">规则名称:</div>
										      	<input class="form-control" type="text" id="rulename" name="rulename" value="${conGrabLRule.rulename}" />
									   	 </div>
								   </div>
								   
								   <div class="form-group">
										<div class="input-group">
									      <div class="input-group-addon">国家码:</div>
										      	 <input class="form-control" type="text" id="code" name="code" value="${conGrabLRule.code}" />
									   	 </div>
								   </div>
								   
									   <div class="form-group">
									   	  <div class="input-group" >
										      <div class="input-group-addon">节点:</div>
										      <select id="nodeid" name="nodeid" class="form-control" >
											      			<option value="0">请选择</option>
														<c:forEach var="item" items="${nodelist}">	
															<option <c:if test="${conGrabLRule.nodeid==item.id }">selected='selected'</c:if> value="${item.id}">${item.nodename}</option>
														</c:forEach>	
												</select>
									    </div>
									    <div class="form-group">
									   	  <div class="input-group" >
										      <div class="input-group-addon">话题:</div>
										      <select id="topic" name="topic" class="form-control" >
											      			<option value="0">请选择</option>
														<c:forEach var="item" items="${topiclist}">	
															<option <c:if test="${conGrabLRule.topic==item.tid }">selected='selected'</c:if> value="${item.tid}">${item.name}</option>
														</c:forEach>	
												</select>
									    </div>
									  </div>
									  <div class="form-group">
									   	  <div class="input-group" >
										      <div class="input-group-addon">渠道:</div>
										      <select id="channelid" name="channelid" class="form-control" >
											      			<option value="0">请选择</option>
														<c:forEach var="item" items="${channellist}">	
															<option <c:if test="${conGrabLRule.channelid==item.id }">selected='selected'</c:if> value="${item.id}">${item.channelname}</option>
														</c:forEach>	
												</select>
									    </div>
									  </div>
								    
									<button type="submit" class="btn btn-primary" id="search">搜索 </button>&nbsp;&nbsp;
									<a href="${ctx }/listrulev2/add?id=0" class="btn btn-primary" id="add"><span
											class="fa fa-plus-circle fa-fw"></span> 添加</a>
							 	</div>
						</div>
									  		    
						</form>
					</div>
		
			</div>
			<div class="panel-body">
					<div class="table-responsive">
						<table class="table table-striped table-bordered table-hover"
							id="dataTables-example">
							<thead>
								<tr>
									<th>规则名称</th>
									<th>话题</th>
									<th>节点</th>
									<th>媒体</th>
									<th>渠道</th>
									<th>国家码</th>
									<!-- <th>csspath</th> -->
									<!-- <th>findpre</th> -->
									<th>创建时间</th>
									<!-- <th>url</th> -->
									<th>列表文章状态</th>
									<th>规则状态</th>
									<th></th>

								</tr>
							</thead>
							<tbody>
								<c:forEach var="item" items="${list}">
									<tr class="id" value="${item.id }"> 
										
										<td>
											${item.rulename}
										</td>
										
										<td>
											<div class="input-group" >
												<c:forEach var="topic" items="${topiclist}">	
													<c:if test="${topic.tid==item.topic}">${topic.name}</c:if>
												</c:forEach>	
										    </div>
										</td>
										
										<td>
											<div class="input-group" >
												<c:forEach var="node" items="${nodelist}">	
													<c:if test="${node.id==item.nodeid}">${node.nodename}</c:if>
												</c:forEach>	
										    </div>
										</td>
										<td>
											<div class="input-group" >
												<c:forEach var="publication" items="${publicationlist}">	
													<c:if test="${publication.id==item.pid}">${publication.name}</c:if>
												</c:forEach>	
										    </div>
										</td>
										 <td>
											<div class="input-group" >
												<c:forEach var="channel" items="${channellist}">	
													<c:if test="${channel.id==item.channelid}">${channel.channelname}</c:if>
												</c:forEach>	
										    </div>
										</td>
										
										<!-- <td>
											${item.csspath}
										</td> -->
										<td>
											${item.code }
										</td>
										<%-- <td>
											${item.findpre }
										</td> --%>
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
										
										<%-- <td width="20">
											${item.url}
										</td> --%>
										
										<td>
											<c:if test="${item.liststatus==0}">正常</c:if>
											<c:if test="${item.liststatus==1}">未发布</c:if>
										</td>
										<td>
											<c:if test="${item.status==0}">正常</c:if>
											<c:if test="${item.status==1}">禁用</c:if>
										</td>
										
										<td>
											<div class="btn-group">
												<a class="btn btn-primary" href="#"><i
													class="icon-wrench icon-white"></i>操作</a> <a
													class="btn btn-primary dropdown-toggle"
													data-toggle="dropdown" href="#"><span class="caret"></span></a>
												<ul class="dropdown-menu">
												
													<li><a href="${ctx }/listrulev2/details?id=${item.id}"><i
															class="fa fa-pencil fa-fw"></i>查看详情</a></li>
													<li><a href="${ctx }/listrulev2/add?id=${item.id}"><i
															class="fa fa-pencil fa-fw"></i>修改</a></li>
													<li><a href="${ctx }/listrulev2/delete?id=${item.id}"><i
															class="fa fa-trash-o fa-fw" ></i>删除</a></li>
													<li><a href="${ctx }/conrulev2/list?lid=${item.id}"><i
															class="fa fa-pencil fa-fw"></i>关联文章规则</a></li>
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
					        <input type="hidden" id="PageCount" runat="server" value="${listPaginator.totalCount}"/>
					        <!-- 总页数 -->
					        <input type="hidden" id="countindex" runat="server" value="${listPaginator.totalPages}"/>
					        <!-- 当前第几页 -->
					        <input type="hidden" id="Pagedq" runat="server" value="${listPaginator.page}"/>
					        <!-- 请求的地址 -->
					        <input type="hidden" id="pageUrl" runat="server" value="${ctx }/listrulev2/list"/>
					        <!-- 请求的参数 -->
					        <input type="hidden" id="pageParameter" runat="server" value="${searchstr}"/>
					        <!--设置最多显示的页码数 可以手动设置 默认为7-->
					        <input type="hidden" id="visiblePages" runat="server" value="10" />
					</div>
					    <script src="${ctx }/js/page/myPage.js" type="text/javascript"></script>
		</body>
</html>













