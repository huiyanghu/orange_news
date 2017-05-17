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
    var id=$("#id").val();
    var countryCode=$("#countryCode").val();
    var begintime=$("#begintime").val();
    var endtime=$("#endtime").val();
    var projectname=$("#projectname").val();
   // alert("id="+id+";countryCode="+countryCode+";begintime="+begintime+";endtime="+endtime+";projectname="+projectname);
     $("body").append("<a id=exportExcel  href='${ctx }/devicestatistics/excelExport?id="
    		 +id+"&countryCode="+countryCode
    		 +"&begintime="+begintime
    		 +"&endtime="+endtime
    		 +"&projectname="+projectname+"'></a>");
     document.getElementById("exportExcel").click();
     $("#exportExcel").remove(); 

}

</script>
</head>
<body>
	<div class="row">
		<div class="col-sm-12">
			<h1 class="page-header">
			 设备统计
			</h1>
		</div>
	</div>
	<div class="row">
		<div class="col-sm-12">
			<div class="panel panel-default">
				<div class="panel-heading text-right">
					<div class="row">
						<form class="form-inline" role="form" action="" method="get">
						   <input type="hidden" id="projectname" name="projectname" value="${deviceModel.projectname }"/>
                              <!-- 设备模块名称-->
                              <div class="form-group ">
							      <div class="input-group">
									<div class="input-group-addon">项目名称:</div>
									    <select class="form-control" name="id" id="id">
									       <c:forEach var="item" items="${devicemodels}">
											<option value="${item.id}"
												<c:if test="${id==item.id}">selected</c:if>>${item.projectname}</option>
											</c:forEach>
									    </select>
								  </div>
							     </div> 
							    
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
							    <div class="form-group">
							      <div class="input-group">
									<div class="input-group-addon">去重方式:</div>
									    <select class="form-control" name="type" id="type">
									        <option value="0" <c:if test="${type==0 }">selected="selected"</c:if>>imsi去重</option>
									         <option value="1" <c:if test="${type==1 }">selected="selected"</c:if>>mac去重</option>
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
							<%-- <a href="${ctx }/devicestatistics/excelExport?id="
								class="btn btn-primary" id="add"><span
								class="fa fa-plus-circle fa-fw"></span> 导出</a> --%>
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
									<th>日期</th>
									<th>
									<c:if test="${empty projectname }">项目名称</c:if>
									<c:if test="${not empty projectname }">${projectname }</c:if>
									</th>
								</tr>
							</thead>
							<tbody>
								<c:forEach var="item" items="${list}">
									<tr class="id" value="${item.date }">
										<td>${item.date}</td>
										<td>
									   <c:choose>
									     <c:when test="${fn:contains(item.date,'总和')}"></c:when>
									     <c:otherwise>${item.statisticscount}</c:otherwise>
									   </c:choose>
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
