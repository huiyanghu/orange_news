<%@page language="java" contentType="text/html; charset=UTF-8"%>
<%@ include file="/common/taglibs.jsp"%>
<!DOCTYPE html>
<html lang="en">
<head runat="server">
<link href="${ctx }/css/page/bootstrap.min.css" rel="stylesheet" type="text/css" />
    <script src="${ctx }/js/page/jquery-1.7.2.min.js" type="text/javascript"></script>
    <script src="${ctx }/js/page/jqPaginator.min.js" type="text/javascript"></script>
    <link href="${ctx }/css/page/myPage.css" rel="stylesheet" type="text/css" />
    <script type="text/javascript">
    </script>
    <script type="text/javascript" src="${ctx }/js/plugins/My97DatePicker/WdatePicker.js"></script>
    <script type="text/javascript">
function daochuExcel(obj){

    if(!confirm("您确定要导出吗？"))
    {
        return;
    }
    var uuid=$("#uuid").val();
    var email=$("#email").val();
    var mobile=$("#mobile").val();
    var status=$("#status").val();
    var changeid=$("#changeid").val();
    var start=$("#start").val();
    var end=$("#end").val();
   // alert("id="+id+";countryCode="+countryCode+";begintime="+begintime+";endtime="+endtime+";projectname="+projectname);
     $("body").append("<a id=exportExcel  href='${ctx }/reguser/excelExportDeviceActionData?uuid="
    		 +uuid+"&email="+email
    		 +"&mobile="+mobile
    		 +"&status="+status
    		 +"&start="+start
    		 +"&end="+end
    		 +"&changeid="+changeid+"'></a>");
     document.getElementById("exportExcel").click();
     $("#exportExcel").remove(); 

}

