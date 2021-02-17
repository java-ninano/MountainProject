<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

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



<title>Insert title here</title>
</head>
<body>

	<div class="container-sm">
		<div class="row">
			<div class="col-12 col-sm-6 offset-sm-3">
				<h1 class="page-header">Mountain Register</h1>
				<hr>
           </div>
       </div>
       
       <div class="row">
       	 <div class="col-12 col-sm-6 offset-sm-3">
            <form method="post">
					<div class="form-group row">
						<label for="input1" >Mountain Name :</label>
						
							<input name="mName" type="text" class="form-control" id="input1" required
								placeholder="산 이름을 입력하세요.">
						</div>
					</div>
					
					<div class="form-group row">
						<label for="input2">Location :</label>
						
							<input name="mLoc" type="text" class="form-control" id="input2" required
								placeholder="산 위치를 입력하세요">
						</div>
					</div>
					
					<div class="form-group row">
						<label for="input3" >Height :</label>
						
							<input name="height" type="number" class="form-control" required
								id="input3" placeholder="산의 높이를 입력하세요.">
						</div>
				
					
					<div class="checks">
					<label for="input3" >status :</label>
						<label><input name="status" type="radio" class="form-control"value="0" required> 가능</label>
						<label><input name="status" type="radio" class="form-control"value="1" required > 불가능</label>
						</div>
					
					
					<div class="form-group row">
						<label for="textarea1">content :</label>
						
							<input name="content" id="textarea1" class="form-control" required
								 placeholder="내용을 입력하세요">
						</div>
					
				
                   
					<div class="form-group row">
						<div class="col-sm-2">Checkbox</div>
							<div class="form-check">
								<input class="form-check-input" type="checkbox" id="gridCheck1" required>
								<label class="form-check-label" for="gridCheck1"> Check
									it if you're done </label>
							
					
							<button type="submit" class="btn btn-primary">Register</button>
						</form>
					
				</div>
						</div>
						</div>
		

</body>
</html>