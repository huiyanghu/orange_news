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
			<h1 class="page-header">添加话题</h1>
		</div>
	</div>
	<div class="row">
		<div class="col-sm-12">
			<div class="panel panel-default">
				<div class="panel-heading">添加话题</div>
				<div class="panel-body">
					<div class="row">
						<form id="addform" class="form-horizontal" action="${ctx }/topics/saveorupdate" method="post">
							<input name="tid" type="hidden" value="${topics.tid }" />
							<div class="form-group">
								<!-- <label for="input01" class="control-label col-sm-2">话题编号：</label> -->
								<div class="controls col-sm-8">
									<input type="hidden" name="ID" id="ID"
										class="input-xlarge" value="${topics.ID }" required
										required-message="话题编号" />
								</div>
							</div>
							<div class="form-group">
								<label for="input01" class="control-label col-sm-2">类型：</label>
								<div class="controls col-sm-8">
									Hubii <input type="radio" name="topictype" value="0" ${topics.topictype==0?'checked':'' }>
									自编 <input type="radio" name="topictype" value="1" ${topics.topictype==1?'checked':'' }>
								</div>
							</div>
							
							<div class="form-group">
								<label for="input01" class="control-label col-sm-2">话题名称：</label>
								<div class="controls col-sm-8">
									<input type="text" name="name" id="name"
										class="input-xlarge" value="${topics.name }" required
										required-message="话题名称" />
								</div>
							</div>
							
							<div class="form-group">
									<label class="control-label col-sm-2" for="type">话题状态：</label>
									<div class="controls col-sm-8">
										<select id="status" name="status" >
											<option value="0"
												<c:if test="${topics.status=='0'}">selected</c:if>>支持</option>
											<option value="1"
												<c:if test="${topics.status=='1'}">selected</c:if>>特殊</option>
										</select>
									</div>
								</div>
							
							
							<div class="form-group">
								<label for="input01" class="control-label col-sm-2">话题图标：</label>
								<div class="controls col-sm-8">
										<span class="btn btn-success fileinput-button">
									  					<span>上传图标</span>
	       										 		<input id="fileupload" type="file" name="file" multiple>
	        							</span>
									<input type="hidden" name="topicicon" id="topicicon" value="${topics.topicicon }" />
								</div>
							</div>
							<div class="form-group">
								<label class="control-label col-sm-2">话题图标：</label>
								<div class="controls col-sm-2">
									<c:choose>
        									<c:when test="${topics.topicicon != null&&topics.topicicon != '' }">
        										<img src="${upyunhttp }${topics.topicicon}" id="titlepicimg" class="thumbnail" height="30">
        									</c:when>
        									<c:otherwise>
												<img src="data:image/svg+xml;base64,PD94bWwgdmVyc2lvbj0iMS4wIiBlbmNvZGluZz0iVVRGLTgiIHN0YW5kYWxvbmU9InllcyI/PjxzdmcgeG1sbnM9Imh0dHA6Ly93d3cudzMub3JnLzIwMDAvc3ZnIiB3aWR0aD0iMTQwIiBoZWlnaHQ9IjE0MCIgdmlld0JveD0iMCAwIDE0MCAxNDAiIHByZXNlcnZlQXNwZWN0UmF0aW89Im5vbmUiPjxkZWZzLz48cmVjdCB3aWR0aD0iMTQwIiBoZWlnaHQ9IjE0MCIgZmlsbD0iI0VFRUVFRSIvPjxnPjx0ZXh0IHg9IjQ1LjUiIHk9IjcwIiBzdHlsZT0iZmlsbDojQUFBQUFBO2ZvbnQtd2VpZ2h0OmJvbGQ7Zm9udC1mYW1pbHk6QXJpYWwsIEhlbHZldGljYSwgT3BlbiBTYW5zLCBzYW5zLXNlcmlmLCBtb25vc3BhY2U7Zm9udC1zaXplOjEwcHQ7ZG9taW5hbnQtYmFzZWxpbmU6Y2VudHJhbCI+MTQweDE0MDwvdGV4dD48L2c+PC9zdmc+" id="titlepicimg" class="thumbnail">
        									</c:otherwise>
        								</c:choose>
			    						<div id="progress" class="progress">
									        <div class="progress-bar progress-bar-success"></div>
									 	</div>
								</div>
							</div>
								
							<div class="form-actions">
								<div class="col-sm-1"></div>
								<div class="col-sm-8">
									<a href="${ctx }/topics/list" class="btn btn-info"><span
										class="fa fa-arrow-left fa-fw"></span> 返回</a> &nbsp;&nbsp;
									<button class="btn btn-primary" type="submit">
										<span class="fa fa-floppy-o fa-fw"></span>
										<c:if test="${topics.tid>0}">修改话题</c:if><c:if test="${topics.tid==0}">添加话题</c:if>
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
	<script type="text/javascript" src="${ctx }/js/jquery.fileupload.js"></script>
	<script type="text/javascript">
		$(function () {
		    $('#fileupload').fileupload({
		        url: '${ctx}/upload/upyun',
		        dataType: 'json',
		        done: function (e, data) {
		        	$("#titlepicimg").attr("src",""+data.result.imgsrc+"");
		        	$("#topicicon").attr("value",data.result.imgpath);
		        },
		        progressall: function (e, data) {
		            var progress = parseInt(data.loaded / data.total * 100, 10);
		            $('#progress .progress-bar').css('width',progress + '%' );
		        }
		    }).prop('disabled', !$.support.fileInput)
		        .parent().addClass($.support.fileInput ? undefined : 'disabled');
		});
	</script>
	</body>
</html>
