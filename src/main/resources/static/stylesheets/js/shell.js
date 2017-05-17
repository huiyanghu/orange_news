$(function () {
	//init
	resize_main();
	$(window).resize(function(){
		resize_main();
	});

	//second menu
	$(".sidebar-nav").delegate("li:not('.nav-header')", "click", function(){
		$(".sidebar-nav").find(".active").removeClass("active");
		$(this).addClass("active");
	})
})

function resize_main (argument) {
	var main_hi = $(window).height() - 175;
	var main_wi = $(window).width() - 220;
	$("#main").height(main_hi);
	$("#main").width(main_wi);
}