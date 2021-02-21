<%@ page language="java" contentType="text/html; charset=UTF-8"
  pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
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
<link rel="stylesheet" type="text/css" href="${root }/resources/css/mountain/list.css">
<script>
var result = '${result}';
</script>
<script src="${root }/resources/js/mountain/list.js"></script>
<title>산산산</title>
</head>
<body>
<div class="container-fluid my-5">
	<div class="row">
		<div class="col-12 col-sm-8 offset-sm-2">  
      		<h3 class="text-center">산산산들</h3>
      		<br>
      		<form id="search" class="d-flex justify-content-center align-items-center">
      			<input class="form-control mr-sm-1" type="search" name="keyword" value="${pages.cri.keyword }" placeholder="Search">
		    	<button class="btn btn-outline-success my-2"><i class="fas fa-search"></i></button>
      		</form>
	      	<table>
	      		<tbody>
	      		  <c:forEach var="mountain" items="${list}" varStatus="status">
	       			<c:if test="${status.count % 3 == 1 }"> 
						<tr>
		          	</c:if>

		        	<td>
						<div class="card">
		                 	<img src="${root }/resources/img/mountain/${mountain.mname}.jpg" class="card-img-top" alt="${mountain.mname }">
		                 	<div class="card-body">
		                 		<h4 class="card-title">${mountain.mname } (AchaSan)</h4>
		                 		<p class="card-text">${mountain.mloc }에 있는 해발고도 ${mountain.height }m의 산</p>
		                		<a href="${root}/get?no=${mountain.no}" class="btn btn-success">Go Into Detail</a>
		               		</div>
	              		</div>
		        	 
		        	</td>
			      
			        <c:if test="${status.count % 3 == 0 }">
						</tr>
			        </c:if>
			      </c:forEach>
				</tbody>
			</table>
			
<!-- 			페이지네이션 처리 -->
		</div>
	</div>
</div>
<%-- 삭제 성공 결과 삭제 --%>
<c:remove var="result"/>
</body>
</html>