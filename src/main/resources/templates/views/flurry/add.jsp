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
			<h1 class="page-header">导入</h1>
		</div>
	</div>
	<div class="row">
		<div class="col-sm-12">
			<div class="panel panel-default">
				<div class="panel-heading">请填写以下选项：</div>
				<div class="panel-body">
					<div class="col">
						<form id="addUserInfoform" class="form-horizontal"
							action="${ctx }/coolookdata/saveorupdate" method="post" enctype="multipart/form-data">
							<div class="col-sm-6">
								<div class="form-group">
									<label for="input01" class="control-label col-sm-2">标题：</label>
									<div class="controls col-sm-8">
									 <input id="fileUpload" class="form-control" type="file" name="file"  multiple  data-show-preview="true">  
									
										<%-- <input type="text" name="title"
											class="form-control" value="${userjob.title}" required /> --%>
									</div>
								</div>
								</div>

							<div class="form-actions">
								<div class="col-sm-1"></div>
								<div class="col-sm-12 text-center">
									<a href="${ctx }/coolookdata/list" class="btn btn-info"><span
										class="fa fa-arrow-left fa-fw"></span> 返回</a> &nbsp;&nbsp;
									<button class="btn btn-primary" type="submit">
										<span class="fa fa-floppy-o fa-fw"></span>
										提交
										<%-- <c:if test="${usercomment.id>0}">修改文章</c:if>
										<c:if test="${usercomment.id==0}">添加文章</c:if> --%>
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
