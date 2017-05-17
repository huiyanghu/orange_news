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
			<h1 class="page-header">添加热搜和敏感词</h1>
		</div>
	</div>
	<div class="row">
		<div class="col-sm-12">
			<div class="panel panel-default">
				<div class="panel-heading">添加热搜和敏感词</div>
				<div class="panel-body">
					<div class="row">
						<form id="addform" class="form-horizontal" action="${ctx }/keywords/saveorupdate" method="post">
							<input name="id" type="hidden" value="${keyword.id }" />
							<input name="countryid" type="hidden" value="${keyword.countryid }" />
							<div class="form-group">
								<label for="input01" class="control-label col-sm-2">名称：</label>
								<div class="controls col-sm-8">
									<input type="text" name="keyname" id="keyname"
										class="input-xlarge" value="${keyword.keyname }" required
										required-message="名称不允许为空" />
								</div>
							</div>
							<div class="form-group">
								<label for="input01" class="control-label col-sm-2">类型：</label>
								<div class="controls col-sm-8">
									热搜词：<input type="radio" name="keytype" value="0" <c:if test="${keyword.keytype==0 }">checked</c:if> />
									敏感词：<input type="radio" name="keytype" value="1"  <c:if test="${keyword.keytype==1 }">checked</c:if> />
								</div>
							</div>
							
							<div class="form-actions">
								<div class="col-sm-1"></div>
								<div class="col-sm-8">
									<a href="${ctx }/keywords/list?countryid=${keyword.countryid}" class="btn btn-info"><span
										class="fa fa-arrow-left fa-fw"></span> 返回</a> &nbsp;&nbsp;
									<button class="btn btn-primary" type="submit">
										<span class="fa fa-floppy-o fa-fw"></span>
										<c:if test="${keyword.id==0 }">添加</c:if>
										<c:if test="${keyword.id>1 }">修改</c:if>
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
