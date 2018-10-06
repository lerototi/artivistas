function setData(){
	
	ano = $("#data .ui-datepicker-year").val();
	mes = $("#data .ui-datepicker-month").val();
	$('#data_input').val(('0' (++mes)).slice(-2)+'/'+ano);	
}

$("#data .ui-datepickr-month").change(function(){
	setDate();
});

$("#data .ui-datepicker-year").change(function(){
	setData();
});
