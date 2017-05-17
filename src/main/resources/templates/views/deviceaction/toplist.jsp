<%@page language="java" contentType="text/html; charset=UTF-8"%>
<%@ include file="/common/taglibs.jsp"%>
<!DOCTYPE html>
<html lang="en">
<head>
<script type="text/javascript" src="${ctx }/js/plugins/My97DatePicker/WdatePicker.js"></script>
<script type="text/javascript">
function daochuExcel(obj){

    if(!confirm("您确定要导出吗？"))
    {
        return;
    }
    var countryCode=$("#countryCode").val();
    var begintime=$("#begintime").val();
    var endtime=$("#endtime").val();
    var channelid=$("#channelid").val();
   // alert("countryCode="+countryCode+";begintime="+begintime+";endtime="+endtime+";size="+size);
     $("body").append("<a id=exportExcel  href='${ctx }/deviceaction/excelExport"
    		 +"?countryCode="+countryCode
    		 +"&begintime="+begintime
    		 +"&endtime="+endtime
    		 +"&channelid="+channelid
    		 +"&objtype="+7
    		 +"&size="+100+"'></a>");
     document.getElementById("exportExcel").click();
     $("#exportExcel").remove();  

}

</script>
</head>
<body>
	<div class="row">
		<div class="col-sm-12">
			<h1 class="page-header">
			 话题点击量统计
			</h1>
		</div>
	</div>
	<div class="row">
		<div class="col-sm-12">
			<div class="panel panel-default">
				<div class="panel-heading text-right">
					<div class="row">
						<form class="form-inline" role="form" action="" method="get">
						  
							    
							  <!-- 国家搜索 -->
                              <div class="form-group">
							      <div class="input-group">
									<div class="input-group-addon">国家:</div>
									    <select class="form-control" name="countryCode" id="countryCode">
									    <option value="00">请选择</option>
									       <c:forEach var="item" items="${hbcountrysSort}">
											<option value="${item.code}"
												<c:if test="${countryCode==item.code}">selected</c:if>>${item.code} ${item.cnname}</option>
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
											<option value="${item.id}"
												<c:if test="${channelid==item.id}">selected</c:if>> ${item.channelname}</option>
											</c:forEach>
									    </select>
								  </div>
							     </div>     
							  <!-- 开始时间 -->  
							     <div class="form-group">
							    <div class="input-group">
							      <div class="input-group-addon">开始日期:</div>
							    <%-- <fmt:formatDate var="begintime_format" value="${begintime}" type="date" pattern="yyyy-MM-dd HH:mm:ss"/> --%>
							      <input class="form-control" name="begintime" id="begintime" type="text" placeholder="输入开始日期" onClick="WdatePicker({dateFmt:'yyyy-MM-dd'})" value="${begintime }">
							    </div>
							  </div> 
							  <!-- 结束时间 -->
							  <div class="form-group">
							    <div class="input-group">
							      <div class="input-group-addon">结束日期:</div>
							      <%-- <fmt:formatDate var="endtime_format" value="${endtime}" type="date" pattern="yyyy-MM-dd HH:mm:ss"/> --%>
							      <input class="form-control" name="endtime" id="endtime" type="text" placeholder="输入结束时间" onClick="WdatePicker({dateFmt:'yyyy-MM-dd'})"  value="${endtime}">
							    </div>
							  </div>
							
							<button type="submit" class="btn btn-primary" >统计</button>
							&nbsp;&nbsp; 
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
									<th>话题</th>
									<th>
									  <p>点击量</p>
									</th>
								</tr>
							</thead>
							<tbody>
								<c:forEach var="item" items="${list}">
									<tr class="id" value="${item.artid }">
										<td>${item.artid}</td>
										<td>
									      ${item.count}
										</td>
									</tr>
								</c:forEach>
							</tbody>
						</table>
						<div class="row">
							<div class="col-sm-12 text-center">
								<ul class="pagination">
									

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
