<%@page language="java" contentType="text/html; charset=UTF-8"%>
<%@ include file="/common/taglibs.jsp"%>
<!DOCTYPE html>
<html lang="en">
<head>
	<script src="${ctx }/js/page/jqPaginator.min.js" type="text/javascript"></script>
    <link href="${ctx }/css/page/myPage.css" rel="stylesheet" type="text/css" />
<script type="text/javascript"
	src="${ctx }/js/plugins/My97DatePicker/WdatePicker.js"></script>
</head>
<body>
	<div class="row">
		<div class="col-sm-12">
			<h1 class="page-header">用户ck币记录</h1>
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
									<div class="input-group-addon">用户uuid:</div>
									<input class="form-control" type="text" name="uuid" value="${userCkcoinsRecord.uuid}" />
								</div>
							</div>
							<div class="form-group">
								<div class="input-group">
									<div class="input-group-addon">类型:</div>
									<select name=itype class="form-control ">
									    <option value="-1" >
									            请选择
									    </option>
										<option value="0" 
										<c:if test="${userCkcoinsRecord.itype==0 }">selected="selected"</c:if>>任务
										</option>
										<option value="1"
										<c:if test="${userCkcoinsRecord.itype==1 }">selected="selected"</c:if>>投注
									    </option>
									    <option value="2"
										<c:if test="${userCkcoinsRecord.itype==2 }">selected="selected"</c:if>>获利
									    </option>
									    <option value="3"
										<c:if test="${userCkcoinsRecord.itype==3 }">selected="selected"</c:if>>充值
									    </option>
									     <option value="4"
										<c:if test="${userCkcoinsRecord.itype==4 }">selected="selected"</c:if>>返还
									    </option>
									     <option value="5"
										<c:if test="${userCkcoinsRecord.itype==5 }">selected="selected"</c:if>>返利
									    </option>
									</select>
								</div>
							</div>
							
							<button type="submit" class="btn btn-primary">搜索</button>
							
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
									<th>uuid</th>
									<th>任务Id</th>
									<th>竞猜Id</th>
									<th>类型</th>
									<th>时间</th>
									<th>ck币</th>
									<th>状态</th>
								</tr>
							</thead>
							<tbody>
								<c:forEach var="item" items="${list}">
									<tr class="id" value="${item.id }">
										<td>${item.id}</td>
										<td>${item.uuid}</td>
										<td>${item.jobid}</td>
										<td>${item.prid }</td>
										<td>
										  <c:if test="${item.itype==0}">任务</c:if>
										   <c:if test="${item.itype==1}">投注</c:if>
										   <c:if test="${item.itype==2}">获利</c:if>
										   <c:if test="${item.itype==3}">充值</c:if>
										    <c:if test="${item.itype==4}">返还</c:if>
										     <c:if test="${item.itype==5}">返利</c:if>
										</td>
										<td>
										<fmt:formatDate value="${item.createtime}" type="date" pattern="yyyy-MM-dd HH:mm:ss"/>
										</td>
										<td>${item.ckcoins }</td>
										<td>
										<c:if test="${item.status==0}">正常</c:if>
										<c:if test="${item.status==1}">禁用</c:if>
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
					        <input type="hidden" id="pageUrl" runat="server" value="${ctx }/userckcoinsrecord/list"/>
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
