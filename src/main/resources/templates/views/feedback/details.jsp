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
			<h1 class="page-header">反馈详情</h1>
		</div>
	</div>
     <div class="panel-body">
		 <div class="table-responsive">
			<table class="table table-striped table-bordered table-hover"
				id="dataTables-example">
					<!--<th>ID</th> 
						<th>email</th>
						<th>url</th>
						<th>时间</th>
						<th>反馈意见</th>
						<th>状态</th>
						<th>是否处理</th> -->
						
				<tr>
				   <td>Id:</td><td>${bean.id }</td>
				</tr>
				<tr>
				   <td>email:</td><td>${bean.email}</td>
				</tr>
				   <td>URL:</td><td>${bean.url}</td>
				<tr>
				   <td>时间:</td><td>${bean.createtime}</td>
				</tr>
					<td>状态:</td>
					<td>
					<c:if test="${bean.status==0}">正常</c:if>
					<c:if test="${bean.status==1}">禁用</c:if>
					</td>
				<tr>
				   <td>描述：</td>
				    <td style="height: 210px; width: 550px;"> ${bean.message }</td>
				</tr>
				<tr>
				   <td>是否处理:</td><td>
					   <div class="form-group">
							<div class="col-sm-8">
								<label class="radio-inline">
									<input type="radio" name="handle" id="handle0" value="0" ${bean.isHandle==0?"checked":""}/>未处理
								</label>
								<label class="radio-inline">
									<input type="radio" name="handle" id="handle1" value="1" ${bean.isHandle==1?"checked":""}/>已处理
								</label>
							</div>
						</div>
				   </td>
				</tr>
			</table>
			<div class="col-sm-12 text-center">
				<a href="${ctx }/feedback/list" class="btn btn-info">
					<span class="fa fa-arrow-left fa-fw"></span> 返回</a>
			</div>
	     </div>
	</div>
	<script type="text/javascript" src="${ctx }/js/jquery.ui.widget.js"></script>
	<script type="text/javascript" src="${ctx }/js/jquery.fileupload.js"></script>
</body>

</html>
