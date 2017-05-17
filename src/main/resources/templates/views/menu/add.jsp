<%@page language="java" contentType="text/html; charset=UTF-8"%>
<%@ include file="/common/taglibs.jsp"%>
<!DOCTYPE html>
<html lang="en">
<head>
</head>
<body>
	<div class="row">
		<div class="col-sm-12">
			<h1 class="page-header">添加菜单</h1>
		</div>
	</div>
	<div class="row">
		<div class="col-sm-12">
			<div class="panel panel-default">
				<div class="panel-heading">添加菜单</div>
				<div class="panel-body">
					<div class="row">
						<form id="addform" class="form-horizontal" action="${ctx }/menu/saveorupdate" method="post">
							<input name="menuid" type="hidden" value="${sysmenu.menuid }" />
							<div class="form-group">
								<label for="input01" class="control-label col-sm-2">菜单名称：</label>
								<div class="controls col-sm-8">
									<input type="text" name="menuname" id="menuname"
										class="input-xlarge" value="${sysmenu.menuname }" required
										required-message="菜单名称不允许为空" />
								</div>
							</div>
							<div class="form-group">
								<label for="input01" class="control-label col-sm-2">菜单地址：</label>
								<div class="controls col-sm-8">
									<input type="text" name="menuurl" id="menuurl"
										class="input-xlarge" value="${sysmenu.menuurl }" required
										required-message="菜单地址不允许为空" />
								</div>
							</div>
							<div class="form-group">
								<label for="input01" class="control-label col-sm-2">唯一标识：</label>
								<div class="controls col-sm-8">
									<input type="text" name="navtabid" id="navtabid"
										class="input-xlarge" value="${sysmenu.navtabid }" required
										required-message="唯一标识不允许为空" />
								</div>
							</div>
							<div class="form-group">
								<label for="input01" class="control-label col-sm-2">上级菜单：</label>
								<div class="controls col-sm-8">
									<input type="text" name="parentid" id="parentid"
										class="input-xlarge" value="${sysmenu.parentid }" />
								</div>
							</div>
							<div class="form-group">
								<label for="input01" class="control-label col-sm-2">排序ID：</label>
								<div class="controls col-sm-8">
									<input type="text" name="orderno" id="orderno"
										class="input-xlarge" value="${sysmenu.orderno }" required
										required-message="排序ID不允许为空" />
								</div>
							</div>
							<div class="form-group">
								<label class="control-label col-sm-2" for="menutype">菜单类型：</label>
								<div class="controls col-sm-8">
									<select id="menutype" name="menutype">
										<option value="-1"
											<c:if test="${sysmenu.menutype=='-1'}">selected</c:if>>请选择</option>
										<option value="0"
											<c:if test="${sysmenu.menutype=='0'}">selected</c:if>>按钮</option>
										<option value="1"
											<c:if test="${sysmenu.menutype=='1'}">selected</c:if>>菜单</option>
										<option value="2"
											<c:if test="${sysmenu.menutype=='2'}">selected</c:if>>菜单组</option>
									</select>
								</div>
							</div>
							<div class="form-group">
								<label class="control-label col-sm-2" for="menustate">菜单状态：</label>
								<div class="controls col-sm-8">
									<select id="menustate" name="menustate">
										<option value="-1"
											<c:if test="${sysmenu.menustate=='-1'}">selected</c:if>>请选择</option>
										<option value="0"
											<c:if test="${sysmenu.menustate=='0'}">selected</c:if>>正常</option>
										<option value="1"
											<c:if test="${sysmenu.menustate=='1'}">selected</c:if>>禁用</option>
									</select>
								</div>
							</div>
							<div class="form-actions">
								<div class="col-sm-1"></div>
								<div class="col-sm-8">
									<a href="${ctx }/menu/list" class="btn btn-info"><span
										class="fa fa-arrow-left fa-fw"></span> 返回</a> &nbsp;&nbsp;
									<button class="btn btn-primary" type="submit">
										<span class="fa fa-floppy-o fa-fw"></span>
										<c:if test="${sysmenu.menuid>0}">修改菜单</c:if><c:if test="${sysmenu.menuid==0}">添加菜单</c:if>
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
