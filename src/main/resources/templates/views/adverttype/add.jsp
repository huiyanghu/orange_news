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
				<h1 class="page-header">添加广告类型</h1>
			</div>
		</div>
		<div class="row">
			<div class="col-sm-12">
				<div class="panel panel-default">
					<div class="panel-heading">请填写以下选项：</div>
					<div class="panel-body">
						<div class="row">
							<form id="addUserInfoform" class="form-horizontal"
								action="${ctx }/adverttype/saveorupdate" method="post">
								<input name="id" type="hidden" value="${advertType.id }" />
							<div class="col-sm-6">
								<div class="form-group">
									<label for="input01" class="control-label col-sm-2">类型名称：</label>
									<div class="controls col-sm-8">
										<input type="text" name="adtypename" id="adtypename" class="form-control" value="${advertType.adtypename }" required />
									</div>
								</div>
										
								
								<div class="form-group">
									<label for="input01" class="control-label col-sm-2">广告url：</label>
									<div class="controls col-sm-8">
										<select id="adurl" name="adurl" class="form-control">
											<option value="-1"
												<c:if test="${advertType.adurl=='-1'}">selected</c:if>>请选择</option>
											<option value="0"
												<c:if test="${advertType.adurl=='0'}">selected</c:if>>正常</option>
											<option value="1"
												<c:if test="${advertType.adurl=='1'}">selected</c:if>>禁用</option>
										</select>
									</div>
								</div>
								
								
								<div class="form-group">
									<label for="input01" class="control-label col-sm-2">广告图片：</label>
									<div class="controls col-sm-8">
										<select id="adimg" name="adimg" class="form-control">
											<option value="-1"
												<c:if test="${advertType.adimg=='-1'}">selected</c:if>>请选择</option>
											<option value="0"
												<c:if test="${advertType.adimg=='0'}">selected</c:if>>正常</option>
											<option value="1"
												<c:if test="${advertType.adimg=='1'}">selected</c:if>>禁用</option>
										</select>
									</div>
								</div>
								
								<div class="form-group">
									<label for="input01" class="control-label col-sm-2">广告标题：</label>
									<div class="controls col-sm-8">
										<select id="adtitle" name="adtitle" class="form-control">
											<option value="-1"
												<c:if test="${advertType.adtitle=='-1'}">selected</c:if>>请选择</option>
											<option value="0"
												<c:if test="${advertType.adtitle=='0'}">selected</c:if>>正常</option>
											<option value="1"
												<c:if test="${advertType.adtitle=='1'}">selected</c:if>>禁用</option>
										</select>
									</div>
								</div>
								
								<div class="form-group">
									<label for="input01" class="control-label col-sm-2">包名：</label>
									<div class="controls col-sm-8">
										<select id="adpackage" name="adpackage" class="form-control">
											<option value="-1"
												<c:if test="${advertType.adpackage=='-1'}">selected</c:if>>请选择</option>
											<option value="0"
												<c:if test="${advertType.adpackage=='0'}">selected</c:if>>正常</option>
											<option value="1"
												<c:if test="${advertType.adpackage=='1'}">selected</c:if>>禁用</option>
										</select>
									</div>
								</div>
								
								<div class="form-group">
									<label for="input01" class="control-label col-sm-2">图标：</label>
									<div class="controls col-sm-8">
										<select id="adicon" name="adicon" class="form-control">
											<option value="-1"
												<c:if test="${advertType.adicon=='-1'}">selected</c:if>>请选择</option>
											<option value="0"
												<c:if test="${advertType.adicon=='0'}">selected</c:if>>正常</option>
											<option value="1"
												<c:if test="${advertType.adicon=='1'}">selected</c:if>>禁用</option>
										</select>
									</div>
								</div>
								
								<div class="form-group">
									<label for="input01" class="control-label col-sm-2">安装包地址：</label>
									<div class="controls col-sm-8">
										<select id="adapk" name="adapk" class="form-control">
											<option value="-1"
												<c:if test="${advertType.adapk=='-1'}">selected</c:if>>请选择</option>
											<option value="0"
												<c:if test="${advertType.adapk=='0'}">selected</c:if>>正常</option>
											<option value="1"
												<c:if test="${advertType.adapk=='1'}">selected</c:if>>禁用</option>
										</select>
									</div>
								</div>
								
								<div class="form-group">
									<label for="input01" class="control-label col-sm-2">url类型：</label>
									<div class="controls col-sm-8">
										<select id="urltype" name="urltype" class="form-control">
											<option value="-1"
												<c:if test="${advertType.urltype=='-1'}">selected</c:if>>请选择</option>
											<option value="0"
												<c:if test="${advertType.urltype=='0'}">selected</c:if>>正常</option>
											<option value="1"
												<c:if test="${advertType.urltype=='1'}">selected</c:if>>禁用</option>
										</select>
									</div>
								</div>
								
								<div class="form-group">
									<label for="input01" class="control-label col-sm-2">广告内容：</label>
									<div class="controls col-sm-8">
										<select id="adcontent" name="adcontent" class="form-control">
											<option value="-1"
												<c:if test="${advertType.adcontent=='-1'}">selected</c:if>>请选择</option>
											<option value="0"
												<c:if test="${advertType.adcontent=='0'}">selected</c:if>>正常</option>
											<option value="1"
												<c:if test="${advertType.adcontent=='1'}">selected</c:if>>禁用</option>
										</select>
									</div>
								</div>
								
								<div class="form-group">
									<label for="input01" class="control-label col-sm-2">安装包大小：</label>
									<div class="controls col-sm-8">
										<select id="adapksize" name="adapksize" class="form-control">
											<option value="-1"
												<c:if test="${advertType.adapksize=='-1'}">selected</c:if>>请选择</option>
											<option value="0"
												<c:if test="${advertType.adapksize=='0'}">selected</c:if>>正常</option>
											<option value="1"
												<c:if test="${advertType.adapksize=='1'}">selected</c:if>>禁用</option>
										</select>
									</div>
								</div>
								
								
							</div>
							
							<div class="form-actions">
									<div class="col-sm-12 text-center">
										<a href="${ctx }/adverttype/list" class="btn btn-info"><span class="fa fa-arrow-left fa-fw"></span> 返回</a>
										&nbsp;&nbsp;
										<button class="btn btn-primary" type="submit"><span class="fa fa-floppy-o fa-fw"></span> 
										<c:if test="${advertType.id>0}">修改广告类型</c:if> <c:if test="${advertType.id==0}">添加广告类型</c:if></button>
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
		        	$("#titlepicimg").attr("class","col-sm-8");
		        	$("#adimg").attr("value",data.result.imgpath);
		        },
		        progressall: function (e, data) {
		            var progress = parseInt(data.loaded / data.total * 100, 10);
		            $('#progress .progress-bar').css('width',progress + '%' );
		        }
		    }).prop('disabled', !$.support.fileInput)
		        .parent().addClass($.support.fileInput ? undefined : 'disabled');
		});
		
		
		
		
		function modellist(id){
			var url="${ctx }/advert/ajaxwb?appid="+id;
			
			var ajax = false;
		    //开始初始化XMLHttpRequest对象
		    if(window.XMLHttpRequest) 
		    { 
		        //Mozilla 浏览器
		        ajax = new XMLHttpRequest();
		        if (ajax.overrideMimeType) 
		        {//设置MiME类别
		            ajax.overrideMimeType("text/xml");
		        }
		    }
		    else if (window.ActiveXObject) 
		    {     // IE浏览器
		        try 
		        {
		            ajax = new ActiveXObject("Msxml2.XMLHTTP");
		        } 
		        catch (e) 
		        {
		            try 
		            {
		                ajax = new ActiveXObject("Microsoft.XMLHTTP");
		            } catch (e) {}
		        }
		    }
		    if (!ajax) 
		    {     
		        // 异常，创建对象实例失败
		        window.alert("不能创建XMLHttpRequest对象实例.");
		        return false;
		    }               

		    //通过Post方式打开连接
		    ajax.open("GET", url, true);

		    //发送GET数据,已经在URL中赋了值所以send那里只要加个空参.
		    ajax.send(null);

		    //获取执行状态
		    ajax.onreadystatechange = function() 
		    { 
		           //如果执行状态成功，那么就把返回信息写到指定的层里
		           if (ajax.readyState == 4 && ajax.status == 200) 
		        { 
		            var date = ajax.responseText; 
		            $('#works').html(date);
		           } 
		    } 
		}
		</script>
			
	
		
		
</body>
</html>
