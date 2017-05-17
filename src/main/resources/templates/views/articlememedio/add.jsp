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
				<h1 class="page-header">添加文章</h1>
			</div>
		</div>
		<div class="row">
			<div class="col-sm-12">
				<div class="panel panel-default">
					<div class="panel-heading">请填写以下选项：</div>
					<div class="panel-body">
					<div class="col">
							<form id="addUserInfoform" class="form-horizontal"
								action="${ctx }/article/saveorupdate" method="post">
								<input name="id" type="hidden" value="${article.id }" />
								<div class="col-sm-6">
								<div class="form-group">
									<label for="input01" class="control-label col-sm-2">文章标题：</label>
									<div class="controls col-sm-8">
										<input type="text" name="title" id="title"
											class="form-control" value="${article.title}" required />
									</div>
								</div>
								
								<%-- <div class="form-group">
									<label for="input01" class="control-label col-sm-2">HUBII ID：</label>
									<div class="controls col-sm-8">
										<input type="text" name="articleid" id="articleid"
											class="input-xlarge" value="${article.articleid}" required />
									</div>
								</div> --%>
								
								<div class="form-group">
									<label for="input01" class="control-label col-sm-2">文章类型：</label>
									<div class="controls col-sm-8">
										<select id="ctype" name="ctype" class="form-control">
											<%-- <option value="-1"
												<c:if test="${article.status=='-1'}">selected</c:if>>请选择</option> --%>
											<option value="1"
												<c:if test="${article.ctype=='1'}">selected</c:if>>推荐</option>
											<option value="0"
												<c:if test="${article.ctype=='0'}">selected</c:if>>普通</option>
											
											<option value="2"
												<c:if test="${article.ctype=='2'}">selected</c:if>>置顶</option>
											<option value="3"
												<c:if test="${article.ctype=='3'}">selected</c:if>>视频</option>
										</select>
									</div>
								</div>
								<div class="form-group">
									<label for="input01" class="control-label col-sm-2">稿件属性：</label>
									<div class="controls col-sm-8">
										<select id="attr" name="attr" class="form-control">
											<%-- <option value="-1"
												<c:if test="${article.status=='-1'}">selected</c:if>>请选择</option> --%>
											<option value="1"
												<c:if test="${article.attr=='1'}">selected</c:if>>图文文章</option>
											<option value="0"
												<c:if test="${article.attr=='0'}">selected</c:if>>文字文章</option>
											
											<option value="2"
												<c:if test="${article.attr=='2'}">selected</c:if>>视频文章</option>
											<option value="3"
												<c:if test="${article.attr=='3'}">selected</c:if>>链接文章</option>
											<option value="4"
												<c:if test="${article.attr=='4'}">selected</c:if>>游戏文章</option>
										</select>
									</div>
								</div>
								<div class="form-group">
									<label for="input01" class="control-label col-sm-2">语言：</label>
									<div class="controls col-sm-8">
										<select id="langid" name="langid" class="form-control">
											<option value="12">英语</option>
											<c:forEach var="item" items="${hblanguages}">
											<option value="${item.id}"
												<c:if test="${article.langid==item.id}">selected</c:if>>${item.hbname}</option>
											</c:forEach>	
										</select>
									</div>
								</div>
								<div class="form-group">
									<label for="input01" class="control-label col-sm-2">国家：</label>
									<div class="controls col-sm-8">
										<select id="countrycode" name="countrycode" class="form-control">
											<option value="00">全球</option>
											<c:forEach var="item" items="${hbcountrys}">
											<option value="${item.code}"
												<c:if test="${article.countrycode==item.code}">selected</c:if>>${item.cnname}</option>
											</c:forEach>	
										</select>
									</div>
								</div>
								<div class="form-group">
									<label for="input01" class="control-label col-sm-2">话题：</label>
									<div class="controls col-sm-8">
										<select id="topicsid" name="topicsid" class="form-control">
											<option value="-1"
												<c:if test="${article.status=='-1'}">selected</c:if>>请选择</option>
											<c:forEach var="item" items="${hbtopics}">
											<option value="${item.tid}"
												<c:if test="${article.topicsid==item.tid}">selected</c:if>>${item.name}</option>
											</c:forEach>	
										</select>
									</div>
								</div>
								<%-- <div class="form-group">
									<label for="input01" class="control-label col-sm-2">渠道：</label>
									<div class="controls col-sm-8">
										<select id="channelid" name="channelid" class="form-control">
											<option value="-1"
												<c:if test="${article.channelid=='-1'}">selected</c:if>>请选择</option>
											<c:forEach var="item" items="${conchannels}">
											<option value="${item.id}"
												<c:if test="${article.channelid==item.id}">selected</c:if>>${item.channelname}</option>
											</c:forEach>	
										</select>
									</div>
								</div> --%>
								<%-- <div class="form-group">
									<label for="input01" class="control-label col-sm-2">媒体：</label>
									<div class="controls col-sm-8">
										<select id="publicationid" name="publicationid" class="form-control">
											<option value="-1"
												<c:if test="${article.publicationid=='-1'}">selected</c:if>>请选择</option>
											<c:forEach var="item" items="${conpublications}">
											<option value="${item.id}"
												<c:if test="${article.publicationid==item.id}">selected</c:if>>${item.name}</option>
											</c:forEach>	
										</select>
									</div>
								</div> --%>
								<div class="form-group">
									<label for="input01" class="control-label col-sm-2">文章摘要：</label>
									<div class="controls col-sm-8">
										<textarea  name="abstracts" id="abstracts"
											class="form-control" >${article.abstracts}</textarea>
									</div>
								</div>
								<%-- <div class="form-group">
									<label for="input01" class="control-label col-sm-2">图片数量：</label>
									<div class="controls col-sm-8">
										<input type="text" name="imgcount" id="imgcount"
											class="form-control" value="${article.imgcount}"  />
									</div>
								</div> --%>
								<div class="form-group">
									<label for="input01" class="control-label col-sm-2">关键字：</label>
									<div class="controls col-sm-8">
										<input type="text" name="keywords" id="keywords"
											class="form-control" value="${article.keywords}"/>
									</div>
								</div>
								<%-- <div class="form-group">
									<label for="input01" class="control-label col-sm-2">编辑：</label>
									<div class="controls col-sm-8">
										<input type="text" name="writer" id="writer"
											class="form-control" value="${article.writer}" />
									</div>
								</div> --%>
								<div class="form-group">
									<label for="input01" class="control-label col-sm-2">作者：</label>
									<div class="controls col-sm-8">
										<input type="text" name="author" id="author"
											class="form-control" value="${article.author}"/>
									</div>
								</div>
								</div>
								<div class="col-sm-6">
								<div class="form-group">
									<label for="input01" class="control-label col-sm-2">来源：</label>
									<div class="controls col-sm-8">
										<input type="text" name="source" id="source"
											class="form-control" value="${article.source}"/>
									</div>
								</div>
								<div class="form-group">
									<label for="input01" class="control-label col-sm-2">来源链接：</label>
									<div class="controls col-sm-8">
										<input type="text" name="sourceurl" id="sourceurl"
											class="form-control" value="${article.sourceurl}"/>
									</div>
								</div>
								 <div class="form-group">
									<label for="input01" class="control-label col-sm-2">跳转链接：</label>
									<div class="controls col-sm-8">
										<input type="text" name="linkurl" id="linkurl"
											class="form-control" value="${article.linkurl}" />
									</div>
								</div> 
								<div class="form-group">
									<label for="input01" class="control-label col-sm-2">多媒体地址：</label>
									<div class="controls col-sm-8">
										<input type="text" name="medialink" id="medialink"
											class="form-control" value="${article.medialink}"/>
									</div>
								</div>
								
								<div class="form-group">
								<label for="subtime" class="control-label col-sm-2">发布时间：</label>
								<div class="controls col-sm-8">
									<input type="text" name="subtime" id="subtime"
										class="form-control" value="<fmt:formatDate value="${article.subtime }" type="both" pattern="yyyy-MM-dd HH:mm:ss"/>" 
										 onfocus="WdatePicker({dateFmt:'yyyy-MM-dd HH:mm:ss'})" />
								</div>
								</div>
								<div class="form-group">
									<label for="input01" class="control-label col-sm-2">状态：</label>
									<div class="controls col-sm-8">
										<select id="status" name="status" class="form-control">
											<option value="0"
												<c:if test="${article.status=='0'}">selected</c:if>>正常</option>
											<option value="1"
												<c:if test="${article.status=='1'}">selected</c:if>>未审核</option>
												<option value="2"
												<c:if test="${article.status=='2'}">selected</c:if>>预发布</option>
										</select>
									</div>
								</div>
								<%-- <div class="form-group">
									<label for="input01" class="control-label col-sm-2">经度：</label>
									<div class="controls col-sm-8">
										<input type="text" name="latitude" id="latitude"
											class="form-control" value="${article.latitude}" required />
									</div>
								</div> --%>
								<%-- <div class="form-group">
									<label for="input01" class="control-label col-sm-2">纬度：</label>
									<div class="controls col-sm-8">
										<input type="text" name="longitude" id="longitude"
											class="form-control" value="${article.longitude}" required />
									</div>
								</div> --%>
								<%-- <div class="form-group">
									<label for="input01" class="control-label col-sm-2">发布人：</label>
									<div class="controls col-sm-8">
										<select id="publicationid" name="publicationid" class="form-control">
											<option value="-1"
												<c:if test="${article.status=='-1'}">selected</c:if>>请选择</option>
											<c:forEach var="item" items="${hbtopics}">
											<option value="${item.tid}"
												<c:if test="${article.topicsid==item.tid}">selected</c:if>>${item.Name}</option>
											</c:forEach>	
										</select>
									</div>
								</div> --%>
								<%-- <div class="form-group">
									<label for="input01" class="control-label col-sm-2">发布时间：</label>
									<div class="controls col-sm-8">
									<input type="text" name="subtime" id="subtime"
										class="form-control" value="<fmt:formatDate value="${article.subtime }" type="both" pattern="yyyy-MM-dd 00:00:00"/>" required
										onfocus="WdatePicker({dateFmt:'yyyy-MM-dd 00:00:00'})" />
									</div>
								</div> --%>
								<%-- <div class="form-group">
									<label for="input01" class="control-label col-sm-2">排序：</label>
									<div class="controls col-sm-8">
										<input type="text" name="rank" id="rank"
											class="form-control" value="${article.rank}" />
									</div>
								</div> --%>
								<%-- <div class="form-group">
									<label for="input01" class="control-label col-sm-2">状态：</label>
									<div class="controls col-sm-8">
										<select id="status" name="status" class="form-control">
											<option value="-1"
												<c:if test="${article.status=='-1'}">selected</c:if>>请选择</option>
											<option value="0"
												<c:if test="${article.status=='0'}">selected</c:if>>支持</option>
											<option value="1"
												<c:if test="${article.status=='1'}">selected</c:if>>未审核</option>
										</select>
									</div>
								</div> --%>
								<%-- <div class="form-group">
									<label for="input01" class="control-label col-sm-2">标题图片地址(本站)：</label>
									<div class="controls col-sm-8">
										<input type="text" name="titlepic" id="titlepic"
											class="form-control" value="${article.titlepic}" />
									</div>
								</div> --%>
								
										<div class="form-group">
											<label for="input01" class="control-label col-sm-2">标题图片：</label>
											<div class="controls col-sm-2">
													<span class="btn btn-success fileinput-button">
												  					<span>上传图片</span>
				       										 		<input id="fileupload" type="file" name="file" multiple>
				        							</span>
												<input type="hidden" name="titlepic" id="titlepic" value="${article.titlepic}" />
											</div>
											<div class="col-sm-2">
												<div id="progress" class="progress">
											        <div id="progress" class="progress-bar progress-bar-success"></div>
											 	</div>
											 </div>
										</div>
										
									<div class="form-group">
										<label class="control-label col-sm-2">标题图片：</label>
										<div class="controls col-sm-8">
											<c:choose>
		        									<c:when test="${article.titlepic != null&&article.titlepic != '' }">
		        										<img src="${upyunhttp }${article.titlepic}" id="titlepicimg" class="col-sm-8">
		        									</c:when>
		        									<c:otherwise>
														<img src="" id="titlepicimg">
		        									</c:otherwise>
		        								</c:choose>
					    						
										</div>
									</div>
								
								<%-- <div class="form-group">
									<label for="input01" class="control-label col-sm-2">标题图片原地址：</label>
									<div class="controls col-sm-8">
										<input type="text" name="sourcetitilepic" id="sourcetitilepic"
											class="form-control" value="${article.sourcetitilepic}" />
									</div>
								</div> --%>
								
								
								</div>
							
								<div class="form-actions">
									<div class="col-sm-1"></div>
									<div class="col-sm-12 text-center" >
										<a href="${ctx }/article/list" class="btn btn-info"><span class="fa fa-arrow-left fa-fw"></span> 返回</a>
										&nbsp;&nbsp;
										<button class="btn btn-primary" type="submit"><span class="fa fa-floppy-o fa-fw"></span> 
										<c:if test="${article.id>0}">修改文章</c:if> <c:if test="${article.id==0}">添加文章</c:if></button>
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
		        	$("#titlepic").attr("value",data.result.imgpath);
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
