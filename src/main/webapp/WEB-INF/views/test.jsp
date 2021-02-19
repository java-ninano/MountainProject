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
<script src="https://kit.fontawesome.com/a076d05399.js"></script>
<title>Insert title here</title>
</head>
<body>
<!-- 산 테이블에서 세션의 user가 정복한 no, mname값만 뽑아온 
List<UserMountainVO> 를 컨트롤러에서 모델에 담아서 
list라는 이름으로 여기로 보내면 !
(제가 서비스까지 작업해서 보내면 언니가 언니 컨트롤러에서 import해서 사용 : service.getUserList())
-->
<select class="form-control">
<c:forEach items="${list }" var="mountain">
  <option value="${mountain.no }">${mountain.mname }</option>
</c:forEach>
</select>
<%-- 이렇게 하면 현재 디비에 등록된 모든 산들이 셀렉트로 보여지게 되고 --%>

</body>
</html>