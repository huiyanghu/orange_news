<%@page language="java" contentType="text/html; charset=UTF-8"%>
<%@ include file="/common/taglibs.jsp"%>
<!DOCTYPE html>
<html lang="en">
<head>
</head>
<body>
	<div class="row">
		<div class="col-sm-12">
			<h1 class="page-header">添加语言</h1>
		</div>
	</div>
	<div class="row">
		<div class="col-sm-12">
			<div class="panel panel-default">
				<div class="panel-heading">添加语言</div>
				<div class="panel-body">
					<div class="row col-sm-6">
						<form id="addform" class="form-horizontal" action="${ctx }/language/saveorupdate" method="post">
							<input name="id" type="hidden" value="${hblanguage.id }" />
							<div class="form-group">
								<label for="channelname" class="control-label col-sm-2">语言名称(英文)：</label>
								<div class="controls col-sm-8">
									<input type="text" name="hbname" id="hbname"
										class="form-control" value="${hblanguage.hbname }" required />
								</div>
							</div>
							<div class="form-group">
								<label for="channelname" class="control-label col-sm-2">本地名称：</label>
								<div class="controls col-sm-8">
									<input type="text" name="localname" id="localname"
										class="form-control" value="${hblanguage.localname }" required />
								</div>
							</div>
							<div class="form-group">
								<label for="channelname" class="control-label col-sm-2">中文名称：</label>
								<div class="controls col-sm-8">
									<input type="text" name="cnname" id="cnname"
										class="form-control" value="${hblanguage.cnname }" required />
								</div>
							</div>
							
							<div class="form-group">
								<label for="input01" class="control-label col-sm-2">状态：</label>
								<div class="controls col-sm-8">
									<select id="status" name="status">
											<option value="0" <c:if test="${hblanguage.status=='0'}">selected</c:if>>正常</option>
											<option value="1" <c:if test="${hblanguage.status=='1'}">selected</c:if>>禁用</option>
										</select>
								</div>
							</div>
								
							<div class="form-actions">
								<div class="col-sm-1"></div>
								<div class="col-sm-6 text-center">
									<a href="${ctx }/language/list" class="btn btn-info"><span
										class="fa fa-arrow-left fa-fw"></span> 返回</a> &nbsp;&nbsp;
									<button class="btn btn-primary" type="submit">
										<span class="fa fa-floppy-o fa-fw"></span>
										<c:if test="${hblanguage.id>0}">修改语言</c:if><c:if test="${hblanguage.id==0}">添加语言</c:if>
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
