<%@page language="java" contentType="text/html; charset=UTF-8"%>
<%@ include file="/common/taglibs.jsp"%>
<!DOCTYPE html>
<html lang="en">
<head>
	<script type="text/javascript" src="${ctx }/js/plugins/My97DatePicker/WdatePicker.js"></script>
	<link rel="stylesheet" href="${ctx }/css/jquery.fileupload.css">
</head>
<body>
			<div class="row">
			<div class="col-sm-12">
				<h1 class="page-header">添加自媒体</h1>
			</div>
		</div>
		<div class="row">
			<div class="col-sm-12">
				<div class="panel panel-default">
					<div class="panel-heading">请填写以下选项：</div>
					<div class="panel-body">
						<div class="row">
							<form id="addUserInfoform" class="form-horizontal"
								action="${ctx }/conSelfPublications/saveorupdate" method="post">
								<input name="id" type="hidden" value="${conSelfPublications.id }" />
							<div id="divName" class="col-sm-6">
								<div class="form-group">
									<label for="input01" class="control-label col-sm-2">规则名称：</label>
									<div class="controls col-sm-8">
										<input type="text" name="name" id="name" class="form-control" value="${conSelfPublications.name }" required />
									</div>
							    </div>
							    <div class="form-group">
									<label for="input01" class="control-label col-sm-2">状态：</label>
									<div class="controls col-sm-8">
										<select id="status" name="status" class="form-control">

											<option value="0"
												<c:if test="${conSelfPublications.status=='0'}">selected</c:if>>正常</option>
											<option value="1"
												<c:if test="${conSelfPublications.status=='1'}">selected</c:if>>禁用</option>
										</select>
									</div>
								</div> 
							    <div class="form-group">
									<label for="input01" class="control-label col-sm-2">选择自媒体：</label>
									<div class="controls col-sm-8">
										<select name="pid">
											  <c:forEach items="${selfpublications }" var="item">
											     <option value="${item.id }" <c:if test="${conSelfPublications.pid eq item.id}">selected</c:if>>${item.name }</option>
											  </c:forEach>
											</select>
									</div>
							    </div>
							     <div class="form-group">
								<label for="input01" class="control-label col-sm-2">配置：</label>  <div class="controls col-sm-8"></div>
								</div>
							    <c:if test="${mtype eq 0 }">
										<div id="div">
										<div class="controls col-sm-8 controls_item">
											<select >
											  <c:forEach items="${publications }" var="item">
											     <option value="${item.id }">${item.name }</option>
											  </c:forEach>
											</select>
											
											<select >
											     <option value="10">10%</option>
											     <option value="20">20%</option>
											     <option value="30">30%</option>
											     <option value="40">40%</option>
											     <option value="50">50%</option>
											     <option value="60">60%</option>
											     <option value="70">70%</option>
											     <option value="80">80%</option>
											     <option value="90">90%</option>
											     <option value="100">100%</option>
											</select>
										     </div>
										</div>
							    </c:if>
						
								<c:if test="${mtype eq 1 }">
								   <c:forEach items="${rules }" var="it" varStatus="status">
								       <c:if test="${status.index ==0 }">
								         
												<div id="div">
												<div class="controls col-sm-8 controls_item">
													<select >
													  <c:forEach items="${publications }" var="item">
													     <option value="${item.id }"  <c:if test="${it.pid eq item.id  }">selected</c:if>>${item.name }</option>
													  </c:forEach>
													</select>
													
													<select >
													     <option value="10"  <c:if test="${it.percent eq 10  }">selected</c:if>>10%</option>
													     <option value="20" <c:if test="${it.percent eq 20  }">selected</c:if>>20%</option>
													     <option value="30" <c:if test="${it.percent eq 30  }">selected</c:if>>30%</option>
													     <option value="40" <c:if test="${it.percent eq 40  }">selected</c:if>>40%</option>
													     <option value="50" <c:if test="${it.percent eq 50  }">selected</c:if>>50%</option>
													     <option value="60" <c:if test="${it.percent eq 60  }">selected</c:if>>60%</option>
													     <option value="70" <c:if test="${it.percent eq 70  }">selected</c:if>>70%</option>
													     <option value="80" <c:if test="${it.percent eq 80  }">selected</c:if>>80%</option>
													     <option value="90" <c:if test="${it.percent eq 80  }">selected</c:if>>90%</option>
													     <option value="100 <c:if test="${it.percent eq 100  }">selected</c:if>">100%</option>
													</select>
												     </div>
												</div>
										    
								      </c:if>
								      
								       <c:if test="${status.index !=0 }">
								       
								          <div id="div">
												<div class="controls col-sm-8 controls_item">
													<select >
													  <c:forEach items="${publications }" var="item">
													     <option value="${item.id }"  <c:if test="${it.pid eq item.id  }">selected</c:if>>${item.name }</option>
													  </c:forEach>
													</select>
													
													<select >
													     <option value="10"  <c:if test="${it.percent eq 10  }">selected</c:if>>10%</option>
													     <option value="20" <c:if test="${it.percent eq 20  }">selected</c:if>>20%</option>
													     <option value="30" <c:if test="${it.percent eq 30  }">selected</c:if>>30%</option>
													     <option value="40" <c:if test="${it.percent eq 40  }">selected</c:if>>40%</option>
													     <option value="50" <c:if test="${it.percent eq 50  }">selected</c:if>>50%</option>
													     <option value="60" <c:if test="${it.percent eq 60  }">selected</c:if>>60%</option>
													     <option value="70" <c:if test="${it.percent eq 70  }">selected</c:if>>70%</option>
													     <option value="80" <c:if test="${it.percent eq 80  }">selected</c:if>>80%</option>
													     <option value="90" <c:if test="${it.percent eq 80  }">selected</c:if>>90%</option>
													     <option value="100 <c:if test="${it.percent eq 100  }">selected</c:if>">100%</option>
													</select>
													 <span class="btn btn-primary delete_btn">删除</span>
												     </div>
												    
												</div>
								       </c:if>
								   </c:forEach>
								       
								
								</c:if>
							   
								
							</div>
							
							<input type="hidden" id="jsonRule" name="jsonRule" value='${conSelfPublications.rule }'>
							<div class="form-actions">
									<div class="col-sm-12 text-center">
										<a href="${ctx }/conSelfPublications/list" class="btn btn-info"><span class="fa fa-arrow-left fa-fw"></span> 返回</a>
										&nbsp;&nbsp;
										<button onclick="getJson();" class="btn btn-primary" type="submit"><span class="fa fa-floppy-o fa-fw"></span> 
										<c:if test="${selfPublications.id>0}">修改自媒体</c:if> <c:if test="${selfPublications.id==0}">添加自媒体</c:if></button>
									</div>
								</div>
								
							</form>
							<input  class="btn btn-primary" type="button" onclick="addPublications()" value="添加一条媒体">
						</div>
					</div>
				</div>
			</div>
		</div>
		
		<script type="text/javascript" src="${ctx }/js/jquery-1.7.2.min.js"></script>
	<script type="text/javascript">
	
		 function addPublications(){
			  var div=$("#div").html()	;
			   $("#divName").append(div);
			   var n = $('#divName').find('.controls_item').length;
			   var item = $('#divName').find('.controls_item');
			   if(n>1){
			   item.eq(n-1).append('<span class="btn btn-primary delete_btn">删除</span>');
			   }
			 
		 }
		 
		 function addItem(middle,pid,percent){
	           var myItem='{"pid":'+pid+',"percent":'+percent+',"lastid":0},';
	           middle=middle+myItem;
	           return middle;
		}
		 
		 function getJson(){
			  var arr=$('#divName').find('.controls_item');
              var count = arr.length;
              var start='{"rules":[';
              var end=']}';
              var middle="";
				 for(var i=0;i<count;i++){
                var item = arr.eq(i);
				    var selectPidObj = item.find('select').eq(0);
				    var selectpercentObj = item.find('select').eq(1);
                  //alert(selectPidObj.val());
                 // alert(selectpercentObj.val());
                  middle=addItem(middle,selectPidObj.val(),selectpercentObj.val());
				 }
				if(middle.length > 1){
                 middle=middle.substring(0,middle.length-1);
				}
				
				var rel=start+middle+end;
			    $("#jsonRule").val(rel);
				return rel;
		 }
		 
		 $(function(){

				$(document).on('click','.delete_btn',function(){
					$(this).parent('.controls_item').remove();
				});
		});
			
	
    </script>
			
	
		
		
</body>
</html>
