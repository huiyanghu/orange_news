<%@page language="java" contentType="text/html; charset=UTF-8"%>
<%@ include file="/common/taglibs.jsp"%>
<!DOCTYPE html>
<html lang="en">
<head>
<script type="text/javascript" src="${ctx }/js/plugins/My97DatePicker/WdatePicker.js"></script>
<link rel="stylesheet" href="${ctx }/css/jquery.fileupload.css">
<script type="text/javascript">
function changtimetype(){
	var time=$("#subtime").val();
	 var date = new Date(time.replace(/-/g,"/"));  
	 var dlong=date.getTime();
	 //alert(dlong);
	 $("#subtime").val(dlong);
}
</script>
</head>
<body>
			<div class="row">
			<div class="col-sm-12">
				<h1 class="page-header">添加置顶图</h1>
			</div>
		</div>
		<div class="row">
			<div class="col-sm-12">
				<div class="panel panel-default">
					<div class="panel-heading">请填写以下选项：</div>
					<div class="panel-body">
					<div class="col">
							<form id="addUserInfoform" class="form-horizontal"
								action="${ctx }/apptop/saveorupdate" method="post">
								<div class="col-sm-6">
									<div class="form-group">
										<label for="input01" class="control-label col-sm-2">ID：</label>
										<div class="controls col-sm-8">
											<input type="text" name="id" id="id"
												class="form-control" value="${appTop.id}" readonly/>
										</div>
									</div>
								<div class="form-group">
									<label for="input01" class="control-label col-sm-2">国家：</label>
									<div class="controls col-sm-8">
										<select name="countrycode" class="form-control">
										<option value="00">请选择</option>
								      		<c:forEach var="country" items="${countrysSort }">
								      			<option value="${country.code }" <c:if test="${appTop.countrycode ==country.code  }">selected</c:if>>${country.code }  ${country.cnname }</option>
								      		</c:forEach>
							      		</select>
									</div>
								</div>
						    <div class="form-group">
									<label for="input01" class="control-label col-sm-2">语言：</label>
									<div class="controls col-sm-8">
										<select name="langid" class="form-control">
								      		<option value="0">请选择</option>
								      		<c:forEach var="language" items="${languages }">
								      			<option value="${language.id }" <c:if test="${appTop.langid ==language.id  }">selected</c:if>>${language.hbcode }  ${language.cnname }</option>
								      		</c:forEach>
							      		</select>
									</div>
								</div> 
									<div class="form-group">
										<label for="input01" class="control-label col-sm-2">标题：</label>
										<div class="controls col-sm-8">
											<input type="text" name="title" id="title"
												class="form-control" value="${appTop.title}" readonly/>
										</div>
									</div>
								   <div class="form-group">
										<label for="input01" class="control-label col-sm-2">类型：</label>
										<div class="controls col-sm-8">
											<select id="itype" name="itype" class="form-control" >
											<c:if test="${appTop.itype==1}"><option value="1" >文章</option></c:if>
												<c:if test="${appTop.itype==2}"><option value="2" >竞猜</option></c:if>
												<c:if test="${appTop.itype==3}"><option value="3" >广告</option></c:if>
												
											</select>
										</div>
									</div>
									
								   <div class="form-group">
										<label for="input01" class="control-label col-sm-2">文章类型：</label>
										<div class="controls col-sm-8">
											<select id="artitype" name="artitype" class="form-control" readonly>
												<c:if test="${appTop.attr==0}"><option value="0" >文字文章</option></c:if>
												<c:if test="${appTop.attr==1}"><option value="1" >图文文章</option></c:if>
												<c:if test="${appTop.attr==2}"><option value="2" >视频文章</option></c:if>
												<c:if test="${appTop.attr==3}"><option value="3" >链接文章</option></c:if>
												<c:if test="${appTop.attr==4}"><option value="4" >H5游戏文章</option></c:if>
												<c:if test="${appTop.attr==5}"><option value="5" >竞猜文章</option></c:if>
												<c:if test="${appTop.attr==6}"><option value="6" >游戏文章</option></c:if>
												<c:if test="${appTop.attr==7}"><option value="7" >其它</option></c:if>
											</select>
										</div>
									</div>  
									
									<div class="form-group">
									<label for="input01" class="control-label col-sm-2">状态：</label>
									<div class="controls col-sm-8">
										<select id="status" name="status" class="form-control">
											<option value="0"
												<c:if test="${appTop.status=='0'}">selected</c:if>>正常</option>
											<option value="1"
												<c:if test="${appTop.status=='1'}">selected</c:if>>禁用</option>
											<%-- <option value="3"
												<c:if test="${appTop.status=='3'}">selected</c:if>>删除</option> --%>
										</select>
									</div>
								</div>
								
								
								<div class="form-group">
										<label for="input01" class="control-label col-sm-2">发布时间：</label>
										<div class="controls col-sm-8">
							      <fmt:formatDate var="subtime_format" value="${dsubtime }" type="date" pattern="yyyy-MM-dd HH:mm:ss"/>
							      <input class="form-control" id="subtime" name="subtime" type="text" placeholder="输入发布时间" onClick="WdatePicker({dateFmt:'yyyy-MM-dd HH:mm:ss'})"  value="${subtime_format}">
							    </div>
							  </div>
							  
								<div class="form-group">
									<label for="input01" class="control-label col-sm-2">排序：</label>
									<div class="controls col-sm-8">
										<input type="text" name="sort" id="sort" class="form-control"
											value="${appTop.sort}" required />
									</div>
								</div>  

							</div>	
							  <div class="col-sm-6">
								<div class="form-group">
									<label class="control-label col-sm-2">图片：</label>
									<div class="controls col-sm-8">
										<c:choose>
        									<c:when test="${appTop.titlepic != null&&appTop.titlepic != '' }">
        										<img src="${upyunhttp }${appTop.titlepic}" id="titlepicimg" class="col-sm-8">
        									</c:when>
        									<c:otherwise>
												<img src="" id="titlepicimg">
        									</c:otherwise>
	        							</c:choose>
				    						
									</div>
								</div>
								</div>	 
							  </div>
								<!-- end -->
							
							</div>
							
								<div class="form-actions">
									<div class="col-sm-1"></div>
									<div class="col-sm-12 text-center" >
										<a href="${ctx }/apptop/list" class="btn btn-info"><span class="fa fa-arrow-left fa-fw"></span> 返回</a>
										&nbsp;&nbsp;
										<button class="btn btn-primary" type="submit" onclick="changtimetype();"><span class="fa fa-floppy-o fa-fw"></span> 
										<c:if test="${not empty appTop.id}">修改置顶图</c:if></button>
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
