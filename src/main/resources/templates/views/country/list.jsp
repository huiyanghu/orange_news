<%@page language="java" contentType="text/html; charset=UTF-8"%>
<%@ include file="/common/taglibs.jsp"%>
<!DOCTYPE html>
<html lang="en">
<head>
<link rel="stylesheet" href="${ctx }/css/jquery.fileupload.css">
</head>
<body>
	<div class="row">
		<div class="col-sm-12">
			<h1 class="page-header">国家管理</h1>
		</div>
	</div>
	<div class="row">
		<div class="col-sm-12">
			<div class="panel panel-default">
				<div class="panel-heading text-right">
					<div class="row">
						<form class="form-inline" action="${ctx }/country/importexcel" method="post" 
							enctype="multipart/form-data">
							<div class="form-group">
							    <div class="input-group">
							      <div class="input-group-addon">国际化语言:</div>
							      <select name="langid" class="form-control">
							      		<option value="-1">请选择</option>
							      	<c:forEach var="language" items="${languagesSort }">
							      		<option value="${language.id}">${language.hbcode}  ${language.cnname}</option>
							      	</c:forEach>	
							      	<%-- <c:if test="${list }"></c:if> --%>
							      </select>
							    </div>
							  </div>
							  <div class="form-group"> 
							  		<span class="btn btn-success fileinput-button">
										<span>上传文件</span>
										<input id="fileupload" type="file" name="file" multiple>
									</span>
							  </div>
									<input type="submit" value="导入Excel"/>
									
									
						<a href="${ctx }/country/exportcountry" class="btn btn-primary" id="add11ssss"><span
							class="fa fa-plus-circle fa-fw"></span> 导出国家</a>
						<a href="${ctx }/country/edit?cid=0" class="btn btn-primary" id="add"><span
							class="fa fa-plus-circle fa-fw"></span> 添加国家</a>
						</form>
							  
							  
					</div>
				</div>
				<!-- /.panel-heading -->
				<div class="panel-body">
					<div class="table-responsive">
						<table class="table table-striped table-bordered table-hover"
							id="dataTables-example">
							<thead>
								<tr>
									<th>国家ID</th>
									<th>国家标识</th>
									<th>国家名称</th>
									<th>国家代码</th>
									<th>国家简称</th>
									<!-- <th>国家英文名称</th> -->
									<th>国家所属区域</th>
									<th>话题</th>
									<th></th>

								</tr>
							</thead>
							<tbody>
								<c:forEach var="item" items="${list}">
									<tr class="cid" value="${item.cid }">
										<td>${item.cid }</td>
										<td><img src="${upyunhttp }${item.countryicon }!30" height="30"></td>
										<td>${item.cnname }</td>
										<td>${item.code }</td>
										<td>${item.shortname }</td>
										
									<%-- 	<td>${item.enname }</td> --%>
										<td>${item.continent }</td>
										<td>${item.topics }</td>
										<td>
											<div class="btn-group">
												<a class="btn btn-primary" href="#"><i
													class="icon-wrench icon-white"></i>操作</a> <a
													class="btn btn-primary dropdown-toggle"
													data-toggle="dropdown" href="#"><span class="caret"></span></a>
												<ul class="dropdown-menu">
													<li><a
														href="${ctx }/country/edit?cid=${item.cid}"><i
															class="fa fa-pencil fa-fw"></i>修改</a></li>
													<li><a
														href="${ctx }/country/addopencountry?cid=${item.cid}"><i
															class="fa fa-pencil fa-fw"></i>国家管理</a></li>
													<li><a
														href="${ctx }/country/topics?countryid=${item.cid}"><i
															class="fa fa-pencil fa-fw"></i>话题管理</a></li>
															
													<li><a
														href="${ctx }/screen/list?countryid=${item.cid}"><i
															class="fa fa-pencil fa-fw"></i>锁屏管理</a></li>
															
													<li><a
														href="${ctx }/keywords/list?countryid=${item.cid}"><i
															class="fa fa-pencil fa-fw"></i>热搜、敏感词管理</a></li>
													<li><a
														href="${ctx }/country/addlanguage?cid=${item.cid}"><i
															class="fa fa-pencil fa-fw"></i>语言管理</a></li>
													<li><a
														href="${ctx }/globalization/list?objid=${item.cid}&objtype=1"><i
															class="fa fa-pencil fa-fw"></i>国际化管理</a></li>		
													
												</ul>
											</div>

										</td>

									</tr>
								</c:forEach>
							</tbody>
						</table>
					</div>
				</div>
			</div>
		</div>
	</div>
	
</body>
</html>
