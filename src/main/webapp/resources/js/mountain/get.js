$(function(){

	if (result == 'modSuccess') {
		swal({
			title: "Modified",
			text: "산이 수정되었습니다.",
			icon: "success",
			button: "close"
		});
	}
	
	$('#submitBtn').click(function(){
		var no = Number($('#no').val());
		var data = {
			no: no,
			mname: $('#mname').val(),
			mloc: $('#mloc').val(),
			height: Number($('#height').val()),
			status: Number($('#status').val()),
			description: $('#description').val()
		};
		
		$.ajax(root + '/modify', {
			type: 'POST',
			contentType: 'application/json',
			data: JSON.stringify(data)
		}).done(function(){		  
		  location.replace(root + '/get?no=' + no);		  
		}).fail(function(er){
			console.log(er);
		});
	});

	$('#removeBtn').click(function(){
		swal({
		  title: "Are you sure?",
		  text: "게시글을 삭제하시겠습니까?",
		  icon: "warning",
		  buttons: true,
		  dangerMode: true,
		})
		.then((isConfirm) => {
		  if (isConfirm) {
			var no = $('#no').val();
		
			$.ajax(root + '/remove?no=' + no, {
				type: 'DELETE'
			}).done(function(){
			  location.replace(root + '/list');
		  	});
		  }
	   });
	});	


	$('#cancelBtn').hide();
	$('#submitBtn').hide();

	$('#modifyBtn').click(function(){// 입산여부도 수정하자!
		$(this).hide();
		$('#removeBtn').hide();
		
		$('#cancelBtn').show();
		$('#submitBtn').show();
		
		$('#modifyForm input').removeAttr('readonly');
		$('#modifyForm textarea').removeAttr('readonly');
	});
	
	$('#cancelBtn').click(function(){
		$(this).hide();
		$('#submitBtn').hide();

		$('#modifyBtn').show();
		$('#removeBtn').show();
		
		$('#modifyForm input').attr('readonly', true);	
		$('#modifyForm textarea').attr('readonly', true);	
	});
	
});