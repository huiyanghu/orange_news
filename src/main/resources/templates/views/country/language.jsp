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
			<h1 class="page-header">【${hbcountry.cnname }】语言管理</h1>
		</div>
	</div>
	<div class="row">
		<div class="col-sm-12">
			<div class="panel panel-default">
				<div class="panel-heading">请选择语言</div>
				<div class="panel-body">
					<div class="row">
						<form id="addform" class="form-horizontal" action="${ctx }/country/languagemanage" method="post">
							<input name="cid" type="hidden" value="${hbcountry.cid }" />
							<table class="table table-striped table-bordered table-hover"
							id="dataTables-example">
							<thead>
								<tr>
									<th>HBID</th>
									<th>语言名称</th>
									<th>中文名称</th>
									<th>语言code</th>
									<th></th>
								</tr>
							</thead>
							<tbody>
							
								<c:forEach var="language" items="${languages }">
									<tr>
										<td>${language.hbid}</td>
										<td>${language.hbname}</td>
										<td>${language.cnname}</td>
										<td>${language.hbcode}</td>
										<td><input type="checkbox" name="hblanguages" value="${language.id }" <c:if test="${language.isopen==2}">checked</c:if>></td>
									</tr>
								</c:forEach>	

							</tbody>
							</table>						
							<div class="form-actions">
								<div class="col-sm-1"></div>
								<div class="col-sm-8">
									<a href="${ctx }/country/list" class="btn btn-info"><span
										class="fa fa-arrow-left fa-fw"></span> 返回</a> &nbsp;&nbsp;
									<button class="btn btn-primary" type="submit">
										<span class="fa fa-floppy-o fa-fw"></span>
										更新国家语言
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
