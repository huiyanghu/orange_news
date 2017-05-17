<%@page language="java" contentType="text/html; charset=UTF-8"%>
<%@ include file="/common/taglibs.jsp"%>
<!DOCTYPE html>
<html lang="en">
<head>
<link rel="stylesheet" href="${ctx }/css/jquery.fileupload.css">
</head>
<body>
	<div class="row">
		<div class="col-sm-12">
			<h1 class="page-header">添加国际化</h1>
		</div>
	</div>
	<div class="row">
		<div class="col-sm-12">
			<div class="panel panel-default">
				<div class="panel-heading">添加国际化</div>
				<div class="panel-body">
					<div class="row">
						<form id="addform" class="form-horizontal" action="${ctx }/globalization/saveorupdate" method="post">
							<input name="id" type="hidden" value="${globalization.id }" />
							<input name="objid" type="hidden" value="${globalization.objid}"/>
							<input name="objtype" type="hidden" value="${globalization.objtype}"/>
							<div class="row col-sm-6">
							<div class="form-group">
								<label for="channelname" class="control-label col-sm-2">语言名称：</label>
								<div class="controls col-sm-8">
									<select id="langid" name="langid" class="form-control">
											<option value="-1"
												<c:if test="${globalization.status=='-1'}">selected</c:if>>请选择</option>
											<c:forEach var="item" items="${hblanguages}">
											<option value="${item.id}"
												<c:if test="${globalization.langid==item.id}">selected</c:if>>${item.hbname}</option>
											</c:forEach>
										</select>
								</div>
							</div>
							
							<div class="form-group">
								<label for="email" class="control-label col-sm-2">国际化目标：</label>
								<div class="controls col-sm-8">
									<input type="text" name="objvalues" id="objvalues"
										class="form-control" value="${globalization.objvalues }" />
								</div>
							</div>
							</div>
							
							<div class="form-actions">
								<div class="col-sm-1"></div>
								<div class="col-sm-8 text-center">
									<a href="${ctx }/globalization/list?objid=${globalization.objid}&objtype=${globalization.objtype}" class="btn btn-info"><span
										class="fa fa-arrow-left fa-fw"></span> 返回</a> &nbsp;&nbsp;
									<button class="btn btn-primary" type="submit">
										<span class="fa fa-floppy-o fa-fw"></span>
										<c:if test="${globalization.id>0}">修改国际化</c:if><c:if test="${globalization.id==0}">添加国际化</c:if>
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
