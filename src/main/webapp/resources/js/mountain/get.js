$(function(){

	if (result == 'modSuccess') {
		swal({
			title: "Modified",
			text: "산이 수정되었습니다.",
			icon: "success",
			button: "close"
		});
	}
	
	/* 수정 */
	$('#submitBtn').click(function(){
		var status = 0;
		const st = $('[name="status"]');
		if( st[1].checked ) {
			status = 1;
		}

		var no = Number($('#no').val());
		var data = {
			no: no,
			mname: $('#mname').val(),
			mloc: $('#mloc').val(),
			height: Number($('#height').val()),
			status: status,
			description: $('#description').val()
		};
		
		$.ajax(root + '/modify?curPage=' + curPage + '&amount=' + amount + '&keyword=' + keyword, 
		{
			type: 'POST',
			contentType: 'application/json',
			data: JSON.stringify(data)
		}).done(function(){	
		  location.replace(root + '/get?no=' + no + '&curPage=' + curPage + '&amount=' + amount + '&keyword=' + keyword);		  
		}).fail(function(er){
			console.log(er);
		});
	});

	/* 삭제 */
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
		
			$.ajax(root + '/remove?no=' + no + '&curPage=' + curPage + '&amount=' + amount + '&keyword=' + keyword, 
			{
				type: 'DELETE'
			}).done(function(cri){
			  //console.log(cri);
			  //console.log(JSON.stringify(cri));
			  //console.log($.parseXML(cri));
			  //console.log($($.parseXML(cri)));
			  //console.log('curPage: ' + $($.parseXML(cri)).find('curPage'));
			  location.replace(root + '/list?curPage=' + curPage + '&amount=' + amount + '&keyword=' + keyword);
		  	});
		  }
	   });
	});	


	$('#cancelBtn').hide();
	$('#submitBtn').hide();
	$('#statusForm').hide();

	$('#modifyBtn').click(function(){// 입산여부도 수정하자!
		$(this).hide();
		$('#removeBtn').hide();
		
		$('#cancelBtn').show();
		$('#submitBtn').show();
		
		$('#modifyForm input').removeAttr('readonly');
		$('#modifyForm textarea').removeAttr('readonly');
		
		$('#statusView').hide();
		$('#statusForm').show();
	});
	
	$('#cancelBtn').click(function(){
		$(this).hide();
		$('#submitBtn').hide();

		$('#modifyBtn').show();
		$('#removeBtn').show();
		
		$('#modifyForm input').attr('readonly', true);	
		$('#modifyForm textarea').attr('readonly', true);
		
		$('#statusView').show();
		$('#statusForm').hide();
	});
	
});