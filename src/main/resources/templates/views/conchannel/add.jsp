<%@page language="java" contentType="text/html; charset=UTF-8"%>
<%@ include file="/common/taglibs.jsp"%>
<!DOCTYPE html>
<html lang="en">
<head>
</head>
<body>
	<div class="row">
		<div class="col-sm-12">
			<h1 class="page-header">添加渠道</h1>
		</div>
	</div>
	<div class="row">
		<div class="col-sm-12">
			<div class="panel panel-default">
				<div class="panel-heading">添加渠道</div>
				<div class="panel-body">
					<div class="row col-sm-8">
						<form id="addform" class="form-horizontal" action="${ctx }/conchannel/saveorupdate" method="post">
							<input name="id" type="hidden" value="${conchannel.id }" />
							<div class="form-group">
								<label for="channelname" class="control-label col-sm-2">来源渠道：</label>
								<div class="controls col-sm-8">
									<input type="text" name="channelname" id="channelname"
										class="form-control" value="${conchannel.channelname }" required
										required-message="请输入来源渠道名称" />
								</div>
							</div>
							<div class="form-group">
								<label for="mobile" class="control-label col-sm-2">来源国家：</label>
								<div class="controls col-sm-8">
									<select id="countryid" name="countryid" class="form-control">
											<option value="-1"
												<c:if test="${conchannel.countryid=='-1'}">selected</c:if>>请选择</option>
											<option value="0"
												<c:if test="${conchannel.countryid=='0'}">selected</c:if>>所有国家</option>
											<option value="1"
												<c:if test="${conchannel.countryid=='1'}">selected</c:if>>单独国家</option>
										</select>
								</div>
							</div>
							
							<div class="form-group">
								<label for="email" class="control-label col-sm-2">渠道邮箱：</label>
								<div class="controls col-sm-8">
									<input type="text" name="email" id="email"
										class="form-control" value="${conchannel.email }" required
										required-message="渠道邮箱" />
								</div>
							</div>
							<div class="form-group">
								<label for="changepass" class="control-label col-sm-2">渠道密码：</label>
								<div class="controls col-sm-8">
									<input type="password" name="password" id="password"
										class="form-control" value="${conchannel.password }" required
										required-message="渠道密码" />
								</div>
							</div>
							
							<div class="form-group">
								<label for="mobile" class="control-label col-sm-2">手机：</label>
								<div class="controls col-sm-8">
									<input type="text" name="mobile" id="mobile"
										class="form-control" value="${conchannel.mobile }" required
										required-message="渠道电话" />
								</div>
							</div>
							<div class="form-group">
								<label for="mobile" class="control-label col-sm-2">联系电话：</label>
								<div class="controls col-sm-8">
									<input type="text" name="telphone" id="telphone"
										class="form-control" value="${conchannel.telphone }" required
										required-message="渠道电话" />
								</div>
							</div>
							
							<div class="form-group">
								<label for="mobile" class="control-label col-sm-2">状态：</label>
								<div class="controls col-sm-8">
									<select id="status" name="status" class="form-control">
											<option value="-1"
												<c:if test="${conchannel.status=='-1'}">selected</c:if>>请选择</option>
											<option value="0"
												<c:if test="${conchannel.status=='0'}">selected</c:if>>支持</option>
											<option value="1"
												<c:if test="${conchannel.status=='1'}">selected</c:if>>失效</option>
										</select>
								</div>
							</div>
							
								
							<div class="form-actions">
								<div class="col-sm-1"></div>
								<div class="col-sm-8">
									<a href="${ctx }/conchannel/list" class="btn btn-info"><span
										class="fa fa-arrow-left fa-fw"></span> 返回</a> &nbsp;&nbsp;
									<button class="btn btn-primary" type="submit">
										<span class="fa fa-floppy-o fa-fw"></span>
										<c:if test="${conchannel.id>0}">修改渠道</c:if><c:if test="${conchannel.id==0}">添加渠道</c:if>
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
