<%@page language="java" contentType="text/html; charset=UTF-8"%>
<%@ include file="/common/taglibs.jsp"%>
<!DOCTYPE html>
<html lang="en">
<head>
</head>
<body>
			<div class="row">
			<div class="col-sm-12">
				<h1 class="page-header">添加用户</h1>
			</div>
		</div>
		<div class="row">
			<div class="col-sm-12">
				<div class="panel panel-default">
					<div class="panel-heading">请填写以下选项：</div>
					<div class="panel-body">
						<div class="row">

							<form id="addUserInfoform" class="form-horizontal"
								action="${ctx }/role/saveorupdate" method="post">
								<input name="parentid" type="hidden" value="${pid }" />
								<div class="form-group">
									<label for="input01" class="control-label col-sm-2">角色名称：</label>
									<div class="controls col-sm-8">
										<input type="text" name="rolename" id="rolename"
											class="input-xlarge" value="${role.rolename }"
											required />
									</div>
								</div>

								<div class="form-group">
									<label for="textarea" class="control-label col-sm-2">父级角色：</label>
									<div class="controls col-sm-8">
										<input type="text" name="pname" id="pname"
											class="input-xlarge" value="${pname }" required
											required-message="昵称不允许为空" readonly="readonly" />
									</div>
								</div>



								<div class="form-actions">
									<div class="col-sm-1"></div>
									<div class="col-sm-8">
										<a href="${ctx }/role/list.html" class="btn btn-info"><span class="fa fa-arrow-left fa-fw"></span> 返回</a>
										&nbsp;&nbsp;
										<button class="btn btn-primary" type="submit"><span class="fa fa-floppy-o fa-fw"></span> 添加角色</button>
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
