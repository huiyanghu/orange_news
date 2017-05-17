<%@page language="java" contentType="text/html; charset=UTF-8"%>
<%@ include file="/common/taglibs.jsp"%>
<!DOCTYPE html>
<html lang="en">
<head>
<style type="text/css">
span{
	display: list-item;
    font-weight: 400;
    font-size: 16px;
    color: #428bca;
}

</style>
</head>
<body>
		<div >
		<h3>文章内容抓取结果:</h3>
		</div>
		<div >
		<div ><span>content:</span>
			<textarea  rows="10" style="width: 100%;" readonly="readonly">${vo.content.content }</textarea>
		</div>
		<div ><span>媒体名称:</span>
			<textarea  rows="2" style="width: 100%;" readonly="readonly">${vo.article.source }</textarea>
		</div>
		<div ><span>媒体LOGO:</span>
			<textarea  rows="2" style="width: 100%;" readonly="readonly">${vo.article.plogo }</textarea>
		</div>
		<div ><span>作者:</span>
			<textarea  rows="2" style="width: 100%;" readonly="readonly">${vo.article.author }</textarea>
		</div>
		<div ><span>头像：</span>
			<textarea  rows="2" style="width: 100%;" readonly="readonly">${vo.article.authorheadimg }</textarea>
		</div>
		<div ><span>标题：</span>
			<textarea  rows="2" style="width: 100%;" readonly="readonly">${vo.article.title }</textarea>
		</div>
		<div ><span>关键字：</span>
			<textarea  rows="2" style="width: 100%;" readonly="readonly">${vo.article.keywords }</textarea>
		</div>
		<div ><span>描述：</span>
			<textarea  rows="5" style="width: 100%;" readonly="readonly">${vo.article.abstracts }</textarea>
		</div>
		<div class="col-sm-12 text-center">
		</div>
</body>
</html>
