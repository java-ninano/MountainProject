$(function(){
	
	showModal(result);
	
	$('#removeBtn').hide();
	$('#modifyBtn').hide();

	$('#newReplyBtn').hide();
	$('#reply').attr('placeholder', '댓글을 쓰려면 로그인을 해주세요');
	$('#reply').attr('readonly', true);
	
	
	if(canReply) {
		if(logined) {
			$('#newReplyBtn').show();
			$('#reply').removeAttr('placeholder');
			$('#reply').removeAttr('readonly');
		}
		$('#replyList').show();
	} else {
		$('#reply').attr('placeholder', '해당 게시물에 댓글을 달 수 없습니다.');
		$('#replyList').hide();
	}
	
	if(logined && isManager) {/* 관리자 */
		$('#removeBtn').show();
		$('#modifyBtn').show();
	}
	
	function showModal(result){
		if(result == 'modSuccess') {
			swal({
			  title: "Modified",
			  text: "공지가 수정되었습니다.",
			  icon: "success",
			  button: "close",
			});
		}
	};
	
	$('#removeBtn').click(function(e){
		e.preventDefault();
		
		var category = $('#category').val();
		var keyword = $('#keyword').val();
		var curPage = $('#curPage').val();
		var amount = $('#amount').val();
		
		
		swal({
		  title: "Are you sure?",
		  text: "게시글을 삭제하시겠습니까?",
		  icon: "warning",
		  buttons: true,
		  dangerMode: true,
		})
		.then((isConfirm) => {
		  if (isConfirm) {
		    //$('#removeForm').submit();
		    
		    $.ajax(root + '/notice/remove/' + no, {// 페이지 이동하지 않고 처리한 다음
		    	method: 'delete'
		    }).done(function(data, status, xhr){
		    	//console.log(data);// = xhr.responseText
				location.replace(root + '/notice/list?'
				+ 'category=' + category + '&keyword=' + keyword
				+ '&curPage=' + curPage + '&amount=' + amount
				);
		    }).fail(function(e){
		    	console.log(e);
		    });

		  }
		});
		
	});
	
/*	$('#modifyBtn').click(function(){
		location.replace(root + '/notice/modify?no='+ no);
	});
*/	

	$('h3').click(function(){
		location.href = root + '/notice/list';
	});
	
});