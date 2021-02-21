<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="m" tagdir="/WEB-INF/tags"%>
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
<link rel="stylesheet" type="text/css" href="${root }/resources/css/mountain/get.css">
<script>
var root = '${root}';
var result = '${result}';
</script>
<script src="${root }/resources/js/mountain/get.js"></script>
<link rel="shortcut icon" href="#">
<title>산산산</title>
</head>
<body>
<div class="container-fluid my-5">
	<div class="row">
<!-- 		<div class="col-12 col-sm-6 offset-sm-3"> -->
		<div class="col-12 col-md-6 offset-md-3">
			<form id="modifyForm" method="post" class="my-2">
				<div class="form-group d-flex justify-content-center align-items-center">
					<input class="form-control text-center" name="mname" id="mname" value="${mountain.mname }" required readonly>
				</div>
				
				<m:miniNav></m:miniNav>
			
				<input type="hidden" name="no" id="no" value="${mountain.no }" >
				<img id="main_image" src="${root }/resources/img/mountain/${mountain.mname }.jpg" alt="${mountain.mname }">
				
				<div class="form-group mt-3">
					<label for="height">해발고도: </label>
					<input type="number" class="form-control" name="height" id="height" value="${mountain.height }" required readonly>
					<span>m</span>
				</div>
	
				<div>
					<label for="status0">현재 상태: </label>
				  	<c:if test="${mountain.status == 0 }">
				  		<c:set var="status" value="입산 가능"></c:set>
				  		<span>입산 가능</span>
				  	</c:if>
				  	<c:if test="${mountain.status == 1 }">
				  		<c:set var="status" value="입산 불가"></c:set>
						<span>입산 불가</span>
				  	</c:if>
				  	<input type="hidden" name="status" id="status" value="${mountain.status }" required readonly>
				</div>
		
				<div class="form-group mt-3">
					<label for="description">상세설명</label>
				    <textarea class="form-control" name="description" id="description" rows="3" required readonly>
				    	${mountain.description }
				    </textarea>					
				</div>
				
				<div class="form-group mt-4 d-flex align-items-center">
					<img alt="map_icon" src="${root }/resources/img/mountain/location.png"> <br>
					<input type="text" class="form-control" name="mloc" id="mloc" value="${mountain.mloc }" required readonly>
				</div>
			</form>
			<hr>
			<a href="${root }/list" class="btn btn-success">목록</a>
			<button id="removeBtn" class="btn btn-danger float-right ml-1">삭제</button>
			<button id="modifyBtn" class="btn btn-primary float-right">수정</button>
			<button id="submitBtn" class="btn btn-success float-right ml-1">등록</button>
			<button id="cancelBtn" class="btn btn-secondary float-right">취소</button>
		</div>
		
		<hr>
		
		<%-- 맛집, 축제, 명소 등 --%>
		
		
	</div>
</div>
<%-- 수정 성공 결과 삭제 --%>
<c:remove var="result"/>
</body>
</html>