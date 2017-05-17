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
				<h1 class="page-header">更新</h1>
			</div>
		</div>
		<div class="row">
			<div class="col-sm-12">
				<div class="panel panel-default">
					<div class="panel-heading">请填写以下选项：</div>
					<div class="panel-body">
						<div class="row">
							<form id="addUserInfoform" class="form-horizontal"
								action="${ctx }/globalrule/saveorupdate" method="post">
								<input name="id" type="hidden" value="${bean.id }" />
							<div class="col-sm-12">
								<div class="form-group">
									<label for="input01" class="control-label col-sm-2">节点：</label>
									<div class="controls col-sm-4">
										<select id="nid" name="nid" class="form-control" >
											<c:forEach var="item" items="${nodelist}">	
											<option value="${item.id}"
												<c:if test="${item.id==bean.nid}">selected</c:if>>${item.nodename}</option>
											</c:forEach>	
										</select>
									</div>
									<div class="controls col-sm-6">
									</div>
								</div>
								<div class="form-group">
									<label for="input01" class="control-label col-sm-2">规则名称：</label>
									<div class="controls col-sm-4">
										<input type="text" name="rulename" id="rulename" class="form-control" value="${bean.rulename }" required />
									</div>
									<div class="controls col-sm-6">
									</div>
								</div>
								<div class="form-group">
									<label for="input01" class="control-label col-sm-2">媒体id：</label>
									<div class="controls col-sm-4">
										<input type="text" name="pid" id="pid" class="form-control" value="${bean.pid }" required />
										<a id="apid" href="${ctx }/article/list?publicationid=${bean.id}" target="_blank" onclick="redictart()">查看文章</a>
									</div>
									<div class="controls col-sm-6">
										<div id=""></div>
									</div>
								</div>
								
								<div class="form-group">
									<label for="input01" class="control-label col-sm-2">关键字csspath：</label>
									<div class="controls col-sm-4">
										<input type="text" name="keycsspath" id="keycsspath" class="form-control" value="<c:if test="${bean.keycsspath!=null&&bean.keycsspath!='' }">${bean.keycsspath}</c:if><c:if test="${bean.keycsspath==null||bean.keycsspath=='' }">head > meta[name=keywords]|content</c:if>"/><>
									</div>
									<div class="controls col-sm-6">
										<div id="keycsspatharea"></div>
									</div>
								</div>
								
								<div class="form-group">
									<label for="input01" class="control-label col-sm-2">videocsspath：</label>
									<div class="controls col-sm-4">
										<input type="text" name="videocsspath" id="videocsspath" class="form-control" value="${bean.videocsspath }"  />
									</div>
									<div class="controls col-sm-6">
										<div id="videocsspatharea"></div>
									</div>
								</div>
								<div class="form-group">
									<label for="input01" class="control-label col-sm-2">authorcsspath：</label>
									<div class="controls col-sm-4">
										<input type="text" name="authorcsspath" id="authorcsspath" class="form-control" value="${bean.authorcsspath }"  />
									</div>
									<div class="controls col-sm-6">
										<div id="authorcsspatharea"></div>
									</div>
								</div>
							
								<div class="form-group">
									<label for="input01" class="control-label col-sm-2">排序：</label>
									<div class="controls col-sm-4">
										<input type="text" name="rank" id="rank" class="form-control" value="${bean.rank }"  />
									</div>
									<div class="controls col-sm-6">
									</div>
								</div>
								<div class="form-group">
									<label for="input01" class="control-label col-sm-2">replacerule：</label>
									<div class="controls col-sm-4">
										<input type="text" name="replacerule" id="replacerule" class="form-control" value="${bean.replacerule }"  />
									</div>
									<div class="controls col-sm-6">
									</div>
								</div>
								<div class="form-group">
									<label for="input01" class="control-label col-sm-2">testurl：</label>
									<div class="controls col-sm-4">
										<input type="text" name="testurl" id="testurl" class="form-control" value="${bean.testurl }" required />
									</div>
										<div class="controls col-sm-6">
									</div>
								</div>
									<div class="form-group">
									<label for="input01" class="control-label col-sm-2">commentcssapth：</label>
									<div class="controls col-sm-4">
										<input type="text" name="commentcssapth" id="commentcssapth" class="form-control" value="${bean.commentcssapth }"  />
									</div>
									<div class="controls col-sm-6">
									</div>
								</div>
								<div class="form-group">
									<label for="input01" class="control-label col-sm-2">内容的csspath：</label>
									<div class="controls col-sm-4">
										<input type="text" name="concsspath" id="concsspath" class="form-control" value="${bean.concsspath }" required />
									</div>
									</div>
										<div class="controls col-sm-6">
									</div>
								</div>
							
							<div class="form-actions">
									<div class="col-sm-12 text-center">
										<a href="${ctx }/globalrule/list" class="btn btn-info"><span class="fa fa-arrow-left fa-fw"></span> 返回</a>
										<a href="#" class="btn btn-info" onclick="test()"><span class="fa fa-arrow-left fa-fw"></span> 测试</a>
										&nbsp;&nbsp;
										<button class="btn btn-primary" type="submit"><span class="fa fa-floppy-o fa-fw"></span> 
										提交</button>
									</div>
									<div class="col-sm-12 text-center">
										<font color="red" id="resstatus"></font>
									</div>
								</div>
							<div class="col-sm-6">
								<div >
									<textarea id="concsspatharea" rows="10" cols="70" readonly="readonly"></textarea>
								</div>
							</div>	
							<div class="col-sm-6">
								<div >
									<textarea id="commentcssaptharea" rows="10" cols="70" readonly="readonly"></textarea>
								</div>
							</div>
							</form>
						</div>
					</div>
				</div>
			</div>
		</div>
		
		<script type="text/javascript" src="${ctx }/js/jquery.ui.widget.js"></script>
		<script type="text/javascript">
		function redictart() {
			var pid=$("#pid").val();
			$("#apid").attr('href','${ctx }/article/list?publicationid='+pid);
			window.open('${ctx }/article/list?publicationid='+pid);
		}
		function test() {
			var testurl=$("#testurl").val();
			var commentcssapth=$("#commentcssapth").val();
			var replacerule=$("#replacerule").val();
			var authorcsspath=$("#authorcsspath").val();
			var videocsspath=$("#videocsspath").val();
			var keycsspath=$("#keycsspath").val();
			var concsspath=$("#concsspath").val();
			$.ajax({
			     type: 'POST',
			     url: '${ctx}/globalrule/test' ,
			    data: {
			    	testurl:testurl,commentcssapth:commentcssapth,replacerule:replacerule,
			    	authorcsspath:authorcsspath,videocsspath:videocsspath,keycsspath:keycsspath,
			    	concsspath:concsspath
			    } ,
			    success: function(data) { 
			    	$("#concsspatharea").text(data.content);
			    	$("#keycsspatharea").text(data.keyword);$("#authorcsspatharea").text(data.author);
			    	$("#videocsspatharea").text(data.video);$("#commentcssaptharea").text(data.comment);
			    	var ss="完成";
			    	if(data.status==-1){
			    		ss="失败";
			    	}else if(data.status==1){
			    		ss="url无效";
			    	}
			    	$("#resstatus").text(ss);
			    		    } ,
			    dataType: 'json'

			});
			
		}
		</script>
	
		
		
</body>
</html>
