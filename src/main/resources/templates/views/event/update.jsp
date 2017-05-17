<%@page language="java" contentType="text/html; charset=UTF-8"%>
<%@ include file="/common/taglibs.jsp"%>
<!DOCTYPE html>
<html lang="en">
<head>
	<script type="text/javascript" charset="utf-8">
		 function change(){
			var dynamic =  document.getElementById("dynamic");
			//alert(dynamic);
				var objvalue =  document.getElementById("objvalue");
				objvalue.value = "*";
				objvalue.readonly  = true;
		}
		function change2(){
			var dynamic =  document.getElementById("static");
			//alert(dynamic);
				var objvalue =  document.getElementById("objvalue");
				objvalue.value = "";
				objvalue.readonly  = false;
		}
		$(document).ready(function(){
			//var retData;
			$("#appid").change(function(){
				var appid = $("#appid option:selected").val();
				//var appid=$("#appid").find("option:selected").val();
				var param = {};
				param.appid = appid;
				$.ajax({ 
				     type: "get",
				     url:"${ctx}/event/getModels", 
				     data: param,
				     dataType: "json",  
				     success: function (data) {
				    	 $("#modleid").html("");
				    	 for(var i = 0;i<data.modelList.length;i++){
				    		var modle = document.getElementById("modleid");
				    		var optionElement =  document.createElement("option");
				    		var div1 = document.getElementById("div1");
				    		var div2 = document.getElementById("div2");
				    		optionElement.value = data.modelList[i].id;
				    		optionElement.text = data.modelList[i].modelname;
				    		modle.appendChild(optionElement);
				    		div2.appendChild(modle);
				    		div1.appendChild(div2);
				    	 }
				   	}
				 });  	 
			});
		});
	</script>
</head>
<body>
			<div class="row">
			<div class="col-sm-12">
				<h1 class="page-header">修改自定义事件</h1>
			</div>
		</div>
		<div class="row">
			<div class="col-sm-12">
				<div class="panel panel-default">
					<div class="panel-heading">请填写以下选项：</div>
					<div class="panel-body">
						<div class="row">

							<form id="addUserInfoform" class="form-horizontal"
								action="${ctx }/event/add">
								<input type="hidden" name="id" value="${appevent.id}"/>
								<div class="form-group">
									<label for="input01" class="control-label col-sm-2">事件名称：</label>
									<div class="controls col-sm-8">
										<input type="text" name="eventname" id="eventname"
											class="input-xlarge" value="${appevent.eventname}"
											/>
									</div>
								</div>
								<div class="form-group">
									<label class="control-label col-sm-2" for="roleid">应用名称：</label>
									<div class="controls col-sm-8">
										<select id="appid" name="appid">
											<option value="-1">请选择</option>
											<c:forEach var="item" items="${applicationList}">
												<option id = "applicationId" <c:if test="${item.id==appevent.appid }">  selected="selected" </c:if> value="${item.id }">${item.appname}</option>
											</c:forEach>
										</select>
									</div>
								</div>
								<div class="form-group" id="div1">
									<label class="control-label col-sm-2" for="roleid">模块名称：</label>
									<div class="controls col-sm-8" id = "div2">
										<select id="modleid" name="modleid">
											<option value="-1">请选择</option>
											<option  selected="selected" value ="${appevent.modelid }">${appmodel.modelname}</option>
										</select>
									</div>
								</div>
								<div class="form-group">
									<label for="input01" class="control-label col-sm-2">动作类型：</label>
									<div class="controls col-sm-8">
										<select id="actiontype" name="actiontype">
											<option value="-1">请选择</option>
											<c:forEach var="item" items="${actionTypes}">	
												<option <c:if test="${appevent.actiontype==item.key}"> selected="selected" </c:if>  value="${item.key }">${item.value }</option>
											</c:forEach>
										</select>
									</div>
								</div>
								<div class="form-group">
									<label for="input01" class="control-label col-sm-2">事件类型：</label>
									<div class="controls col-sm-8">
									<select id="objtype" name="objtype">
											<option value="-1">请选择</option>
											<c:forEach var="item" items="${objTypes}">
												<option  <c:if test="${item.key==appevent.objtype}">  selected="selected" </c:if>  value="${item.key }">${item.value }</option>
											</c:forEach>
										</select>
									</div>
								</div>
								<div class="form-group">
									<label for="input01" class="control-label col-sm-2">事件内容：</label>
									<div class="col-sm-8">
										<input type="text" name="objvalue" id="objvalue" class="input-xlarge" value="${appevent.objvalue}"/>
										<label class="radio-inline">
										<c:choose>
												<c:when test="${appevent.objvalue eq '*'}">
													<input type="radio" name="content" checked="checked" readonly="readonly" id="dynamic" onclick="change()"/>动态
													&nbsp;&nbsp;&nbsp;&nbsp;
													<input type="radio" name="content"  id="static" onclick = "change2()"/>固定
												</c:when>
												<c:otherwise>
													<input type="radio" name="content"  id="dynamic" onclick="change()"/>动态 
													&nbsp;&nbsp;&nbsp;&nbsp;
													<input type="radio" name="content" checked="checked" id="static" onclick = "change2()"/>固定
												</c:otherwise>
										</c:choose>
										</label>
									</div>
								</div>
								<div class="form-group">
									<label for="input01" class="control-label col-sm-2">备注：</label>
									<div class="controls col-sm-8">
										<textarea class="form-control" rows="3" name="comment">${appevent.comment}</textarea>
									</div>
								</div>
								
								<div class="form-actions">
									<div class="col-sm-1"></div>
									<div class="col-sm-8">
										<a href="${ctx }/event/list" class="btn btn-info"><span class="fa fa-arrow-left fa-fw"></span> 返回</a>
										&nbsp;&nbsp;
										<button class="btn btn-primary" type="submit"><span class="fa fa-floppy-o fa-fw"></span> 
										修改</button>
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
