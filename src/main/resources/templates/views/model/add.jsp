<%@page language="java" contentType="text/html; charset=UTF-8"%>
<%@ include file="/common/taglibs.jsp"%>
<!DOCTYPE html>
<html lang="en">
<head>
</head>
<body>
			<div class="row">
			<div class="col-sm-12">
				<h1 class="page-header">添加模块</h1>
			</div>
		</div>
		<div class="row">
			<div class="col-sm-12">
				<div class="panel panel-default">
					<div class="panel-heading">请填写以下选项：</div>
					<div class="panel-body">
						<div class="row">

							<form id="addUserInfoform" class="form-horizontal"
								action="${ctx }/model/saveorupdate" method="post">
								<input name="id" type="hidden" value="${appmodel.id }" />
								<div class="form-group">
									<label for="input01" class="control-label col-sm-2">模块名称：</label>
									<div class="controls col-sm-8">
										<input type="text" name="modelname" id="modelname"
											class="input-xlarge" value="${appmodel.modelname}"
											required />
									</div>
								</div>
								
								<div class="form-group">
									<label for="input01" class="control-label col-sm-2">模块描述：</label>
									<div class="controls col-sm-8">
										<input type="text" name="modeldesc" id="modeldesc"
											class="input-xlarge" value="${appmodel.modeldesc}"
											required />
									</div>
								</div>
								
								<div class="form-group">
									<label for="input01" class="control-label col-sm-2">模块标识：</label>
									<div class="controls col-sm-8">
										<input type="text" name="modelcode" id="modelcode"
											class="input-xlarge" value="${appmodel.modelcode}"
											required />
									</div>
								</div>
								
								<div class="form-group">
									<label for="input01" class="control-label col-sm-2">横坐标：</label>
									<div class="controls col-sm-8">
										<input type="text" name="x" id="x"
											class="input-xlarge" value="${appmodel.x}"
											required />
									</div>
								</div>
								
								<div class="form-group">
									<label for="input01" class="control-label col-sm-2">纵坐标：</label>
									<div class="controls col-sm-8">
										<input type="text" name="y" id="y"
											class="input-xlarge" value="${appmodel.y}"
											required />
									</div>
								</div>
								
								<div class="form-group">
									<label for="input01" class="control-label col-sm-2">宽：</label>
									<div class="controls col-sm-8">
										<input type="text" name="width" id="width"
											class="input-xlarge" value="${appmodel.width}"
											required />
									</div>
								</div>
								
								<div class="form-group">
									<label for="input01" class="control-label col-sm-2">高：</label>
									<div class="controls col-sm-8">
										<input type="text" name="heigth" id="heigth"
											class="input-xlarge" value="${appmodel.heigth}"
											required />
									</div>
								</div>
								
								<div class="form-group">
									<label for="input01" class="control-label col-sm-2">应用：</label>
									<div class="controls col-sm-8">
										<select id="appid" name="appid">
											<option value="-1"
												<c:if test="${appmodel.status=='-1'}">selected</c:if>>请选择</option>
											<c:forEach var="item" items="${applicationlist}">
											<option value="${item.id}"
												<c:if test="${appmodel.appid==item.id}">selected</c:if>>${item.appname}</option>
											</c:forEach>	
										</select>
									</div>
								</div>
								
								<div class="form-group">
									<label for="input01" class="control-label col-sm-2">模块状态：</label>
									<div class="controls col-sm-8">
										<select id="status" name="status">
										<%-- 	<option value="-1"
												<c:if test="${appmodel.status=='-1'}">selected</c:if>>请选择</option> --%>
											<option value="0"
												<c:if test="${appmodel.status=='0'}">selected</c:if>>正常</option>
											<option value="1"
												<c:if test="${appmodel.status=='1'}">selected</c:if>>禁用</option>
										</select>
									</div>
								</div>
								
								<div class="form-group">
									<label for="input01" class="control-label col-sm-2">模块类型：</label>
									<div class="controls col-sm-8">
										<select id="modeltype" name="modeltype">
											<option value="-1"
												<c:if test="${appmodel.modeltype=='-1'}">selected</c:if>>请选择</option>
											<option value="0"
												<c:if test="${appmodel.modeltype=='0'}">selected</c:if>>广告</option>
											<option value="1"
												<c:if test="${appmodel.modeltype=='2'}">selected</c:if>>文章</option>
											<option value="2"
												<c:if test="${appmodel.modeltype=='2'}">selected</c:if>>游戏</option>
											<option value="3"
												<c:if test="${appmodel.modeltype=='3'}">selected</c:if>>锁屏</option>
										</select>
									</div>
								</div>
								
							
								<div class="form-actions">
									<div class="col-sm-1"></div>
									<div class="col-sm-8">
										<a href="${ctx }/model/list" class="btn btn-info"><span class="fa fa-arrow-left fa-fw"></span> 返回</a>
										&nbsp;&nbsp;
										<button class="btn btn-primary" type="submit"><span class="fa fa-floppy-o fa-fw"></span> 
										<c:if test="${appmodel.id>0}">修改模块</c:if> <c:if test="${appmodel.id==0}">添加模块</c:if></button>
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
