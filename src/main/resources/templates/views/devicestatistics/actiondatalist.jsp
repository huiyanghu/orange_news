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
    var channelid=$("#channelid").val();
    var begintime=$("#begintime").val();
    var endtime=$("#endtime").val();

    if(begintime==null||begintime==""){
        alert("请完善开始时间");
        return;
    }

    if(endtime==null||endtime==""){
        alert("请完善结束时间");
        return;
    }
  
   // alert("id="+id+";countryCode="+countryCode+";begintime="+begintime+";endtime="+endtime+";projectname="+projectname);
     $("body").append("<a id=exportExcel  href='${ctx }/devicestatistics/excelExportDeviceActionData?channelid="
    		 +channelid
    		 +"&begintime="+begintime
    		 +"&endtime="+endtime+"'></a>");
     document.getElementById("exportExcel").click();
     $("#exportExcel").remove(); 

}

</script>
</head>
<body>
	<div class="row">
		<div class="col-sm-12">
			<h1 class="page-header">
			 设备启动数据导出
			</h1>
		</div>
	</div>
	<div class="row">
		<div class="col-sm-12">
			<div class="panel panel-default">
				<div class="panel-heading text-right">
					<div class="row">
						<form class="form-inline" role="form" action="" method="get">                          
							       <!-- 渠道搜索 -->
                             <div class="form-group">
							      <div class="input-group">
									<div class="input-group-addon">渠道:</div>
									    <select class="form-control" name="channelid" id="channelid">
									   <!--  <option value="0">请选择</option> -->
									       <c:forEach var="item" items="${channellist}">
											  <option value="${item.id}" >${item.channelname}</option>
											</c:forEach>
									    </select>
								  </div>
							     </div>  
							  <!-- 开始时间 -->  
							     <div class="form-group">
							    <div class="input-group">
							      <div class="input-group-addon">开始日期:</div>
							      <input class="form-control" name="begintime" id="begintime" type="text" placeholder="输入开始日期" onClick="WdatePicker({dateFmt:'yyyy-MM-dd'})" value="${begintime }">
							    </div>
							  </div> 
							  <!-- 结束时间 -->
							  <div class="form-group">
							    <div class="input-group">
							      <div class="input-group-addon">结束日期:</div>
							     <input class="form-control" name="endtime" id="endtime" type="text" placeholder="输入结束时间" onClick="WdatePicker({dateFmt:'yyyy-MM-dd'})"  value="${endtime}">
							    </div>
							  </div>
							  
						<!-- 	<button type="submit" class="btn btn-primary" >统计</button> -->
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
								
							</thead>
							<tbody>
								
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
