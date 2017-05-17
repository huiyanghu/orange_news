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
			<h1 class="page-header">添加菜单</h1>
		</div>
	</div>
	<div class="row">
		<div class="col-sm-12">
			<div class="panel panel-default">
				<div class="panel-heading">添加菜单</div>
				<div class="panel-body">
					<div class="row">
						<form id="addform" class="form-horizontal" action="${ctx }/contopic/saveorupdate" method="post">
							<input name="tid" type="hidden" value="${bean.tid }" />
							<div class="form-group">
								<label for="input01" class="control-label col-sm-2">分类名称：</label>
								<div class="controls col-sm-8">
									<input type="text" name="topicname" id="topicname"
										class="input-xlarge" value="${bean.topicname }" required
										required-message="分类名称不允许为空" />
								</div>
							</div>
							<div class="form-group">
								<label for="input01" class="control-label col-sm-2">类型：</label>
								<div class="controls col-sm-8">
									Hubii <input type="radio" name="topictype" value="0" ${bean.topictype==0?'checked':'' }>
									自编 <input type="radio" name="topictype" value="1" ${bean.topictype==1?'checked':'' }>
								</div>
							</div>
							<div class="form-group">
									<label class="control-label col-sm-2" for="type">分类状态：</label>
									<div class="controls col-sm-8">
										<select id="status" name="status" >
											<option value="0"
												<c:if test="${bean.status=='0'}">selected</c:if>>支持</option>
											<option value="1"
												<c:if test="${bean.status=='1'}">selected</c:if>>特殊</option>
										</select>
									</div>
								</div>
							<div class="form-group">
								<label for="input01" class="control-label col-sm-2">分类图标：</label>
								<div class="controls col-sm-8">
										<span class="btn btn-success fileinput-button">
									  					<span>上传图标</span>
	       										 		<input id="fileupload" type="file" name="file" multiple>
	        							</span>
									<input type="hidden" name="topicicon" id="topicicon" value="${bean.topicicon }" />
								</div>
							</div>
							<div class="form-group">
								<label class="control-label col-sm-2">分类图标：</label>
								<div class="controls col-sm-2">
									<c:choose>
        									<c:when test="${bean.topicicon != null&&bean.topicicon != '' }">
        										<img src="${upyunhttp }${bean.topicicon}" id="titlepicimg" class="thumbnail" height="30">
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
							
							<div class="form-group">
								<label for="input01" class="control-label col-sm-2">上级分类：</label>
								<div class="controls col-sm-8">
									<input type="text" name="pid" id="pid"
										class="input-xlarge" value="${bean.pid }" />
								</div>
							</div>
							<div class="form-group">
								<label for="input01" class="control-label col-sm-2">排序ID：</label>
								<div class="controls col-sm-8">
									<input type="text" name="rank" id="rank"
										class="input-xlarge" value="${bean.rank }" required
										required-message="排序ID不允许为空" />
								</div>
							</div>
						
							<div class="form-actions">
								<div class="col-sm-1"></div>
								<div class="col-sm-8">
									<a href="${ctx }/contopic/list" class="btn btn-info"><span
										class="fa fa-arrow-left fa-fw"></span> 返回</a> &nbsp;&nbsp;
									<button class="btn btn-primary" type="submit">
										<span class="fa fa-floppy-o fa-fw"></span>
										<c:if test="${bean.tid>0}">修改分类</c:if><c:if test="${bean.tid==0}">添加分类</c:if>
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
