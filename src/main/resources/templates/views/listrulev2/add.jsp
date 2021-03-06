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
			<h1 class="page-header">列表规则</h1>
		</div>
	</div>
<div class="row">
	<div class="col-sm-12">
		<div class="panel panel-default">
			<div class="panel-heading">请填写以下选项：</div>
				<div class="panel-body">
					<div class="col" >
					  <form id="addUserInfoform" class="form-horizontal" action="${ctx }/listrule2/saveorupdate" method="post">
						<input class="form-control" id="id" name="id" type="hidden"  value="${bean.id }" />
							 
								 <div class="form-group">
									<label for="input01" class="control-label col-sm-2">规则名称：</label>
									<div class="controls col-sm-4">
										<input type="text" name="rulename" id="rulename" class="form-control" value="${bean.rulename} " required />
									</div>
									<div class="controls col-sm-6">
									</div>
								</div>
								<div class="form-group">
									<label for="input01" class="control-label col-sm-2">节点id：</label>
									<div class="controls col-sm-4">
										<select id="nodeid" name="nodeid" class="form-control" >
											<c:forEach var="node" items="${nodelist}">	
											<option value="${node.id}"
												<c:if test="${node.id==bean.nodeid}">selected</c:if>>${node.nodename}</option>
											</c:forEach>	
										</select>
									</div>
									<div class="controls col-sm-6">
									</div>
								</div>
								
							
								<div class="form-group">
									<label for="input01" class="control-label col-sm-2">国家：</label>
									<div class="controls col-sm-4">
										<select id="code" name="code" class="form-control" >
											<c:forEach var="country" items="${countrylist}">	
											<option value="${country.code}"
												<c:if test="${country.code==bean.code}">selected</c:if>>${country.cnname}</option>
											</c:forEach>	
										</select>
									</div>
									<div class="controls col-sm-6">
									</div>
								</div>
									<div class="form-group">
									<label for="input01" class="control-label col-sm-2">媒体：</label>
									<div class="controls col-sm-4">
										<select id="pid" name="pid" class="form-control" >
											<c:forEach var="publication" items="${publicationlist}">	
											<option value="${publication.id}"
												<c:if test="${publication.id==bean.pid}">selected</c:if>>${publication.name}</option>
											</c:forEach>	
										</select>
									</div>
									<div class="controls col-sm-6">
									</div>
								</div>
								
								
								<div class="form-group">
									<label for="input01" class="control-label col-sm-2">渠道id：</label>
									<div class="controls col-sm-4">
										<select id="channelid" name="channelid" class="form-control" >
											<c:forEach var="channel" items="${channellist}">	
											<option value="${channel.id}"
												<c:if test="${channel.id==bean.channelid}">selected</c:if>>${channel.channelname}</option>
											</c:forEach>	
										</select>
									</div>
									<div class="controls col-sm-6">
									</div>
								</div>
								<div class="form-group">
									<label for="input01" class="control-label col-sm-2">csspath：</label>
									<div class="controls col-sm-4">
										<input type="text" name="csspath" id="csspath" class="form-control" value="${bean.csspath}" required />
									</div>
									<div class="controls col-sm-6">
									</div>
								</div>
								<div class="form-group">
									<label for="input01" class="control-label col-sm-2">url：</label>
									<div class="controls col-sm-4">
										<input type="text" name="url" id="url" class="form-control" value="${bean.url}" required />
									</div>
									<div class="controls col-sm-6">
									</div>
								</div>
								
								<div class="form-group">
									<label for="input01" class="control-label col-sm-2">话题：</label>
									<div class="controls col-sm-4">
										<select id="topic" name="topic" class="form-control" >
											<c:forEach var="topic" items="${topiclist}">	
											<option value="${topic.tid}"
												<c:if test="${topic.tid==bean.topic}">selected</c:if>>${topic.name}</option>
											</c:forEach>	
										</select>
									</div>
									<div class="controls col-sm-6">
									</div>
								</div>
								
								<div class="form-group">
									<label for="input01" class="control-label col-sm-2">findpre：</label>
									<div class="controls col-sm-4">
										<input type="text" name="findpre" id="findpre" class="form-control" value="${bean.findpre}"/>
									</div>
									<div class="controls col-sm-6">
									</div>
								</div>
								
								<div class="form-group">
									<label for="input01" class="control-label col-sm-2">语言：</label>
									<div class="controls col-sm-4">
										<select id="langid" name="langid" class="form-control" >
											<c:forEach var="lang" items="${langlist}">	
											<option value="${lang.id}"
												<c:if test="${lang.id==bean.langid}">selected</c:if>>${lang.cnname}</option>
											</c:forEach>	
										</select>
									</div>
									<div class="controls col-sm-6">
									</div>
								</div>
								
									<div class="form-group">
							      <label for="input01" class="control-label col-sm-2">列表文章状态：</label>
							      	<div class="controls col-sm-4">
								      	<select name="liststatus" class="form-control ">
									      		<option value="0" <c:if test="${bean.liststatus==0 }">selected</c:if>>正常</option>
									      		<option value="1" <c:if test="${bean.liststatus==1 }">selected</c:if>>未发布</option>
									      </select>
									 </div>
								</div> 
								
						 	<div class="form-group">
							      <label for="input01" class="control-label col-sm-2">规则状态：</label>
							      	<div class="controls col-sm-4">
								      	<select name="status" class="form-control ">
									      		<option  value="0" <c:if test="${bean.status==0 }">selected</c:if>>正常</option>
									      		<option  value="1" <c:if test="${bean.status==1 }">selected</c:if>>禁用</option>
									      </select>
									 </div>
								</div> 
								<div class="form-group">
								      <label for="input01" class="control-label col-sm-2">字符：</label>
									      <div class="controls col-sm-4">
									      	<select name="constant" class="form-control ">
										      		<option value="auto" <c:if test="${bean.constant=='auto' }">selected</c:if>>auto</option>
										      		<option value="utf8" <c:if test="${bean.constant=='utf8' }">selected</c:if>>utf8</option>
										      		<option value="jbk" <c:if test="${bean.constant=='jbk' }">selected</c:if>>jbk</option>
										      		<option value="jb2312" <c:if test="${bean.constant=='jb2312' }">selected</c:if>>jb2312</option>
										    </select>
										   </div>
								</div>
								
								<div class="form-group">
									<label for="input01" class="control-label col-sm-2">抓取时间间隔(秒)：</label>
									<div class="controls col-sm-4">
										<input type="text" name="grabtime" id="grabtime" class="form-control" value="${bean.grabtime} " required />
									</div>
									<div class="controls col-sm-6">
									</div>
								</div>
								
							<div class="form-actions">
								<div class="col-sm-1"></div>
								<div class="col-sm-12 text-center">
									<a href="${ctx }/listrulev2/list" class="btn btn-info"><span
										class="fa fa-arrow-left fa-fw"></span> 返回</a> &nbsp;&nbsp;
									<a href="#" class="btn btn-info" onclick="test()">
											<span class="fa fa-arrow-left fa-fw"></span> 测试</a>
									 <a href="#" class="btn btn-info" onclick="testSubmmit()">
											<span class="fa fa-arrow-left fa-fw"></span>提交</a>
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
		function test() {
				$("#addUserInfoform").attr("action","${ctx }/listrulev2/test");
				$("#addUserInfoform").attr("target","_blank");
				$("#addUserInfoform").submit();
		}
		function testSubmmit() {
			$("#addUserInfoform").attr("action","${ctx }/listrulev2/saveorupdate");
			$("#addUserInfoform").attr("target","_self");
			$("#addUserInfoform").submit();
	}
	</script>

</body>

</html>
