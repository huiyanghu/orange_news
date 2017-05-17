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
			<h1 class="page-header">规则详情</h1>
		</div>
	</div>
     <div class="panel-body">
		 <div class="table-responsive">
			<table class="table table-striped table-bordered table-hover"
				id="dataTables-example">

		<input class="form-control" id="id" name="id" type="hidden"  value="${item1.id }" />		
		
		
									
				
				<tr>
					<td>规则名称</td>
					<td>${item1.rulename}</td>
				</tr>
				<tr>
					<td>规则状态</td>
					<td>
					<c:if test="${item1.status==0}">正常</c:if>
					<c:if test="${item1.status==1}">禁用</c:if>
					</td>
				</tr>
				<tr>
					<td>所属列表规则</td>
					<td>
					${liname}
					</td>
				</tr>
				<tr>
					<td>content</td>
					<td>${item1.content}</td>
				</tr>
				<tr>
					<td>媒体名称</td>
					<td>${item1.pname}</td>
				</tr>
				<tr>
					<td>媒体LOGO</td>
					<td>${item1.plogo}</td>
				</tr>
				<tr>
					<td>作者</td>
					<td>${item1.author}</td>
				</tr>
				<tr>
					<td>头像</td>
					<td>${item1.headimg}</td>
				</tr>
				<tr>
					<td>url</td>
					<td>${item1.url}</td>
				</tr>
				<tr>
					<td>文章状态</td>
					<td>
						<c:if test="${item1.constatus==-1}">审核</c:if>
						<c:if test="${item1.constatus==0}">待发布</c:if>
						<c:if test="${item1.constatus==1}">已发布</c:if>
					</td>
				</tr>
				<tr>
					<td>标题</td>
					<td>${item1.title}</td>
				</tr>
				<tr>
					<td>关键字</td>
					<td>${item1.keyword}</td>
				</tr>
				<tr>
					<td>描述</td>
					<td>${item1.describe}</td>
				</tr>
				<tr>
					<td>replacerule</td>
					<td>${item1.replacerule}</td>
				</tr>
				<tr>
					<td>replacecsspath</td>
					<td>${item1.replacecsspath}</td>
				</tr>
				<tr>
					<td>创建时间</td>
					<td>
					<script language="javascript" >
                                        var str='${item1.createtime}';
                                         Date.prototype.format = function (format) {     
                                                var o = {     
                                                    "M+": this.getMonth() + 1,     
                                                    "d+": this.getDate(),     
                                                    "h+": this.getHours(),     
                                                    "m+": this.getMinutes(),     
                                                    "s+": this.getSeconds(),     
                                                    "q+": Math.floor((this.getMonth() + 3) / 3),     
                                                    "S": this.getMilliseconds()     
                                                }     
                                                if (/(y+)/.test(format)) {     
                                                    format = format.replace(RegExp.$1, (this.getFullYear() + "").substr(4 - RegExp.$1.length));     
                                                }     
                                                for (var k in o) {     
                                                    if (new RegExp("(" + k + ")").test(format)) {     
                                                        format = format.replace(RegExp.$1, RegExp.$1.length == 1 ? o[k] : ("00" + o[k]).substr(("" + o[k]).length));     
                                                    }     
                                                }     
                                                return format;     
                                            }  
                                          document.write(new Date(parseInt(str)).format("yyyy-MM-dd hh:mm:ss")); 
                                        </script>
					</td>
				</tr>
				<tr>
					<td>测试url</td>
					<td>${item1.testurl}</td>
				</tr>
				
			</table>
			<div class="col-sm-12 text-center">
				<a href="${ctx }/conrulev2/list?lid=${item1.lid}" class="btn btn-info">
					<span class="fa fa-arrow-left fa-fw"></span> 返回</a>
				<%-- <a href="${ctx }/conrule/test?id=${item1.id}" class="btn btn-info" target="_blank">
					<span class="fa fa-arrow-left fa-fw"></span> 测试</a> --%>
			</div>
			<div class="col-sm-12 text-center">
			</div>
	     </div>
	</div>
	<script type="text/javascript" src="${ctx }/js/jquery.ui.widget.js"></script>
	<script type="text/javascript" src="${ctx }/js/jquery.fileupload.js"></script>
</body>

</html>
