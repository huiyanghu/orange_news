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
			<h1 class="page-header">添加媒体</h1>
		</div>
	</div>
	<div class="row">
		<div class="col-sm-12">
			<div class="panel panel-default">
				<div class="panel-heading">添加媒体</div>
				<div class="panel-body">
					<div class="row">
						<form id="addform" class="form-horizontal"
							action="${ctx }/conpublication/saveorupdate" method="post">
							<input name="id" type="hidden" value="${conpublication.id }" />
							<input name="hbid" type="hidden" value="${conpublication.hbid }" />
							<div class="row col-sm-6">
								<div class="form-group">
									<label for="channelname" class="control-label col-sm-2">媒体名称：</label>
									<div class="controls col-sm-8">
										<input type="text" name="name" id="name" class="form-control"
											value="${conpublication.name }" required
											required-message="请输入来媒体名称" />
									</div>
								</div>
								<div class="form-group">
									<label for="mobile" class="control-label col-sm-2">来源国家：</label>
									<div class="controls col-sm-8">
										<select id="countryid" name="countryid" class="form-control">
											<option value="-1"
												<c:if test="${conchannel.countryid=='-1'}">selected</c:if>>请选择</option>
											<c:forEach var="item" items="${hbcountrys}">
												<option value="${item.cid}"
													<c:if test="${conpublication.countryid==item.cid}">selected</c:if>>${item.cnname}</option>
											</c:forEach>
										</select>
									</div>
								</div>
								<div class="form-group">
									<label for="mobile" class="control-label col-sm-2">渠道：</label>
									<div class="controls col-sm-8">
										<select id="channelid" name="channelid" class="form-control">
											<option value="-1"
												<c:if test="${conchannel.channelid=='-1'}">selected</c:if>>请选择</option>
											<c:forEach var="item" items="${conchannellist}">
												<option value="${item.id}"
													<c:if test="${conpublication.channelid==item.id}">selected</c:if>>${item.channelname}</option>
											</c:forEach>
										</select>
									</div>
								</div>

								<div class="form-group">
									<label for="email" class="control-label col-sm-2">描述：</label>
									<div class="controls col-sm-8">
										<input type="text" name="description" id="description"
											class="form-control" value="${conpublication.description }"
											required-message="媒体描述" />
									</div>
								</div>
								<div class="form-group">
									<label for="changepass" class="control-label col-sm-2">url：</label>
									<div class="controls col-sm-8">
										<input type="text" name="url" id="url" class="form-control"
											value="${conpublication.url }" />
									</div>
								</div>

								<div class="form-group">
									<label for="input01" class="control-label col-sm-2">经度：</label>
									<div class="controls col-sm-8">
										<input type="text" name="latitude" id="latitude"
											class="form-control" value="${conpublication.latitude}" />
									</div>
								</div>
								<div class="form-group">
									<label for="input01" class="control-label col-sm-2">纬度：</label>
									<div class="controls col-sm-8">
										<input type="text" name="longitude" id="longitude"
											class="form-control" value="${conpublication.longitude}" />
									</div>
								</div>
							</div>
							<div class="row col-sm-6">
								<div class="form-group">
									<label for="input01" class="control-label col-sm-2">LOGO：</label>
									<div class="controls col-sm-8">
										<span class="btn btn-success fileinput-button"> <span>上传LOGO</span>
											<input id="fileupload" type="file" name="file" multiple>
										</span> <input type="hidden" name="logourl" id="logourl"
											value="${conpublication.logourl }" />
									</div>
								</div>
								<div class="form-group">
									<label class="control-label col-sm-2">LOGO：</label>
									<div class="controls col-sm-2">
										<c:choose>
											<c:when
												test="${conpublication.logourl != null&&conpublication.logourl != '' }">
												<img src="${upyunhttp }${conpublication.logourl}"
													id="titlepicimg" class="thumbnail" heiht="140">
											</c:when>
											<c:otherwise>
												<img
													src="data:image/svg+xml;base64,PD94bWwgdmVyc2lvbj0iMS4wIiBlbmNvZGluZz0iVVRGLTgiIHN0YW5kYWxvbmU9InllcyI/PjxzdmcgeG1sbnM9Imh0dHA6Ly93d3cudzMub3JnLzIwMDAvc3ZnIiB3aWR0aD0iMTQwIiBoZWlnaHQ9IjE0MCIgdmlld0JveD0iMCAwIDE0MCAxNDAiIHByZXNlcnZlQXNwZWN0UmF0aW89Im5vbmUiPjxkZWZzLz48cmVjdCB3aWR0aD0iMTQwIiBoZWlnaHQ9IjE0MCIgZmlsbD0iI0VFRUVFRSIvPjxnPjx0ZXh0IHg9IjQ1LjUiIHk9IjcwIiBzdHlsZT0iZmlsbDojQUFBQUFBO2ZvbnQtd2VpZ2h0OmJvbGQ7Zm9udC1mYW1pbHk6QXJpYWwsIEhlbHZldGljYSwgT3BlbiBTYW5zLCBzYW5zLXNlcmlmLCBtb25vc3BhY2U7Zm9udC1zaXplOjEwcHQ7ZG9taW5hbnQtYmFzZWxpbmU6Y2VudHJhbCI+MTQweDE0MDwvdGV4dD48L2c+PC9zdmc+"
													id="titlepicimg" class="thumbnail">
											</c:otherwise>
										</c:choose>
										<div id="progress" class="progress">
											<div class="progress-bar progress-bar-success"></div>
										</div>
									</div>
								</div>
							</div>


							<div class="form-actions">
								<div class="col-sm-1"></div>
								<div class="col-sm-12 text-center">
									<a href="${ctx }/conpublication/list" class="btn btn-info"><span
										class="fa fa-arrow-left fa-fw"></span> 返回</a> &nbsp;&nbsp;
									<button class="btn btn-primary" type="submit">
										<span class="fa fa-floppy-o fa-fw"></span>
										<c:if test="${conpublication.id>0}">修改媒体</c:if>
										<c:if test="${conpublication.id==0}">添加媒体</c:if>
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
		        	$("#logourl").attr("value",data.result.imgpath);
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
