<%@page language="java" contentType="text/html; charset=UTF-8"%>
<%@ include file="/common/taglibs.jsp"%>

<!DOCTYPE html>
<html lang="en">
<head>
<script type="text/javascript" src="${ctx }/js/plugins/My97DatePicker/WdatePicker.js"></script>
<script type="text/javascript" src="${ctx }/js/jquery-1.11.0.js"></script>

</head>
<body>
	<div class="row">
		<div class="col-sm-12">
			<h1 class="page-header">【留存统计】</h1>
			<br/>次日留存率：(当天新增的用户中，在第2天还登录的用户数)/第一天新增总用户数;
			<br/>第3日留存率：(第一天新增用户中，在往后的第3天还有登录的用户数)/第一天新增总用户数;
			<br/>第7日留存率：(第一天新增的用户中，在往后的第7天还有登录的用户数)/第一天新增总用户数;
			<br/>第30日留存率：(第一天新增的用户中，在往后的第30天还有登录的用户数)/第一天新增总用户数。
		</div>
	</div>
	<div class="row">
		<div class="col-sm-12">
			<div class="panel panel-default">
				<div class="panel-heading text-right">
					<div class="row">
						<form class="form-inline" role="form" action="${ctx}/genralize/remain" method="get">
							  <c:if test="${sessionScope.sysuser.roleid != 1001 }">
							  <div class="form-group">
							   <div class="input-group">
								<div class="input-group-addon">渠道：</div>
									<select id="channelid" name="channelid" class="form-control">
									<option value="0" >全部</option>
										<c:forEach items="${channellist }" var="iteml">
											<option value="${iteml.id }"
												<c:if test="${iteml.id ==channelid }">selected</c:if>>${iteml.channelname }</option>
										</c:forEach>
									</select>
								</div>
								</div>
							</c:if>
							
							
							<div class="input-group">
								<div class="input-group-addon">请选择：</div>
									<select id="remainselt" name="remainselt" class="form-control" >
											<option value="2"
												<c:if test="${remainselt == 2 }">selected</c:if>>次日留存率</option>
											<option value="3"
												<c:if test="${remainselt == 3 }">selected</c:if>>第3日留存率</option>
												<option value="7"
												<c:if test="${remainselt == 7 }">selected</c:if>>第7日留存率</option>
												<option value="30"
												<c:if test="${remainselt == 30 }">selected</c:if>>第30日留存率</option>
									</select>
							</div>
							
							
							  <div class="form-group">
							    <div class="input-group">
							      <input class="form-control" name="starttime" id="starttime"  type="text" placeholder="输入日期"  value="${starttime }" onClick="WdatePicker()"/>
							    </div>
							  </div>
							  
							  
							   <input type="submit" value="搜索" />
							</form>
					
					
					</div>
				</div>
				<!-- /.panel-heading -->
				<div class="panel-body">
					<div class="table-responsive">
					新增：${newtotle}  留存：${liucun}  留存率：${liucunv}
						<!-- <table class="table table-striped table-bordered table-hover"
							id="dataTables-example">
							<thead>
								<tr>
									<th>UUID</th>
									<th>应用ID</th>
									<th>渠道ID</th>
									<th>应用版本</th>
									<th></th>

								</tr>
							</thead> -->
							<%-- <tbody>
								<c:forEach var="item" items="${actiondatas}">
									<tr class="id" value="${item.uuid }">
										<td>${item.uuid }</td>
										<td><coolook:status type="4" value="${item.appid }"/></td>
										<td><coolook:status type="3" value="${item.channelid }"/></td>
										<td>${item.appversion }</td>
										<td>

										</td>

									</tr>
								</c:forEach>
							</tbody> --%>
						</table>
						
						<%-- <div class="row">
							<div class="col-sm-12 text-center">
									<ul class="pagination">
										<li>
										<a href="#">当前：${pageUtil.currentPage}页，总共:${pageUtil.recordCount}条,总页数:${pageUtil.pagecount }页</a></li>
										<c:if test="${pageUtil.currentPage>1}">
											<li><a href="${ctx }/genralize/newlyincreased?page=1${searchstr}">首页</a></li>
										</c:if>	
										<c:if test="${pageUtil.currentPage>1}">
											<li><a href="${ctx }/genralize/newlyincreased?page=${pageUtil.currentPage-1}${searchstr}">上一页</a></li>
										</c:if>
										<c:if test="${pageUtil.currentPage<pageUtil.pagecount}">
											<li><a href="${ctx }/genralize/newlyincreased?page=${pageUtil.currentPage+1}${searchstr}">下一页</a></li>
										</c:if> 
										<c:if test="${pageUtil.currentPage<pageUtil.pagecount}">
											<li><a href="${ctx }/genralize/newlyincreased?page=${pageUtil.pagecount}${searchstr}">尾页</a></li>
										</c:if>	
									</ul>
							</div>
						</div> --%>
						
					</div>
				</div>
			</div>
		</div>
	</div>
</body>
</html>
