<%@page language="java" contentType="text/html; charset=UTF-8"%>
<%@ include file="/common/taglibs.jsp"%>
<!DOCTYPE html>
<html lang="en">
<head>
<script type="text/javascript"
	src="${ctx }/js/plugins/My97DatePicker/WdatePicker.js"></script>
<script type="text/javascript">
function checkboxclear(){
	 var ids=""; 
	 var answer= document.getElementsByName("checkbox");
	 for(var i=0;i<answer.length;i++){
		 if(answer[i].checked == true){
			 ids=ids+$(answer[i]).val()+",";
		 }
	}
	 if(ids==null||ids==""){
		 alert("请选择win结果");
		 return;
	 }
	$("#winxids").val(ids);
	if(ids!=null||ids!=""){
		$("#button").attr("type","submit");
	}
	
}

</script>
<link rel="stylesheet" href="${ctx }/css/jquery.fileupload.css">
</head>
<body>
	<div class="row">
		<div class="col-sm-12">
			<h1 class="page-header">竞猜结算</h1>
		</div>
	</div>
	<div class="row">
		<div class="col-sm-12">
			<div class="panel panel-default">
				<div class="panel-heading">请填写以下选项：</div>
				<div class="panel-body">
					<div class="col">
						<form id="addUserInfoform" class="form-horizontal"
							action="${ctx }/predictionTopic/predictionTopicClearing" method="post">
							<input name="id" type="hidden" value="${predictionTopic.id }" />
							<input name="winxids" id="winxids" type="hidden" value="" />
							<div class="col-sm-6">
						       <div class="form-group">
									<label for="input01" class="control-label col-sm-2.5">勾选win结果</label>
								</div> 
								 <div class="form-group">
									<div class="controls col-sm-8">
									    
										 <c:forEach items="${itemlist }" var="itemlist">
									     <div>
										 <label>  选项名称：</label>
									     <input type="checkbox" name="checkbox" value="${itemlist.xid }"/>
									       ${itemlist.name }
									    </div>
									</c:forEach>
									</div>
								</div> 
							</div>

							<div class="form-actions">
								<div class="col-sm-1"></div>
								<div class="col-sm-12 text-center">
									<a href="${ctx }/predictionTopic/list" class="btn btn-info"><span
										class="fa fa-arrow-left fa-fw"></span> 返回</a> &nbsp;&nbsp;
									<button class="btn btn-primary" id="button" type="button" onclick="checkboxclear();"> 
										<span class="fa fa-floppy-o fa-fw"></span>
										   竞猜结算
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

</body>

</html>
