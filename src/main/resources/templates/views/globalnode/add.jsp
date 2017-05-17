<%@page language="java" contentType="text/html; charset=UTF-8"%>
<%@ include file="/common/taglibs.jsp"%>
<!DOCTYPE html>
<html lang="en">
<head>
	<script type="text/javascript" src="${ctx }/js/plugins/My97DatePicker/WdatePicker.js"></script>
	<link rel="stylesheet" href="${ctx }/css/jquery.fileupload.css">
</head>
<body>
			<div class="row">
			<div class="col-sm-12">
				<h1 class="page-header">添加</h1>
			</div>
		</div>
		<div class="row">
			<div class="col-sm-12">
				<div class="panel panel-default">
					<div class="panel-heading">请填写以下选项：</div>
					<div class="panel-body">
						<div class="row">
							<form id="addUserInfoform" class="form-horizontal"
								action="${ctx }/globalnode/saveorupdate" method="post">
								<input name="id" type="hidden" value="${bean.id }" />
							<div class="col-sm-6">
								<div class="form-group">
									<label for="input01" class="control-label col-sm-2">nodecode：</label>
									<div class="controls col-sm-8">
										<input type="text" name="nodecode" id="nodecode" class="form-control" value="${bean.nodecode }" required />
									</div>
								</div>
								<div class="form-group">
									<label for="input01" class="control-label col-sm-2">nodename：</label>
									<div class="controls col-sm-8">
										<input type="text" name="nodename" id="nodename" class="form-control" value="${bean.nodename }" required />
									</div>
								</div>
							</div>
							
							<div class="form-actions">
									<div class="col-sm-12 text-center">
										<a href="${ctx }/globalnode/list" class="btn btn-info"><span class="fa fa-arrow-left fa-fw"></span> 返回</a>
										&nbsp;&nbsp;
										<button class="btn btn-primary" type="submit"><span class="fa fa-floppy-o fa-fw"></span> 
									提交</button>
									</div>
								</div>
								
							</form>
						</div>
					</div>
				</div>
			</div>
		</div>
		
		<script type="text/javascript" src="${ctx }/js/jquery.ui.widget.js"></script>
	
</body>
</html>
