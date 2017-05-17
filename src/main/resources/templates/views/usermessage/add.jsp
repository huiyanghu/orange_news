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
			<h1 class="page-header">修改消息</h1>
		</div>
	</div>
	<div class="row">
		<div class="col-sm-12">
			<div class="panel panel-default">
				<div class="panel-heading">请填写以下选项：</div>
				<div class="panel-body">
					<div class="col">
						<form id="addUserInfoform" class="form-horizontal"
							action="${ctx }/usermessage/saveorupdate" method="post">
							<input name="id" type="hidden" value="${usermessage.id }" />
							<input name="sysuid" type="hidden" value="${usermessage.sysuid }" />
							<div class="col-sm-6">
							<div class="form-group">
									<label for="input01" class="control-label col-sm-2">uuid：</label>
									<div class="controls col-sm-8">
										<input type="text" name="uuid"
											class="form-control" value="${usermessage.uuid}"  />
											注：类型为系统消息时不用填写
									</div>
								</div>
								<div class="form-group">
									<label for="input01" class="control-label col-sm-2">标题：</label>
									<div class="controls col-sm-8">
										<input type="text" name="title"
											class="form-control" value="${usermessage.title}" required />
									</div>
								</div>
								<div class="form-group">
									<label for="input01" class="control-label col-sm-2">内容：</label>
									<div class="controls col-sm-8">
									  <textarea name="content" class="form-control" rows="3" cols="10">
									      ${usermessage.content }
									  </textarea>
									</div>
								</div>
                                  <div class="form-group">
									<label for="input01" class="control-label col-sm-2">消息类型：</label>
									<div class="controls col-sm-8">
										<select id="itype" name="itype" class="form-control">
											<option value="0"
												<c:if test="${usermessage.itype=='0'}">selected</c:if>>系统消息</option>
											<option value="2"
												<c:if test="${usermessage.itype=='2'}">selected</c:if>>个人消息</option>
										</select>
									</div>
								</div> 
				
								 <div class="form-group">
									<label for="input01" class="control-label col-sm-2">状态：</label>
									<div class="controls col-sm-8">
										<select id="status" name="status" class="form-control">

											<option value="0"
												<c:if test="${usermessage.status=='0'}">selected</c:if>>正常</option>
											<option value="1"
												<c:if test="${usermessage.status=='1'}">selected</c:if>>禁用</option>
										</select>
									</div>
								</div> 
							</div>

							<div class="form-actions">
								<div class="col-sm-1"></div>
								<div class="col-sm-12 text-center">
									<a href="${ctx }/usermessage/list" class="btn btn-info"><span
										class="fa fa-arrow-left fa-fw"></span> 返回</a> &nbsp;&nbsp;
									<button class="btn btn-primary" type="submit">
										<span class="fa fa-floppy-o fa-fw"></span>
										修改消息 
										
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
