<%@page language="java" contentType="text/html; charset=UTF-8"%>
<%@ include file="/common/taglibs.jsp"%>
<!DOCTYPE html>
<html lang="en">
<head>
<script src="${ctx }/js/page/jqPaginator.min.js" type="text/javascript"></script>
<link href="${ctx }/css/page/myPage.css" rel="stylesheet" type="text/css" />
<script type="text/javascript" src="${ctx }/js/plugins/My97DatePicker/WdatePicker.js"></script>
<script type="text/javascript">
	function refreshs(obj){
		var id=$(obj).attr("beanid");
		if(confirm("确认要修改更新时间吗?")){
			var href = "${ctx }/apptop/refreshtime?id="+id+"&starttime=${starttime}&endtime=${endtime}&countrycode=${appTop.countrycode}&status=${appTop.status}&itype=${appTop.itype}";
			$(obj).attr("href",href);
		}
	}
	
	function deleteapp(obj){
		var id=$(obj).attr("beanid");
		if(confirm("确认要删除吗?")){
			var href = "${ctx }/apptop/deleteApptop?id="+id+"&starttime=${starttime}&endtime=${endtime}&countrycode=${appTop.countrycode}&status=${appTop.status}&itype=${appTop.itype}";
			$(obj).attr("href",href);
		}
	}
	
	function updateSort(){
	/* 	var answer= document.getElementsByName("beansort"); */
	//debugger;
	var answer= $("input[name='beansort']");
		var ids="";
		for(var i=0;i<answer.length;i++){
			var sort=$(answer[i]).val();
			var id=$(answer[i]).attr("ids");
			var n=id+"-"+sort;
			if(id!=null&&id!=""&&sort!=null){
			ids=ids+n+",";
			}
			//alert(ids);
		}
		$("#beanids").val(ids);
		document.getElementById('sortupdate').submit();
	} 
 
