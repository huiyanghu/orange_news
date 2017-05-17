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
			<h1 class="page-header">添加国家</h1>
		</div>
	</div>
	<div class="row">
		<div class="col-sm-12">
			<div class="panel panel-default">
				<div class="panel-heading">添加国家</div>
				<div class="panel-body">
					<div class="row">
						<form id="addform" class="form-horizontal" action="${ctx }/country/saveorupdate" method="post">
							<input name="cid" type="hidden" value="${hbcountrys.cid }" />
							<div class="form-group">
								<label for="input01" class="control-label col-sm-2">国家名称：</label>
								<div class="controls col-sm-8">
									<input type="text" name="cnname" id="cnname"
										class="input-xlarge" value="${hbcountrys.cnname }" required
										required-message="菜单名称不允许为空" />
								</div>
							</div>
							<div class="form-group">
								<label for="input01" class="control-label col-sm-2">国家代码：</label>
								<div class="controls col-sm-8">
									<input type="text" name="code" id="code"
										class="input-xlarge" value="${hbcountrys.code }" required
										required-message="菜单地址不允许为空" />
								</div>
							</div>
							<div class="form-group">
								<label for="input01" class="control-label col-sm-2">国家简称：</label>
								<div class="controls col-sm-8">
									<input type="text" name="shortname" id="shortname"
										class="input-xlarge" value="${hbcountrys.shortname }" required
										required-message="唯一标识不允许为空" />
								</div>
							</div>
							<div class="form-group">
								<label for="input01" class="control-label col-sm-2">国家英文名称：</label>
								<div class="controls col-sm-8">
									<input type="text" name="enname" id="enname"
										class="input-xlarge" value="${hbcountrys.enname }" />
								</div>
							</div>
							
							
							<div class="form-group">
								<label for="input01" class="control-label col-sm-2">国家标识：</label>
								<div class="controls col-sm-8">
										<span class="btn btn-success fileinput-button">
									  					<span>上传图标</span> 
	       										 		<input id="fileupload" type="file" name="file" multiple>
	        							</span>
									<input type="hidden" name="countryicon" id="countryicon" value="${hbcountrys.countryicon }" />
								</div>
							</div>
							<div class="form-group">
								<label class="control-label col-sm-2">国家标识：</label>
								<div class="controls col-sm-2">
									<c:choose>
        									<c:when test="${hbcountrys.countryicon != null&&hbcountrys.countryicon != '' }">
        										<img src="${upyunhttp }${hbcountrys.countryicon}" id="titlepicimg" class="thumbnail" heiht="140">
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
								<label for="input01" class="control-label col-sm-2">国家主语言：</label>
								<div class="controls col-sm-8">
									<select id="langid" name="langid">
											<option value="-1"
												<c:if test="${hbcountrys.isopen=='-1'}">selected</c:if>>请选择</option>
											<c:forEach var="language" items="${languagelist}">
											<option value="${language.id}"
												<c:if test="${hbcountrys.langid==language.id}">selected</c:if>>${language.cnname}</option>
											</c:forEach>	
										</select>
								</div>
							</div>
							
							
							<div class="form-group">
								<label for="input01" class="control-label col-sm-2">国家所属区域：</label>
								<div class="controls col-sm-8">
									<select id="continent" name="continent" onchange="area(this.value)">
											<option value="-1"
												<c:if test="${hbcountrys.isopen=='-1'}">selected</c:if>>请选择</option>
											<c:forEach var="continent" items="${continentlist}">
											<option value="${continent}"
												<c:if test="${continent==hbcountrys.continent}">selected</c:if>>${continent}</option>
											</c:forEach>	
										</select>
								</div>
							</div>
							
							<div class="form-group">
								<label for="input01" class="control-label col-sm-2">区域id：</label>
								<div class="controls col-sm-8" id="counts">
									<select id="continentid" name="continentid">
									<c:if test="${hbcountrys.continentid > 0 }">
											<c:forEach var="continentid" items="${continentidlist}">
											<option value="${continentid}"
												<c:if test="${continentid==hbcountrys.continentid}">selected</c:if>>${continentid}</option>
											</c:forEach>	
									</c:if>
										</select>
								</div>
							</div>
							
							<div class="form-group">
								<label for="input01" class="control-label col-sm-2">状态：</label>
								<div class="controls col-sm-8">
									<select id="status" name="status">
											<option value="0" <c:if test="${hbcountrys.status=='0'}">selected</c:if>>正常</option>
											<option value="1" <c:if test="${hbcountrys.status=='1'}">selected</c:if>>禁用</option>
										</select>
								</div>
							</div>
							
							<div class="form-actions">
								<div class="col-sm-1"></div>
								<div class="col-sm-8">
									<a href="${ctx }/country/list" class="btn btn-info"><span
										class="fa fa-arrow-left fa-fw"></span> 返回</a> &nbsp;&nbsp;
									<button class="btn btn-primary" type="submit">
									<span class="fa fa-floppy-o fa-fw"></span> 
										<c:if test="${hbcountrys.cid>0}">修改国家信息</c:if> <c:if test="${hbcountrys.cid==0}">添加国家信息</c:if>
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
		        	$("#countryicon").attr("value",data.result.imgpath);
		        },
		        progressall: function (e, data) {
		            var progress = parseInt(data.loaded / data.total * 100, 10);
		            $('#progress .progress-bar').css('width',progress + '%' );
		        }
		    }).prop('disabled', !$.support.fileInput)
		        .parent().addClass($.support.fileInput ? undefined : 'disabled');
		});
		
		
		
		function area(str){
			if(str=="亚洲AS"){
				$('#counts').html("<select id=\"continentid\" name=\"continentid\"> <option value=\"1\">1</option></select>");
			}
			if(str=="欧洲EU"){
				$('#counts').html("<select id=\"continentid\" name=\"continentid\"> <option value=\"2\">2</option></select>");
			}
			if(str=="非洲AF"){
				$('#counts').html("<select id=\"continentid\" name=\"continentid\"> <option value=\"3\">3</option></select>");
			}
			if(str=="北美洲NA"){
				$('#counts').html("<select id=\"continentid\" name=\"continentid\"> <option value=\"4\">4</option></select>");
			}
			if(str=="南美洲SA"){
				$('#counts').html("<select id=\"continentid\" name=\"continentid\"> <option value=\"5\">5</option></select>");
			}
			if(str=="大洋洲OA"){
				$('#counts').html("<select id=\"continentid\" name=\"continentid\"> <option value=\"6\">6</option></select>");
			}
			
			
		}
		
		
		
		
		
		
		
	</script>
	
</body>
</html>
