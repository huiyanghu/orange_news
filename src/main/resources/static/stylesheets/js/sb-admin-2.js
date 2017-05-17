$(function() {
    $('#side-menu').metisMenu();
});


$.cookie("count", 0);
//读取消息通知
//setInterval("mesageloop();", 60000);
function mesageloop() {
	$.ajax({
		type : "GET",
		url : "${ctx}/message/my.json",
		dataType : "json",
		success : function(data) {
			var jsondata = eval(data);
			$("#messagelist").html(jsondata.htmlcontent);
			$("#messagecount").html(jsondata.count);
			var count = jsondata.count;
			console.log(count + "_" + $.cookie("count"));
			if (count > $.cookie("count")) {
				$("#play")[0].play();
			}
			$.cookie("count", count);
		}
	})
}