</script>
</head>
<body>
	<div class="row">
		<div class="col-sm-12">
			<h1 class="page-header">用户列表</h1>
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
							      <div class="input-group-addon">UUID:</div>
								      	<input style = "width:300px" class="form-control"  type="text" name="uuid" id="uuid" value="${reguser.uuid}"/>
							   	  </div>
							   </div>
							
							<div class="form-group">
							    <div class="input-group">
							      <div class="input-group-addon">邮箱:</div>
								      	<input style = "width:300px" class="form-control"  type="text" name="email" id="email" value="${reguser.email}"/>
							   	  </div>
							   </div>
							   
							   <div class="form-group">
							    <div class="input-group">
							      <div class="input-group-addon">手机号:</div>
							      	<input class="form-control" type="text" name="mobile" id="mobile" value="${reguser.mobile}"/>
							    </div>
							  </div>
							   
							   <div class="form-group">
							    <div class="input-group">
							      <div class="input-group-addon">状态:</div>
								      	<select name="status" class="form-control " id="status">
									      		<option value="-2">请选择</option>
									      		<option value="-1" <c:if test="${reguser.status==-1 }">selected</c:if>>未激活</option>
									      		<option value="0" <c:if test="${reguser.status==0 }">selected</c:if>>激活</option>
									      		<option value="1" <c:if test="${reguser.status==1 }">selected</c:if>>禁用</option>
									      		<option value="3" <c:if test="${reguser.status==3 }">selected</c:if>>删除</option>
									      </select>
							   	  </div>
							   </div>
							  
							  <div class="form-group">
							   <div class="input-group">
								<div class="input-group-addon">渠道：</div>
									<select id="changeid" name="changeid" class="form-control">
									<option value="0" >全部</option>
										<c:forEach items="${channellist }" var="iteml">
											<option value="${iteml.id }"
												<c:if test="${iteml.id ==reguser.changeid }">selected</c:if>>${iteml.channelname }</option>
										</c:forEach>
									</select>
								</div>
								</div>
							  
							  <div class="form-group">
							    <div class="input-group">
							      <div class="input-group-addon">开始日期:</div>
							      <input class="form-control" name="start" id="start" type="text" placeholder="输入注册时间" onClick="WdatePicker()" value="${start }">
							    </div>
							  </div>
							 <div class="form-group">
							    <div class="input-group">
							      <div class="input-group-addon">结束日期:</div>
							      <input class="form-control" name="end" id="end" type="text" placeholder="输入注册时间" onClick="WdatePicker()"  value="${end }">
							    </div>
							  </div>
							 
							  <button type="submit" class="btn btn-primary">搜索 </button>&nbsp;&nbsp;
							      <a class="btn btn-primary"
						     id="daochu" onmousedown="daochuExcel(this);" href="">
						     <span
								class="fa fa-plus-circle fa-fw"></span> 导出
						     </a> 
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
									<th>uuid</th>
									<!-- <th>用户类型</th> -->
									<th>用户邮箱</th>
									<th>来源</th>
									<th>渠道</th>
									<th>版本号</th>
									<th>手机号</th>
									<th>注册时间</th>
									<th>注册国家</th>
									<!-- <th>facebook</th>
									<th>twitter</th>
									<th>google+</th> -->
									<th>状态</th>
									<th>用户余额</th>
									
									<th></th>
								</tr>
							</thead>
							<tbody>
								<c:forEach var="item" items="${regusers}">
									<tr class="id" value="${item.id }">
										<td>${item.uuid}</td>
										<%-- <td>
											<c:if test="${item.utype==0 }">coolook</c:if>
											<c:if test="${item.utype==1 }">facebook</c:if>
											<c:if test="${item.utype==2 }">twitter</c:if>
											<c:if test="${item.utype==3 }">google+</c:if>
										</td> --%>
										<td>${item.email}</td>
										<td>
											<c:if test="${item.source==1 }">android</c:if>
											<c:if test="${item.source==2 }">ios</c:if>
											<c:if test="${item.source==3 }">web</c:if>
										</td>
										<td>${item.changeid}</td>
										<td>${item.versioncode}</td>
										<td>${item.mobile}</td>
										<td>
										<fmt:formatDate value="${item.createtime}" type="date" pattern="yyyy-MM-dd HH:mm:ss"/>
										</td>
										<td>${item.countrycode}</td>
										<%-- <td>
											<c:if test="${item.fbinding==0 }">绑定</c:if>
											<c:if test="${item.fbinding==1 }">未绑定</c:if>
										</td>
										<td>
											<c:if test="${item.tbingding==0 }">绑定</c:if>
											<c:if test="${item.tbingding==1 }">未绑定</c:if>
										</td>
										<td>
											<c:if test="${item.gbinging==0 }">绑定</c:if>
											<c:if test="${item.gbinging==1 }">未绑定</c:if>
										</td> --%>
										<td>
											<c:if test="${item.status==-1 }">未激活</c:if>
											<c:if test="${item.status==0 }">激活</c:if>
											<c:if test="${item.status==1 }">禁用</c:if>
											<c:if test="${item.status==-2 }">删除</c:if>
										</td>
										<td>
										 <c:if test="${empty item.ckcoins  }">0</c:if>
										 <c:if test="${not empty item.ckcoins  }">${item.ckcoins  }</c:if>
										</td>
										
										<td>
											<div class="btn-group">
												<a class="btn btn-primary" href="#"><i
													class="icon-wrench icon-white"></i>操作</a> <a
													class="btn btn-primary dropdown-toggle"
													data-toggle="dropdown" href="#"><span class="caret"></span></a>
												<ul class="dropdown-menu">
												
													<li><a href="${ctx }/reguser/editinfo?uuid=${item.uuid}"><i
															class="fa fa-pencil fa-fw"></i>修改</a></li>
													<li><a href="${ctx }/reguser/payck?uuid=${item.uuid}"><i
															class="fa fa-pencil fa-fw"></i>用户充值</a></li>		
													<li><a
														href="${ctx }/reguser/delete?id=${item.id}"><i
															class="fa fa-trash-o fa-fw" ></i>删除</a></li>
													
															
																		
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
					        <input type="hidden" id="countindex" runat="server" value="${pageUtil.pagecount }"/>
					        <!-- 当前第几页 -->
					        <input type="hidden" id="Pagedq" runat="server" value="${pageUtil.currentPage}"/>
					        <!-- 请求的地址 -->
					        <input type="hidden" id="pageUrl" runat="server" value="${ctx }/reguser/list"/>
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
