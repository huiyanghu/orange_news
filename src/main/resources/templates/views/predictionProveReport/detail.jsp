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
			<h1 class="page-header">详情信息</h1>
		</div>
	</div>
     <div class="panel-body">
			 <div class="table-responsive">
						<table class="table table-striped table-bordered table-hover"
							id="dataTables-example">
							<tr>
							   <td></td>
							    <td></td>
							     <td></td>
							      <td></td>
							</tr>
							<tr>
							   <td>Id:</td>
							    <td>${predictionProveReport.id }</td>
							     <td>用户uuid：</td>
							      <td>${predictionProveReport.uuid}</td>
							</tr>
							<tr>
							   <td>竞猜Id:</td>
							    <td>${predictionProveReport.pid}</td>
							     <td>状态：</td>
							      <td>
							           <c:if test="${predictionProveReport.status=='0'}">未审核</c:if>
									   <c:if test="${predictionProveReport.status=='1'}">删除</c:if>
									   <c:if test="${predictionProveReport.status=='2'}">已选用</c:if>
							      </td>
							</tr>
							<tr>
							   <td>描述：</td>
							    <td style="height: 130px; width: 550px;"> ${predictionProveReport.desc }</td>
							     <td>urls：</td>
							      <td>
							        ${predictionProveReport.urls }
							      </td>
							</tr>
							<tr>
							   <td>类型：</td>
							    <td>
							       <c:if test="${predictionProveReport.itype==0 }">用户证明</c:if>
							        <c:if test="${predictionProveReport.itype==1 }">竞猜举报</c:if>
							         <c:if test="${predictionProveReport.itype==2 }">系统证明</c:if>
							          <c:if test="${predictionProveReport.itype==3 }">证明举报</c:if>
							          <c:if test="${predictionProveReport.itype==3 }">应用建议</c:if>
							    </td>
							     <td>创建时间：</td>
							      <td><fmt:formatDate value="${predictionProveReport.createtime}" type="date" pattern="yyyy-MM-dd HH:mm:ss"/></td>
							</tr>
							
							<tr>
							     <td>图片：</td>
							      <td>
							      <c:if test="${not empty predictionProveReport.picpath}">
							      <img src="${upyunhttp }${predictionProveReport.picpath}" class="col-sm-8"></td>
							      </c:if>
							   <td></td>
							    <td></td>
							</tr>
						</table>
						<div class="form-actions">
								<div class="col-sm-1"></div>
								<div class="col-sm-12 text-center">
									<a href="${ctx }/predictionProveReport/list" class="btn btn-info"><span
										class="fa fa-arrow-left fa-fw"></span> 返回</a> &nbsp;&nbsp;
									
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
