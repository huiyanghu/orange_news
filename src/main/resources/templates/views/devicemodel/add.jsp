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
			<h1 class="page-header">修改项目</h1>
		</div>
	</div>
	<div class="row">
		<div class="col-sm-12">
			<div class="panel panel-default">
				<div class="panel-heading">请填写以下选项：</div>
				<div class="panel-body">
					<div class="col">
						<form id="addUserInfoform" class="form-horizontal"
							action="${ctx }/devicemodel/saveorupdate" method="post">
							<input name="id" type="hidden" value="${deviceModel.id }" />
							<div class="col-sm-6">
								<div class="form-group">
									<label for="input01" class="control-label col-sm-3">项目名称：</label>
									<div class="controls col-sm-6">
										<input type="text" name="projectname"
											class="form-control" value="${deviceModel.projectname}" required />
									</div>
								</div>
								<div class="form-group">
									<label for="input01" class="control-label col-sm-3">渠道id：</label>
									<div class="controls col-sm-6">
									<select name="channelid" class="form-control">
									   <c:forEach items="${channels}" var="channels">
									    <option value="${channels.id  }" <c:if test="${channels.id == deviceModel.channelid }">selected="selected"</c:if>>${channels.channelname }</option>
									    </c:forEach>
									</select>	
									</div>
								</div>
                               <div class="form-group">
									<label for="input01" class="control-label col-sm-3">手机型号：</label>
									<div class="controls col-sm-6">
										<input type="text"  name="modelname"
											class="form-control" value="${deviceModel.modelname}"  />
									</div>
								</div>
								 <div class="form-group">
									<label for="input01" class="control-label col-sm-3">ROM：</label>
									<div class="controls col-sm-6">
										<input type="text"  name="rom"
											class="form-control" value="${deviceModel.rom}"  />
									</div>
								</div>
								 <div class="form-group">
									<label for="input01" class="control-label col-sm-3">RAM：</label>
									<div class="controls col-sm-6">
										<input type="text"  name="ram"
											class="form-control" value="${deviceModel.ram}"  />
									</div>
								</div>
								 <div class="form-group">
									<label for="input01" class="control-label col-sm-3">分辨率宽：</label>
									<div class="controls col-sm-6">
										<input type="text"  name="width"
											class="form-control" value="${deviceModel.width}"  />
									</div>
								</div>
								 <div class="form-group">
									<label for="input01" class="control-label col-sm-3">分辨率高：</label>
									<div class="controls col-sm-6">
										<input type="text"  name="height"
											class="form-control" value="${deviceModel.height}"  />
									</div>
								</div>
								 <div class="form-group">
									<label for="input01" class="control-label col-sm-3">android版本：</label>
									<div class="controls col-sm-6">
										<input type="text"  name="version"
											class="form-control" value="${deviceModel.version}"  />
									</div>
								</div>
								 <div class="form-group">
									<label for="input01" class="control-label col-sm-3">状态：</label>
									<div class="controls col-sm-6">
										<select id="status" name="status" class="form-control">
											<option value="0"
												<c:if test="${deviceModel.status=='0'}">selected</c:if>>正常</option>
											<option value="1"
												<c:if test="${deviceModel.status=='1'}">selected</c:if>>禁用</option>
										</select>
									</div>
								</div> 
							
							</div>
							<div class="form-actions">
								<div class="col-sm-1"></div>
								<div class="col-sm-12 text-center">
									<a href="${ctx }/devicemodel/list" class="btn btn-info"><span
										class="fa fa-arrow-left fa-fw"></span> 返回</a> &nbsp;&nbsp;
									<button class="btn btn-primary" type="submit">
										<span class="fa fa-floppy-o fa-fw"></span>
										修改项目
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
