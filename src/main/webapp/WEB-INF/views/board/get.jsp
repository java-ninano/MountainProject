<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html>
<html>
<head>
<script>
var appRoot = "${root}";
var no = ${mountain.no};
</script>
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
				<div class="col-12 col-lg-6 offset-lg-3">
        <h1> Mountain Board Read </h1>
        <div class="form-group">
   
    
    <div class="form-group ">
    <label for="input1" class="col-sm-2 col-form-label">번호</label> 
    <div class="col-sm-10">
      <input name="no" type="text" class="form-control" id="input1"
      value='<c:out value="${board.no }"/>'readonly ="readonly">
    </div>
  </div>
  
  <div class="form-group">
    <label for="input2" class="col-sm-2 col-form-label">산 이름 </label>
    <div class="col-sm-10">
    <input name="Name" type="text" class="form-control" id="input2"
    value ='<c:out value="${board.mName}"/>' >
    </div>
    </div>
    
    <div class="form-group ">
    <label for="input3" class="col-sm-2 col-form-label">산 위치</label>
    <div class="col-sm-10">
    <input name="Loc" type="text" class="form-control" id="input3" value='<c:out value="${board.mLoc }"/>'>
     </div>
      </div>
      
      <div class="form-group ">
    <label for="input4" class="col-sm-4 col-form-label">해발고도 </label>
    <div class="col-sm-10">
      <input name="height" type="number" class="form-control" id="input4"
    value='<c:out value="${board.height}"/>'>
    </div>
      </div>
      
      <div class="form-group ">
    <label for="input5" class="col-sm-4 col-form-label">입산여부</label>
    <div class="col-sm-10">
      <input name="status" type="number" class="form-control" id="input5"
     value='<c:out value="${board.status}"/>'>
    </div>
      </div>
      
  </div>

  
  <div class="form-group row">
    <div class="col-sm-2">Checkbox</div>
    <div class="col-sm-10">
      <div class="form-check">
        <input class="form-check-input" type="checkbox" id="gridCheck1">
        <label class="form-check-label" for="gridCheck1">
         Check it if you're done
        </label>
        
      </div>
    </div>
  </div>
  
  
  
       
       <button type="submit" class="btn btn-primary"
        onclick="location.href='/board/modify?no=<c:out value="${board.no }" />'">Modify</button>
      <button type="submit" class="btn btn-primary"
      onclick="location.href='/board/list'">list</button>
      
      </div>  
   </div>     
  </div>
	
</body>
</html>