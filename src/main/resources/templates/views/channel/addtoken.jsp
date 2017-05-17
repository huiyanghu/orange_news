<%@page language="java" contentType="text/html; charset=UTF-8"%>
<%@ include file="/common/taglibs.jsp"%>
<!DOCTYPE html>
<html lang="en">
<head>
	<script type="text/javascript" src="${ctx }/js/plugins/My97DatePicker/WdatePicker.js"></script>
</head>
<body>
	<div class="row">
		
		<div class="col-sm-12">
			<h1 class="page-header">编辑token</h1>
		</div>
	</div>
	<div class="row">
		<div class="col-sm-12">
			<div class="panel panel-default">
				<div class="panel-heading">编辑token</div>
				<div class="panel-body">
					<div class="row col-sm-8">
						<form id="addform" class="form-horizontal" action="${ctx }/channel/tokensaveorupdate" method="post">
							<input name="id" type="hidden" value="${channel.id }" />
							<div class="form-group">
								<label for="channelname" class="control-label col-sm-2">access_token：</label>
								<div class="controls col-sm-8">
									<input type="text" name="access_token" id="access_token"
										class="form-control" value="${channel.access_token }" required
										required-message="请输入access_token" />
								</div>
							</div>
							
								
							<div class="form-actions">
								<div class="col-sm-1"></div>
								<div class="col-sm-8">
									<a href="${ctx }/channel/list" class="btn btn-info"><span
										class="fa fa-arrow-left fa-fw"></span> 返回</a> &nbsp;&nbsp;
									<button class="btn btn-primary" type="submit">
										<span class="fa fa-floppy-o fa-fw"></span>
										编辑token
									</button>
								</div>
							</div>
						</form>
					</div>
				</div>
			</div>
		</div>
	</div>
	</body>
</html>
