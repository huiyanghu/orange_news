<%@page language="java" contentType="text/html; charset=UTF-8"%>
<%@ include file="/common/taglibs.jsp"%>
<!DOCTYPE html>
<html lang="en">
<head>
<script type="text/javascript"
	src="${ctx }/js/plugins/My97DatePicker/WdatePicker.js"></script>
<script type="text/javascript">
function checkout(obj){
	var urls=$("#urls").val();
	var flag=true;
	if(urls==null || urls==""){
		flag=false;
		alert("请完善urls内容");
	}
	if(flag){
	   $(obj).attr("type","submit");
	}
}
</script>
	
<link rel="stylesheet" href="${ctx }/css/jquery.fileupload.css">
</head>
<body>
	<div class="row">
		<div class="col-sm-12">
			<h1 class="page-header">编辑证明</h1>
		</div>
	</div>
	<div class="row">
		<div class="col-sm-12">
			<div class="panel panel-default">
				<div class="panel-heading">请填写以下选项：</div>
				<div class="panel-body">
					<div class="col">
						<form id="addUserInfoform" class="form-horizontal"
							action="${ctx }/predictionProveReport/saveorupdate" method="post">
							<input name="id" type="hidden" value="${predictionProveReport.id }" />
							<input name="flag" type="hidden" value="${flag }" />
							<div class="col-sm-6">
							<c:if test="${empty predictionProveReport.id }">
								
							 <div class="form-group">
									<label for="input01" class="control-label col-sm-2">竞猜id：</label>
									<div class="controls col-sm-8">
										<input class="form-control" name="pid" type="text" value="${predictionProveReport.pid }"/>
									</div>
							</div> 
							
							 <div class="form-group">
									<label for="input01" class="control-label col-sm-2">详情：</label>
									<div class="controls col-sm-8">
									<textarea rows="5" cols="45" name="desc"></textarea>
									</div>
							</div> 
							
							 <div class="form-group">
									<label for="input01" class="control-label col-sm-2">urls：</label>
									<div class="controls col-sm-8">
									<textarea rows="5" cols="45" id="urls" name="urls"></textarea>
									</div>
							</div> 
							 
							</c:if>
							<c:if test="${not empty predictionProveReport.id }">
							 <div class="form-group">
									<label for="input01" class="control-label col-sm-2">状态：</label>
									<div class="controls col-sm-8">
										<select id="status" name="status" class="form-control">
											<option value="0"
												<c:if test="${predictionProveReport.status=='0'}">selected</c:if>>未审核</option>
												<option value="2"
												<c:if test="${predictionProveReport.status=='2'}">selected</c:if>>已选用</option>
										</select>
										<input name="pid" type="hidden" value="${predictionProveReport.pid }" />
									</div>
								</div> 
							</c:if>
							
							</div>
								<c:if test="${empty predictionProveReport.id }">
							<div class="col-sm-6">
										<div class="form-group">
											<label for="input01" class="control-label col-sm-2">证明图片：</label>
											<div class="controls col-sm-2">
													<span class="btn btn-success fileinput-button">
												  					<span>上传图片</span>
				       										 		<input id="fileupload" type="file" name="file" multiple>
				        							</span>
												<input type="hidden" name="picpath" id="img" value="${predictionProveReport.picpath }" />
											</div>
											<div class="col-sm-2">
												<div id="progress" class="progress">
											        <div id="progress" class="progress-bar progress-bar-success"></div>
											 	</div>
											 </div>
										</div>
										
										<div class="form-group">
										<label class="control-label col-sm-2">证明图片：</label>
										<div class="controls col-sm-8">
											<c:choose>
		        									<c:when test="${predictionProveReport.picpath != null&&predictionProveReport.picpath != '' }">
		        										<img src="${upyunhttp }${predictionProveReport.picpath}" id="titlepicimg" class="col-sm-8">
		        									</c:when>
		        									<c:otherwise>
														<img src="" id="titlepicimg">
		        									</c:otherwise>
		        								</c:choose>
					    						
										</div>
									</div>
							</div>
							</c:if>
							<div class="form-actions">
								<div class="col-sm-1"></div>
								<div class="col-sm-12 text-center">
									<a href="${ctx }/predictionProveReport/list?id=${predictionProveReport.id }&flag=${flag}" class="btn btn-info"><span
										class="fa fa-arrow-left fa-fw"></span> 返回</a> &nbsp;&nbsp;
									<button class="btn btn-primary" 
									<c:if test="${empty predictionProveReport.id }">type="button" onclick="checkout(this)"</c:if>
									<c:if test="${not empty predictionProveReport.id }">type="submit"</c:if>
									>
										<span class="fa fa-floppy-o fa-fw"></span>
										编辑证明
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
		        	$("#img").attr("value",data.result.imgpath);
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