</script>
</head>
<body>
	<div class="row">
		<div class="col-sm-12">
			<h1 class="page-header">置顶图管理</h1>
		</div>
	</div>
	<div class="row">
		<div class="col-sm-12">
			<div class="panel panel-default">
				<div class="panel-heading text-left">
					<div class="row">
					<form class="form-inline" role="form" action="" method="get">
							<!-- <input name="page" type="hidden" value="1"/> -->
							<input name="id" type="hidden" value=""/>
							  <div class="input-group">
							      <div class="input-group-addon">国家:</div>
							      	<select name="countrycode" class="form-control">
							      		<option value="">请选择</option>
							      		<option value="00">所有国家</option>
							      		<c:forEach var="country" items="${countrysSort }">
							      			<option value="${country.code }" <c:if test="${appTop.countrycode ==country.code  }">selected</c:if>>${country.code }  ${country.cnname }</option>
							      		</c:forEach>
							      	</select>
							   	  </div>
							   	<div class="input-group">
							      <div class="input-group-addon">类型:</div>
							      	<select name="itype" class="form-control">
							      		 <option value="-1" selected>请选择</option>
							      		 <option value="1" <c:if test="${appTop.itype eq 1}">selected</c:if>>文章</option>
							      	     <option value="2" <c:if test="${appTop.itype eq 2}">selected</c:if>>竞猜</option>
							      	     <option value="3" <c:if test="${appTop.itype eq 3}">selected</c:if>>广告</option>
							      	     <%-- <option value="3" <c:if test="${appTop.status eq 3}">selected</c:if>>删除</option> --%>
							      	</select>
							   	  </div>  
							  <div class="input-group">
							      <div class="input-group-addon">状态:</div>
							      	<select name="status" class="form-control">
							      		 <option value="-1" selected>请选择</option>
							      		 <option value="0" <c:if test="${appTop.status eq 0}">selected</c:if>>正常</option>
							      	     <option value="1" <c:if test="${appTop.status eq 1}">selected</c:if>>禁用</option>
							      	     <%-- <option value="3" <c:if test="${appTop.status eq 3}">selected</c:if>>删除</option> --%>
							      	</select>
							   	  </div>
							   
							  <div class="form-group">
							    <div class="input-group">
							      <div class="input-group-addon">开始日期:</div>
							      <input class="form-control" name="starttime" type="text" placeholder="输入开始日期" onClick="WdatePicker()" value="${param.starttime}"> 
							     <%--  <fmt:formatDate var="starttime_format" value="${starttime}" type="date" pattern="yyyy-MM-dd HH:mm:ss"/>
							      <input class="form-control" name="starttime" type="text" placeholder="输入开始日期" onClick="WdatePicker({dateFmt:'yyyy-MM-dd HH:mm:ss'})" value="${starttime_format }"> --%>
							    </div>
							  </div>
							 <div class="form-group">
							    <div class="input-group">
							      <div class="input-group-addon">结束日期:</div>
							      <input class="form-control" name="endtime" type="text" placeholder="输入结束时间" onClick="WdatePicker()"  value="${param.endtime}"> 
							      <%--  <fmt:formatDate var="endtime_format" value="${endtime}" type="date" pattern="yyyy-MM-dd HH:mm:ss"/>
							      <input class="form-control" name="endtime" type="text" placeholder="输入结束时间" onClick="WdatePicker({dateFmt:'yyyy-MM-dd HH:mm:ss'})"  value="${endtime_format}"> --%>
							    </div>
							  </div>
							  <button type="submit" class="btn btn-primary">搜索 </button>&nbsp;&nbsp;
							<h6 align="left" style="color: red;">刷新按钮：点击刷新按钮时，符合状态为正常，发布日期小于当前时间的置顶图为当前国家的新的置顶图</h6>
						</form>
				</div>
				<!-- /.panel-heading -->
				<form id="sortupdate" action="${ctx }/apptop/updatesort" method="post">
				<input type="hidden" name="countryCode" value="${appTop.countrycode }">
				<input type="hidden" name="status" value="${appTop.status}">
				<input type="hidden" name="itype" value="${appTop.itype}">
				<input type="hidden" name="starttime" value="${starttime}">
				<input type="hidden" name="endtime" value="${endtime}">
				
				
				<div class="panel-body">
					<div class="table-responsive">
						<table class="table table-striped table-bordered table-hover"
							id="dataTables-example">
							<thead>
								<tr>
									<th>ID</th>
									<!-- <th>记录</th> -->
									<th>国家</th>
									<th>语言</th>
									<th>标题</th>
									<th>类型</th>
									<th>文章类型</th>
									<!-- <th>图片地址</th> -->
									<!-- <th>跳转链接</th> -->
									<th>图片</th>
									<th>创建时间</th>
									<th>发布时间</th>
									<th>更新时间</th>
									<th>状态</th>
									<th>排序</th>
									<th></th>
								</tr>
							</thead>
							<tbody>
								<c:forEach var="bean" items="${list}">
									<tr class="id" >
										<td>
										<%-- <input type="hidden" name="ids" value="${bean.id }-${bean.sort }"/> --%>
										${bean.id }</td>
										<%-- <td>${bean.hisid }</td> --%>
										<td>
										  <c:choose>
										     <c:when test="${bean.countrycode eq '00'}">
										        所有国家
										     </c:when>
										     <c:otherwise>
											<c:forEach var="country" items="${countrysSort }">
								      			<c:set var="beanCountryCode" value="${bean.countrycode }"/>
												<c:set var="beanCountry" value="${fn:toUpperCase(beanCountryCode)}" />
												<c:if test="${beanCountry==country.code }">${country.cnname }</c:if>
								      		</c:forEach>
										       
										     </c:otherwise>
										  </c:choose>
										
										</td>
										<td>
											<c:forEach var="language" items="${languages }">
								      			<c:if test="${bean.langid ==language.id }">${language.cnname }</c:if>
								      		</c:forEach>
										</td>
										<td>${bean.title}</td>
										<%-- <td>${bean.itype}</td> --%>
										<td>
											<c:if test="${bean.itype ==1 }">文章</c:if>
								      		<c:if test="${bean.itype ==2 }">竞猜</c:if>
								      		<c:if test="${bean.itype ==3 }">广告</c:if>
										</td>
										<%-- <td>${bean.artitype}</td> private int artitype;  //1=图文文章 0=文字文章 2=视频文章 3=链接文章 4=H5游戏文章 5=竞猜文章 6=游戏文章 7=其它 --%>
										<td>
											<c:if test="${bean.attr ==0 }">文字文章</c:if>
								      		<c:if test="${bean.attr ==1 }">图文文章</c:if>
								      		<c:if test="${bean.attr ==2 }">视频文章</c:if>
								      		<c:if test="${bean.attr ==3 }">链接文章</c:if>
								      		<c:if test="${bean.attr ==4 }">H5游戏文章</c:if>
								      		<c:if test="${bean.attr ==5 }">竞猜文章</c:if>
								      		<c:if test="${bean.attr ==6 }">游戏文章</c:if>
								      		<c:if test="${bean.attr ==7 }">其它</c:if>
										</td>
										<%-- <td>${bean.titlepic}</td>
										<td>${bean.url}</td> --%>
										<%-- <td>${bean.createtime}</td> --%>
										<td><img src="${upyunhttp }${bean.titlepic}!30" height="30" /></td>
										<td>
											<script language="javascript" >
												var str='${bean.createtime}';
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
										<td>
											<script language="javascript" >
												var str='${bean.subtime}';
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
										<td>
											<script language="javascript" >
												var str='${bean.updatetime}';
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
										<%-- 	<jsp:useBean id="now" class="java.util.Date" scope="page"/>
											<fmt:formatDate value="${now}" pattern="yyyy-MM-dd HH:mm:ss" /> --%>
										</td>
										<td>
								      		<c:if test="${bean.status ==0 }">正常</c:if>
								      		<c:if test="${bean.status ==1 }">禁用</c:if>
								      		<%-- <c:if test="${bean.status ==3 }">删除</c:if> --%>
										</td>
										<%-- <td>${bean.sort}</td> --%>
										<td><input type="text" name="beansort" value="${bean.sort }" ids="${bean.id }"  size="5"></td>
										<td>
											<div class="btn-group">
												<a class="btn btn-primary" href="#"><i
													class="icon-wrench icon-white"></i>操作</a> <a
													class="btn btn-primary dropdown-toggle"
													data-toggle="dropdown" href="#"><span class="caret"></span></a>
												<ul class="dropdown-menu">
												
													<li><a href="${ctx }/apptop/add?id=${bean.id}"><i
															class="fa fa-pencil fa-fw"></i>修改</a></li>
													 <li><a
														href=""
														onclick="deleteapp(this)" beanid="${bean.id }"><i
															class="fa fa-trash-o fa-fw" ></i>删除</a></li> 
													<li>
													<li>
													<input type="hidden" id="beanids" name="beanids" value=""/>
													<a 
													href="";
												onclick="refreshs(this)" beanid="${bean.id }"><i
															class="fa fa-trash-o fa-fw" ></i>刷新</a></li>
													<li>
												</ul>
											</div>

										</td>

									</tr>
									
								</c:forEach>
							</tbody>
						</table>
						
						<c:if test="${not empty list}">
							<div style = "text-align:right;">
								<input type="button" class="btn btn-primary" value="更新排序" onclick="updateSort()"></input>
							</div>
						</c:if>
							
							</div>
						</div>
					</form>
						
						<div class="col-sm-12 text-center">
					        <ul class="pagination" id="pagination">
						        
					        </ul>
					        <ul id="countabs">
					        
					        </ul>
					        <!-- 总条数 -->
					        <input type="hidden" id="PageCount" runat="server" value="${pageUtil.recordCount}"/>
					        <!-- 总页数 -->
					        <input type="hidden" id="countindex" runat="server" value="${pageUtil.pagecount}"/>
					        <!-- 当前第几页 -->
					        <input type="hidden" id="Pagedq" runat="server" value="${pageUtil.currentPage}"/>
					        <!-- 请求的地址 -->
					        <input type="hidden" id="pageUrl" runat="server" value="${ctx }/apptop/list"/>
					        <!-- 请求的参数 -->
					        <input type="hidden" id="pageParameter" runat="server" value="${searchstr}"/>
					        <!--设置最多显示的页码数 可以手动设置 默认为7-->
					        <input type="hidden" id="visiblePages" runat="server" value="10" />
					</div>
					    <script src="${ctx }/js/page/myPage.js" type="text/javascript"></script>
					</div>
				</div>
			</div>
		</div>
	
</body>
</html>
