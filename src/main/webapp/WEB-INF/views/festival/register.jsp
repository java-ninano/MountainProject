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
			<div class="col-12 col-sm-6 offset-sm-3">
				<h1>Board Register</h1>
			</div>
		</div>
		
		<div class="row">
			<div class="col-12 col-sm-6 offset-sm-3">
			<form action="${root}/festival/register"  method="post" name="register">
                 
                 <div class="form-group">
               <label for="input1">산 이름 </label>
               <select name="ename" class="custom-select my-1 mr-sm-2 bd-highlight" id="input1" required/><br/>
                            <option>북한산</option>
							<option>도봉산</option>
							<option>수락산</option>
							<option>인왕산</option>
							<option>아차산</option>
							<option>관악산</option>
                 </select>
                 </div>
                 
                 <div class="form-group">
						<label for="input2">설명</label><textarea class="form-control" name="description" id="input2"
						rows="6" required placeholder="설명을 작성하세요"></textarea>
					</div>
                 
                 <div class="form-group">
               <label for=input3>축제가 있는 달</label>
               <select name="month" class="custom-select my-1 mr-sm-2 bd-highlight" id="input1" required/><br/>
                            <option>1</option>
							<option>2</option>
							<option>3</option>
							<option>4</option>
							<option>5</option>
							<option>6</option>
							<option>7</option>
							<option>8</option>
							<option>9</option>
							<option>10</option>
							<option>11</option>
							<option>12</option>
                 </select>
                  </div>
                    <!-- 산 번호를 어찌 읽어 오지?.... --> 
        <div class="form-group">
               <label>산 번호 </label>
               <input type="number" name="mountain_no"  placeholder="산 축제가 있는 산 번호를 입력하세요"  required/> <br/>
                  </div>
                 
                   <p>
                 <a href="/mountain/festival/list">게시물 목록</a> <br/>
                 <!-- <a href="/mountain/festival/register">게시물 작성</a> -->
                 </p>
                 
                 
                 	<button type="submit" class="btn btn-primary">Submit</button>
                 	  </form>
                 </div>
		</div>
	</div>

</body>
</html>	
                 	
                 	
                 	
                 	
                    
				
				
			
			