<%@page language="java" contentType="text/html; charset=UTF-8"%>
<%@ include file="/common/taglibs.jsp"%>
<!DOCTYPE html>
<html lang="en">
<head>
</head>
<body>

			<form action="${ctx}/country/updateopencountry" method="post">
	<div class="row">
		<div class="col-sm-12">
			<h1 class="page-header">设置【${hbcountry.cnname }】开放的国家</h1>
		</div>
	</div>
	<div class="row">
		<div class="col-sm-12">
			<div class="panel panel-default">
				<input type="hidden" name="cid" id="cid" value="${cid}" />
				<div class="panel-heading">亚洲:</div>
				<div class="panel-body">
					<div class="col-sm-12">
						<c:forEach var="country" items="${AsiaCountryList}">
							<div class="col-sm-2 text-center">
								<img src="${upyunhttp }${country.countryicon}" height="30" /></br/>
								${country.cnname}</br/> <input type="checkbox" name="countryid"
									value="${country.cid}"
									<c:if test="${country.isopen==1}">checked="checked"</c:if> />
							</div>
						</c:forEach>
					</div>
				</div>

				<div class="panel-heading">欧洲:</div>
				<div class="panel-body">
					<div class="col-sm-12">
						<c:forEach var="country" items="${EuropeCountryList}">
							<div class="col-sm-2 text-center">
								<img src="${upyunhttp }${country.countryicon}" height="30" /></br/>
								${country.cnname}</br/> <input type="checkbox" name="countryid"
									value="${country.cid}"
									<c:if test="${country.isopen==1}">checked="checked"</c:if> />
							</div>
						</c:forEach>
					</div>
				</div>

				<div class="panel-heading">非洲:</div>
				<div class="panel-body">
					<div class="col-sm-12">
						<c:forEach var="country" items="${AfricaCountryList}">
							<div class="col-sm-2 text-center">
								<img src="${upyunhttp }${country.countryicon}" height="30" /></br/>
								${country.cnname}</br/> <input type="checkbox" name="countryid"
									value="${country.cid}"
									<c:if test="${country.isopen==1}">checked="checked"</c:if> />
							</div>
						</c:forEach>
					</div>
				</div>

				<div class="panel-heading">北美洲:</div>
				<div class="panel-body">
					<div class="col-sm-12">
						<c:forEach var="country" items="${NorthAmericaCountryList}">
							<div class="col-sm-2 text-center">
								<img src="${upyunhttp }${country.countryicon}" height="30" /></br/>
								${country.cnname}</br/> <input type="checkbox" name="countryid"
									value="${country.cid}"
									<c:if test="${country.isopen==1}">checked="checked"</c:if> />
							</div>
						</c:forEach>
					</div>
				</div>

				<div class="panel-heading">南美洲:</div>
				<div class="panel-body">
					<div class="col-sm-12">
						<c:forEach var="country" items="${SouthAmericaCountryList}">
							<div class="col-sm-2 text-center">
								<img src="${upyunhttp }${country.countryicon}" height="30" /></br/>
								${country.cnname}</br/> <input type="checkbox" name="countryid"
									value="${country.cid}"
									<c:if test="${country.isopen==1}">checked="checked"</c:if> />
							</div>
						</c:forEach>
					</div>
				</div>

				<div class="panel-heading">大洋洲:</div>
				<div class="panel-body">
					<div class="col-sm-12">
						<c:forEach var="country" items="${OceaniaCountryList}">
							<div class="col-sm-2 text-center">
								<img src="${upyunhttp }${country.countryicon}" height="30" /></br/>
								${country.cnname}</br/> <input type="checkbox" name="countryid"
									value="${country.cid}"
									<c:if test="${country.isopen==1}">checked="checked"</c:if> />
							</div>
						</c:forEach>
					</div>
				</div>
				<%-- <div class="panel-heading">南极洲:</div>
				<div class="panel-body">
					<div class="col-sm-12">
						<c:forEach var="country" items="${AntarcticaCountryList}">
							<div class="col-sm-2 text-center ">
								<img src="${upyunhttp }${country.countryicon}" height="30"/></br/>
								${country.cnname}</br/>
								<input type="checkbox" name="countryid" value="${country.cid}" <c:if test="${country.isopen==1}">checked="checked"</c:if>  /> 
							</div>
						</c:forEach>
					</div>
				</div> --%>

				<div class="panel-body">
					<div class="form-actions">
						<div class="col-sm-12 text-center">
							<a href="${ctx }/country/list" class="btn btn-info"><span
								class="fa fa-arrow-left fa-fw"></span> 返回</a> &nbsp;&nbsp;
							<button class="btn btn-primary" type="submit">
								<span class="fa fa-floppy-o fa-fw"></span> 更新
							</button>
						</div>
					</div>

				</div>
			</div>
		</div>
	</div>
	</from>

</body>

</html>
