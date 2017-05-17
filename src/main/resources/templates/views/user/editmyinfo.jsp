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
								action="${ctx }/user/updatemyinfo" method="post">
								<div class="form-group">
									<label for="input01" class="control-label col-sm-2">用户名：</label>
									<div class="controls col-sm-8">
										${sysuser.username}
									</div>
								</div>
								
								<%-- <div class="form-group">
									<label for="input01" class="control-label col-sm-2">密码：</label>
									<div class="controls col-sm-8">
										<input type="password" name="password" id="password"
											class="form-control" value="${sysuser.password}"
											required />
									</div>
								</div> --%>
								
								<div class="form-group">
									<label for="input01" class="control-label col-sm-2">真实姓名：</label>
									<div class="controls col-sm-8">
										<input type="text" name="truename" id="truename"
											class="form-control" value="${sysuser.truename}"
											required />
									</div>
								</div>
								<div class="form-group">
									<label for="input01" class="control-label col-sm-2">身份证：</label>
									<div class="controls col-sm-8">
										<input type="text" name="identity" id="identity"
											class="form-control" value="${sysuser.identity}"
											/>
									</div>
								</div>
								<div class="form-group">
									<label for="sex" class="control-label col-sm-2">性别：</label>
									<div class="col-sm-8">
										<label class="radio-inline">
											<input type="radio" name="sex" id="sex1" value="0" ${sysuser.sex==0?"checked":""} />男
										</label>
										<label class="radio-inline">
											<input type="radio" name="sex" id="sex2" value="1" ${sysuser.sex==1?"checked":""}/>女
										</label>
									</div>
								</div>
								<div class="form-group">
									<label for="input01" class="control-label col-sm-2">邮箱：</label>
									<div class="controls col-sm-8">
										<input type="text" name="email" id="email"
											class="form-control" value="${sysuser.email}"
											/>
									</div>
								</div>
								<div class="form-group">
									<label for="mobilephone" class="control-label col-sm-2">手机：</label>
									<div class="controls col-sm-8">
										<input type="text" name="mobilephone" id="mobilephone"
											class="form-control" value="${sysuser.mobilephone}"
											/>
									</div>
								</div>
								<div class="form-group">
									<label for="telphone" class="control-label col-sm-2">座机：</label>
									<div class="controls col-sm-8">
										<input type="text" name="telphone" id="telphone"
											class="form-control" value="${sysuser.telphone}"
											/>
									</div>
								</div>
								<div class="form-group">
									<label for="fax" class="control-label col-sm-2">传真：</label>
									<div class="controls col-sm-8">
										<input type="text" name="fax" id="fax"
											class="form-control" value="${sysuser.fax}"
											/>
									</div>
								</div>
								<div class="form-group">
									<label for="input01" class="control-label col-sm-2">QQ：</label>
									<div class="controls col-sm-8">
										<input type="text" name="qq" id="qq"
											class="form-control" value="${sysuser.qq}"
											/>
									</div>
								</div>
								<div class="form-actions">
									<div class="col-sm-1"></div>
									<div class="col-sm-8">
										<button class="btn btn-primary" type="submit"><span class="fa fa-floppy-o fa-fw"></span> 更新个人资料</button>
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
