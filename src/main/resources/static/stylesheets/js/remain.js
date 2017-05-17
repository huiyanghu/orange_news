$(function(){
		
		$("#endtime").hide();
		$('#remainselt').on('change', function () {
			//$("#remaintiptext").html($("#remainselt  option:selected").text());
			//alert($("#remainselt  option:selected").val());
			var seltVal=$("#remainselt  option:selected").val();
			if(seltVal==1){
				$("#endtime").hide();
				$("#starttime").show();
			}else if(seltVal==2){
				$("#starttime").hide();
				$("#endtime").show();
			}
	    });
});