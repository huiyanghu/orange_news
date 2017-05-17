<%@page language="java" contentType="text/html; charset=UTF-8"%>
<%@ include file="/common/taglibs.jsp"%>
<!DOCTYPE html>
<html lang="en">
<head>
</head>
<body>

		<div >
		<span>抓取文章列表结果:</span>
		</div>
		<div >
			<textarea  rows="10" cols="100" readonly="readonly" style="width: 100%;height:450px;">
			<c:forEach var="list" items="${artlist}">
			第${list.xh}条   ${list.lacturl}
			</c:forEach>
			</textarea>
		</div>
		<div class="col-sm-12 text-center">
		</div>
		
</body>
</html>
