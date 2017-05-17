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
			<h1 class="page-header">修改用户审核信息</h1>
		</div>
	</div>
	<div class="row">
		<div class="col-sm-12">
			<div class="panel panel-default">
				<div class="panel-heading">请填写以下选项：</div>
				<div class="panel-body">
					<div class="col">
						<form id="addUserreviewform" class="form-horizontal"
							action="${ctx }/userreview/saveorupdate" method="post">
							<input name="id" type="hidden" value="${userReview.id }" />
							<div class="col-sm-6">
								 <div class="form-group">
									<label for="input01" class="control-label col-sm-2">状态：</label>
									<div class="controls col-sm-8">
										<select id="status" name="status" class="form-control">
											<option value="0"
												<c:if test="${userReview.status=='0'}">selected</c:if>>审核中</option>
											<option value="1"
												<c:if test="${userReview.status=='1'}">selected</c:if>>已审核</option>
											<option value="2"
												<c:if test="${userReview.status=='2'}">selected</c:if>>已驳回</option>
										</select>
									</div>
								</div> 
							</div>
							<div class="form-actions">
								<div class="col-sm-1"></div>
								<div class="col-sm-12 text-center">
									<a href="${ctx }/userreview/list" class="btn btn-info"><span
										class="fa fa-arrow-left fa-fw"></span> 返回</a> &nbsp;&nbsp;
									<button class="btn btn-primary" type="submit">
										<span class="fa fa-floppy-o fa-fw"></span>
										提交
									</button>
								</div>
							</div>
						</form>
					</div>
				</div>
			</div>
		</div>
	</div>

	<script type="text/javascript" src="${ctx }/js/jquery.ui.widget.js"></script>

</body>

</html>
