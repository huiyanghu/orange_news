<%@page language="java" contentType="text/html; charset=UTF-8"%>
<%@ include file="/common/taglibs.jsp"%>
<!DOCTYPE html>
<html lang="en">
<head>
<link rel="stylesheet" href="${ctx }/css/jquery.fileupload.css">
</head>
<body>
	<div class="row">
		<div class="col-sm-12">
			<h1 class="page-header">【${country.cnname }】话题管理</h1>
		</div>
	</div>
	<div class="row">
		<div class="col-sm-12">
			<div class="panel panel-default">
				<div class="panel-heading">请选择话题</div>
				<div class="panel-body">
					<div class="row">
						<form id="addform" class="form-horizontal" action="${ctx }/country/topicsupdate" method="post">
							<input name="cid" type="hidden" value="${country.cid }" />
							<table class="table table-striped table-bordered table-hover"
							id="dataTables-example">
							<thead>
								<tr>
									<th>话题图标</th>
									<th>话题类型</th>
									<th>话题名称</th>
									<th>话题关键字</th>
									<th>话题排序</th>
									<th><input type="checkbox" id="allcheckbox"></th>

								</tr>
							</thead>
							<tbody>
							
								<c:forEach var="topcisvo" items="${apptopicsvos }">
									<tr>
										<td><img src="${topcisvo.topicicon}!30" id="titlepicimg" ></td>
										<td><c:if test="${topcisvo.topicstype ==0}">Hubii</c:if><c:if test="${topcisvo.topicstype ==1}">自编</c:if></td>
										<td>${topcisvo.name }</td>
										<td><textarea id="keyword${topcisvo.tid }" rows="2" cols="40" name="keywords" <c:if test="${topcisvo.ischecked ==0 }">disabled</c:if>>${topcisvo.keyword }</textarea></td>
										<td><input id="rank${topcisvo.tid }" name="ranks" type="text" size="2" value="${topcisvo.rank }" <c:if test="${topcisvo.ischecked ==0 }">disabled</c:if>/></td>
										<td><input type="checkbox" name="topics" value="${topcisvo.tid }" <c:if test="${topcisvo.ischecked ==1 }">checked</c:if>></td>
									</tr>
								</c:forEach>	

							</tbody>
							</table>						
							<div class="form-actions">
								<div class="col-sm-1"></div>
								<div class="col-sm-8">
									<a href="${ctx }/country/list" class="btn btn-info"><span
										class="fa fa-arrow-left fa-fw"></span> 返回</a> &nbsp;&nbsp;
									<button class="btn btn-primary" type="submit">
										<span class="fa fa-floppy-o fa-fw"></span>
										更新国家话题
									</button>
								</div>
							</div>
						</form>
					</div>
				</div>
			</div>
		</div>
	</div>
	<script type="text/javascript">
		$(function(){
			$("input:checkbox").click(function(){
				var tid = $(this).val();
				var keytd = "#keyword"+tid;
				var ranktd = "#rank"+tid;
				if($(this).is(':checked')){
					$(keytd).removeAttr("disabled");
					$(ranktd).removeAttr("disabled");
				}else{
					$(keytd).attr("disabled",true);
					$(ranktd).attr("disabled",true);
				}
			});
			$("#allcheckbox").click(function(){ 
			    if(this.checked){
			        $("input[name='topics']").each(function(){
			            this.checked = true;
			        }); 
			    }else{ 
			        $("input[name='topics']").each(function(){
			            this.checked = false;
			        }); 
			    } 
			});
		});
	</script>
	</body>
</html>
