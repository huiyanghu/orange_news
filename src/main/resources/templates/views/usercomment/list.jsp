<%@page language="java" import="java.util.*" contentType="text/html; charset=UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ include file="/common/taglibs.jsp"%>
<!DOCTYPE html>
<html lang="en">
<head>
<script src="${ctx }/js/page/jqPaginator.min.js" type="text/javascript"></script>
<link href="${ctx }/css/page/myPage.css" rel="stylesheet" type="text/css" />
<script type="text/javascript"
	src="${ctx }/js/plugins/My97DatePicker/WdatePicker.js"></script>
	<script type="text/javascript">
		function validate(){  
	        var reg = new RegExp("^[0-9]*$");  
	        var val = document.getElementsByName("artid")[0].value.trim();  
		    if(!reg.test(val)){  
		       alert("文章编号格式不正确!");
		       return;
		    }  
		    
		    document.forms[0].submit();
		  }  
	</script>
</head>
<body>
	<div class="row">
		<div class="col-sm-12">
			<h1 class="page-header">评论管理</h1>
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
								<div class="input-group col-xs-8">
									<div class="input-group-addon">文章编号:</div>
									<input class="form-control" type="text" name="artid"
									<c:if test='${usercomment.artid==0 }'>value=""</c:if>value="${usercomment.artid}"/>
								</div>
							</div>

							<div class="form-group">
								<div class="input-group">
									<div class="input-group-addon">状态:</div>
									<select name="status" class="form-control ">
										<option value="-1">请选择</option>
										<option value="0" 
										<c:if test="${usercomment.status==0 }">selected="selected"</c:if>>已审核
										</option>
										<option value="1"
										<c:if test="${usercomment.status==2 }">selected="selected"</c:if>>未审核
									    </option>
									   <%--  <option value="-1"
										<c:if test="${usercomment.status==-1 }">selected="selected"</c:if>>已删除
									    </option> --%>
									</select>
								</div>
							</div>

							

							<div class="form-group">
								<div class="input-group">
									<div class="input-group-addon">国家:</div>
									<input class="form-control" type="text" name="countrycode"
										value="${usercomment.countrycode}" />
								</div>
							</div>

							<button type="button" class="btn btn-primary"  onclick=validate(); >搜索</button>
							
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
									<th>文章ID</th>
									<!-- <th>评论内容</th> -->
									<th>时间</th>
									<th>状态</th>
									<th>国家</th>
									<th></th>
								</tr>
							</thead>
							<tbody>
								<c:forEach var="item" items="${usercomments}">
									<tr class="id" value="${item.id }">
										<td title="${item.content }">${item.id}</td>
										
										<td>${item.artid }</td>
										<%-- <td>${item.content }</td>--%> 
										
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
										<td>
										<c:if test="${item.status==0}">已审核</c:if>
										<c:if test="${item.status==2}">未审核</c:if>
										<c:if test="${item.status==-1}">已删除</c:if>
										</td>
										<td>${item.countrycode}</td>
										<td>
										 <div class="btn-group">
												<a class="btn btn-primary" href="#"><i
													class="icon-wrench icon-white"></i>操作</a> <a
													class="btn btn-primary dropdown-toggle"
													data-toggle="dropdown" href="#"><span class="caret"></span></a>
												<ul class="dropdown-menu">

													<li><a href="${ctx }/usercomment/add?id=${item.id}"><i
															class="fa fa-pencil fa-fw"></i>修改</a></li>
													<li><a href="${ctx }/usercomment/delete?id=${item.id}"><i
															class="fa fa-trash-o fa-fw"></i>删除</a></li>
							
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
					        <input type="hidden" id="pageUrl" runat="server" value="${ctx }/usercomment/list"/>
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
