<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.16.0/umd/popper.min.js"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
<script src="https://use.fontawesome.com/releases/v5.15.2/js/all.js" data-auto-replace-svg="nest"></script>
<script src="https://unpkg.com/sweetalert/dist/sweetalert.min.js"></script>
<link rel="stylesheet" type="text/css" href="${root }/resources/css/font.css">
<title>산산산</title>
</head>
<body>
<div class="container-sm my-5"">
	<div class="row">
		<div class="col-12 col-sm-6 offset-sm-3">
			<h3 class="text-center">산 정보 등록</h3>
			<form method="post">
				<div class="form-group">
					<label for="mname">이름</label>
					<input type="text" class="form-control" name="mname" id="mname" required
						 placeholder="산 이름을 입력하세요.">
						 <script> /* pattern="^[가~힣]{1,}산$"
						 $('input').keyup(function(key) {
							 var x = $('#mname').val();
							 var reg = /[가~힣]{1,}산/
						 	console.log(x);
						 	console.log(x.match(reg));
						 });*/
						 </script> 
					<small class="text-success">공백 없이 한글을 이용하여 ~산으로 끝나게 작성해주세요.</small>
				</div>

				<div class="form-group">
					<label for="mloc">위치</label>
					<input type="text" class="form-control" name="mloc" id="mloc" required placeholder="산 위치를 입력하세요">
				</div>

				<div class="form-group">
					<label for="height">해발고도</label>
					<input type="number" class="form-control" name="height" id="height" required placeholder="산의 높이를 입력하세요.">
				</div>
	
				<div class="form-group">
				  	<label for="status0">입산여부</label>
					<div class="form-check form-check-inline">
					  <input class="form-check-input" type="radio" name="status" id="status0" value="0" checked>
					  <label class="form-check-label" for="status0">가능</label>
					</div>
					<div class="form-check form-check-inline">
					  <input class="form-check-input" type="radio" name="status" id="status1" value="1">
					  <label class="form-check-label" for="status1">불가능</label>
					</div>
				</div>
	
				<div class="form-group">
					<label for="description">상세설명</label>
				    <textarea class="form-control" name="description" id="description" rows="3" required></textarea>					
				</div>

				<button class="btn btn-success float-right">등록</button>
			</form>
		</div>
	</div>
</div>
</body>
</html>