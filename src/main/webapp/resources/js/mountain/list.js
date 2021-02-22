$(function(){
	if(result == 'regSuccess') {
		swal({
		  title: "Registered",
		  text: "산이 등록되었습니다.",
		  icon: "success",
		  button: "close"
		});
	}
	
	if(result == 'delSuccess') {
		swal({
		  	title: "Removed",
		  	text: "산이 삭제되었습니다.",
		  	icon: "success",
		  	button: "close"
		});
	}
	
	/*검색창에 포커스 맞춰져 있을 때 엔터치면 검색*/
	$('#search input').keydown(function(key) {
		if (key.keyCode == 13) {
			$('#search').submit();
		}
	});
	
	/*
	$('img').error(function(){
	}).attr('src', src + '/default.png');*/
	
})