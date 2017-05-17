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
			<h1 class="page-header">
			<c:if test="${advertManage.itype==0 }">添加文章页广告</c:if>
			<c:if test="${advertManage.itype==1 }">添加浮屏页</c:if>
			</h1>
		</div>
	</div>
	<div class="row">
		<div class="col-sm-12">
			<div class="panel panel-default">
				<div class="panel-heading">
				<c:if test="${advertManage.itype==0 }">添加文章页广告</c:if>
				<c:if test="${advertManage.itype==1 }">添加浮屏页</c:if>
				</div>
				<div class="panel-body">
					<div class="row">
						<form id="addform" class="form-horizontal"
							action="${ctx }/advertmanage/saveorupdate" method="post">
							<input name="id" type="hidden" value="${advertManage.id }" />
							<input name="itype" type="hidden" value="${advertManage.itype }"/>
							<div class="row col-sm-6">
								<div class="form-group">
									<label for="channelname" class="control-label col-sm-2">名称：</label>
									<div class="controls col-sm-8">
										<input type="text" name="advertname" id="advertname" class="form-control"
											value="${advertManage.advertname }" required
											required-message="请输入名称" />
									</div>
								</div>
								<c:if test="${advertManage.itype==0 }"><!-- 0表示详情页时显示 -->
								<div class="form-group">
									<label for="mobile" class="control-label col-sm-2">渠道：</label>
									<div class="controls col-sm-8">
										<select id="cid" name="cid" class="form-control">
											<c:forEach var="item" items="${conchannellist}">
											
												<option value="${item.id}" <c:if test="${advertManage.cid==item.id}">selected="selected"</c:if> >
													${item.channelname}
													</option>
											</c:forEach>
										</select>
									</div>
								</div>
                               </c:if>
                               <c:if test="${advertManage.itype==1 }"><!-- 1表示浮屏页是显示 -->
                                 <div class="form-group">
									<label for="email" class="control-label col-sm-2">国家：</label>
									<div class="controls col-sm-8">
									    <select name="countrycode" id="countrycode" class="form-control">
									      
									       <c:forEach var="item" items="${hbcountrys}">
											<option value="${item.code}"
												<c:if test="${advertManage.countrycode==item.code}">selected</c:if>>${item.cnname}</option>
											</c:forEach>	
									    </select>
									</div>
								</div>
								<div class="form-group">
									<label for="email" class="control-label col-sm-2">语言：</label>
									<div class="controls col-sm-8">
									 <select name="langid" id="langid" class="form-control">
									        
											<c:forEach var="item" items="${hblanguages}">
											<option value="${item.id}"
												<c:if test="${advertManage.langid==item.id}">selected</c:if>>${item.hbname}</option>
											</c:forEach>	
									    </select>
									</div>
								</div>
								<div class="form-group">
									<label for="email" class="control-label col-sm-2">描述：</label>
									<div class="controls col-sm-8">
									<textarea rows="5" cols="60" name="desc" id="desc" class="form-control">
									${advertManage.desc }
									</textarea>
									
									</div>
								</div>
                               
                               </c:if>
                               
                               
								<div class="form-group">
									<label for="email" class="control-label col-sm-2">url：</label>
									<div class="controls col-sm-8">
										<input type="text" name="adverturl" id="adverturl"
											class="form-control" value="${advertManage.adverturl }"
											required-message="广告url" />
									</div>
								</div>
								
								<div class="form-group">
									<label for="input01" class="control-label col-sm-2">状态：</label>
									<div class="controls col-sm-8">
									    <select name="status" class="form-control">
									        <option value="0" <c:if test="${advertManage.status==0 }">selected="selected"</c:if>>正常</option>
									        <option value="2" <c:if test="${advertManage.status==2 }">selected="selected"</c:if>>禁用</option>
									    </select>
									</div>
								</div>
							</div>
						<div class="col-sm-6">
										<div class="form-group">
											<label for="input01" class="control-label col-sm-2">图片：</label>
											<div class="controls col-sm-2">
													<span class="btn btn-success fileinput-button">
												  					<span>上传图片</span>
				       										 		<input id="fileupload" type="file" name="file" multiple>
				        							</span>
												<input type="hidden" name="advertpic" id="img" value="${advertManage.advertpic }" />
											</div>
											<div class="col-sm-2">
												<div id="progress" class="progress">
											        <div id="progress" class="progress-bar progress-bar-success"></div>
											 	</div>
											 </div>
										</div>
										
										<div class="form-group">
										<label class="control-label col-sm-2">图片：</label>
										<div class="controls col-sm-8">
											<c:choose>
		        									<c:when test="${advertManage.advertpic != null && advertManage.advertpic != '' }">
		        										<img src="${upyunhttp }${advertManage.advertpic}" id="titlepicimg" class="col-sm-8">
		        									</c:when>
		        									<c:otherwise>
														<img src="" id="titlepicimg">
		        									</c:otherwise>
		        								</c:choose>
					    						
										</div>
									</div>
							</div>


							<div class="form-actions">
								<div class="col-sm-1"></div>
								<div class="col-sm-12 text-center">
									<a href="${ctx }/advertmanage/list-${advertManage.itype}" class="btn btn-info"><span
										class="fa fa-arrow-left fa-fw"></span> 返回</a> &nbsp;&nbsp;
									<button class="btn btn-primary" type="submit">
										<span class="fa fa-floppy-o fa-fw"></span>
										<c:if test="${not empty advertManage.id}">修改</c:if>
										<c:if test="${empty advertManage.id}">添加</c:if>
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
