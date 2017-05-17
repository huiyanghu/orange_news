<%@page language="java" contentType="text/html; charset=UTF-8"%>
<%@ include file="/common/taglibs.jsp"%>
<!DOCTYPE html>
<html lang="en">
<head>
</head>
<body>
<script type="text/javascript" charset="utf-8" src="${ctx }/ueditor/ueditor.config.js"></script>
<script type="text/javascript" charset="utf-8" src="${ctx }/ueditor/ueditor.all.js"></script>
<script type="text/javascript" charset="utf-8" src="${ctx }/ueditor/ueditor.parse.min.js"></script>
<link type="text/css" rel="stylesheet"  href="${ctx }/ueditor/themes/default/css/ueditor.min.css"/>

			<div class="row">
			<div class="col-sm-12">
				<h1 class="page-header">添加文章内容</h1>
			</div>
		</div>
		<div class="row">
			<div class="col-sm-12">
				<div class="panel panel-default">
					<div class="panel-heading">请填写以下选项：</div>
					<div class="panel-body">
					<div class="col">
							<form id="addUserInfoform" class="form-horizontal"
								action="${ctx }/articlescontent/saveorupdate" method="post">
								<input name="id" type="hidden" value="${articlescontent.articleid }" />
								<input name="articleid" type="hidden" value="${articlescontent.articleid }" />
								<input name="status" type="hidden" value="${articlescontent.status }" />
								<div class="form-actions">
									<div class="col-sm-1"></div>
									<div class="col-sm-8 text-center" >
										<a href="${ctx }/article/list" class="btn btn-info"><span class="fa fa-arrow-left fa-fw"></span> 返回</a>
										&nbsp;&nbsp;
										<button class="btn btn-primary" type="submit"><span class="fa fa-floppy-o fa-fw"></span> 
										添加文章内容</button>
									</div>
								</div>
							<div class="col-sm-6">
								<div class="form-group">
									<div class="controls col-sm-8">
										<textarea id="myEditor" name="content" >${articlescontent.content}</textarea>
										<script type="text/javascript">
												 var  editor1 = new baidu.editor.ui.Editor({
													    textarea:'tcontent',
													    	autoClearinitialContent : false,
													    	wordCount:false,
													    	initialFrameWidth : 800,
											                initialFrameHeight: 300,
													    	toolbars:[
													        [ 'fullscreen', 'source', '|','undo', 'redo','autotypeset','|','pasteplain','|',
													            'bold', 'italic','removeformat','blockquote','insertorderedlist', 'insertunorderedlist', 'selectall','cleardoc',
													            'rowspacingtop', 'rowspacingbottom', 'lineheight',
													            'customstyle', 'paragraph', 'fontfamily', 'fontsize', 
													            'justifyleft', 'justifycenter', 'justifyright', 'justifyjustify', 
													            'link', 'unlink', '|', 
													            'simpleupload']
													  		]
													});
													editor1.render("myEditor");
											</script>
									</div>
								</div>
							</div>
								
								<div class="form-actions">
									<div class="col-sm-1"></div>
									<div class="col-sm-8 text-center" >
										<a href="${ctx }/article/list" class="btn btn-info"><span class="fa fa-arrow-left fa-fw"></span> 返回</a>
										&nbsp;&nbsp;
										<button class="btn btn-primary" type="submit"><span class="fa fa-floppy-o fa-fw"></span> 
										添加文章内容</button>
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
