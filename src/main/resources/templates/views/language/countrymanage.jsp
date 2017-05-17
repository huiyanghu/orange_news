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
			<h1 class="page-header">【${hblanguage.hbname }】国家管理</h1>
		</div>
	</div>
	<div class="row">
		<div class="col-sm-12">
			<div class="panel panel-default">
				<div class="panel-heading">请选择国家</div>
				<div class="panel-body">
					<div class="row">
						<form id="addform" class="form-horizontal" action="${ctx }/language/languagemanage" method="post">
							<input name="id" type="hidden" value="${hblanguage.id }" />
							<table class="table table-striped table-bordered table-hover"
							id="dataTables-example">
							<thead>
								<tr>
									<th>国家图标</th>
									<th>国家ID</th>
									<th>国家名称</th>
									<th>国家code</th>
									<th></th>
								</tr>
							</thead>
							<tbody>
							<c:forEach var="n" items="${num}">
							
							</c:forEach>
								<c:forEach var="country" items="${hbcountrylist }">
									<tr>
										<td><img src="${upyunhttp }${country.countryicon }!30" height="30"></td>
										<td>${country.cid}</td>					
										<td>${country.cnname}</td>
										<td>${country.code}</td>
										<td><input type="checkbox" name="hbcountrys" value="${country.cid }" <c:if test="${country.isopen==2}">checked</c:if>></td>
									</tr>
								</c:forEach>	

							</tbody>
							</table>						
							<div class="form-actions">
								<div class="col-sm-1"></div>
								<div class="col-sm-8">
									<a href="${ctx }/language/list" class="btn btn-info"><span
										class="fa fa-arrow-left fa-fw"></span> 返回</a> &nbsp;&nbsp;
									<button class="btn btn-primary" type="submit">
										<span class="fa fa-floppy-o fa-fw"></span>
										更新语言国家
									</button>
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
