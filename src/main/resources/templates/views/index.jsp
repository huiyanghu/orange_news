<%@ page contentType="text/html;charset=UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ page import="top.coolook.model.SysUser"%>
<%@ page import="top.coolook.utils.MD5"%>
<%@ page language="java"%>
<c:set var="ctx" value="${pageContext.request.contextPath}"/>
<!DOCTYPE html>
<html lang="zh-Hans">
    <head>
        <title>coolook</title>
    </head>
    <body window.onload = "check()">
    	<div class="row">
			<div class="col-sm-12">
				<h1 class="page-header">首页</h1>
			</div>
		</div>
		
		<c:if test="${flag eq true }">
		   <div class="alert alert-warning " role="alert" >
			<button type="button" class="close" data-dismiss="alert" aria-label="Close">
				<span aria-hidden="true">&times;</span>
			</button>
			<font size = "5">
  				<strong>警告!</strong> 
  				密码不要采用默认的，建议
				<a href="/user/editpassword" class="alert-link">修改密码</a>
			</font>
		</div>
		
		</c:if>
		<%-- 
		<%if(  ((SysUser)session.getAttribute("sysuser")).getPassword().equals(MD5.MD5("coolook"))   ) {%>
        <!-- <div class="row" id = "temp">
			<div class="col-sm-12">
				<h2>密码不要采用默认的，建议<a href="/user/editpassword">修改密码</a></h2>
				
			</div>
		</div> -->
		<div class="alert alert-warning " role="alert" >
			<button type="button" class="close" data-dismiss="alert" aria-label="Close">
				<span aria-hidden="true">&times;</span>
			</button>
			<h1>
  				<strong>警告!</strong> 
  				密码不要采用默认的，建议
				<a href="/user/editpassword" class="alert-link">修改密码</a>
			</h1>
		</div>
		<%} %> --%>
		
        <div class="row">
        	<div class="col-sm-12">
	        	<h2>更新日志</h2>
	        	<p>10-29 完成锁屏图片管理功能</p>
	        	<p>10-23 更新完国家、话题管理</p>
	        	<p>10-17 初始化系统日志</p>
        	</div>
        </div>
        
		<!-- <script type="text/javascript">
		$(document).ready(function(){
			$.ajax({
	            url: "${ctx}/checkpass",
	            type: 'POST',
	            dataType: 'json',
	            error: function () {
	            },
	            success: function (data) {
					if (data.status == '-1') {
						document.getElementById('temp').style.display = "none";
	                }else {
	                }
	            }
	        });
		})
		</script> -->
    </body>
</html>
