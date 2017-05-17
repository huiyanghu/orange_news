<%@page language="java" contentType="text/html; charset=UTF-8"%>
<%@ include file="/common/taglibs.jsp"%>
<!DOCTYPE html>
<html lang="en">
<head>
</head>
<body>
			<div class="row">
			<div class="col-sm-12">
				<h1 class="page-header">修改用户信息</h1>
			</div>
		</div>
		<div class="row">
			<div class="col-sm-12">
				<div class="panel panel-default">
					<div class="panel-heading">请填写以下选项：</div>
					<div class="panel-body">
						<div class="row">
							<form id="editRegUserInfoform" class="form-horizontal"
								action="${ctx }/reguser/updateinfo" method="post">
								<input name="uuid" type="hidden" value="${reguser.uuid }" />
								<div class="form-group">
									<label for="input01" class="control-label col-sm-2">uuid:</label>
									<input type="text" value="${reguser.uuid }" readonly="readonly"/>
								</div>
								<div class="form-group">
									<label for="input01" class="control-label col-sm-2">用户邮箱:</label>
									<input type="text" value="${reguser.email }" readonly="readonly"/>
								
								</div>
							    <div class="form-group">
									<label for="input01" class="control-label col-sm-2">用户类型:</label>
									<c:choose>
									   <c:when test="${reguser.utype==0 }">
									     <input type="text" value="coolook" readonly="readonly"/>
									   </c:when>
									   <c:when test="${reguser.utype==1 }">
									     <input type="text" value="facebook" readonly="readonly"/>
									   </c:when>
									   <c:when test="${reguser.utype==2 }">
									     <input type="text" value="twitter" readonly="readonly"/>
									   </c:when>
									   <c:when test="${reguser.utype==3 }">
									      <input type="text" value="google+" readonly="readonly"/>
									   </c:when>
									   <c:otherwise>
									       <input type="text" value="" readonly="readonly"/>
									   </c:otherwise>
									</c:choose>
									
								</div>
								<div class="form-group">
									<label for="input01" class="control-label col-sm-2">facebook:</label>
									<c:choose>
									<c:when test="${reguser.fbinding==0 }">
									<input type="text" value="绑定" readonly="readonly"/>
									</c:when>
									<c:when test="${reguser.fbinding==1 }">
									<input type="text" value="未绑定" readonly="readonly"/>
									</c:when>
									 <c:otherwise>
									 <input type="text" value="" readonly="readonly"/>
									 </c:otherwise>  
									</c:choose>
								</div>
								<div class="form-group">
									<label for="input01" class="control-label col-sm-2">twitter:</label>
									<c:choose>
									<c:when test="${reguser.tbingding==0 }">
									<input type="text" value="绑定" readonly="readonly"/>
									</c:when>
									<c:when test="${reguser.tbingding==1 }">
									<input type="text" value="未绑定" readonly="readonly"/>
									</c:when>
									 <c:otherwise>
									 <input type="text" value="" readonly="readonly"/>
									 </c:otherwise>  
									</c:choose>
									
								</div>
								<div class="form-group">
									<label for="input01" class="control-label col-sm-2">google+:</label>
									<c:choose>
									<c:when test="${reguser.gbinging==0 }">
									<input type="text" value="绑定" readonly="readonly"/>
									</c:when>
									<c:when test="${reguser.gbinging==1 }">
									<input type="text" value="未绑定" readonly="readonly"/>
									</c:when>
									 <c:otherwise>
									 <input type="text" value="" readonly="readonly"/>
									 </c:otherwise>  
									</c:choose>
									
									
								</div>
							
								<div class="form-group">
									<label for="sex" class="control-label col-sm-2">状态:</label>
									
								      	<select  name="status" class="form-control "style="display:inline-block; width:100px;">
									      		<option value="-1" <c:if test="${reguser.status==-1 }">selected</c:if>>未激活</option>
									      		<option value="0" <c:if test="${reguser.status==0 }">selected</c:if>>激活</option>
									      		<option value="1" <c:if test="${reguser.status==1 }">selected</c:if>>禁用</option>
									      		<option value="3" <c:if test="${reguser.status==3 }">selected</c:if>>删除</option>
									      </select>
							   	  </div>
								</div>
								<div class="form-actions">
									<div class="col-sm-1"></div>
									<div class="col-sm-8">
										<a href="${ctx }/reguser/list" class="btn btn-info"><span class="fa fa-arrow-left fa-fw"></span> 返回</a>
										&nbsp;&nbsp;
										<button class="btn btn-primary" type="submit"><span class="fa fa-floppy-o fa-fw"></span> 修改状态</button>
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
