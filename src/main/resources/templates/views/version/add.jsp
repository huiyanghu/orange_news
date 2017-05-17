<%@page language="java" contentType="text/html; charset=UTF-8"%>
<%@ include file="/common/taglibs.jsp"%>
<!DOCTYPE html>
<html lang="en">
<head>
	<script type="text/javascript" src="${ctx }/js/plugins/My97DatePicker/WdatePicker.js"></script>
	<link rel="stylesheet" href="${ctx }/css/jquery.fileupload.css">
</head>
<body>
	<div class="row">
		<div class="col-sm-12">
			<h1 class="page-header">添加版本</h1>
		</div>
	</div>
	<div class="row">
		<div class="col-sm-12">
			<div class="panel panel-default">
				<div class="panel-heading">添加版本</div>
				<div class="panel-body">
					<div class="row col-sm-8">
						<form id="addform" class="form-horizontal" action="${ctx }/version/saveorupdate" method="post">
							<input name="id" type="hidden" value="${version.id }" />
							<div class="form-group">
								<label for="versionnum" class="control-label col-sm-2">版本数：</label>
								<div class="controls col-sm-8">
									<input type="text" name="versionnum" id="versionnum"
										class="form-control" value="${version.versionnum }" required
										required-message="请输入版本数" />
								</div>
							</div>
							<div class="form-group">
								<label for="versioncode" class="control-label col-sm-2">版本号：</label>
								<div class="controls col-sm-8">
									<input type="text" name="versioncode" id="versioncode"
										class="form-control" value="${version.versioncode }" required
										required-message="请输入版本号" />
								</div>
							</div>
							
							<div class="form-group">
								<label for="versiondesc" class="control-label col-sm-2">版本描述：</label>
								<div class="controls col-sm-8">
									<textarea name="versiondesc" id="versiondesc" rows="5" cols="20"
										class="form-control"  required>${version.versiondesc }</textarea>
								</div>
							</div>
							
							<div class="form-group">
									<label for="input01" class="control-label col-sm-2">应用：</label>
									<div class="controls col-sm-8">
										<select id="appid" name="appid" class="form-control" onchange="channellist(this.value)">
											<option value="-1"
												<c:if test="${version.pubstatus=='-1'}">selected</c:if>>请选择</option>
											<c:forEach var="item" items="${applicationlist}">
											<option value="${item.id}"
												<c:if test="${version.appid==item.id}">selected</c:if>>${item.appname}</option>
											</c:forEach>	
										</select>
									</div>
								</div>
								
							<div class="form-group">
								<label for="channelid" class="control-label col-sm-2">发布渠道：</label>
								<div class="controls col-sm-8" id="appchannel">
										<select id="channelid" name="channelid" class="form-control">
									<c:if test="${version.channelid!='0'}">
									<c:forEach var="channel" items="${channels}">
											<option value="${channel.id}"
												<c:if test="${version.channelid==channel.id}">selected</c:if>>${channel.channelname}</option>
									</c:forEach>
									</c:if>
										</select>
								</div>
							</div>
							
							
							<div class="form-group">
								<label for="publishtime" class="control-label col-sm-2">发布时间：</label>
								<div class="controls col-sm-8">
									<input type="text" name="publishtime" id="publishtime"
										class="form-control" value="<fmt:formatDate value="${version.publishtime }" type="both" pattern="yyyy-MM-dd 00:00:00"/>" required
										onfocus="WdatePicker({dateFmt:'yyyy-MM-dd 00:00:00'})" required-message="发布时间" />
								</div>
							</div>
							<%-- <div class="form-group">
								<label for="download" class="control-label col-sm-2">下载地址：</label>
								<div class="controls col-sm-8">
									<input type="text" name="download" id="download"
										class="form-control" value="${version.download }" required
										required-message="请输入载地址" />
								</div>
							</div> --%>
							<div class="form-group">
								<label for="appsize" class="control-label col-sm-2">APK 大小：</label>
								<div class="controls col-sm-8">
									<input type="text" name="appsize" id="appsize"
										class="form-control" value="${version.appsize }" required
										required-message="请输入载APK大小" />
								</div>
							</div>
							
							<div class="form-group">
								<label for="input01" class="control-label col-sm-2">下载地址：</label>
									<div class="controls col-sm-2">
											<span class="btn btn-success fileinput-button">
												  		<span>上传apk</span>
				       									<input id="fileupload3" type="file" name="file" multiple>
				        					</span>
									</div>
									<div class="col-sm-2">
										<div id="progress3" class="progress">
											      <div id="progress3" class="progress-bar progress-bar-success"></div>
										</div>
									</div>
							</div>
							
							<div class="form-group">
								<label for="appsize" class="control-label col-sm-2"></label>
								<div class="controls col-sm-8">
									<input type="text" name="download" id="download1"
										class="form-control" value="${version.download}" readonly="readonly"/>
								</div>
							</div>
							
							
							
							<div class="form-group">
									<label for="input01" class="control-label col-sm-2">是否强制升级：</label>
									<div class="controls col-sm-8">
										<select id="isforce" name="isforce" class="form-control">
											<option value="-1"
												<c:if test="${version.pubstatus=='-1'}">selected</c:if>>请选择</option>
											<option value="0"
												<c:if test="${version.isforce=='0'}">selected</c:if>>否</option>
											<option value="1"
												<c:if test="${version.isforce=='1'}">selected</c:if>>是</option>
										</select>
									</div>
								</div>
								
							<div class="form-actions">
								<div class="col-sm-1"></div>
								<div class="col-sm-8">
									<a href="${ctx }/version/list" class="btn btn-info"><span
										class="fa fa-arrow-left fa-fw"></span> 返回</a> &nbsp;&nbsp;
									<button class="btn btn-primary" type="submit">
										<span class="fa fa-floppy-o fa-fw"></span>
										<c:if test="${version.id>0}">修改版本</c:if><c:if test="${version.id==0}">添加版本</c:if>
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
	
	function channellist(id){
		var url="${ctx }/version/ajaxchannel?appid="+id;
		
		var ajax = false;
	    if(window.XMLHttpRequest) { 
	        ajax = new XMLHttpRequest();
	        if (ajax.overrideMimeType) {//设置MiME类别
	            ajax.overrideMimeType("text/xml");
	        }
	    }else if (window.ActiveXObject) {     // IE浏览器
	        try{
	            ajax = new ActiveXObject("Msxml2.XMLHTTP");
	        }catch (e){
	            try{
	                ajax = new ActiveXObject("Microsoft.XMLHTTP");
	            }catch(e){}
	        }
	    }
	    if (!ajax){     
	        // 异常，创建对象实例失败
	        window.alert("不能创建XMLHttpRequest对象实例.");
	        return false;
	    }               
	    //通过Post方式打开连接
	    ajax.open("GET", url, true);
	    //发送GET数据,已经在URL中赋了值所以send那里只要加个空参.
	    ajax.send(null);
	    //获取执行状态
	    ajax.onreadystatechange = function(){ 
	           //如果执行状态成功，那么就把返回信息写到指定的层里
	           if (ajax.readyState == 4 && ajax.status == 200){ 
	            	var date = ajax.responseText; 
	            	$('#appchannel').html(date);
	           } 
	    } 
	}
	
	$(function () {
		$('#fileupload3').fileupload({
	        url: '${ctx}/upload/upyun',
	        dataType: 'json',
	        done: function (e, data) {
	        	$("#titlepicimg3").attr("src",""+data.result.imgsrc+"");
	        	$("#titlepicimg3").attr("class","col-sm-8");
	        	$("#download1").attr("value",data.result.imgsrc);
	        },
	        progressall: function (e, data) {
	            var progress = parseInt(data.loaded / data.total * 100, 10);
	            $('#progress3 .progress-bar').css('width',progress + '%' );
	        }
	    }).prop('disabled', !$.support.fileInput)
	        .parent().addClass($.support.fileInput ? undefined : 'disabled');
		
		
	});
	
	
	</script>
	</body>
</html>
