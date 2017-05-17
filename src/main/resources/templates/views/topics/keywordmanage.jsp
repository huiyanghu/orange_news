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
			<h1 class="page-header">【${hbtopic.name }】关键字管理</h1>
		</div>
	</div>
	<div class="row">
		<div class="col-sm-12">
			<div class="panel panel-default">
				<div class="panel-heading">填写关键字</div>
				<div class="panel-body">
					<div class="row">
						<form id="addform" class="form-horizontal" action="${ctx }/topics/keywordedit" method="post">
							<input name="tid" type="hidden" value="${hbtopic.tid }" />
							<table class="table table-striped table-bordered table-hover"
							id="dataTables-example">
							<thead>
								<tr>
									<th>国家图标</th>
									<th>国家名称</th>
									<th>话题关键字</th>
									<!-- <th><input type="checkbox" id="allcheckbox"></th> -->
									<th></th>

								</tr>
							</thead>
							<tbody>
							
								<c:forEach var="appcountryVo" items="${appcountryvos }">
									<tr>
										<td><img src="${upyunhttp}${appcountryVo.countryicon}!30" id="titlepicimg" ></td>
										<td>${appcountryVo.cnname }</td>
										<td><textarea id="keyword${appcountryVo.cid}" rows="2" cols="40" name="keyname" <c:if test="${appcountryVo.ischecked ==0 }">disabled</c:if>>${appcountryVo.keyword}</textarea></td>
										<td><input type="checkbox" name="countryid" value="${appcountryVo.cid}" <c:if test="${appcountryVo.ischecked ==1 }">checked</c:if>></td>
									</tr>
								</c:forEach>	

							</tbody>
							</table>						
							<div class="form-actions">
								<div class="col-sm-1"></div>
								<div class="col-sm-8">
									<a href="${ctx }/topics/list" class="btn btn-info"><span
										class="fa fa-arrow-left fa-fw"></span> 返回</a> &nbsp;&nbsp;
									<button class="btn btn-primary" type="submit">
										<span class="fa fa-floppy-o fa-fw"></span>
										更新国家话题关键字
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
				/* var ranktd = "#rank"+tid; */
				if($(this).is(':checked')){
					$(keytd).removeAttr("disabled");
					/* $(ranktd).removeAttr("disabled"); */
				}else{
					$(keytd).attr("disabled",true);
				/* 	$(ranktd).attr("disabled",true); */
				}
			});
			$("#allcheckbox").click(function(){ 
			    if(this.checked){
			        $("input[name='countryid']").each(function(){
			            this.checked = true;
			        }); 
			    }else{ 
			        $("input[name='countryid']").each(function(){
			            this.checked = false;
			        }); 
			    } 
			});
		});
	</script>
	</body>
</html>
