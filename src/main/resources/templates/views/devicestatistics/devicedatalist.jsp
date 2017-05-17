<%@page language="java" contentType="text/html; charset=UTF-8"%>
<%@ include file="/common/taglibs.jsp"%>
<!DOCTYPE html>
<html lang="en">
<head>
<script type="text/javascript"
	src="${ctx }/js/plugins/My97DatePicker/WdatePicker.js"></script>
<script type="text/javascript">
	function daochuExcel(obj) {

		if (!confirm("您确定要导出吗？")) {
			return;
		}
		var id = $("#id").val();
		var channelid = $("#channelid").val();
		var code = $("#code").val();

		var begintime = $("#begintime").val();
		var endtime = $("#endtime").val();

		if (begintime == null || begintime == "") {
			alert("请完善开始时间");
			return;
		}

		if (endtime == null || endtime == "") {
			alert("请完善结束时间");
			return;
		}
		var projectname = $("#projectname").val();
		// alert("id="+id+";countryCode="+countryCode+";begintime="+begintime+";endtime="+endtime+";projectname="+projectname);
		$("body")
				.append(
						"<a id=exportExcel  href='${ctx }/devicestatistics/excelExportDeviceData?channelid="
								+ channelid
								+ "&begintime="
								+ begintime
								+ "&code="
								+ code
								+ "&endtime="
								+ endtime
								+ "'></a>");
		document.getElementById("exportExcel").click();
		$("#exportExcel").remove();

	}
</script>
</head>
<body>
	<div class="row">
		<div class="col-sm-12">
			<h1 class="page-header">设备导出</h1>
		</div>
	</div>
	<div class="row">
		<div class="col-sm-12">
			<div class="panel panel-default">
				<div class="panel-heading text-right">
					<div class="row">
						<form class="form-inline" role="form"
							action="${ctx }/devicestatistics/datalistsize" method="get">


							<!-- 国家 -->
							<div class="form-group">
								<div class="input-group">
									<div class="input-group-addon">国家:</div>
									<select class="form-control" name="code" id="code">
										<option value="0">请选择</option>
										<c:forEach var="con" items="${countrylist}">
											<%--<option value="${con.code}">${con.cnname}</option> --%>
											<option value="${con.code}"
												<c:if test="${hbCountrys.cid==con.cid}">selected</c:if>>${con.cnname}</option>
										</c:forEach>
									</select>  
								</div>
							</div>

							<!-- 渠道搜索 -->
							<div class="form-group">
								<div class="input-group">
									<div class="input-group-addon">渠道:</div>
									<select class="form-control" name="channelid" id="channelid">
										<option value="0">请选择</option>
										<c:forEach var="item" items="${channellist}">
<%-- 											<option value="${item.id}">${item.channelname}</option> --%>
											<option value="${item.id}"
												<c:if test="${channel.id==item.id}">selected</c:if>>${item.channelname}</option>
										</c:forEach>
									</select>
								</div>
							</div>
							<!-- 开始时间 -->
							<div class="form-group">
								<div class="input-group">
									<div class="input-group-addon">开始日期:</div>
									<input class="form-control" name="begintime" id="begintime"
										type="text" placeholder="输入开始日期"
										onClick="WdatePicker({dateFmt:'yyyy-MM-dd'})"
										value="${begintime }">
								</div>
							</div>
							<!-- 结束时间 -->
							<div class="form-group">
								<div class="input-group">
									<div class="input-group-addon">结束日期:</div>
									<input class="form-control" name="endtime" id="endtime"
										type="text" placeholder="输入结束时间"
										onClick="WdatePicker({dateFmt:'yyyy-MM-dd'})"
										value="${endtime}">
								</div>
							</div>
							<button type="submit" class="btn btn-primary">查询</button>
							<!-- 	<button type="submit" class="btn btn-primary" >统计</button> -->
							<a class="btn btn-primary" id="daochu"
								onmousedown="daochuExcel(this);" href=""> <span
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

							</thead>
							<tbody>

							</tbody>
						</table>
						<div class="row">
							<div class="col-sm-12 text-center">
								<ul class="pagination">
								</ul>
								<c:if test="${not empty total }">imei总数量为:${total }</c:if>
							</div>
						</div>
					</div>
				</div>
			</div>
		</div>
	</div>
</body>
</html>
