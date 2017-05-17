<%@page language="java" contentType="text/html; charset=UTF-8"%>
<%@ include file="/common/taglibs.jsp"%>
<!DOCTYPE html>
<html lang="en">
<head>
</head>
<body>
		<div >
		<span>结果:</span>
			<span>${status }</span>
		</div>
		<div >
		<span>作者:</span>
			<span>${author }</span>
		</div>
		<div >
		<span>多媒体:</span>
			<span>${video }</span>
		</div>
		<div >
		<span>关键词:</span>
			<span>${keyword }</span>
		</div>
		<div ><span>内容1:</span>
			<textarea  rows="10" cols="70" readonly="readonly">${content }</textarea>
		</div>
		<div ><span>内容2:</span>
			<textarea  rows="10" cols="70" readonly="readonly">${content1 }</textarea>
		</div>
		<div ><span>内容3:</span>
			<textarea  rows="10" cols="70" readonly="readonly">${content2 }</textarea>
		</div>
		<div ><span>评论:</span>
			<textarea  rows="10" cols="70" readonly="readonly">${comment }</textarea>
		</div>
</body>
</html>
