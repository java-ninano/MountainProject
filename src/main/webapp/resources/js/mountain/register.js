$(function(){
	$('#mname').focusout(function(){
		var mname = $('#mname').val();
		var reg = /^[가-힣]+산$/;
		
		if (!mname.match(reg)){
			swal({
				title: "Not available",
				text: "산 이름을 정확히 작성해주세요.",
				icon: "warning",
				button: "close"
			});
		}
	});

	if(result == 'failed'){
		swal({
			title: "Not available",
			text: "이미 존재하는 산 이름입니다.",
			icon: "warning",
			button: "close"
		});
	}

});