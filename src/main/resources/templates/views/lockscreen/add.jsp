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
				<h1 class="page-header">添加锁屏</h1>
			</div>
		</div>
		<div class="row">
			<div class="col-sm-12">
				<div class="panel panel-default">
					<div class="panel-heading">请填写以下选项：</div>
					<div class="panel-body">
						<div class="row">
							<form id="addUserInfoform" class="form-horizontal"
								action="${ctx }/screen/saveorupdate" method="post">
								<input name="id" type="hidden" value="${appLockScreen.id }" />
							<div class="col-sm-6">
								<div class="form-group">
									<label for="input01" class="control-label col-sm-2">锁屏标题：</label>
									<div class="controls col-sm-8">
										<input type="text" name="title" id="title" class="form-control" value="${appLockScreen.title }" required />
									</div>
								</div>

								
								<div class="form-group">
									<label class="control-label col-sm-2" for="type">图片类型：</label>
									<div class="controls col-sm-8">
										<select id="type" name="type" class="form-control">
											<option value="-1"
												<c:if test="${appLockScreen.type=='-1'}">selected</c:if>>请选择</option>
											<option value="0"
												<c:if test="${appLockScreen.type=='0'}">selected</c:if>>默认图片</option>
											<option value="1"
												<c:if test="${appLockScreen.type=='1'}">selected</c:if>>锁屏图片</option>
											<option value="2"
												<c:if test="${appLockScreen.type=='2'}">selected</c:if>>广告图片</option>
										</select>
									</div>
								</div>
								
								<div class="form-group">
									<label for="input01" class="control-label col-sm-2">发布时间：</label>
									<%-- <div class="controls col-sm-8">
									<fmt:parseDate value="${appLockScreen.datatime}" var="pubtime"/>
											<input type="text" name="datatime" class="form-control" value="<fmt:formatDate value="${appLockScreen.datatime}" type="both" pattern="yyyy-MM-dd HH:mm:ss"/>" onfocus="WdatePicker()" required/>
									</div> --%>
									<div class="controls col-sm-8">
									<input type="text" name="datatime" id="datatime"
										class="form-control" value="<fmt:formatDate value="${appLockScreen.datatime }" type="both" pattern="yyyy-MM-dd HH:mm:ss"/>" 
										 onfocus="WdatePicker({dateFmt:'yyyy-MM-dd HH:mm:ss'})" />
								</div>
								</div>
								
								
								<div class="form-group">
									<label for="input01" class="control-label col-sm-2">锁屏摘要：</label>
									<div class="controls col-sm-8">
										<textarea  name="abstracts" id="abstracts" class="form-control">${appLockScreen.abstracts}</textarea>
									</div>
								</div>
								
								<div class="form-group">
									<label for="input01" class="control-label col-sm-2">链接地址：</label>
									<div class="controls col-sm-8">
										<input type="text" name="src" class="form-control" id="src" value="${appLockScreen.src}" required/>
									</div>
								</div>
								
								<div class="form-group">
									<label for="input01" class="control-label col-sm-2">排序值：</label>
									<div class="controls col-sm-8">
										<input type="text" name="rank" class="form-control" id="rank" value="${appLockScreen.rank}" />
									</div>
								</div>
								
								<div class="form-group">
								<label class="control-label col-sm-2" for="countryid">发布国家：</label>
								<div class="controls col-sm-8">
									<select id="countrycode" name="countrycode" class="form-control">
										<option value="00" >所有国家</option>
										<c:forEach var="item" items="${hbcountrysList}">		
											<option value="${item.code}" <c:if test="${item.code==appLockScreen.countrycode}">selected</c:if>>${item.cnname}</option>
										</c:forEach>	
									</select>
								</div>
							</div>
							<div class="form-group">
								<label class="control-label col-sm-2" for="countryid">话题：</label>
								<div class="controls col-sm-8">
									<select id="topicsid" name="topicsid" class="form-control">
										<option value="0">所有话题</option>
										<c:forEach var="item" items="${topics}">		
											<option value="${item.tid}" <c:if test="${item.tid==appLockScreen.topicsid}">selected</c:if>>${item.name}</option>
										</c:forEach>	
									</select>
								</div>
							</div>
							<div class="form-group">
								<label class="control-label col-sm-2" for="countryid">语言：</label>
								<div class="controls col-sm-8">
									<select id="langid" name="langid" class="form-control">
										<option value="0">所有语言</option>
										<c:forEach var="item" items="${languages}">		
											<option value="${item.id}" <c:if test="${item.id==appLockScreen.langid}">selected</c:if>>${item.cnname}</option>
										</c:forEach>	
									</select>
								</div>
							</div>
							<div class="form-group">
								<label class="control-label col-sm-2" for="countryid">渠道：</label>
								<div class="controls col-sm-8">
									<select id="channelid" name="channelid" class="form-control">
										<option value="0">所有渠道</option>
										<c:forEach var="item" items="${channels}">		
											<option value="${item.id}" <c:if test="${item.id==appLockScreen.channelid}">selected</c:if>>${item.channelname}</option>
										</c:forEach>	
									</select>
								</div>
							</div>
							<div class="form-group">
									<label for="input01" class="control-label col-sm-2">属性：</label>
									<div class="controls col-sm-8">
										<input type="text" name="attr" class="form-control" id="attr" value="${appLockScreen.attr}" />
									</div>
								</div>
							
							<div class="form-group">
									<label class="control-label col-sm-2" for="type">是否显示：</label>
									<div class="controls col-sm-8">
										<select id="isshow" name="isshow" class="form-control">
											<option value="1"
												<c:if test="${appLockScreen.isshow=='1'}">selected</c:if>>否</option>
											<option value="0"
												<c:if test="${appLockScreen.isshow=='0'}">selected</c:if>>是</option>
										</select>
									</div>
								</div>
								<div class="form-group">
									<label class="control-label col-sm-2" for="type">是否滚动：</label>
									<div class="controls col-sm-8">
										<select id="isscroll" name="isscroll" class="form-control">
											<option value="0"
												<c:if test="${appLockScreen.isscroll=='0'}">selected</c:if>>不滚动</option>
											<option value="1"
												<c:if test="${appLockScreen.isscroll=='1'}">selected</c:if>>滚动</option>
										</select>
									</div>
								</div>
					
								
							</div>
							<div class="col-sm-6">
										<div class="form-group">
											<label for="input01" class="control-label col-sm-2">锁屏图片：</label>
											<div class="controls col-sm-2">
													<span class="btn btn-success fileinput-button">
												  					<span>上传图片</span>
				       										 		<input id="fileupload" type="file" name="file" multiple>
				        							</span>
												<input type="hidden" name="img" id="img" value="${appLockScreen.img }" />
											</div>
											<div class="col-sm-2">
												<div id="progress" class="progress">
											        <div id="progress" class="progress-bar progress-bar-success"></div>
											 	</div>
											 </div>
										</div>
										
										<div class="form-group">
										<label class="control-label col-sm-2">锁屏图片：</label>
										<div class="controls col-sm-8">
											<c:choose>
		        									<c:when test="${appLockScreen.img != null&&appLockScreen.img != '' }">
		        										<img src="${upyunhttp }${appLockScreen.img}" id="titlepicimg" class="col-sm-8">
		        									</c:when>
		        									<c:otherwise>
														<img src="" id="titlepicimg">
		        									</c:otherwise>
		        								</c:choose>
					    						
										</div>
									</div>
							</div>
							
							
							<div class="form-actions">
									<div class="col-sm-12 text-center">
										<a href="${ctx }/screen/list" class="btn btn-info"><span class="fa fa-arrow-left fa-fw"></span> 返回</a>
										&nbsp;&nbsp;
										<button class="btn btn-primary" type="submit"><span class="fa fa-floppy-o fa-fw"></span> 
										<c:if test="${appLockScreen.id>0}">修改锁屏</c:if> <c:if test="${appLockScreen.id==0}">添加锁屏</c:if></button>
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
		        	$("#img").attr("value",data.result.imgpath);
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
