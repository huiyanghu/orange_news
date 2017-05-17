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
					
		<input class="form-control" id="id" name="id" type="hidden"  value="${item.id }" />		
				<tr>
				   <td>规则名称</td>
				   <td>${item.rulename}</td>
				</tr>
				<tr>
				   <td>节点</td>
				   <td>
					   	<div class="input-group" >
							<c:forEach var="node" items="${nodelist}">	
								<c:if test="${node.id==item.nodeid}">${node.nodename}</c:if>
							</c:forEach>	
					    </div>
				   </td>
				</tr>
				
				<tr>
				   <td>渠道</td>
				   <td>
					   	<div class="input-group" >
							<c:forEach var="channel" items="${channellist}">	
								<c:if test="${channel.id==item.channelid}">${channel.channelname}</c:if>
							</c:forEach>	
					    </div>
				   </td>
				</tr>
				
				<tr>
					<td>创建时间</td>
					<td>
						<script language="javascript" >
                                        var str='${item.createtime}';
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
					<td>url</td>
					<td>${item.url}</td>
				</tr>
				<tr>
					<td>字符</td>
					<td>${item.constant}</td>
				</tr>
				<tr>
					<td>国家码</td>
					<td>${item.code}</td>
					<td>
						<div class="input-group" >
							<c:forEach var="country" items="${countrylist}">	
								<c:if test="${country.cid==item.code}">${country.cnname}</c:if>
							</c:forEach>	
					    </div>			
						
					</td>
					
				</tr>
				<tr>
					<td>语言码</td>
					<td>${item.langid}</td>
				</tr>
				
				<tr>
					<td>话题分类id</td>
					<td>
					<div class="input-group" >
						<c:forEach var="topic" items="${topiclist}">	
							<c:if test="${topic.tid==item.topic}">${topic.tid}</c:if>
						</c:forEach>	
				    </div>
					</td>
				</tr>
				
				<tr>
					<td>csspath</td>
					<td>${item.csspath}</td>
				</tr>
				<tr>
					<td>finder</td>
					<td>${item.findpre}</td>
				</tr>
				<tr>
					<td>规则状态</td>
					<td>
					<c:if test="${item.status==0}">正常</c:if>
					<c:if test="${item.status==1}">禁用</c:if>
					</td>
				</tr>
				<tr>
					<td>列表文章状态</td>
					<td>
					<c:if test="${item.liststatus==0}">正常</c:if>
					<c:if test="${item.liststatus==1}">未发布</c:if>
					</td>
				</tr>
				<tr>
					<td>抓取时间间隔(秒)</td>
					<td>${item.grabtime}</td>
				</tr>
				
			</table>
			<div class="col-sm-12 text-center">
				<a href="${ctx }/listrulev2/list" class="btn btn-info">
					<span class="fa fa-arrow-left fa-fw"></span> 返回</a>
			</div>
			<div class="col-sm-12 text-center">
			</div>
	     </div>
	</div>
	<script type="text/javascript" src="${ctx }/js/jquery.ui.widget.js"></script>
	<script type="text/javascript" src="${ctx }/js/jquery.fileupload.js"></script>
</body>

</html>
