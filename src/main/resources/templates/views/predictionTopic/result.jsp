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
			<h1 class="page-header">竞猜结果</h1>
		</div>
	</div>
	<div class="row">
		<div class="col-sm-12">
			<div class="panel panel-default">
				<div class="panel-heading">竞猜结果：</div>
				<div class="panel-body">
					<div class="col">
						<form id="addUserInfoform" class="form-horizontal"
							action="" method="post">
							<div class="col-sm-6">
						       <div class="form-group">
									<label for="input01" class="control-label">
									竞猜标题：
									</label>
									${predictionTopic.title }
								</div> 
								 <div class="form-group">
									<div class="controls col-sm-8">
									    
										 <c:forEach items="${itemlist }" var="itemlist">
									     <div>
										 <label>  选项名称：</label>
									     <input type="checkbox" name="checkbox" <c:if test="${itemlist.ischeck==true }">checked="checked"</c:if>  value="${itemlist.xid }"/>
									       ${itemlist.name }
									    </div>
									</c:forEach>
									</div>
								</div> 
							</div>

							<div class="form-actions">
								<div class="col-sm-12 text-center">
									<a href="${ctx }/predictionTopic/list" class="btn btn-info"><span
										class="fa fa-arrow-left fa-fw"></span> 返回</a> &nbsp;&nbsp;
									
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
