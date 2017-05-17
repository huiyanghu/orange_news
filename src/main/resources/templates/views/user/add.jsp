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
								action="${ctx }/user/saveorupdate" method="post">
								<input name="userid" type="hidden" value="${sysuser.userid }" />
								<div class="form-group">
									<label for="input01" class="control-label col-sm-2">用户名：</label>
									<div class="controls col-sm-8">
										<input type="text" name="username" id="username"
											class="input-xlarge" value="${sysuser.username}"
											required />
									</div>
								</div>
								
								<div class="form-group">
									<label for="input01" class="control-label col-sm-2">密码：</label>
									<div class="controls col-sm-8">
										<input type="password" name="password" id="password"
											class="input-xlarge" value="${sysuser.password}"
											required />
									</div>
								</div>
								
								<div class="form-group">
									<label for="input01" class="control-label col-sm-2">真实姓名：</label>
									<div class="controls col-sm-8">
										<input type="text" name="truename" id="truename"
											class="input-xlarge" value="${sysuser.truename}"
											required />
									</div>
								</div>
								<div class="form-group">
									<label for="input01" class="control-label col-sm-2">身份：</label>
									<div class="controls col-sm-8">
										<input type="text" name="identity" id="identity"
											class="input-xlarge" value="${sysuser.identity}"
											/>
									</div>
								</div>
								<div class="form-group">
									<%-- <label for="input01" class="control-label col-sm-2">性别：</label>
									<div class="controls col-sm-8">
										<input type="text" name="sex" id="sex"
											class="input-xlarge" value="${sysuser.sex}"
											/>
									</div> --%>
									
									
									<label class="control-label col-sm-2" for="roleid">性别：</label>
									<div class="controls col-sm-8">
										<select  name="sex">
											<option value="-1"
												<c:if test="${sysuser.sex==-1}">selected</c:if>>请选择</option>
											<option value="0"
												<c:if test="${sysuser.sex==0}">selected</c:if>>男</option>
											<option value="1"
												<c:if test="${sysuser.sex==1}">selected</c:if>>女</option>
										</select>
									</div>
									
									
									
									
									
								</div>
								<div class="form-group">
									<label for="input01" class="control-label col-sm-2">邮箱：</label>
									<div class="controls col-sm-8">
										<input type="text" name="email" id="email"
											class="input-xlarge" value="${sysuser.email}"
											/>
									</div>
								</div>
								<div class="form-group">
									<label for="input01" class="control-label col-sm-2">手机：</label>
									<div class="controls col-sm-8">
										<input type="text" name="mobilephone" id="mobilephone"
											class="input-xlarge" value="${sysuser.mobilephone}"
											/>
									</div>
								</div>
								<div class="form-group">
									<label class="control-label col-sm-2" for="roleid">角色：</label>
									<div class="controls col-sm-8">
										<select id="roleid" name="roleid">
											<option value="-1"
												<c:if test="${sysuser.roleid=='-1'}">selected</c:if>>请选择</option>
											<c:forEach var="item" items="${sysroles}">	
											<option value="${item.roleid }"
												<c:if test="${sysuser.roleid==item.roleid}">selected</c:if>>${item.rolename }</option>
											</c:forEach>
										</select>
									</div>
								</div>
								<div class="form-group">
									<label for="input01" class="control-label col-sm-2">QQ：</label>
									<div class="controls col-sm-8">
										<input type="text" name="qq" id="qq"
											class="input-xlarge" value="${sysuser.qq}"
											/>
									</div>
								</div>
								
								<div class="form-actions">
									<div class="col-sm-1"></div>
									<div class="col-sm-8">
										<a href="${ctx }/user/list" class="btn btn-info"><span class="fa fa-arrow-left fa-fw"></span> 返回</a>
										&nbsp;&nbsp;
										<button class="btn btn-primary" type="submit"><span class="fa fa-floppy-o fa-fw"></span> 
										<c:if test="${sysuser.userid>0}">修改用户</c:if> <c:if test="${sysuser.userid==0}">添加用户</c:if></button>
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
