<%@page language="java" contentType="text/html; charset=UTF-8"%>
<%@ include file="/common/taglibs.jsp"%>
<!DOCTYPE html>
<html lang="en">
<head>
<script type="text/javascript">
function checkCK(){
	var flag=true;
	var updateckcoins=$("#updateckcoins").val();
	var temp=/^\d$/;
	if(isNaN(updateckcoins)){
		flag=false;
	   alert("请输入有效数字");
	   return ;
	}
	var ckcoins=$("#ckcoins").val();
	var type="";
	var answer= document.getElementsByName("type");
	 for(var i=0;i<answer.length;i++){
		 if(answer[i].checked == true){
			 type=$(answer[i]).val();
		 }
	}
	if(type==1&&ckcoins<updateckcoins){
	    alert("用户余额不足,无法扣除");
		flag=false;
	}
	if(flag){
		$("#button").attr("type","submit");
	} 
}

</script>
</head>
<body>
			<div class="row">
			<div class="col-sm-12">
				<h1 class="page-header">用户充值</h1>
			</div>
		</div>
		<div class="row">
			<div class="col-sm-12">
				<div class="panel panel-default">
					<div class="panel-heading">请填写以下选项：</div>
					<div class="panel-body">
						<div class="row">
							<form id="editRegUserInfoform" class="form-horizontal"
								action="${ctx }/reguser/updatepayck" method="post">
								<input name="uuid" type="hidden" value="${reguser.uuid }" />
								<div class="form-group">
									<label for="input01" class="control-label col-sm-2">uuid:</label>
									<input type="text" value="${reguser.uuid }" readonly="readonly"/>
								</div>
						
								<div class="form-group">
									<label for="input01" class="control-label col-sm-2">用户余额:</label>
									<input name="ckcoins" id="ckcoins" type="text"  <c:if test="${empty reguser.ckcoins  }">value="0"</c:if> value="${reguser.ckcoins }" readonly="readonly"/>
								</div>
								
								<div class="form-group">
									<label for="input01" class="control-label col-sm-2">充值金额:</label>
									<input name="updateckcoins" type="text" id="updateckcoins" value=""/>
								</div>
								<div class="form-group">
									<label for="input01" class="control-label col-sm-2">类型:</label>
									<input type="radio" name="type" value="0" checked="checked"/>充值<br>
									<input type="radio" name="type" value="1"/>扣除<br>
								</div>
								
								</div>
								<div class="form-actions">
									<div class="col-sm-1"></div>
									<div class="col-sm-8">
										<a href="${ctx }/reguser/list" class="btn btn-info"><span class="fa fa-arrow-left fa-fw"></span> 返回</a>
										&nbsp;&nbsp;
										<button class="btn btn-primary" id="button" type="button" onclick="checkCK()"><span class="fa fa-floppy-o fa-fw"></span> 更新余额</button>
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
