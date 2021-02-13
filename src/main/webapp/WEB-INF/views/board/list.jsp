<%@ page language="java" contentType="text/html; charset=UTF-8"
  pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
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
	
<title>Insert title here</title>
</head>
<body>
<div class="container-sm">

 <div class="row">
 
 <table class="table table-striped table-hover table-dark">
  <thead>
    <tr>
      <th>#</th>
      <th>Name</th>
      <th>location</th>
      <th>height</th>
      <th>status</th>
    </tr>
  </thead>
 <tbody>
 <c:forEach items="${list}" var="mountain">
 <tr>
 

 <td><c:out value="${mountain.no }" /></td>
 <td><c:out value="${mountain.MName }"  /></td>
 <td><c:out value="${mountain.MLoc }"/></td>
 <td><c:out value="${mountain.height }"/></td>
 <td><c:out value="${mountain.status }" /></td>

 
 
 </c:forEach>
 </tbody>
</table>
</div>
</div>
</body>
</html>