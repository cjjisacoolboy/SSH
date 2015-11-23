$(function(){
	$('#focus .hs').each(function(){
		$(this).focus(function(){
			$(this).siblings('span').hide(); 
		}).blur(function(){
			var val=$(this).val();
			if (val != "") {
				$(this).siblings('span').hide();
			} else{
				$(this).siblings('span').show();
			}
		})
	});
});
