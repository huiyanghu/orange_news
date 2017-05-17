<%@page language="java" contentType="text/html; charset=UTF-8"%>
<%@ include file="/common/taglibs.jsp"%>
<!DOCTYPE html>
<html lang="en">
<head>
<script type="text/javascript" src="${ctx }/js/plugins/My97DatePicker/WdatePicker.js"></script>
<script type="text/javascript" src="${ctx}/highcharts/highcharts.js"></script>
</head>
<body>
	<div class="row">
		<div class="col-sm-12">
			<h1 class="page-header">按国家查看统计图</h1>
		</div>
	</div>
	<div class="row">
		<div class="col-sm-12">
			<div class="panel panel-default">
				<div class="panel-heading text-right">
					<div class="row">
							<form class="form-inline" role="form" action="" method="get">
							  <div class="form-group">
							    <div class="input-group">
							      <div class="input-group-addon">国家:</div>
							      <select name="countryid" id="countryid" class="form-control">
							      		<option value="">请选择</option>
							      		<option value="0" >所有国家</option>
							      		<c:forEach var="uitem" items="${countrysSort }">
							      			<option value="${uitem.cid }" >${uitem.code } ${uitem.cnname }</option>
							      		</c:forEach>
							      </select>
							    </div>
							  </div>
							  <div class="form-group">
							    <div class="input-group">
							      <div class="input-group-addon">渠道:</div>
							      <select name="channelid" id="channelid" class="form-control">
							      		<option value="">请选择</option>
							      		<option value="1" >hb</option>
							      		<option value="2" >gwm</option>
							      		<option value="3" >自编</option>
							      </select>
							    </div>
							  </div>
							  
							  <div class="form-group">
							    <div class="input-group">
							      <div class="input-group-addon">话题:</div>
							      <select name="topicsid" id="topicsid" class="form-control">
							      		<option value="">请选择</option>
							      		<c:forEach var="item" items="${topics }">
							      			<option value="${item.tid }" >${item.name }</option>
							      		</c:forEach>
							      </select>
							    </div>
							  </div>
							  
							  <div class="form-group">
							    <div class="input-group">
							      <div class="input-group-addon">开始日期:</div>
							      <input class="form-control" name="starttime" id="starttime" type="text" placeholder="输入开始日期"  value="" onClick="WdatePicker()"/>
							    </div>
							  </div>
							  <div class="form-group">
							    <div class="input-group">
							      <div class="input-group-addon">结束日期:</div>
							      <input class="form-control" name="endtime" id="endtime" type="text" placeholder="输入结束日期"  value="" onClick="WdatePicker()"/>
							    </div>
							  </div>
							   
							   <input type="button" value="曲线图" id="button" onclick="lookstatistic() "/>
							   <a href="${ctx}/grabstatistic/formlist"><input type="button" value="表格列表" id="button"/></a>
							</form>
						</div>
				
				
					<div class="panel-body">
				
						<div class="controls col-sm-12 text-center">
							<div id="container"></div>
					
					
						</div>
				</div>
			</div>
		</div>
		</div>
	</div>
	
	<script type="text/javascript">
	
	function lookstatistic(){
		var countryid = $('#countryid').val();
		var topicsid = $('#topicsid').val();
		var channelid = $('#channelid').val();
		var starttime = $('#starttime').val();
		var endtime = $("#endtime").val();
		
		$.getJSON('${ctx}/grabstatistic/ajaxgetdate',
					{countryid:countryid,
						topicsid:topicsid,channelid:channelid,
						starttime:starttime,endtime:endtime	},		
				function(data){
							var total = new Array();
							var pictotal = new Array();
							var dates = new Array();
							var j = 0;
							$.each(data.root,function(i,item){
								total[j] = item.total;
								pictotal[j] = item.pictotal;
								dates[j] = item.date;
								j = j+1;
							})
							
							 $('#container').highcharts({
								
								chart:{ type: 'line'},
								title:{ text:'统计图'},
								xAxis:{
										categories: dates
									},
								yAxis:{
									 plotLines: [{ value: 0, width: 1, color: '#808080' }]
									},
							
								series: [{ name: '所有数量', data: total  }, 
									     { name: '带图数量', data: pictotal}]
								
							}); 
						})
	}
	
	</script>
	
</body>
</html>
