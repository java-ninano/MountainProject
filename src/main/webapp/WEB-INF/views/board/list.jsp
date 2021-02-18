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
	
<title>Insert title here</title>
</head>
<body>
<div class="container-sm">
<div class="row">
      <div class="col-12 col-sm-6 offset-sm-3">  
      <h1>Mountain List Page</h1>
      <table>
      <tbody>
      <c:forEach var="mountain" items="${list}"  varStatus="status">
       <c:if test="${status.count % 3 == 1 }"> 
             <tr>
                <td>
                 <div class="card" style="width: 18rem;">
                 <img src="${root }/resources/img/mountain/Buk.jpg" class="card-img-top" alt="...">
                 <div class="card-body">
                 <h1 class="card-title">북한산(Bukhansan)</h1>
                 <p class="card-text">Some quick example text to build on the card title and make up the bulk of the card's content.</p>
                <!-- <a href="${root}/board/get.jsp" class="btn btn-primary">Go somewhere</a> -->
               </div>
              </div>
                <td>
          </c:if>

         <c:if test="${status.count % 3 == 2 }"> 
                <td>
                  <div class="card" style="width: 18rem;">
                 <img src="${root }/resources/img/mountain/Acha.jpg" class="card-img-top" alt="...">
                 <div class="card-body">
                 <h5 class="card-title">아차산(Achasan)</h5>
                 <p class="card-text">Some quick example text to build on the card title and make up the bulk of the card's content.</p>
                <a href="${root}/board/get.jsp" class="btn btn-primary">Go somewhere</a>
               </div>
               </div>
                <td>
          </c:if>
      
          <c:if test="${status.count % 3 == 0 }"> 
                <td>
                    <div class="card" style="width: 18rem;">
                 <img src="${root }/resources/img/mountain/Do.jpg" class="card-img-top" alt="...">
                 <div class="card-body">
                 <h5 class="card-title">도봉산(Dobongsan)</h5>
                 <p class="card-text">Some quick example text to build on the card title and make up the bulk of the card's content.</p>
                <a href="${root}/board/get.jsp" class="btn btn-primary">Go somewhere</a>
               </div>
               </div>
                <td>
             <tr>
          </c:if>
         
      </c:forEach>
      </tbody>
</table>
</div>
</div>
</div>
</body>
</html>