<%@page language="java" contentType="text/html; charset=UTF-8"%>
<%@ include file="/common/taglibs.jsp"%>
<!DOCTYPE html>
<html lang="en">
<head>
	<script type="text/javascript" src="${ctx }/js/plugins/My97DatePicker/WdatePicker.js"></script>
<script>
	function checkchannel(){
		var channelspan= document.getElementById("channelspan");
		channelspan.innerHTML="";
		var val=document.getElementById("channelname").value;
		<c:forEach items="${channelList}" var="obj">
        	var channelname="${obj.channelname}";
        	if(channelname.trim()==val.trim()){
        		channelspan.innerHTML="该渠道已经存在";
        		channelspan.style.color="red";
        		return false;
        	}
     	</c:forEach>
     	return true;
	}
	function checkform(){
		return checkchannel();
	}
</script>
</head>
<body>
	<div class="row">
		<c:if test="${channel.id==0 }">
		<div class="col-sm-12">
			<h1 class="page-header">添加渠道</h1>
		</div>
		</c:if>
		<c:if test="${channel.id>0}">
		<div class="col-sm-12">
			<h1 class="page-header">修改渠道</h1>
		</div>
		</c:if>
	</div>
	<div class="row">
		<div class="col-sm-12">
			<div class="panel panel-default">
				<div class="panel-heading">添加渠道</div>
				<div class="panel-body">
					<div class="row col-sm-8">
						<form id="addform" class="form-horizontal" action="${ctx }/channel/saveorupdate" method="post" <c:if test="${channel.id==0}">onsubmit="return checkform();"</c:if>>
							<input name="id" type="hidden" value="${channel.id }" />
							<div class="form-group">
								<label for="channelname" class="control-label col-sm-2">渠道名称：</label>
								<div class="controls col-sm-8">
									<input type="text" name="channelname" id="channelname"
										class="form-control" value="${channel.channelname }" required
										required-message="请输入渠道名称" <c:if test="${channel.id==0}">onblur="checkchannel();"</c:if>/><span id="channelspan"></span>
								</div>
							</div>
							<div class="form-group">
								<label for="channelcode" class="control-label col-sm-2">渠道代码：</label>
								<div class="controls col-sm-8">
									<input type="text" name="channelcode" id="channelcode"
										class="form-control" value="${channel.channelcode }" required
										required-message="请输入渠道代码" />
								</div>
							</div>
							
							<div class="form-group">
								<label for="channeldesc" class="control-label col-sm-2">渠道描述：</label>
								<div class="controls col-sm-8">
									<input type="text" name="channeldesc" id="channeldesc"
										class="form-control" value="${channel.channeldesc }" required
										required-message="渠道描述" />
								</div>
							</div>
							<div class="form-group">
								<label for="email" class="control-label col-sm-2">渠道邮箱：</label>
								<div class="controls col-sm-8">
									<input type="text" name="email" id="email"
										class="form-control" value="${channel.email }" required
										required-message="渠道邮箱" />
								</div>
							</div>
							<div class="form-group">
								<label for="changepass" class="control-label col-sm-2">渠道密码：</label>
								<div class="controls col-sm-8">
									<input type="password" name="changepass" id="changepass"
										class="form-control" value="${channel.changepass }" required
										required-message="渠道密码" />
								</div>
							</div>
							<div class="form-group">
								<label for="contact" class="control-label col-sm-2">联系人：</label>
								<div class="controls col-sm-8">
									<input type="text" name="contact" id="contact"
										class="form-control" value="${channel.contact }" required
										required-message="渠道联系人" />
								</div>
							</div>
							<div class="form-group">
								<label for="mobile" class="control-label col-sm-2">联系电话：</label>
								<div class="controls col-sm-8">
									<input type="text" name="mobile" id="mobile"
										class="form-control" value="${channel.mobile }" required
										required-message="渠道电话" />
								</div>
							</div>
							
							<div class="form-group">
								<label for="mobile" class="control-label col-sm-2">应用：</label>
								<div class="controls col-sm-8">
									<select id="appid" name="appid" class="form-control">
											<option value="-1"
												<c:if test="${channel.status=='-1'}">selected</c:if>>请选择</option>
											<c:forEach var="item" items="${applications}">
											<option value="${item.id}"
												<c:if test="${channel.appid==item.id}">selected</c:if>>${item.appname}</option>
											</c:forEach>	
										</select>
								</div>
							</div>
							
							<div class="form-group">
								<label for="proportion" class="control-label col-sm-2">结算比例：</label>
								<div class="controls col-sm-8">
									<input type="text" name="proportion" id="proportion"
										class="form-control" value="${channel.proportion }" required
										required-message="结算比例" />
								</div>
							</div>
							<div class="form-group">
								<label for="starttime" class="control-label col-sm-2">合作开始时间：</label>
								<div class="controls col-sm-8">
									<input type="text" name="starttime" id="starttime"
										class="form-control" value="<fmt:formatDate value="${channel.starttime }" type="both" pattern="yyyy-MM-dd 00:00:00"/>" required
										onfocus="WdatePicker({dateFmt:'yyyy-MM-dd 00:00:00'})" required-message="合作开始时间" />
								</div>
							</div>
							<div class="form-group">
								<label for="endtime" class="control-label col-sm-2">合作结束时间：</label>
								<div class="controls col-sm-8">
									<input type="text" name="endtime" id="endtime"
										class="form-control" value="<fmt:formatDate value="${channel.endtime }" type="both" pattern="yyyy-MM-dd 00:00:00"/>" required
										onfocus="WdatePicker({dateFmt:'yyyy-MM-dd 00:00:00'})" required-message="合作结束时间" />
								</div>
							</div>
							
								
							<div class="form-actions">
								<div class="col-sm-1"></div>
								<div class="col-sm-8">
									<a href="${ctx }/channel/list" class="btn btn-info"><span
										class="fa fa-arrow-left fa-fw"></span> 返回</a> &nbsp;&nbsp;
									<button class="btn btn-primary" type="submit">
										<span class="fa fa-floppy-o fa-fw"></span>
										<c:if test="${channel.id>0}">修改渠道</c:if><c:if test="${channel.id==0}">添加渠道</c:if>
									</button>
								</div>
							</div>
						</form>
					</div>
				</div>
			</div>
		</div>
	</div>
	</body>
</html>
