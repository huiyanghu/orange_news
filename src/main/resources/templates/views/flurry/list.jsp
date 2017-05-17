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
			<h1 class="page-header">数据录入</h1>
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
									<div class="input-group-addon">应用:</div>
									<select class="form-control" name="appid">
									   <option value="0">请选择 </option>
									   <option value="1">Coolook </option>
									</select>
								</div>
							</div>
							<div class="form-group">
								<div class="input-group">
									<div class="input-group-addon">渠道:</div>
									<select class="form-control" name="channelid" id="channelid">
									    <option value="">请选择</option>
									       <c:forEach var="item" items="${channellist}">
											<option value="${item.id}"
												<c:if test="${devData.channelid==item.id}">selected</c:if>> ${item.channelname}</option>
											</c:forEach>
									    </select>
								</div>
							</div>
							<button type="submit" class="btn btn-primary">搜索</button>
							<a class="btn btn-primary" href="${ctx }/coolookdata/add?id=" >导入excel</a>
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
									<th>应用id</th>
									<th>渠道id</th>
									<th>数量</th>
									<th>日期</th>
									<th>利率</th>
									
									<th></th>
								</tr>
							</thead>
							<tbody>
								<c:forEach var="item" items="${devdatalist}">
									<tr class="id" value="${item.id }">
										<td>
										<c:if test="${item.appid==1}">Coolook</c:if>
										</td>
										<td>
										<c:forEach var="channel" items="${channellist }">
								      			<c:if test="${item.channelid ==channel.id }">${channel.channelname }</c:if>
								      		</c:forEach>
										</td>
										<td>${item.devnum }</td>
										
										
										<td>
										<script language="javascript" >
												var str='${item.devdate}';
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
											  document.write(new Date(parseInt(str)).format("yyyy-MM-dd")); 
											</script> 
										
										
										
										</td>
										<td>${item.rate }</td>
										<td>
										
                                              
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
					        <input type="hidden" id="PageCount" runat="server" value="${devdatalistPaginator.totalCount}"/>
					        <!-- 总页数 -->
					        <input type="hidden" id="countindex" runat="server" value="${devdatalistPaginator.totalPages}"/>
					        <!-- 当前第几页 -->
					        <input type="hidden" id="Pagedq" runat="server" value="${devdatalistPaginator.page}"/>
					        <!-- 请求的地址 -->
					        <input type="hidden" id="pageUrl" runat="server" value="${ctx }/coolookdata/list"/>
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
