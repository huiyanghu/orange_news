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
			<h1 class="page-header">添加停止词</h1>
		</div>
	</div>
	<div class="row">
		<div class="col-sm-12">
			<div class="panel panel-default">
				<div class="panel-heading">添加停止词</div>
				<div class="panel-body">
					<div class="row">
						<form id="addform" class="form-horizontal" action="${ctx }/stopword/saveorupdate" method="post">
							<input name="id" type="hidden" value="${bean.id }" />
							<div class="form-group">
								<label for="input01" class="control-label col-sm-2">名称：</label>
								<div class="controls col-sm-8">
									<input type="text" name="stopword" id="stopword"
										class="input-xlarge" value="${bean.stopword }" required
										required-message="名称不允许为空" />
								</div>
							</div>
							<div class="form-group">
								<label for="input01" class="control-label col-sm-2">语言：</label>
								<div class="controls col-sm-8">
									<select id="langid" name="langid" >
										<c:forEach items="${languages }" var="iteml">
											<option value="${iteml.id }"
												<c:if test="${iteml.id ==bean.langid }">selected</c:if>>${iteml.cnname }</option>
										</c:forEach>
									</select>
								</div>
							</div>
							
							<div class="form-actions">
								<div class="col-sm-1"></div>
								<div class="col-sm-8">
									<a href="${ctx }/stopword/list" class="btn btn-info"><span
										class="fa fa-arrow-left fa-fw"></span> 返回</a> &nbsp;&nbsp;
									<button class="btn btn-primary" type="submit">
										<span class="fa fa-floppy-o fa-fw"></span>
										<c:if test="${bean.id==0 }">添加</c:if>
										<c:if test="${bean.id>1 }">修改</c:if>
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
