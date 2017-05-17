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
			 <h1 class="page-header">文章规则</h1>
		</div>
	</div>
<div class="row">
	<div class="col-sm-12">
		<div class="panel panel-default">
			<div class="panel-heading">请填写以下选项：</div>
				<div class="panel-body">
					<div class="col">
					  <form id="addUserInfoform" class="form-horizontal" action="${ctx }/conrulev2/saveorupdate" method="post">
						<input class="form-control" id="id" name="id" type="hidden"  value="${bean1.id }" />
								<div class="form-group ">
									<label for="input01" class="control-label col-sm-2">规则名称：</label>
									<div class="controls col-sm-4">
										<input type="text" name="rulename" id="rulename" class="form-control" value="${bean1.rulename} " required />
									</div>
									<div class="controls col-sm-6">
									</div>
								</div>
								
								<div class="form-group">
							      <label for="input01" class="control-label col-sm-2">规则状态：</label>
							      	<div class="controls col-sm-4">
								      	<select name="status" class="form-control ">
								      			<option value="0" <c:if test="${bean1.status==0 }">selected</c:if>>正常</option>
									      		<option value="1" <c:if test="${bean1.status==1 }">selected</c:if>>禁用</option>
									      </select>
									 </div>
								</div>
								
								<div class="form-group">
							      <label for="input01" class="control-label col-sm-2">文章状态：</label>
							      	<div class="controls col-sm-4">
								      	<select name="constatus" class="form-control ">
								      			<option value="-1" <c:if test="${bean1.constatus==-1 }">selected</c:if>>未审核</option>
								      			<option value="0" <c:if test="${bean1.constatus==0 }">selected</c:if>>待发布</option>
									      		<option value="1" <c:if test="${bean1.constatus==1 }">selected</c:if>>已发布</option>
									      </select>
									 </div>
								</div>
								
								<div class="form-group">
									<label for="input01" class="control-label col-sm-2">所属列表规则：</label>
									<div class="controls col-sm-4">
										<input type="hidden" name="lid" id="lid" class="form-control" value="${bean1.lid} " required />
										<input type="text" disabled="true" class="form-control" value="${liname} " required />
									</div>
									<div class="controls col-sm-6">
									</div>
								</div>
								
								<div class="form-group">
									<label for="input01" class="control-label col-sm-2">content：</label>
									<div class="controls col-sm-4">
										<input type="text" name="content" id="content" class="form-control" value="${bean1.content} " required />
									</div>
									<div class="controls col-sm-6">
									</div>
								</div>
								<%-- 
								<div class="form-group">
										<label for="input01" class="control-label col-sm-2">媒体名称：</label>
										<div class="controls col-sm-4">
											<input type="text" name="pname" id="pname" class="form-control" value="${bean1.pname}"/>
										</div>
								</div> 
								<div class="form-group">
										<label for="input01" class="control-label col-sm-2">媒体LOGO：</label>
										<div class="controls col-sm-4">
											<input type="text" name="plogo" id="plogo" class="form-control" value="${bean1.plogo}"/>
										</div>
								</div>  --%>
								
								<div class="form-group">
									<label for="input01" class="control-label col-sm-2">作者：</label>
									<div class="controls col-sm-4">
										<input type="text" name="author" id="author" class="form-control" value="${bean1.author}"/>
									</div>
							</div> 
							
								<div class="form-group">
									<label for="input01" class="control-label col-sm-2">头像：</label>
									<div class="controls col-sm-4">
										<input type="text" name="headimg" id="headimg" class="form-control" value="${bean1.headimg}"/>
									</div>
								</div> 
								<div class="form-group">
									<label for="input01" class="control-label col-sm-2">url：</label>
									<div class="controls col-sm-4">
										<input type="text" name="url" id="url" class="form-control" value="${bean1.url}"/>
									</div>
								</div> 
								<div class="form-group">
									<label for="input01" class="control-label col-sm-2">标题：</label>
									<div class="controls col-sm-4">
										<input type="text" name="title" id="title" class="form-control" value="${bean1.title} "/>
									</div>
									<div class="controls col-sm-6">
									</div>
								</div>
							<div class="form-group">
									<label for="input01" class="control-label col-sm-2">关键字：</label>
									<div class="controls col-sm-4">
										<input type="text" name="keyword" id="keyword" class="form-control"
										<c:if test="${bean1.keyword==null||bean1.keyword=='' }"> value="head > meta[name=keywords]|content" </c:if> 
										<c:if test="${bean1.keyword!=null&&bean1.keyword!='' }">value="${bean1.keyword}"</c:if> />
										
									</div>
							</div> 	
							<div class="form-group">
									<label for="input01" class="control-label col-sm-2">描述：</label>
									<div class="controls col-sm-4">
										<input type="text" name="describe" id="describe" class="form-control" 
										<c:if test="${bean1.describe==null||bean1.describe=='' }">value="head > meta[name=description]|content"</c:if>
										<c:if test="${bean1.describe!=null&&bean1.describe!='' }">value="${bean1.describe}"</c:if> />
									</div>
								</div> 
							
								
								
								<div class="form-group">
									<label for="input01" class="control-label col-sm-2">replacerule：</label>
									<div class="controls col-sm-4">
										<input type="text" name="replacerule" id="replacerule" class="form-control" value="${bean1.replacerule} "  />
									</div>
									<div class="controls col-sm-6">
									</div>
								</div>
								<div class="form-group">
									<label for="input01" class="control-label col-sm-2">replacecsspath：</label>
									<div class="controls col-sm-4">
										<input type="text" name="replacecsspath" id="replacecsspath" class="form-control" value="${bean1.replacecsspath} "  />
									</div>
									<div class="controls col-sm-6">
									</div>
								</div>
								<div class="form-group">
									<label for="input01" class="control-label col-sm-2">测试url：</label>
									<div class="controls col-sm-4">
										<input type="text" name="testurl" id="testurl" class="form-control" value="${bean1.testurl} " required />
										<input type="button" value="预览" onclick="preview()"/>
									</div>
									<div class="controls col-sm-6">
									</div>
								</div>
							

							
							
							<!-- -->
							<div class="form-actions">
								<div class="col-sm-1"></div>
								<div class="col-sm-12 text-center">
									<a href="<c:if test="${bean1.id==null||bean1.id==0 }">${ctx }/listrulev2/list?lid=${bean1.lid}</c:if><c:if test="${bean1.id!=null&&bean1.id>0 }">${ctx }/conrulev2/list?lid=${bean1.lid}</c:if>" class="btn btn-info"><span
										class="fa fa-arrow-left fa-fw"></span> 返回</a> &nbsp;&nbsp;
									<a href="#" class="btn btn-info" onclick="test()">
										<span class="fa fa-arrow-left fa-fw"></span> 测试</a>
									<a href="#" class="btn btn-info" onclick="submit()">
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
				$("#addUserInfoform").attr("action","${ctx }/conrulev2/test");
				$("#addUserInfoform").attr("target","_blank");
				$("#addUserInfoform").submit();
		}
		function submit() {
			$("#addUserInfoform").attr("action","${ctx }/conrulev2/saveorupdate");
			$("#addUserInfoform").attr("target","_self");
			$("#addUserInfoform").submit();
	}
			function preview() {
				$("#addUserInfoform").attr("action","${ctx }/conrulev2/preview");
				$("#addUserInfoform").attr("target","_blank");
				$("#addUserInfoform").submit();
			}
</script>
</body>

</html>
