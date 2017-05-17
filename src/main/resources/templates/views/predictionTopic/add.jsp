<%@page language="java" contentType="text/html; charset=UTF-8"%>
<%@ include file="/common/taglibs.jsp"%>
<!DOCTYPE html>
<html lang="en">
<head>
<script type="text/javascript"
	src="${ctx }/js/plugins/My97DatePicker/WdatePicker.js"></script>
<link rel="stylesheet" href="${ctx }/css/jquery.fileupload.css">
</head>
<body>
	<div class="row">
		<div class="col-sm-12">
			<h1 class="page-header">修改竞猜</h1>
		</div>
	</div>
	<div class="row">
		<div class="col-sm-12">
			<div class="panel panel-default">
				<div class="panel-heading">请填写以下选项：</div>
				<div class="panel-body">
					<div class="col">
						<form id="addUserInfoform" class="form-horizontal"
							action="${ctx }/predictionTopic/saveorupdate" method="post">
							<input name="id" type="hidden" value="${predictionTopic.id }" />
							<div class="col-sm-6">
						         <div class="form-group">
									<label for="input01" class="control-label col-sm-2">开始日期：</label>
									<div class="controls col-sm-8">
									<fmt:formatDate var="starttime_format" value="${predictionTopic.starttime}" type="date" pattern="yyyy-MM-dd HH:mm:ss"/>
							      <input class="form-control" name="starttime_format" type="text" placeholder="输入开始日期" onClick="WdatePicker({dateFmt:'yyyy-MM-dd HH:mm:ss'})" value="${starttime_format }">
									</div>
								</div> 
						     <div class="form-group">
									<label for="input01" class="control-label col-sm-2">结束日期：</label>
									<div class="controls col-sm-8">
							      <fmt:formatDate var="endtime_format" value="${predictionTopic.endtime}" type="date" pattern="yyyy-MM-dd HH:mm:ss"/>
							      <input class="form-control" name="endtime_format" type="text" placeholder="输入结束时间" onClick="WdatePicker({dateFmt:'yyyy-MM-dd HH:mm:ss'})"  value="${endtime_format}">
									</div>
								</div> 
						   
						   
								 <div class="form-group">
									<label for="input01" class="control-label col-sm-2">状态：</label>
									<div class="controls col-sm-8">
										<select id="status" name="status" class="form-control">

											<option value="0"
												<c:if test="${predictionTopic.status=='0'}">selected</c:if>>正常</option>
											<option value="1"
												<c:if test="${predictionTopic.status=='1'}">selected</c:if>>未激活</option>
												<option value="4"
												<c:if test="${predictionTopic.status=='4'}">selected</c:if>>失效</option>
										</select>
									</div>
								</div> 
							</div>

							<div class="form-actions">
								<div class="col-sm-1"></div>
								<div class="col-sm-12 text-center">
									<a href="${ctx }/predictionTopic/list" class="btn btn-info"><span
										class="fa fa-arrow-left fa-fw"></span> 返回</a> &nbsp;&nbsp;
									<button class="btn btn-primary" type="submit">
										<span class="fa fa-floppy-o fa-fw"></span>
										修改竞猜
									</button>
								</div>
							</div>
						</form>
					</div>
				</div>
			</div>
		</div>
	</div>

	<script type="text/javascript" src="${ctx }/js/jquery.ui.widget.js"></script>
	<script type="text/javascript" src="${ctx }/js/jquery.fileupload.js"></script>
	<script type="text/javascript">
		$(function () {
		    $('#fileupload').fileupload({
		        url: '${ctx}/upload/upyun',
		        dataType: 'json',
		        done: function (e, data) {
		        	$("#titlepicimg").attr("src",""+data.result.imgsrc+"");
		        	$("#titlepicimg").attr("class","col-sm-8");
		        	$("#titlepic").attr("value",data.result.imgpath);
		        },
		        progressall: function (e, data) {
		            var progress = parseInt(data.loaded / data.total * 100, 10);
		            $('#progress .progress-bar').css('width',progress + '%' );
		        }
		    }).prop('disabled', !$.support.fileInput)
		        .parent().addClass($.support.fileInput ? undefined : 'disabled');
		});
	</script>


</body>

</html>
