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
			<h1 class="page-header">竞猜详情</h1>
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
							    <td>${predictionTopic.id }</td>
							     <td>文章编号：</td>
							      <td>${predictionTopic.articleid}</td>
							</tr>
							<tr>
							   <td>标题:</td>
							    <td>${predictionTopic.title}</td>
							     <td>状态：</td>
							      <td>
							           <c:if test="${predictionTopic.status=='0'}">正常</c:if>
									   <c:if test="${predictionTopic.status=='1'}">未激活</c:if>
									   <c:if test="${predictionTopic.status=='2'}">关闭</c:if>
							      </td>
							</tr>
							<tr>
							   <td>描述：</td>
							    <td style="height: 130px; width: 550px;"> ${predictionTopic.desc }</td>
							     <td>选项：</td>
							      <td>
							       <c:forEach items="${itemlist }" var="itemlist">
									    <div>选项名称：${itemlist.name }</div>
									</c:forEach>
							      </td>
							</tr>
							<tr>
							   <td>开始时间：</td>
							    <td><fmt:formatDate value="${predictionTopic.starttime}" type="date" pattern="yyyy-MM-dd HH:mm:ss"/></td>
							     <td>阅读数：</td>
							      <td>${predictionTopic.readcount}</td>
							</tr>
							<tr>
							   <td>结束时间：</td>
							    <td><fmt:formatDate value="${predictionTopic.endtime}" type="date" pattern="yyyy-MM-dd HH:mm:ss"/></td>
							     <td>投注数：</td>
							      <td>${predictionTopic.joincount}</td>
							</tr>
							<tr>
							   <td>国家编号：</td>
							    <td>${predictionTopic.countrycode}</td>
							     <td>创建时间：</td>
							      <td><fmt:formatDate value="${predictionTopic.createtime}" type="date" pattern="yyyy-MM-dd HH:mm:ss"/></td>
							</tr>
							<tr>
							   <td>关键词：</td>
							    <td>${predictionTopic.keywords}</td>
							     <td>图片：</td>
							      <td><img src="${upyunhttp }${predictionTopic.titlepic}" class="col-sm-8"></td>
							</tr>
							
							
						</table>
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
