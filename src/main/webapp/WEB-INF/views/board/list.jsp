<%@ page language="java" contentType="text/html; charset=UTF-8"
  pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" type="text/css" href="${root }/resources/css/font.css">
<script
  src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
<script
  src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.16.0/umd/popper.min.js"></script>
<script
  src="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
<script src="https://kit.fontawesome.com/a076d05399.js"></script>
	<!-- addFlash ==> 상황에 따른 메세지 -->
	
<title>Mountain List Page</title>
</head>
<body>
<div class="container-sm">
<div class="row">
      <div class="col-12 col-sm-6 offset-sm-3">  
      <h1>Mountain List Page</h1>
      
      <c:set var="board" value="1">
<div class="card" style="width: 18rem;">
  <img src="${root }/resources/img/mountain/Buk.jpg" class="" alt="....">
  <div class="card-body">
    <h1 class="card-title">북한산(Bukhansan)</h1>
    
    <table>
    <thead>
        <tr>
          <th>#No</th>
          <th>Name</th>
          <th>Location</th>
          <th>height</th>
          <th>status</th>
        </tr>
      </thead>
      <tbody>
    <c:forEach var="mountain" items="${list }" >
    <td><c:out value="${mountain.no }" /></td>
    <td><c:out value="${mountain.MName }"/></td>
    <td><c:out value="${mountain.MLoc }"/></td>
    <td><c:out value="${mountain.height }"/></td>
    <td><c:out value="${mountain.status }" /></td>
    </c:forEach>
    <a href="${root }/board/get.jsp" class="btn btn-primary">Go More Information</a>
  </div>
</div>
</c:set>
</tbody>
</table>

 </div>
 </div>
</div>
</body>
</html>