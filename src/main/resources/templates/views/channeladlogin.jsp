<%@page language="java" contentType="text/html; charset=UTF-8"%>
<%@ include file="/common/taglibs.jsp" %>
<!DOCTYPE html>
<html lang="en">
<head>
 <%@ include file="/common/head.jsp" %>
</head>
<body  class="lock-screen">
    <div class="container" >
    	<div class="form-signin">
	        <h1 class="form-signin-heading">渠道登录</h1>
	        <div class="login-wrap">
	            <input name="channelname" id="channelname" type="text" class="form-control" placeholder="请输入用户名" autofocus>
	            <input name="changepass" id="changepass" type="password" class="form-control" placeholder="请输入您的密码">
	            <input type="button" class="btn btn-lg btn-login btn-block" onclick="login();" value="进入系统"/>
	            <p id="alertmessage">如遗忘帐号密码请与管理员联系！</p>
	        </div>
        </div>
    </div>
   <script type="text/javascript">
    var mark = 0;
    function login() {
        if (mark == 1) {
            alert("系统验证中...");
            return;
        }
        mark = 1;
        var channelname = $("#channelname").val();
        var changepass = $("#changepass").val();
        $.ajax({
            url: "${ctx}/channeladlogin",
            type: 'POST',
            data: {channelname:channelname,changepass:changepass},
            dataType: 'json',
            error: function () {
                alert("超时或者系统异常...");
                mark = 0;
            },
            success: function (data) {
				if (data.status == '0') {
					$("#alertmessage").html("<font color=red>正在登陆...</font>");
                    location.href = "${ctx}/home/index";
                }else {
                    $("#alertmessage").html("<font color=red>登陆校验失败！</font>");
                }
                mark = 0;
            }
        });
    }
    $(document).keyup(function(event){
    	  if(event.keyCode ==13){
    		  login();
    	  }
    });
</script>
</body>

</html>
