<%@page language="java" contentType="text/html; charset=UTF-8"%>
<%@ include file="/common/taglibs.jsp"%>
<!DOCTYPE html>
<html lang="en">
<head>
	<script type="text/javascript" src="${ctx }/js/plugins/My97DatePicker/WdatePicker.js"></script>
	<link rel="stylesheet" href="${ctx }/css/jquery.fileupload.css">
</head>
<body>
			<div class="row">
			<div class="col-sm-12">
				<c:if test="${appadvert.id==0 }">
				<h1 class="page-header">添加广告</h1>
				</c:if>
				<c:if test="${appadvert.id>0 }">
				<h1 class="page-header">修改广告</h1>
				</c:if>
			</div>
		</div>
		<div class="row">
			<div class="col-sm-12">
				<div class="panel panel-default">
					<div class="panel-heading">请填写以下选项：</div>
					<div class="panel-body">
						<div class="row">
							<form id="addUserInfoform" class="form-horizontal"
								action="${ctx }/advert/saveorupdate" method="post">
								<input name="id" type="hidden" value="${appadvert.id }" />
							<div class="col-sm-6">
								<div class="form-group">
								<div class="form-group">
									<label for="input01" class="control-label col-sm-2">广告类型：</label>
									<div class="controls col-sm-8">
										<select id="adtype" name="adtype" class="form-control" onchange="choose(this.value)">
											<option value="-1"
												<c:if test="${appadvert.status=='-1'}">selected</c:if>>请选择</option>
											<c:forEach var="item" items="${appAdvertTypelist}">	
											<option value="${item.id}"
												<c:if test="${item.id==appadvert.adtype|| item.id==appAdverType.id}">selected</c:if>>${item.adtypename}</option>
											</c:forEach>	
										</select>
									</div>
								</div>
									<label for="input01" class="control-label col-sm-2">广告名称：</label>
									<div class="controls col-sm-8">
										<input type="text" name="adname" id="adname" class="form-control" value="${appadvert.adname }" required />
									</div>
								</div>
										
								<div class="form-group">
									<label for="input01" class="control-label col-sm-2">广告描述：</label>
									<div class="controls col-sm-8">
										<input type="text" name="addesc" id="addesc" class="form-control" value="${appadvert.addesc}" required />
									</div>
								</div>
								<div class="form-group">
									<label for="input01" class="control-label col-sm-2">广告状态：</label>
									<div class="controls col-sm-8">
										<select id="status" name="status" class="form-control">
											<option value="-1"
												<c:if test="${appadvert.status=='-1'}">selected</c:if>>请选择</option>
											<option value="0"
												<c:if test="${appadvert.status=='0'}">selected</c:if>>正常</option>
											<option value="1"
												<c:if test="${appadvert.status=='1'}">selected</c:if>>禁用</option>
										</select>
									</div>
								</div>
								
								<div class="form-group">
									<label for="input01" class="control-label col-sm-2">开始时间：</label>
									<div class="controls col-sm-8">
										 <input required class="form-control" onfocus="WdatePicker({dateFmt: 'yyyy-MM-dd HH:mm:ss'})" name="start" id="start" type="text"  placeholder="输入开始日期"  value="${start }" onClick="WdatePicker()"/>
									</div>
								</div>
								<div class="form-group">
									<label for="input01" class="control-label col-sm-2">结束时间：</label>
									<div class="controls col-sm-8">
										 <input required class="form-control" onfocus="WdatePicker({dateFmt: 'yyyy-MM-dd HH:mm:ss'})" name="end" id="end" type="text" placeholder="输入开始日期"  value="${end}" onClick="WdatePicker()"/>
									</div>
								</div>
								
								<div class="form-group">
									<label for="input01" class="control-label col-sm-2">国家：</label>
									<div class="controls col-sm-8">
										<select id="countrycode" name="countrycode" class="form-control">
											<option value="00" >所有国家</option>
											<c:forEach var="country" items="${hbcountrys}">
											<option value="${country.code }" <c:if test="${appadvert.countrycode==country.code}">selected</c:if>>${country.cnname}</option>
											</c:forEach>		
										</select>
									</div>
								</div>
								
								<div class="form-group">
									<label for="input01" class="control-label col-sm-2">语言：</label>
									<div class="controls col-sm-8">
										<select id="langid" name="langid" class="form-control">
											<option value="0" >所有语言</option>
											<c:forEach var="language" items="${hblanguages}">
											<option value="${language.id}" <c:if test="${appadvert.langid==language.id}">selected</c:if>>${language.cnname }</option>
											</c:forEach>
										</select>
									</div>
								</div>
								
								
								<%-- <c:if test="${appAdverType.adurl=='0'}"> --%>
								<div class="form-group" id="adurl" <c:if test="${adtype.adurl ==1 }">style="display:none;"</c:if>>
									<label for="input01" class="control-label col-sm-2">广告url：</label>
									<div class="controls col-sm-8">
										<input type="text" name="adurl" id="adurl1" class="form-control" value="${appadvert.adurl}"  />
									</div>
								</div>
								<%-- </c:if> --%>
								
								<%-- <c:if test="${appAdverType.adtitle=='0'}"> --%>
								<div class="form-group" id="adtitle" <c:if test="${adtype.adtitle ==1 }">style="display:none;"</c:if>>
									<label for="input01" class="control-label col-sm-2">广告标题：</label>
									<div class="controls col-sm-8">
										<input type="text" name="adtitle" id="adtitle1" class="form-control" value="${appadvert.adtitle}"  />
									</div>
								</div>
								<%-- </c:if> --%>
								<div class="form-group">
									<label for="input01" class="control-label col-sm-2">应用：</label>
									<div class="controls col-sm-8">
										<select id="appid" name="appid" class="form-control" onchange="modellist(this.value)">
											<option value="-1"
												<c:if test="${appadvert.status=='-1'}">selected</c:if>>请选择</option>
											<c:forEach var="item" items="${applicationlist}">
											<option value="${item.id}"
												<c:if test="${appadvert.appid==item.id}">selected</c:if>>${item.appname}</option>
											</c:forEach>		
										</select>
									</div>
								</div>
								
								<div class="form-group">
									<label for="input01" class="control-label col-sm-2">模块：</label>
									<div class="controls col-sm-8" id="works">
									<c:if test="${appadvert.modelid!='0'}">
										<select id="modelid" name="modelid" class="form-control">
									<c:forEach var="appmodel" items="${models}">
											<option value="${appmodel.id}"
												<c:if test="${appadvert.modelid==appmodel.id}">selected</c:if>>${appmodel.modelname}</option>
																						
									</c:forEach>
										</select>
									</c:if>
									</div>
								</div>
								
								<div class="form-group">
									<label for="input01" class="control-label col-sm-2">分成金额：</label>
									<div class="controls col-sm-8">
										<input type="text" name="divideprice" id="divideprice" class="form-control" value="${appadvert.divideprice}" required />
									</div>
								</div>
								
								<div class="form-group">
									<label for="input01" class="control-label col-sm-2">合作id：</label>
									<div class="controls col-sm-8">
										<input type="text" name="jointid" id="jointid" class="form-control" value="${appadvert.jointid}" required />
									</div>
								</div>
								
								<div class="form-group">
									<label for="input01" class="control-label col-sm-2">星级：</label>
									<div class="controls col-sm-8">
										<input type="text" name="starlv" id="starlv" class="form-control" value="${appadvert.starlv}" required />
									</div>
								</div>
								
								<div class="form-group">
									<label for="input01" class="control-label col-sm-2">合作公司：</label>
									<div class="controls col-sm-8">
										<input type="text" name="jointcom" id="jointcom" class="form-control" value="${appadvert.jointcom}" required />
									</div>
								</div>
								
								<div class="form-group">
									<label for="input01" class="control-label col-sm-2">内容类型：</label>
									<div class="controls col-sm-8">
										<select id="contype" name="contype" class="form-control">
											<option value="-1"
												<c:if test="${appadvert.contype=='-1'}">selected</c:if>>请选择</option>
											<option value="0"
												<c:if test="${appadvert.contype=='0'}">selected</c:if>>广告</option>
											<option value="1"
												<c:if test="${appadvert.contype=='1'}">selected</c:if>>应用</option>
											<option value="2"
												<c:if test="${appadvert.contype=='2'}">selected</c:if>>游戏</option>
										</select>
									</div>
								</div>
								
								<div class="form-group">
									<label for="input01" class="control-label col-sm-2">合作类型：</label>
									<div class="controls col-sm-8">
										<select id="jointtype" name="jointtype" class="form-control">
											<option value="-1"
												<c:if test="${appadvert.jointtype=='-1'}">selected</c:if>>请选择</option>
											<option value="0"
												<c:if test="${appadvert.jointtype=='0'}">selected</c:if>>CPA</option>
											<option value="1"
												<c:if test="${appadvert.jointtype=='1'}">selected</c:if>>CPC</option>
											<option value="2"
												<c:if test="${appadvert.jointtype=='2'}">selected</c:if>>CPM</option>
											<option value="3"
												<c:if test="${appadvert.jointtype=='3'}">selected</c:if>>CPD</option>
										</select>
									</div>
								</div>
								
								<%-- <c:if test="${appAdverType.adpackage=='0'}"> --%>
								<div class="form-group" id="adpackage" <c:if test="${adtype.adpackage ==1 }">style="display:none;"</c:if>>
									<label for="input01" class="control-label col-sm-2">包名：</label>
									<div class="controls col-sm-8">
										<input type="text" name="adpackage" id="adpackage1" class="form-control" value="${appadvert.adpackage}"  />
									</div>
								</div>
								<%-- </c:if> --%>
								
								<%-- <c:if test="${appAdverType.urltype=='0'}"> --%>
								<div class="form-group" id="urltype" <c:if test="${adtype.urltype ==1 }">style="display:none;"</c:if>>
									<label for="input01" class="control-label col-sm-2">url类型：</label>
									<div class="controls col-sm-8">
										<select id="urltype1" name="urltype" class="form-control">
											<option value="-1"
												<c:if test="${appadvert.urltype=='-1'}">selected</c:if>>请选择</option>
											<option value="0"
												<c:if test="${appadvert.urltype=='0'}">selected</c:if>>URL</option>
											<option value="1"
												<c:if test="${appadvert.urltype=='1'}">selected</c:if>>DDL</option>
											<option value="2"
												<c:if test="${appadvert.urltype=='2'}">selected</c:if>>APK</option>
										</select>
									</div>
								</div>
								<%-- </c:if> --%>
								
								<%-- <c:if test="${appAdverType.adcontent=='0'}"> --%>
								<div class="form-group" id="adcontent" <c:if test="${adtype.adcontent ==1 }">style="display:none;"</c:if>>
									<label for="input01" class="control-label col-sm-2">广告内容：</label>
									<div class="controls col-sm-8">
										<input type="text" name="adcontent" id="adcontent1" class="form-control" value="${appadvert.adcontent}"  />
									</div>
								</div>
								<%-- </c:if> --%>
								
								<%-- <c:if test="${appAdverType.adapksize=='0'}"> --%>
								<div class="form-group" id="adapksize" <c:if test="${adtype.adapksize ==1 }">style="display:none;"</c:if>>
									<label for="input01" class="control-label col-sm-2">安装包大小：</label>
									<div class="controls col-sm-8">
										<input type="text" name="adapksize" id="adapksize1" class="form-control" value="${appadvert.adapksize}"  />
									</div>
								</div>
								<%-- </c:if> --%>
								
							</div>
							
							<div class="col-sm-6">
							<%-- <c:if test="${appAdverType.adimg=='0'}"> --%>
										<div class="form-group" id="adimg" <c:if test="${adtype.adimg ==1 }">style="display:none;"</c:if>>
											<label for="input01" class="control-label col-sm-2">广告图片：</label>
											<div class="controls col-sm-2">
													<span class="btn btn-success fileinput-button">
												  					<span>上传图片</span>
				       										 		<input id="fileupload" type="file" name="file" multiple>
				        							</span>
												<input type="hidden" name="adimg" id="adimg1" value="${appadvert.adimg }" />
											</div>
											<div class="col-sm-2">
												<div id="progress" class="progress">
											        <div id="progress" class="progress-bar progress-bar-success"></div>
											 	</div>
											 </div>
										</div>
										
										<div class="form-group" id="adimg2" <c:if test="${adtype.adimg ==1 }">style="display:none;"</c:if>>
										<label class="control-label col-sm-2">广告图片：</label>
										<div class="controls col-sm-8">
											<c:choose>
		        									<c:when test="${appadvert.adimg != null&&appadvert.adimg != '' }">
		        										<img src="${upyunhttp }${appadvert.adimg}" id="titlepicimg" class="col-sm-8">
		        									</c:when>
		        									<c:otherwise>
														<img src="" id="titlepicimg">
		        									</c:otherwise>
		        								</c:choose>
										</div>
									</div>
								<%-- </c:if> --%>
									
								<%-- <c:if test="${appAdverType.adicon=='0'}">	 --%>
									<div class="form-group" id="adicon" <c:if test="${adtype.adicon ==1 }">style="display:none;"</c:if>>
											<label for="input01" class="control-label col-sm-2">图标：</label>
											<div class="controls col-sm-2">
													<span class="btn btn-success fileinput-button">
												  					<span>上传图标</span>
				       										 		<input id="fileupload2" type="file" name="file" multiple>
				        							</span>
												<input type="hidden" name="adicon" id="adicon1" value="${appadvert.adicon }" />
											</div>
											<div class="col-sm-2">
												<div id="progress2" class="progress">
											        <div id="progress2" class="progress-bar progress-bar-success"></div>
											 	</div>
											 </div>
										</div>
										
										<div class="form-group" id="adicon2" <c:if test="${adtype.adicon ==1 }">style="display:none;"</c:if>>
										<label class="control-label col-sm-2">图标：</label>
										<div class="controls col-sm-8">
											<c:choose>
		        									<c:when test="${appadvert.adicon != null&&appadvert.adicon != '' }">
		        										<img src="${upyunhttp }${appadvert.adicon}" id="titlepicimg2" class="col-sm-8">
		        									</c:when>
		        									<c:otherwise>
														<img src="" id="titlepicimg2">
		        									</c:otherwise>
		        								</c:choose>
										</div>
									</div>
								<%-- </c:if> --%>
								
								<%-- <c:if test="${appAdverType.adapk=='0'}">	 --%>	
									<div class="form-group" id="adapk" <c:if test="${adtype.adapk ==1 }">style="display:none;"</c:if>>
											<label for="input01" class="control-label col-sm-2">安装地址：</label>
											<div class="controls col-sm-2">
													<span class="btn btn-success fileinput-button">
												  					<span>上传apk</span>
				       										 		<input id="fileupload3" type="file" name="file" multiple>
				        							</span>
				        							
												<input type="text" name="adapk" id="adapk1" value="${appadvert.adapk }" />
											</div>
											<div class="col-sm-2">
												<div id="progress3" class="progress">
											        <div id="progress3" class="progress-bar progress-bar-success"></div>
											 	</div>
											 </div>
										</div>
										
								<%-- </c:if> --%>
									
							</div>
							
							
							
							<div class="form-actions">
									<div class="col-sm-12 text-center">
										<a href="${ctx }/advert/list" class="btn btn-info"><span class="fa fa-arrow-left fa-fw"></span> 返回</a>
										&nbsp;&nbsp;
										<button class="btn btn-primary" type="submit"><span class="fa fa-floppy-o fa-fw"></span> 
										<c:if test="${appadvert.id>0}">修改广告</c:if> <c:if test="${appadvert.id==0}">添加广告</c:if></button>
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
		        	$("#adimg1").attr("value",data.result.imgpath);
		        },
		        progressall: function (e, data) {
		            var progress = parseInt(data.loaded / data.total * 100, 10);
		            $('#progress .progress-bar').css('width',progress + '%' );
		        }
		    }).prop('disabled', !$.support.fileInput)
		        .parent().addClass($.support.fileInput ? undefined : 'disabled');
		    
		    
		    $('#fileupload2').fileupload({
		        url: '${ctx}/upload/upyun',
		        dataType: 'json',
		        done: function (e, data) {
		        	$("#titlepicimg2").attr("src",""+data.result.imgsrc+"");
		        	$("#titlepicimg2").attr("class","col-sm-8");
		        	$("#adicon1").attr("value",data.result.imgpath);
		        },
		        progressall: function (e, data) {
		            var progress = parseInt(data.loaded / data.total * 100, 10);
		            $('#progress2 .progress-bar').css('width',progress + '%' );
		        }
		    }).prop('disabled', !$.support.fileInput)
		        .parent().addClass($.support.fileInput ? undefined : 'disabled');
		    
		    
		    $('#fileupload3').fileupload({
		        url: '${ctx}/upload/upyun',
		        dataType: 'json',
		        done: function (e, data) {
		        	$("#titlepicimg3").attr("src",""+data.result.imgsrc+"");
		        	$("#titlepicimg3").attr("class","col-sm-8");
		        	$("#adapk1").attr("value",data.result.imgsrc);
		        },
		        progressall: function (e, data) {
		            var progress = parseInt(data.loaded / data.total * 100, 10);
		            $('#progress3 .progress-bar').css('width',progress + '%' );
		        }
		    }).prop('disabled', !$.support.fileInput)
		        .parent().addClass($.support.fileInput ? undefined : 'disabled');
		    
		    
		    
		    
		});
		
		
		
		
		function modellist(id){
			var url="${ctx }/advert/ajaxwb?appid="+id;
			
			/*  var ajax = InitAjax();
			//使用Get方式进行请求
			ajax.open("GET", url, true);
			//获取执行状态
			ajax.onreadystatechange = function() {
			//如果执行是状态正常，那么就把返回的内容赋值给上面指定的层
				if (ajax.readyState == 4 && ajax.status == 200) {
						var date=ajax.responseText;
						$('#works').html(date);
				}
			}
			//发送空
			ajax.send(null);  */
			
			var ajax = false;
		    if(window.XMLHttpRequest) { 
		        ajax = new XMLHttpRequest();
		        if (ajax.overrideMimeType) {//设置MiME类别
		            ajax.overrideMimeType("text/xml");
		        }
		    }else if (window.ActiveXObject) {     // IE浏览器
		        try{
		            ajax = new ActiveXObject("Msxml2.XMLHTTP");
		        }catch (e){
		            try{
		                ajax = new ActiveXObject("Microsoft.XMLHTTP");
		            }catch(e){}
		        }
		    }
		    if (!ajax){     
		        // 异常，创建对象实例失败
		        window.alert("不能创建XMLHttpRequest对象实例.");
		        return false;
		    }               
		    //通过Post方式打开连接
		    ajax.open("GET", url, true);
		    //发送GET数据,已经在URL中赋了值所以send那里只要加个空参.
		    ajax.send(null);
		    //获取执行状态
		    ajax.onreadystatechange = function(){ 
		           //如果执行状态成功，那么就把返回信息写到指定的层里
		           if (ajax.readyState == 4 && ajax.status == 200){ 
		            	var date = ajax.responseText; 
		            	$('#works').html(date);
		           } 
		    } 
		}
		
		</script>
	<script type="text/javascript">
	
		function choose(id){
			var url = "${ctx }/advert/ajaxtype?typeid="+id;
			var ajax = false;
		    if(window.XMLHttpRequest){ 
		        ajax = new XMLHttpRequest();
		        if (ajax.overrideMimeType){
		            ajax.overrideMimeType("text/xml");
		        }
		    }else if (window.ActiveXObject){    
		        try {
		            ajax = new ActiveXObject("Msxml2.XMLHTTP");
		        }catch (e){
		            try{
		                ajax = new ActiveXObject("Microsoft.XMLHTTP");
		            }catch(e){}
		        }
		    }if (!ajax){     
		        window.alert("不能创建XMLHttpRequest对象实例.");
		        return false;
		    }               
		    ajax.open("GET", url, true);
		    ajax.send(null);
		    ajax.onreadystatechange = function(){ 
		           if (ajax.readyState == 4 && ajax.status == 200){ 
		            var date = ajax.responseText; 
		            var typestr=date.split(",");
		            for(var i=0;i<typestr.length;i++){
		            	var str=typestr[i].split(":")
		            	if(str[1]==1&&str[0]=="adurl"){
		            		$('#adurl').hide();
		            	}else if(str[1]==0&&str[0]=="adurl"){
		            		$('#adurl').show();
		            	}
		            	if(str[1]==1&&str[0]=="adimg"){
		            		$('#adimg').hide();
		            		$('#adimg2').hide();
		            	}else if(str[1]==0&&str[0]=="adimg"){
		            		$('#adimg').show();
		            		$('#adimg2').show();
		            	}
		            	if(str[1]==1&&str[0]=="adtitle"){
		            		$('#adtitle').hide();
		            	}else if(str[1]==0&&str[0]=="adtitle"){
		            		$('#adtitle').show();
		            	}
		            	if(str[1]==1&&str[0]=="adicon"){
		            		$('#adicon').hide();
		            		$('#adicon2').hide();
		            	}else if(str[1]==0&&str[0]=="adicon"){
		            		$('#adicon').show();
		            		$('#adicon2').show();
		            	}
		            	if(str[1]==1&&str[0]=="adpackage"){
		            		$('#adpackage').hide();
		            	}else if(str[1]==0&&str[0]=="adpackage"){
		            		$('#adpackage').show();
		            	}
		            	if(str[1]==1&&str[0]=="urltype"){
		            		$('#urltypeurltype').hide();
		            	}else if(str[1]==0&&str[0]=="urltype"){
		            		$('#urltypeurltype').show();
		            	}
		            	if(str[1]==1&&str[0]=="adapk"){
		            		$('#adapk').hide();
		            	}else if(str[1]==0&&str[0]=="adapk"){
		            		$('#adapk').show();
		            	}
		            	if(str[1]==1&&str[0]=="adcontent"){
		            		$('#adcontent').hide();
		            	}else if(str[1]==0&&str[0]=="adcontent"){
		            		$('#adcontent').show();
		            	}
		            	if(str[1]==1&&str[0]=="adapksize"){
		            		$('#adapksize').hide();
		            	}else if(str[1]==1&&str[0]=="adapksize"){
		            		$('#adapksize').show();
		            	}
		            	
		             }
		    		
		           } 
			
			}
		    
		}	    
	</script>	
		
		
</body>
</html>
