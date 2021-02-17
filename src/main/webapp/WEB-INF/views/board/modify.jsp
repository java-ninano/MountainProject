<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
<script
	src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.16.0/umd/popper.min.js"></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
<script src="https://kit.fontawesome.com/a076d05399.js"></script>

<script>
$(document).ready(function() {
	$("#remove-btn").click(function(e) {
		e.preventDefault();
		
		// #modify-form 의 action attr 값을 바꿔야함.
		$("#modify-form").attr("action", "${root}/board/remove");
		
		$("#modify-form").submit();
	});
});
</script>

<title>Insert title here</title>
</head>
<body>
	

	<div class="container-sm">
		<div class="row">
			<div class="col-12 col-lg-6 offset-lg-3">
				<h1>Board Modify Page</h1>
			</div>
		</div>
		<div class="row">
			<div class="col-12 col-lg-6 offset-lg-3">

				<form id="modify-form" method="post" action="${root }/board/modify">
					<div class="form-group">
						<label for="input1">#no</label>
						<input class="form-control" name="no" type="text" id="input3" readonly value="${board.no }" />
					</div>
					
					<div class="form-group">
						<label for="input2">#Name</label> 
						<input name="title" type="text"
							class="form-control" value='<c:out value="${board.MName }" />' 
							id="input2" placeholder="산 이름을 입력하세요.">
					</div>

					<div class="form-group">
						<label for="input3">#Location</label>
						<input name="location" type="text" 
						class="form-control" value='<c:out value="${board.MLoc }" />' 
							id="input3" placeholder="산 위치을 입력하세요.">
						
					</div>

					<div class="form-group">
						<label for="input4">#Height</label> 
						<input name="height" type="number"
							class="form-control" value='<c:out value="${board.height }" />' 
							id="input4" placeholder="높이를 입력하세요">
					</div>
					
					<div class="form-group">
						<label for="input5">#status</label>
						 <input name="status" type="number"
							class="form-control" value='<c:out value="${board.status }" />'
							 id="input5" placeholder="입산여부를 입력하세요">
					</div>
					
				

                    <input type="hidden" value="${cri.pageNum }" name="pageNum" />
                    <input type="hidden" value="${cri.amount }" name="amount" />
                    <input type="hidden" value="${cri.keyword }" name="keyword"/>
                     <input type="hidden" value="${cri.type }" name="type"/>
					<button type="submit" class="btn btn-primary">수정</button>
					<button id="remove-btn" type="submit" class="btn btn-danger">삭제</button>
				</form>
			</div>
		</div>
	</div>

</body>
</html>




