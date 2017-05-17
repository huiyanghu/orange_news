$(function () {
	$('select[name="projectid"]').each(function(){
	    $(this).change();
	});
});

function loadKemu(obj)
{
	var pid = $(obj).val();
	if(pid>0){
		$.ajax({
	        type: "get",
	        data:{"pid":pid},
	        async:false,
	        url: '/budget/kumu.json',
	        dataType: "jsonp",
	        jsonp: "jsoncallback",
	        jsonpCallback:"kemu",
	        success: function(jsonData){
		        // 如果返回的数据不为空，则处理下面的操作
	        	if(jsonData.length>0){
	        		// 生成下拉框
	    			var selectobj=null;
	    			/*console.log($("kemuids").size());
	    			if($("select[name='kemuids']").size()>0){
	    				selectobj = $("select[name='kemuids']");
	    			}else{
	    				selectobj = $("select[name='kemuid']");
	    			}*/
	    			selectobj=$(obj).parent().parent().children("td").eq(4).find("select");
	    			console.log(selectobj);
	    			selectobj.empty();
	    			selectobj.append('<option value="">请选择预算科目</option>');
	        		$.each(jsonData,function(k,v){
	        			if(v.createuid==0){
		        			selectobj.append('<option value="'+v.id+'" disabled>'+v.costname+'</option>');
	        			}else{
		        			selectobj.append('<option value="'+v.id+'" >'+v.costname+'</option>');
	        			}
	        			
	        		});
	        	}
	        },
	        error:function(){
	           
	        }
		});
	}
}

function additem()
{
	if($("#dailyclaimslist tr").length<8){
		var itemhtml = $("#dailyclaimslist tr:last").html();
		$("#dailyclaimslist tr:last").after("<tr>"+itemhtml+"</tr>");
		$("#dailyclaimslist tr:last input[name='bxitems'] ").attr("value",0);
		$("#dailyclaimslist tr:last input[name='prices'] ").attr("value",0);
		$("#dailyclaimslist tr:last input[name='itemdescs'] ").attr("value",'');
	}
}

function delitem(delobj){
	if($("#dailyclaimslist tr").length>1){
		$(delobj).parent().parent().remove();
	}
}

function changejine(itemprice)
{
	var countprice = 0;
	$("#dailyclaimslist input[name='prices']").each(function(){
		countprice += parseFloat($(this).val());
	});
	countprice = Number(countprice).toFixed(2);
	if(countprice=='NaN'){
		countprice = 0;
	}
	$("#bxprice").attr("value",countprice);
}

function formatCurrency(num) {
	var sign = "";
	if (isNaN(num)) {
		num = 0;
	}
	if (num < 0) {
		sign = "-";
	}
	var strNum = num + "";
	var arr1 = strNum.split(".");
	var hasPoint = false;// 是否有小数部分
	var piontPart = "";// 小数部分
	var intPart = strNum;// 整数部分
	if (arr1.length >= 2) {
		hasPoint = true;
		piontPart = arr1[1];
		intPart = arr1[0];
	}

	var res = '';// 保存添加逗号的部分
	var intPartlength = intPart.length;// 整数部分长度
	var maxcount = Math.ceil(intPartlength / 3);// 整数部分需要添加几个逗号
	for ( var i = 1; i <= maxcount; i++)// 每三位添加一个逗号
	{
		var startIndex = intPartlength - i * 3;// 开始位置
		if (startIndex < 0)// 开始位置小于0时修正为0
		{
			startIndex = 0;
		}
		var endIndex = intPartlength - i * 3 + 3;// 结束位置
		var part = intPart.substring(startIndex, endIndex) + ",";
		res = part + res;
	}
	res = res.substr(0, res.length - 1);// 去掉最后一个逗号
	if (hasPoint) {
		return "" + sign + res + "." + piontPart;
	} else {
		return "" + sign + res;
	}
}
