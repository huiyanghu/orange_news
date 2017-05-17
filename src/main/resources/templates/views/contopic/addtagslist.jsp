<%@page language="java" contentType="text/html; charset=UTF-8"%>
<%@ include file="/common/taglibs.jsp"%>
<!DOCTYPE html>
<html lang="en">
<head>
<script type="text/javascript">
    function checktags(){
    	
    	var obj=document.getElementsByName('checktags');  //选择所有name="'test'"的对象，返回数组    
    	  //取到对象数组后，我们来循环检测它是不是被选中    
    	  var str='';    
    	  for(var i=0; i<obj.length; i++){    
    	    if(obj[i].checked) str+=obj[i].value+',';  //如果选中，将value添加到变量s中    
    	  }    
        if(str.length>0){
  	    	location.href="${ctx}/contopic/batchSaveTagsTopic?tags="+str+"&topicid=${topic.tid }";
  	    }else{
  	    	alert("请选择标签");
  	    }
    } 
</script>
</head>
<body>
	<div class="row">
		<div class="col-sm-12">
			<h1 class="page-header">设置在二级分类【${topic.topicname }】下的标签</h1>
		</div>
	</div>
	<div class="row">
	
	
	<div class="panel-heading text-right">
					<div class="row text-right">
						<form class="form-inline" role="form" action="" method="get">
							<input name="page" type="hidden" value="${contagsPaginator.page }"/>
							<input name="tpid" type="hidden" value="${topic.tid}">
							<div class="form-group ">
							    <div class="input-group">
							      <div class="input-group-addon">国家:</div>
							      	<select name="countrycode" class="form-control">
							      		<option value="">请选择</option>
							      		<c:forEach var="country" items="${countrys }">
							      			<option value="${country.code }" <c:if test="${country.code eq conTags.countrycode }">selected</c:if>>${country.cnname }</option>
							      		</c:forEach>
							      	</select>
							   	  </div>
							   
							    <div class="input-group">
							      <div class="input-group-addon">标签是否分类:</div>
							      	<select name="type" class="form-control">
							      		 <option value="" <c:if test="${conTags.type eq ''}">selected</c:if>>所有标签</option>
							      	     <option value="1" <c:if test="${conTags.type eq 1}">selected</c:if>>未分类标签</option>
							      	</select>
							   	  </div>
							   </div>
							    <div class="input-group">
							      <div class="input-group-addon">类型:</div>
							      	<select name="tagtype" class="form-control">
							      		<option value="">请选择</option>
							      		<option value="0" <c:if test="${conTags.tagtype eq 0}">selected</c:if>>通用</option>
							      		<option value="1" <c:if test="${conTags.tagtype eq 1}">selected</c:if>>特殊</option>
							      	</select>
							   	  </div>
							   	  
							   	    <button type="submit" class="btn btn-primary">搜索 </button>&nbsp;&nbsp;
							   </div>
							  
							
							</form>
					</div>
				</div>
	
		<div class="col-sm-12">
			<div class="panel panel-default">
				<div class="panel-heading text-right">
				</div>
				<!-- /.panel-heading -->
				<div class="panel-body">
					<div class="table-responsive">
							<div class="col-sm-12">
								<c:forEach var="item" items="${contags}">
									<div class="col-sm-1 text-center">
										${item.tagname}</br/> <input type="checkbox" name="checktags" value="${item.id}"
											<c:forEach var="it" items="${tts }"> <c:if test="${it.tagid eq item.id }">checked="checked"</c:if></c:forEach> />
									</div>
								</c:forEach>
							</div>
						<br/><br/><br/>
						<button onclick="checktags()" class="btn btn-primary">批量添加或修改标签</button>
						<div class="row">
							<div class="col-sm-12 text-center">
									<ul class="pagination">
										<li>
											<a href="#">当前：${contagsPaginator.page}页，总共:${contagsPaginator.totalCount}条,总页数:${contagsPaginator.totalPages }页</a>
										</li>
										<c:if test="${contagsPaginator.page>1}">
											<li><a href="${ctx }/contopic/addtags?page=${contagsPaginator.prePage}${searchstr}&tpid=${topic.tid}">上一页</a></li>
										</c:if>
										
										<c:if test="${contagsPaginator.page<contagsPaginator.totalPages}">
											<li><a href="${ctx }/contopic/addtags?page=${contagsPaginator.nextPage}${searchstr}&tpid=${topic.tid}">下一页</a></li>
										</c:if>

									</ul>
							</div>
						</div>
					</div>
				</div>
			</div>
		</div>
	</div>
</body>
</html>







