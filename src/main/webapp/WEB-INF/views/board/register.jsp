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



<title>Insert title here</title>
</head>
<body>
	<div class="container-sm">
		<div class="row">
			<div class="col-lg-12 col-12 offset-lg-1">
			
			<form method="post">
				<h1 class="page-header">Mountain Register</h1> <hr>
        
        <div class="panel panel-default">
        
        
        
        
        <div class="form-group row">
    <label for="input1" class="col-sm-2 col-form-label">Mountain Name</label>
    <div class="col-sm-10">
      <input name="mName" type="text" class="form-control" id="input1" 
      placeholder="산 이름을 입력하세요.">
    </div>
  </div>
  <div class="form-group row">
    <label for="input2" class="col-sm-2 col-form-label">Location</label>
    <div class="col-sm-10">
      <input name="mLoc"type="text" class="form-control" id="input2"
      placeholder="산 위치를 입력하세요">
    </div>
  </div>
  <div class="form-group row">
    <label for="input3" class="col-sm-2 col-form-label">Height</label>
    <div class="col-sm-10">
      <input name="height" type="number" class="form-control" id="input3"
      placeholder="산의 높이를 입력하세요">
    </div>
  </div>
  <div class="form-group row">
    <label for="input4" class="col-sm-2 col-form-label">Status</label>
    <div class="col-sm-10">
      <input name="status" type="number" class="form-control" id="input4"
      placeholder="산의 입산 여부를 입력하세요">
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
  <div class="form-group row">
    <div class="col-sm-10">
      <button type="submit" class="btn btn-primary">Register</button>
    </div>
  </div>
        
        
        
        
        
        
        </div>
            
            
  
</form>
            
			</div>
		</div>
	</div>
	
</body>
</html>