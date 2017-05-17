<%@page language="java" contentType="text/html; charset=UTF-8"%>
<%@ include file="/common/taglibs.jsp"%>
<!DOCTYPE html>
<html lang="en">
<head>
</head>
<body>
			<div class="row">
			<div class="col-sm-12">
				<h1 class="page-header">代码</h1>
			</div>
		</div>
		<div class="row">
			<div class="col-sm-12">
				<div class="panel panel-default">
					<div class="panel-heading">生成的代码</div>
					<div class="panel-body">
						<div class="row">
							<form>
								<div class="form-group col-xs-12">
									<label for="input01" class="control-label col-sm-2">安卓代码：</label>
									<div class="controls col-sm-8">
										<pre>${androidCode}</pre>
									</div>
								</div>
								<div class="form-group col-xs-12">
									<label for="input01" class="control-label col-sm-2">IOS代码：</label>
									<div class="controls col-sm-8">
										<pre>${IOSCode}</pre>
									</div>
								</div>
								<div class="form-actions">
									<div class="col-sm-1"></div>
									<div class="col-sm-8">
										<a href="${ctx }/event/list" class="btn btn-info"><span class="fa fa-arrow-left fa-fw"></span> 返回</a>
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
