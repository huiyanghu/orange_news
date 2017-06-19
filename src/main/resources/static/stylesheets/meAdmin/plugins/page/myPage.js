function exeData(num, type) {
    loadpage();
}
function loadpage() {
    var myPageCount = parseInt($("#PageCount").val());
    var countindex = parseInt($("#countindex").val());
    var pageUrl=$("#pageUrl").val();
    //var pageParameter=$("#pageParameter").val();
    var Pagedq=$("#Pagedq").val();
    $.jqPaginator('#pagination', {
        totalPages: parseInt($("#countindex").val()),
        visiblePages: parseInt($("#visiblePages").val()),
        currentPage: parseInt($("#Pagedq").val()),
        first: '<li class="first"><a href="javascript:void(0);" value="1">首页</a></li>',
        prev: '<li class="prev"><a href="javascript:void(0);" value="prev"><i class="arrow arrow2"></i>上一页</a></li>',
        next: '<li class="next"><a href="javascript:void(0);" value="prev">下一页<i class="arrow arrow3"></i></a></li>',
        last: '<li class="last"><a href="javascript:void(0);" value="last">末页</a></li>',
        page: '<li class="page"><a href="javascript:void(0);" value="page">{{page}}</a></li>',
        // onPageChange: function (num, type) {
        //     if (type == "change") {
        //         exeData(num, type);
        //         location.href=pageUrl;
        //     }
        // }
    });
    $("#countabs").html("<li>当前：第"+Pagedq+"页，共:"+myPageCount+"条,共:"+countindex+"页</li>");
}
$(function () {
    loadpage();
});

