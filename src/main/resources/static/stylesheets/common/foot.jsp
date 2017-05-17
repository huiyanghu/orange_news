<%@page language="java" contentType="text/html; charset=UTF-8"%>
<script src="${ctx }/js/bootstrap.min.js"></script>
<script src="${ctx }/js/jquery.validate.min.js"></script>
<script src="${ctx }/js/messages_zh.js"></script>
<script src="${ctx }/js/plugins/metisMenu/metisMenu.min.js"></script>
<script src="${ctx }/js/plugins/morris/raphael.min.js"></script>
<script src="${ctx }/js/jquery.cookie.js"></script>
<script src="${ctx }/js/sb-admin-2.js"></script>
<script type="text/javascript">
//Loads the correct sidebar on window load,
//collapses the sidebar on window resize.
// Sets the min-height of #page-wrapper to window size
$(function() {
	$(window).bind(
		"load resize",
		function() {
			topOffset = 50;
			width = (this.window.innerWidth > 0) ? this.window.innerWidth
					: this.screen.width;
			if (width < 768) {
				$('div.navbar-collapse').addClass('collapse')
				topOffset = 100; // 2-row-menu
			} else {
				$('div.navbar-collapse')
						.removeClass('collapse')
			}
			height = (this.window.innerHeight > 0) ? this.window.innerHeight
					: this.screen.height;
			height = height - topOffset;
			if (height < 1)
				height = 1;
			if (height > topOffset) {
				$("#page-wrapper").css("min-height",
						(height - 2) + "px");
			}
		})
});
</script>